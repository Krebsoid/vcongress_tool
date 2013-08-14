package com.phanative.startup.data

import com.phanative.module.security.model.EnabledAttribute
import org.picketlink.idm.api._
import javax.inject.Inject
import java.lang._
import org.jboss.seam.transaction.Transactional
import javax.enterprise.context.ApplicationScoped
import javax.persistence.EntityManager
import com.phanative.model.core.person.Country
import java.util

@ApplicationScoped
class Data003Country @Inject()(entityManager : EntityManager) extends Data {

  def this() = this(null)

  var countryList: util.HashMap[String, Country] = new util.HashMap[String,Country]()

  @Transactional
  def initialize() {

    val country1 = new Country
    country1.isoCode = "AF"
    country1.name
      .add(util.Locale.UK, "Afghanistan")
      .add(util.Locale.GERMANY, "Afghanistan")
    entityManager.persist(country1)
    countryList.put(country1.isoCode, country1)

    val country2 = new Country
    country2.isoCode = "AX"
    country2.name
      .add(util.Locale.UK, "Åland Islands")
      .add(util.Locale.GERMANY, "Åland Islands")
    entityManager.persist(country2)
    countryList.put(country2.isoCode, country2)

    val country3 = new Country
    country3.isoCode = "AL"
    country3.name
      .add(util.Locale.UK, "Albania")
      .add(util.Locale.GERMANY, "Albania")
    entityManager.persist(country3)
    countryList.put(country3.isoCode, country3)

    val country4 = new Country
    country4.isoCode = "DZ"
    country4.name
      .add(util.Locale.UK, "Algeria")
      .add(util.Locale.GERMANY, "Algeria")
    entityManager.persist(country4)
    countryList.put(country4.isoCode, country4)

    val country5 = new Country
    country5.isoCode = "AS"
    country5.name
      .add(util.Locale.UK, "American Samoa")
      .add(util.Locale.GERMANY, "American Samoa")
    entityManager.persist(country5)
    countryList.put(country5.isoCode, country5)

    val country6 = new Country
    country6.isoCode = "AD"
    country6.name
      .add(util.Locale.UK, "Andorra")
      .add(util.Locale.GERMANY, "Andorra")
    entityManager.persist(country6)
    countryList.put(country6.isoCode, country6)

    val country7 = new Country
    country7.isoCode = "AO"
    country7.name
      .add(util.Locale.UK, "Angola")
      .add(util.Locale.GERMANY, "Angola")
    entityManager.persist(country7)
    countryList.put(country7.isoCode, country7)

    val country8 = new Country
    country8.isoCode = "AI"
    country8.name
      .add(util.Locale.UK, "Anguilla")
      .add(util.Locale.GERMANY, "Anguilla")
    entityManager.persist(country8)
    countryList.put(country8.isoCode, country8)

    val country9 = new Country
    country9.isoCode = "AQ"
    country9.name
      .add(util.Locale.UK, "Antarctica")
      .add(util.Locale.GERMANY, "Antarctica")
    entityManager.persist(country9)
    countryList.put(country9.isoCode, country9)

    val country10 = new Country
    country10.isoCode = "AG"
    country10.name
      .add(util.Locale.UK, "Antigua and Barbuda")
      .add(util.Locale.GERMANY, "Antigua and Barbuda")
    entityManager.persist(country10)
    countryList.put(country10.isoCode, country10)

    val country11 = new Country
    country11.isoCode = "AR"
    country11.name
      .add(util.Locale.UK, "Argentina")
      .add(util.Locale.GERMANY, "Argentina")
    entityManager.persist(country11)
    countryList.put(country11.isoCode, country11)

    val country12 = new Country
    country12.isoCode = "AM"
    country12.name
      .add(util.Locale.UK, "Armenia")
      .add(util.Locale.GERMANY, "Armenia")
    entityManager.persist(country12)
    countryList.put(country12.isoCode, country12)

    val country13 = new Country
    country13.isoCode = "AW"
    country13.name
      .add(util.Locale.UK, "Aruba")
      .add(util.Locale.GERMANY, "Aruba")
    entityManager.persist(country13)
    countryList.put(country13.isoCode, country13)

    val country14 = new Country
    country14.isoCode = "AU"
    country14.name
      .add(util.Locale.UK, "Australia")
      .add(util.Locale.GERMANY, "Australia")
    entityManager.persist(country14)
    countryList.put(country14.isoCode, country14)

    val country15 = new Country
    country15.isoCode = "AT"
    country15.name
      .add(util.Locale.UK, "Austria")
      .add(util.Locale.GERMANY, "Austria")
    entityManager.persist(country15)
    countryList.put(country15.isoCode, country15)

    val country16 = new Country
    country16.isoCode = "AZ"
    country16.name
      .add(util.Locale.UK, "Azerbaijan")
      .add(util.Locale.GERMANY, "Azerbaijan")
    entityManager.persist(country16)
    countryList.put(country16.isoCode, country16)

    val country17 = new Country
    country17.isoCode = "BS"
    country17.name
      .add(util.Locale.UK, "Bahamas")
      .add(util.Locale.GERMANY, "Bahamas")
    entityManager.persist(country17)
    countryList.put(country17.isoCode, country17)

    val country18 = new Country
    country18.isoCode = "BH"
    country18.name
      .add(util.Locale.UK, "Bahrain")
      .add(util.Locale.GERMANY, "Bahrain")
    entityManager.persist(country18)
    countryList.put(country18.isoCode, country18)

    val country19 = new Country
    country19.isoCode = "BD"
    country19.name
      .add(util.Locale.UK, "Bangladesh")
      .add(util.Locale.GERMANY, "Bangladesh")
    entityManager.persist(country19)
    countryList.put(country19.isoCode, country19)

    val country20 = new Country
    country20.isoCode = "BB"
    country20.name
      .add(util.Locale.UK, "Barbados")
      .add(util.Locale.GERMANY, "Barbados")
    entityManager.persist(country20)
    countryList.put(country20.isoCode, country20)

    val country21 = new Country
    country21.isoCode = "BY"
    country21.name
      .add(util.Locale.UK, "Belarus")
      .add(util.Locale.GERMANY, "Belarus")
    entityManager.persist(country21)
    countryList.put(country21.isoCode, country21)

    val country22 = new Country
    country22.isoCode = "BE"
    country22.name
      .add(util.Locale.UK, "Belgium")
      .add(util.Locale.GERMANY, "Belgium")
    entityManager.persist(country22)
    countryList.put(country22.isoCode, country22)

    val country23 = new Country
    country23.isoCode = "BZ"
    country23.name
      .add(util.Locale.UK, "Belize")
      .add(util.Locale.GERMANY, "Belize")
    entityManager.persist(country23)
    countryList.put(country23.isoCode, country23)

    val country24 = new Country
    country24.isoCode = "BJ"
    country24.name
      .add(util.Locale.UK, "Benin")
      .add(util.Locale.GERMANY, "Benin")
    entityManager.persist(country24)
    countryList.put(country24.isoCode, country24)

    val country25 = new Country
    country25.isoCode = "BM"
    country25.name
      .add(util.Locale.UK, "Bermuda")
      .add(util.Locale.GERMANY, "Bermuda")
    entityManager.persist(country25)
    countryList.put(country25.isoCode, country25)

    val country26 = new Country
    country26.isoCode = "BT"
    country26.name
      .add(util.Locale.UK, "Bhutan")
      .add(util.Locale.GERMANY, "Bhutan")
    entityManager.persist(country26)
    countryList.put(country26.isoCode, country26)

    val country27 = new Country
    country27.isoCode = "BO"
    country27.name
      .add(util.Locale.UK, "Bolivia")
      .add(util.Locale.GERMANY, "Bolivia")
    entityManager.persist(country27)
    countryList.put(country27.isoCode, country27)

    val country28 = new Country
    country28.isoCode = "BA"
    country28.name
      .add(util.Locale.UK, "Bosnia and Herzegovina")
      .add(util.Locale.GERMANY, "Bosnia and Herzegovina")
    entityManager.persist(country28)
    countryList.put(country28.isoCode, country28)

    val country29 = new Country
    country29.isoCode = "BW"
    country29.name
      .add(util.Locale.UK, "Botswana")
      .add(util.Locale.GERMANY, "Botswana")
    entityManager.persist(country29)
    countryList.put(country29.isoCode, country29)

    val country30 = new Country
    country30.isoCode = "BV"
    country30.name
      .add(util.Locale.UK, "Bouvet Island")
      .add(util.Locale.GERMANY, "Bouvet Island")
    entityManager.persist(country30)
    countryList.put(country30.isoCode, country30)

    val country31 = new Country
    country31.isoCode = "BR"
    country31.name
      .add(util.Locale.UK, "Brazil")
      .add(util.Locale.GERMANY, "Brazil")
    entityManager.persist(country31)
    countryList.put(country31.isoCode, country31)

    val country32 = new Country
    country32.isoCode = "IO"
    country32.name
      .add(util.Locale.UK, "British Indian Ocean Territory")
      .add(util.Locale.GERMANY, "British Indian Ocean Territory")
    entityManager.persist(country32)
    countryList.put(country32.isoCode, country32)

    val country33 = new Country
    country33.isoCode = "BN"
    country33.name
      .add(util.Locale.UK, "Brunei Darussalam")
      .add(util.Locale.GERMANY, "Brunei Darussalam")
    entityManager.persist(country33)
    countryList.put(country33.isoCode, country33)

    val country34 = new Country
    country34.isoCode = "BG"
    country34.name
      .add(util.Locale.UK, "Bulgaria")
      .add(util.Locale.GERMANY, "Bulgaria")
    entityManager.persist(country34)
    countryList.put(country34.isoCode, country34)

    val country35 = new Country
    country35.isoCode = "BF"
    country35.name
      .add(util.Locale.UK, "Burkina Faso")
      .add(util.Locale.GERMANY, "Burkina Faso")
    entityManager.persist(country35)
    countryList.put(country35.isoCode, country35)

    val country36 = new Country
    country36.isoCode = "BI"
    country36.name
      .add(util.Locale.UK, "Burundi")
      .add(util.Locale.GERMANY, "Burundi")
    entityManager.persist(country36)
    countryList.put(country36.isoCode, country36)

    val country37 = new Country
    country37.isoCode = "KH"
    country37.name
      .add(util.Locale.UK, "Cambodia")
      .add(util.Locale.GERMANY, "Cambodia")
    entityManager.persist(country37)
    countryList.put(country37.isoCode, country37)

    val country38 = new Country
    country38.isoCode = "CM"
    country38.name
      .add(util.Locale.UK, "Cameroon")
      .add(util.Locale.GERMANY, "Cameroon")
    entityManager.persist(country38)
    countryList.put(country38.isoCode, country38)

    val country39 = new Country
    country39.isoCode = "CA"
    country39.name
      .add(util.Locale.UK, "Canada")
      .add(util.Locale.GERMANY, "Canada")
    entityManager.persist(country39)
    countryList.put(country39.isoCode, country39)

    val country40 = new Country
    country40.isoCode = "CV"
    country40.name
      .add(util.Locale.UK, "Cape Verde")
      .add(util.Locale.GERMANY, "Cape Verde")
    entityManager.persist(country40)
    countryList.put(country40.isoCode, country40)

    val country41 = new Country
    country41.isoCode = "KY"
    country41.name
      .add(util.Locale.UK, "Cayman Islands")
      .add(util.Locale.GERMANY, "Cayman Islands")
    entityManager.persist(country41)
    countryList.put(country41.isoCode, country41)

    val country42 = new Country
    country42.isoCode = "CF"
    country42.name
      .add(util.Locale.UK, "Central African Republic")
      .add(util.Locale.GERMANY, "Central African Republic")
    entityManager.persist(country42)
    countryList.put(country42.isoCode, country42)

    val country43 = new Country
    country43.isoCode = "TD"
    country43.name
      .add(util.Locale.UK, "Chad")
      .add(util.Locale.GERMANY, "Chad")
    entityManager.persist(country43)
    countryList.put(country43.isoCode, country43)

    val country44 = new Country
    country44.isoCode = "CL"
    country44.name
      .add(util.Locale.UK, "Chile")
      .add(util.Locale.GERMANY, "Chile")
    entityManager.persist(country44)
    countryList.put(country44.isoCode, country44)

    val country45 = new Country
    country45.isoCode = "CN"
    country45.name
      .add(util.Locale.UK, "China")
      .add(util.Locale.GERMANY, "China")
    entityManager.persist(country45)
    countryList.put(country45.isoCode, country45)

    val country46 = new Country
    country46.isoCode = "CX"
    country46.name
      .add(util.Locale.UK, "Christmas Island")
      .add(util.Locale.GERMANY, "Christmas Island")
    entityManager.persist(country46)
    countryList.put(country46.isoCode, country46)

    val country47 = new Country
    country47.isoCode = "CC"
    country47.name
      .add(util.Locale.UK, "Cocos (Keeling) Islands")
      .add(util.Locale.GERMANY, "Cocos (Keeling) Islands")
    entityManager.persist(country47)
    countryList.put(country47.isoCode, country47)

    val country48 = new Country
    country48.isoCode = "CO"
    country48.name
      .add(util.Locale.UK, "Colombia")
      .add(util.Locale.GERMANY, "Colombia")
    entityManager.persist(country48)
    countryList.put(country48.isoCode, country48)

    val country49 = new Country
    country49.isoCode = "KM"
    country49.name
      .add(util.Locale.UK, "Comoros")
      .add(util.Locale.GERMANY, "Comoros")
    entityManager.persist(country49)
    countryList.put(country49.isoCode, country49)

    val country50 = new Country
    country50.isoCode = "CG"
    country50.name
      .add(util.Locale.UK, "Congo")
      .add(util.Locale.GERMANY, "Congo")
    entityManager.persist(country50)
    countryList.put(country50.isoCode, country50)

    val country51 = new Country
    country51.isoCode = "CD"
    country51.name
      .add(util.Locale.UK, "Congo, The Democratic Republic of the")
      .add(util.Locale.GERMANY, "Congo, The Democratic Republic of the")
    entityManager.persist(country51)
    countryList.put(country51.isoCode, country51)

    val country52 = new Country
    country52.isoCode = "CK"
    country52.name
      .add(util.Locale.UK, "Cook Islands")
      .add(util.Locale.GERMANY, "Cook Islands")
    entityManager.persist(country52)
    countryList.put(country52.isoCode, country52)

    val country53 = new Country
    country53.isoCode = "CR"
    country53.name
      .add(util.Locale.UK, "Costa Rica")
      .add(util.Locale.GERMANY, "Costa Rica")
    entityManager.persist(country53)
    countryList.put(country53.isoCode, country53)

    val country54 = new Country
    country54.isoCode = "CI"
    country54.name
      .add(util.Locale.UK, "Cote D'Ivoire")
      .add(util.Locale.GERMANY, "Cote D'Ivoire")
    entityManager.persist(country54)
    countryList.put(country54.isoCode, country54)

    val country55 = new Country
    country55.isoCode = "HR"
    country55.name
      .add(util.Locale.UK, "Croatia")
      .add(util.Locale.GERMANY, "Croatia")
    entityManager.persist(country55)
    countryList.put(country55.isoCode, country55)

    val country56 = new Country
    country56.isoCode = "CU"
    country56.name
      .add(util.Locale.UK, "Cuba")
      .add(util.Locale.GERMANY, "Cuba")
    entityManager.persist(country56)
    countryList.put(country56.isoCode, country56)

    val country57 = new Country
    country57.isoCode = "CY"
    country57.name
      .add(util.Locale.UK, "Cyprus")
      .add(util.Locale.GERMANY, "Cyprus")
    entityManager.persist(country57)
    countryList.put(country57.isoCode, country57)

    val country58 = new Country
    country58.isoCode = "CZ"
    country58.name
      .add(util.Locale.UK, "Czech Republic")
      .add(util.Locale.GERMANY, "Czech Republic")
    entityManager.persist(country58)
    countryList.put(country58.isoCode, country58)

    val country59 = new Country
    country59.isoCode = "DK"
    country59.name
      .add(util.Locale.UK, "Denmark")
      .add(util.Locale.GERMANY, "Denmark")
    entityManager.persist(country59)
    countryList.put(country59.isoCode, country59)

    val country60 = new Country
    country60.isoCode = "DJ"
    country60.name
      .add(util.Locale.UK, "Djibouti")
      .add(util.Locale.GERMANY, "Djibouti")
    entityManager.persist(country60)
    countryList.put(country60.isoCode, country60)

    val country61 = new Country
    country61.isoCode = "DM"
    country61.name
      .add(util.Locale.UK, "Dominica")
      .add(util.Locale.GERMANY, "Dominica")
    entityManager.persist(country61)
    countryList.put(country61.isoCode, country61)

    val country62 = new Country
    country62.isoCode = "DO"
    country62.name
      .add(util.Locale.UK, "Dominican Republic")
      .add(util.Locale.GERMANY, "Dominican Republic")
    entityManager.persist(country62)
    countryList.put(country62.isoCode, country62)

    val country63 = new Country
    country63.isoCode = "EC"
    country63.name
      .add(util.Locale.UK, "Ecuador")
      .add(util.Locale.GERMANY, "Ecuador")
    entityManager.persist(country63)
    countryList.put(country63.isoCode, country63)

    val country64 = new Country
    country64.isoCode = "EG"
    country64.name
      .add(util.Locale.UK, "Egypt")
      .add(util.Locale.GERMANY, "Egypt")
    entityManager.persist(country64)
    countryList.put(country64.isoCode, country64)

    val country65 = new Country
    country65.isoCode = "SV"
    country65.name
      .add(util.Locale.UK, "El Salvador")
      .add(util.Locale.GERMANY, "El Salvador")
    entityManager.persist(country65)
    countryList.put(country65.isoCode, country65)

    val country66 = new Country
    country66.isoCode = "GQ"
    country66.name
      .add(util.Locale.UK, "Equatorial Guinea")
      .add(util.Locale.GERMANY, "Equatorial Guinea")
    entityManager.persist(country66)
    countryList.put(country66.isoCode, country66)

    val country67 = new Country
    country67.isoCode = "ER"
    country67.name
      .add(util.Locale.UK, "Eritrea")
      .add(util.Locale.GERMANY, "Eritrea")
    entityManager.persist(country67)
    countryList.put(country67.isoCode, country67)

    val country68 = new Country
    country68.isoCode = "EE"
    country68.name
      .add(util.Locale.UK, "Estonia")
      .add(util.Locale.GERMANY, "Estonia")
    entityManager.persist(country68)
    countryList.put(country68.isoCode, country68)

    val country69 = new Country
    country69.isoCode = "ET"
    country69.name
      .add(util.Locale.UK, "Ethiopia")
      .add(util.Locale.GERMANY, "Ethiopia")
    entityManager.persist(country69)
    countryList.put(country69.isoCode, country69)

    val country70 = new Country
    country70.isoCode = "FK"
    country70.name
      .add(util.Locale.UK, "Falkland Islands (Malvinas)")
      .add(util.Locale.GERMANY, "Falkland Islands (Malvinas)")
    entityManager.persist(country70)
    countryList.put(country70.isoCode, country70)

    val country71 = new Country
    country71.isoCode = "FO"
    country71.name
      .add(util.Locale.UK, "Faroe Islands")
      .add(util.Locale.GERMANY, "Faroe Islands")
    entityManager.persist(country71)
    countryList.put(country71.isoCode, country71)

    val country72 = new Country
    country72.isoCode = "FJ"
    country72.name
      .add(util.Locale.UK, "Fiji")
      .add(util.Locale.GERMANY, "Fiji")
    entityManager.persist(country72)
    countryList.put(country72.isoCode, country72)

    val country73 = new Country
    country73.isoCode = "FI"
    country73.name
      .add(util.Locale.UK, "Finland")
      .add(util.Locale.GERMANY, "Finland")
    entityManager.persist(country73)
    countryList.put(country73.isoCode, country73)

    val country74 = new Country
    country74.isoCode = "FR"
    country74.name
      .add(util.Locale.UK, "France")
      .add(util.Locale.GERMANY, "France")
    entityManager.persist(country74)
    countryList.put(country74.isoCode, country74)

    val country75 = new Country
    country75.isoCode = "GF"
    country75.name
      .add(util.Locale.UK, "French Guiana")
      .add(util.Locale.GERMANY, "French Guiana")
    entityManager.persist(country75)
    countryList.put(country75.isoCode, country75)

    val country76 = new Country
    country76.isoCode = "PF"
    country76.name
      .add(util.Locale.UK, "French Polynesia")
      .add(util.Locale.GERMANY, "French Polynesia")
    entityManager.persist(country76)
    countryList.put(country76.isoCode, country76)

    val country77 = new Country
    country77.isoCode = "TF"
    country77.name
      .add(util.Locale.UK, "French Southern Territories")
      .add(util.Locale.GERMANY, "French Southern Territories")
    entityManager.persist(country77)
    countryList.put(country77.isoCode, country77)

    val country78 = new Country
    country78.isoCode = "GA"
    country78.name
      .add(util.Locale.UK, "Gabon")
      .add(util.Locale.GERMANY, "Gabon")
    entityManager.persist(country78)
    countryList.put(country78.isoCode, country78)

    val country79 = new Country
    country79.isoCode = "GM"
    country79.name
      .add(util.Locale.UK, "Gambia")
      .add(util.Locale.GERMANY, "Gambia")
    entityManager.persist(country79)
    countryList.put(country79.isoCode, country79)

    val country80 = new Country
    country80.isoCode = "GE"
    country80.name
      .add(util.Locale.UK, "Georgia")
      .add(util.Locale.GERMANY, "Georgien")
    entityManager.persist(country80)
    countryList.put(country80.isoCode, country80)

    val country81 = new Country
    country81.isoCode = "DE"
    country81.name
      .add(util.Locale.UK, "Germany")
      .add(util.Locale.GERMANY, "Deutschland")
    entityManager.persist(country81)
    countryList.put(country81.isoCode, country81)

    val country82 = new Country
    country82.isoCode = "GH"
    country82.name
      .add(util.Locale.UK, "Ghana")
      .add(util.Locale.GERMANY, "Ghana")
    entityManager.persist(country82)
    countryList.put(country82.isoCode, country82)

    val country83 = new Country
    country83.isoCode = "GI"
    country83.name
      .add(util.Locale.UK, "Gibraltar")
      .add(util.Locale.GERMANY, "Gibraltar")
    entityManager.persist(country83)
    countryList.put(country83.isoCode, country83)

    val country84 = new Country
    country84.isoCode = "GR"
    country84.name
      .add(util.Locale.UK, "Greece")
      .add(util.Locale.GERMANY, "Greece")
    entityManager.persist(country84)
    countryList.put(country84.isoCode, country84)

    val country85 = new Country
    country85.isoCode = "GL"
    country85.name
      .add(util.Locale.UK, "Greenland")
      .add(util.Locale.GERMANY, "Greenland")
    entityManager.persist(country85)
    countryList.put(country85.isoCode, country85)

    val country86 = new Country
    country86.isoCode = "GD"
    country86.name
      .add(util.Locale.UK, "Grenada")
      .add(util.Locale.GERMANY, "Grenada")
    entityManager.persist(country86)
    countryList.put(country86.isoCode, country86)

    val country87 = new Country
    country87.isoCode = "GP"
    country87.name
      .add(util.Locale.UK, "Guadeloupe")
      .add(util.Locale.GERMANY, "Guadeloupe")
    entityManager.persist(country87)
    countryList.put(country87.isoCode, country87)

    val country88 = new Country
    country88.isoCode = "GU"
    country88.name
      .add(util.Locale.UK, "Guam")
      .add(util.Locale.GERMANY, "Guam")
    entityManager.persist(country88)
    countryList.put(country88.isoCode, country88)

    val country89 = new Country
    country89.isoCode = "GT"
    country89.name
      .add(util.Locale.UK, "Guatemala")
      .add(util.Locale.GERMANY, "Guatemala")
    entityManager.persist(country89)
    countryList.put(country89.isoCode, country89)

    val country90 = new Country
    country90.isoCode = "GG"
    country90.name
      .add(util.Locale.UK, "Guernsey")
      .add(util.Locale.GERMANY, "Guernsey")
    entityManager.persist(country90)
    countryList.put(country90.isoCode, country90)

    val country91 = new Country
    country91.isoCode = "GN"
    country91.name
      .add(util.Locale.UK, "Guinea")
      .add(util.Locale.GERMANY, "Guinea")
    entityManager.persist(country91)
    countryList.put(country91.isoCode, country91)

    val country92 = new Country
    country92.isoCode = "GW"
    country92.name
      .add(util.Locale.UK, "Guinea-Bissau")
      .add(util.Locale.GERMANY, "Guinea-Bissau")
    entityManager.persist(country92)
    countryList.put(country92.isoCode, country92)

    val country93 = new Country
    country93.isoCode = "GY"
    country93.name
      .add(util.Locale.UK, "Guyana")
      .add(util.Locale.GERMANY, "Guyana")
    entityManager.persist(country93)
    countryList.put(country93.isoCode, country93)

    val country94 = new Country
    country94.isoCode = "HT"
    country94.name
      .add(util.Locale.UK, "Haiti")
      .add(util.Locale.GERMANY, "Haiti")
    entityManager.persist(country94)
    countryList.put(country94.isoCode, country94)

    val country95 = new Country
    country95.isoCode = "HM"
    country95.name
      .add(util.Locale.UK, "Heard Island and Mcdonald Islands")
      .add(util.Locale.GERMANY, "Heard Island and Mcdonald Islands")
    entityManager.persist(country95)
    countryList.put(country95.isoCode, country95)

    val country96 = new Country
    country96.isoCode = "VA"
    country96.name
      .add(util.Locale.UK, "Holy See (Vatican City State)")
      .add(util.Locale.GERMANY, "Holy See (Vatican City State)")
    entityManager.persist(country96)
    countryList.put(country96.isoCode, country96)

    val country97 = new Country
    country97.isoCode = "HN"
    country97.name
      .add(util.Locale.UK, "Honduras")
      .add(util.Locale.GERMANY, "Honduras")
    entityManager.persist(country97)
    countryList.put(country97.isoCode, country97)

    val country98 = new Country
    country98.isoCode = "HK"
    country98.name
      .add(util.Locale.UK, "Hong Kong")
      .add(util.Locale.GERMANY, "Hong Kong")
    entityManager.persist(country98)
    countryList.put(country98.isoCode, country98)

    val country99 = new Country
    country99.isoCode = "HU"
    country99.name
      .add(util.Locale.UK, "Hungary")
      .add(util.Locale.GERMANY, "Hungary")
    entityManager.persist(country99)
    countryList.put(country99.isoCode, country99)

    val country100 = new Country
    country100.isoCode = "IS"
    country100.name
      .add(util.Locale.UK, "Iceland")
      .add(util.Locale.GERMANY, "Iceland")
    entityManager.persist(country100)
    countryList.put(country100.isoCode, country100)

    val country101 = new Country
    country101.isoCode = "IN"
    country101.name
      .add(util.Locale.UK, "India")
      .add(util.Locale.GERMANY, "India")
    entityManager.persist(country101)
    countryList.put(country101.isoCode, country101)

    val country102 = new Country
    country102.isoCode = "ID"
    country102.name
      .add(util.Locale.UK, "Indonesia")
      .add(util.Locale.GERMANY, "Indonesia")
    entityManager.persist(country102)
    countryList.put(country102.isoCode, country102)

    val country103 = new Country
    country103.isoCode = "IR"
    country103.name
      .add(util.Locale.UK, "Iran, Islamic Republic Of")
      .add(util.Locale.GERMANY, "Iran, Islamic Republic Of")
    entityManager.persist(country103)
    countryList.put(country103.isoCode, country103)

    val country104 = new Country
    country104.isoCode = "IQ"
    country104.name
      .add(util.Locale.UK, "Iraq")
      .add(util.Locale.GERMANY, "Iraq")
    entityManager.persist(country104)
    countryList.put(country104.isoCode, country104)

    val country105 = new Country
    country105.isoCode = "IE"
    country105.name
      .add(util.Locale.UK, "Ireland")
      .add(util.Locale.GERMANY, "Ireland")
    entityManager.persist(country105)
    countryList.put(country105.isoCode, country105)

    val country106 = new Country
    country106.isoCode = "IM"
    country106.name
      .add(util.Locale.UK, "Isle of Man")
      .add(util.Locale.GERMANY, "Isle of Man")
    entityManager.persist(country106)
    countryList.put(country106.isoCode, country106)

    val country107 = new Country
    country107.isoCode = "IL"
    country107.name
      .add(util.Locale.UK, "Israel")
      .add(util.Locale.GERMANY, "Israel")
    entityManager.persist(country107)
    countryList.put(country107.isoCode, country107)

    val country108 = new Country
    country108.isoCode = "IT"
    country108.name
      .add(util.Locale.UK, "Italy")
      .add(util.Locale.GERMANY, "Italy")
    entityManager.persist(country108)
    countryList.put(country108.isoCode, country108)

    val country109 = new Country
    country109.isoCode = "JM"
    country109.name
      .add(util.Locale.UK, "Jamaica")
      .add(util.Locale.GERMANY, "Jamaica")
    entityManager.persist(country109)
    countryList.put(country109.isoCode, country109)

    val country110 = new Country
    country110.isoCode = "JP"
    country110.name
      .add(util.Locale.UK, "Japan")
      .add(util.Locale.GERMANY, "Japan")
    entityManager.persist(country110)
    countryList.put(country110.isoCode, country110)

    val country111 = new Country
    country111.isoCode = "JE"
    country111.name
      .add(util.Locale.UK, "Jersey")
      .add(util.Locale.GERMANY, "Jersey")
    entityManager.persist(country111)
    countryList.put(country11.isoCode, country111)

    val country112 = new Country
    country112.isoCode = "JO"
    country112.name
      .add(util.Locale.UK, "Jordan")
      .add(util.Locale.GERMANY, "Jordan")
    entityManager.persist(country112)
    countryList.put(country12.isoCode, country112)

    val country113 = new Country
    country113.isoCode = "KZ"
    country113.name
      .add(util.Locale.UK, "Kazakhstan")
      .add(util.Locale.GERMANY, "Kazakhstan")
    entityManager.persist(country113)
    countryList.put(country13.isoCode, country113)

    val country114 = new Country
    country114.isoCode = "KE"
    country114.name
      .add(util.Locale.UK, "Kenya")
      .add(util.Locale.GERMANY, "Kenya")
    entityManager.persist(country114)
    countryList.put(country114.isoCode, country114)

    val country115 = new Country
    country115.isoCode = "KI"
    country115.name
      .add(util.Locale.UK, "Kiribati")
      .add(util.Locale.GERMANY, "Kiribati")
    entityManager.persist(country115)
    countryList.put(country115.isoCode, country115)

    val country116 = new Country
    country116.isoCode = "KP"
    country116.name
      .add(util.Locale.UK, "Korea, Democratic People's Republic of")
      .add(util.Locale.GERMANY, "Korea, Democratic People's Republic of")
    entityManager.persist(country116)
    countryList.put(country116.isoCode, country116)

    val country117 = new Country
    country117.isoCode = "KR"
    country117.name
      .add(util.Locale.UK, "Korea, Republic of")
      .add(util.Locale.GERMANY, "Korea, Republic of")
    entityManager.persist(country117)
    countryList.put(country117.isoCode, country117)

    val country118 = new Country
    country118.isoCode = "KW"
    country118.name
      .add(util.Locale.UK, "Kuwait")
      .add(util.Locale.GERMANY, "Kuwait")
    entityManager.persist(country118)
    countryList.put(country18.isoCode, country118)

    val country119 = new Country
    country119.isoCode = "KG"
    country119.name
      .add(util.Locale.UK, "Kyrgyzstan")
      .add(util.Locale.GERMANY, "Kyrgyzstan")
    entityManager.persist(country119)
    countryList.put(country119.isoCode, country119)

    val country120 = new Country
    country120.isoCode = "LA"
    country120.name
      .add(util.Locale.UK, "Lao People's Democratic Republic")
      .add(util.Locale.GERMANY, "Lao People's Democratic Republic")
    entityManager.persist(country120)
    countryList.put(country120.isoCode, country120)

    val country121 = new Country
    country121.isoCode = "LV"
    country121.name
      .add(util.Locale.UK, "Latvia")
      .add(util.Locale.GERMANY, "Latvia")
    entityManager.persist(country121)
    countryList.put(country121.isoCode, country121)

    val country122 = new Country
    country122.isoCode = "LB"
    country122.name
      .add(util.Locale.UK, "Lebanon")
      .add(util.Locale.GERMANY, "Lebanon")
    entityManager.persist(country122)
    countryList.put(country122.isoCode, country122)

    val country123 = new Country
    country123.isoCode = "LS"
    country123.name
      .add(util.Locale.UK, "Lesotho")
      .add(util.Locale.GERMANY, "Lesotho")
    entityManager.persist(country123)
    countryList.put(country123.isoCode, country123)

    val country124 = new Country
    country124.isoCode = "LR"
    country124.name
      .add(util.Locale.UK, "Liberia")
      .add(util.Locale.GERMANY, "Liberia")
    entityManager.persist(country124)
    countryList.put(country124.isoCode, country124)

    val country125 = new Country
    country125.isoCode = "LY"
    country125.name
      .add(util.Locale.UK, "Libyan Arab Jamahiriya")
      .add(util.Locale.GERMANY, "Libyan Arab Jamahiriya")
    entityManager.persist(country125)
    countryList.put(country125.isoCode, country125)

    val country126 = new Country
    country126.isoCode = "LI"
    country126.name
      .add(util.Locale.UK, "Liechtenstein")
      .add(util.Locale.GERMANY, "Liechtenstein")
    entityManager.persist(country126)
    countryList.put(country126.isoCode, country126)

    val country127 = new Country
    country127.isoCode = "LT"
    country127.name
      .add(util.Locale.UK, "Lithuania")
      .add(util.Locale.GERMANY, "Lithuania")
    entityManager.persist(country127)
    countryList.put(country127.isoCode, country127)

    val country128 = new Country
    country128.isoCode = "LU"
    country128.name
      .add(util.Locale.UK, "Luxembourg")
      .add(util.Locale.GERMANY, "Luxembourg")
    entityManager.persist(country128)
    countryList.put(country128.isoCode, country128)

    val country129 = new Country
    country129.isoCode = "MO"
    country129.name
      .add(util.Locale.UK, "Macao")
      .add(util.Locale.GERMANY, "Macao")
    entityManager.persist(country129)
    countryList.put(country129.isoCode, country129)

    val country130 = new Country
    country130.isoCode = "MK"
    country130.name
      .add(util.Locale.UK, "Macedonia, The Former Yugoslav Republic of")
      .add(util.Locale.GERMANY, "Macedonia, The Former Yugoslav Republic of")
    entityManager.persist(country130)
    countryList.put(country130.isoCode, country130)

    val country131 = new Country
    country131.isoCode = "MG"
    country131.name
      .add(util.Locale.UK, "Madagascar")
      .add(util.Locale.GERMANY, "Madagascar")
    entityManager.persist(country131)
    countryList.put(country131.isoCode, country131)

    val country132 = new Country
    country132.isoCode = "MW"
    country132.name
      .add(util.Locale.UK, "Malawi")
      .add(util.Locale.GERMANY, "Malawi")
    entityManager.persist(country132)
    countryList.put(country132.isoCode, country132)

    val country133 = new Country
    country133.isoCode = "MY"
    country133.name
      .add(util.Locale.UK, "Malaysia")
      .add(util.Locale.GERMANY, "Malaysia")
    entityManager.persist(country133)
    countryList.put(country133.isoCode, country133)

    val country134 = new Country
    country134.isoCode = "MV"
    country134.name
      .add(util.Locale.UK, "Maldives")
      .add(util.Locale.GERMANY, "Maldives")
    entityManager.persist(country134)
    countryList.put(country134.isoCode, country134)

    val country135 = new Country
    country135.isoCode = "ML"
    country135.name
      .add(util.Locale.UK, "Mali")
      .add(util.Locale.GERMANY, "Mali")
    entityManager.persist(country135)
    countryList.put(country135.isoCode, country135)

    val country136 = new Country
    country136.isoCode = "MT"
    country136.name
      .add(util.Locale.UK, "Malta")
      .add(util.Locale.GERMANY, "Malta")
    entityManager.persist(country136)
    countryList.put(country136.isoCode, country136)

    val country137 = new Country
    country137.isoCode = "MH"
    country137.name
      .add(util.Locale.UK, "Marshall Islands")
      .add(util.Locale.GERMANY, "Marshall Islands")
    entityManager.persist(country137)
    countryList.put(country137.isoCode, country137)

    val country138 = new Country
    country138.isoCode = "MQ"
    country138.name
      .add(util.Locale.UK, "Martinique")
      .add(util.Locale.GERMANY, "Martinique")
    entityManager.persist(country138)
    countryList.put(country138.isoCode, country138)

    val country139 = new Country
    country139.isoCode = "MR"
    country139.name
      .add(util.Locale.UK, "Mauritania")
      .add(util.Locale.GERMANY, "Mauritania")
    entityManager.persist(country139)
    countryList.put(country139.isoCode, country139)

    val country140 = new Country
    country140.isoCode = "MU"
    country140.name
      .add(util.Locale.UK, "Mauritius")
      .add(util.Locale.GERMANY, "Mauritius")
    entityManager.persist(country140)
    countryList.put(country140.isoCode, country140)

    val country141 = new Country
    country141.isoCode = "YT"
    country141.name
      .add(util.Locale.UK, "Mayotte")
      .add(util.Locale.GERMANY, "Mayotte")
    entityManager.persist(country141)
    countryList.put(country141.isoCode, country141)

    val country142 = new Country
    country142.isoCode = "MX"
    country142.name
      .add(util.Locale.UK, "Mexico")
      .add(util.Locale.GERMANY, "Mexico")
    entityManager.persist(country142)
    countryList.put(country142.isoCode, country142)

    val country143 = new Country
    country143.isoCode = "FM"
    country143.name
      .add(util.Locale.UK, "Micronesia, Federated States of")
      .add(util.Locale.GERMANY, "Micronesia, Federated States of")
    entityManager.persist(country143)
    countryList.put(country143.isoCode, country143)

    val country144 = new Country
    country144.isoCode = "MD"
    country144.name
      .add(util.Locale.UK, "Moldova, Republic of")
      .add(util.Locale.GERMANY, "Moldova, Republic of")
    entityManager.persist(country144)
    countryList.put(country144.isoCode, country144)

    val country145 = new Country
    country145.isoCode = "MC"
    country145.name
      .add(util.Locale.UK, "Monaco")
      .add(util.Locale.GERMANY, "Monaco")
    entityManager.persist(country145)
    countryList.put(country145.isoCode, country145)

    val country146 = new Country
    country146.isoCode = "MN"
    country146.name
      .add(util.Locale.UK, "Mongolia")
      .add(util.Locale.GERMANY, "Mongolia")
    entityManager.persist(country146)
    countryList.put(country146.isoCode, country146)

    val country147 = new Country
    country147.isoCode = "MS"
    country147.name
      .add(util.Locale.UK, "Montserrat")
      .add(util.Locale.GERMANY, "Montserrat")
    entityManager.persist(country147)
    countryList.put(country147.isoCode, country147)

    val country148 = new Country
    country148.isoCode = "MA"
    country148.name
      .add(util.Locale.UK, "Morocco")
      .add(util.Locale.GERMANY, "Morocco")
    entityManager.persist(country148)
    countryList.put(country148.isoCode, country148)

    val country149 = new Country
    country149.isoCode = "MZ"
    country149.name
      .add(util.Locale.UK, "Mozambique")
      .add(util.Locale.GERMANY, "Mozambique")
    entityManager.persist(country149)
    countryList.put(country149.isoCode, country149)

    val country150 = new Country
    country150.isoCode = "MM"
    country150.name
      .add(util.Locale.UK, "Myanmar")
      .add(util.Locale.GERMANY, "Myanmar")
    entityManager.persist(country150)
    countryList.put(country150.isoCode, country150)

    val country151 = new Country
    country151.isoCode = "NA"
    country151.name
      .add(util.Locale.UK, "Namibia")
      .add(util.Locale.GERMANY, "Namibia")
    entityManager.persist(country151)
    countryList.put(country151.isoCode, country151)

    val country152 = new Country
    country152.isoCode = "NR"
    country152.name
      .add(util.Locale.UK, "Nauru")
      .add(util.Locale.GERMANY, "Nauru")
    entityManager.persist(country152)
    countryList.put(country152.isoCode, country152)

    val country153 = new Country
    country153.isoCode = "NP"
    country153.name
      .add(util.Locale.UK, "Nepal")
      .add(util.Locale.GERMANY, "Nepal")
    entityManager.persist(country153)
    countryList.put(country153.isoCode, country153)

    val country154 = new Country
    country154.isoCode = "NL"
    country154.name
      .add(util.Locale.UK, "Netherlands")
      .add(util.Locale.GERMANY, "Netherlands")
    entityManager.persist(country154)
    countryList.put(country154.isoCode, country154)

    val country155 = new Country
    country155.isoCode = "AN"
    country155.name
      .add(util.Locale.UK, "Netherlands Antilles")
      .add(util.Locale.GERMANY, "Netherlands Antilles")
    entityManager.persist(country155)
    countryList.put(country155.isoCode, country155)

    val country156 = new Country
    country156.isoCode = "NC"
    country156.name
      .add(util.Locale.UK, "New Caledonia")
      .add(util.Locale.GERMANY, "New Caledonia")
    entityManager.persist(country156)
    countryList.put(country156.isoCode, country156)

    val country157 = new Country
    country157.isoCode = "NZ"
    country157.name
      .add(util.Locale.UK, "New Zealand")
      .add(util.Locale.GERMANY, "New Zealand")
    entityManager.persist(country157)
    countryList.put(country157.isoCode, country157)

    val country158 = new Country
    country158.isoCode = "NI"
    country158.name
      .add(util.Locale.UK, "Nicaragua")
      .add(util.Locale.GERMANY, "Nicaragua")
    entityManager.persist(country158)
    countryList.put(country158.isoCode, country158)

    val country159 = new Country
    country159.isoCode = "NI"
    country159.name
      .add(util.Locale.UK, "Niger")
      .add(util.Locale.GERMANY, "Niger")
    entityManager.persist(country159)
    countryList.put(country159.isoCode, country159)

    val country160 = new Country
    country160.isoCode = "NG"
    country160.name
      .add(util.Locale.UK, "Nigeria")
      .add(util.Locale.GERMANY, "Nigeria")
    entityManager.persist(country160)
    countryList.put(country160.isoCode, country160)

    val country161 = new Country
    country161.isoCode = "NU"
    country161.name
      .add(util.Locale.UK, "Niue")
      .add(util.Locale.GERMANY, "Niue")
    entityManager.persist(country161)
    countryList.put(country161.isoCode, country161)

    val country162 = new Country
    country162.isoCode = "NF"
    country162.name
      .add(util.Locale.UK, "Norfolk Island")
      .add(util.Locale.GERMANY, "Norfolk Island")
    entityManager.persist(country162)
    countryList.put(country162.isoCode, country162)

    val country163 = new Country
    country163.isoCode = "MP"
    country163.name
      .add(util.Locale.UK, "Northern Mariana Islands")
      .add(util.Locale.GERMANY, "Northern Mariana Islands")
    entityManager.persist(country163)
    countryList.put(country163.isoCode, country163)

    val country164 = new Country
    country164.isoCode = "NO"
    country164.name
      .add(util.Locale.UK, "Norway")
      .add(util.Locale.GERMANY, "Norway")
    entityManager.persist(country164)
    countryList.put(country164.isoCode, country164)

    val country165 = new Country
    country165.isoCode = "OM"
    country165.name
      .add(util.Locale.UK, "Oman")
      .add(util.Locale.GERMANY, "Oman")
    entityManager.persist(country165)
    countryList.put(country165.isoCode, country165)

    val country166 = new Country
    country166.isoCode = "PK"
    country166.name
      .add(util.Locale.UK, "Pakistan")
      .add(util.Locale.GERMANY, "Pakistan")
    entityManager.persist(country166)
    countryList.put(country166.isoCode, country166)

    val country167 = new Country
    country167.isoCode = "PW"
    country167.name
      .add(util.Locale.UK, "Palau")
      .add(util.Locale.GERMANY, "Palau")
    entityManager.persist(country167)
    countryList.put(country167.isoCode, country167)

    val country168 = new Country
    country168.isoCode = "PS"
    country168.name
      .add(util.Locale.UK, "Palestinian Territory, Occupied")
      .add(util.Locale.GERMANY, "Palestinian Territory, Occupied")
    entityManager.persist(country168)
    countryList.put(country168.isoCode, country168)

    val country169 = new Country
    country169.isoCode = "PA"
    country169.name
      .add(util.Locale.UK, "Panama")
      .add(util.Locale.GERMANY, "Panama")
    entityManager.persist(country169)
    countryList.put(country169.isoCode, country169)

    val country170 = new Country
    country170.isoCode = "PG"
    country170.name
      .add(util.Locale.UK, "Papua New Guinea")
      .add(util.Locale.GERMANY, "Papua New Guinea")
    entityManager.persist(country170)
    countryList.put(country170.isoCode, country170)

    val country171 = new Country
    country171.isoCode = "PY"
    country171.name
      .add(util.Locale.UK, "Paraguay")
      .add(util.Locale.GERMANY, "Paraguay")
    entityManager.persist(country171)
    countryList.put(country171.isoCode, country171)

    val country172 = new Country
    country172.isoCode = "PE"
    country172.name
      .add(util.Locale.UK, "Peru")
      .add(util.Locale.GERMANY, "Peru")
    entityManager.persist(country172)
    countryList.put(country172.isoCode, country172)

    val country173 = new Country
    country173.isoCode = "PH"
    country173.name
      .add(util.Locale.UK, "Philippines")
      .add(util.Locale.GERMANY, "Philippines")
    entityManager.persist(country173)
    countryList.put(country173.isoCode, country173)

    val country174 = new Country
    country174.isoCode = "PN"
    country174.name
      .add(util.Locale.UK, "Pitcairn")
      .add(util.Locale.GERMANY, "Pitcairn")
    entityManager.persist(country174)
    countryList.put(country174.isoCode, country174)

    val country175 = new Country
    country175.isoCode = "PL"
    country175.name
      .add(util.Locale.UK, "Poland")
      .add(util.Locale.GERMANY, "Poland")
    entityManager.persist(country175)
    countryList.put(country175.isoCode, country175)

    val country176 = new Country
    country176.isoCode = "PT"
    country176.name
      .add(util.Locale.UK, "Portugal")
      .add(util.Locale.GERMANY, "Portugal")
    entityManager.persist(country176)
    countryList.put(country176.isoCode, country176)

    val country177 = new Country
    country177.isoCode = "PR"
    country177.name
      .add(util.Locale.UK, "Puerto Rico")
      .add(util.Locale.GERMANY, "Puerto Rico")
    entityManager.persist(country177)
    countryList.put(country177.isoCode, country177)

    val country178 = new Country
    country178.isoCode = "QA"
    country178.name
      .add(util.Locale.UK, "Qatar")
      .add(util.Locale.GERMANY, "Qatar")
    entityManager.persist(country178)
    countryList.put(country178.isoCode, country178)

    val country179 = new Country
    country179.isoCode = "RE"
    country179.name
      .add(util.Locale.UK, "Reunion")
      .add(util.Locale.GERMANY, "Reunion")
    entityManager.persist(country179)
    countryList.put(country179.isoCode, country179)

    val country180 = new Country
    country180.isoCode = "RO"
    country180.name
      .add(util.Locale.UK, "Romania")
      .add(util.Locale.GERMANY, "Romania")
    entityManager.persist(country180)
    countryList.put(country180.isoCode, country180)

    val country181 = new Country
    country181.isoCode = "RU"
    country181.name
      .add(util.Locale.UK, "Russian Federation")
      .add(util.Locale.GERMANY, "Russian Federation")
    entityManager.persist(country181)
    countryList.put(country181.isoCode, country181)

    val country182 = new Country
    country182.isoCode = "RW"
    country182.name
      .add(util.Locale.UK, "Rwanda")
      .add(util.Locale.GERMANY, "Rwanda")
    entityManager.persist(country182)
    countryList.put(country182.isoCode, country182)

    val country183 = new Country
    country183.isoCode = "SH"
    country183.name
      .add(util.Locale.UK, "Saint Helena")
      .add(util.Locale.GERMANY, "Saint Helena")
    entityManager.persist(country183)
    countryList.put(country183.isoCode, country183)

    val country184 = new Country
    country184.isoCode = "KN"
    country184.name
      .add(util.Locale.UK, "Saint Kitts and Nevis")
      .add(util.Locale.GERMANY, "Saint Kitts and Nevis")
    entityManager.persist(country184)
    countryList.put(country184.isoCode, country184)

    val country185 = new Country
    country185.isoCode = "LC"
    country185.name
      .add(util.Locale.UK, "Saint Luciaa")
      .add(util.Locale.GERMANY, "Saint Lucia")
    entityManager.persist(country185)
    countryList.put(country185.isoCode, country185)

    val country186 = new Country
    country186.isoCode = "PM"
    country186.name
      .add(util.Locale.UK, "Saint Pierre and Miquelon")
      .add(util.Locale.GERMANY, "Saint Pierre and Miquelon")
    entityManager.persist(country186)
    countryList.put(country186.isoCode, country186)

    val country187 = new Country
    country187.isoCode = "VC"
    country187.name
      .add(util.Locale.UK, "Saint Vincent and the Grenadines")
      .add(util.Locale.GERMANY, "Saint Vincent and the Grenadines")
    entityManager.persist(country187)
    countryList.put(country187.isoCode, country187)

    val country188 = new Country
    country188.isoCode = "WS"
    country188.name
      .add(util.Locale.UK, "Samoa")
      .add(util.Locale.GERMANY, "Samoa")
    entityManager.persist(country188)
    countryList.put(country188.isoCode, country188)

    val country189 = new Country
    country189.isoCode = "SM"
    country189.name
      .add(util.Locale.UK, "San Marino")
      .add(util.Locale.GERMANY, "San Marino")
    entityManager.persist(country189)
    countryList.put(country189.isoCode, country189)

    val country190 = new Country
    country190.isoCode = "ST"
    country190.name
      .add(util.Locale.UK, "Sao Tome and Principe")
      .add(util.Locale.GERMANY, "Sao Tome and Principe")
    entityManager.persist(country190)
    countryList.put(country190.isoCode, country190)

    val country191 = new Country
    country191.isoCode = "SA"
    country191.name
      .add(util.Locale.UK, "Saudi Arabia")
      .add(util.Locale.GERMANY, "Saudi Arabia")
    entityManager.persist(country191)
    countryList.put(country191.isoCode, country191)

    val country192 = new Country
    country192.isoCode = "SN"
    country192.name
      .add(util.Locale.UK, "Senegal")
      .add(util.Locale.GERMANY, "Senegal")
    entityManager.persist(country192)
    countryList.put(country192.isoCode, country192)

    val country193 = new Country
    country193.isoCode = "CS"
    country193.name
      .add(util.Locale.UK, "Serbia and Montenegro")
      .add(util.Locale.GERMANY, "Serbia and Montenegro")
    entityManager.persist(country193)
    countryList.put(country193.isoCode, country193)

    val country194 = new Country
    country194.isoCode = "SC"
    country194.name
      .add(util.Locale.UK, "Seychelles")
      .add(util.Locale.GERMANY, "Seychelles")
    entityManager.persist(country194)
    countryList.put(country194.isoCode, country194)

    val country195 = new Country
    country195.isoCode = "SL"
    country195.name
      .add(util.Locale.UK, "Sierra Leone")
      .add(util.Locale.GERMANY, "Sierra Leone")
    entityManager.persist(country195)
    countryList.put(country195.isoCode, country195)

    val country196 = new Country
    country196.isoCode = "SG"
    country196.name
      .add(util.Locale.UK, "Singapore")
      .add(util.Locale.GERMANY, "Singapore")
    entityManager.persist(country196)
    countryList.put(country196.isoCode, country196)

    val country197 = new Country
    country197.isoCode = "SK"
    country197.name
      .add(util.Locale.UK, "Slovakia")
      .add(util.Locale.GERMANY, "Slovakia")
    entityManager.persist(country197)
    countryList.put(country197.isoCode, country197)

    val country198 = new Country
    country198.isoCode = "SI"
    country198.name
      .add(util.Locale.UK, "Slovenia")
      .add(util.Locale.GERMANY, "Slovenia")
    entityManager.persist(country198)
    countryList.put(country198.isoCode, country198)

    val country199 = new Country
    country199.isoCode = "SB"
    country199.name
      .add(util.Locale.UK, "Solomon Islands")
      .add(util.Locale.GERMANY, "Solomon Islands")
    entityManager.persist(country199)
    countryList.put(country199.isoCode, country199)

    val country200 = new Country
    country200.isoCode = "SO"
    country200.name
      .add(util.Locale.UK, "Somalia")
      .add(util.Locale.GERMANY, "Somalia")
    entityManager.persist(country200)
    countryList.put(country200.isoCode, country200)

    val country201 = new Country
    country201.isoCode = "ZA"
    country201.name
      .add(util.Locale.UK, "South Africa")
      .add(util.Locale.GERMANY, "South Africa")
    entityManager.persist(country201)
    countryList.put(country201.isoCode, country201)

    val country202 = new Country
    country202.isoCode = "GS"
    country202.name
      .add(util.Locale.UK, "South Georgia and the South Sandwich Islands")
      .add(util.Locale.GERMANY, "South Georgia and the South Sandwich Islands")
    entityManager.persist(country202)
    countryList.put(country202.isoCode, country202)

    val country203 = new Country
    country203.isoCode = "ES"
    country203.name
      .add(util.Locale.UK, "Spain")
      .add(util.Locale.GERMANY, "Spain")
    entityManager.persist(country203)
    countryList.put(country203.isoCode, country203)

    val country204 = new Country
    country204.isoCode = "LK"
    country204.name
      .add(util.Locale.UK, "Sri Lanka")
      .add(util.Locale.GERMANY, "Sri Lanka")
    entityManager.persist(country204)
    countryList.put(country204.isoCode, country204)

    val country205 = new Country
    country205.isoCode = "SD"
    country205.name
      .add(util.Locale.UK, "Sudan")
      .add(util.Locale.GERMANY, "Sudan")
    entityManager.persist(country205)
    countryList.put(country205.isoCode, country205)

    val country206 = new Country
    country206.isoCode = "SR"
    country206.name
      .add(util.Locale.UK, "Suriname")
      .add(util.Locale.GERMANY, "Suriname")
    entityManager.persist(country206)
    countryList.put(country206.isoCode, country206)

    val country207 = new Country
    country207.isoCode = "SJ"
    country207.name
      .add(util.Locale.UK, "Svalbard and Jan Mayen")
      .add(util.Locale.GERMANY, "Svalbard and Jan Mayen")
    entityManager.persist(country207)
    countryList.put(country207.isoCode, country207)

    val country208 = new Country
    country208.isoCode = "SZ"
    country208.name
      .add(util.Locale.UK, "Swaziland")
      .add(util.Locale.GERMANY, "Swaziland")
    entityManager.persist(country208)
    countryList.put(country208.isoCode, country208)

    val country209 = new Country
    country209.isoCode = "SE"
    country209.name
      .add(util.Locale.UK, "Sweden")
      .add(util.Locale.GERMANY, "Sweden")
    entityManager.persist(country209)
    countryList.put(country209.isoCode, country209)

    val country210 = new Country
    country210.isoCode = "CH"
    country210.name
      .add(util.Locale.UK, "Switzerland")
      .add(util.Locale.GERMANY, "Switzerland")
    entityManager.persist(country210)
    countryList.put(country210.isoCode, country210)

    val country211 = new Country
    country211.isoCode = "SY"
    country211.name
      .add(util.Locale.UK, "Syrian Arab Republic")
      .add(util.Locale.GERMANY, "Syrian Arab Republic")
    entityManager.persist(country211)
    countryList.put(country21.isoCode, country211)

    val country212 = new Country
    country212.isoCode = "TW"
    country212.name
      .add(util.Locale.UK, "Taiwan, Province of China")
      .add(util.Locale.GERMANY, "Taiwan, Province of China")
    entityManager.persist(country212)
    countryList.put(country22.isoCode, country212)

    val country213 = new Country
    country213.isoCode = "TJ"
    country213.name
      .add(util.Locale.UK, "Tajikistan")
      .add(util.Locale.GERMANY, "Tajikistan")
    entityManager.persist(country213)
    countryList.put(country23.isoCode, country213)

    val country214 = new Country
    country214.isoCode = "TZ"
    country214.name
      .add(util.Locale.UK, "Tanzania, United Republic of")
      .add(util.Locale.GERMANY, "Tanzania, United Republic of")
    entityManager.persist(country214)
    countryList.put(country214.isoCode, country214)

    val country215 = new Country
    country215.isoCode = "TH"
    country215.name
      .add(util.Locale.UK, "Thailand")
      .add(util.Locale.GERMANY, "Thailand")
    entityManager.persist(country215)
    countryList.put(country215.isoCode, country215)

    val country216 = new Country
    country216.isoCode = "TL"
    country216.name
      .add(util.Locale.UK, "Timor-Leste")
      .add(util.Locale.GERMANY, "Timor-Leste")
    entityManager.persist(country216)
    countryList.put(country216.isoCode, country216)

    val country217 = new Country
    country217.isoCode = "TG"
    country217.name
      .add(util.Locale.UK, "Togo")
      .add(util.Locale.GERMANY, "Togo")
    entityManager.persist(country217)
    countryList.put(country217.isoCode, country217)

    val country218 = new Country
    country218.isoCode = "TK"
    country218.name
      .add(util.Locale.UK, "Tokelau")
      .add(util.Locale.GERMANY, "Tokelau")
    entityManager.persist(country218)
    countryList.put(country28.isoCode, country218)

    val country219 = new Country
    country219.isoCode = "TO"
    country219.name
      .add(util.Locale.UK, "Tonga")
      .add(util.Locale.GERMANY, "Tonga")
    entityManager.persist(country219)
    countryList.put(country219.isoCode, country219)

    val country220 = new Country
    country220.isoCode = "TT"
    country220.name
      .add(util.Locale.UK, "Trinidad and Tobago")
      .add(util.Locale.GERMANY, "Trinidad and Tobago")
    entityManager.persist(country220)
    countryList.put(country220.isoCode, country220)

    val country221 = new Country
    country221.isoCode = "TN"
    country221.name
      .add(util.Locale.UK, "Tunisia")
      .add(util.Locale.GERMANY, "Tunisia")
    entityManager.persist(country221)
    countryList.put(country221.isoCode, country221)

    val country222 = new Country
    country222.isoCode = "TR"
    country222.name
      .add(util.Locale.UK, "Turkey")
      .add(util.Locale.GERMANY, "Turkey")
    entityManager.persist(country222)
    countryList.put(country222.isoCode, country222)

    val country223 = new Country
    country223.isoCode = "TM"
    country223.name
      .add(util.Locale.UK, "Turkmenistan")
      .add(util.Locale.GERMANY, "Turkmenistan")
    entityManager.persist(country223)
    countryList.put(country223.isoCode, country223)

    val country224 = new Country
    country224.isoCode = "TC"
    country224.name
      .add(util.Locale.UK, "Turks and Caicos Islands")
      .add(util.Locale.GERMANY, "Turks and Caicos Islands")
    entityManager.persist(country224)
    countryList.put(country224.isoCode, country224)

    val country225 = new Country
    country225.isoCode = "TV"
    country225.name
      .add(util.Locale.UK, "Tuvalu")
      .add(util.Locale.GERMANY, "Tuvalu")
    entityManager.persist(country225)
    countryList.put(country225.isoCode, country225)

    val country226 = new Country
    country226.isoCode = "UG"
    country226.name
      .add(util.Locale.UK, "Uganda")
      .add(util.Locale.GERMANY, "Uganda")
    entityManager.persist(country226)
    countryList.put(country226.isoCode, country226)

    val country227 = new Country
    country227.isoCode = "UA"
    country227.name
      .add(util.Locale.UK, "Ukraine")
      .add(util.Locale.GERMANY, "Ukraine")
    entityManager.persist(country227)
    countryList.put(country227.isoCode, country227)

    val country228 = new Country
    country228.isoCode = "AE"
    country228.name
      .add(util.Locale.UK, "United Arab Emirates")
      .add(util.Locale.GERMANY, "United Arab Emirates")
    entityManager.persist(country228)
    countryList.put(country228.isoCode, country228)

    val country229 = new Country
    country229.isoCode = "GB"
    country229.name
      .add(util.Locale.UK, "United Kingdom")
      .add(util.Locale.GERMANY, "United Kingdom")
    entityManager.persist(country229)
    countryList.put(country229.isoCode, country229)

    val country230 = new Country
    country230.isoCode = "US"
    country230.name
      .add(util.Locale.UK, "United States")
      .add(util.Locale.GERMANY, "United States")
    entityManager.persist(country230)
    countryList.put(country230.isoCode, country230)

    val country231 = new Country
    country231.isoCode = "UM"
    country231.name
      .add(util.Locale.UK, "United States Minor Outlying Islands")
      .add(util.Locale.GERMANY, "United States Minor Outlying Islands")
    entityManager.persist(country231)
    countryList.put(country231.isoCode, country231)

    val country232 = new Country
    country232.isoCode = "UY"
    country232.name
      .add(util.Locale.UK, "Uruguay")
      .add(util.Locale.GERMANY, "Uruguay")
    entityManager.persist(country232)
    countryList.put(country232.isoCode, country232)

    val country233 = new Country
    country233.isoCode = "UZ"
    country233.name
      .add(util.Locale.UK, "Uzbekistan")
      .add(util.Locale.GERMANY, "Uzbekistan")
    entityManager.persist(country233)
    countryList.put(country233.isoCode, country233)

    val country234 = new Country
    country234.isoCode = "VU"
    country234.name
      .add(util.Locale.UK, "Vanuatu")
      .add(util.Locale.GERMANY, "Vanuatu")
    entityManager.persist(country234)
    countryList.put(country234.isoCode, country234)

    val country235 = new Country
    country235.isoCode = "VE"
    country235.name
      .add(util.Locale.UK, "Venezuela")
      .add(util.Locale.GERMANY, "Venezuela")
    entityManager.persist(country235)
    countryList.put(country235.isoCode, country235)

    val country236 = new Country
    country236.isoCode = "VN"
    country236.name
      .add(util.Locale.UK, "Viet Nam")
      .add(util.Locale.GERMANY, "Viet Nam")
    entityManager.persist(country236)
    countryList.put(country236.isoCode, country236)

    val country237 = new Country
    country237.isoCode = "VG"
    country237.name
      .add(util.Locale.UK, "Virgin Islands, British")
      .add(util.Locale.GERMANY, "Virgin Islands, British")
    entityManager.persist(country237)
    countryList.put(country237.isoCode, country237)

    val country238 = new Country
    country238.isoCode = "VI"
    country238.name
      .add(util.Locale.UK, "Virgin Islands, U.S.")
      .add(util.Locale.GERMANY, "Virgin Islands, U.S.")
    entityManager.persist(country238)
    countryList.put(country238.isoCode, country238)

    val country239 = new Country
    country239.isoCode = "WF"
    country239.name
      .add(util.Locale.UK, "Wallis and Futuna")
      .add(util.Locale.GERMANY, "Wallis and Futuna")
    entityManager.persist(country239)
    countryList.put(country239.isoCode, country239)

    val country240 = new Country
    country240.isoCode = "EH"
    country240.name
      .add(util.Locale.UK, "Western Sahara")
      .add(util.Locale.GERMANY, "Western Sahara")
    entityManager.persist(country240)
    countryList.put(country240.isoCode, country240)

    val country241 = new Country
    country241.isoCode = "YE"
    country241.name
      .add(util.Locale.UK, "Yemen")
      .add(util.Locale.GERMANY, "Yemen")
    entityManager.persist(country241)
    countryList.put(country241.isoCode, country241)

    val country242 = new Country
    country242.isoCode = "ZM"
    country242.name
      .add(util.Locale.UK, "Zambia")
      .add(util.Locale.GERMANY, "Zambia")
    entityManager.persist(country242)
    countryList.put(country242.isoCode, country242)

    val country243 = new Country
    country243.isoCode = "ZW"
    country243.name
      .add(util.Locale.UK, "Zimbabwe")
      .add(util.Locale.GERMANY, "Zimbabwe")
    entityManager.persist(country243)
    countryList.put(country243.isoCode, country243)

  }

  def index() = 3

  def name() = "Country"
}