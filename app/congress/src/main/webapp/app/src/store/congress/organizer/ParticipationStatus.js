Ext.define('App.store.congress.organizer.ParticipationStatus', {
    extend: 'Ext.data.Store',

    requires : [
        'Ext.Ajax',
        'Ext.data.reader.Json'
    ],

    model : 'App.model.congress.ParticipationStatus',

    proxy: {
        type: 'ajax',
        url : 'service/participant/status/all',
        reader: {
            type            : 'json',
            totalProperty   : 'total',
            successProperty : 'success',
            root            : 'data'
        }
    },
    autoLoad: false
});