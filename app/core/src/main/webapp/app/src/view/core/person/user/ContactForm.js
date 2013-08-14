Ext.define('App.view.core.person.user.ContactForm', {
    extend: 'Ext.form.Panel',
    alias : 'widget.person_user_contact_Detail',

    requires: [
        'Ext.form.Label',
        'Ext.form.field.Text',
        'Ext.layout.container.Anchor',
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
            xtype: 'textfield',
            fieldLabel: Locale['Email'] + ' *',
            name: 'email',
            vtype: 'email',
            anchor  : '100%',
            allowBlank: false
        },
        {
            xtype: 'textfield',
            fieldLabel: Locale['Phone'] + ' *',
            allowBlank: false,
            name: 'phone',
            anchor  : '100%'
        },
        {
            xtype: 'textfield',
            fieldLabel: Locale['Fax'],
            anchor  : '100%',
            name: 'fax'
        },
        {
            html : Locale['Fields marked with * are mandatory and may not be empty!'],
            margin : '237 0 0 0',
            border : 0
        }
    ]
});