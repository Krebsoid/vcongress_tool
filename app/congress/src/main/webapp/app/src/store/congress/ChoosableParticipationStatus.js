Ext.define('App.store.congress.ChoosableParticipationStatus', {
    extend: 'Ext.data.Store',

    requires : [
        'Ext.Ajax',
        'Ext.data.reader.Json'
    ],

    model : 'App.model.congress.ParticipationStatus',

    proxy: {
        type: 'ajax',
        url : 'service/participant/status',
        reader: {
            type            : 'json',
            totalProperty   : 'total',
            successProperty : 'success',
            root            : 'data'
        }
    },
    autoLoad: false
});