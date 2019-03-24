Ext.application({
   name: 'extMvc', //应用名称
   autoCreateViewport: true,
   models: ['DemoModel'],
   stores: ['DemoStore'],
   controllers: ['DemoController']

});