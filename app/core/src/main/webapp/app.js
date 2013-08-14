Ext.application({

    requires:[
        'App.Localization',
        'Ext.form.field.VTypes',
        'Ext.form.field.ComboBox',
        'Ext.grid.Panel',
        'App.view.Viewport',
        'App.controller.core.locale.LocaleDe'
    ],

    name:'App',

    appFolder:'app/src',

    controllers:[
        'core.locale.Locale',
        'core.user.Authorization',
        'core.user.Register',

        'core.person.user.Person',
        'core.person.user.Address',
        'core.person.user.BillAddress',
        'core.person.user.Contact',
        'core.person.user.Occupation',

        'core.admin.Role'
    ],


    launch:function () {
        this.patch();
        Ext.create('App.view.Viewport', {
            renderTo:Ext.getBody()
        });
        Ext.apply(Ext.form.field.VTypes, {
            password        :function (val, field) {
                if (field.initialPasswordField) {
                    var pwd = Ext.getCmp(field.initialPasswordField);
                    return (val == pwd.getValue());
                }
                return true;
            },
            passwordText    :Locale['Passwords do not match'],
            emailConfirm    :function (val, field) {
                if (field.initialEmailField) {
                    var pwd = Ext.getCmp(field.initialEmailField);
                    return (val == pwd.getValue());
                }
                return true;
            },
            emailConfirmText:Locale['Email do not match']

        });
        var params = Ext.urlDecode(window.location.search.substring(1));

        if (Ext.isDefined(params.lang)) {
            if (params.lang == 'de') {
                var localeDe = Ext.create('App.controller.core.locale.LocaleDe');
                localeDe.doTranslation();
            }
        }
        else {
        }
    },

    // TODO Patch for ComboBox Loading Mask Issue - Needs to be removed when fixed
    // http://www.sencha.com/forum/showthread.php?152499-4.0.7-ComboBox-bug-with-load-mask&highlight=loading+mask
    patch :function () {
        Ext.override(Ext.form.field.ComboBox, {
            createPicker:function () {
                var me = this,
                    picker,
                    menuCls = Ext.baseCSSPrefix + 'menu',
                    opts = Ext.apply({
                        pickerField   :me,
                        selModel      :{
                            mode:me.multiSelect ? 'SIMPLE' : 'SINGLE'
                        },
                        floating      :true,
                        hidden        :true,
                        ownerCt       :me.ownerCt,
                        cls           :me.el.up('.' + menuCls) ? menuCls : '',
                        store         :me.store,
                        displayField  :me.displayField,
                        focusOnToFront:false,
                        pageSize      :me.pageSize,
                        tpl           :me.tpl,
                        loadMask      :me.queryMode === 'local' ? false : true
                    }, me.listConfig, me.defaultListConfig);

                picker = me.picker = Ext.create('Ext.view.BoundList', opts);
                if (me.pageSize) {
                    picker.pagingToolbar.on('beforechange', me.onPageChange, me);
                }

                me.mon(picker, {
                    itemclick:me.onItemClick,
                    refresh  :me.onListRefresh,
                    scope    :me
                });

                me.mon(picker.getSelectionModel(), {
                    'beforeselect'   :me.onBeforeSelect,
                    'beforedeselect' :me.onBeforeDeselect,
                    'selectionchange':me.onListSelectionChange,
                    scope            :me
                });

                return picker;
            }
        });
        Ext.override(Ext.grid.Panel, {
            // Returns row index of selected record or -1 if there is
            // no selection. To use call method like this:
            // var idx = grid.getSelectedRowIndex();
            getSelectedRowIndex          :function () {
                var r, s;
                r = this.getView().getSelectionModel().getSelection();
                s = this.getStore();
                return s.indexOf(r[0]);

            },
            // Returns currently selected record in a grid or -1 if there
            // is no selected record. To use call method like this:
            // var record = grid.getSelectedRecord();
            getSelectedRecord            :function () {
                var r;
                if (this.getView().getSelectionModel().hasSelection()) {
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
            getSelectedRecordAsParameters:function () {
                var r, params;
                if (this.getView().getSelectionModel().hasSelection()) {
                    r = this.getView().getSelectionModel().getSelection();
                    params = '?1=1';
                    for (value in r[0].data) {
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

