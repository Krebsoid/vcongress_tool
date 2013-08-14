Ext.define('App.view.core.content.HomePanel', {
    extend:'Ext.panel.Panel',
    alias :'widget.content_home',

    requires:[
        'Ext.container.Container',
        'Ext.layout.container.HBox',
        'Ext.layout.container.Anchor',
        'Ext.button.Button',
        'Ext.form.field.Text',
        'Ext.form.Panel'
    ],

    bodyPadding:50,

    layout     :{
        type :'vbox',
        align:'stretch'
    },
    items      :[
        {
            xtype :'container',
            height:100,
            layout:{
                type :'hbox',
                align:'stretch'
            },
            items :[
                {
                    xtype:'container',
                    html:'<div">' +
                        '<span style="display: inline-block">' +
                        '<a href="http://www.scisertec.de" target="_blank"><div class="congress-logo" style="height: 99px; width: 160px"></div></a>' +
                        '</span>' +
                        '<span style="vertical-align: top; display: inline-block; width: 335px;">' + Congress_Title['Text'] + '</span>' +
                        '</div>'
                }
            ]
        },
        {
            xtype :'container',
            margin:'20 0 0 0',
            html  : '<h2>'+ Locale['Welcome'] + '</h2>'
        },
        {
            xtype  :'container',
            margin :'20 0 0 0',
            height :30,
            layout :{
                type:'hbox'
            },
            items  :[
                {
                    html : Locale['Please choose your language:'],
                    border: 0
                },
                {
                    xtype       : 'button',
                    iconCls     : 'en_flag_16x11',
                    text        : 'English',
                    action      : 'english',
                    margin      : '0 10 0 15'
                },
                {
                    xtype       : 'button',
                    iconCls     : 'de_flag_16x11',
                    text        : 'Deutsch',
                    action      : 'german'
                }
            ]
        },
        {
            xtype  :'container',
            margin :'20 0 0 0',
            height :96,
            secured:['guest'],
            hidden :true,
            layout :{
                type:'hbox'
            },
            items  :[
                {
                    xtype    :'button',
                    flex     :0,
                    width    :200,
                    height   :96,
                    scale    :'large',
                    iconAlign:'left',
                    iconCls  :'user1_add_32x32',
                    text     : Locale['Register Button'],
                    action   :'register'
                },
                {
                    xtype:'box',
                    flex :1
                },
                {
                    xtype    :'button',
                    flex     :0,
                    width    :200,
                    height   :96,
                    scale    :'large',
                    iconAlign:'left',
                    iconCls  :'login_32x32',
                    text     : Locale['Login Button'],
                    action   :'login'
                }
            ]
        },
        {
            xtype  :'container',
            margin :'30 0 0 0',
            height :96,
            secured:['person', 'organiser', 'admin', 'reviewer', 'suborganiser'],
            hidden :true,
            layout :{
                type:'hbox'
            },
            items  :[
                {
                    xtype    :'button',
                    flex     :0,
                    width    :200,
                    height   :96,
                    scale    :'large',
                    iconAlign:'left',
                    iconCls  :'login_32x32',
                    text     : Locale['Logout Button'],
                    action   :'logout'
                },
                {
                    xtype:'box',
                    flex :1
                },
                {
                    xtype    :'button',
                    flex     :0,
                    width    :200,
                    height   :96,
                    scale    :'large',
                    iconAlign:'left',
                    iconCls  :'home_32x32',
                    text     : Locale['Dashboard Button'],
                    action   :'dashboard'
                }
            ]
        },
        {
            xtype    :'button',
            scale    :'large',
            ui       :'default-toolbar',
            frame    :false,
            border   :0,
            height   :60,
            text     :'<h1 style="margin-left: 20px;">'+Locale['Frequently asked questions and Trouble shooting for vCongress']+'</h1>',
            textAlign:'left',
            iconAlign:'left',
            iconCls  :'help_48x48',
            margin   :'10 0 0 0',
            listeners:{
                click:function () {
                    Ext.widget('content_FaqWindow').show();
                }
            }

        },
        {
            xtype    :'button',
            scale    :'large',
            ui       :'default-toolbar',
            frame    :false,
            border   :0,
            height   :60,
            text     :'<h1 style="margin-left: 20px;">'+Locale['Manual']+'</h1>',
            textAlign:'left',
            iconAlign:'left',
            iconCls  :'help_48x48',
            margin   :'10 0 0 0',
            listeners:{
                click:function () {
                    Ext.widget('content_ManualWindow').show();
                }
            }

        },
        {
            xtype :'container',
            margin:'20 0 0 0',
            html  : Locale['Technical Support']
        },
        {
            xtype :'container',
            margin:'30 0 0 0',
            html  : Locale['Greeting']
        }
    ]



});