Ext.define('App.controller.core.person.import.Person', {

    extend:'Ext.app.Controller',

    requires:[
        'Ext.Ajax',
        'Ext.data.reader.Json',
        'Ext.ComponentManager',
        'Ext.window.MessageBox',
        'Ext.container.Container',
        'Ext.ux.window.Notification'
    ],

    views:[
        'core.person.import.PersonForm',
        'core.person.import.PersonView'
    ],

    models:[
        'core.person.import.ImportedPerson',
        'core.error.Error'
    ],

    stores:[
        'core.person.import.ImportedPerson'
    ],


    refs:[
        {
            ref     :'content',
            selector:'#content'
        },
        {
            ref: 'personImportForm',
            selector:'core_person_import_PersonForm'
        },
        {
            ref: 'personImportUploadButton',
            selector:'core_person_import_PersonForm button[action=personImportUpload]'
        },
        {
            ref: 'personImportTemplateDownloadButton',
            selector:'core_person_import_PersonForm button[action=personImportTemplateDownload]'
        },
        {
            ref: 'personImportCancelButton',
            selector:'core_person_import_PersonForm button[action=personImportCancel]'
        },
        {
            ref: 'personImportExecuteButton',
            selector:'core_person_import_PersonForm button[action=personImportExecute]'
        }
    ],

    config:{
    },

    init:function () {
        this.control(
            {
                'core_person_import_PersonForm button[action=personImportUpload]' : {
                    click: this.importPersons
                },
                'core_person_import_PersonForm button[action=personImportCancel]' : {
                    click: this.cancelImport
                },
                'core_person_import_PersonForm button[action=personImportExecute]' : {
                    click: this.executeImport
                }
            }
        );
    },

    loadView: function() {
        this.getStore('core.person.import.ImportedPerson').load({
            scope: this,
            callback: function(e,response,f) {
                this.buttonControl(response.success)
            }
        });
    },

    buttonControl: function(success) {
        if(this.getStore('core.person.import.ImportedPerson').getCount() > 0) {
            this.getPersonImportUploadButton().hide();
            this.getPersonImportTemplateDownloadButton().hide();
            this.getPersonImportCancelButton().show();
            this.getPersonImportExecuteButton().show();
        }
        else {
            this.getPersonImportCancelButton().hide();
            this.getPersonImportExecuteButton().hide();
            this.getPersonImportUploadButton().show();
            this.getPersonImportTemplateDownloadButton().show();
        }
    },

    importPersons : function(button) {
        var form = button.up('form').getForm();
        var fileName = button.up('form').down('filefield').getValue();
        if(fileName.indexOf('\\') != -1) {
            var pathArray = fileName.split('\\');
            fileName = pathArray[pathArray.length-1];
        }
        button.up('form').down('hiddenfield').setValue(fileName);
        if(form.isValid()){
            var progressBox = Ext.MessageBox.show({
                title: Locale['Please wait'],
                msg: Locale['Reading participants...'],
                progressText: Locale['Reading...'],
                width:300,
                progress:true,
                closable:false
            });
            var f = function(v){
                return function(){
                    if(v == 12){
                    }else{
                        var i = v/11;
                        progressBox.updateProgress(i, Math.round(100*i)+'% completed');
                    }
                };
            };
            for(var i = 1; i < 13; i++){
                setTimeout(f(i), i*500);
            }
            form.submit({
                method: 'POST',
                url: 'service/persons/import',
                scope : this,
                headers :  {
                    'Accept': ['application/octet-stream','application/xml']
                },
                success: function(form, o) {
                    Ext.create('widget.uxNotification', {
                        corner: 'tr',
                        cls: 'ux-notification-light',
                        width: 200,
                        height: 130,
                        autoDestroyDelay: 8000,
                        useXAxis: true,
                        iconCls: 'ux-notification-icon-information',
                        html: '<h2>' + Locale['Participants successfully read.'] + '</h2>'
                    }).show();
                    progressBox.close();
                    this.loadView();
                },
                failure: function(fp, o) {
                    Ext.create('widget.uxNotification', {
                        corner: 'tr',
                        cls: 'ux-notification-light',
                        width: 200,
                        autoDestroyDelay: 15000,
                        useXAxis: true,
                        iconCls: 'ux-notification-icon-error',
                        html: '<h2>' +Locale['Error while reading'] + '</h2>'
                    }).show();
                    this.loadView();
                }
            });
        }
    },

    cancelImport : function() {
        Ext.Ajax.request({
            method: 'DELETE',
            url: 'service/persons/import/',
            scope : this,
            success: function(form, o) {
                Ext.create('widget.uxNotification', {
                    corner: 'tr',
                    cls: 'ux-notification-light',
                    width: 200,
                    height: 130,
                    autoDestroyDelay: 8000,
                    useXAxis: true,
                    iconCls: 'ux-notification-icon-information',
                    html: '<h2>' + Locale['Participant import canceled.'] + '</h2>'
                }).show();
                this.loadView();
            },
            failure: function(fp, o) {
            }
        });
    },

    executeImport : function() {
        Ext.MessageBox.confirm('Confirm', Locale['Are you sure you want to import the participants? A notification mail will also be sent to every imported participant.'], function (btn) {
            if (btn == 'yes') {
                var progressBox = Ext.MessageBox.show({
                    title: Locale['Please wait'],
                    msg: Locale['Executing import of participants...'],
                    progressText: Locale['Importing...'],
                    width:300,
                    progress:true,
                    closable:false
                });

                var timeoutFunction = function(progress){
                    return function(){
                        if(progress == 12){
                        }else{
                            var partialProgress = progress/11;
                            progressBox.updateProgress(partialProgress, Math.round(100*partialProgress)+'% completed');
                        }
                    };
                };
                for(var i = 1; i < 13; i++){
                    setTimeout(timeoutFunction(i), i*2000);
                }

                Ext.Ajax.request({
                    method: 'POST',
                    url: 'service/persons/import/execute/',
                    scope : this,
                    timeout: 300000,
                    success: function(request, con) {
                        var response = JSON.parse(request.responseText);
                        if(response.success) {
                            Ext.create('widget.uxNotification', {
                                corner: 'tr',
                                cls: 'ux-notification-light',
                                width: 200,
                                height: 130,
                                autoDestroyDelay: 8000,
                                useXAxis: true,
                                iconCls: 'ux-notification-icon-information',
                                html: '<h2>' +Locale['Participant import successfully executed'] +'</h2>'
                            }).show();
                        }
                        else {
                            Ext.create('widget.uxNotification', {
                                corner: 'tr',
                                cls: 'ux-notification-light',
                                width: 200,
                                height: 130,
                                autoDestroyDelay: 8000,
                                useXAxis: true,
                                iconCls: 'ux-notification-icon-error',
                                html: '<h2>'+ Locale['Participant import failed. There are errors in the data of some participants.'] +'</h2>'
                            }).show();
                        }
                        this.loadView();
                        progressBox.close();
                    }
                });
            }
        },this);
    }
});
