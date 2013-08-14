Ext.define('App.model.core.admin.Role', {

    extend : 'Ext.data.Model',

    fields : [
        'roleName'
    ],

    proxy: {
        type : 'rest',
        url : 'service/role',
        reader:  {
            type            : 'json',
            totalProperty   : 'total',
            successProperty : 'success',
            root            : 'data'
        }
    }

});