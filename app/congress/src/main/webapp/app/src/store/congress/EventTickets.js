Ext.define('App.store.congress.EventTickets', {
    extend: 'Ext.data.Store',

    requires : [
        'Ext.Ajax',
        'Ext.data.reader.Json'
    ],

    fields : ['id'],

    proxy: {
        type: 'ajax',
        url : 'service/participant/participation/active/eventtickets',
        reader: {
            type            : 'json',
            totalProperty   : 'total',
            successProperty : 'success',
            root            : 'data'
        }
    },
    autoLoad: false
});