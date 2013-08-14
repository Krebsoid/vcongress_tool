Ext.application({

    requires: [
        'Ext.form.field.VTypes',
        'Ext.form.field.ComboBox',
        'Ext.grid.Panel',
        'App.view.Viewport',
        'App.controller.core.locale.LocaleDe'
    ],

    name: 'App',

    appFolder : 'app/src',

    controllers: [
        'core.locale.Locale',
        'core.user.Authorization',
        'core.user.Register',

        'congress.participant.Participation',

        'core.person.user.Person',
        'core.person.user.Address',
        'core.person.user.Contact',
        'core.person.user.Occupation'

    ],


    launch: function() {
        this.patch();
        Ext.create('App.view.Viewport', {
            renderTo: Ext.getBody()
        });
        Ext.apply(Ext.form.field.VTypes, {
            password : function(val, field) {
                if (field.initialPasswordField) {
                    var pwd = Ext.getCmp(field.initialPasswordField);
                    return (val == pwd.getValue());
                }
                return true;
            },
            passwordText : Locale['Passwords do not match'],
            emailConfirm : function(val, field) {
                if (field.initialEmailField) {
                    var pwd = Ext.getCmp(field.initialEmailField);
                    return (val == pwd.getValue());
                }
                return true;
            },
            emailConfirmText : Locale['Email do not match']
        });
        var params = Ext.urlDecode(window.location.search.substring(1));

        if(Ext.isDefined(params.lang)) {
            if(params.lang == 'de') {
                var localeDe = Ext.create('App.controller.core.locale.LocaleDe');
                localeDe.doTranslation();
            }
        }
        else {
        }
    },

    patch : function() {
        Ext.override(Ext.grid.Panel, {
            // Returns row index of selected record or -1 if there is
            // no selection. To use call method like this:
            // var idx = grid.getSelectedRowIndex();
            getSelectedRowIndex :  function(){
                var r, s;
                r = this.getView().getSelectionModel().getSelection();
                s = this.getStore();
                return s.indexOf(r[0]);

            },
            // Returns currently selected record in a grid or -1 if there
            // is no selected record. To use call method like this:
            // var record = grid.getSelectedRecord();
            getSelectedRecord : function(){
                var r;
                if(this.getView().getSelectionModel().hasSelection()){
                    var r = this.getView().getSelectionModel().getSelection();
                    return r[0];
                } else {
                    return -1;
                }
            },
            // Returns currently selected record as a parameter string which
            // will allow you to pass the row using an ajax call. If there is
            // no slection this will return -1. To use call like this:
            // var params = grid.getSelectedRecordAsParameters();
            getSelectedRecordAsParameters : function(){
                var r, params;
                if(this.getView().getSelectionModel().hasSelection()){
                    r = this.getView().getSelectionModel().getSelection();
                    params = '?1=1';
                    for (value in r[0].data){
                        params = params + '&' + value + '=' + r[0].get(value);
                    }
                } else {
                    params = -1;
                }
                return params;
            }
        });
    }


});