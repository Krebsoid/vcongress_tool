Ext.define('App.controller.core.admin.Role', {

    extend:'Ext.app.Controller',

    requires:[
        'Ext.Ajax',
        'Ext.data.reader.Json',
        'Ext.ComponentManager',
        'Ext.window.MessageBox',
        'Ext.container.Container',
        'Ext.ux.window.Notification'
    ],

    models:[
        'core.admin.Role',
        'core.admin.User'
    ],

    stores:[
        'core.admin.Role'
    ],

    views:[
        'core.admin.RoleChangeForm'
    ],

    config:{
        loadingUser:false
    },


    refs:[
        {
            ref     :'content',
            selector:'#content'
        },
        {
            ref     :'userRoleChange',
            selector:'identity_admin_RoleChange'
        },
        {
            ref     :'userRoleChangeCombobox',
            selector:'identity_admin_RoleChange combobox'
        }
    ],

    init:function () {
        this.control(
            {
                'identity_admin_RoleChange combobox':{
                    change:this.updateUser
                }
            }
        );
    },

    loadRoleWidget:function (record) {
        if(this.getController('core.user.Authorization').hasRoles(['admin'])) {
            this.setLoadingUser(true);
            App.model.core.admin.User.load(record.data.name, {
                scope  :this,
                success:function (loadedUser) {
                    var detailedUser = this.getContent().query('identity_admin_RoleChange');
                    detailedUser[0].loadRecord(loadedUser);
                    this.setLoadingUser(false);
                    this.getUserRoleChange().show();
                }
            });
        }
    },

    loadData:function () {
        if(this.getController('core.user.Authorization').hasRoles(['admin'])) {
            this.getStore('core.admin.Role').load();
        }
    },

    updateUser:function (combobox, newValue) {
        if (!this.getLoadingUser()) {
            var record = this.getUserRoleChange().getForm().getRecord();
            if (Ext.isDefined(record)) {
                this.getUserRoleChange().getForm().submit({
                    url    :"/service/user/" + record.data.name + "/rolechange",
                    method :'PUT',
                    headers:{'Accept':'application/json'},
                    scope  :this,
                    success:function (response, options) {
                        Ext.create('widget.uxNotification', {
                            corner          :'tr',
                            cls             :'ux-notification-light',
                            width           :200,
                            height          :130,
                            autoDestroyDelay:8000,
                            useXAxis        :true,
                            iconCls         :'ux-notification-icon-information',
                            html            :'<h2>User Role Changed</h2>'
                        }).show();
                    }
                });
            }
        }
    }

});