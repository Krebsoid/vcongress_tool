Ext.define('App.view.congress.ParticipationStatusForm', {
    extend: 'Ext.form.Panel',
    alias : 'widget.congress_ParticipationStatusForm',

    requires: [
        'Ext.form.Label',
        'Ext.form.field.Text',
        'Ext.layout.container.Anchor',
        'Ext.form.FieldSet',
        'Ext.toolbar.Toolbar'
    ],

    bodyPadding: '20 50 50 60',

    constructor: function(config) {
        var me = this;
        config = config || {};
        config.trackResetOnLoad = true;
        me.callParent([config]);
    },


    items: [
        {
            html : '<div align="left" style="margin-left: 200px"><h1>Status</h1></div>' +
                '<div class="registration-wizard-step-3" style="width: 460px; height: 50px; margin-top: 10px; margin-bottom: 20px;"></div>',
            border : 0
        },
        {
            xtype : 'container',
            border : 0,
            margin : '10 20 20 0',
            html : '<div>' +
                '<span style="display: inline-block">' +
                '<a href="http://www.scisertec.de" target="_blank">' +
                '<div class="congress-logo" style="width: 160px; height: 99px;"></div>' +
                '</a>' +
                '</span>' +
                '<span style="display: inline-block; text-align: right; width: 300px; vertical-align: 20px;">' +
                Congress_Title['Smaller'] +
                '<a href="http://www.scisertec.de" target="_blank">http://www.scisertec.de</a>' +
                '</span>' +
                '</div>'
        },

        {
            xtype:'fieldset',
            columnWidth: 0.5,
            title: Locale['Congress Fee'],
            margin: '10 0 20 0',
            layout: 'anchor',
            items :[
                {
                    html : Registration_Status['Text'],
                    border : 0
                }
            ]
        },
        {
            xtype:'fieldset',
            columnWidth: 0.5,
            title: Locale['Participation Status'],
            layout: 'anchor',
            items :[
                {
                    xtype: 'combobox',
                    triggerAction: 'all',
                    displayField : 'name',
                    valueField : 'id',
                    selectOnTab: true,
                    editable: false,
                    allowBlank : false,
                    forceSelection: true,
                    queryMode : 'local',
                    store : 'congress.ChoosableParticipationStatus',
                    anchor : '100%',
                    name : 'participationStatusId',
                    emptyText: Locale['Select a status']
                }
            ]
        },
        {
            border: 0,
            html: '<hr>',
            margin: '10 0 10 0'
        },
        {
            xtype:'fieldset',
            columnWidth: 0.5,
            itemId: 'extraBooking',
            title: "Workshops",
            layout: 'anchor',
            items :[
                {
                    xtype: 'fieldcontainer',
                    layout : 'hbox',
                    items: [
                        {
                            xtype: 'checkbox',
                            name : 'workshop1',
                            inputValue: true,
                            flex : 1
                        },
                        {
                            xtype : 'container',
                            flex : 5,
                            width : 450,
                            items : [
                                {
                                    xtype : 'displayfield',
                                    value : '<div style="width: 170px; display: inline-block; vertical-align: top">Workshop 1</div>' +
                                        '<div style="width: 200px; display: inline-block"><span style="font-size: 10px">+ 120,00&euro; '+ Locale['(incl. tax)'] +'</span></div>'
                                }
                            ]
                        }
                    ]
                },
                {
                    xtype: 'fieldcontainer',
                    layout : 'hbox',
                    items: [
                        {
                            xtype: 'checkbox',
                            name : 'workshop2',
                            inputValue: true,
                            flex : 1
                        },
                        {
                            xtype : 'container',
                            flex : 5,
                            width : 450,
                            items : [
                                {
                                    xtype : 'displayfield',
                                    value : '<div style="width: 170px; display: inline-block; vertical-align: top">Workshop 2</div>' +
                                        '<div style="width: 200px; display: inline-block"><span style="font-size: 10px">+ 90,00&euro; '+ Locale['(incl. tax)'] +'</span></div>'
                                }
                            ]
                        }
                    ]
                },
                {
                    xtype: 'fieldcontainer',
                    layout : 'hbox',
                    items: [
                        {
                            xtype: 'checkbox',
                            name : 'workshop3',
                            inputValue: true,
                            flex : 1
                        },
                        {
                            xtype : 'container',
                            flex : 5,
                            width : 450,
                            items : [
                                {
                                    xtype : 'displayfield',
                                    value : '<div style="width: 170px; display: inline-block; vertical-align: top">Workshop 3</div>' +
                                        '<div style="width: 200px; display: inline-block"><span style="font-size: 10px">+ 365,00&euro; '+ Locale['(incl. tax)'] +'</span></div>'
                                }
                            ]
                        }
                    ]
                }
            ]
        },
        {
            xtype:'fieldset',
            columnWidth: 0.5,
            title: Locale['Evening Event'],
            layout: 'anchor',
            items :[
                {
                    xtype: 'combobox',
                    triggerAction: 'all',
                    editable: false,
                    forceSelection: true,
                    fieldLabel: Locale['Number of tickets'],
                    queryMode : 'local',
                    name : 'eveningEventTickets',
                    emptyText: 'Number of tickets',
                    store : 'congress.EventTickets',
                    displayField: 'id',
                    valueField: 'id'
                }
            ]
        },
        {
            xtype: 'fieldcontainer',
            items: [
                {
                    xtype : 'panel',
                    itemId : 'bookedTickets',
                    border: 0,
                    tpl : Locale['Booked Tickets Text']
                }
            ]
        }
    ],

    dockedItems: [
        {
            xtype: 'toolbar',
            dock: 'bottom',
            items: [
                '->',
                {
                    text        : Locale['Make Payment Underneath'],
                    hidden      : true,
                    action      : 'payment',
                    width       : 90,
                    scale       : 'large',
                    iconAlign   : 'top',
                    iconCls     : 'payment_32x32',
                    margin      : '0 30 0 0'
                },
                {
                    text        : Locale['Save and proceed'],
                    formBind    : true,
                    action      : 'save',
                    width       : 90,
                    scale       : 'large',
                    iconAlign   : 'top',
                    iconCls     : 'save_32x32'
                }
            ]
        }
    ]
});