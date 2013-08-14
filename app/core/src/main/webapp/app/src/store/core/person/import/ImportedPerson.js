Ext.define('App.store.core.person.import.ImportedPerson', {
    extend: 'Ext.data.Store',

    requires : [
        'Ext.Ajax',
        'Ext.data.reader.Json',
        'Ext.data.proxy.Rest'
    ],

    model : 'App.model.core.person.import.ImportedPerson',

    pageSize: 100,

    proxy: {
        type: 'rest',
        url : 'service/persons/import',
        appendId: false,
        reader:  {
            type            : 'json',
            totalProperty   : 'total',
            successProperty : 'success',
            root            : 'data'
        }
    },
    autoSync : true,
    autoLoad : false
});