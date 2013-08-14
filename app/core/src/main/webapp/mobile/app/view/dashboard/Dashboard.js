Ext.define('vCongress_Mobile.view.dashboard.Dashboard', {
    extend:'Ext.Panel',
    xtype:'dashboard',

    config : {

        border : 0,

        tpl:'<div style="margin: 10px">' +
            '<table class="dashboard" style="width: 100%; font-size: 12px;">' +
            '<tr>' +
            '<td width="55px"><div class="date-time_32x32" style="height: 32px; width: 32px; margin-left: 10px;"></div> </td>' +
            '<td><b>Registered since</b></td><td>{regDate:date("d F Y")}</td></tr>' +
            '<tpl if="noParticipation == false">' +
            '<tr>' +
            '<td width="55px"><div class="payment_32x32" style="height: 32px; width: 32px; margin-left: 10px;"></div> </td>' +
            '<td><div><b>Paid Status</b></div><div style="margin-top: 5px;"><b>Conference Fee:</b></div></td><td>' +
            '<tpl if="paidStatus == true"><div class="true_16x16" style="width: 16px; height: 16px"></div></tpl>' +
            '<tpl if="paidStatus == false"><div class="false_16x16" style="width: 16px; height: 16px"></div></tpl>' +
            '<div style="margin-top: 5px;"><b>{price} &euro; (incl. tax)</b></div></td></tr>' +
            '</tpl>' +
            '<tr>' +
            '<td><div class="id_card_32x32" style="height: 32px; width: 32px; margin-left: 10px;"></div> </td>' +
            '<td><b>Participation Status:</b></td><td>{participationStatus}' +
            '</td></tr>' +
            '<tpl if="noParticipation == true">' +
            '<tr style="">' +
            '<td><div class="warning_32x32" style="height: 32px; width: 32px; margin-left: 10px;"></div></td>' +
            '<td colspan="2"><b>You have no status for the congress chosen yet.</b>' +
            '</td></tr>'+
            '</tpl></table>'
        /*
            '<tpl if="workshop1 == true">' +
            '<tr>' +
            '<td><div class="id_card_add_32x32" style="height: 32px; width: 32px; margin-left: 20px;"></div> </td>' +
            '<td><span style="font-size: 14px;"><b>Workshop</b></span></td><td>' +
            'Workshop 1' +
            '</td></tr>' +
            '</tpl>'+
            '<tpl if="workshop2 == true">' +
            '<tr>' +
            '<td><div class="id_card_add_32x32" style="height: 32px; width: 32px; margin-left: 20px;"></div> </td>' +
            '<td><span style="font-size: 14px;"><b>Workshop</b></span></td><td>' +
            'Workshop 2' +
            '</td></tr>' +
            '</tpl>'+
            '<tpl if="workshop3 == true">' +
            '<tr>' +
            '<td><div class="id_card_add_32x32" style="height: 32px; width: 32px; margin-left: 20px;"></div> </td>' +
            '<td><span style="font-size: 14px;"><b>Workshop</b></span></td><td>' +
            'Workshop 3' +
            '</td></tr>' +
            '</tpl>'+
            '<tpl if="eveningEventTickets &gt; 0">' +
            '<tr>' +
            '<td><div class="id_card_add_32x32" style="height: 32px; width: 32px; margin-left: 20px;"></div> </td>' +
            '<td><span style="font-size: 14px;"><b>'+Locale['Evening Event']+'</b></span></td><td>' +
            '{eveningEventTickets} Ticket(s)' +
            '</td></tr>' +
            '</tpl>'+
            '<tpl if="abstractCount &gt; 0">' +
            '<tr>' +
            '<td><div class="abstract_32x32" style="height: 32px; width: 32px; margin-left: 20px;"></div> </td>' +
            '<td><span style="font-size: 14px;"><b>' + Locale['Abstracts submitted/ created'] + ':</b></span></td><td>' +
            '<tpl if="submissionStatus == true">' +
            '<span style="display: inline-block; vertical-align: 2px;">{abstractsSubmitted}/{abstractCount} </span>' +
            '<span style="display: inline-block;"><div class="true_16x16" style="width: 16px; height: 16px; margin-left: 10px;"></span>' +
            '</tpl>' +
            '<tpl if="submissionStatus == false">' +
            '<span style="display: inline-block; vertical-align: 2px;">{abstractsSubmitted}/{abstractCount} </span>' +
            '<span style="display: inline-block;"><div class="false_16x16" style="width: 16px; height: 16px; margin-left: 10px;"></div></span>' +
            '</tpl>' +
            '</td></tr>' +
            '<tpl if="abstractCount &gt; abstractsSubmitted">' +
            '<tr>' +
            '<td><div class="warning_32x32" style="height: 32px; width: 32px; margin-left: 20px;"></div></td>' +
            '<td colspan="2"><span style="font-size: 14px;"><b>' + Locale['You have abstracts that are not submitted yet.'] + '</b></span>' +
            '</td></tr>'+
            '</tpl>'+
            '</tpl>' +
            '<tpl if="vipStatus == true">' +
            '<tr>' +
            '<td><div class="star_32x32" style="height: 32px; width: 32px; margin-left: 20px;"></div></td>' +
            '<td colspan="2"><span style="font-size: 14px;"><b>' + Locale['VIP Status for this congress.'] + '</b>' +
            '<br/>'+ Locale['Only participation status is inclusive.'] +'</span>' +
            '</td></tr>' +
            '</tpl>' +
            '</table>' +
            '</div>' */
    }

});