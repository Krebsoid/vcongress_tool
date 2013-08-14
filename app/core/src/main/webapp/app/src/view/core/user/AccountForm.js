Ext.define('App.view.core.user.AccountForm', {
    extend: 'Ext.form.Panel',
    alias : 'widget.person_user_account_Detail',

    requires: [
        'Ext.form.Label',
        'Ext.form.field.Text',
        'Ext.layout.container.Anchor',
        'Ext.form.field.ComboBox',
        'Ext.form.FieldSet'
    ],

    constructor : function(config) {
        Ext.apply(config, {
            trackResetOnLoad: true
        });
        this.callParent([config]);
    },


    items :[
        {
            html    : Update_Account['Text'],
            border  : 0,
            margin  : '0 0 20 0'
        },
        {
            xtype: 'textfield',
            fieldLabel: Locale['Email'] + ' *',
            name: 'username',
            vtype : 'email',
            anchor  : '100%',
            allowBlank: false,
            labelWidth: 170
        },
        {
            xtype: 'textfield',
            fieldLabel: Locale['Password'] + ' *',
            inputType: 'password',
            anchor  : '100%',
            name: 'password',
            allowBlank: false,
            margin : '0 0 30 0',
            labelWidth: 170
        },
        {
            xtype: 'textfield',
            fieldLabel: Locale['New Password'] + ' *',
            anchor  : '100%',
            id: 'newPassword',
            name: 'newPassword',
            inputType: 'password',
            vtype: 'password',
            allowBlank: false,
            labelWidth: 170
        },
        {
            xtype: 'textfield',
            fieldLabel: Locale['Retype new Password'] + ' *',
            anchor  : '100%',
            id: 'newPasswordConfirm',
            name: 'newPasswordConfirm',
            inputType: 'password',
            vtype: 'password',
            initialPasswordField: 'newPassword',
            allowBlank: false,
            labelWidth: 170
        },
        {
            html : Locale['Fields marked with * are mandatory and may not be empty!'],
            margin : '134 0 0 0',
            border : 0
        }
    ]
});