Ext.define('App.view.core.person.user.AddressForm', {
    extend: 'Ext.form.Panel',
    alias : 'widget.person_user_address_Detail',

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
            fieldLabel: Locale['Street'] + ' *',
            allowBlank: false,
            name: 'street',
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
            allowBlank: false,
            queryMode: 'local',
            store: 'core.person.user.Country',
            anchor      : '100%'
        },
        {
            html : Locale['Fields marked with * are mandatory and may not be empty!'],
            margin : '210 0 0 0',
            border : 0
        }
    ]
});