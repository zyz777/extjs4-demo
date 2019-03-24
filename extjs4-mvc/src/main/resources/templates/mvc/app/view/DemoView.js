Ext.define('extMvc.view.DemoView', {
    extend: Ext.panel,
    alias: 'widget.demo',
    store: 'DemoStore',
    queryMode: 'local',
    title: 'Demo的标题',
    buttons: [
        {text: 'update', action: 'updatePanelBody'}
    ],
    updateBody: function (html) {
        this.body.setHTML(html);
    }
});