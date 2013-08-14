package com.phanative.module.security.service

import analyze._
import javax.inject.Inject
import javax.persistence.criteria._
import com.phanative.module.security.model.RecognizedAction
import scala.collection.JavaConversions._
import org.joda.time.LocalDate
import javax.enterprise.context.ApplicationScoped
import java.util.{ArrayList, List}
import java.lang.Integer
import javax.persistence.{NoResultException, EntityManager}

@ApplicationScoped
class ActionAnalyzer {

  @Inject
  var entityManager: EntityManager = _

  def getCountTillDate(date: LocalDate, resource : String, action: String) : Long = {
    val builder: CriteriaBuilder = entityManager.getCriteriaBuilder
    val query = builder.createQuery(classOf[AnalyzeType])
    val queryRoot: Root[RecognizedAction] = query.from(classOf[RecognizedAction])
    query.select(
      builder.construct(
        classOf[AnalyzeType],
        builder.count(queryRoot.get("id"))
      )
    )
    query.groupBy(queryRoot.get("resource"), queryRoot.get("action"))
    query.where(Seq(builder.lessThan(queryRoot.get("occurDate"),date),
                    builder.equal(queryRoot.get("resource"), resource),
                    builder.equal(queryRoot.get("action"), action)) : _*)
    try {
      val analyzeType = entityManager.createQuery(query).getSingleResult
      analyzeType.getValue
    }
    catch {
      case e: NoResultException => {
        0
      }
    }
  }

  def getResults(analyzeCriteria: AnalyzeCriteria) : List[AnalyzeType] = {
    val builder: CriteriaBuilder = entityManager.getCriteriaBuilder
    val query = builder.createTupleQuery()

    analyzeCriteria.checkForPrecision()

    val queryRoot: Root[RecognizedAction] = query.from(classOf[RecognizedAction])
    val yearSelection = builder.function("YEAR",classOf[Integer], queryRoot.get("occurDate"))
    val monthSelection = builder.function("MONTH",classOf[Integer], queryRoot.get("occurDate"))
    val daySelection = builder.function("DAY",classOf[Integer], queryRoot.get("occurDate"))

    analyzeCriteria.datePrecision match {
      case DatePrecision.DAYS_OF_MONTH => {
        query.select(
          builder.tuple (
            builder.count(queryRoot.get("id")),
            yearSelection,
            monthSelection,
            daySelection
          )
        )
        query.groupBy(daySelection, queryRoot.get("occurDate"), queryRoot.get("resource"), queryRoot.get("action"))
      }
      case DatePrecision.MONTHS_OF_YEAR => {
        query.select(
          builder.tuple(builder.count(queryRoot.get("occurDate")), monthSelection, yearSelection)
        )
        query.groupBy(monthSelection, queryRoot.get("occurDate"), queryRoot.get("resource"), queryRoot.get("action"))
      }
    }


    val predicates : ArrayList[Predicate] = new ArrayList[Predicate]()
    
    analyzeCriteria.datePrecision match {
      case DatePrecision.DAYS_OF_MONTH => {
        val localDate = new LocalDate(analyzeCriteria.year, analyzeCriteria.month, 1)
        val tillLocalDate = localDate.plusMonths(1)
        predicates.add(builder.greaterThanOrEqualTo(queryRoot.get("occurDate"),localDate))
        predicates.add(builder.lessThan(queryRoot.get("occurDate"),tillLocalDate))
      }
      case DatePrecision.MONTHS_OF_YEAR => {

      }
    }

    predicates.add(builder.equal(queryRoot.get("resource"), analyzeCriteria.resource))
    predicates.add(builder.equal(queryRoot.get("action"), analyzeCriteria.action))

    query.having(predicates: _*)

    val list = entityManager.createQuery(query).getResultList
    val analyzeTypeList = new ArrayList[AnalyzeType]()

    analyzeCriteria.datePrecision match {
      case DatePrecision.DAYS_OF_MONTH => {
        var localDate = new LocalDate(analyzeCriteria.year, analyzeCriteria.month, 1)
        val tillLocalDate = localDate.plusMonths(1)
        var countTill = getCountTillDate(localDate, analyzeCriteria.resource, analyzeCriteria.action)
        while(!localDate.isEqual(tillLocalDate)) {
          if(!list.exists((tuple) => tuple.get (3) == localDate.dayOfMonth().get())) {
            val analyzeType = new AnalyzeType(countTill, localDate.year().get(), localDate.monthOfYear().get(), localDate.dayOfMonth().get())
            analyzeTypeList.add(analyzeType)
          }
          else {
            val foundAnalyzeType = list.find(tuple => tuple.get(3) == localDate.dayOfMonth().get()).get
            val newAnalyzeType = new AnalyzeType(foundAnalyzeType.get(0).asInstanceOf[Long]+countTill,
              foundAnalyzeType.get(1).asInstanceOf[Int],
              foundAnalyzeType.get(2).asInstanceOf[Int],
              foundAnalyzeType.get(3).asInstanceOf[Int])
            list.remove(foundAnalyzeType)
            analyzeTypeList.add(newAnalyzeType)
            countTill = countTill + foundAnalyzeType.get(0).asInstanceOf[Long]
          }
          localDate = localDate.plusDays(1)
        }
      }
      case DatePrecision.MONTHS_OF_YEAR => {
        var localDate = new LocalDate(analyzeCriteria.year, 1, 1)
        val tillLocalDate = localDate.plusYears(1)
        var countTill = getCountTillDate(localDate, analyzeCriteria.resource, analyzeCriteria.action)
        while(!localDate.isEqual(tillLocalDate)) {
          if(!list.exists((tuple) => tuple.get(1) == localDate.monthOfYear().get())) {
            val analyzeType = new AnalyzeType(countTill, localDate.year().get(), localDate.monthOfYear().get())
            analyzeTypeList.add(analyzeType)
          }
          else {
            val foundAnalyzeType = list.find(tuple => tuple.get (1) == localDate.monthOfYear().get()).get
            val foundSum = list.foldLeft(0l)((sum, tuple) => if(tuple.get(1) == localDate.monthOfYear().get()) sum+tuple.get(0).asInstanceOf[Long] else sum+0)
            val newAnalyzeType = new AnalyzeType(foundSum+countTill, foundAnalyzeType.get(2).asInstanceOf[Int], foundAnalyzeType.get(1).asInstanceOf[Int])
            analyzeTypeList.add(newAnalyzeType)
            countTill = countTill + foundSum
          }
          localDate = localDate.plusMonths(1)
        }
      }
    }

    analyzeTypeList.sortWith((at1,at2) => at1.compareTo(at2) > 0)
  }

}
