Ext.define('App.view.core.content.FaqWindow', {
    extend: 'Ext.window.Window',
    alias : 'widget.content_FaqWindow',

    width : 700,
    height : 500,
    autoScroll : true,
    bodyStyle: {
        background: '#FFFFFF'
    },

    title : Locale['Frequently asked questions and Trouble shooting for vCongress'],

    loader : {
        url: 'faces/view/content/faq.xhtml',
        autoLoad: true,
        loadMask: true
    }
});