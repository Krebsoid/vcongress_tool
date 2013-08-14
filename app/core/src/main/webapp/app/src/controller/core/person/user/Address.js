Ext.define('App.controller.core.person.user.Address', {

    extend: 'Ext.app.Controller',

    requires : [
        'Ext.ux.window.Notification'
    ],

    models : [
        'core.person.user.Address',
        'core.person.user.Country'
    ],

    stores : [
        'core.person.user.Country'
    ],

    views: [
        'core.person.user.AddressForm'
    ],


    refs: [
        {
            ref     : 'addressForm',
            selector: 'person_user_Update person_user_address_Detail'
        }
    ],

    init: function() {
        this.control(
            {
                'person_user_Update person_user_address_Detail button[action=save]': {
                    click: this.save
                },
                'person_user_Update person_user_address_Detail': {
                    dirtychange: this.processUnsavedMessagePanel
                }
            });
    },

    loadView :  function() {
        this.setProxy();
        if(!this.getAddressForm().getForm().isDirty()) {
            this.getStore('core.person.user.Country').clearFilter();
            this.getStore('core.person.user.Country').load({
                scope: this,
                callback: function() {
                    App.model.core.person.user.Address.load('0',{
                        scope : this,
                        success : function(address) {
                            this.getAddressForm().getForm().loadRecord(address);
                        }
                    });
                }
            });
        }
    },

    loadViewAsOrganizer :  function(id) {
        this.setProxy(id);
        if(!this.getAddressForm().getForm().isDirty()) {
            this.getStore('core.person.user.Country').clearFilter();
            this.getStore('core.person.user.Country').load({
                scope: this,
                callback: function() {
                    App.model.core.person.user.Address.load('0',{
                        scope : this,
                        success : function(address) {
                            this.getAddressForm().getForm().loadRecord(address);
                        }
                    });
                }
            });

        }
    },

    setProxy: function(id) {
        var path = '';
        if(Ext.isEmpty(id))
            path = 'service/person/address';
        else
            path = 'service/persons/'+ id + '/address';

        this.getModel('core.person.user.Address').setProxy({
            type: 'rest',
            url : path,
            appendId : false,
            reader:  {
                type            : 'json',
                totalProperty   : 'total',
                successProperty : 'success',
                root            : 'data'
            }
        });
    },

    save: function(button) {
        var form = button.up('form');
        var model = form.getRecord();
        form.getForm().updateRecord(model);
        model.save({
            scope       : this,
            success     : function() {
                Ext.create('widget.uxNotification', {
                    corner: 'tr',
                    cls: 'ux-notification-light',
                    width: 200,
                    height: 130,
                    autoDestroyDelay: 8000,
                    useXAxis: true,
                    iconCls: 'ux-notification-icon-information',
                    html: '<h2>'+Locale['Changes successfully saved.']+'</h2>'
                }).show();
                this.hideUnsavedNotification();
                form.getForm().loadRecord(model);
            },
            failure     : function(form, action) {
                Ext.create('widget.uxNotification', {
                    corner: 'tr',
                    cls: 'ux-notification-light',
                    width: 200,
                    height: 130,
                    autoDestroyDelay: 8000,
                    useXAxis: true,
                    iconCls: 'ux-notification-icon-error',
                    html: '<h2>'+Locale['Failed to save the changes. Errors in some of your inputs.']+'</h2>'
                }).show();
            }
        });
    },

    processUnsavedMessagePanel : function(form, dirty, eOpts) {
        if(form.isDirty())
            this.showUnsavedNotification();
        else
            this.hideUnsavedNotification();
    },

    showUnsavedNotification : function() {
        this.getController('core.content.UnsavedChangeNotification').showNotification(Locale['Address Form']);
    },

    hideUnsavedNotification : function() {
        this.getController('core.content.UnsavedChangeNotification').hideNotification(Locale['Address Form']);
    }
});