Ext.define('App.controller.congress.organizer.Statistic', {

    extend: 'Ext.app.Controller',

    requires    : [
        'Ext.Ajax',
        'Ext.data.reader.Json',
        'Ext.ComponentManager',
        'Ext.window.MessageBox',
        'Ext.container.Container',
        'Ext.ux.window.Notification'
    ],

    stores: [
        'congress.organizer.Statistic'
    ],

    views: [
        'congress.organizer.StatisticPanel'
    ],

    config      : {
    },

    refs: [
        {
            ref: 'statisticPanel',
            selector: 'congress_organizer_StatisticPanel'
        },
        {
            ref: 'chart',
            selector: 'congress_organizer_StatisticPanel chart'
        },
        {
            ref: 'statisticInfoPanel',
            selector: 'congress_organizer_StatisticPanel container[itemId=statisticInfoPanel]'
        },
        {
            ref: 'yearComboBox',
            selector: 'congress_organizer_StatisticPanel combobox[name=year]'
        },
        {
            ref: 'monthComboBox',
            selector: 'congress_organizer_StatisticPanel combobox[name=month]'
        },
        {
            ref: 'statisticComboBox',
            selector: 'congress_organizer_StatisticPanel combobox[name=statistic]'
        },
        {
            ref:'statisticEmptyText',
            selector:'congress_organizer_StatisticPanel container[itemId=statisticEmptyText]'
        }
    ],

    init: function() {
        this.control(
            {
                'congress_organizer_StatisticPanel button' : {
                    click: this.drawChart
                }
            }
        );
    },

    loadView :  function() {
        var today = new Date();
        this.getYearComboBox().setValue(today.getFullYear());
        this.getMonthComboBox().setValue(today.getMonth()+1);
        this.getStatisticComboBox().setValue('Registration/register');
        this.drawChart();
    },

    drawChart: function() {

        var year = this.getYearComboBox().getValue();
        var month = this.getMonthComboBox().getValue();
        var statisticPath = this.getStatisticComboBox().getValue();
        var statistic = this.getStatisticComboBox().getRawValue();
        var monthName = this.getMonthComboBox().getRawValue();

        var queryParam = "";
        if(year != 0) {
            queryParam = '?year='+year;
            if(month != 0) {
                queryParam += '&month='+month;
            }
        }

        if(statisticPath != null && year != 0) {
            this.getStatisticEmptyText().hide();
            this.getStatisticInfoPanel().update({'statistic': statistic, 'year' : year, 'month' : monthName });
            this.getStore('congress.organizer.Statistic').setProxy({
                type :'rest',
                url : 'service/stat/'+statisticPath+queryParam,
                reader:  {
                    type            : 'json',
                    totalProperty   : 'total',
                    successProperty : 'success',
                    root            : 'data'
                }
            });
            this.getStore('congress.organizer.Statistic').load({
                scope: this,
                callback : function() {
                    this.getChart().axes.items[1].setTitle(monthName+' '+year);
                }
            });
        }
        else {
            Ext.Msg.alert('Status', Locale['Incomplete input for Statistic.']);
        }
    }

});