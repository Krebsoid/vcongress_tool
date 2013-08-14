Ext.define('App.view.core.user.WelcomeToolbar', {

    extend : 'Ext.toolbar.Toolbar',

    alias : 'widget.identity_user_account_WelcomeBar',

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

    secured     : ['person', 'organiser','admin','reviewer', 'suborganiser'],

    items       : [
        '->',
        {
            xtype       : 'tbtext',
            text        :  Locale['Welcome']
        },
        {
            xtype       : 'tbtext',
            name        : 'name'
        },
        {
            xtype       : 'button',
            text        : Locale['Log out'],
            action      : 'logout'
        }
    ],
    hidden : true
});