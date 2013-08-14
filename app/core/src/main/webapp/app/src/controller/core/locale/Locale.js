Ext.define('App.controller.core.locale.Locale', {

    extend: 'Ext.app.Controller',

    views: [
        'core.locale.LocaleChooseToolbar',
        'Ext.util.Cookies'
    ],

    refs: [
        {
            ref: 'localeToolbar',
            selector: 'LocaleChoose'
        },
        {
            ref: 'germanButton',
            selector: 'LocaleChoose button[action=german]'
        },
        {
            ref: 'englishButton',
            selector: 'LocaleChoose button[action=english]'
        }

    ],

    init: function() {

        var params = Ext.urlDecode(window.location.search.substring(1));

        if(!Ext.isDefined(params.lang)) {
            Ext.util.Cookies.set('lang','en_GB', new Date(new Date().getTime()+(1000*60*60*24*30)));
        }
        else {
            Ext.util.Cookies.set('lang',params.lang, new Date(new Date().getTime()+(1000*60*60*24*30)));
        }

        this.control(
            {
                '#content': {
                    afterrender: this.loadLanguageToolbar
                },
                'LocaleChoose button[action=german]': {
                    click: this.germanLanguage
                },
                'LocaleChoose button[action=english]': {
                    click: this.englishLanguage
                },
                'content_home button[action=german]': {
                    click: this.germanLanguage
                },
                'content_home button[action=english]': {
                    click: this.englishLanguage
                }
            }
        );
    },

    germanLanguage : function() {
        Ext.util.Cookies.set('lang','de_DE', new Date(new Date().getTime()+(1000*60*60*24*30)));
        window.location.search = Ext.urlEncode({"lang":'de_DE'});
    },

    englishLanguage : function() {
        Ext.util.Cookies.set('lang','en_GB', new Date(new Date().getTime()+(1000*60*60*24*30)));
        window.location.search = Ext.urlEncode();
    },

    loadLanguageToolbar : function() {
        var params = Ext.urlDecode(window.location.search.substring(1));

        if(!Ext.isDefined(params.lang)) {
            this.getGermanButton().enable();
            this.getEnglishButton().disable();
        }
        else {
            this.getGermanButton().disable();
            this.getEnglishButton().enable();
        }
    }


});