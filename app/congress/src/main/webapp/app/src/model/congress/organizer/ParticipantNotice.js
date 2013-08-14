Ext.define('App.model.congress.organizer.ParticipantNotice', {

    extend : 'Ext.data.Model',

    fields : [
        'id',
        'notice'
    ],

    proxy: {
        type: 'rest',
        url : 'service/participant/notice',
        reader:  {
            type            : 'json',
            totalProperty   : 'total',
            successProperty : 'success',
            root            : 'data'
        }
    }

});