Ext.define('App.controller.core.person.user.Contact', {

    extend: 'Ext.app.Controller',

    requires : [
        'Ext.ux.window.Notification'
    ],

    models : [
        'core.person.user.Contact'
    ],

    views: [
        'core.person.user.ContactForm'
    ],


    refs: [
        {
            ref     : 'contactForm',
            selector: 'person_user_Update person_user_contact_Detail'
        }
    ],

    init: function() {
        this.control(
            {
                'person_user_Update person_user_contact_Detail button[action=save]': {
                    click: this.save
                },
                'person_user_Update person_user_contact_Detail': {
                    dirtychange: this.processUnsavedMessagePanel
                }
            });
    },

    loadView :  function() {
        this.setProxy();
        if(!this.getContactForm().getForm().isDirty()) {
            App.model.core.person.user.Contact.load('0',{
                scope : this,
                success : function(contact) {
                    this.getContactForm().getForm().loadRecord(contact);
                }
            });
        }
    },

    loadViewAsOrganizer :  function(id) {
        this.setProxy(id);
        if(!this.getContactForm().getForm().isDirty()) {
            App.model.core.person.user.Contact.load('0',{
                scope : this,
                success : function(contact) {
                    this.getContactForm().getForm().loadRecord(contact);
                }
            });
        }
    },

    setProxy: function(id) {
        var path = '';
        if(Ext.isEmpty(id))
            path = 'service/person/contact';
        else
            path = 'service/persons/'+ id + '/contact';

        this.getModel('core.person.user.Contact').setProxy({
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
        this.getController('core.content.UnsavedChangeNotification').showNotification(Locale['Contact Form']);
    },

    hideUnsavedNotification : function() {
        this.getController('core.content.UnsavedChangeNotification').hideNotification(Locale['Contact Form']);
    }
});