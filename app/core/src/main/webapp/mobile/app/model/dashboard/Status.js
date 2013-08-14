Ext.define('vCongress_Mobile.model.dashboard.Status', {

    extend:'Ext.data.Model',

    config: {
        fields:[
            {
                name:'paidStatus',
                type:'boolean'
            },
            {
                name:'participationStatus',
                type:'string'
            },
            {
                name:'workshop1',
                type:'boolean'
            },
            {
                name:'workshop2',
                type:'boolean'
            },
            {
                name:'workshop3',
                type:'boolean'
            },
            {
                name:'eveningEventTickets',
                type:'int'
            },
            {
                name:'noParticipation',
                type:'boolean'
            },
            {
                name:'regDate',
                type:'date',
                dateFormat:'c'
            },
            {
                name:'abstractCount',
                type:'int'
            },
            {
                name:'abstractsSubmitted',
                type:'int'
            },
            {
                name:'submissionStatus',
                type:'boolean'
            },
            {
                name:'vipStatus',
                type:'boolean'
            },
            {
                name:'price',
                type:'float'
            }
        ]
    }

});