Ext.define('Qwzn.LoginWin', {
    extend: 'Ext.window.Window',
    singleton: true, //单例
    hideMode: 'offsets',
    closeAction: 'hide',
    closable: false,
    resizable: false,
    title: '权威指南管理系统登录窗口',
    width: 300,
    height: 250,
    modal: true,
    currentTabIndex: 0,
    initComponent: function () {
        var me = this;
        me.fields = [];
        me.fields.push(
            Ext.widget("textfield", {
                fieldLabel: '用户名', name: 'username',
                allowBlank: false, tabIndex: 1,
                listeners: {
                    scope: me,
                    focus: me.setTabIndex
                }
            })
        );
        me.fields.push(
            Ext.widget("textfield", {
                fieldLabel: ' 密码 ', name: 'password', inputType: 'password',
                allowBlank: false, tabIndex: 2,
                listeners: {
                    scope: me,
                    focus: me.setTabIndex
                }
            })
        );
        me.fields.push(
            Ext.widget("textfield", {
                fieldLabel: '验证码', name: 'vcode',
                minLength: 6,
                allowBlank: false, tabIndex: 3,
                listeners: {
                    scope: me,
                    focus: me.setTabIndex
                }
            })
        );
        me.image = Ext.create(Ext.Img);

        me.form = Ext.create('Ext.form.Panel', {

        });

    }
});