Ext.define('App.view.core.person.import.PersonForm', {
    extend:'Ext.form.Panel',
    alias :'widget.core_person_import_PersonForm',

    requires:[
        'Ext.form.Label',
        'Ext.form.field.File',
        'Ext.layout.container.Anchor',
        'Ext.button.Button',
        'Ext.resizer.Splitter',
        'Ext.form.field.Hidden',
        'Ext.Img',
        'App.view.core.person.import.PersonView',
        'App.model.core.error.Field'
    ],

    bodyPadding:20,

    constructor:function (config) {
        Ext.apply(config, {
            trackResetOnLoad:true,
            errorReader:  Ext.create('Ext.data.reader.Xml', {
                model: 'App.model.core.error.Field',
                record: 'error',
                root: 'errors',
                successProperty: 'success',
                read: function(response) {
                    var data = response;

                    if (response) {
                        data = this.getResponseData(response);
                    }

                    if (data) {
                        return this.readRecords(data);
                    } else {
                        return this.nullResultSet;
                    }
                }
            })
        });
        this.callParent([config]);
    },

    dockedItems: [
        {
            xtype: 'toolbar',
            dock: 'top',
            items: [
                {
                    xtype: 'filefield',
                    name: 'personImport',
                    msgTarget: 'side',
                    allowBlank: false,
                    width: 350,
                    buttonText: Locale['Select .xlsx or .xls file...']
                },
                {
                    xtype: 'hiddenfield',
                    name: 'fileName'
                }

            ]
        },
        {
            xtype: 'toolbar',
            dock: 'left',
            width: 73,
            items: [
                {
                    text : Locale['Upload'],
                    action : 'personImportUpload',
                    width : 70,
                    scale : 'large',
                    iconAlign: 'top',
                    iconCls: 'users_into_32x32',
                    hidden: true
                },
                {
                    text : Locale['Download Template'],
                    action : 'personImportTemplateDownload',
                    href: 'service/persons/import/template',
                    width : 70,
                    scale : 'large',
                    iconAlign: 'top',
                    iconCls: 'column_preferences_32x32',
                    hidden: true
                },
                {
                    text : Locale['Execute'],
                    action : 'personImportExecute',
                    width : 70,
                    scale : 'large',
                    iconAlign: 'top',
                    iconCls: 'true_32x32',
                    hidden: true
                },
                {
                    text : Locale['Cancel'],
                    action : 'personImportCancel',
                    width : 70,
                    scale : 'large',
                    iconAlign: 'top',
                    iconCls: 'false_32x32',
                    hidden: true
                }
            ]
        }
    ],

    items:[
        {
            xtype : 'core_person_import_PersonView',
            margin: '40 0 0 20'
        }
    ]
});