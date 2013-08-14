Ext.define('App.view.congress.CalculatedFeePanel', {
    extend: 'Ext.panel.Panel',
    alias : 'widget.congress_CalculatedFeePanel',

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
                    itemId  : 'priceCalculation',
                    margin  : '10 10 10 10',
                    tpl     : Locale['Fee for this congress'] +
                        '<br/>' +
                        '<b>{price:currency("€",2,true)} '+ Locale['(incl. tax)'] +
                        '<tpl if="discount &gt; 0"> ({discount:currency("€",2,true)}'+ Locale['Discount'] + ') </tpl>' +
                        '</b>',
                    border : 0
                }
            ]
        }
    ]
});