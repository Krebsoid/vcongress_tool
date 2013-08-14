Ext.define('App.model.core.person.user.Country', {

    extend : 'Ext.data.Model',

    requires : [
        'Ext.data.reader.Json',
        'Ext.data.proxy.Rest'
    ],

    fields:[
        {
            name        :'id',
            type        :'string',
            defaultValue:undefined
        },
        {
            name        :'name',
            type        :'string',
            defaultValue:undefined
        }
    ]

});