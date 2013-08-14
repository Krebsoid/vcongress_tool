Ext.define('App.view.core.user.LoginForm', {

    extend : 'Ext.form.Panel',

    alias : 'widget.core_user_LoginForm',

    requires : [
        'Ext.container.Container',
        'Ext.form.field.Text',
        'Ext.button.Button',
        'Ext.layout.container.HBox',
        'Ext.layout.container.Anchor'
    ],

    items  : [
        {
            xtype       : 'container',
            html        : '<span style="display: inline-block; vertical-align: -5px;"><div class="login_24x24" style="width: 24px; height: 24px; margin-left: 20px; margin-top: 4px; margin-right: 10px;"></div></span>' +
                '<span style="display: inline-block"><h2><span style="font-size: 16px; margin-left: 10px;">'+Locale['Account Login']+'</span></h2></span>',
            border      : 0
        },
        {
            xtype       : 'textfield',
            name        : 'username',
            margin      : '10 20 5 20',
            labelWidth  : 60,
            allowBlank  : false,
            fieldLabel  : Locale['Email'],
            width       : 200
        },
        {
            xtype           : 'textfield',
            name            : 'password',
            margin          : '0 20 5 20',
            inputType       : 'password',
            fieldLabel      : Locale['Password'],
            allowBlank      : false,
            enableKeyEvents : true,
            labelWidth      : 60,
            width           : 200
        },
        {
            xtype       : 'container',
            layout  : {
                type    : 'hbox',
                pack    : 'stretch'
            },
            items   : [
                {
                    xtype       : 'button',
                    text        : Locale['Login'],
                    margin      : '5 10 5 10',
                    action      : 'login',
                    formBind    : true
                }
            ]

        }
    ]
});