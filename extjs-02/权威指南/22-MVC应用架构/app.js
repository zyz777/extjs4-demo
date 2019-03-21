Ext.Loader.setConfig({
    enable: true, //开启动态加载
});

Ext.direct.Manager.addProvider(Ext.app.REMOTING_API);
Ext.ns('Qwzn.app');
Ext.require('Qwzn.LoginWin');

Ext.onReady(function () {
    Ext.state.Manager.setProvider(new Ext.state.CookieProvider({
        //设置登录状态的有效时间为 1小时
        expires: new Date(new Date().getTime()+(1000*60*60))
    }));
    if (Ext.util.Cookies.get('hasLogin') == true) {
        Ext.create('Qwzn.Application');
    } else {
        Qwzn.LoginWin.show();
    }
});