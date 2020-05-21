layui.config({
    base: '/lib/layui/extend/'
}).use(['table', 'element', 'form', 'dtree', 'tablePlug'], function () {
    var table = layui.table;
    var $ = layui.$;
    var form = layui.form;
    var dtree = layui.dtree;
    var tablePlug = layui.tablePlug;

    tablePlug.smartReload.enable(true);

    dtree.renderSelect({
        elem: "#deptTree",
        url: "/dept/tree",
        dataStyle: "layuiStyle",
        width: "100%",
        method: "GET",
        dot: false,
        menubar: true,
        response: {
            statusCode: 0,
            message: "msg",
            treeId: "id",
            parentId: "parentId",
            title: "name"
        }
    });

    dtree.on("node('deptTree')", function (obj) {
        var typeDom = layui.$('#deptId');
        console.log(typeDom.val(), obj.param.nodeId);
        console.log(typeDom.val() === obj.param.nodeId);
        if (typeDom.val() === obj.param.nodeId) {
            typeDom.val('');
            layui.$("input[dtree-id='deptTree']").val('请选择');
        } else {
            typeDom.val(obj.param.nodeId)
        }
    });

    table.render({
        elem: '#user-table'
        , url: '/user/list'
        , page: true
        , height: 'full-20'
        , toolbar: '#toolbar'
        , smartReloadModel: true
        , cols: [
            [
                { type: 'numbers', title: '序号', width: "5%" }
                , { field: 'userId', title: 'ID', width: "10%", hide: true }
                , { field: 'username', title: '用户名', width: "15%" }
                , { field: 'fullname', title: '姓名', width: "15%" }
                , { field: 'deptName', title: '部门', width: "12%" }
                , { field: 'email', title: '邮箱', width: "12%" }
                , { field: 'createTime', title: '创建时间', width: "12%" }
                , { field: 'lastLoginTime', title: '最后登陆时间', width: "12%" }
                , { field: 'status', title: '状态', templet: "#statusTpl", width: "12%" }
                , { title: '操作', fixed: 'right', align: 'center', toolbar: '#column-toolbar' }
            ]
        ]
    });

    // 账号状态(正常/锁定)点击事件
    form.on('switch(status)', function (data) {
        if (data.elem.checked) {
            $.post('/user/' + data.value + '/enable', function (data) {
                handlerResult(data, enableDone);
            });
        } else {
            if (data.value == 1) {
                layer.msg("管理员帐号不允许禁用！！！", { icon: 2 });
                table.reload('user-table');
                return false;
            }
            $.post('/user/' + data.value + '/disable', function (data) {
                handlerResult(data, disableDone);
            });
        }
    });

    // 工具条点击事件
    table.on('toolbar', function (obj) {
        var data = obj.data;
        var event = obj.event;

        if (event === 'add') {
            add();
        }
    });

    // 行点击事件 重置密码
    table.on('tool', function (obj) {
        var data = obj.data;
        var event = obj.event;
        if (event === 'edit') {
            edit(data.userId);
        } else if (event === 'reset') {
            layer.open({
                content: '/user/' + data.userId + "/reset",
                title: "重置密码",
                area: ['500px', '200px'],
                type: 2,
                maxmin: true,
                shadeClose: true,
                end: function () {
                    table.reload('user-table');
                }
            });
        } else if (event === 'del') {
            del(obj);
        }
    });
    function disableDone(data) {
        parent.layer.msg("禁用成功", { icon: 6 });
        table.reload('user-table');
    }
    function enableDone(data) {
        parent.layer.msg("激活成功", { icon: 6 });
        table.reload('user-table');
    }
    /**
     * openDialogNoCallBack1 参数，1标题，2链接，3窗口大小，4窗口ID，5要刷新的表（表格重载），如table.reload('user-table');
     * */
    function add(){
        Layer.NoParametersReturnPopUpWindow("新增会员", "/user", 95, 95, "NewWindowsUser","user-table");
    }
    function edit(id){
        Layer.NoParametersReturnPopUpWindow("修改会员", "/user/"+id, 95, 95, "UpdateWindowsUser","user-table");
    }
    function del(obj) {
        layer.confirm("确定删除用户吗?", { icon: 3, title: '提示' },
            function (index) {//确定回调
                var id = obj.data.userId;
                $.post('/user/' + id, { _method: "DELETE" }, function (data) {
                    layer.close(index);
                    handlerResult(data, deleteDone);
                });
            }, function (index) {//取消回调
                layer.close(index);
            }
        );
    }
    function deleteDone(data) {
        parent.layer.msg("删除成功", { icon: 6 });
        table.reload('user-table');
    }
    form.on('submit(search)', function (form) {
        table.reload('user-table', {
            where: form.field
        });
        return false;
    });

});
