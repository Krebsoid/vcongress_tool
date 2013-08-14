Ext.define('App.model.core.person.user.DetailedPerson', {

    extend : 'Ext.data.Model',

    fields : [
        'id',
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
        'email',
        'erroneous'
    ],

    proxy: {
        type: 'rest',
        url : 'service/persons/detailed',
        reader:  {
            type            : 'json',
            totalProperty   : 'total',
            successProperty : 'success',
            root            : 'data'
        }
    },

    getName: function() {
        return this.get('firstname') + " " + this.get('lastname');
    }

});