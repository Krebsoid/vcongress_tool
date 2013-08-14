Ext.define('App.controller.congress.participant.Participation', {

    extend: 'Ext.app.Controller',

    requires    : [
        'Ext.Ajax',
        'Ext.data.reader.Json',
        'Ext.ComponentManager',
        'Ext.window.MessageBox',
        'Ext.container.Container',
        'Ext.ux.window.Notification'
    ],

    models : [
        'congress.ParticipationStatus',
        'congress.participant.Participation'
    ],

    stores: [
        'congress.ChoosableParticipationStatus',
        'congress.EventTickets'
    ],

    views: [
        'congress.ParticipationStatusForm',
        'congress.CalculatedFeePanel',
        'congress.PaymentForwardingWindow',
        'core.admin.OrganizerManipulationInfoPanel',
        'congress.PaidPanel'
    ],

    config      : {
    },

    refs: [
        {
            ref: 'participationStatusForm',
            selector: 'congress_ParticipationStatusForm'
        },
        {
            ref: 'calculatedFeePanel',
            selector: 'congress_CalculatedFeePanel'
        },
        {
            ref: 'paidPanel',
            selector: 'congress_PaidPanel'
        },
        {
            ref: 'calculatedPriceInfo',
            selector: 'congress_CalculatedFeePanel #priceCalculation'
        },
        {
            ref: 'paymentForwardingWindow',
            selector: 'congress_PaymentForwardingWindow'
        },
        {
            ref: 'participationStatusComboBox',
            selector: 'congress_ParticipationStatusForm combobox[name=participationStatusId]'
        },
        {
            ref: 'workshop1CheckBox',
            selector: 'congress_ParticipationStatusForm checkbox[name=workshop1]'
        },
        {
            ref: 'workshop2CheckBox',
            selector: 'congress_ParticipationStatusForm checkbox[name=workshop2]'
        },
        {
            ref: 'workshop3CheckBox',
            selector: 'congress_ParticipationStatusForm checkbox[name=workshop3]'
        },
        {
            ref: 'eveningEventTicketComboBox',
            selector: 'congress_ParticipationStatusForm combobox[name=eveningEventTickets]'
        },
        {
            ref: 'bookedEveningEventTickets',
            selector: 'congress_ParticipationStatusForm panel[itemId=bookedTickets]'
        },
        {
            ref: 'organizerNotification',
            selector: 'core_admin_OrganizerManipulationInfoPanel[itemId=participation]'
        },
        {
            ref: 'organizerNotificationParticipantPanel',
            selector: 'core_admin_OrganizerManipulationInfoPanel[itemId=participation] #organizerManipulationPanel'
        },
        {
            ref: 'saveButton',
            selector: 'congress_ParticipationStatusForm button[action=save]'
        },
        {
            ref: 'paymentButton',
            selector: 'congress_ParticipationStatusForm button[action=payment]'
        }
    ],

    init: function() {
        this.control(
            {
                'congress_ParticipationStatusForm button[action=save]':{
                    click: this.save
                },
                'congress_ParticipationStatusForm button[action=payment]':{
                    click: this.navigatePayment
                },
                'congress_ParticipationStatusForm field' : {
                    change: this.calculatePrice
                },
                'congress_PaymentForwardingWindow button[action=forwardToPayment]' : {
                    click: this.navigatePayment
                },
                'congress_ParticipationStatusForm' : {
                    dirtychange: this.processUnsavedMessagePanel
                }
            }
        );
    },

    save : function(button) {
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
                    html: '<h2>'+Locale['Participation Status successfully updated.']+'</h2>'
                }).show();
                form.getForm().loadRecord(model);
                this.hideUnsavedNotification();
                if(!this.getController('core.user.Authorization').hasRoles(['organiser','admin'])) {
                    var paymentForwardingWindow = Ext.ClassManager.instantiate('widget.congress_PaymentForwardingWindow');
                    paymentForwardingWindow.addButtons();
                    paymentForwardingWindow.show();
                }
            }
        });
    },

    navigatePayment : function() {
        this.getController('main.navigation.Navigation').navigatePayment();
    },


    loadView :  function() {
        this.setProxy();
        if(!this.getParticipationStatusForm().getForm().isDirty()) {
            this.getStore('congress.ChoosableParticipationStatus').load({
                scope : this,
                callback : function() {
                    this.getStore('congress.EventTickets').load({
                        scope: this,
                        callback : function() {
                            App.model.congress.participant.Participation.load('active',{
                                scope : this,
                                success : function(participation) {
                                    this.getParticipationStatusForm().getForm().loadRecord(participation);
                                    var statusComboBox = this.getParticipationStatusForm().down('combobox[name=participationStatusId]');
                                    var workshop1 = this.getParticipationStatusForm().down('checkbox[name=workshop1]');
                                    var workshop2 = this.getParticipationStatusForm().down('checkbox[name=workshop2]');
                                    var workshop3 = this.getParticipationStatusForm().down('checkbox[name=workshop3]');
                                    var eveningEventTickets = this.getParticipationStatusForm().down('combobox[name=eveningEventTickets]');
                                    if(participation.get('eveningEventTicketsFixed') > 0) {
                                        this.getBookedEveningEventTickets().show();
                                        this.getBookedEveningEventTickets().update({ticketCount : participation.get('eveningEventTicketsFixed')});
                                    }
                                    else {
                                        this.getBookedEveningEventTickets().hide();
                                    }

                                    statusComboBox.setDisabled(participation.get('participationStatusIdFixed'));
                                    workshop1.setDisabled(participation.get('workshop1Fixed'));
                                    workshop2.setDisabled(participation.get('workshop2Fixed'));
                                    workshop3.setDisabled(participation.get('workshop3Fixed'));
                                    eveningEventTickets.setDisabled(participation.get('eveningEventTicketsFixed') == participation.get('eveningEventTicketsMax'));

                                    if (participation.get('dirty')) {
                                        this.getPaidPanel().show();
                                    } else {
                                        this.getPaidPanel().hide();
                                    }

                                    this.getOrganizerNotification().hide();
                                    this.getPaymentButton().show();
                                    this.calculatePrice();
                                }
                            });
                        }
                    });
                }
            });
        }
    },

    loadViewAsOrganizer :  function(id, firstname, lastname) {
        this.setProxy(id);
        this.getStore('congress.ChoosableParticipationStatus').load({
            scope : this,
            callback : function() {
                this.getStore('congress.EventTickets').load({
                    scope: this,
                    callback : function() {
                        App.model.congress.participant.Participation.load('0',{
                            scope : this,
                            success : function(participation) {
                                this.getParticipationStatusForm().getForm().loadRecord(participation);

                                var statusComboBox = this.getParticipationStatusForm().down('combobox[name=participationStatusId]');
                                var workshop1 = this.getParticipationStatusForm().down('checkbox[name=workshop1]');
                                var workshop2 = this.getParticipationStatusForm().down('checkbox[name=workshop2]');
                                var workshop3 = this.getParticipationStatusForm().down('checkbox[name=workshop3]');
                                var eveningEventTickets = this.getParticipationStatusForm().down('combobox[name=eveningEventTickets]');

                                if(participation.get('eveningEventTicketsFixed') > 0) {
                                    this.getBookedEveningEventTickets().show();
                                    this.getBookedEveningEventTickets().update({ticketCount : participation.get('eveningEventTicketsFixed')});
                                }
                                else {
                                    this.getBookedEveningEventTickets().hide();
                                }

                                statusComboBox.setDisabled(participation.get('participationStatusIdFixed'));
                                workshop1.setDisabled(participation.get('workshop1Fixed'));
                                workshop2.setDisabled(participation.get('workshop2Fixed'));
                                workshop3.setDisabled(participation.get('workshop3Fixed'));
                                eveningEventTickets.setDisabled(participation.get('eveningEventTicketsFixed') == participation.get('eveningEventTicketsMax'));

                                this.getOrganizerNotification().show();
                                this.getOrganizerNotificationParticipantPanel().update({firstname: firstname, lastname: lastname});
                                this.calculatePrice();
                                this.getPaymentButton().hide();
                                this.getPaidPanel().hide();
                            }
                        });
                    }
                });
            }
        });
    },

    setProxy: function(id) {
        var pathParticipant = '';
        var pathParticipantStatus = '';
        var pathEventTickets = '';
        if(Ext.isEmpty(id)) {
            pathParticipant = 'service/participant/participation/active';
            pathParticipantStatus = 'service/participant/status';
            pathEventTickets = 'service/participant/participation/active/eventtickets';
        }
        else {
            pathParticipant = 'service/participant/participation/admin/'+id;
            pathParticipantStatus = 'service/participant/status/all';
            pathEventTickets = 'service/participant/participation/admin/'+id+'/eventtickets';
        }

        this.getStore('congress.ChoosableParticipationStatus').setProxy({
            type: 'ajax',
            url : pathParticipantStatus,
            reader: {
                type            : 'json',
                totalProperty   : 'total',
                successProperty : 'success',
                root            : 'data'
            }
        });

        this.getModel('congress.participant.Participation').setProxy({
            type: 'rest',
            url : pathParticipant,
            appendId : false,
            reader:  {
                type            : 'json',
                totalProperty   : 'total',
                successProperty : 'success',
                root            : 'data'
            }
        });

        this.getStore('congress.EventTickets').setProxy({
            type: 'rest',
            url : pathEventTickets,
            appendId : false,
            reader:  {
                type            : 'json',
                totalProperty   : 'total',
                successProperty : 'success',
                root            : 'data'
            }
        });
    },

    calculatePrice : function() {
        var record = this.getParticipationStatusForm().getForm().getRecord();
        var vipStatus = record.data.vipStatus;

        var participationStatus = this.getParticipationStatusComboBox().getRawValue();
        var workshop1 = this.getWorkshop1CheckBox().getRawValue();
        var workshop2 = this.getWorkshop2CheckBox().getRawValue();
        var workshop3 = this.getWorkshop3CheckBox().getRawValue();
        var eveningEventTickets = this.getEveningEventTicketComboBox().getRawValue();

        var discount = 0;
        var price = 0;

        if(!vipStatus) {
            if(participationStatus == 'Participation Status 1 (early bird)' || participationStatus == 'Teilnehmer Status 1 (Fruehbucher)') {
                price = 300;
            }
            if(participationStatus == 'Participation Status 2 (early bird)' || participationStatus == 'Teilnehmer Status 2 (Fruehbucher)') {
                price = 150;
            }
            if(participationStatus == 'Participation Status 3 (early bird)' || participationStatus == 'Teilnehmer Status 3 (Fruehbucher)') {
                price = 30;
            }
            if(participationStatus == 'Participation Status 1' || participationStatus == 'Teilnehmer Status 1') {
                price = 600;
            }
            if(participationStatus == 'Participation Status 2' || participationStatus == 'Teilnehmer Status 2') {
                price = 300;
            }
            if(participationStatus == 'Participation Status 3' || participationStatus == 'Teilnehmer Status 3') {
                price = 60;
            }
        }
        if(workshop1) {
            price += 120
        }

        if(workshop2) {
            price += 90
        }

        if(workshop3) {
            price += 365
        }

        price += eveningEventTickets * 35;

        this.getCalculatedPriceInfo().update({price : price, discount : discount});
    },

    processUnsavedMessagePanel : function(form, dirty, eOpts) {
        if(form.isDirty())
            this.showUnsavedNotification();
        else
            this.hideUnsavedNotification();
    },

    showUnsavedNotification : function() {
        this.getController('core.content.UnsavedChangeNotification').showNotification(Locale['Participation Form']);
    },

    hideUnsavedNotification : function() {
        this.getController('core.content.UnsavedChangeNotification').hideNotification(Locale['Participation Form']);
    }

});