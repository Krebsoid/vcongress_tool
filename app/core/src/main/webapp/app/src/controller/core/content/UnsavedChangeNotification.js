Ext.define('App.controller.core.content.UnsavedChangeNotification', {

    extend:'Ext.app.Controller',

    requires:[
        'Ext.ux.window.Notification'
    ],

    config:{
        forms: []
    },

    init:function () {

    },

    showNotification : function(msg) {
        this.getForms().push(msg);
        var formString = '';
        Ext.Array.each(this.getForms(), function(form) {
            formString += '<br/>&bull; ' + form;
        });
        Ext.create('widget.uxNotification', {
            corner: 'tr',
            cls: 'ux-notification-light',
            width: 200,
            height: 220,
            autoDestroyDelay: 4000,
            useXAxis: true,
            iconCls: 'ux-notification-icon-warn',
            html: '<h1>'+ Locale['Save data'] +'</h1><br/><h2>' +
                Locale['There are unsaved changes in forms']+ ':<br/>' + formString + '<br/><br/>'+ Locale['please dont forget to save the data'] +'!</h2>'

        }).show();
    },

    hideNotification : function (msg) {
        if(this.getForms().indexOf(msg) != -1) {
            this.getForms().splice(this.getForms().indexOf(msg),1);
        }
    }

});