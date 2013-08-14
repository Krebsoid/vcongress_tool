Ext.define('vCongress_Mobile.view.Main', {
    extend: 'Ext.Panel',
    xtype: 'main',

    requires : [
        'Ext.TitleBar'
    ],

    config: {
        layout: 'card',
        items: [
            {
                xtype: 'login_form',
                itemId: 'login'
            },
            {
                itemId: 'dashboard',
                items : [
                    {
                        xtype: 'titlebar',
                        docked: 'top',
                        title: 'You are logged in',
                        items: [
                            {
                                iconCls: 'reply',
                                iconMask: true,
                                align: 'right',
                                action: 'logout'
                            }
                        ]
                    },
                    {
                        xtype: 'dashboard'
                    }
                ]
            }
        ]
    }
});
