cordova.define("youyun-cn-plugin-im.YouYunIMPlugin", function(require, exports, module) {
var cordova = require('cordova');

var YouYunIMPlugin = function() {};

/*
 *1   login 登陆
 *successCallback成功回调方法
 *errorCallbac失败回调方法
 *options可不传
 =============================================================================*/

YouYunIMPlugin.prototype.login = function(successCallback, errorCallback, options) {
    if (!errorCallback) { errorCallback = function() {}; }

    if (typeof errorCallback !== 'function') {
        console.log('YouYunIMPlugin.login failure: failure parameter not a function');
        return;
    }

    if (typeof successCallback !== 'function') {
        console.log('YouYunIMPlugin.login failure: success callback parameter must be a function');
        return;
    }
    cordova.exec(successCallback, errorCallback, 'YouYunIMPlugin', 'login', [options]);
};

/*
  *2   发送消息
  *successCallback成功回调方法
  *errorCallbac失败回调方法
  *option是一个json对象，对象内容为用户ID，发送文本
  *例如：var json = {
            "toUserID": '139702',
            "content": Send_Test
        };
=============================================================================*/
YouYunIMPlugin.prototype.sendText = function(successCallback, errorCallback, options) {
    if (!errorCallback) { errorCallback = function() {}; }

    if (typeof errorCallback !== 'function') {
        console.log('YouYunIMPlugin.sendText failure: failure parameter not a function');
        return;
    }

    if (typeof successCallback !== 'function') {
        console.log('YouYunIMPlugin.sendText failure: success callback parameter must be a function');
        return;
    }
    cordova.exec(successCallback, errorCallback, 'YouYunIMPlugin', 'sendText', [options]);
};
/*
*3  发送图片
=============================================================================*/
YouYunIMPlugin.prototype.sendPic = function(successCallback, errorCallback, options) {
    if (!errorCallback) { errorCallback = function() {}; }

    if (typeof errorCallback !== 'function') {
        console.log('YouYunIMPlugin.sendPic failure: failure parameter not a function');
        return;
    }

    if (typeof successCallback !== 'function') {
        console.log('YouYunIMPlugin.sendPic failure: success callback parameter must be a function');
        return;
    }
    cordova.exec(successCallback, errorCallback, 'YouYunIMPlugin', 'sendImage', [options]);
};
/*
*4  创建群
 =============================================================================*/
YouYunIMPlugin.prototype.groupCreate = function(successCallback, errorCallback, options) {
    if (!errorCallback) { errorCallback = function() {}; }

    if (typeof errorCallback !== 'function') {
        console.log('YouYunIMPlugin.groupCreate failure: failure parameter not a function');
        return;
    }

    if (typeof successCallback !== 'function') {
        console.log('YouYunIMPlugin.groupCreate failure: success callback parameter must be a function');
        return;
    }
    cordova.exec(successCallback, errorCallback, 'YouYunIMPlugin', 'groupCreate', [options]);
};
/*
*5  获取用户总数
 =============================================================================*/
YouYunIMPlugin.prototype.groupGetTotalUsers = function(successCallback, errorCallback, options) {
    if (!errorCallback) { errorCallback = function() {}; }

    if (typeof errorCallback !== 'function') {
        console.log('YouYunIMPlugin.groupGetTotalUsers failure: failure parameter not a function');
        return;
    }

    if (typeof successCallback !== 'function') {
        console.log('YouYunIMPlugin.groupGetTotalUsers failure: success callback parameter must be a function');
        return;
    }
    cordova.exec(successCallback, errorCallback, 'YouYunIMPlugin', 'groupGetTotalUsers', [options]);
};

/*
*6  获取用户群列表
 =============================================================================*/
 YouYunIMPlugin.prototype.groupGetUserGroups = function(successCallback, errorCallback, options) {
    if (!errorCallback) { errorCallback = function() {}; }

    if (typeof errorCallback !== 'function') {
        console.log('YouYunIMPlugin.groupGetUserGroups failure: failure parameter not a function');
        return;
    }

    if (typeof successCallback !== 'function') {
        console.log('YouYunIMPlugin.groupGetUserGroups failure: success callback parameter must be a function');
        return;
    }
    cordova.exec(successCallback, errorCallback, 'YouYunIMPlugin', 'groupGetUserGroups', [options]);
};
/*
*7  添加群用户
 =============================================================================*/
YouYunIMPlugin.prototype.groupAddUser = function(successCallback, errorCallback, options) {
    if (!errorCallback) { errorCallback = function() {}; }

    if (typeof errorCallback !== 'function') {
        console.log('YouYunIMPlugin.groupAddUser failure: failure parameter not a function');
        return;
    }

    if (typeof successCallback !== 'function') {
        console.log('YouYunIMPlugin.groupAddUser failure: success callback parameter must be a function');
        return;
    }
    cordova.exec(successCallback, errorCallback, 'YouYunIMPlugin', 'groupAddUser', [options]);
};

/*
*8  删除群用户
 =============================================================================*/
YouYunIMPlugin.prototype.groupDeleteUser = function(successCallback, errorCallback, options) {
    if (!errorCallback) { errorCallback = function() {}; }

    if (typeof errorCallback !== 'function') {
        console.log('YouYunIMPlugin.groupDeleteUser failure: failure parameter not a function');
        return;
    }

    if (typeof successCallback !== 'function') {
        console.log('YouYunIMPlugin.groupDeleteUser failure: success callback parameter must be a function');
        return;
    }
    cordova.exec(successCallback, errorCallback, 'YouYunIMPlugin', 'groupDeleteUser', [options]);
};

/*
*9  退出群
=============================================================================*/
YouYunIMPlugin.prototype.groupExit = function(successCallback, errorCallback, options) {
    if (!errorCallback) { errorCallback = function() {}; }

    if (typeof errorCallback !== 'function') {
        console.log('YouYunIMPlugin.groupExit failure: failure parameter not a function');
        return;
    }

    if (typeof successCallback !== 'function') {
        console.log('YouYunIMPlugin.groupExit failure: success callback parameter must be a function');
        return;
    }
    cordova.exec(successCallback, errorCallback, 'YouYunIMPlugin', 'groupExit', [options]);
};
/*
*10 群聊发送信息
================================================================================*/
YouYunIMPlugin.prototype.sendGroupText = function(successCallback, errorCallback, options) {
    if (!errorCallback) { errorCallback = function() {}; }

    if (typeof errorCallback !== 'function') {
        console.log('YouYunIMPlugin.sendGroupText failure: failure parameter not a function');
        return;
    }

    if (typeof successCallback !== 'function') {
        console.log('YouYunIMPlugin.sendGroupText failure: success callback parameter must be a function');
        return;
    }
    cordova.exec(successCallback, errorCallback, 'YouYunIMPlugin', 'sendGroupText', [options]);
};

/*
* 11发送群图片
===================================================================================*/
YouYunIMPlugin.prototype.sendGroupImage = function(successCallback, errorCallback, options) {
    if (!errorCallback) { errorCallback = function() {}; }

    if (typeof errorCallback !== 'function') {
        console.log('YouYunIMPlugin.sendGroupImage failure: failure parameter not a function');
        return;
    }

    if (typeof successCallback !== 'function') {
        console.log('YouYunIMPlugin.sendGroupImage failure: success callback parameter must be a function');
        return;
    }
    cordova.exec(successCallback, errorCallback, 'YouYunIMPlugin', 'sendGroupImage', [options]);
};
/*
* 12下载图片
======================================================================================*/
YouYunIMPlugin.prototype.getFile = function(successCallback, errorCallback, options) {
    if (!errorCallback) { errorCallback = function() {}; }

    if (typeof errorCallback !== 'function') {
        console.log('YouYunIMPlugin.getFile failure: failure parameter not a function');
        return;
    }

    if (typeof successCallback !== 'function') {
        console.log('YouYunIMPlugin.getFile failure: success callback parameter must be a function');
        return;
    }
    cordova.exec(successCallback, errorCallback, 'YouYunIMPlugin', 'getFile', [options]);
};

/*
* 13登出
========================================================================================*/
YouYunIMPlugin.prototype.logout = function(successCallback, errorCallback, options) {
    if (!errorCallback) { errorCallback = function() {}; }

    if (typeof errorCallback !== 'function') {
        console.log('YouYunIMPlugin.logout failure: failure parameter not a function');
        return;
    }

    if (typeof successCallback !== 'function') {
        console.log('YouYunIMPlugin.logout failure: success callback parameter must be a function');
        return;
    }
    cordova.exec(successCallback, errorCallback, 'YouYunIMPlugin', 'logout', [options]);
};
/*
* 14服务器下发消息
=========================================================================================*/
YouYunIMPlugin.prototype.setReceiveMsgListener = function(successCallback, errorCallback, options) {
    if (!errorCallback) { errorCallback = function() {}; }

    if (typeof errorCallback !== 'function') {
        console.log('YouYunIMPlugin.setReceiveMsgListener failure: failure parameter not a function');
        return;
    }

    if (typeof successCallback !== 'function') {
        console.log('YouYunIMPlugin.setReceiveMsgListener failure: success callback parameter must be a function');
        return;
    }
    cordova.exec(successCallback, errorCallback, 'YouYunIMPlugin', 'setReceiveMsgListener', [options]);
};
/*
* 15 PUSH 启动PUSH服务 Android调用,IOS不需要
=========================================================================================*/
YouYunIMPlugin.prototype.pushConnect = function(successCallback, errorCallback, options) {
    if (!errorCallback) { errorCallback = function() {}; }

    if (typeof errorCallback !== 'function') {
        console.log('YouYunIMPlugin.pushConnect failure: failure parameter not a function');
        return;
    }

    if (typeof successCallback !== 'function') {
        console.log('YouYunIMPlugin.pushConnect failure: success callback parameter must be a function');
        return;
    }
    cordova.exec(successCallback, errorCallback, 'YouYunIMPlugin', 'pushConnect', [options]);
};
/*
* 16 PUSH 注册PUSH信息
=========================================================================================*/
YouYunIMPlugin.prototype.pushRegister = function(successCallback, errorCallback, options) {
    if (!errorCallback) { errorCallback = function() {}; }

    if (typeof errorCallback !== 'function') {
        console.log('YouYunIMPlugin.pushRegister failure: failure parameter not a function');
        return;
    }

    if (typeof successCallback !== 'function') {
        console.log('YouYunIMPlugin.pushRegister failure: success callback parameter must be a function');
        return;
    }
    cordova.exec(successCallback, errorCallback, 'YouYunIMPlugin', 'pushRegister', [options]);
};
/*
* 17 PUSH 注销PUSH
=========================================================================================*/
YouYunIMPlugin.prototype.pushUnRegister = function(successCallback, errorCallback, options) {
    if (!errorCallback) { errorCallback = function() {}; }

    if (typeof errorCallback !== 'function') {
        console.log('YouYunIMPlugin.pushUnRegister failure: failure parameter not a function');
        return;
    }

    if (typeof successCallback !== 'function') {
        console.log('YouYunIMPlugin.pushUnRegister failure: success callback parameter must be a function');
        return;
    }
    cordova.exec(successCallback, errorCallback, 'YouYunIMPlugin', 'pushUnRegister', [options]);
};
/*
* 18 PUSH 获取PUSH信息
=========================================================================================*/
YouYunIMPlugin.prototype.pushGetInfo = function(successCallback, errorCallback, options) {
    if (!errorCallback) { errorCallback = function() {}; }

    if (typeof errorCallback !== 'function') {
        console.log('YouYunIMPlugin.pushGetInfo failure: failure parameter not a function');
        return;
    }

    if (typeof successCallback !== 'function') {
        console.log('YouYunIMPlugin.pushGetInfo failure: success callback parameter must be a function');
        return;
    }
    cordova.exec(successCallback, errorCallback, 'YouYunIMPlugin', 'pushGetInfo', [options]);
};


var youyunIMPlugin = new YouYunIMPlugin();
module.exports = youyunIMPlugin;


});
