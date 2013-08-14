Ext.define('App.store.core.admin.Role', {
    extend: 'Ext.data.Store',

    requires : [
        'Ext.Ajax',
        'Ext.data.reader.Json'
    ],

    model : 'App.model.core.admin.Role',

    proxy: {
        type: 'ajax',
        url : 'service/role',
        reader: {
            type            : 'json',
            totalProperty   : 'total',
            successProperty : 'success',
            root            : 'data'
        }
    },
    autoLoad: false
});