Ext.define('App.model.core.person.import.ImportedPerson', {

    extend : 'Ext.data.Model',

    fields : [
        'id',
        'row',
        'firstname',
        'lastname',
        'title',
        'gender',
        'street',
        'zipCode',
        'city',
        'country',
        'phone',
        'fax',
        'institute',
        'department',
        'position',
        'email'
    ],

    hasMany : {model: 'App.model.core.error.Error', name: 'errors' },

    getName: function() {
        return this.get('firstname') + " " + this.get('lastname');
    }

});