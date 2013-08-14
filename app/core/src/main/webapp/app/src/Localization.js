Ext.define('App.Localization', {

    singleton:true,

    requires:[
        'Ext.XTemplate'
    ],

    constructor:function (config) {
        this.callParent([config]);

        var params = Ext.urlDecode(window.location.search.substring(1)),
            language;

        if (!Ext.isDefined(params.lang))
            params.lang = 'en_GB';
        else if (params.lang != 'de_DE')
            params.lang = 'en_GB';

        language = params.lang;


        Ext.Class.registerPreprocessor('localization',
            function (cls, data, callback) {

                /*if (data.localize) {
                    Ext.require('App.localization.' + data.localize.bundle, function () {
                        var localization = App.localization[data.localize.bundle];

                        function traverse(root, object, path) {
                            for (var property in object) {
                                var propertyValue = object[property];

                                if (property == 'localization') {
                                    var parentNode = root,
                                        pathLength = path.length - 1,
                                        localizationKey = root.$className;
                                    for (var j = 0; j < pathLength; j++) {
                                        parentNode = parentNode[path[j]];
                                    }

                                    if (Ext.isString(propertyValue)) {
                                        parentNode[path[pathLength]] = localization[localizationKey][propertyValue][language];
                                    }
                                    if (Ext.isObject(propertyValue)) {
                                        var template = Ext.create('Ext.XTemplate', propertyValue.tpl);
                                        parentNode[path[pathLength]] = template.apply(localization[localizationKey][propertyValue.id][language], false);
                                    }
                                    break;
                                }

                                if (Ext.isObject(propertyValue)) {
                                    var newObjectPath = Ext.Array.clone(path);
                                    newObjectPath.push(property);
                                    traverse(root, propertyValue, newObjectPath);
                                }

                                if (Ext.isArray(propertyValue)) {
                                    for (var i = 0; i < propertyValue.length; i++) {
                                        var newArrayPath = Ext.Array.clone(path);
                                        newArrayPath.push(property);
                                        newArrayPath.push(i);
                                        traverse(root, propertyValue[i], newArrayPath);
                                    }
                                }

                            }
                        }

                        traverse(data, data, []);

                        if (callback) {
                            callback.call(this, cls, data);
                        }
                    });
                } else {
                    if (callback) {
                        callback.call(this, cls, data);
                    }
                }   */

            }, true, 'first');
    }

});