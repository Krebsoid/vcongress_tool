vCongress – Kongressverwaltungs
==============
Die Grundlage für das System existiert seit 2009, als Versuch ein modernes, flexibles System mit Maven-gestützter Modularisierung aufzubauen. Das Kongressmanagement Tool sollte komponentenweise aufgebaut werden, so dass einzelne Komponenten mit wenig Aufwand abgeschnitten oder hinzugefügt werden können, um die Funktionalität zu erweitern.

Das System ist darauf ausgelegt, dass es eine ständig aktualisierte und gepflegte Master Version gibt, in der alle Funktionalitäten enthalten sind. Für jeden Kongress wird eine Branch Version von der Master Version angelegt, in der die benötigten Komponenten (Bezahlung, Abstract Submission, etc.) für den Kongress zusammengestellt werden und individuelle Anpassungen eingepflegt werden können.

Als Programmiersprache hab ich mich für Scala entschieden, um die Tauglichkeit und Produktivität gegenüber von purem Java im Enterprise Sektor zu testen.

Zu dieser Zeit gab es auch einen ziemlichen Hype um Rich Client Anwendungen im Internet. Daher  habe ich auch in diesem Zuge das JavaScript Framework ExtJS von Sencha getestet. ExtJS bot und bietet zu diesem Zeitpunkt immer noch eine ziemlich große Anzahl von sehr nützlichen Widgets und Funktionalitäten, gerade was Datenaufbereitung in Tabellen und Grids angeht. Das Framework hat sich allerdings im Nachhinein als ziemlich schwergewichtig im Umgang, der Erweiterung und bei Fehlersuche herausgestellt. Für die Kommunikation zwischen Backend und Frontend ist eine REST Schnittstelle implementiert.

Mittlerweile wurde das System in den letzten 3 Jahren für ca. 30 Kongresse eingesetzt und währenddessen ständig von mir weiterentwickelt und gepflegt.

Aufgrund der Größe des Systems hier nur ein kleiner Teil des Systems. Im Detail das Kernmodul, mit Funktionalitäten zu Benutzerkonten, Registrierung, Login, Logout, Security, etc. als Grundlage, von allen darauf aufbauenden Modulen. Sowie das Congress Modul, welches für die Auswahl der kongress-spezifischen Aktivitäten durch die Teilnehmer zuständig ist, wie Auswahl des Teilnehmerstatus und Buchung von  optionalen Abendveranstaltungen und Workshops.

Zur Anschauung ist eine Testversion online. Zu erreichen unter http://test.vcongress.de Man kann sich registrieren oder einfach als Organisator einloggen, mit folgenden Daten:
 
E-Mail Adresse: organiser@organiser.de

Passwort: organiser