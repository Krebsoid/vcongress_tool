Ext.define('App.view.core.content.TermsAndConditionsWindow', {
    extend: 'Ext.window.Window',
    alias : 'widget.content_TermsAndConditionsWindow',

    width : 500,
    height : 300,
    autoScroll : true,
    bodyStyle: {
        background: '#FFFFFF'
    },

    title : Locale['Terms and Conditions Title'],

    loader : {
        url: 'faces/view/content/terms_and_conditions.xhtml',
        autoLoad: true,
        loadMask: true
    }

});