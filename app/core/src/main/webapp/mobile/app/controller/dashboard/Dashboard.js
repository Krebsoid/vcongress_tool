Ext.define('vCongress_Mobile.controller.dashboard.Dashboard', {
    extend: 'Ext.app.Controller',

    requires: [
        'Ext.Ajax'
    ],

    config: {
        views: [
            'dashboard.Dashboard'
        ],

        models: [
            'dashboard.Status'
        ],

        control: {

        },

        refs: {
              dashboard: 'dashboard'
        }
    },

    loadView: function() {
        Ext.Ajax.request({
            url     : '/service/dashboard',
            method  : 'GET',
            headers :  {
                'Accept'        : 'application/json'
            },
            scope   : this,
            success:function(options) {
                var decode = Ext.JSON.decode(options.responseText);
                if(Ext.isDefined(decode.data)) {
                    var participantStatus = Ext.create('vCongress_Mobile.model.dashboard.Status', decode.data);
                    this.getDashboard().setData(participantStatus.data);
                }
            }
        });
    }
});