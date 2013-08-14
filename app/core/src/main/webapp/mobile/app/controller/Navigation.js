Ext.define('vCongress_Mobile.controller.Navigation', {

    extend: 'Ext.app.Controller',

    requires    : [
        'Ext.Ajax',
        'Ext.data.reader.Json'
    ],

    config : {
        views: [
            'Main'
        ],

        refs: {
            content: 'main'
        }
    },

    init: function() {
        this.getApplication().getController('user.Authorization').on({
            login : this.navigateDashboard,
            scope : this
        });
    },

    navigateDashboard : function() {
        this.getContent().setActiveItem(1, {type: 'slide', direction: 'right'});
        this.getApplication().getController('dashboard.Dashboard').loadView();
    }

});