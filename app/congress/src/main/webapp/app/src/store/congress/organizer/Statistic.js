Ext.define('App.store.congress.organizer.Statistic', {
    extend: 'Ext.data.Store',

    requires : [
        'Ext.Ajax',
        'Ext.data.reader.Json'
    ],

    fields : ['value','name']

});