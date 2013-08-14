Ext.define('App.view.core.person.user.OccupationForm', {
    extend: 'Ext.form.Panel',
    alias : 'widget.person_user_occupation_Detail',

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
            fieldLabel: Locale['Position'],
            name: 'position',
            anchor  : '100%'
        },
        {
            xtype: 'textfield',
            fieldLabel: Locale['Institute'] + ' *',
            anchor  : '100%',
            name: 'institute',
            allowBlank: false
        },
        {
            xtype: 'textfield',
            fieldLabel: Locale['Department'],
            anchor  : '100%',
            name: 'department'
        },
        {
            html : Locale['Fields marked with * are mandatory and may not be empty!'],
            margin : '237 0 0 0',
            border : 0
        }
    ]
});