Ext.define('App.view.core.content.TermsAndConditionsPanel', {
    extend: 'Ext.panel.Panel',
    alias : 'widget.content_TermsAndConditions',

    loader : {
        url: 'faces/view/content/terms_and_conditions.xhtml',
        autoLoad: true,
        loadMask: true
    }


});