Ext.define('App.view.congress.organizer.StatisticPanel', {
    extend:'Ext.panel.Panel',
    alias :'widget.congress_organizer_StatisticPanel',

    requires:[
        'Ext.container.Container',
        'Ext.button.Button',
        'Ext.form.field.Text',
        'Ext.form.Panel',
        'Ext.chart.*',
        'Ext.form.field.ComboBox',
        'Ext.layout.container.Fit'
    ],

    bodyPadding: 30,

    dockedItems: [
        {
            xtype: 'toolbar',
            dock: 'top',
            items: [
                {
                    xtype: 'combobox',
                    name : 'statistic',
                    emptyText: Locale['Choose Statistic'],
                    store: Ext.create('Ext.data.Store', {
                        fields: ['name','path'],
                        data: [
                            {'name': Locale['Participant registered'], 'path': 'Registration/register'},
                            {'name': Locale['User logged in'], 'path': 'Authorization/authenticate'},
                            {'name': Locale['Abstract submitted'], 'path': 'Papers/submit'},
                            {'name': Locale['Abstract created'], 'path': 'Papers/create'},
                            {'name': Locale['Payment via PayPal'], 'path': 'PayPal/execute'},
                            {'name': Locale['Review updated'], 'path': 'Review/update'}
                        ]}),
                    displayField: 'name',
                    valueField: 'path',
                    queryMode: 'local',
                    width: 300
                },
                {
                    xtype: 'clearablecombo',
                    name : 'year',
                    emptyText: Locale['Choose Year'],
                    store: [2011,2012,2013,2014,2015,2016],
                    queryMode: 'local',
                    width: 150
                },
                {
                    xtype: 'clearablecombo',
                    name : 'month',
                    emptyText: Locale['Choose Month'],
                    store: Ext.create('Ext.data.Store', {
                        fields: ['month','id'],
                        data: [
                            {'month': Locale['January'], 'id': 1},
                            {'month': Locale['February'], 'id': 2},
                            {'month': Locale['March'], 'id': 3},
                            {'month': Locale['April'], 'id': 4},
                            {'month': Locale['May'], 'id': 5},
                            {'month': Locale['June'], 'id': 6},
                            {'month': Locale['July'], 'id': 7},
                            {'month': Locale['August'], 'id': 8},
                            {'month': Locale['September'], 'id': 9},
                            {'month': Locale['October'], 'id': 10},
                            {'month': Locale['November'], 'id': 11},
                            {'month': Locale['December'], 'id': 12}
                        ]}),
                    margin: '0 70 0 0',
                    displayField: 'month',
                    valueField: 'id',
                    queryMode: 'local',
                    width: 180
                },
                '->',
                {
                    xtype: 'button',
                    text: '<b>'+Locale['Show Statistic']+'</b>'
                }
            ]
        }

    ],

    items    :[
        {
            xtype: 'container',
            itemId: 'statisticEmptyText',
            html : '<div style="margin: 150px 30px 20px 180px">' +
                '<table><tr>' +
                '<td><div class="information_32x32" style="height: 32px; width: 32px"></div></td>' +
                '<td><span style="margin-left: 10px; font-size: 24px;">'+Locale['Please select a statistic in the upper toolbar.']+'</span></td>' +
                '</tr></table>' +
                '</div>'
        },
        {
            border: 0,
            itemId: 'statisticInfoPanel',
            tpl: '<div style="margin:10px 0 20px 20px">' +
                '<div style="font-size: 20px">{statistic}</div>' +
                '<div style="font-size: 18px">' +
                    '<tpl if="month != \'\'">{month} </tpl>' +
                    '<tpl if="year != \'\'">{year}</tpl>' +
                '</div>' +
                '</div>'
        },
        {
            xtype : 'chart',
            width: 850,
            height: 500,
            store: 'congress.organizer.Statistic',
            axes: [
                {
                    title: Locale['Amount'],
                    type: 'Numeric',
                    position: 'left',
                    fields: ['value'],
                    minimum: 0,
                    label: {
                        renderer: Ext.util.Format.numberRenderer('0'),
                        font: '10px Arial'
                    },
                    grid: {
                        odd: {
                            opacity: 1,
                            fill: '#ddd',
                            stroke: '#bbb',
                            'stroke-width': 1
                        }
                    }
                },
                {
                    title: 'Name',
                    type: 'Category',
                    position: 'bottom',
                    fields: ['name'],
                    label: {
                        font: '10px Arial'
                    }
                }
            ],
            series: [
                {
                    type: 'line',
                    smooth: true,
                    fill: true,
                    xField: 'name',
                    yField: 'value',
                    markerConfig: {
                        type: 'circle',
                        size: 4,
                        radius: 4,
                        'stroke-width': 0
                    },
                    tips: {
                        trackMouse: true,
                        width: 20,
                        height: 28,
                        renderer: function(storeItem, item) {
                            if(storeItem.get('value') != 0)
                                this.setTitle(storeItem.get('value'));
                            else
                                this.setTitle('0');
                        }
                    }
                }
            ]
        }
    ]
});