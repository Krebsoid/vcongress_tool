package com.phanative.module.persistence.service.criteria

import com.phanative.module.persistence.service.EntityCriteria
import com.phanative.module.persistence.service.collection.{PagedArrayList, PagedCollection}
import org.apache.commons.lang.StringUtils
import org.codehaus.jackson.`type`.TypeReference
import org.codehaus.jackson.map.ObjectMapper
import javax.enterprise.context.Dependent
import scala.collection.JavaConversions._
import org.jboss.solder.beanManager.BeanManagerAware
import javax.inject.Inject
import javax.persistence.criteria._
import java.util.{Date, ArrayList}
import javax.persistence.{TypedQuery, EntityManager}
import java.lang.Integer

@Dependent
class ExtJsCriteriaService[ENTITY <: AnyRef] extends BeanManagerAware {


  var mapper: ObjectMapper = new ObjectMapper

  @Inject
  var entityManager: EntityManager = _

  def findEntities(entityCriteria: EntityCriteria, queryClass: Class[ENTITY]): PagedCollection[ENTITY] = {
    val builder: CriteriaBuilder = entityManager.getCriteriaBuilder
    val query: CriteriaQuery[ENTITY] = builder.createQuery(queryClass)

    val queryRoot: Root[ENTITY] = query.from(queryClass)
    query.select(queryRoot)

    if(entityCriteria.filtered) {
      val predicates : ArrayList[Predicate] = new ArrayList[Predicate]()

      for (filter: FilterType <- entityCriteria.filters) {
        filter match {
          case x: FilterType => x.dataType match {
            case "list" => {
              val listItemId : Path[Long]= queryRoot.get(filter.field);
              var predicate = builder.in(listItemId);
              for (id <- x.value.asInstanceOf[ArrayList[Int]]) {
                predicate = predicate.value(id)
              }
              predicates.add(predicate)
            }
            case "string" => {
              predicates.add(builder.like(builder.lower(queryRoot.get[String](x.field)), "%"+StringUtils.lowerCase(x.value.asInstanceOf[String])+"%"))
            }
            case "numeric" => {
              x.comparison match {
                case "lt" => {
                  predicates.add(builder.lessThan[Integer](queryRoot.get(x.field), x.value.asInstanceOf[Integer]))
                }
                case "gt" => {
                  predicates.add(builder.greaterThan[Integer](queryRoot.get(x.field), x.value.asInstanceOf[Integer]))
                }
                case "eq" => {
                  predicates.add(builder.equal(queryRoot.get(x.field), x.value.asInstanceOf[Integer]))
                }
              }
            }
            case "date" => {
              x.comparison match {
                case "lt" => {
                  predicates.add(builder.lessThan[Date](queryRoot.get(x.field),new Date(x.value.asInstanceOf[String])))
                }
                case "gt" => {
                  predicates.add(builder.greaterThan[Date](queryRoot.get(x.field),new Date(x.value.asInstanceOf[String])))
                }
                case "eq" => {
                  predicates.add(builder.equal(queryRoot.get(x.field),new Date(x.value.asInstanceOf[String])))
                }
              }
            }
            case "boolean" => {
              x.value match {
                case true => {
                  predicates.add(builder.isTrue(queryRoot.get(x.field)))
                }
                case false => {
                  predicates.add(builder.isFalse(queryRoot.get(x.field)))
                }
              }
            }
            case _ => Nil
          }
          case _ => Nil
        }
      }
      query.where(predicates: _*)
    }

    if (entityCriteria.sorted) {
      for (sorter <- entityCriteria.sortByName) {
        sorter match {
          case x: SortType =>  x.direction match {
            case "ASC" => {
              query.orderBy(builder.asc(queryRoot.get(x.property)))
            }
            case "DESC" => {
              query.orderBy(builder.desc(queryRoot.get(x.property)))
            }
          }
        }
      }
    }

    val typedQuery: TypedQuery[ENTITY] = entityManager.createQuery(query)
    val pagedArrayList: PagedArrayList[ENTITY] = new PagedArrayList[ENTITY]

    if (entityCriteria.paged) {
      pagedArrayList.total = typedQuery.getResultList.size()
      typedQuery.setFirstResult(entityCriteria.firstResult)
      typedQuery.setMaxResults(entityCriteria.maxResults)
    }

    pagedArrayList.addAll(typedQuery.getResultList)
    pagedArrayList
  }


  def createEntityCriteria(filter: String, group: String, sort: String) : EntityCriteria = {
    val entityCriteria = new EntityCriteria

    if (StringUtils.isNotEmpty(sort)) {
      val typeReference = new TypeReference[java.util.List[SortType]] {}
      val sortType = mapper.readValue[java.util.List[SortType]](sort, typeReference)
      entityCriteria.sorted = true
      entityCriteria.sortByName = sortType
    }

    if (StringUtils.isNotEmpty(filter)) {
      val typeReference = new TypeReference[java.util.List[FilterType]] {}
      val filtersType = mapper.readValue[java.util.List[FilterType]](filter, typeReference)
      entityCriteria.filtered = true
      entityCriteria.filters = filtersType
    }

    if (StringUtils.isNotEmpty(group)) {
      val typeReference = new TypeReference[java.util.List[GroupType]] {}
      val groupType = mapper.readValue[java.util.List[GroupType]](group, typeReference)
      entityCriteria.grouped = true
      entityCriteria.group = groupType
    }

    entityCriteria
  }

  def createEntityCriteria(filter: String, group: String, sort: String, start: Int, limit: Int) : EntityCriteria = {
    val entityCriteria: EntityCriteria = createEntityCriteria(filter, group, sort)

    entityCriteria.firstResult = start
    entityCriteria.maxResults = limit
    entityCriteria.paged = true

    entityCriteria
  }
}

