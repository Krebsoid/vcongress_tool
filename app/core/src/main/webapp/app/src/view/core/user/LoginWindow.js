Ext.define('App.view.core.user.LoginWindow', {

    extend : 'Ext.window.Window',

    alias : 'widget.core_user_LoginWindow',

    requires : [
        'Ext.layout.container.Accordion',
        'App.view.core.user.LoginForm',
        'App.view.core.user.PasswordRecoveryForm'
    ],

    layout: {
        type : 'accordion',
        titleCollapse: true,
        animate: true,
        multi : false
    },

    width  : 240,
    height : 230,
    modal : true,
    resizable : false,
    autoDestroy : false,
    closeAction : 'hide',

    items  : [
        {
            xtype : 'core_user_LoginForm',
            title : 'Login'
        },
        {
            xtype : 'core_user_PasswordRecoveryForm',
            title : Locale['Password Recovery']
        }
    ]
});