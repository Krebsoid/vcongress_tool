Ext.define('App.view.core.locale.LocaleChooseToolbar', {

    extend : 'Ext.toolbar.Toolbar',

    alias : 'widget.LocaleChoose',

    requires : [
        'Ext.toolbar.TextItem',
        'Ext.form.field.Text',
        'Ext.form.Label',
        'Ext.button.Button',
        'Ext.toolbar.Toolbar'
    ],

    style: {
        border : 0
    },

    items       : [
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
});