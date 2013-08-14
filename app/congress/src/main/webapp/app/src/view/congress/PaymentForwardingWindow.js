Ext.define('App.view.congress.PaymentForwardingWindow', {
    extend: 'Ext.window.Window',
    alias : 'widget.congress_PaymentForwardingWindow',

    width : 480,
    height : 240,
    resizable: false,
    bodyStyle: {
        background: '#FFFFFF'
    },

    title : Locale['Participation successfully selected'],

    items : [
        {
            html : '' +
                '<div style = "width: 400px;">' +
                    '<span style="display: inline-block; width: 50px;">' +
                        '<div class="information_32x32" style="height:32px; width: 32px;"></div>' +
                    '</span>' +
                    '<span style="display: inline-block; width: 340px; vertical-align: top; text-align: justify">' +
                    Locale['Payment Forwarding Text'] +
                    '</span>' +
                '</div>',
            border: false,
            margin: 30
        }
    ],

    addButtons : function() {
        var self = this;
        var printButton = Ext.create('Ext.button.Button', {
            text        : Locale['Make Payment Underneath'],
            scale       : 'large',
            width       : 105,
            height      : 75,
            margin      : '0 0 0 20',
            iconAlign   : 'top',
            iconCls     : 'payment_32x32',
            action      : 'forwardToPayment',
            handler     : function() {
                self.destroy();
            }
        });
        var cancelPrintingButton = Ext.create('Ext.button.Button', {
            text        : Locale['Pay later'],
            scale       : 'large',
            width       : 105,
            height      : 75,
            margin      : '0 0 0 80',
            iconAlign   : 'top',
            iconCls     : 'delete_32x32',
            handler     : function() {
                self.destroy();
            }
        });
        this.add(cancelPrintingButton);
        this.add(printButton);

    }

});