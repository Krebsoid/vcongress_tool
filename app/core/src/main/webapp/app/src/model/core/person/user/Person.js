Ext.define('App.model.core.person.user.Person', {

    extend : 'Ext.data.Model',

    fields : [
        'firstname',
        'lastname',
        'gender',
        'title'
    ],

    getName: function() {
        return this.get('firstname') + " " + this.get('lastname');
    }

});



