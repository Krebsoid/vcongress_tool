Ext.define('App.view.core.user.RegisterForm', {
    extend: 'Ext.form.Panel',
    alias : 'widget.person_user_Register',

    requires: [
        'Ext.form.Label',
        'Ext.form.field.Text',
        'Ext.layout.container.Anchor',
        'Ext.form.field.Checkbox',
        'Ext.form.FieldContainer',
        'Ext.form.field.Display',
        'Ext.layout.container.HBox',
        'Ext.form.FieldSet',
        'Ext.form.RadioGroup',
        'Ext.form.field.Radio',
        'Ext.form.RadioManager',
        'Ext.ux.form.field.ClearableCombo',
        'App.view.core.content.TermsAndConditionsWindow',
        'Ext.tip.ToolTip'
    ],

    bodyPadding: 20,

    fieldDefaults: {
        labelAlign: 'left',
        labelWidth: 200
    },

    items : [
        {
            html : '<div align="left" style="margin-left: 50px"><h1>'+Locale['Personal Data']+'</h1></div>' +
                '<div class="registration-wizard-step-1" style="width: 460px; height: 50px; margin-top: 10px; margin-bottom: 20px; margin-left: 20px"></div>',
            border : false
        },
        {
            xtype : 'container',
            border : 0,
            margin : '10 20 20 20',
            html : '<div>' +
                '<span style="display: inline-block">' +
                '<a href="http://www.scisertec.de" target="_blank">' +
                '<div class="congress-logo" style="width: 160px; height: 99px;"></div>' +
                '</a>' +
                '</span>' +
                '<span style="display: inline-block; text-align: right; width: 270px; vertical-align: 20px;">' +
                Congress_Title['Smaller'] +
                '<a href="http://www.scisertec.de" target="_blank">http://www.scisertec.de</a>' +
                '</span>' +
                '</div>'
        },
        {
            xtype:'fieldset',
            columnWidth: 0.5,
            title: Locale['Personal Data'],
            layout: 'anchor',
            items :[
                {
                    xtype: 'radiogroup',
                    fieldLabel: Locale['Gender'],
                    items: [
                        {boxLabel: Locale['female'], name: 'gender', inputValue: 'FEMALE', checked: true},
                        {boxLabel: Locale['male'], name: 'gender', inputValue: 'MALE'}
                    ]
                },
                {
                    xtype: 'clearablecombo',
                    fieldLabel: Locale['Title'],
                    labelWidth : 200,
                    editable: false,
                    name: 'title',
                    store : ['PhD', 'PD',  'Prof.']
                },
                {
                    xtype: 'textfield',
                    fieldLabel: Locale['First Name'] + ' *',
                    labelWidth : 200,
                    anchor  : '100%',
                    name: 'firstname',
                    allowBlank: false
                },
                {
                    xtype: 'textfield',
                    fieldLabel: Locale['Last Name'] + ' *',
                    labelWidth : 200,
                    anchor  : '100%',
                    name: 'lastname',
                    allowBlank: false
                },
                {
                    xtype: 'textfield',
                    fieldLabel: Locale['Position'],
                    labelWidth : 200,
                    anchor  : '100%',
                    name: 'position'
                },
                {
                    xtype: 'textfield',
                    fieldLabel: Locale['Institute'] + ' *',
                    labelWidth : 200,
                    anchor  : '100%',
                    name: 'institute',
                    allowBlank: false
                },
                {
                    xtype: 'textfield',
                    fieldLabel: Locale['Department'],
                    labelWidth : 200,
                    anchor  : '100%',
                    name: 'department'
                },
                {
                    xtype: 'textfield',
                    fieldLabel: Locale['Phone'] + ' *',
                    name: 'phone',
                    allowBlank  : false,
                    anchor  : '100%'
                },
                {
                    xtype: 'textfield',
                    fieldLabel: Locale['Fax'],
                    labelWidth : 200,
                    anchor  : '100%',
                    name: 'fax'
                }
            ]
        },
        {
            xtype       : 'fieldset',
            columnWidth : 0.5,
            title       : Locale['Address'],
            items       : [
                {
                    xtype       : 'textfield',
                    name        : 'street',
                    fieldLabel  : Locale['Street'] + ' *',
                    allowBlank  : false,
                    anchor      : '100%'
                },
                {
                    xtype       : 'textfield',
                    name        : 'zipCode',
                    fieldLabel  : Locale['Code'] + ' *',
                    allowBlank  : false,
                    anchor      : '100%'
                },
                {
                    xtype       : 'textfield',
                    name        : 'city',
                    fieldLabel  : Locale['City'] + ' *',
                    allowBlank  : false,
                    anchor      : '100%'
                },
                {
                    xtype: 'combobox',
                    fieldLabel: Locale['Country'] + ' *',
                    emptyText: Locale['Select a country'],
                    name: 'country',
                    displayField : 'name',
                    valueField : 'id',
                    autoSelect: true,
                    selectOnTab: true,
                    typeAhead: true,
                    forceSelection : true,
                    queryMode: 'local',
                    allowBlank  : false,
                    store: 'core.person.user.Country',
                    anchor      : '100%'
                }
            ]
        },
        {
            xtype:'fieldset',
            columnWidth: 0.5,
            title: Locale['Account'],
            layout: 'anchor',
            items : [
                {
                    xtype: 'textfield',
                    name : 'email',
                    id : 'email',
                    vtype : 'email',
                    labelWidth : 200,
                    anchor  : '100%',
                    allowBlank  : false,
                    fieldLabel: Locale['Email Address'] + ' *'
                },
                {
                    xtype: 'textfield',
                    name : 'emailConfirm',
                    vtype : 'emailConfirm',
                    labelWidth : 200,
                    anchor  : '100%',
                    fieldLabel: Locale['Confirm Email Address'] + ' *',
                    allowBlank  : false,
                    initialEmailField: 'email'
                },
                {
                    xtype: 'textfield',
                    fieldLabel: Locale['Select a password'] + ' *',
                    anchor  : '100%',
                    id: 'password',
                    labelWidth : 200,
                    name: 'password',
                    allowBlank: false,
                    inputType: 'password',
                    vtype: 'password'
                },
                {
                    xtype: 'textfield',
                    fieldLabel: Locale['Confirm Password'] + ' *',
                    anchor  : '100%',
                    id: 'passwordConfirm',
                    labelWidth : 200,
                    name: 'passwordConfirm',
                    inputType: 'password',
                    vtype: 'password',
                    allowBlank: false,
                    initialPasswordField: 'password'
                }
            ]
        },
        {
            xtype:'fieldset',
            columnWidth: 0.5,
            title: Locale['Disclaimer'] + ' / ' + Locale['Photo'] +' *',
            layout: 'anchor',
            items : [
                {
                    xtype: 'fieldcontainer',
                    layout : 'hbox',
                    items: [
                        {
                            xtype: 'checkbox',
                            fieldLabel: Locale['Disclaimer'],
                            hideLabel: true,
                            name: 'disclaimer',
                            flex : 1,
                            getErrors: function() {
                                return this.getValue() ? [] : [Locale['You must accept the Disclaimer']]
                            }
                        },
                        {
                            xtype : 'container',
                            flex : 5,
                            width : 350,
                            items : [
                                {
                                    xtype : 'displayfield',
                                    value : Locale['Terms and Conditions']
                                }
                            ],
                            listeners: {
                                click: {
                                    element: 'el',
                                    fn: function(){
                                        var termsAndConditionsWindow = Ext.ClassManager.instantiate('widget.content_TermsAndConditionsWindow');
                                        termsAndConditionsWindow.show();
                                    }
                                }
                            }
                        }
                    ]

                }
            ]
        },
        {
            xtype:'fieldset',
            columnWidth: 0.5,
            title: 'Information',
            layout: 'anchor',
            items : [
                {
                    xtype: 'fieldcontainer',
                    layout : 'hbox',
                    items: [
                        {
                            xtype: 'checkbox',
                            fieldLabel: 'Information',
                            hideLabel: true,
                            inputValue: true,
                            name: 'notification',
                            flex : 1
                        },
                        {
                            xtype : 'container',
                            flex : 5,
                            width : 350,
                            items : [
                                {
                                    xtype : 'displayfield',
                                    value : Locale['Notification Service Text']
                                }
                            ]
                        }
                    ]

                }
            ]
        },
        {
            html : Locale['Fields marked with * are mandatory and may not be empty!'],
            border : 0
        }
    ],

    dockedItems: [
        {
            xtype: 'toolbar',
            dock: 'bottom',
            items: [
                {
                    xtype: 'component',
                    id: 'formErrorState',
                    baseCls: 'form-error-state',
                    validText: Locale['Form is valid'],
                    invalidText: Locale['Form has invalid input'],
                    hidden : true,
                    width: 400,

                    tipTpl: Ext.create('Ext.XTemplate', '<ul><tpl for="."><li><span class="field-name"><b>{name}</b></span>: <span class="error">{error}</span></li></tpl></ul>'),

                    getTip: function() {
                        var tip = this.tip;
                        if (!tip) {
                            tip = this.tip = Ext.widget('tooltip', {
                                target: this.el,
                                title: Locale['Completion-Helper'],
                                autoHide: false,
                                anchor: 'bottom',
                                mouseOffset: [-11, -2],
                                closable: true,
                                constrainPosition: false,
                                cls: 'errors-tip'
                            });
                        }
                        return tip;
                    },

                    setErrors: function(errors) {
                        var me = this,
                            baseCls = me.baseCls,
                            tip = me.getTip();

                        errors = Ext.Array.from(errors);
                        if (errors.length) {
                            me.addCls(baseCls + '-invalid');
                            me.removeCls(baseCls + '-valid');
                            me.update(me.invalidText);
                            tip.setDisabled(false);
                            tip.update(me.tipTpl.apply(errors));
                        } else {
                            me.addCls(baseCls + '-valid');
                            me.removeCls(baseCls + '-invalid');
                            tip.setDisabled(true);
                            me.update(me.validText);
                        }
                    }
                },
                '->',
                {
                    text        : Locale['Register'],
                    action      : 'register',
                    width       : 75,
                    scale       : 'large',
                    iconAlign   : 'top',
                    iconCls     : 'save_32x32'
                }
            ]
        }
    ]

});