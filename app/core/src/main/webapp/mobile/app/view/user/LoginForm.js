Ext.define('vCongress_Mobile.view.user.LoginForm', {

    extend : 'Ext.form.Panel',

    xtype : 'login_form',

    requires: [
        'Ext.form.FieldSet',
        'Ext.field.Password',
        'Ext.field.Email'
    ],

    config : {
        fullscreen: true,
        layout : {
            type  : 'vbox',
            pack  : 'center'
        },
        items : [
            {
                xtype       : 'container',
                html        : '<span style="display: inline-block; vertical-align: -5px;"><div class="login_24x24" style="width: 24px; height: 24px; margin-left: 20px; margin-top: 4px; margin-right: 10px;"></div></span>' +
                    '<span style="display: inline-block"><h2><span style="font-size: 20px; margin-left: 10px; font-weight: bold;">Account Login</span></h2></span>',
                border      : 0
            },
            {
                xtype: 'fieldset',
                items  : [
                    {
                        xtype       : 'emailfield',
                        name        : 'username',
                        label       : 'Email',
                        labelWidth  : 95,
                        placeHolder : 'yourname@domain.com'
                    },
                    {
                        xtype           : 'passwordfield',
                        name            : 'password',
                        labelWidth      : 95,
                        label           : 'Password'
                    },
                    {
                        xtype       : 'button',
                        text        : 'Login',
                        action      : 'login'
                    }
                ]
            }
        ]
    }

});