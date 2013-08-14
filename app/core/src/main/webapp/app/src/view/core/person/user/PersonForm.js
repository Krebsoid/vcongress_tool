Ext.define('App.view.core.person.user.PersonForm', {
    extend: 'Ext.form.Panel',
    alias : 'widget.person_user_person_Detail',

    requires: [
        'Ext.form.Label',
        'Ext.form.field.Text',
        'Ext.layout.container.Anchor',
        'Ext.form.field.ComboBox',
        'Ext.form.FieldSet',
        'Ext.ux.form.field.ClearableCombo'
    ],

    constructor : function(config) {
        Ext.apply(config, {
            trackResetOnLoad: true
        });
        this.callParent([config]);
    },


    items :[
        {
            xtype: 'radiogroup',
            fieldLabel: Locale['Gender'],
            items: [
                {boxLabel: Locale['female'], name: 'gender', inputValue: 'FEMALE', checked: true},
                {boxLabel: Locale['male'], name: 'gender', inputValue: 'MALE'}
            ]
        },
        {
            xtype: 'clearablecombo',
            fieldLabel: Locale['Title'],
            anchor  : '100%',
            editable: false,
            name: 'title',
            store : ['PhD', 'PD',  'Prof.']
        },
        {
            xtype: 'textfield',
            fieldLabel: Locale['First Name'] + ' *',
            anchor  : '100%',
            name: 'firstname',
            allowBlank: false
        },
        {
            xtype: 'textfield',
            fieldLabel: Locale['Last Name'] + ' *',
            anchor  : '100%',
            name: 'lastname',
            allowBlank: false
        },
        {
            html : Locale['Fields marked with * are mandatory and may not be empty!'],
            margin : '208 0 0 0',
            border : 0
        }
    ]
});