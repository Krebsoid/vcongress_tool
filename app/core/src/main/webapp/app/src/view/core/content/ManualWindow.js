Ext.define('App.view.core.content.ManualWindow', {
    extend: 'Ext.window.Window',
    alias : 'widget.content_ManualWindow',

    width : 700,
    height : 500,
    autoScroll : true,
    bodyStyle: {
        background: '#FFFFFF'
    },

    title : Locale['Manual'],

    loader : {
        url: 'faces/view/content/manual.xhtml',
        autoLoad: true,
        loadMask: true
    }

});