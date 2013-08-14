Ext.define('App.controller.core.user.Authorization', {

    extend:'Ext.app.Controller',

    requires:[
        'Ext.Ajax',
        'Ext.data.reader.Json',
        'Ext.layout.container.Card',
        'Ext.window.MessageBox',
        'App.model.core.user.Role',
        'Ext.ComponentManager',
        'Ext.EventObject',
        'Ext.ux.window.Notification',
        'Ext.TaskManager',
        'Ext.util.Cookies'
    ],

    views:[
        'core.user.LoginWindow',
        'core.user.WelcomeToolbar',
        'core.user.PasswordRecoveryForm',
        'core.user.AccountForm'
    ],

    refs:[
        {
            ref     :'content',
            selector:'#content'
        },
        {
            ref     :'login',
            selector:'core_user_LoginWindow'
        },
        {
            ref     :'passwordRecovery',
            selector:'core_user_PasswordRecoveryForm'
        },
        {
            ref     :'accountForm',
            selector:'person_user_Update person_user_account_Detail'
        }
    ],

    config:{
        roles:undefined
    },

    init:function () {
        this.getController('core.user.Register').on({
            registerUser:this.requestState,
            scope       :this
        });

        this.addEvents({
            stateChanged:true,
            login       :true
        });

        this.initSecurityListener();

        Ext.TaskManager.start({
            run     :this.requestState,
            interval:20000,
            scope   :this
        });

        this.getView('core.user.LoginWindow').create().hide();

        var mailRemember = Ext.util.Cookies.get("mailRemember");
        var usernameField = Ext.ComponentQuery.query('core_user_LoginForm textfield[name=username]');
        if(!Ext.isEmpty(mailRemember)) {
            usernameField[0].setValue(mailRemember);
        }

        this.control(
            {
                'content_home button[action=login]'                                :{
                    click:this.showLogin
                },
                'content_home button[action=logout]'                               :{
                    click:this.logoutHandler
                },
                'content_home button[action=dashboard]'                            :{
                    click:this.navigateDashboard
                },
                'core_user_LoginWindow textfield[name=password]'                   :{
                    keypress:this.fireLogin
                },
                'core_user_LoginWindow button[action=login]'                       :{
                    click:this.authenticateHandler
                },
                'identity_user_account_WelcomeBar button[action=logout]'           :{
                    click:this.logoutHandler
                },
                'core_user_LoginWindow button[action=password_recovery]'           :{
                    click:this.showPasswordRecovery
                },
                'core_user_PasswordRecoveryForm button[action=send_password]'      :{
                    click:this.recoverPassword
                },
                'person_user_Update person_user_account_Detail button[action=save]':{
                    click:this.update
                },
                'person_user_Update person_user_account_Detail'                    :{
                    dirtychange   :this.dirtyDetection,
                    validitychange:this.dirtyDetection
                }
            }
        );

    },

    navigateDashboard : function() {
        this.getController('main.navigation.Navigation').navigateDashboard();
    },

    dirtyDetection:function (form) {
        if (form.isDirty() && !(form.hasInvalidField()))
            form.owner.down('button[action=save]').enable();
        else
            form.owner.down('button[action=save]').disable();
    },

    update:function (button) {
        var form = this.getAccountForm().getForm();
        form.submit({
            url    :'service/account',
            headers:{
                'Accept':'application/json'
            },
            method :'POST',
            scope  :this,
            success:function (form, action) {
                form.reset();
                Ext.create('widget.uxNotification', {
                    corner          :'tr',
                    cls             :'ux-notification-light',
                    width           :200,
                    height          :130,
                    autoDestroyDelay:8000,
                    useXAxis        :true,
                    iconCls         :'ux-notification-icon-information',
                    html            :'<h2>' + Locale['Password successfully changed.'] + '</h2>'
                }).show();
            },
            failure:function (form, action) {
                form.reset();
                Ext.create('widget.uxNotification', {
                    corner          :'tr',
                    cls             :'ux-notification-light',
                    width           :200,
                    height          :130,
                    autoDestroyDelay:8000,
                    useXAxis        :true,
                    iconCls         :'ux-notification-icon-error',
                    html            :'<h2>' + Locale['Failed to save the changes. Errors in some of your inputs.'] + '</h2>'
                }).show();
            }
        });
    },

    fireLogin:function (button, e) {
        var event = e.getKey();
        if (event == Ext.EventObject.ENTER)
            this.authenticateHandler();
    },

    showLogin:function () {
        this.getLogin().show();
    },

    showPasswordRecovery:function () {
        this.getPasswordRecovery().show();
    },

    requestState:function () {
        Ext.Ajax.request({
            url    :'service/account/state',
            method :'GET',
            headers:{'Accept':'application/json'},
            scope  :this,
            success:function (response, options) {
                var reader = new Ext.data.reader.Json({
                    model          :'App.model.core.user.Role',
                    successProperty:'success',
                    root           :'roles'
                });
                var roles = reader.read(response).records;
                if (roles.size != 0) {
                    this.setRoles(roles);
                    this.fireEvent('stateChanged', roles);
                }
            },
            failure:function (response, options) {
                Ext.Msg.alert(Locale['Connection Problem'], Locale['Please check your internet connection.'], function() {
                    this.requestState();
                }, this);
                this.getContent().getLayout().setActiveItem('home');
            }
        });
    },

    authenticateHandler:function () {
        this.getLogin().down('form').getForm().submit({
            url    :'service/account/authenticate',
            method :'POST',
            headers:{'Accept':'application/json'},
            scope  :this,
            success:function (form, action) {
                var reader = new Ext.data.reader.Json({
                    model          :'App.model.core.user.Role',
                    totalProperty  :'total',
                    successProperty:'success',
                    root           :'data'
                });
                var roles = reader.read(action.response).records;
                this.setRoles(roles);
                this.fireEvent('stateChanged', roles);
                this.fireEvent('login', roles[0].data.roleType);
                Ext.util.Cookies.set('mailRemember',roles[0].data.userId, new Date(new Date().getTime()+(1000*60*60*24*30)));
                this.getLogin().hide();
            },
            failure:function (response, options) {
                this.getLogin().down('field[name=password]').reset();
                Ext.create('widget.uxNotification', {
                    corner          :'tr',
                    cls             :'ux-notification-light',
                    width           :200,
                    height          :130,
                    autoDestroyDelay:8000,
                    useXAxis        :true,
                    iconCls         :'ux-notification-icon-error',
                    html            :'<h2>' + Locale['Username or password not correct.'] + '</h2>'
                }).show();
            }
        });
    },

    logoutHandler:function () {
        Ext.Ajax.request({
            url    :'service/account/logout',
            method :'GET',
            headers:{'Accept':'application/json'},
            scope  :this,
            success:function (response, options) {
                var reader = new Ext.data.reader.Json({
                    model          :'App.model.core.user.Role',
                    totalProperty  :'total',
                    successProperty:'success',
                    root           :'data'
                });
                var roles = reader.read(response).records;
                this.getLogin().down('textfield[name=password]').reset();
                this.setRoles(roles);
                this.getContent().getLayout().setActiveItem('home');
                this.fireEvent('stateChanged', roles);
            },
            failure:function (response, options) {
                Ext.Msg.alert('Server Error', 'User has not logged out correctly');
            }
        });
    },

    recoverPassword:function (button) {
        var params = Ext.urlDecode(window.location.search.substring(1));
        var form = this.getPasswordRecovery().getForm();
        form.submit({
            url    :'service/account/recover',
            headers:{
                'Accept':'application/json'
            },
            params :{
                language:params.lang
            },
            method :'POST',
            scope  :this,
            success:function (form, action) {
                form.reset();
                this.getLogin().hide();
                Ext.create('widget.uxNotification', {
                    corner          :'tr',
                    cls             :'ux-notification-light',
                    width           :200,
                    height          :130,
                    autoDestroyDelay:8000,
                    useXAxis        :true,
                    iconCls         :'ux-notification-icon-information',
                    html            :'<h2>' + Locale['An email with your account data was sent to you.'] + '</h2>'
                }).show();
            },
            failure:function (form, action) {
                Ext.create('widget.uxNotification', {
                    corner          :'tr',
                    cls             :'ux-notification-light',
                    width           :200,
                    height          :130,
                    autoDestroyDelay:8000,
                    useXAxis        :true,
                    iconCls         :'ux-notification-icon-error',
                    html            :'<h2>' + Locale['Sorry, we could not find your email address, please try again.'] + '</h2>'
                }).show();
            }
        });
    },

    hasRoles:function (requiredRoles) {
        var actualRoles = this.getRoles();

        return Ext.Array.some(requiredRoles, function (requireRole) {
            switch (requireRole) {
                case 'guest' :
                {
                    return actualRoles.length == 0;
                }
                case 'reviewer' :
                {
                    return Ext.Array.some(actualRoles, function (role) {
                        var roleType = role.get('roleType');
                        return roleType === 'reviewer'
                    });
                }
                case 'organiser' :
                {
                    return Ext.Array.some(actualRoles, function (role) {
                        var roleType = role.get('roleType');
                        return roleType === 'organiser'
                    });
                }
                case 'suborganiser' :
                {
                    return Ext.Array.some(actualRoles, function (role) {
                        var roleType = role.get('roleType');
                        return roleType === 'suborganiser'
                    });
                }
                case 'admin' :
                {
                    return Ext.Array.some(actualRoles, function (role) {
                        var roleType = role.get('roleType');
                        return roleType === 'admin'
                    });
                }
                case 'person' :
                {
                    return Ext.Array.some(actualRoles, function (role) {
                        var roleType = role.get('roleType');
                        return roleType === 'person'
                    });
                }
            }

        });
    },

    isOrganizer : function() {
        return this.hasRoles(['suborganiser','admin','organiser']);
    },

    isReviewer : function() {
        return this.hasRoles(['reviewer']);
    },

    initSecurityListener:function () {

        var SecurityInterceptor = {
            register:function (component) {
                if (Ext.isDefined(component.secured)) {
                    component.stateChanged = function (user) {
                        if (component.rendered) {
                            var layout, activeItem;
                            if (this.hasRoles(component.secured)) {
                                layout = component.ownerCt.getLayout();
                                if (layout instanceof Ext.layout.container.Card) {
                                    activeItem = layout.getActiveItem();
                                    if (activeItem === component) {
                                        component.show();
                                    } else {
                                        // do nothing because card layout manages visibility
                                    }
                                } else {
                                    component.show();
                                }
                            } else {
                                layout = component.ownerCt.getLayout();
                                if (layout instanceof Ext.layout.container.Card) {
                                    activeItem = layout.getActiveItem();
                                    if (activeItem === component) {
                                        component.hide();
                                    } else {
                                        // do nothing because card layout manages visibility
                                    }
                                } else {
                                    component.hide();
                                }

                            }
                        }
                    };
                    this.addListener('stateChanged', component.stateChanged, this);
                }
                return true;
            },

            unRegister:function (component) {
                if (Ext.isDefined(component.secured)) {
                    this.removeListener('stateChanged', component.stateChanged, this);
                }
                return true;
            }
        };


        Ext.ComponentManager.register = Ext.Function.createInterceptor(
            Ext.ComponentManager.register,
            SecurityInterceptor.register,
            this
        );

        Ext.ComponentManager.unregister = Ext.Function.createInterceptor(
            Ext.ComponentManager.unregister,
            SecurityInterceptor.unRegister,
            this
        );

    }

});