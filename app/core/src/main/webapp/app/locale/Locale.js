var params = Ext.urlDecode(window.location.search.substring(1));

if (!Ext.isDefined(params.lang))
    params.lang = 'en_GB';
else if (params.lang != 'de_DE') {
    params.lang = 'en_GB'
}

var locale = {

    'Notification Service Text' : {
        de_DE : 'Ich möchte gerne über weitere Kongresse und Veranstaltungen informiert werden. Dieser Service kann jederzeit wiederrufen werden.',
        en_GB : 'I would like to receive information about new congresses and events. This service can be cancelled every time.'
    },

    'Registered participants' : {
        de_DE : 'Angemeldete Teilnehmer',
        en_GB : 'Registered participants'
    },
    'Thereof already paid' : {
        de_DE : 'Davon bereits bezahlt',
        en_GB : 'Thereof already paid'
    },
    'PayPal balance' : {
        de_DE : 'Kontostand PayPal',
        en_GB : 'PayPal balance'
    },
    'Created abstracts' : {
        de_DE : 'Angelegte Abstracts',
        en_GB : 'Created abstracts'
    },
    'Thereof already submitted' : {
        de_DE : 'Davon bereits eingreicht',
        en_GB : 'Thereof already submitted'
    },
    'Status reviewed abstracts' : {
        de_DE : 'Status begutachtete Abstracts',
        en_GB : 'Status reviewed abstracts'
    },
    'Retrieving PayPal data... Please wait' : {
        de_DE : 'Rufe PayPal Daten ab... Bitte warten',
        en_GB : 'Retrieving PayPal data... Please wait'
    },
    'Congress Status' : {
        de_DE : 'Kongress Status',
        en_GB : 'Congress Status'
    },

    'Select a reviewer' : {
        de_DE : 'Gutachter wählen',
        en_GB : 'Select a reviewer'
    },

    'There are unsaved changes.' : {
        de_DE : 'Im Formular sind ungesicherte Änderungen.',
        en_GB : 'There are unsaved changes.'
    },

    'Please choose your language:' : {
        de_DE : 'Bitte wählen Sie Ihre Sprache:',
        en_GB : 'Please choose your language:'
    },
    'Evening Event' : {
        de_DE : 'Abendveranstaltung:',
        en_GB : 'Evening Event'
    },

    'Please save.' : {
        de_DE : 'Bitte speichern.',
        en_GB : 'Please save.'
    },

    'Occupation Form' : {
        de_DE : 'Formular: Tätigkeit',
        en_GB : 'Occupation Form'
    },

    'Participation Form' : {
        de_DE : 'Formular: Teilnahme',
        en_GB : 'Participation Form'
    },

    'Contact Form' : {
        de_DE : 'Formular: Kontakt',
        en_GB : 'Contact Form'
    },

    'Address Form' : {
        de_DE : 'Formular: Adresse',
        en_GB : 'Address Form'
    },

    'Bill Address Form' : {
        de_DE : 'Formular: Rechnungsadresse',
        en_GB : 'Bill Address Form'
    },

    'Personal Form' : {
        de_DE : 'Formular: Persönlich',
        en_GB : 'Personal Form'
    },

    'Session Form' : {
        de_DE : 'Formular: Thema',
        en_GB : 'Session Form'
    },

    'Paper Form' : {
        de_DE : 'Formular: Abstract',
        en_GB : 'Abstract Form'
    },

    'Author Form' : {
        de_DE : 'Formular: Author',
        en_GB : 'Author Form'
    },

    'Reference Form' : {
        de_DE : 'Formular: Referenzen',
        en_GB : 'Reference Form'
    },

    'Manual' : {
        de_DE : 'Benutzerhandbuch f&uuml;r Kongressteilnehmer',
        en_GB : 'Manual for congress participants'
    },

    'After creation you have to submit your abstract.' : {
        de_DE : 'Nach dem Anlegen müssen Sie ihr Abstract noch submitten.',
        en_GB : 'After creation you have to submit your abstract.'
    },

    'Logout Button' : {
        de_DE : '<h1>Abmelden</h1><p style="width: 140px;white-space: normal;">Bitte loggen Sie sich aus falls Sie sich neu anmelden oder registrieren wollen</p>',
        en_GB : '<h1>Logout</h1><p style="width: 140px;white-space: normal;">Please log out if you want to login or register again</p>'
    },

    'Login Button' : {
        de_DE : '<h1>Anmelden</h1><p style="width: 140px;white-space: normal;">Falls Sie sich schon registriert haben, k&ouml;nnen Sie sich hier wieder anmelden</p>',
        en_GB : '<h1>Login</h1><p style="width: 140px;white-space: normal;">If you are already registered you can login again here</p>'
    },

    'Register Button' : {
        de_DE : '<h1>Registrierung</h1><p style="width: 140px;white-space: normal;">Falls Sie noch nicht registriert sind, dr&uuml;cken Sie bitte diesen Button</p>',
        en_GB : '<h1>Registration</h1><p style="width: 140px;white-space: normal;">If you are not registered yet, please press this button</p>'
    },

    // General
    'Connection Problem'                                         :{
        de_DE :'Verbindungsproblem',
        en_GB :'Connection Problem'
    },
    'Frequently asked questions and Trouble shooting for vCongress':{
        de_DE :'Frequently Asked Questions (FAQ) and Trouble Shooting',
        en_GB :'Frequently asked questions and Trouble shooting for vCongress'
    },
    'Help'                                                       :{
        de_DE :'&nbsp;&nbsp;Hilfe&nbsp;&nbsp;',
        en_GB :'&nbsp;&nbsp;&nbsp;Help&nbsp;&nbsp;&nbsp;'
    },

    'Please check your internet connection.':{
        de_DE :'Bitte &uuml;berpr&uuml;fen Sie Ihre Internetverbindung.',
        en_GB :'Please check your internet connection.'
    },

    'Congress Title':{
        de_DE :'Kongress Titel',
        en_GB :'Congress Title'
    },
    'Welcome'       :{
        de_DE :'Willkommen',
        en_GB :'Welcome'
    },
    'Log out'       :{
        de_DE :'Ausloggen',
        en_GB :'Log out'
    },
    'Contact'       :{
        de_DE :'Kontakt',
        en_GB :'Contact'
    },
    'Imprint'       :{
        de_DE :'Impressum',
        en_GB :'Imprint'
    },

    'Logged in successfully.'                                                                                                                :{
        de_DE :'Erfolgreich eingeloggt.',
        en_GB :'Logged in successfully.'
    },
    'Username or password not correct.'                                                                                                      :{
        de_DE :'Benutzername oder Passwort nicht korrekt.',
        en_GB :'Username or password not correct.'
    },
    'Logged out successfully.'                                                                                                               :{
        de_DE :'Erfolgreich ausgeloggt.',
        en_GB :'Logged out successfully.'
    },
    'Passwords do not match'                                                                                                                 :{
        de_DE :'Passw&ouml;rter stimmen nicht &uuml;berein',
        en_GB :'Passwords do not match'
    },
    'Email do not match'                                                                                                                     :{
        de_DE :'Email stimmt nicht &uuml;berein',
        en_GB :'Email do not match'
    },
    'Bitte geben Sie hier Ihre E-Mail Adresse ein, mit der Sie in vCongress registriert sind und Sie erhalten ein neues Passwort zugesendet.':{
        de_DE :'Bitte geben Sie hier Ihre E-Mail Adresse ein, mit der Sie in vCongress registriert sind und Sie erhalten ein neues Passwort zugesendet.',
        en_GB :'Please type your email address, you are registered within vCongress and you will receive a new password.'
    },
    'Senden'                                                                                                                                 :{
        de_DE :'Senden',
        en_GB :'Send'
    },
    'Sorry, we could not find your email address, please try again.'                                                                         :{
        de_DE :'Es tut uns Leid, wir konnten Ihre E-Mail Adresse nicht finden, bitte probieren Sie es noch einmal.',
        en_GB :'Sorry, we could not find your email address, please try again.'
    },
    'An email with your account data was sent to you.'                                                                                       :{
        de_DE :'Eine E-Mail mit Ihren Kontodaten wurde zu Ihnen gesandt.',
        en_GB :'An email with your account data was sent to you.'
    },
    'You have no status for the congress chosen yet.'                                                                                                         :{
        de_DE : 'Sie haben f&uuml;r diesen Kongress noch keinen Teilnahmestatus ausgew&auml;hlt.',
        en_GB : 'You have no status for the congress chosen yet.'
    },
    'You have abstracts that are not submitted yet.'                                                                                                         :{
        de_DE : 'Sie haben Abstracts, die noch nicht eingereicht sind.',
        en_GB : 'You have abstracts that are not submitted yet.'
    },
    //-------

    // Navigation
    'Congress Registration':{
        de_DE :'Kongress-<br/>anmeldung',
        en_GB :'Congress<br/>Registration'
    },
    'Dashboard'                                                                                                                              :{
        de_DE :'&Uuml;berblick',
        en_GB :'Dashboard'
    },
    'Payment'                                                                                                                                :{
        de_DE :'Bezahlung',
        en_GB :'Payment'
    },
    'Make Payment'                                                                                                                                :{
        de_DE :'Bezahlen',
        en_GB :'Make Payment'
    },
    'Make Payment Toolbar'                                                                                                                                :{
        de_DE :'Bezahlen',
        en_GB :'Make<br/>Payment'
    },
    'Choose Status'                                                                                                                                :{
        de_DE :'Teilnehmerstatus',
        en_GB :'Choose Status'
    },
    'Participant List'                                                                                                                           :{
        de_DE :'Teilnehmerliste',
        en_GB :'Participant List'
    },
    'Abstract List' : {
        de_DE : 'Abstract Liste',
        en_GB : 'Abstract List'
    },
    'Statistic Participants' : {
        de_DE : 'Statistik Teilnehmer',
        en_GB : 'Statistic Participants'
    },
    'Statistic Abstracts' : {
        de_DE : 'Statistik Abstracts',
        en_GB : 'Statistic Abstracts'
    },
    'Participant Import' : {
        de_DE : 'Teilnehmer Import',
        en_GB : 'Participant Import'
    },
    'Persons'                                                                                                                                :{
        de_DE :'Personen',
        en_GB :'Persons'
    },
    'Confirm'                                                                                                                                :{
        de_DE :'Best&auml;tigung',
        en_GB :'Confirm'
    },
    'Registration'                                                                                                                           :{
        de_DE :'Registrierung',
        en_GB :'Registration'
    },
    'Please wait, registration is in progress...'                                                                                            :{
        de_DE :'Bitte warten, Registrierung wird durchgeführt...',
        en_GB :'Please wait, registration is in progress...'
    },
    'Login'                                                                                                                                  :{
        de_DE :'Login',
        en_GB :'Login'
    },
    'Update'                                                                                                                                 :{
        de_DE :'Daten<br/>Bearbeiten',
        en_GB :'Edit Data'
    },
    'Picture' : {
        de_DE : 'Bild',
        en_GB : 'Picture'
    },
    'Reviewer' : {
        de_DE : 'Gutachter',
        en_GB : 'Reviewer'
    },
    //-----


    'Account Login'                                                   :{
        de_DE :'Account Login',
        en_GB :'Account Login'
    },
    'Email'                                                           :{
        de_DE :'E-Mail',
        en_GB :'Email'
    },
    'Password'                                                        :{
        de_DE :'Passwort',
        en_GB :'Password'
    },
    'Password Recovery'                                               :{
        de_DE :'Passwort vergessen?',
        en_GB :'Password Recovery'
    },

    // Dashboard
    'To change your personal data please press the button "Edit".'    :{
        de_DE :'Um Ihre persönlichen Daten zu ändern drücken Sie bitte den Button "Bearbeiten". ',
        en_GB :'To change your personal data please press the button "Edit".'
    },
    'For submitting your abstract please press the button "Abstract".':{
        de_DE :'Um Ihr Abstract einzureichen drücken Sie bitte den Button "Abstract".',
        en_GB :'For submitting your abstract please press the button "Abstract".'
    },
    'To register for the congress please press the button "Participation" and make your payment by pressing the button "Payment".' : {
        de_DE : 'Zur Kongressanmeldung drücken Sie bitte den Button "Teilnahme" und führen die Bezahlung aus, indem Sie den Button "Bezahlung" drücken.' +
            'Sie sind erst für den Kongress angemeldet, wenn Ihre Bezahlung erfolgreich eingegangen ist.',
        en_GB : 'To register for the congress please press the button "Participation" and make your payment by pressing the button "Payment".' +
            'You are not registered for the congress until your payment was completed successfully.'
    },
    'To register for the congress please press the button "Choose Status".' : {
        de_DE : 'Zur Kongressanmeldung klicken Sie bitte auf den Button "Teilnehmerstatus".',
        en_GB : 'To register for the congress please click the button "Choose Status".'
    },
    'After choosing you status, please make your payment by clicking the button "Make Payment".' : {
        de_DE : 'Nachdem Sie Ihren Status ausgewählt haben, führen Sie bitte Ihre Bezahlung aus, indem Sie auf den Knopf "Bezahlen" drücken.',
        en_GB : 'After choosing your status, please make your payment by clicking the button "Make Payment".'
    },

    // Update
    'Save'                                                            :{
        de_DE :'Speichern',
        en_GB :'Save'
    },
    'Account'                                                         :{
        de_DE :'Konto',
        en_GB :'Account'
    },
    'Occupation'                                                      :{
        de_DE :'T&auml;tigkeit',
        en_GB :'Occupation'
    },
    'Address'                                                         :{
        de_DE :'Adresse',
        en_GB :'Address'
    },
    'Bill Address'                                                         :{
        de_DE :'Rechnungsadresse',
        en_GB :'Billing Address'
    },

    'Gender'         :{
        de_DE :'Geschlecht',
        en_GB :'Gender'
    },
    'male'         :{
        de_DE :'männlich',
        en_GB :'male'
    },
    'female'         :{
        de_DE :'weiblich',
        en_GB :'female'
    },
    'Select a gender':{
        de_DE :'Geschlecht wählen',
        en_GB :'Select a gender'
    },
    'Select a title' :{
        de_DE :'Titel wählen',
        en_GB :'Select a title'
    },
    'Select a country' :{
        de_DE :'Land wählen',
        en_GB :'Select a country'
    },
    'Title'          :{
        de_DE :'Titel',
        en_GB :'Title'
    },

    'Department':{
        de_DE :'Abteilung',
        en_GB :'Department'
    },
    'Institute' :{
        de_DE :'Institut',
        en_GB :'Institute'
    },
    'Position'  :{
        de_DE :'Position',
        en_GB :'Position'
    },

    'Code'               :{
        de_DE :'PLZ',
        en_GB :'Zip Code'
    },
    'City'               :{
        de_DE :'Stadt',
        en_GB :'City'
    },
    'New Password'       :{
        de_DE :'Neues Passwort',
        en_GB :'New Password'
    },
    'Select a password'       :{
        de_DE :'Passwort wählen',
        en_GB :'Select a password'
    },
    'Retype new Password':{
        de_DE :'Neues Passwort best&auml;tigen',
        en_GB :'Retype new Password'
    },

    'Changes successfully saved.'                               :{
        de_DE :'Änderungen erfolgreich gespeichert.',
        en_GB :'Changes successfully saved.'
    },
    'Failed to save the changes. Errors in some of your inputs.':{
        de_DE :'Fehler bei der Speicherung. Ung&uuml;ltige Eingabe.',
        en_GB :'Failed to save the changes. Errors in some of your inputs.'
    },
    'Password successfully changed.'                            :{
        de_DE :'Passwort erfolgreich ge&auml;ndert.',
        en_GB :'Password successfully changed.'
    },
    //------

    //Registration
    'Registration for vCongress'                                :{
        de_DE :'Registrierung f&uuml;r vCongress',
        en_GB :'Registration for vCongress'
    },
    'Next'                                                      :{
        de_DE :'Weiter',
        en_GB :'Next'
    },
    'Back'                                                      :{
        de_DE :'Zur&uuml;ck',
        en_GB :'Back'
    },
    'Register'                                                  :{
        de_DE :'Anmelden',
        en_GB :'Register'
    },

    'Email Address'        :{
        de_DE :'E-Mail Adresse',
        en_GB :'Email Address'
    },
    'Confirm Email Address':{
        de_DE :'E-Mail Adresse wiederholen',
        en_GB :'Retype Email Address'
    },
    'Confirm Password'     :{
        de_DE :'Passwort wiederholen',
        en_GB :'Retype Password'
    },
    'Disclaimer'           :{
        de_DE :'Haftungshinweis',
        en_GB :'Disclaimer'
    },
    'Photo'           :{
        de_DE :'Fotografie',
        en_GB :'Photography'
    },
    'Personal Data'        :{
        de_DE :'Pers&ouml;nliche Daten',
        en_GB :'Personal Data'
    },
    'Select a status'      :{
        de_DE :'Status wählen',
        en_GB :'Select a status'
    },
    'Participation Status' :{
        de_DE :'Teilnehmer Status',
        en_GB :'Participation Status'
    },
    'Congress Fee'         :{
        de_DE :'Kongressgeb&uuml;hr',
        en_GB :'Congress Fee'
    },
    'Discount'         :{
        de_DE :'Rabatt',
        en_GB :'Congress Fee'
    },

    'Registration was successful.'                                                    :{
        de_DE :'Registrierung war erfolgreich.',
        en_GB :'Registration was successful.'
    },
    'Registration failed, please correct the indicated errors and try again to register.' : {
        de_DE : 'Die Registrierung war nicht erfolgreich. Bitte bearbeiten Sie die angezeigten Fehler und versuchen noch einmal sich zu registrieren.',
        en_GB : 'Registration failed. Please correct the indicated errors and try again to register.'
    },
    'Do you want to provide an additional email address? (i.e. secretary)'            :{
        de_DE :'M&ouml;chten Sie eine zus&auml;tzliche E-Mail Adresse angeben? (z.B. Sekretariat)',
        en_GB :'Do you want to provide an additional email address? (i.e. secretary)'
    },
    'Your account is now confirmed and you have complete access to vCongress.'        :{
        de_DE :'Ihr Account ist nun best&auml;tigt und Sie haben vollst&auml;ndigen Zugriff auf vCongress.',
        en_GB :'Your account is now confirmed and you have complete access to vCongress.'
    },
    'An Email was sent to your contact email address.'                                :{
        de_DE :'Eine E-Mail wurde an Ihre Kontakt E-Mail Adresse geschickt.',
        en_GB :'An Email was sent to your contact email address.'
    },
    'Fields marked with * are mandatory and may not be empty!'                        :{
        de_DE :'Mit * markierte Felder sind Pflichtfelder und d&uuml;rfen nicht frei bleiben!',
        en_GB :'Fields marked with * are mandatory and may not be empty!'
    },
    'Terms and Conditions'                                                            :{
        de_DE : 'Ich akzeptiere die Allgemeinen Geschäftsbedingungen <a href="#">(hier einsehen)</a>. ' +
            'Ich stimme zu, dass meine Daten elektronisch gespeichert und verarbeitet ' +
            'werden, um den Kongress zu organisieren. Zu Qualitätsverbesserungszwecken ' +
            'stimme ich zu, am Ende des Kongresses per E-Mail einen Fragebogen zu erhalten.<br/><br/>' +
            'Bitte beachten Sie, dass alle Teilnehmer des Kongresses ihre Einwilligung geben, dass alle ' +
            'Fotografien, die während der Veranstaltung aufgenommen werden, ohne Kompensation von den ' +
            'Veranstaltern verwendet werden dürfen.',
        en_GB :'I accept the terms and conditions <a href="#">(review here)</a>. ' +
            'I agree that my data are stored electronically ' +
            'to organize the congress. To ensure the quality I agree to receive a questionnaire ' +
            'via email in the end of the congress. The participation is voluntary and anonymous.<br/><br/>' +
            'Please note that all participants of the conference do hereby give '+
            'permission to the committee to use any photos taken during the event which contain '+
            'their likeness in any respectable manner, without compensation.'

    },
    'Terms and Conditions Title'                                                      :{
        de_DE :'Allgemeine Gesch&auml;ftsbedingungen',
        en_GB :'Terms and Conditions'
    },
    'Conference Fee' : {
        de_DE : 'Konferenzgebühr',
        en_GB : 'Conference Fee'
    },
    'Please fill every field and accept the disclaimer.' : {
        de_DE : 'Bitte füllen Sie alle Felder aus und stimmen den Haftungshinweisen zu.',
        en_GB : 'Please comlete every field and accept the disclaimer.'
    },
    //-------

    // Participant Grid
    'Participation Status successfully updated.'                                      :{
        de_DE :'Teilnehmerstatus erfolgreich aktualisiert.',
        en_GB :'Participation Status successfully updated.'
    },
    'Participation'                                                                   :{
        de_DE :'Teilnahme',
        en_GB :'Participation'
    },
    'Participant'                                                                     :{
        de_DE :'Teilnehmer',
        en_GB :'Participant'
    },
    'was successfully updated.'                                                       :{
        de_DE :'wurde erfolgreich aktualisiert.',
        en_GB :'was successfully updated.'
    },
    'Export'                                                                          :{
        de_DE :'Exportieren',
        en_GB :'Export'
    },
    'First Name'                                                                      :{
        de_DE :'Vorname',
        en_GB :'First Name'
    },
    'Last Name'                                                                       :{
        de_DE :'Nachname',
        en_GB :'Last Name'
    },
    'Paid'                                                                            :{
        de_DE :'Bezahlt',
        en_GB :'Paid'
    },
    'Reg. Date'                                                                       :{
        de_DE :'Reg. Datum',
        en_GB :'Reg. Date'
    },
    'Phone'                                                                           :{
        de_DE :'Telefon',
        en_GB :'Phone'
    },
    'Fax'                                                                             :{
        de_DE :'Fax',
        en_GB :'Fax'
    },
    'service/participant/participant_list.csv'                                        :{
        de_DE :'service/participant/teilnehmer_liste.csv',
        en_GB :'service/participant/participant_list.csv'
    },
    'Remove participant'                                                              :{
        de_DE :'Teilnahme stornieren',
        en_GB :'Cancel participation'
    },
    'Add participant'                                                                 :{
        de_DE :'Teilnahme anmelden',
        en_GB :'Apply participation'
    },
    'Note saved.'                                                                     :{
        de_DE :'Notiz gespeichert.',
        en_GB :'Note saved.'
    },
    'Removed Participant.'                                                            :{
        de_DE :'Teilnehmer abgemeldet.',
        en_GB :'Removed Participant.'
    },
    'Participant added.'                                                              :{
        de_DE :'Teilnehmer angemeldet.',
        en_GB :'Participant added.'
    },
    'Created' : {
        de_DE : 'Angelegt',
        en_GB : 'Created'
    },
    'Created Explanation' : {
        de_DE : 'Gibt an, wieviele Abstracts der Teilnehmer bereits angelegt hat, inklusive der eingereichten Abstracts.',
        en_GB : 'Indicates the number of overall created abstracts by the participant, including submitted abstracts.'
    },
    'Email Explanation' : {
        de_DE : 'Zeigt die E-Mail Adresse, mit der der Benutzer sich angemeldet hat und als Login benutzt.',
        en_GB : 'Shows the email address, the user is registered with and is used to login.'
    },
    'Present Explanation' : {
        de_DE : 'Markiert den Teilnehmer als Anwesend bei dem Kongress.',
        en_GB : 'Marks a participant as present at this congress.'
    },
    'Present' : {
        de_DE : 'Anwesend',
        en_GB : 'Present'
    },
    'Exhibitor Explanation' : {
        de_DE : 'Markiert den Teilnehmer als Aussteller.',
        en_GB : 'Marks a participant as exhibitor.'
    },
    'Exhibitor' : {
        de_DE : 'Aussteller',
        en_GB : 'Exhibitor'
    },
    'Speaker Explanation' : {
        de_DE : 'Markiert den Teilnehmer als Referent.',
        en_GB : 'Marks a participant as speaker.'
    },
    'Speaker' : {
        de_DE : 'Referent',
        en_GB : 'Speaker'
    },
    'Submitted Explanation' : {
        de_DE : 'Gibt an, wieviele Abstracts der Teilnehmer bereits eingereicht hat.',
        en_GB : 'Indicates the number of overall submitted abstracts by the participant.'
    },
    'Reg. Date Explanation' : {
        de_DE : 'Datum der Registrierung im System. Nicht zwingend der Zeitpunkt, der Registrierung beim Kongress',
        en_GB : 'Date of the registration in the system. Not necessarily the date of the actual congress registration.'
    },
    'Paid Explanation' : {
        de_DE : 'Es extistieren keine offenen Posten für den Teilnehmer. Weiterhin gibt es mindestens eine abgeschlossene Bezahlung.',
        en_GB : 'There are no more open transactions. Furthermore the participant has at least one completed transaction.'
    },
    'VIP Explanation' : {
        de_DE : 'Die Teilnahme ist für diesen Teilnehmer teilweise gebührenfrei. Bei Vergabe des VIP Status, wird der Teilnehmerstatus nicht in Rechnung gestellt. Falls keine Summe beglichen werden muss, wird auch keine Rechnung erzeugt.',
        en_GB : 'Participation for this participant is partly free of fee. On assigning this VIP Status, the participation fee is free. If there is no fee to be paid, no bill will be created.'
    },
    'Reviewer Explanation' : {
        de_DE : 'Dieser Teilnehmer ist als Reviewer markiert. Ihm können in der Abstract Liste Abstracts zugeordnet werden, die er begutachten soll.' +
            ' Bitte beachten: Falls der Teilnehmer als Reviewer gelöscht wird, werden auch die Gutachten dieses Teilnehmers gelöscht.',
        en_GB : 'This participant is marked as reviewer. Abstracts, which the reviewer is supposed to review, can be assigned in the abstract list.' +
            ' Please note: If the reviewer is deleted, the reviews will be also deleted.'
    },
    'Participation Explanation'                               :{
        de_DE :'Aktiv bedeutet, dass die Person am Kongress teilnimmt. Storniert bedeutet, dass die Person nicht mehr am Kongress teilnehmen wird.',
        en_GB :'Active means regular Participation. Canceled means that the participant will not participate in the congress anymore.'
    },
    //-------

    'Role'                                    :{
        de_DE :'Rolle',
        en_GB :'Role'
    },

    // Payment
    'Pending'                                 :{
        de_DE :'Ausstehend',
        en_GB :'Pending'
    },
    'Fixed'                                 :{
        de_DE :'Fest',
        en_GB :'Fixed'
    },
    'Refunded'                                 :{
        de_DE :'Erstattet',
        en_GB :'Refunded'
    },
    'Completed'                               :{
        de_DE :'Abgeschlossen',
        en_GB :'Completed'
    },
    'Canceled'                               :{
        de_DE :'Storniert',
        en_GB :'Canceled'
    },
    'Active'                               :{
        de_DE :'Aktiv',
        en_GB :'Active'
    },
    'Refund via PayPal successfully initiated.'                               :{
        de_DE :'Rückerstattung via PayPal erfolreich eingeleitet.',
        en_GB :'Refund via PayPal successfully initiated.'
    },
    'PayPal refund in progress'                               :{
        de_DE :'PayPal Rückerstattung wird durchgeführt',
        en_GB :'PayPal refund in progress'
    },
    'Confirm Refund'                               :{
        de_DE :'Bestätigung der Rückerstattung',
        en_GB :'Confirm Refund'
    },
    'Refund Transaction'                               :{
        de_DE :'Bezahlung<br/>rückerstatten',
        en_GB :'Refund<br/>Transaction'
    },
    'Close'                               :{
        de_DE :'Schließen',
        en_GB :'Close'
    },
    'Transaction Overview'                               :{
        de_DE :'Übersicht über die Transaktionen',
        en_GB :'Transaction Overview'
    },
    'Number of tickets'                               :{
        de_DE :'Anzahl der Tickets',
        en_GB :'Number of tickets'
    },
    'Transactions'                               :{
        de_DE :'Transaktionen',
        en_GB :'Transactions'
    },
    'Handling Fee' : {
        de_DE : 'Bearbeitungsgebühr',
        en_GB : 'Handling Fee'
    },
    'Hide all CANCELED transactions' : {
        de_DE : 'Blende alle CANCELED Transaktionen aus',
        en_GB : 'Hide all CANCELED transactions'
    },
    'Pending Description' : {
        de_DE : 'Transaktion ist noch bearbeitbar. Es wurde noch keine Rechnung zu dieser Transaktion gedruckt.',
        en_GB : 'Transaction is still editable. No invoice was printed yet for this transaction.'
    },
    'Fixed Description' : {
        de_DE : 'Transaktion ist nicht mehr änderbar. Bitte wenden Sie sich an den Organisator des Kongress, falls diese Bezahlung storniert werden soll.',
        en_GB : 'Transaction is not editable anymore. Please contact the organizer of the congress, if you want to cancel the transaction.'
    },
    'Refunded Description' : {
        de_DE : 'Transaktion ist als zurückerstattet markiert worden. Der Prozess der Rückerstattung kann einige Tage in Anspruch nehmen.',
        en_GB : 'Transaction is marked as refunded. The process of refund can last some days.'
    },
    'Canceled Description' : {
        de_DE : 'Transaktion ist storniert.',
        en_GB : 'Transaction is canceled.'
    },
    'Completed Description' : {
        de_DE : 'Transaktion wurde erfolgreich beglichen.',
        en_GB : 'Transaction was paid successfully.'
    },
    'Transactions Explanation'                               :{
        de_DE :'Gibt an, wie viele Transaktionen insgesamt für diesen Teilnehmer existieren.',
        en_GB :'Indicates how many transactions are created overall for this participant.'
    },
    'Open Transactions'                               :{
        de_DE :'Offene Transaktionen',
        en_GB :'Open Transactions'
    },
    'Open Transactions Explanation'                               :{
        de_DE :'Gibt an, wie viele Transaktionen dieses Teilnehmers noch nicht bezahlt sind.',
        en_GB :'Indicates how many transactions of this participant are not paid yet.'
    },
    'Sum'                               :{
        de_DE :'Summe',
        en_GB :'Sum'
    },
    'Sum Explanation'                               :{
        de_DE :'Gesamtsumme der Bezahlungen. Schließt zurückerstattete und stornierte Transaktionen aus.',
        en_GB :'Overall sum of transactions. Excludes refunded or canceled transactions.'
    },
    'Transaction Status'                               :{
        de_DE :'Status der Bezahlung',
        en_GB :'Transaction Status'
    },
    'Transaction List'                               :{
        de_DE :'Transaktionenliste',
        en_GB :'Transaction List'
    },
    'Transaction successfully updated.'                               :{
        de_DE :'Transaktion erfolreich aktualisiert.',
        en_GB :'Transaction successfully updated.'
    },
    'Bill Printing Information'                               :{
        de_DE :'Information zum Ausdrucken der Rechnung',
        en_GB :'Bill Printing Information'
    },
    'Bill Printing Information Text'                               :{
        de_DE :'Wenn Sie die Rechnung ausdrucken, wird diese Rechnung eingefroren und muss mit den ausgewählten Positionen bezahlt werden. ' +
            'Sie können nachträglich keine Änderungen mehr an der Rechnung vornehmen. Sie können allerdings nach wie ' +
            'vor weitere Leistungen hinzubuchen. Zu diesen weiteren Leistungen wird dann jeweils wieder eine neue ' +
            'Rechnung erstellt, die einzeln bezahlt werden kann.',
        en_GB :'If you print the invoice, the invoice will be fixed. ' +
            'You cannot make changes to this invoice anymore. ' +
            'If applicable you can book more options in the participation form. ' +
            'For the additionally booked options a new invoice will be created, that you have to pay on its own.'
    },
    'To print an invoice for this transaction please change the status to FIXED'                              :{
        de_DE : 'Um eine Rechnung zu drucken, ändern Sie den Status bitte auf FIXED',
        en_GB : 'To print an invoice for this transaction please change the status to FIXED'
    },
    'Refund Confirmation Text'                               :{
        de_DE :'Sind Sie sicher, dass Sie die Bezahlung zurückerstatten möchten? ' +
            'Dadurch wird die PayPal Bezahlung rückgängig gemacht und das Geld an den Teilnehmer zurückgeschickt. ' +
            'Dieser Vorgang kann einige Tage dauern, bis das Geld komplett zurückerstattet ist.',
        en_GB :'Are you sure that you want to refund the payment? ' +
            'The PayPal payment will be reverted and the money will be sent back to the participant.' +
            'This process could last some days till the money is refunded completely.'
    },
    'Transaction Summary'                     :{
        de_DE :'Zusammenfassung der Bezahlung',
        en_GB :'Transaction Summary'
    },
    'Pay'                                     :{
        de_DE : 'Bezahlung <br/>&uuml;ber PayPal',
        en_GB : 'Payment <br/>via PayPal'
    },
    'Print Invoice'                              :{
        de_DE :'Rechnung<br/>drucken',
        en_GB :'Print<br/>Invoice'
    },
    'Invoice'                              :{
        de_DE :'Rechnung',
        en_GB :'Invoice'
    },
    'No transactions found.'                  :{
        de_DE :'Keine Bezahlungen vorhanden.',
        en_GB :'No transactions found.'
    },
    'Back to Payment'                         :{
        de_DE :'Zur&uuml;ck zur Bezahlseite',
        en_GB :'Back to Payment'
    },
    'Conclude Payment'                        :{
        de_DE :'Bezahlung abschlie&szlig;en',
        en_GB :'Conclude Payment'
    },
    'Payment is in progress.'                 :{
        de_DE :'Bezahlung wird durchgef&uuml;hrt.',
        en_GB :'Payment is in progress.'
    },
    'Payment was successful.'                 :{
        de_DE :'Die Bezahlung der Kongressgeb&uuml;hr war erfolgreich.',
        en_GB :'Payment was successful.'
    },
    'Payment was not successful. Please try again.' : {
        de_DE : 'Ihre Bezahlung war leider nicht erfolgreich. Bitte versuchen Sie es erneut.',
        en_GB : 'Payment was not successful. Please try again.'
    },
    'Forwarding to PayPal...'                 :{
        de_DE :'Sie werden zu PayPal weitergeleitet...',
        en_GB :'Forwarding to PayPal...'
    },
    //-------

    // Dashboard
    'Your Status'                             :{
        de_DE :'Ihr Status',
        en_GB :'Your Status'
    },
    'Registered since'                        :{
        de_DE :'Registriert seit',
        en_GB :'Registered since'
    },
    'Paid Status'                             :{
        de_DE :'Bezahl Status',
        en_GB :'Paid Status'
    },
    'Abstracts submitted/ created'                     :{
        de_DE :'Abstracts eingereicht/ angelegt',
        en_GB :'Abstracts submitted/ created'
    },
    'VIP Status for this congress.'           :{
        de_DE :'F&uuml;r diesen Kongress VIP Status.',
        en_GB :'VIP Status for this congress.'
    },
    'Only participation status is inclusive.'           :{
        de_DE :'Nur der Teilnahmestatus ist inklusive.',
        en_GB :'Only participation status is inclusive.'
    },
    //-------

    // Abstract Submission
    'Abstract Submission'                     :{
        de_DE :'Abstract Einreichung',
        en_GB :'Abstract Submission'
    },
    'Please wait, submission is in progress...'                     :{
        de_DE :'Bitte warten, Einreichung wird durchgeführt...',
        en_GB :'Please wait, submission is in progress...'
    },
    'Author'                                  :{
        de_DE :'Autor',
        en_GB :'Author'
    },
    'not submitted yet'                       :{
        de_DE :'noch nicht eingereicht',
        en_GB :'not submitted yet'
    },
    'Submitted'                               :{
        de_DE :'Submitted',
        en_GB :'Submitted'
    },
    'No Abstracts created yet.'               :{
        de_DE :'Bisher keine Abstracts angelegt.',
        en_GB :'No Abstracts created yet.'
    },
    'Create'                                  :{
        de_DE :'Neu',
        en_GB :'Create'
    },
    'Words'                                   :{
        de_DE :'W&ouml;rter',
        en_GB :'Words'
    },
    'Authors'                                 :{
        de_DE :'Autoren',
        en_GB :'Authors'
    },
    'Summary'                                 :{
        de_DE :'Zusammenfassung',
        en_GB :'Summary'
    },
    'Abstract'                                :{
        de_DE :'Abstract',
        en_GB :'Abstract'
    },
    'Submit'                                  :{
        de_DE :'Submit',
        en_GB :'Submit'
    },
    'Save without Submit'                     :{
        de_DE :'Speichern<br/>ohne Submit',
        en_GB :'Save without<br/>Submit'
    },
    'service/paper/participation/papers/print':{
        de_DE :'service/paper/participation/papers/print',
        en_GB :'service/paper/participation/papers/print'
    },
    'Preview'                                 :{
        de_DE :'Vorschau',
        en_GB :'Preview'
    },
    'Delete'                                  :{
        de_DE :'L&ouml;schen',
        en_GB :'Delete'
    },
    'Author Creation'                         :{
        de_DE :'Autoren Erzeugung',
        en_GB :'Author Creation'
    },
    'Check author as presenter'               :{
        de_DE :'Autor als Presenter markieren',
        en_GB :'Check author as presenter'
    },
    'Abstract Creation'                       :{
        de_DE :'Abstract Erzeugung',
        en_GB :'Abstract Creation'
    },
    'of'                              :{
        de_DE :'von',
        en_GB :'of'
    },
    'words left.'                            :{
        de_DE :'W&ouml;rtern &uuml;brig.',
        en_GB :'words left.'
    },
    'character left.' : {
        de_DE : 'Zeichen &uuml;brig.',
        en_GB : 'character left.'
    },
    'Finish'                                  :{
        de_DE :'Fertig',
        en_GB :'Finish'
    },
    'Cancel'                                  :{
        de_DE :'Abbrechen',
        en_GB :'Cancel'
    },
    'Add Author'                              :{
        de_DE :'Autor<br/>Hinzuf&uuml;gen',
        en_GB :'Add Author'
    },
    'Update Author'                           :{
        de_DE :'Updaten',
        en_GB :'Update'
    },
    'Remove Author'                           :{
        de_DE :'Autor<br/>Entfernen',
        en_GB :'Remove<br/>Author'
    },
    'Author Up'                           :{
        de_DE :'Autor<br/>hoch',
        en_GB :'Author up'
    },
    'Author Down'                           :{
        de_DE :'Autor<br/>runter',
        en_GB :'Author down'
    },
    'Body'                                    :{
        de_DE :'Body',
        en_GB :'Body'
    },
    'Topic'                                   :{
        de_DE :'Titel',
        en_GB :'Topic'
    },
    'Reference'                               :{
        de_DE :'Referenz',
        en_GB :'Reference'
    },
    'References'                              :{
        de_DE :'Referenzen',
        en_GB :'References'
    },
    'Keywords References'                     :{
        de_DE :'Keywords Referenzen',
        en_GB :'Keywords References'
    },

    'Street'                                                                       :{
        de_DE :'Stra&szlig;e/Nr.',
        en_GB :'Street/No.'
    },
    'Street Label'                                                                 :{
        de_DE :'Straße',
        en_GB :'Street'
    },
    'Code */City *'                                                                :{
        de_DE :'PLZ */Stadt *',
        en_GB :'Code */City *'
    },
    'Country'                                                                      :{
        de_DE :'Land',
        en_GB :'Country'
    },
    'Country Explanantion' : {
        de_DE :'Bitte benutzen Sie zur Filterung die ISO Codes der Länder.',
        en_GB :'For filtering please use the ISO codes of the countries.'
    },
    'Successfully deleted your abstract.'                                          :{
        de_DE :'Abstract erfolgreich gel&ouml;scht.',
        en_GB :'Successfully deleted your abstract.'
    },
    'Successfully submitted your abstract.'                                        :{
        de_DE :'Abstract erfolgreich eingereicht.',
        en_GB :'Successfully submitted your abstract.'
    },
    'There are data missing in your abstract. Please review your abstract by clicking the "Preview" Button to check if all data (authors, references, topic and body) is saved.' : {
        de_DE : 'In Ihrem Abstract fehlen Daten. Bitte überprüfen Sie Ihr Abstract, indem Sie den Knopf "Vorschau" drücken, ob alle Daten (Autoren, Referenzen, Titel und Inhalt) gespeichert sind.',
        en_GB : 'There are data missing in your abstract. Please review your abstract by clicking the "Preview" Button to check if all data (authors, references, topic and body) is saved.'
    },
    'Abstract successfully created.'                                               :{
        de_DE :'Abstract erfolgreich angelegt.',
        en_GB :'Abstract successfully created.'
    },
    'Do you want to submit your abstract now?'                              :{
        de_DE :'Wollen Sie Ihr Abstract jetzt einreichen?',
        en_GB :'Do you want to submit your abstract now?'
    },
    'Are you sure you want to cancel the abstract creation? All data will be lost!':{
        de_DE :'Sind Sie sicher, dass Sie Ihr Abstract l&ouml;schen wollen? Alle Daten gehen verloren!',
        en_GB :'Are you sure you want to cancel the abstract creation? All data will be lost!'
    },
    'Are you sure you want to remove this abstract?'                               :{
        de_DE :'Sind Sie sicher, dass Sie Ihr Abstract l&ouml;schen wollen?',
        en_GB :'Are you sure you want to remove this abstract?'
    },
    'New Author'                                                                   :{
        de_DE :'Neuer Author',
        en_GB :'New Author'
    },
    'No Authors'                                                                   :{
        de_DE :'Keine Autoren',
        en_GB :'No Authors'
    },
    'Successfully updated your Abstract.'                                          :{
        de_DE :'Erfolgreich Ihr Abstract aktualisiert.',
        en_GB :'Successfully updated your Abstract.'
    },
    'Error while updating your Abstract.'                                          :{
        de_DE :'Fehler bei der Aktualisierung Ihres Abstract.',
        en_GB :'Error while updating your Abstract.'
    },
    'Successfully updated Keyword.'                                                :{
        de_DE :'Erfolgreich Keyword aktualisiert.',
        en_GB :'Successfully updated Keyword.'
    },
    'Successfully updated Reference.'                                              :{
        de_DE :'Erfolgreich Referenz aktualisiert.',
        en_GB :'Successfully updated Reference.'
    },
    'Topic Selection'                                                              :{
        de_DE :'Themen<br/>Auswahl',
        en_GB :'Topic<br/>Selection'
    },
    'Topic Selection Header'                                                       :{
        de_DE :'Themen Auswahl',
        en_GB :'Topic Selection'
    },
    'Keyword Reference'                                                            :{
        de_DE :'Keywords<br/>Referenzen',
        en_GB :'Keywords<br/>References'
    },
    'No Authors created yet'                                                       :{
        de_DE :'Keine Autoren angelegt.',
        en_GB :'No Authors created yet'
    },
    'Submission Type'                                                              :{
        de_DE :'Art der Einreichung',
        en_GB :'Submission Type'
    },
    'Presentation'                                                                 :{
        de_DE :'Vortrag',
        en_GB :'Presentation'
    },
    'Poster'                                                                       :{
        de_DE :'Poster',
        en_GB :'Poster'
    },
    'Presentation or Poster'                                                       :{
        de_DE :'Vortrag oder Poster',
        en_GB :'Presentation or Poster'
    },
    'Poster or Presentation'                                                       :{
        de_DE :'Poster oder Vortrag',
        en_GB :'Poster or Presentation'
    },
    'No participation'                                                              :{
        de_DE :'Keine Teilnahme',
        en_GB :'No participation'
    },
    'References (optional)'                                                        :{
        de_DE :'Referenzen (optional)',
        en_GB :'References (optional)'
    },
    'Submission Type saved.'                                                       :{
        de_DE :'Art der Einreichung gespeichert.',
        en_GB :'Submission Type saved.'
    },
    'Reference successfully updated.'                                              :{
        de_DE :'Referenz erfolgreich aktualisiert.',
        en_GB :'Reference successfully updated.'
    },
    'Session selected.'                                                            :{
        de_DE :'Session ausgew&auml;hlt.',
        en_GB :'Session selected.'
    },
    'New Abstract created.'                                                        :{
        de_DE :'Ein neues Abstract angelegt.',
        en_GB :'New Abstract created.'
    },
    'PLEASE ALLOCATE YOUR ABSTRACT TO ONE OF THE FOLLOWING TOPICS'                 :{
        de_DE :'BITTE ORDNEN SIE IHR ABSTRACT EINEM DER FOLGENDEN THEMENGEBIETE ZU',
        en_GB :'PLEASE ALLOCATE YOUR ABSTRACT TO ONE OF THE FOLLOWING TOPICS'
    },
    'Sessions'                                                                     :{
        de_DE :'Themengebiete',
        en_GB :'Sessions'
    },
    'Submission Type / References'                                                 :{
        de_DE :'Art der Einreichung / Referenzen',
        en_GB :'Submission Type / References'
    },
    'Text'                                                                         :{
        de_DE :'Text',
        en_GB :'Text'
    },
    'No title yet'                                                                 :{
        de_DE :'Kein Titel',
        en_GB :'No title yet'
    },
    'on'                                                                           :{
        de_DE :'am',
        en_GB :'on'
    },
    'No Submission Type selected'                                                  :{
        de_DE :'Art der Einreichung nicht ausgew&auml;hlt',
        en_GB :'No Submission Type selected'
    },
    'No Session selected yet'                                                      :{
        de_DE :'Keine Session ausgew&auml;hlt',
        en_GB :'No Session selected yet'
    },
    'Session'                                                                      :{
        de_DE :'Session',
        en_GB :'Session'
    },
    'Abstract will be submitted as'                                                :{
        de_DE :'Abstract wird abgeschickt als',
        en_GB :'Abstract will be submitted as'
    },
    'Submitted as'                                                :{
        de_DE :'Einreicht als',
        en_GB :'Submitted as'
    },

    'Participant successfully marked as reviewer':{
        de_DE :'Teilnehmer erfolgreich als Gutachter markiert',
        en_GB :'Participant successfully marked as reviewer'
    },
    'Participant removed as reviewer'            :{
        de_DE :'Teilnehmer als Gutachter gelöscht',
        en_GB :'Participant removed as reviewer'
    },

    'Review successfully saved'         :{
        de_DE :'Gutachten erfolgreich gespeichert',
        en_GB :'Review successfully saved'
    },
    'Reviewed'                          :{
        de_DE :'Bewertet',
        en_GB :'Reviewed'
    },
    'Review Form'                       :{
        de_DE :'Gutachter Formular',
        en_GB :'Review Form'
    },
    'Rating'                            :{
        de_DE :'Bewertung',
        en_GB :'Rating'
    },
    'Recommendation'                    :{
        de_DE :'Empfehlung',
        en_GB :'Recommendation'
    },
    'Export as PDF'                    :{
        de_DE :'Als PDF<br/>exportieren',
        en_GB :'Export<br/>as PDF'
    },
    'Print as PDF'                    :{
        de_DE :'Als PDF<br/>drucken',
        en_GB :'Print<br/>as PDF'
    },
    'Print as ODT'                    :{
        de_DE :'Als ODT<br/>drucken',
        en_GB :'Print<br/>as ODT'
    },
    'Export as Word'                    :{
        de_DE :'Als Word<br/>exportieren',
        en_GB :'Export<br/>as Word'
    },
    'Check this participant as Reviewer':{
        de_DE :'Teilnehmer als Gutachter markieren',
        en_GB :'Check this participant as reviewer'
    },
    'Remove this participant as Reviewer':{
        de_DE :'Teilnehmer als Gutachter entfernen',
        en_GB :'Remove this participant as reviewer'
    },
    'Reviewer Registration'             :{
        de_DE :'Gutachter Registrierung',
        en_GB :'Reviewer Registration'
    },

    //-------

    'Technical Support' : {
        de_DE : 'Technischer Support: <a href=\"mailto:support@vcongress.de\">support@vcongress.de</a><br/>' +
            '(Für inhaltliche Fragen, wenden Sie sich bitte an die Veranstalter)',
        en_GB : 'Technical Support: <a href=\"mailto:support@vcongress.de\">support@vcongress.de</a><br/>' +
            '(For inquiries regarding the congress please contact the organizers)'
    },

    'Greeting':{
        de_DE :'<div style="width: 100%">' +
            '<span style="display: inline-block; width: 70%">Viele Gr&uuml;&szlig;e, <br/>Ihr Kongress-Organisationsteam und vCongress Team</span>' +
            '<span style="display: inline-block; width: 30%" align="right">' +
            '<a href="https://www.xing.com/companies/scisertec" target="_blank">' +
            '<img src="http://www.xing.com/img/xing/xe/corporate_pages/cp_button.png" width="98" height="23" border="0" title="SciSerTec" alt="SciSerTec" />' +
            '</a>' +
            '</span>' +
            '</div>',
        en_GB :'<div style="width: 100%">' +
            '<span style="display: inline-block; width: 70%">Best regards, <br/>your congress organization committee and vCongress Team</span>' +
            '<span style="display: inline-block; width: 30%" align="right">' +
            '<a href="https://www.xing.com/companies/scisertec" target="_blank">' +
            '<img src="http://www.xing.com/img/xing/xe/corporate_pages/cp_button.png" width="98" height="23" border="0" title="SciSerTec" alt="SciSerTec" />' +
            '</a>' +
            '</span>' +
            '</div>'
    },
    'For detailed information about your participation please click on the pdf symbol' : {
        de_DE : 'Für detailierte Information über Ihre Teilnahme klicken Sie bitte auf das PDF Zeichen rechts',
        en_GB : 'For detailed information about your participation please click on the pdf symbol to the right'
    },
    'You can print your bill by clicking on the pdf symbol' : {
        de_DE : 'Sie können Ihre Rechnung anzeigen, indem Sie auf das PDF Zeichen klicken',
        en_GB : 'You can print your invoice by clicking on the pdf symbol'
    },
    'Print Summary' : {
        de_DE : 'Überblick<br/>ansehen/<br/>drucken',
        en_GB : 'Print/ View<br/>Summary'
    },
    'Information about the choosable options!' :{
        de_DE : 'Information über die wählbaren Optionen!',
        en_GB : 'Information about the choosable options!'
    },
    'Some options may be locked, for the fact that you already paid them.' : {
        de_DE : 'Einige Optionen können gesperrt sein. Das hat den Grund, dass Sie diese Optionen bereits bezahlt haben.<br/><br/>' +
            'Bei Stornierung oder Änderungswünschen richten Sie sich bitte an den Organisator.',
        en_GB : 'Some options may be locked, for the fact that you already paid them. ' +
            'If you wish to cancel or change some orderings please contact the organizer.'
    },


    'Picture Upload' : {
        de_DE : 'Bild Upload',
        en_GB : 'Picture Upload'
    },
    'Select Picture...' : {
        de_DE : 'Bild w&auml;hlen...',
        en_GB : 'Select Picture...'
    },
    'Upload' : {
        de_DE : 'Hochladen',
        en_GB : 'Upload'
    },
    'Preview of your uploaded picture below' : {
        de_DE : 'Unten sehen Sie eine Vorschau von Ihrem Bild:',
        en_GB : 'Preview of your uploaded picture below:'
    },
    'Uploading your picture...' : {
        de_DE : 'Ihr Bild wird hochgeladen...',
        en_GB : 'Uploading your picture...'
    },
    'Picture successfully uploaded.' : {
        de_DE : 'Bild erfolgreich hochgeladen.',
        en_GB : 'Picture successfully uploaded.'
    },
    'Upload Error' : {
        de_DE : 'Ihr Bild ist entweder zu groß oder hat einen falschen Dateitypen.<br/>' +
            'Nur PNG, GIF, JPG oder BMP Dateien erlaubt mit einer maximalen Größe von 5MB.',
        en_GB : 'Your picture is either too big in size or has the wrong file type.<br/>' +
            'Only PNG, GIF, JPG or BMP allowed with a filesize of max 5MB.'
    },
    'Picture deleted.' : {
        de_DE : 'Bild gel&ouml;scht.',
        en_GB : 'Picture deleted.'
    },
    'Picture added' : {
        de_DE : 'Bild hinzugef&uuml;gt',
        en_GB : 'Picture added'
    },
    'No picture added' : {
        de_DE : 'Kein Bild hinzugef&uuml;gt',
        en_GB : 'No picture added'
    },
    'Download Picture' : {
        de_DE : 'Bild<br/>anzeigen',
        en_GB : 'Download<br/>picture'
    },
    'Allowed file types are BMP, JPG, GIF and PNG. Maximum file size is 5MB.' : {
        de_DE : 'Als Bildformate sind JPG, PNG, BMP und GIF erlaubt. Maximale Dateigröße sind 5MB.',
        en_GB : 'Allowed file types are BMP, JPG, GIF and PNG. Maximum file size is 5MB.'
    },

    'Review Statistic' : {
        de_DE : 'Gutachten Statistik',
        en_GB : 'Review Statistic'
    },
    'Not reviewed yet' : {
        de_DE : 'Noch nicht bewertet',
        en_GB : 'Not reviewed yet'
    },
    'Not reviewed' : {
        de_DE : 'Nicht bewertet',
        en_GB : 'Not reviewed'
    },
    'Abstract Statistic' : {
        de_DE : 'Abstract Statistik',
        en_GB : 'Abstract Statistic'
    },
    'Please select a session.' : {
        de_DE : 'Bitte ein Thema ausw&auml;hlen.',
        en_GB : 'Please select a session.'
    },
    'Session Statistic' : {
        de_DE : 'Themen Statistik',
        en_GB : 'Session Statistic'
    },
    'Abstracts overall' : {
        de_DE : 'Abstracts gesamt',
        en_GB : 'Abstracts overall'
    },

    'Statistic' : {
        de_DE : 'Statistik',
        en_GB : 'Statistic'
    },

    'Invoice Book' : {
        de_DE : 'Rechnungs-<br/>Buch',
        en_GB : 'Invoice Book'
    },

    'Invoice Number' : {
        de_DE : 'Rechnungsnummer',
        en_GB : 'Invoice Number'
    },

    'Payment Type' : {
        de_DE : 'Art der Bezahlung',
        en_GB : 'Payment Type'
    },

    'Form is valid' : {
        de_DE : '<h1 style="margin-left: 20px;">Eingaben sind vollständig</h1>',
        en_GB : '<h1 style="margin-left: 20px;">Form is valid</h1>'
    },
    'Form has invalid input' : {
        de_DE : '<h1 style="margin-left: 20px;">Fehlerhafte Eingaben im Formular</h1>',
        en_GB : '<h1 style="margin-left: 20px;">Form has invalid input</h1>'
    },
    'Completion-Helper': {
        de_DE : 'Vervollständigungs-Assistent',
        en_GB : 'Completion-Helper'
    },
    'You must accept the Disclaimer': {
        de_DE : 'Sie müssen den Haftungshinweisen zustimmen',
        en_GB : 'You must accept the Disclaimer'
    },

    'Please select a statistic in the upper toolbar.' : {
        de_DE : 'Bitte wählen Sie eine Statistik aus der oberen Toolbar.',
        en_GB : 'Please select a statistic in the upper toolbar.'
    },
    'Show Statistic' : {
        de_DE : 'Zeige Statistik',
        en_GB : 'Show Statistic'
    },
    'January' : {
        de_DE : 'Januar',
        en_GB : 'January'
    },
    'February' : {
        de_DE : 'Februar',
        en_GB : 'February'
    },
    'March' : {
        de_DE : 'März',
        en_GB : 'March'
    },
    'April' : {
        de_DE : 'April',
        en_GB : 'April'
    },
    'May' : {
        de_DE : 'Mai',
        en_GB : 'May'
    },
    'June' : {
        de_DE : 'Juni',
        en_GB : 'June'
    },
    'July' : {
        de_DE : 'Juli',
        en_GB : 'July'
    },
    'August' : {
        de_DE : 'August',
        en_GB : 'August'
    },
    'September' : {
        de_DE : 'September',
        en_GB : 'September'
    },
    'October' : {
        de_DE : 'Oktober',
        en_GB : 'October'
    },
    'November' : {
        de_DE : 'November',
        en_GB : 'November'
    },
    'December' : {
        de_DE : 'Dezember',
        en_GB : 'December'
    },

    'Choose Statistic' : {
        de_DE : 'Statistik wählen',
        en_GB : 'Choose Statistic'
    },
    'Choose Year' : {
        de_DE : 'Jahr wählen',
        en_GB : 'Choose Year'
    },
    'Choose Month' : {
        de_DE : 'Monat wählen',
        en_GB : 'Choose Month'
    },

    'Amount' : {
        de_DE : 'Anzahl',
        en_GB : 'Amount'
    },

    'Participant registered' : {
        de_DE : 'Teilnehmer angemeldet',
        en_GB : 'Participant registered'
    },
    'User logged in' : {
        de_DE : 'Benutzer eingeloggt',
        en_GB : 'User logged in'
    },
    'Abstract submitted' : {
        de_DE : 'Abstract eingereicht',
        en_GB : 'Abstract submitted'
    },
    'Abstract created' : {
        de_DE : 'Abstract angelegt',
        en_GB : 'Abstract created'
    },
    'Payment via PayPal' : {
        de_DE : 'Bezahlung über PayPal',
        en_GB : 'Payment via PayPal'
    },
    'Review updated' : {
        de_DE : 'Gutachten gespeichert',
        en_GB : 'Review updated'
    },

    'Incomplete input for Statistic.' : {
        de_DE : 'Unvollständige Eingabe für die Statistik.',
        en_GB : 'Incomplete input for Statistic.'
    },

    'Fee for this congress' : {
        de_DE : 'Gebühr für diesen Kongress',
        en_GB : 'Fee for this congress'
    },

    'Comment' : {
        de_DE : 'Kommentar',
        en_GB : 'Comment'
    },

    'Are you sure you want to import the participants? A notification mail will also be sent to every imported participant.' : {
        de_DE : 'Sind Sie sicher, dass Sie die Teilnehmer importieren wollen? Es wird außerdem eine automatische Benachrichtigunsmail an alle importierten Teilnehmer verschickt.',
        en_GB : 'Are you sure you want to import the participants? A notification mail will be sent also to every imported participant.'
    },

    'Download Template' : {
        de_DE : 'Muster<br/>downloaden',
        en_GB : 'Download<br/>Template'
    },
    'Execute' : {
        de_DE : 'Ausführen',
        en_GB : 'Execute'
    },
    'Select .xlsx or .xls file...' : {
        de_DE : 'Bitte .xlsx oder .xls Datei auswählen...',
        en_GB : 'Select .xlsx or .xls file...'
    },
    'No participants to import' : {
        de_DE : 'Keine zu importierenden Teilnehmer',
        en_GB : 'No participants to import'
    },
    'Reading participants...' : {
        de_DE : 'Teilnehmer werden gelesen...',
        en_GB : 'Reading participants...'
    },
    'Please wait' : {
        de_DE : 'Please wait',
        en_GB : 'Please wait'
    },
    'Reading...' : {
        de_DE : 'Lese...',
        en_GB : 'Reading...'
    },
    'Participants successfully read.' : {
        de_DE : 'Teilnehmer erfolgreich gelesen.',
        en_GB : 'Participants successfully read.'
    },
    'Error while reading' : {
        de_DE : 'Fehler beim Lesen.',
        en_GB : 'Error while reading.'
    },
    'Participant import canceled.' : {
        de_DE : 'Teilnehmer Import abgebrochen.',
        en_GB : 'Participant import canceled.'
    },
    'Executing import of participants...' : {
        de_DE : 'Führe Teilnehmer Import durch...',
        en_GB : 'Executing import of participants...'
    },
    'Importing...' : {
        de_DE : 'Importiere...',
        en_GB : 'Importing...'
    },
    'Participant import successfully executed' : {
        de_DE : 'Teilnehmer Import erfolgreich durchgeführt',
        en_GB : 'Participant import successfully executed'
    },
    'Participant import failed. There are errors in the data of some participants.' : {
        de_DE : 'Teilnehmer Import fehlgeschlagen. Es sind Fehler in den Daten von einem oder mehreren Teilnehmern.',
        en_GB : 'Participant import failed. There are errors in the data of some participants.'
    },
    'Error in row' : {
        de_DE : 'Fehler in Zeile ',
        en_GB : 'Error in row '
    },

    'Organizer Editation' : {
        de_DE : 'Organizer Bearbeitung',
        en_GB : 'Organizer Editation'
    },
    'Please note' : {
        de_DE : 'Bitte beachten',
        en_GB : 'Please note'
    },
    'You are editing the participant:' : {
        de_DE : 'Sie bearbeiten den Teilnehmer:',
        en_GB : 'You are editing the participant:'
    },

    'INCOMPLETE' : {
        de_DE : 'UNVOLLSTÄNDIG',
        en_GB : 'INCOMPLETE'
    },
    'UNSURE' : {
        de_DE : 'UNSICHER',
        en_GB : 'UNSURE'
    },
    'CANDIDATE' : {
        de_DE : 'KANDIDAT',
        en_GB : 'CANDIDATE'
    },
    'Completion' : {
        de_DE : 'Vollständigkeit',
        en_GB : 'Completion'
    },

    'Do you want to exclude the abstract now? It will return to the Open Abstract List and is again editable by the author.' : {
        de_DE : 'Wollen Sie das Abstract wirklich ausschließen? Das Abstract wird in die Offene Abstract Liste verschoben und ist durch den Autoren wieder bearbeitbar.',
        en_GB : 'Do you want to exclude the abstract now? It will return to the Open Abstract List and is editable again by the author.'
    },
    'Successfully excluded the abstract.' : {
        de_DE : 'Abstract erfolgreich ausgeschlossen.',
        en_GB : 'Successfully excluded the abstract.'
    },
    'Exclude Abstract' : {
        de_DE : 'Abstract ausschließen',
        en_GB : 'Exclude Abstract'
    },
    'Successfully submitted the abstract.' : {
        de_DE : 'Das Abstract ist erfolgreich eingereicht.',
        en_GB : 'Successfully submitted the abstract.'
    },
    'Do you want to submit the abstract now? Please note that you submit the abstract in the name of the participant.' : {
        de_DE : 'Wollen Sie das Abstract wirklich einreichen? Bitte beachten Sie, dass Sie das Abstract im Namen des Teilnehmers einreichen.',
        en_GB : 'Do you want to submit the abstract now? Please note that you submit the abstract in the name of the participant.'
    },
    'Open Abstract List' : {
        de_DE : 'Offene Abstracts Liste',
        en_GB : 'Open Abstract List'
    },
    'Reviewer comment' : {
        de_DE : 'Gutachter-Kommentar',
        en_GB : 'Reviewer comment'
    },

    'Submitter' :{
        de_DE : 'Einreichender',
        en_GB : 'Submitter'
    },
    'First Author' : {
        de_DE : 'Erstautor',
        en_GB : 'First Author'
    },
    'Presenter Author' : {
        de_DE : 'Presenter Autor',
        en_GB : 'Presenter Author'
    },

    '(no tax)' : {
        de_DE : '(keine MwSt.)',
        en_GB : '(no tax)'
    },
    '(incl. tax)' : {
        de_DE : '(inkl. MwSt.)',
        en_GB : '(incl. tax)'
    },


    'No contributions uploaded yet.' : {
        de_DE : 'Bisher wurde noch kein Vortrag hochgeladen.',
        en_GB : 'No talk uploaded yet.'
    },
    'Contributions' : {
        de_DE : 'Vorträge',
        en_GB : 'Talks'
    },
    'Upload Error Contribution' : {
        de_DE : 'Ihr Vortrag ist entweder zu groß oder hat einen falschen Dateitypen.<br/>' +
            'Nur PDF Dateien erlaubt mit einer maximalen Größe von 10MB.',
        en_GB : 'Your talk is either too big in size or has the wrong file type.<br/>' +
            'Only PDF allowed with a filesize of max 10MB.'
    },
    'Contribution successfully uploaded.' : {
        de_DE : 'Vortrag erfolgreich hochgeladen.',
        en_GB : 'Talk successfully uploaded.'
    },
    'Delete Contribution' : {
        de_DE : 'Vortrag löschen',
        en_GB : 'Delete talk'
    },
    'Contribution deleted.' : {
        de_DE : 'Vortrag gelöscht.',
        en_GB : 'Talk deleted.'
    },
    'Contribution Deletion Help' : {
        de_DE : 'Falls Sie ein hochgeladenes PDF löschen möchten, suchen Sie Ihr PDF in der Liste.' +
            'Danach klicken Sie bitte mit der rechten Maustaste darauf und wählen "Vortrag löschen".',
        en_GB : 'If you want to delete an uploaded PDF, find it in the list below. ' +
            'Please click on the right mouse button and choose "Delete talk".'
    },
    'Uploading your contribution...' : {
        de_DE : 'Ihr Vortrag wird hochgeladen...',
        en_GB : 'Uploading your talk...'
    },
    'Upload a contribution - for speaker only' : {
        de_DE : 'Laden Sie einen Vortrag hoch - nur für Referenten',
        en_GB : 'Upload a talk - for speaker only'
    },
    'Contributions for this congress' : {
        de_DE : 'Vorträge für diesen Kongress',
        en_GB : 'Talks for this congress'
    },
    'Select PDF...' : {
        de_DE : 'Wähle PDF...',
        en_GB : 'Select PDF...'
    },
    'Please upload PDF files only. Maximum file size: 10MB. One PDF per speaker only.' : {
        de_DE : 'Bitte laden Sie nur PDF Dateien hoch. Maximale Dateigröße: 10MB.',
        en_GB : 'Please upload PDF files only. Maximum file size: 10MB.'
    },
    'Title of talk' : {
        de_DE : 'Titel des Vortrags',
        en_GB : 'Title of talk'
    },
    'Short description or keywords' : {
        de_DE : 'Kurze Beschreibung oder Schlagwörter',
        en_GB : 'Short description or keywords'
    },
    'You already uploaded a contribution. You can delete the old one or just upload a new one. The old contribution will be overwritten.' : {
        de_DE : 'Sie haben bereits einen Vortrag hochgeladen. Sie können Ihr Altes löschen oder ein Neues hochladen. Der alte Vortrag wird überschrieben.',
        en_GB : 'You already uploaded a talk. You can delete the old one or just upload a new one. The old talk will be overwritten.'
    },
    'Uploaded by' : {
        de_DE : 'Hochgeladen von',
        en_GB : 'Uploaded by'
    },
    'Click to download the PDF': {
        de_DE : 'Klicken, um das PDF herunterzuladen',
        en_GB : 'Click to download the PDF'
    },

    'Supporter Text': {
        de_DE : 'Das Projekt vCongress wird mit Mitteln des ' +
            '<span style="border-bottom: 1px dotted #000000;"><abbr title="europäischen Fonds für regionale Entwicklung">europäischen Fonds</abbr></span>' +
            ' gefördert' +
            '<a href="http://www.scisertec.de/supporter.html" target="_blank"> ...mehr erfahren</a>',
        en_GB : 'The vCongress project is funded by the ' +
            '<span style="border-bottom: 1px dotted #000000;"><abbr title="European Fond for Regional Development">European Fond</abbr></span>' +
            '<a href="http://www.scisertec.de/en/supporter.html" target="_blank"> ...read more</a>'
    },
    'SciSerTec Team Page' : {
        de_DE: 'http://www.scisertec.de/contact.html',
        en_GB: 'http://www.scisertec.de/en/contact.html'
    },
    'Company name' : {
        de_DE : 'Firmenname',
        en_GB : 'Company name'
    },
    'Full name' : {
        de_DE : 'Vor- und Nachname',
        en_GB : 'Full name'
    },

    'Participation successfully selected' : {
        de_DE : 'Auswahl der Teilnahme erfolgreich',
        en_GB : 'Participation successfully selected'
    },
    'Payment Forwarding Text' : {
        de_DE : 'Die Auswahl Ihrer Teilnahmedaten war erfolgreich. Wenn Sie jetzt die Bezahlung der ' +
            'Teilnahme vornehmen möchten, klicken Sie bitte auf den Button "Bezahlung".',
        en_GB : 'The selection of your participation data was successful. If you would like to pay now, ' +
            'please click on the button "Make Payment".'
    },
    'Pay later' : {
        de_DE : 'Später<br/>bezahlen',
        en_GB : 'Pay<br/>later'
    },
    'Make Payment Underneath' : {
        de_DE : 'Jetzt zur<br/>Bezahlung',
        en_GB : 'Make<br/>payment now'
    },
    'Invoice for bank transfer' : {
        de_DE : 'Rechnung für<br/>Bank Überweisung',
        en_GB : 'Invoice for<br/>bank transfer'
    },
    'Transfer to Abstract List' : {
        de_DE : 'In die Abstract Liste transferieren',
        en_GB : 'Transfer to Abstract List'
    },
    'Export as PDF File' : {
        de_DE : 'Als PDF Datei exportieren',
        en_GB : 'Export as PDF File'
    },
    'Abstract as PDF'                    :{
        de_DE :'Abstract<br/>als PDF',
        en_GB :'Abstract<br/>as PDF'
    },
    'Abstract as ODT'                    :{
        de_DE :'Abstract<br/>als ODT',
        en_GB :'Abstract<br/>as ODT'
    },
    'Export as ODT File' : {
        de_DE : 'Als ODT Datei exportieren',
        en_GB : 'Export as ODT File'
    },
    'Export as Word File' : {
        de_DE : 'Als Word Datei exportieren',
        en_GB : 'Export as Word File'
    },
    'Edit personal data' : {
        de_DE : 'Persönliche Daten editieren',
        en_GB : 'Edit personal data'
    },
    'Edit participation data' : {
        de_DE : 'Teilnahmedaten editieren',
        en_GB : 'Edit participation data'
    },
    'Successfully added reviewer' : {
        de_DE : 'Gutachter erfolgreich zugeteilt',
        en_GB : 'Successfully added reviewer'
    },
    'Successfully removed reviewer' : {
        de_DE : 'Gutachter entfernt',
        en_GB : 'Successfully removed reviewer'
    },
    'Something went wrong' : {
        de_DE : 'Irgendetwas lief falsch, bitte benachrichtigen Sie die Administratoren',
        en_GB : 'Something went wrong, please notify the administrators'
    },
    'Remove reviewer' : {
        de_DE : 'Gutachter entfernen',
        en_GB : 'Remove reviewer'
    },
    'Review was successfully submitted' : {
        de_DE : 'Gutachten wurde erfolgreich eingereicht',
        en_GB : 'Review was successfully submitted'
    },
    'Review not submitted yet' : {
        de_DE : 'Gutachten noch nicht erstellt',
        en_GB : 'Review not submitted yet'
    },
    'Assigned reviewer' : {
        de_DE : 'Zugewiesene Gutachter',
        en_GB : 'Assigned reviewer'
    },
    'Reviewer Assignment' : {
        de_DE : 'Gutachterzuteilung',
        en_GB : 'Reviewer Assignment'
    },
    'Assign' : {
        de_DE : 'Zuweisen',
        en_GB : 'Assign'
    },
    'Available reviewer' : {
        de_DE : 'Verfügbare Gutachter',
        en_GB : 'Available reviewer'
    },
    'Booked Tickets Text' : {
        de_DE : '<hr>' +
            '<div style="width: 450px;">' +
            '<div class="information_32x32" style="height: 32px; width: 32px; margin-right: 10px; display: inline-block"></div>' +
            '<div style="width: 400px; display: inline-block; font-size: 10px;"><b>{ticketCount} Ticket(s) für Begleitpersonen bereits gebucht.</b><br/>Falls Sie Tickets nachbuchen möchten, wählen Sie bitte die gewünschte Gesamtmenge aus und sichern Ihre Eingabe.</div>' +
            '</div>',
        en_GB : '<hr>' +
            '<div style="width: 450px;">' +
            '<div class="information_32x32" style="height: 32px; width: 32px; margin-right: 10px; display: inline-block"></div>' +
            '<div style="width: 400px; display: inline-block; font-size: 10px;"><b>{ticketCount} ticket(s) for companions already booked.</b><br/>If you want to book further tickets, please choose your desired overall amount and save your input.</div>' +
            '</div>'
    },
    'excellent' : {
        de_DE : 'excellent',
        en_GB : 'excellent'
    },
    'good' : {
        de_DE : 'good',
        en_GB : 'good'
    },
    'average' : {
        de_DE : 'average',
        en_GB : 'average'
    },
    'fair' : {
        de_DE : 'fair',
        en_GB : 'fair'
    },
    'poor' : {
        de_DE : 'poor',
        en_GB : 'poor'
    },
    'Save and proceed' : {
        de_DE : 'Speichern und<br/>fortfahren',
        en_GB : 'Save and<br/>proceed'
    },
    'Abstracts assigned to review' : {
        de_DE : 'Abstracts zur Begutachtung<br/>zugewiesen',
        en_GB : 'Abstracts assigned to review'
    },
    'Abstracts already reviewed' : {
        de_DE : 'Davon bereits begutachtet',
        en_GB : 'Abstracts already reviewed'
    },
    'Reviewer Status' : {
        de_DE : 'Gutachterstatus',
        en_GB : 'Reviewer Status'
    },
    'Dashboard Button' : {
        de_DE : '<h1>Dashboard</h1>' +
            'Sie sind eingeloggt.<br/>Jetzt zum Dashboard wechseln.',
        en_GB : '<h1>Dashboard</h1>' +
            'You are logged in<br/>Navigate to the dashboard.'
    },
    'Save changes' : {
        de_DE : 'Daten sichern',
        en_GB : 'Save changes'
    },
    'Save<br/>changes' : {
        de_DE : 'Daten<br/>sichern',
        en_GB : 'Save<br/>changes'
    },
    'Assign abstract to session' : {
        de_DE : 'Abstract dem<br/>Thema zuordnen',
        en_GB : 'Assign abstract<br/>to session'
    },
    'Preview as PDF' : {
        de_DE : 'Vorschau<br/>als PDF',
        en_GB : 'Preview<br/>as PDF'
    },
    'Preview as ODT' : {
        de_DE : 'Vorschau<br/>als ODT',
        en_GB : 'Preview<br/>as ODT'
    },
    'Submit the abstract' : {
        de_DE : 'Abstract<br/>einreichen',
        en_GB : 'Submit<br/>the abstract'
    },
    'Abstract Submission Text' : {
        en_GB: 'After having typed in all the information correctly and having checked ' +
            'its accuracy (you can print out a PDF or ODT file of the abstract), ' +
            'you can submit the abstract.<br/>' +
            '<span style="font-weight: bolder; color: red">Note: After submission no further changes to the abstract are ' +
            'possible. Submission is required so that the abstract becomes visible to the ' +
            'organizers and reviewers</span>.' +
            '<br/>Abstracts that have not been submitted will not be considered for ' +
            'the congress. The status of submitted abstracts can be viewed under the ' +
            'abstract button in the menu.',
        de_DE: 'Nachdem Sie alle Informationen eingegeben haben und die Korrektheit überprüft haben ' +
            '(Sie können das Abstract als PDF oder als ODT Datei drucken), ' +
            'haben Sie die Möglichkeit Ihr Abstract einzureichen.<br/>' +
            '<span style="font-weight: bolder; color: red">Beachten Sie: Nach der Einreichung können keine weiteren Änderungen mehr an dem Abstract ' +
            'vorgenommen werden. Die Einreichung ist erforderlich, damit das Abstract zur Gutachtung ' +
            'durch die Organisatoren und der Gutachter berücksichtigt werden kann.</span>' +
            '<br/>Bitte beachten Sie, dass alle Teilnehmer des Kongresses ihre Einwilligung geben, ' +
            'dass alle Fotografien, die während der Veranstaltung aufgenommen werden, ohne Kompensation von den Veranstaltern verwendet werden dürfen.'
    },
    'Export as CSV' : {
        de_DE : 'Exportieren<br/>als CSV',
        en_GB : 'Export<br/>as CSV'
    },
    'Abstract List as CSV' : {
        de_DE : 'Abstract Liste<br/>als CSV',
        en_GB : 'Abstract list<br/>as CSV'
    },
    'Abstract book as DOCX' : {
        de_DE : 'Abstract Buch<br/>als DOCX',
        en_GB : 'Abstract book<br/>as DOCX'
    },
    'Reset filter' : {
        de_DE : 'Filter<br/>zurücksetzen',
        en_GB : 'Reset<br/>filter'
    },
    'Imported' : {
        de_DE : 'Importiert',
        en_GB : 'Imported'
    },
    'Submission Date' : {
        de_DE : 'Datum der Einreichung',
        en_GB : 'Submission Date'
    },
    'Invoice book as ODT' : {
        de_DE : 'Rechnungen<br/>als ODT',
        en_GB : 'Invoice book<br/>as ODT'
    },
    'Transaction Editation' : {
        de_DE : 'Transaktion bearbeiten',
        en_GB : 'Transaction Editation'
    },
    'Pending Transaction' : {
        de_DE : 'Schwebende Transaktion',
        en_GB : 'Pending Transaction'
    },
    'Pending Transaction Explanation' : {
        de_DE : 'Zeigt an, dass der Teilnehmer noch keine Rechnung zu seinen auswählten Positionen gedruckt hat.' +
            'Sie können eine Rechnung drucken, indem Sie den Teilnehmer anklicken, danach auf die schwebende ' +
            'Transaktion klicken und den Status der Transaktion auf FIXED ändern.',
        en_GB : 'This indicates, that the participant did ' +
            'not print an invoice yet. You can print an invoice by clicking the participant, ' +
            'afterwords clicking the pending transaction und changing the Transaction Status ' +
            'to FIXED.'
    },
    'Participant List Title' : {
        de_DE : 'Teilnehmerliste - rechter Mausklick auf einen Teilnehmer für weitere Optionen - linker Mausklick für mehr Details',
        en_GB : 'Participant list - right mouse click on a participant for further options - left click for more details'
    },
    'Abstract List Title' : {
        de_DE : 'Abstractliste - rechter Mausklick auf ein Abstract für weitere Optionen - linker Mausklick für mehr Details',
        en_GB : 'Abstract list - right mouse click on an abstract for further options - left click for more details'
    },
    'Open Abstract List Title' : {
        de_DE : 'Offene Abstractliste - rechter Mausklick auf ein Abstract für weitere Optionen',
        en_GB : 'Open abstract list - right click on an abstract for further options'
    },
    'Transaction List Title' : {
        de_DE : 'Transaktionenliste - um alle Transaktionen eines Teilnehmers zu sehen mit der linken Maustaste auf einen Teilnehmer klicken',
        en_GB : 'Transaction list - to view all transactions of a participant click with the left mouse button on the participant'
    },
    'Review List Title' : {
        de_DE : 'Gutachterliste - Linksklick auf ein Abstract, um das Gutachterformular aufzurufen - Rechtsklick auf ein Abstract für weitere Optionen',
        en_GB : 'Review list - left click on an abstract to show up the reviewer form - right click on an abstract for further options'
    },
    'Do you really want to remove this participant as reviewer? Please note, all reviews will also be deleted.' : {
        de_DE : 'Wollen Sie den Teilnehmer wirklich als Gutachter abwählen? Bitte beachten Sie, es werden dadurch auch alle Gutachten gelöscht.',
        en_GB : 'Do you really want to remove this participant as reviewer? Please note, all reviews will also be deleted.'
    },
    'There are unsaved changes in forms' : {
        de_DE : 'In den folgenden Formularen sind ungesicherte Daten',
        en_GB : 'There are unsaved changes in following forms'
    },
    'please dont forget to save the data' : {
        de_DE : 'Bitte vergessen Sie nicht die Daten zu speichern',
        en_GB : 'Please don\'t forget to save the data'
    },
    'Save data' : {
        de_DE : 'Daten speichern',
        en_GB : 'Save data'
    }
};

var update_account = {
    'Text':{
        de_DE :'<h1>Passwort &auml;ndern</h1>' +
            'Um Ihr Passwort &auml;ndern zu k&ouml;nnen, m&uuml;ssen Sie Ihre aktuellen Kontodaten eingeben.',

        en_GB :'<h1>Change Password</h1>' +
            'In order to update your Password you must provide your actual Account Data.'
    }
};

var registration_status = {
    'Text':{
        de_DE :'<table width="400px" style="margin-left: 20px; margin-right: 20px; margin-top: 10px; margin-bottom: 10px"><tbody>' +
            '<tr style="border: solid #E0E0E0 2px; background: #F7F7F7; height: 30px;">' +
            '<td width="200px"><span style="font-size: 13px; margin-left: 15px;"><b>Status</b></span></td><td><span style="font-size: 13px;"><b>Preis</b></span></td></tr>' +
            '<tr style="border: solid #E0E0E0 2px; background: #F7F7F7; height: 30px;">' +
            '<td><span style="font-size: 12px; margin-left: 15px;"><b>Participation Status 1</b></span></td><td>300,00&euro;<br/>(keine MwSt.)</td></tr>' +
            '<tr style="border: solid #E0E0E0 2px; background: #F7F7F7; height: 30px;">' +
            '<td><span style="font-size: 12px; margin-left: 15px;"><b>Participation Status 2</b></span></td><td>150,00&euro;<br/>(keine MwSt.)</td></tr>' +
            '<tr style="border: solid #E0E0E0 2px; background: #F7F7F7; height: 30px;">' +
            '<td><span style="font-size: 12px; margin-left: 15px;"><b>Participation Status 3</b></span></td><td>30,00&euro;<br/>(keine MwSt.)</td></tr>' +
            '</tbody></table>',

        en_GB :'<table width="400px" style="margin-left: 20px; margin-right: 20px; margin-top: 10px; margin-bottom: 10px"><tbody>' +
            '<tr style="border: solid #E0E0E0 2px; background: #F7F7F7; height: 30px;">' +
            '<td width="200px"><span style="font-size: 13px; margin-left: 15px;"><b>Status</b></span></td><td><span style="font-size: 13px;"><b>Price</b></span></td></tr>' +
            '<tr style="border: solid #E0E0E0 2px; background: #F7F7F7; height: 30px;">' +
            '<td><span style="font-size: 12px; margin-left: 15px;"><b>Participation Status 1</b></span></td><td>300,00&euro;<br/>(no tax)</td></tr>' +
            '<tr style="border: solid #E0E0E0 2px; background: #F7F7F7; height: 30px;">' +
            '<td><span style="font-size: 12px; margin-left: 15px;"><b>Participation Status 2</b></span></td><td>150,00&euro;<br/>(no tax)</td></tr>' +
            '<tr style="border: solid #E0E0E0 2px; background: #F7F7F7; height: 30px;">' +
            '<td><span style="font-size: 12px; margin-left: 15px;"><b>Participation Status 3</b></span></td><td>30,00&euro;<br/>(no tax)</td></tr>' +
            '</tbody></table>'
    }
};

var payment = {
    'Text':{
        de_DE :'<div style="margin: 10px 50px 50px 50px;">' +
            '<h2>Bezahlung &uuml;ber Bank Überweisung:</h2>' +
            '<br/>Die Bezahlung der Konferenzgeb&uuml;hr verl&auml;uft entweder &uuml;ber PayPal oder per '+
            'Bank&uuml;berweisung.<br/>' +
            'Das Bankkonto finden Sie auf der entsprechenden Rechnung, die Sie unterhalb dieses Textes ausdrucken k&ouml;nnen.<br/>' +
            '<br/>' +
            '<h2>Bezahlung &uuml;ber PayPal:</h2>' +
            '<p><br/>' +
            '<table>' +
            '<tr><td style="vertical-align: top;"><span style="margin-right: 10px;">1.</span></td><td> Dr&uuml;cken Sie bitte den Knopf \'Bezahlung &uuml;ber PayPal\', um den Bezahlvorgang mit PayPal zu starten.<br/><br/></td></tr>' +
            '<tr><td style="vertical-align: top;"><span style="margin-right: 10px;">2a.</span></td><td>F&uuml;hren Sie Ihre Bezahlung mit Ihrem PayPal Konto durch.</td></tr>' +
            '<tr><td style="vertical-align: top;"><span style="margin-right: 10px;">2b.</span></td><td>Falls Sie nicht &uuml;ber ein PayPal Konto verf&uuml;gen, k&ouml;nnen Sie ein Konto w&auml;hrend Ihrer Sitzung anlegen.</td></tr>' +
            '<tr><td style="vertical-align: top;"><span style="margin-right: 10px;">2c.</span></td><td>Wenn Sie kein PayPal Konto anlegen wollen, k&ouml;nnen Sie auch eine Einzel-Bezahlung &uuml;ber PayPal durchf&uuml;hren.<br/><br/></td></tr>' +
            '<tr><td style="vertical-align: top;"><span style="margin-right: 10px;">3.</span></td><td>Auf dieser Seite k&ouml;nnen Sie Ihre Rechnung als PDF Dokument herunterladen.</td></tr>' +
            '</table>' +
            '</p>' +
            '</div> ',

        en_GB :'<div style="margin: 10px 50px 50px 50px;">' +
            '<h2>Payment via bank transfer:</h2>' +
            '<br/>Payment can be done via PayPal or bank transfer.<br/>' +
            'The bank account can be found on the corresponding invoice that you can print below. <br/>' +
            '<br/>' +
            '<h2>Payment via PayPal:</h2>' +
            '<p><br/>' +
            '<table>' +
            '<tr><td style="vertical-align: top;"><span style="margin-right: 10px;">1.</span></td><td>Press the button \'Payment via PayPal\' to initiate your payment via PayPal.<br/><br/></td></tr>' +
            '<tr><td style="vertical-align: top;"><span style="margin-right: 10px;">2a.</span></td><td>Make your payment via your PayPal account.</td></tr>' +
            '<tr><td style="vertical-align: top;"><span style="margin-right: 10px;">2b.</span></td><td>If you do not have an account you can create one during this session.</td></tr>' +
            '<tr><td style="vertical-align: top;"><span style="margin-right: 10px;">2c.</span></td><td>If you do not want a PayPal account you can choose to make a single payment only.<br/><br/></td></tr>' +
            '<tr><td style="vertical-align: top;"><span style="margin-right: 10px;">3.</span></td><td>You can download your invoice as PDF document from the vCongress payment area.</td></tr>' +
            '</table>' +
            '</p>' +
            '</div> '
    },

    'Payment Confirmation':{
        de_DE :
            '<table><tr><td><div class="shoppingcart_full_32x32" style="height: 32px; width: 32px; margin-right: 15px;"></div> </td><td><h1>Zusammenfassung</h1></td></tr></table>' +
            '<br/>' +
            'Bitte best&auml;tigen Sie die Bezahlung mit dem Button <b>"Bezahlung abschlie&szlig;en"</b>.' +
            '<br/>' +
            '<tpl for="data.items">' +
            '<div style="margin-top: 10px;">' +
            '<table style="height: 40px; background-color: #EFEFEF;">' +
            '<tr>' +
            '<td width="400px">' +
            '<div style="margin-left: 10px;">' +
            '<b>{data.description}</b><br/><tpl if="data.amount &gt; 1">{data.amount}x </tpl>{data.name}' +
            '</div>' +
            '</td>' +
            '<td width="100px" style="margin: 10px">' +
            '<div style="margin-left: 10px;">{data.price:currency("€",2,true)}' +
            '<tpl if="data.tax &gt; 0"> <br/>(inkl. MwSt.)</tpl>' +
            '<tpl if="data.tax == 0"> <br/>(keine MwSt.)</tpl>' +
            '</div>' +
            '</td>' +
            '</tr>' +
            '</table>' +
            '</div>' +
            '</tpl>',
        en_GB :
            '<table><tr><td><div class="shoppingcart_full_32x32" style="height: 32px; width: 32px; margin-right: 15px;"></div> </td><td><h1>Summary</h1></td></tr></table>' +
            '<br/>' +
            'Please confirm your payment by pressing the button <b>"Conclude Payment"</b>.' +
            '<br/>' +
            '<tpl for="data.items">' +
            '<div style="margin-top: 10px;">' +
            '<table style="height: 40px; background-color: #EFEFEF;">' +
            '<tr>' +
            '<td width="400px">' +
            '<div style="margin-left: 10px;">' +
            '<b>{data.description}</b><br/><tpl if="data.amount &gt; 1">{data.amount}x </tpl>{data.name}' +
            '</div>' +
            '</td>' +
            '<td width="100px" style="margin: 10px">' +
            '<div style="margin-left: 10px;">{data.price:currency("€",2,true)}' +
            '<tpl if="data.tax &gt; 0"> <br/>(incl. tax)</tpl>' +
            '<tpl if="data.tax == 0"> <br/>(no tax)</tpl>' +
            '</div>' +
            '</td>' +
            '</tr>' +
            '</table>' +
            '</div>' +
            '</tpl>'
    },
    'Payment Failed'      :{
        de_DE :'<table><tr><td><div class="warning_32x32" style="height: 32px; width: 32px; margin-right: 15px;"></div> </td><td><h1> Ihre Bezahlung war nicht erfolgreich. </h1></td></tr></table>',
        en_GB :'<table><tr><td><div class="warning_32x32" style="height: 32px; width: 32px; margin-right: 15px;"></div> </td><td><h1> Your payment was not successful. </h1></td></tr></table>'
    }
};

var abstractSubmission = {
    'Abstract Overview':{
        de_DE :'<div style="margin: 20px 50px 50px 50px">' +
            '<h1>Abstract Statusmeldungen</h1>' +
            '<br/>' +
            '<div style="text-align: justify">Hier finden Sie eine Übersicht über Ihre \"angelegten\" und \"eingereichten\" Abstracts. ' +
            'Sie können Ihr Abstract bearbeiten, indem Sie dieses unten in der Liste auswählen und danach den ' +
            'Button \"Abstract bearbeiten\" auf der linken Seite drücken. Sie müssen Ihr Abstract einreichen (\"submitten\") ' +
            'damit es von den Reviewern beurteilt werden kann. Nach dem Einreichen, können Sie keine Änderungen mehr am Abstract ' +
            'vornehmen.</div>' +
            '</div>',
        en_GB :'<div style="margin: 20px 50px 50px 50px">' +
            '<h1>Abstract Status</h1>' +
            '<br/>' +
            '<div style="text-align: justify">This is an overview of your \"created\" and \"submitted\" abstracts. You can edit your ' +
            'abstracts as long as they are not submitted. For editing an abstract click on the respective abstract below ' +
            'and afterwards choose the button \"Edit abstracts\" on the left side tool bar. You have to \"submit\" your ' +
            'abstract in the end. Otherwise it will not be available for the review process. After submission you can ' +
            'not edit your abstract anymore. </div>' +
            '</div>'
    }
};

var congress_title = {
    'Text':{
        de_DE :'<div align="right" style="margin-top: 15px;">' +
            '<h1>Kongress Titel - Zusätzliche Infos</h1>' +
            '<p>Irgendwas</p>' +
            '<p>Irgendwann, Irgendwo</p>' +
            '<a href="http://www.scisertec.de" target="_blank">http://www.scisertec.de</a>' +
            '</div>',

        en_GB :'<div align="right" style="margin-top: 15px;">' +
            '<h1>Congress Title - Additional info</h1>' +
            '<p>Somewhat</p>' +
            '<p>Somewhen, Somewhere</p>' +
            '<a href="http://www.scisertec.de" target="_blank">http://www.scisertec.de</a>' +
            '</div>'
    },
    'Smaller':{
        de_DE :'<h1>Kongress Titel - Zusätzliche Infos</h1>' +
            '<p>Irgendwann</p>' +
            '<p>Irgendwo</p>',

        en_GB : '<h1>Congress Title - Additional info</h1>' +
            '<p>Somewhen</p>' +
            '<p>Somewhere</p>'
    }
};


Locale = {};
Update_Account = {};
Registration_Status = {};
Payment = {};
Abstract = {};
Congress_Title = {};

var property;
for (property in locale) {
    Locale[property] = locale[property][params.lang];
}
for (property in update_account) {
    Update_Account[property] = update_account[property][params.lang];
}
for (property in registration_status) {
    Registration_Status[property] = registration_status[property][params.lang];
}
for (property in payment) {
    Payment[property] = payment[property][params.lang];
}
for (property in abstractSubmission) {
    Abstract[property] = abstractSubmission[property][params.lang];
}
for (property in congress_title) {
    Congress_Title[property] = congress_title[property][params.lang];
}