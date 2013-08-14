Ext.define('App.view.core.content.ImprintPanel', {
    extend: 'Ext.panel.Panel',
    alias : 'widget.content_imprint',

    loader : {
        url: 'faces/view/content/imprint.xhtml',
        autoLoad: true,
        loadMask: true
    }

});