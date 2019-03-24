Ext.define('extMvc.controller.DemoController', {
    extend: Ext.app.Controller,

    refs: [{
        ref: 'demoView',
        selector: 'demo'
    }],
    stores: ['DemoStore'],
    init: function () {
        this.control({
            'demoView button[action=updatePanelBody]': {
                click: this.onDemoUpdate
            }
        });
    },
    onDemoUpdate: function () {
        this.getDemo().updateBody('body update');
    }

});