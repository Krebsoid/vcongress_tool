Ext.define('App.model.congress.participant.Participation', {

    extend : 'Ext.data.Model',

    fields : [
        {name: 'id', type: 'long', defaultValue: null},
        {name: 'participationStatusId', type: 'int', defaultValue: null},
        {name: 'participationStatusIdFixed', type: 'boolean', defaultValue: false},
        {name: 'workshop1', type: 'boolean', defaultValue: null},
        {name: 'workshop1Fixed', type: 'boolean', defaultValue: false},
        {name: 'workshop2', type: 'boolean', defaultValue: null},
        {name: 'workshop2Fixed', type: 'boolean', defaultValue: false},
        {name: 'workshop3', type: 'boolean', defaultValue: null},
        {name: 'workshop3Fixed', type: 'boolean', defaultValue: false},
        {name: 'eveningEventTickets', type: 'int', defaultValue: null},
        {name: 'eveningEventTicketsFixed', type: 'int', defaultValue: null},
        {name: 'eveningEventTicketsMax', type: 'int', defaultValue: null},
        {name: 'dirty', type: 'boolean', defaultValue: false},
        {name: 'vipStatus', type: 'boolean', defaultValue: false}
    ]
});