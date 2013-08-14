Ext.define('App.view.congress.organizer.ParticipationNoticeForm', {
    extend: 'Ext.form.Panel',
    alias : 'widget.congress_participant_ParticipantNotice',

    requires : [
        'Ext.layout.container.HBox',
        'Ext.button.Button',
        'Ext.form.field.TextArea'
    ],

    border : 0,
    margin : '0 0 0 10',
    width : 180,
    layout  : {
        type    : 'hbox',
        pack    : 'stretch'
    },

    constructor : function(config) {
        Ext.apply(config, {
            trackResetOnLoad: true
        });
        this.callParent([config]);
    },

    items : [
        {
            xtype : 'textarea',
            name  : 'notice',
            width : 150
        },
        {
            xtype       : 'button',
            action      : 'saveNotice',
            iconCls     : 'save_16x16',
            margin      : '0 0 0 3',
            scale       : 'small',
            hidden      : true
        }
    ]
});