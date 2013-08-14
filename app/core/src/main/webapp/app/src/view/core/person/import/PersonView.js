Ext.define('App.view.core.person.import.PersonView', {

    extend:'Ext.view.View',
    alias :'widget.core_person_import_PersonView',

    requires:[
        'Ext.XTemplate',
        'Ext.data.reader.Xml'
    ],

    constructor:function (config) {
        Ext.apply(config, {
            trackResetOnLoad:true,
            errorReader:  Ext.create('Ext.data.reader.Xml', {
                model: 'App.model.core.error.Field',
                record: 'error',
                root: 'errors',
                successProperty: 'success',
                read: function(response) {
                    var data = response;

                    if (response) {
                        data = this.getResponseData(response);
                    }

                    if (data) {
                        return this.readRecords(data);
                    } else {
                        return this.nullResultSet;
                    }
                }
            })
        });
        this.callParent([config]);
    },

    margin : 10,

    store    :'core.person.import.ImportedPerson',
    emptyText : '<div style="margin: 0 30px 20px 44px">' +
        '<table><tr>' +
        '<td><div class="information_32x32" style="height: 32px; width: 32px"></div></td>' +
        '<td><h1 style="margin-left: 10px">' + Locale['No participants to import'] + '</h1></td>' +
        '</tr></table>' +
        '</div>',

    multiSelect    :false,

    itemSelector:'div.importedPerson',


    tpl:
        '<div style="width: 100%">' +
            '<tpl for=".">' +
                '<div style="width: 100%; margin-bottom: 20px;" class="importedPerson">' +
                    '<span style="display: inline-block;">' +
                        '<span style="font-size: 20px; vertical-align: 9px; margin-right: 5px;"><b>' +
                        '<tpl if="errors.length &gt; 0">' +
                        Locale['Error in row'] +
                        '</tpl>' +
                        '{row}.</b></span>'+
                    '</span>' +
                    '<span style="display: inline-block;"><div style="width: 32px; height: 32px; display: inline-block; margin-top: 5px;" class="user1_add_32x32"></div></span>' +
                    '<span style="display: inline-block; margin-left: 15px; vertical-align: -5px;">' +
                        '<tpl if="gender == \'MALE\'">' +
                        '<span style="display: inline-block;"><div class="male_24x24" style="height: 24px; width: 24px; margin: 10px;"></div></span>' +
                        '<span style="display: inline-block; vertical-align: 15px;"><b>{title} {firstname} {lastname}</b></span>' +
                        '</tpl>' +
                        '<tpl if="gender == \'FEMALE\'">' +
                        '<span style="display: inline-block;"><div class="female_24x24" style="height: 24px; width: 24px; margin: 10px; vertical-align: -10px;"></div></span>' +
                        '<span style="display: inline-block; vertical-align: 15px;"><b>{title} {firstname} {lastname}</b></span>' +
                        '</tpl>' +
                        '<tpl if="!gender"><span style="vertical-align: 15px;"><b>{title} {firstname} {lastname}</b></span></tpl>' +
                    '</span>' +
                    '<tpl if="errors.length == 0">' +
                    '<div><span style="width: 290px; display: inline-block;">' +
                        '<fieldset class="x-fieldset x-fieldset-default" style="margin-right: 10px; padding:5px; margin-bottom: 0;">' +
                            '<legend>'+Locale['Address']+'</legend>' +
                            '<table>' +
                                '<tr>' +
                                    '<td></td>' +
                                    '<td>' +
                                        '<div style="margin-left: 20px;"> ' +
                                            '<tpl if="!street">n/a</tpl>{street} <br/> ' +
                                            '<tpl if="!zipCode">n/a</tpl>{zipCode} <tpl if="!city">n/a</tpl>{city} <br/> ' +
                                            '<tpl if="!country">n/a</tpl>{country}' +
                                        '</div>' +
                                    '</td>' +
                                '</tr>' +
                            '</table>' +
                        '</fieldset>' +
                    '</span>' +

                    '<span style="width: 290px;; display: inline-block;">' +
                        '<fieldset class="x-fieldset x-fieldset-default" style="padding:5px; margin-bottom: 0;">' +
                            '<legend>'+Locale['Contact']+'</legend>' +
                            '<table>' +
                                '<tr>' +
                                    '<td rowspan="3"></td>' +
                                    '<td width="70px"><div style="margin-left: 20px;"> '+Locale['Phone']+' </div></td><td><tpl if="!phone">n/a</tpl>{phone}' +
                                    '</td>' +
                                '</tr>' +
                                '<tr>' +
                                    '<td width="70px"><div style="margin-left: 20px;"> '+Locale['Fax']+' </div></td><td><tpl if="!fax">n/a</tpl>{fax}</td>' +
                                '</tr>' +
                                '<tr>' +
                                    '<td colspan="2"><div style="margin-left: 20px;"><a href="mailto:{email}">{email}</a> </div></td>' +
                                '</tr>' +
                            '</table>' +
                        '</fieldset>' +
                    '</span></div>' +

                    '<div style="width: 290px;">' +
                        '<fieldset class="x-fieldset x-fieldset-default" style="margin-right: 10px; padding:5px;">' +
                            '<legend>'+Locale['Occupation']+'</legend>' +
                            '<table>' +
                                '<tr>' +
                                    '<td></td>' +
                                    '<td>' +
                                        '<div style="margin-left: 20px;">' +
                                            '{institute}' +
                                            '<tpl if="department"><br/> {department}</tpl>' +
                                            '<tpl if="position"><br/> {position}</tpl>' +
                                        '</div>' +
                                    '</td>' +
                                '</tr>' +
                            '</table>' +
                        '</fieldset>' +
                    '</div>' +
                    '</tpl>' +

                    '<tpl for="errors">' +
                        '<div style="margin-top: 15px;">' +
                            '<span style="display: inline-block;"><div style="width: 32px; height: 32px;" class="false_32x32"></div></span>' +
                            '<span style="display: inline-block; vertical-align: top; margin-left: 15px;">' +
                                '{field}: {msg}<br/>-> <b>{value}</b>' +
                            '</span> ' +
                        '</div>' +
                    '</tpl>' +
                '</div>' +
                '<hr/>' +
            '</tpl>' +
        '</div>'
    
});