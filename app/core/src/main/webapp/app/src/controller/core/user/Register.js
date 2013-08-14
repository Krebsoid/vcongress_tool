Ext.define('App.controller.core.user.Register', {

    extend: 'Ext.app.Controller',

    requires    : [
        'Ext.Ajax',
        'Ext.ComponentManager',
        'Ext.ux.window.Notification'
    ],

    models : [
        'core.person.user.Country'
    ],

    stores : [
        'core.person.user.Country'
    ],

    views: [
        'core.user.RegisterForm',
        'core.content.TermsAndConditionsWindow'
    ],

    refs: [
        {
            ref: 'content',
            selector: '#content'
        },
        {
            ref     : 'registration',
            selector: 'person_user_Register'
        },
        {
            ref     : 'registerButton',
            selector: 'person_user_Register button[action=register]'
        },
        {
            ref     : 'countryComboBox',
            selector: 'person_user_Register combobox[name=country]'
        }
    ],

    init: function() {
        this.addEvents({
            registerUser  : true
        });

        this.control(
            {
                'content_home button[action=register]': {
                    click: this.loadCountryStore
                },
                'person_user_Register button[action=register]': {
                    click: this.register
                },
                'person_user_Register field' : {
                    change: this.updateErrorState
                },
                'person_user_Register checkbox' : {
                    change: this.updateErrorState
                }
            }
        );
    },

    loadCountryStore: function() {
        this.getStore('core.person.user.Country').load({
            scope: this,
            callback : function() {
                this.getCountryComboBox().setValue('DE');
            }
        });
    },

    updateErrorState: function() {
        var me = this.getRegistration(),
            errorCmp, fields, errors;

        errorCmp = me.down('#formErrorState');
        errorCmp.show();
        fields = me.getForm().getFields();
        errors = [];
        fields.each(function(field) {
            Ext.Array.forEach(field.getErrors(), function(error) {
                errors.push({name: field.getFieldLabel(), error: error});
            });
        });

        errorCmp.setErrors(errors);
    },

    register : function() {
        var form = this.getRegistration().getForm();
        if(this.getRegistration().getForm().isValid()) {
            form.submit({
                url: 'service/register',
                method : 'POST',
                headers :  {'Accept': 'application/json'},
                waitTitle : Locale['Registration'],
                waitMsg : Locale['Please wait, registration is in progress...'],
                scope : this,
                success:function(form, action) {
                    this.reset();
                    this.fireEvent('registerUser', this);
                    Ext.create('widget.uxNotification', {
                        corner: 'tr',
                        cls: 'ux-notification-light',
                        width: 200,
                        height: 130,
                        autoDestroyDelay: 8000,
                        useXAxis: true,
                        iconCls: 'ux-notification-icon-information',
                        html: '<h2>'+Locale['Registration was successful.']+'</h2>'
                    }).show();
                },
                failure: function(form,action) {
                    this.getRegistration().getForm().checkValidity();
                    Ext.create('widget.uxNotification', {
                        corner: 'tr',
                        cls: 'ux-notification-light',
                        width: 200,
                        height: 130,
                        autoDestroyDelay: 8000,
                        useXAxis: true,
                        iconCls: 'ux-notification-icon-error',
                        html: '<h2>'+Locale['Registration failed, please correct the indicated errors and try again to register.']+'</h2>'
                    }).show();
                    var errors = [];
                    var errorCmp = this.getRegistration().down('#formErrorState');
                    Ext.Array.forEach(action.result.errors, function(error) {
                        var field = this.getRegistration().down('field[name='+error.id+']');
                        errors.push({name: field.getFieldLabel(), error: error.msg});
                    },this);
                    errorCmp.setErrors(errors);
                    errorCmp.getTip().show();
                }
            });
        }
        else {
            var errorCmp = this.getRegistration().down('#formErrorState');
            this.updateErrorState();
            errorCmp.show();
            errorCmp.getTip().show();
        }
    },

    reset : function() {
        this.getRegistration().getForm().reset();
        this.getContent().getLayout().setActiveItem('home');
    }

});