Ext.define('App.view.core.admin.RoleChangeForm', {
    extend: 'Ext.form.Panel',
    alias : 'widget.identity_admin_RoleChange',

    requires : [
        'Ext.container.Container',
        'Ext.layout.container.HBox',
        'Ext.form.field.ComboBox'
    ],

    title : 'Role Widget',

    items : [
        {
            xtype : 'container',
            height : 100,
            margin : '20 10 10 10',
            items : [
                {
                    xtype: 'displayfield',
                    name: 'name',
                    fieldLabel : 'Change Role for',
                    margin: '0 0 10 0'
                },
                {
                    html : '<b>Active Role</b> ',
                    border : 0
                },
                {
                    xtype: 'combobox',
                    displayField : 'roleName',
                    valueField : 'roleName',
                    name : 'roleName',
                    editable: false,
                    queryMode : 'local',
                    store : 'core.admin.Role'
                }
            ]


        }
    ]
});