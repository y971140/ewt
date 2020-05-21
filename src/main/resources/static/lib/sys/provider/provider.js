layui.config({
    base: '/lib/layui/extend/'
}).use(['table', 'element', 'form', 'dtree', 'tablePlug'], function () {
    var table = layui.table;
    var $ = layui.$;
    var form = layui.form;
    /*  //防止弹窗
      $(document).keydown(function (event) {
          if (event.keyCode == 13 || event.keyCode == 32) {
              $("*").blur();//去掉焦点
              if ($(".layui-layer-btn0").length > 0)
                  parent.layer.closeAll();
          }
      });*/
    //$('body').off('click').on('click', 'button', function () { $(this).blur(); })

    table.render({
        elem: '#provider-table'
        , url: '/provider/list'
        , cols: [
            [
                {title: '操作', fixed: 'left', align: 'center', toolbar: '#column-toolbar'}
                , {type: 'checkbox'}
                , {type: 'numbers', title: '序号', width: "60"}
                , {field: 'id', title: 'ID', sort: true, width: "80", hide: true}
                , {field: 'pid', title: 'PID', sort: true, width: "100", hide: true}
                , {field: 'pname', title: '供应商名称', sort: true, width: "180"}
                , {field: 'bankName', title: '联系人', width: "120"}
                , {field: 'mobile', title: '手机', width: "12%"}
                , {field: 'email', title: '邮箱', width: "12%"}
                , {field: 'genre', title: '性别', width: "80", templet:   function (d) {
                    return d.genre === 1 ? "男" : "女";
                }}
                , {field: 'isActivate', title: '状态', templet: "#statusTpl", width: "100"}
                , {field: 'createTime', title: '创建时间', sort: true, width: "160"}
                , {field: 'addr', title: '地址', width: "120"}
                , {field: 'remark', title: '备注', width: "120"}
            ]
        ]
        , page: true
        , done: function (res) {
            //  $('tbody').append('<div><tr>合计:</td><td colspan="13" align="center">' + 300 + '</td></tr></div>')
//            $('tbody').append('<div class="layui-form-item"><label class="layui-form-label">合计：</label>' +
//                '<div class="layui-input-block">' +
//                '<input type="text" name="title" lay-verify="title" disableDone autocomplete="off" placeholder="300" class="layui-input">' +
//                '</div>' +
//                '</div>'
//            )
        }
    });
    // 账号状态(正常/锁定)点击事件
    form.on('switch(isActivate)', function (data) {
        if (data.elem.checked) {
            $.post('/provider/' + data.value + '/enable', function (data) {
                handlerResult(data, enableDone);
            });
        } else {
            $.post('/provider/' + data.value + '/disable', function (data) {
                handlerResult(data, disableDone);
            });
        }
    });
    //$('#page').css('text-align', 'right');  // 分页右对齐
    $('#page').css('text-align', 'left');  // 分页左对齐
    //$('.layui-table-page').css('text-align', 'right');  // 数据表格分页右对齐
    $('.layui-table-page').css('text-align', 'left');  // 数据表格分页左对齐
    form.on('submit(search)', function (form) {
        table.reload('provider-table', {
            where: form.field
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        });
        return false;
    });


    function disableDone(data) {
        table.reload('provider-table');
        parent.layer.msg("禁用成功", {icon: 6});
    }

    function enableDone(data) {
        table.reload('provider-table');
        parent.layer.msg("激活成功", {icon: 6});
    }


    //监听行单击事件（双击事件为：rowDouble）
    table.on('rowDouble(provider-table)', function (obj) {
        var data = obj.data;

        layer.alert(JSON.stringify(data), {
            title: '当前行数据：'
        });

        //标注选中样式
        obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
    });
    // 工具条点击事件
    table.on('toolbar', function (obj) {
        var data = obj.data;
        var event = obj.event;
        var checkStatus = table.checkStatus(obj.config.id);
        if (event === 'add') {
            add();
        } else if (event === 'pdel') {
            pdel();
        }
    });
    // 行点击事件 重置密码
    table.on('tool', function (obj) {
        var data = obj.data;
        var event = obj.event;
        if (event === 'edit') {
            edit(data);
        } else if (event === 'del') {
            del(obj);
        }
    });

    function add() {
        layer.open({
            content: "/provider/",
            title: "新增",
            area: ['40%', '85%'],
            type: 2,
            maxmin: true,
            shadeClose: true,
            end: function () {
                table.reload('provider-table');
            }
        });
    }

    /*   function add() {
            Layer.openDialog1('新增供应商', '/provider/', 40, 80);
        }*/

    /*  function edit(id) {
            Layer.openDialog1('修改供应商', '/provider/'+id, 40, 80);
        } */

    /* function add() {
         layer.open({
             content: '/provider/',
             title: "新增供应商",
             area: ['40%', '85%'],
             type: 2,
             maxmin: true,
             shadeClose: true,
             success: function (data) {
                 $(':focus').blur();
                 form.val("provider-table", data);
             },
             end: function () {
                 $(':focus').blur();
                 table.reload('provider-table');
             }
         });
     }*/
    function edit(data) {
        console.log(data.id);
        layer.open({
            content: '/provider/' + data.id,
            title: "编辑",
            area: ['40%', '85%'],
            type: 2,
            maxmin: true,
            shadeClose: true,
            success: function (data) {
                $(':focus').blur();
                form.val("provider-table", data);
            },
            end: function () {
                $(':focus').blur();
                table.reload('provider-table');
            }
        });
    }


    //批量删除
    function pdel() {
        //得到选中行
        var checkStatus = table.checkStatus('provider-table');
        var dataLength = checkStatus.data.length;
        //获取选中行数据
        var data = checkStatus.data;
        var ids = 0;
        $.each(data, function (index, item) {
            if (index == 0) {
                ids += item.id;
            } else {
                ids += "," + item.id;
            }
        });
        var id = ids;
        if (dataLength > 0) {
            layer.confirm('确定删除【' + id + '】供应商吗?', {
                Boolean: false,
                shade: [0.3, '#393D49'],
                icon: 3,
                title: '批量删除提醒'
            }, function (index) {
                $.post("/provider/delall/" + id, {_method: "DELETE"}, function (data) {
                    layer.close(index);
                    handlerResult(data, deleteDone);
                });
                layer.close(index);
            });
        } else {
            layer.msg("批量删除至少选中一项数据", {icon: 0});
        }
    }

    function del(obj) {
        layer.confirm("确定删除供应商吗?", {icon: 3, title: '删除提示'},
            function (index) {//确定回调
                var id = obj.data.id;
                $.post('/provider/' + id, {_method: "DELETE"}, function (data) {
                    layer.close(index);
                    handlerResult(data, deleteDone);
                });
            }, function (index) {//取消回调
                layer.close(index);
            }
        );
    }

    function deleteDone(data) {
        parent.layer.msg("删除成功", {icon: 6});
        table.reload('provider-table');
    }

    $(function () {
        //输入框的值改变时触发
        $("#mobile").on("input", function (e) {
            //获取input输入的值
            console.log(e.delegateTarget.value);
        });
    });

});