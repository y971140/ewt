var table = layui.table;
var $ = layui.$;
var form = layui.form;
//防止弹窗
$(document).keydown(function (event) {
    if (event.keyCode == 13 || event.keyCode == 32) {
        $("*").blur();//去掉焦点
        if ($(".layui-layer-btn0").length > 0)
            parent.layer.closeAll();
    }
});
//$('body').off('click').on('click', 'button', function () { $(this).blur(); })
layui.use(['table', 'element', 'jquery', 'form', 'laypage', 'laydate'], function () {
    var $ = layui.jquery;
    var table = layui.table,
        laydate = layui.laydate,
        laypage = layui.laypage;
    form = layui.form;
    var tableIns = table.render({
        elem: '#item-table'
        , url: '/item/list'
        , page: true
        , height: 'full-60'
        , toolbar: '#toolbar'
        , theme: '#FFB801'
        , smartReloadModel: true
        , cols: [
            [
                { title: '操作', fixed: 'left', align: 'center', toolbar: '#column-toolbar' }
                , { type: 'checkbox' }
                , { type: 'numbers', title: '序号', sort: true, width: '5%' }
                , { field: 'id', title: 'ID', sort: true, width: '10%', hide: true }
                , { field: 'cid', title: '所属类目', width: 120, templet: '<div>{{sotitle(d.cid)}}</div>' }
                , { field: 'title', title: '商品标题', sort: true, width: '10%' }
                , { field: 'sellPoint', title: '商品卖点', sort: true, width: '260', totalRowText: '本页小计' }
                , { field: 'price', title: '商品价格', width: "120", templet: "#statusTpl1" }
                , { field: 'num', title: '库存数量', width: "12%", totalRow: true }
                , { field: 'barcode', title: '商品条码', width: "12%" }
                , { field: 'image', title: '商品图片', width: "80" }
                , { field: 'status', title: '商品状态', templet: "#statusTpl", sort: true, width: "160", totalRowText: '库存总额' }
                , { field: 'createTime', title: '创建时间', width: "120" }
                , { field: 'updateTime', title: '更新时间', width: "120" }
            ]
        ], done: function (res, curr, count) {
            //如果是异步请求数据方式，res即为你接口返回的信息。
            //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
        }
    });
    form.on('submit(search)', function (form) {
        table.reload('item-table', {
            where: form.field
        });
        return false;
    });

    /*  $("#search").click(function () {
         var params = $("#searchFrm").serialize();
         tableIns.reload({
             url: '/item/list?' + params
         });
     });
  */
    // 账号状态(正常/锁定)点击事件
    form.on('switch(status)', function (data) {
        if (data.elem.checked) {
            $.post('/item/' + data.value + '/enable', function (data) {
                handlerResult(data, enableDone);
            });
        } else {
            $.post('/item/' + data.value + '/disable', function (data) {
                handlerResult(data, disableDone);
            });
        }
    });

    function disableDone(data) {
        parent.layer.msg("禁用成功", { icon: 6 });
    }



    //监听行单击事件（双击事件为：rowDouble）
    table.on('rowDouble(item-table)', function (obj) {
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
        Layer.openDialog1('新增供应商', '/item', 40, 80);
    }

    /*  function edit(id) {
            Layer.openDialog1('修改供应商', '/item/'+id, 40, 80);
        } */

    function edit(data) {
        console.log(data.id);
        layer.open({
            content: '/item/' + data.id,
            title: "编辑",
            area: ['40%', '85%'],
            type: 2,
            maxmin: true,
            shadeClose: true,
            success: function (data) {
                $(':focus').blur();
                form.val("item-table", data);
            },
            end: function () {
                $(':focus').blur();
                table.reload('item-table');
            }
        });
    }



    //批量删除
    function pdel() {
        //得到选中行
        var checkStatus = table.checkStatus('item-table');
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
        if (dataLength > 0) {
            layer.confirm('确定删除【' + ids + '】供应商吗?', { Boolean: false, shade: [0.3, '#393D49'], icon: 3, title: '批量删除提醒' }, function (index) {
                $.post("/item/deleteAll", { "id": ids }, function (data) {
                    layer.close(index);
                    handlerResult(data, deleteDone);
                });
                layer.close(index);
            });
        } else {
            layer.msg("批量删除至少选中一项数据", { icon: 0 });
        }
    }
    function del(obj) {
        layer.confirm("确定删除供应商吗?", { icon: 3, title: '删除提醒' },
            function (index) {//确定回调
                var id = obj.data.id;
                $.post('/item/delete', { id: id }, function (data) {
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
        table.reload('item-table');
    }

    $(function () {
        //输入框的值改变时触发
        $("#mobile").on("input", function (e) {
            //获取input输入的值
            console.log(e.delegateTarget.value);
        });
    });

});
//将id变成内容，应用template模板
function sotitle(val) {
    var name;
    $.ajax({
        type: "get",
        url: "/item/cat/queryItemName",
        data: { itemCatId: val },
        cache: true,    //缓存
        async: false,    //表示同步   默认的是异步的true
        //dataType:"text",//表示返回值参数类型
        success: function (data) {
            name = data;
        }
    });
    return name;	//商品分类名称
};











