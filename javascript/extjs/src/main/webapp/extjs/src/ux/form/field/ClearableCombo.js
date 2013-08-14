Ext.define("Ext.ux.form.field.ClearableCombo",{
    extend:"Ext.form.field.ComboBox",
    alias:["widget.clearablecombo"],
    trigger1Cls:Ext.baseCSSPrefix+"form-clear-trigger",
    trigger2Cls:Ext.baseCSSPrefix+"form-arrow-trigger",
    onTrigger2Click:function(){
        var me=this;
        if(!me.readOnly&&!me.disabled){
            if(me.isExpanded){me.collapse();}
            else{
                me.onFocus({});
                if(me.triggerAction==="all"){me.doQuery(me.allQuery,true);}
                else{me.doQuery(me.getRawValue());}
            }
            me.inputEl.focus();
        }
    },
    onTrigger1Click:function(){
    	var me=this;
    	me.setValue('',true);
    }
});