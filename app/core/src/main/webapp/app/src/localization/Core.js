Ext.define('App.localization.Core', {

    singleton:true,

    'App.view.core.content.HomePanel':{
        title   :{
            de_DE:{
                title   :'Kongress Name',
                subTitle:'Kongress Zusatz',
                location:'Irgendwo'
            },
            en_GB:{
                title   :'Congress Name',
                subTitle:'Congress Addition',
                location:'Somewhere'
            }
        },
        welcome :{
            de_DE:{
                text:'Willkommen'
            },
            en_GB:{
                text:'Welcome'
            }
        },
        register:{
            de_DE:{
                title      :'Registrierung',
                description:'Falls Sie noch nicht registriert sind, dr&uuml;cken Sie bitte diesen Button'
            },
            en_GB:{
                title      :'Registration',
                description:'If you are not registered yet, please press this button'
            }
        },
        login   :{
            de_DE:{
                title      :'Anmelden',
                description:'Falls Sie sich schon registriert haben, k&ouml;nnen Sie sich hier wieder anmelden. '
            },
            en_GB:{
                title      :'Login',
                description:'If you are already registered you can login again here.'
            }
        },
        logout  :{
            de_DE:{
                title      :'Abmelden',
                description:'Bitte loggen Sie sich aus falls Sie sich neu anmelden oder registrieren wollen. '
            },
            en_GB:{
                title      :'Logout',
                description:'Please log out if you want to login or register again.'
            }
        },
        faq     :{
            de_DE:{
                text:'Frequently Asked Questions (FAQ) and Trouble Shooting'
            },
            en_GB:{
                text:'Frequently asked questions and Trouble shooting for vCongress'
            }
        },
        manual  :{
            de_DE:{
                text:'Benutzerhandbuch f&uuml;r Kongressteilnehmer'
            },
            en_GB:{
                text:'Manual for congress participants'
            }
        },
        greeting:{
            de_DE: {
                text : 'Viele Gr&uuml;&szlig;e, <br/>Ihr Kongress-Organisationsteam und vCongress Team'
            },
            en_GB: {
                text : 'Best regards, <br/>your congress organization committee and vCongress Team'
            }
        }
    }


});