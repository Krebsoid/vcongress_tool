Ext.define('App.controller.core.person.user.Occupation', {

    extend: 'Ext.app.Controller',

    requires : [
        'Ext.ux.window.Notification'
    ],

    models : [
        'core.person.user.Occupation'
    ],

    views: [
        'core.person.user.OccupationForm'
    ],


    refs: [
        {
            ref     : 'occupationForm',
            selector: 'person_user_Update person_user_occupation_Detail'
        }
    ],

    init: function() {
        this.control(
            {
                'person_user_Update person_user_occupation_Detail button[action=save]': {
                    click: this.save
                },
                'person_user_Update person_user_occupation_Detail': {
                    dirtychange: this.processUnsavedMessagePanel
                }
            });
    },

    loadView :  function() {
        this.setProxy();
        if(!this.getOccupationForm().getForm().isDirty()) {
            App.model.core.person.user.Occupation.load('0',{
                scope : this,
                success : function(occupation) {
                    this.getOccupationForm().getForm().loadRecord(occupation);
                }
            });
        }
    },

    loadViewAsOrganizer :  function(id) {
        this.setProxy(id);
        if(!this.getOccupationForm().getForm().isDirty()) {
            App.model.core.person.user.Occupation.load('0',{
                scope : this,
                success : function(occupation) {
                    this.getOccupationForm().getForm().loadRecord(occupation);
                }
            });
        }
    },

    setProxy: function(id) {
        var path = '';
        if(Ext.isEmpty(id))
            path = 'service/person/occupation';
        else
            path = 'service/persons/'+ id + '/occupation';

        this.getModel('core.person.user.Occupation').setProxy({
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
            scope: this,
            success : function() {
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
        this.getController('core.content.UnsavedChangeNotification').showNotification(Locale['Occupation Form']);
    },

    hideUnsavedNotification : function() {
        this.getController('core.content.UnsavedChangeNotification').hideNotification(Locale['Occupation Form']);
    }
});