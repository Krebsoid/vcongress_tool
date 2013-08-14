Ext.define('App.view.core.person.user.UpdateTab', {
    extend:'Ext.tab.Panel',
    alias :'widget.person_user_Update',

    requires:[
        'App.view.core.person.user.AddressForm',
        'App.view.core.person.user.BillAddressForm',
        'App.view.core.person.user.OccupationForm',
        'App.view.core.person.user.ContactForm',
        'App.view.core.person.user.PersonForm',
        'Ext.layout.container.Anchor',
        'Ext.data.reader.Json',
        'Ext.toolbar.Toolbar'
    ],

    plain:true,

    items:[
        {
            xtype      :'person_user_person_Detail',
            title      :'Person',
            height     :470,
            bodyPadding:50,
            dockedItems:[
                {
                    xtype:'toolbar',
                    dock :'bottom',
                    items:[
                        '->',
                        {
                            text     : Locale['Save changes'],
                            scale    :'large',
                            iconAlign:'top',
                            iconCls  :'save_32x32',
                            action   :'save'
                        }
                    ]
                }
            ]
        },
        {
            xtype      :'person_user_address_Detail',
            title      :Locale['Address'],
            height     :470,
            bodyPadding:50,
            dockedItems:[
                {
                    xtype:'toolbar',
                    dock :'bottom',
                    items:[
                        '->',
                        {
                            text     : Locale['Save changes'],
                            scale    :'large',
                            iconAlign:'top',
                            iconCls  :'save_32x32',
                            action   :'save'
                        }
                    ]
                }
            ]
        },
        {
            xtype      :'person_user_billAddress_Detail',
            title      :Locale['Bill Address'],
            height     :470,
            bodyPadding:50,
            dockedItems:[
                {
                    xtype:'toolbar',
                    dock :'bottom',
                    items:[
                        '->',
                        {
                            text     : Locale['Save changes'],
                            scale    :'large',
                            iconAlign:'top',
                            iconCls  :'save_32x32',
                            action   :'save'
                        }
                    ]
                }
            ]
        },
        {
            xtype      :'person_user_occupation_Detail',
            title      :Locale['Occupation'],
            height     :470,
            bodyPadding:50,
            dockedItems:[
                {
                    xtype:'toolbar',
                    dock :'bottom',
                    items:[
                        '->',
                        {
                            text     : Locale['Save changes'],
                            scale    :'large',
                            iconAlign:'top',
                            iconCls  :'save_32x32',
                            action   :'save'
                        }
                    ]
                }
            ]
        },
        {
            xtype      :'person_user_contact_Detail',
            title      :Locale['Contact'],
            height     :470,
            bodyPadding:50,
            dockedItems:[
                {
                    xtype:'toolbar',
                    dock :'bottom',
                    items:[
                        '->',
                        {
                            text     : Locale['Save changes'],
                            scale    :'large',
                            iconAlign:'top',
                            iconCls  :'save_32x32',
                            action   :'save'
                        }
                    ]
                }
            ]
        },
        {
            xtype      :'person_user_account_Detail',
            title      :Locale['Account'],
            itemId     :'accountTab',
            height     :470,
            bodyPadding:50,
            dockedItems:[
                {
                    xtype:'toolbar',
                    dock :'bottom',
                    items:[
                        '->',
                        {
                            text     : Locale['Save changes'],
                            scale    :'large',
                            iconAlign:'top',
                            iconCls  :'save_32x32',
                            action   :'save'
                        }
                    ]
                }
            ]
        }
    ]

});