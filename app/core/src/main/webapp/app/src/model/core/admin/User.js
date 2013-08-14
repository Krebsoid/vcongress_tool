Ext.define('App.model.core.admin.User', {

    extend : 'Ext.data.Model',

    fields : [
        'name',
        'roleName'
    ],

    proxy: {
        type : 'rest',
        url : 'service/user',
        reader:  {
            type            : 'json',
            totalProperty   : 'total',
            successProperty : 'success',
            root            : 'data'
        }
    }

});