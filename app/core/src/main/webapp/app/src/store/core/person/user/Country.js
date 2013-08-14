Ext.define('App.store.core.person.user.Country', {
    extend: 'Ext.data.Store',

    requires : [
        'Ext.Ajax',
        'Ext.data.reader.Json'
    ],

    model : 'App.model.core.person.user.Country',

    proxy: {
        type: 'ajax',
        url : 'service/person/countries',
        reader: {
            type            : 'json',
            totalProperty   : 'total',
            successProperty : 'success',
            root            : 'data'
        }
    }

});