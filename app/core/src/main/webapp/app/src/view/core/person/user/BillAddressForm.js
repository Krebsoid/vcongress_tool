Ext.define('App.view.core.person.user.BillAddressForm', {
    extend: 'Ext.form.Panel',
    alias : 'widget.person_user_billAddress_Detail',

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
            xtype: 'textfield',
            fieldLabel: Locale['Full name'] + ' *',
            name: 'fullName',
            allowBlank: false,
            anchor  : '100%'
        },
        {
            xtype: 'textfield',
            fieldLabel: Locale['Company name'],
            name: 'institute',
            anchor  : '100%'
        },
        {
            xtype: 'textfield',
            fieldLabel: Locale['Street'] + ' *',
            name: 'street',
            allowBlank: false,
            anchor  : '100%'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'Zip Code / PLZ *',
            anchor  : '100%',
            allowBlank: false,
            name: 'zipCode'
        },
        {
            xtype: 'textfield',
            fieldLabel: Locale['City'] + ' *',
            anchor  : '100%',
            allowBlank: false,
            name: 'city'
        },
        {
            xtype: 'combobox',
            fieldLabel: Locale['Country'] + ' *',
            emptyText: Locale['Select a country'],
            name: 'country',
            displayField : 'name',
            valueField : 'id',
            autoSelect: true,
            selectOnTab: true,
            typeAhead: true,
            forceSelection : true,
            queryMode: 'local',
            store: 'core.person.user.Country',
            allowBlank: false,
            anchor      : '100%'
        },
        {
            html : Locale['Fields marked with * are mandatory and may not be empty!'],
            margin : '156 0 0 0',
            border : 0
        }
    ]
});