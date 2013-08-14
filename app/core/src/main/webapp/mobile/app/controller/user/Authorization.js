Ext.define('vCongress_Mobile.controller.user.Authorization', {
    extend: 'Ext.app.Controller',

    requires: [
        'Ext.Ajax'
    ],

    config: {
        views: [
            'user.LoginForm'
        ],

        control: {
            'login_form button[action=login]': {
                tap: 'login'
            },
            'button[action=logout]': {
                tap: 'logout'
            }
        },

        refs: {
            login: 'login_form',
            content: 'main'
        }
    },

    login: function() {
        this.getLogin().submit({
            url    :'/service/account/authenticate',
            method :'POST',
            scope  :this,
            success:function (response,o,e,f) {
                this.fireEvent('login');
            },
            failure:function (response,o,e,f) {
                this.getLogin().down('textfield[name=password]').reset();
            }
        });
    },

    logout : function() {
        Ext.Ajax.request({
            url    :'/service/account/logout',
            method :'GET',
            scope  :this,
            success:function (response, options) {
                this.getLogin().down('textfield[name=password]').reset();
                this.getContent().setActiveItem(0, {type: 'slide', direction: 'right'});
            },
            failure:function (response, options) {
            }
        });
    }
});