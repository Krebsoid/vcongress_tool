Ext.define('App.view.congress.PaidPanel', {
    extend: 'Ext.panel.Panel',
    alias : 'widget.congress_PaidPanel',

    requires : [
        'Ext.container.Container',
        'Ext.layout.container.HBox'
    ],

    title : Locale['Congress Fee'],

    items : [
        {
            xtype : 'container',
            margin : '5 5 5 5',
            items : [
                {
                    margin  : '10 10 10 10',
                    html : '<div>' +
                        '<table><tr>' +
                        '<td><div class="information_32x32" style="height: 32px; width: 32px; margin-right: 10px;"></div></td>' +
                        '<td><h1><b>'+ Locale['Information about the choosable options!']+ '</b></h1>' +
                        '<span>'+ Locale['Some options may be locked, for the fact that you already paid them.']+ '</div></td>' +
                        '</tr></table>' +
                        '</div>',
                    border : 0
                }
            ]
        }
    ]
});