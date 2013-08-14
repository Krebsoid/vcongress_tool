Ext.define('App.controller.core.person.user.Person', {

    extend: 'Ext.app.Controller',

    requires    : [
        'Ext.Ajax',
        'Ext.data.reader.Json',
        'App.model.core.person.user.Person',
        'Ext.ComponentManager',
        'Ext.ux.window.Notification'
    ],

    models : [
        'core.person.user.Person'
    ],

    views: [
        'core.user.WelcomeToolbar',
        'core.person.user.UpdateTab'
    ],

    stores : [
        'core.person.user.Gender'
    ],


    refs: [
        {
            ref: 'content',
            selector: '#content'
        },
        {
            ref : 'navigation',
            selector : 'navigation'
        },
        {
            ref     : 'updateForm',
            selector: 'person_user_Update'
        },
        {
            ref     : 'personForm',
            selector: 'person_user_Update person_user_person_Detail'
        },
        {
            ref     :'accountTab',
            selector:'person_user_Update #accountTab'
        },
        {
            ref     : 'welcome',
            selector: 'identity_user_account_WelcomeBar'
        },
        {
            ref: 'organizerNotification',
            selector: 'core_admin_OrganizerManipulationInfoPanel[itemId=person]'
        },
        {
            ref: 'organizerNotificationParticipantPanel',
            selector: 'core_admin_OrganizerManipulationInfoPanel[itemId=person] #organizerManipulationPanel'
        }
    ],

    init: function() {

        this.addEvents({
            stateChanged  : true
        });

        this.getController('core.user.Authorization').on({
            stateChanged : this.accountStateChangedHandler,
            scope : this
        });

        this.control(
            {
                'person_user_Update person_user_person_Detail button[action=save]': {
                    click: this.save
                },
                'person_user_Update person_user_person_Detail': {
                    dirtychange: this.processUnsavedMessagePanel
                }
            }
        );
    },

    loadView : function() {
        this.getAccountTab().enable();
        this.load();
        this.getController('core.person.user.Occupation').loadView();
        this.getController('core.person.user.Contact').loadView();
        this.getController('core.person.user.Address').loadView();
        this.getController('core.person.user.BillAddress').loadView();
        this.getOrganizerNotification().hide();
    },

    loadViewAsOrganizer : function(id, firstname, lastname) {
        this.getAccountTab().disable();
        this.loadAsOrganizer(id);
        this.getController('core.person.user.Occupation').loadViewAsOrganizer(id);
        this.getController('core.person.user.Contact').loadViewAsOrganizer(id);
        this.getController('core.person.user.Address').loadViewAsOrganizer(id);
        this.getController('core.person.user.BillAddress').loadViewAsOrganizer(id);
        this.getOrganizerNotification().show();
        this.getOrganizerNotificationParticipantPanel().update({firstname: firstname, lastname: lastname});
    },

    accountStateChangedHandler : function(roles) {
        if (this.getController('core.user.Authorization').hasRoles(['person','organiser','admin','reviewer', 'suborganiser'])) {
            this.requestState();
        }
    },

    requestState : function() {
        Ext.Ajax.request({
            url     : 'service/person/state',
            method  : 'GET',
            headers :  {
                Accept        : 'application/json'
            },
            scope   : this,
            success:function(options) {
                var decode = Ext.JSON.decode(options.responseText);
                this.fireEvent('stateChanged', decode);
                this.getWelcome().down('tbtext[name=name]').setText(decode.data.firstname + " " + decode.data.lastname);

            }
        });
    },

    load :  function() {
        this.setProxy();
        if(!this.getPersonForm().getForm().isDirty()) {
            App.model.core.person.user.Person.load('0',{
                scope : this,
                success : function(person) {
                    this.getPersonForm().getForm().loadRecord(person);
                }
            });
        }
    },

    loadAsOrganizer :  function(id) {
        this.setProxy(id);
        if(!this.getPersonForm().getForm().isDirty()) {
            App.model.core.person.user.Person.load('0',{
                scope : this,
                success : function(person) {
                    this.getPersonForm().getForm().loadRecord(person);
                }
            });
        }
    },

    setProxy: function(id) {
        var path = '';
        if(Ext.isEmpty(id))
            path = 'service/person';
        else
            path = 'service/persons/'+ id;

        this.getModel('core.person.user.Person').setProxy({
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
                this.requestState();
                this.hideUnsavedNotification();
                form.getForm().loadRecord(model);
                this.getOrganizerNotificationParticipantPanel().update({firstname: model.data.firstname, lastname: model.data.lastname});
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
        this.getController('core.content.UnsavedChangeNotification').showNotification(Locale['Personal Form']);
    },

    hideUnsavedNotification : function() {
        this.getController('core.content.UnsavedChangeNotification').hideNotification(Locale['Personal Form']);
    }
});