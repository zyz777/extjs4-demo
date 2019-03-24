Ext.define('extMvc.view.ContentLeftView', {
    extend: Ext.Panel,
    alias: 'widget.contentleftview',
    layout: 'accordion',
    items: [
        {
            iconCls: 'icon-sys',
            title: '系统管理',
            xtype: 'treepanel',
            rootVisible: false,
            root: {
                children: [
                    {
                        iconCls: 'icon-user', text: '用户管理', leaf: true
                    },
                    {
                        iconCls: 'icon-org', text: '组织机构管理', leaf: true
                    },
                    {
                        iconCls: 'icon-auth', text: '权限管理', leaf: true
                    }
                ]
            }
        }
    ],
});
// Ext.define('extMvc.view.ContentCenterView', {
//     extend: Ext.Panel,
//     alias: 'widget.contentcenter'
// });



var northItem = {
    region: 'north',
    xtype: 'toolbar',
    items: [
        '<h2>Ext OA</h2>',
        '->', //右对齐
        {
            text: '登录',
            iconCls: 'icon-login',
            action: 'login'
        },
        {
            text: '修改密码',
            iconCls: 'icon-password',
            action: 'password'
        }
    ]
};
var westItem = {
    region: 'west',
    width: 150,
    xtype: 'contentleftview'
};
var centerItem = {
    region: 'center',
    xtype: 'contentcenter'
};

Ext.define("extMvc.view.ViewportView", {
    extend: Ext.container.Viewport,
    layout: 'border',
    // requires: [//主要是为了让 Ext 能够自动加载
    //     'extMvc.view.DemoView'
    // ],
    initComponent: function () {
        // this.items = [
        //     {xtype: 'demoView'}
        // ];
        // this.callParent();
        this.items = [northItem, westItem, centerItem];
        this.callParent();
    }
});
// Ext.onReady(function () {
//     Ext.create('extMvc.view.ViewportView', {
//         renderTo: Ext.getBody(),
//     });
// });