layui.config({
    base: '/lib/layui/extend/'
}).use(['table'], function () {
});
//防止弹窗
$(document).keydown(function (event) {
    if (event.keyCode == 13 || event.keyCode == 32) {
        $("*").blur();//去掉焦点
        if ($(".layui-layer-btn0").length > 0)
            parent.layer.closeAll();
    }
});
    //$('body').off('click').on('click', 'button', function () { $(this).blur(); })
function Layer() { };
Layer.prototype = {

    toplayer: window.top.layer,   // 获取顶层窗口的layer对象
    topWin: window.top,           // 获取顶层窗口对象
    colseTime: 1000,                // 关闭弹出框的默认时间 1S
    width: '65%',                 // 默认窗口的宽度
    height: '95%',               // 默认窗口的高度
    px: '%',                     // 对话框宽高单位，可改为px
    flag: true,
    /**
     * 警告框
     * @param {} content    警示的内容
     */
    showAlert: function (content) {
        this.toplayer.alert(content, { icon: 0 });
    },
    /**
     * 操作成功提示框
     * @param {} content    提示内容  默认：操作成功
     * @param {} callback    回调方法
     */
    showSucAlert: function (content, callback) {
        var length = arguments.length;   //  实际传入参数的长度
        var options = { icon: 1, time: this.colseTime };
        if (length == 0) {  // 没有传入任何参数
            this.toplayer.alert("操作成功", options);
        } else if (length == 1) { // 传入了提示内容
            this.toplayer.alert(content, options);
        } else if (length == 2) {  // 有回调函数的,将不自动关闭
            this.toplayer.alert(content, { icon: 1 }, callback);
        }
    },
    /**
     * 操作失败提示框
     * @param {} content    提示内容 默认：操作失败
     * @param {} time       关闭时间(单位毫秒) 默认：1S,0:表示不自动关闭  
     */
    showFailAlert: function (content, time) {
        var length = arguments.length;   //  实际传入参数的长度
        var options = { icon: 2, time: this.colseTime };
        if (length == 0) {  // 没有传入任何参数
            this.toplayer.alert("操作失败", options);
        } else if (length == 1) { // 传入了提示内容
            this.toplayer.alert(content, options);
        } else if (length == 2) { // 传入了关闭时间
            options.time = time;
            this.toplayer.alert(content, options);
        }
    },
    /**
     * 打开一个对话框(没有回调函数)
     * @param {} title       对话框标题(必须)
     * @param {} url        对话框URL(必须)
     * @param {} width        对话框宽度 默认：65%
     * @param {} height        对话框高低 默认：95%
     */
    openDialogNoCallBack: function (title, url, width, height) {
        this.toplayer.open({
            type: 2,
            title: title,
            content: url,
            maxmin: true,
            scrollbar: false,
            area: [width, height],
            success: function (layero) {
                // flag = false;
                $(':focus').blur();
            }
        });
    },

    /**
     * 获取当前的窗口对象
     * @return {}
     */
    getCurrentWin: function () {
        return this.topWin.frames['ifr_center'];
    },

    /**
     * 打开一个对话框(带回调函数)
     * @param {} title       对话框标题(必须)
     * @param {} url        对话框URL(必须)
     * @param {} width        对话框宽度 默认：65%
     * @param {} height        对话框高低 默认：95%
     */
    openDialogWithCallBack: function (title, url, width, height, callback) {
        this.toplayer.open({
            type: 2,
            title: title,
            content: url,
            area: [width, height],
            maxmin: true,
            end: callback,
            success: function (layero) {
                // flag = false;
                $(':focus').blur();
            }

        });
    },
    /**
 * 打开一个对话框(没有回调函数)
 * @param {} title       对话框标题(必须)
 * @param {} url        对话框URL(必须)
 * @param {} width        对话框宽度 默认：65%
 * @param {} height        对话框高低 默认：95%
 * @param {} callback   窗口销毁时的回调方法
 */
    openDialog: function (title, url, width, height, callback) {
        var length = arguments.length;   //  实际传入参数的长度
        if (length == 2) {   // 默认宽高
            this.openDialogNoCallBack(title, url, this.width, this.height)
        } else if (length == 3) {  // 只传入宽度参数
            width += this.px;
            this.openDialogNoCallBack(title, url, width, this.height)
        } else if (length == 4) {  // 传入宽度和高度
            width += this.px;
            height += this.px;
            this.openDialogNoCallBack(title, url, width, height)
        } else if (length == 5) {   // 带回调函数
            width += this.px;
            height += this.px;
            this.openDialogWithCallBack(title, url, width, height, callback);
        }
    },
    /**
    * 打开一个对话框(没有回调函数，在内框架里)
    * @param {} title       对话框标题(必须)
    * @param {} url        对话框URL(必须)
    * @param {} width        对话框宽度 默认：65%
    * @param {} height        对话框高低 默认：95%
    * @param {} callback   窗口销毁时的回调方法
    */
    openDialog1: function (title, url, width, height, callback1) {
        var length = arguments.length;   //  实际传入参数的长度
        if (length == 2) {   // 默认宽高
            this.openDialogNoCallBack1(title, url, this.width, this.height)
            console.log(this.width, this.height);
        } else if (length == 3) {  // 只传入宽度参数
            width += this.px;
            this.openDialogNoCallBack1(title, url, width, this.height)
            console.log(width, this.height);
        } else if (length == 4) {  // 传入宽度和高度
            width += this.px;
            height += this.px;
            this.openDialogNoCallBack1(title, url, width, height)
            console.log(width, height);
        } else if (length == 5) {   // 带回调函数
            width += this.px;
            height += this.px;
            this.openDialogWithCallBack1(title, url, width, height, callback1);
            console.log(title, url, width, height, callback1);
        }
    },   //用于内窗口，不需要返回值使用
    openDialogNoCallBack1: function (title, url, width, height) {
        layer.open({
            offset: '15px',
            //maxmin: true,
            type: 2,
            title: title,
            content: url,
            //maxmin: true,
            scrollbar: false,
            area: [width, height],
            success: function (layero, index) {
                $(':focus').blur();
                setTimeout(function () {
                    layui.layer.tips('返回列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: [3, '#3595CC'], time: 2000,
                        area: ['80px', 'auto']
                    });
                }, 500)
            }
        });
    },   //用于内窗口，不需要返回值使用
    openDialogWithCallBack1: function (title, url, width, height, callback1) {
        console.log(title, url, width, height, callback1);
        layer.open({
            offset: '35px',
            //maxmin: true,
            type: 2,
            title: title,
            content: url,
            //maxmin: true,
            scrollbar: false,
            area: [width, height],
            success: function () {
                $(':focus').blur();
                setTimeout(function () {
                    layui.layer.tips('返回列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: [3, '#3595CC'], time: 2000,
                        area: ['80px', 'auto']
                    });
                }, 500)
            }
        });
    },
    openDialogLoad: function (content) {  //  load加载提示条
        var length = arguments.length;   //  实际传入参数的长度
        if (length == 0) {  // 没有传入任何参数
            this.openDialogLoadNoCallBack("数据加载中，请稍候!");
        } else if (length == 1) { // 传入了提示内容
            this.openDialogLoadNoCallBack(content);
        }
    },
    openDialogLoadNoCallBack: function (content) {
        var indexLayer = layer.load(2, {
            offset: ['50%', "35%"],
            shade: false,
            time: false,
            content: content,
            success: function (layero) {
                $(':focus').blur();
                layero.find('.layui-layer-content').css({
                    'padding-top': '40px', //文字与图标间隙
                    'textAlign': 'center', //文字居中
                    'backgroundPositionX': 'center', //背景位置居中
                    'width': '180px' //文字宽度
                });
                setTimeout(function () {
                    layer.close(indexLayer);
                }, false);
            }
        });
    },



    /**
     * 关闭弹出层
     * @param {} index
     */
    closeLayer: function (index) {
        this.toplayer.close(index);
    },
    /**
     * 关闭所有的Dialog
     */
    closeDialog: function () {
        this.toplayer.closeAll('iframe');
    },
    /**
     * 关闭Dialog带有操作成功的提示
     * @param {} content
     */
    closeDialogWithMsg: function (content) {
        this.toplayer.closeAll('iframe');
        if (!content) content = "操作成功";
        this.showSucMsg(content);
    },
    /**
     * 显示提示框
     * @param {} content
     */
    showMsg: function (content) {
        this.toplayer.msg(content, { time: this.colseTime });
    },
    /**
     * 显示操作成功的提示框
     * @param {} content
     */
    showSucMsg: function (content) {
        if (!content) content = "操作成功";
        this.toplayer.msg(content, { icon: 1, time: this.colseTime });
    },
    showTips: function (content, parameter) {
        if (!content) content = "项目不详";
        if (!parameter) parameter = "#parameter";
        this.toplayer.tips(content, parameter, {
            tips: [1, '#3595CC'],
            area: 'auto',
            tipsMore: true,
            time: this.colseTime
        });
    },


    /**
     * 显示验证框
     * @param {} content   提示内容
     * @param {} yesFunction 确定以后的回调函数
     */
    showConfirm: function (content, yesFunction) {
        this.toplayer.confirm(content, {
            btn: ['确定', '取消'],
            icon: 3
        }, yesFunction);
    }
};

var Layer = new Layer();

var table = layui.table;

