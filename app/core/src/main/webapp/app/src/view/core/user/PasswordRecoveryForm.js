Ext.define('App.view.core.user.PasswordRecoveryForm', {

    extend : 'Ext.form.Panel',

    alias : 'widget.core_user_PasswordRecoveryForm',

    requires : [
        'Ext.container.Container',
        'Ext.form.field.Text',
        'Ext.button.Button',
        'Ext.layout.container.HBox',
        'Ext.layout.container.Anchor'
    ],

    layout : 'anchor',

    items  : [
        {
            xtype       : 'container',
            html        : '<div style="margin-left: 10px; margin-right: 15px; margin-top: 10px;">' +
                '<table><tr>' +
                '<td><div class="information_32x32" style="height: 32px; width: 32px; margin-right: 10px;"></div></td>' +
                '<td>'+Locale['Bitte geben Sie hier Ihre E-Mail Adresse ein, mit der Sie in vCongress registriert sind und Sie erhalten ein neues Passwort zugesendet.']+'</td>' +
                '</tr></table>' +
                '</div>',
            border      : 0
        },
        {
            xtype       : 'container',
            layout  : {
                type    : 'hbox',
                pack    : 'center'
            },
            items   : [
                {
                    xtype       : 'textfield',
                    name        : 'email',
                    margin      : '10 10 5 10',
                    allowBlank  : false,
                    vtype       : 'email',
                    width       : 130
                },
                {
                    xtype       : 'button',
                    text        : Locale['Senden'],
                    margin      : '10 15 5 0',
                    action      : 'send_password',
                    formBind    : true
                }
            ]

        }
    ]
});