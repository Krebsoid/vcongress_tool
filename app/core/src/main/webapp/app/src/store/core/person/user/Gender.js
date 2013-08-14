Ext.define('App.store.core.person.user.Gender', {
    extend: 'Ext.data.Store',

    requires : [
        'Ext.Ajax',
        'Ext.data.reader.Json'
    ],

    model : 'App.model.core.person.user.Gender',

    proxy: {
        type: 'ajax',
        url : 'service/person/genders',
        reader: {
            type            : 'json',
            totalProperty   : 'total',
            successProperty : 'success',
            root            : 'data'
        }
    },
    autoLoad: false
});