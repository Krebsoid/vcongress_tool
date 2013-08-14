Ext.define('App.view.core.admin.OrganizerManipulationInfoPanel', {
    extend: 'Ext.panel.Panel',
    alias : 'widget.core_admin_OrganizerManipulationInfoPanel',

    requires : [
        'Ext.container.Container',
        'Ext.layout.container.HBox'
    ],

    title : Locale['Organizer Editation'],

    items : [
        {
            xtype : 'container',
            margin : '5 5 5 5',
            items : [
                {
                    itemId  : 'organizerManipulationPanel',
                    margin  : '10 10 10 10',
                    tpl     :
                        '<span style="display: inline-block;"><div class="information_32x32" style="height: 32px; width: 32px;"></div></span>' +
                        '<span style="font-size: 16px; vertical-align: 10px; margin-left: 5px">'+ Locale['Please note'] + '</span>' +
                        '<div>' +
                        Locale['You are editing the participant:'] +'<br/>' +
                        '<b>{firstname} {lastname}</b>' +
                        '</div>',
                    border : 0
                }
            ]
        }
    ]
});