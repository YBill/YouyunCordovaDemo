package cn.youyun.cordova;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

/**
 * Created by Bill on 2016/4/12.
 * IM插件
 */
public class YouYunIMPlugin extends CordovaPlugin {

    private Context context;
    private Activity activity;
    private CordovaWebView webView;
    private YouyunHandler handler;
    private CallbackContext receiveCallback;

    class YouyunHandler extends Handler {

        private WeakReference<YouYunIMPlugin> weakReference;

        public YouyunHandler(YouYunIMPlugin plugin) {
            weakReference = new WeakReference<YouYunIMPlugin>(plugin);
        }

        @Override
        public void handleMessage(final Message msg) {
            super.handleMessage(msg);
            if (weakReference.get() == null) {
                return;
            }
            if(msg == null)
                return;
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    sendSyncMessage(msg);
                }
            });

        }
    }

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        YouyunUtil.log("YouYunIMPlugin initialize");
        this.webView = webView;
        context = this.cordova.getActivity().getApplicationContext();
        activity = this.cordova.getActivity();
        if (handler == null)
            handler = new YouyunHandler(YouYunIMPlugin.this);
        YouyunInstance.getInstance().init(context, handler); // 初始化游云SDK
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if("setReceiveMsgListener".equals(action)){
            this.receiveCallback = callbackContext;
            YouyunUtil.log("注册监听成功");
            return true;
        }else if ("login".equals(action)) {
            login(callbackContext);
            return true;
        } else if ("logout".equals(action)) {
            logout(callbackContext);
            return true;
        } else if ("sendText".equals(action)) {
            String arg0 = args.getString(0);
            if (args != null) {
                JSONObject object = new JSONObject(arg0);
                if (object != null) {
                    String userId = object.optString("userID");
                    String content = object.optString("content");
                    String extContent = object.optString("extContent");
                    sendText(userId, content, extContent, ChatType.single, callbackContext);
                }
            }

            return true;
        } else if ("sendGroupText".equals(action)) {
            String arg0 = args.getString(0);
            if (args != null) {
                JSONObject object = new JSONObject(arg0);
                if (object != null) {
                    String groupId = object.optString("groupID");
                    String content = object.optString("content");
                    String extContent = object.optString("extContent");
                    sendText(groupId, content, extContent, ChatType.group, callbackContext);
                }
            }

            return true;
        } else if ("sendImage".equals(action)) {
            String arg0 = args.getString(0);
            if (args != null) {
                JSONObject object = new JSONObject(arg0);
                if (object != null) {
                    String uid = object.optString("userID");
                    String filePath = object.optString("filePath");
                    String thumbnailPath = object.optString("nailPath");
                    String extContent = object.optString("extContent");
                    sendImage(uid, filePath, thumbnailPath, ChatType.single, extContent, callbackContext);
                }
            }
            return true;
        } else if ("sendGroupImage".equals(action)) {
            String arg0 = args.getString(0);
            if (args != null) {
                JSONObject object = new JSONObject(arg0);
                if (object != null) {
                    String gid = object.optString("groupID");
                    String filePath = object.optString("filePath");
                    String thumbnailPath = object.optString("nailPath");
                    String extContent = object.optString("extContent");
                    sendImage(gid, filePath, thumbnailPath, ChatType.group, extContent, callbackContext);
                }
            }
            return true;
        }else if ("getFile".equals(action)) {
            String arg0 = args.getString(0);
            if (args != null) {
                JSONObject object = new JSONObject(arg0);
                if (object != null) {
                    String fileId = object.optString("fileID");
                    String filePath = object.optString("filePath");
                    int fileLength = object.optInt("length");
                    int pieceSize = object.optInt("pieceSize");
                    downloadImg(fileId, filePath, fileLength, pieceSize, callbackContext);
                }
            }
            return true;
        } else if ("groupCreate".equals(action)) {
            createGroup(callbackContext);
            return true;
        } else if ("groupGetTotalUsers".equals(action)) {
            String arg0 = args.getString(0);
            if (args != null) {
                JSONObject object = new JSONObject(arg0);
                if (object != null) {
                    String groupId = object.optString("groupID");
                    getUserListByGroupId(groupId, callbackContext);
                }
            }
            return true;
        } else if ("groupGetUserGroups".equals(action)) {
            String arg0 = args.getString(0);
            if (args != null) {
                JSONObject object = new JSONObject(arg0);
                if (object != null) {
                    String userId = object.optString("userID");
                    getGroupListByUserId(userId, callbackContext);
                }
            }
            return true;
        } else if ("groupAddUser".equals(action)) {
            String arg0 = args.getString(0);
            if (args != null) {
                JSONObject object = new JSONObject(arg0);
                if (object != null) {
                    String groupId = object.optString("groupID");
                    String userIds = object.optString("userIDs");
                    groupAddUser(groupId, userIds, callbackContext);
                }
            }
            return true;
        } else if ("groupDeleteUser".equals(action)) {
            String arg0 = args.getString(0);
            if (args != null) {
                JSONObject object = new JSONObject(arg0);
                if (object != null) {
                    String groupId = object.optString("groupID");
                    String userIds = object.optString("userIDs");
                    groupDeleteUser(groupId, userIds, callbackContext);
                }
            }
            return true;
        } else if ("groupExit".equals(action)) {
            String arg0 = args.getString(0);
            if (args != null) {
                JSONObject object = new JSONObject(arg0);
                if (object != null) {
                    String groupId = object.optString("groupID");
                    exitGroup(groupId, callbackContext);
                }
            }
            return true;
        }else if("pushConnect".equals(action)){
            buildPushConnect(callbackContext);
            return true;
        }else if("pushRegister".equals(action)){
            String arg0 = args.getString(0);
            if (args != null) {
                JSONObject object = new JSONObject(arg0);
                if (object != null) {
                    String startTime = object.optString("startTime");
                    String endTime = object.optString("endTime");
                    registerPushInfo(startTime, endTime, callbackContext);
                }
            }
            return true;
        }else if("pushUnRegister".equals(action)){
            logoutPush(callbackContext);
            return true;
        }else if("pushGetInfo".equals(action)){
            getPushInfo(callbackContext);
            return true;
        }

        return false;
    }

    /**
     * 发送异步消息
     * @param object
     */
    private void sendSyncMessageToJS(JSONObject object){
        if(receiveCallback == null)
            return;
        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, object);
        pluginResult.setKeepCallback(true);
        receiveCallback.sendPluginResult(pluginResult);
    }

    /**
     * 接收文本
     *
     * @param msg
     */
    private void sendSyncMessage(Message msg) {
        JSONObject result = (JSONObject) msg.obj;
        YouyunUtil.log("result：" + result.toString());
        sendSyncMessageToJS(result);

//       webView.loadUrl("javascript:receiveMessageThread('" + result + "')"); // 此方式IOS不适用,用上面的和IOS统一
    }

    /**
     * 获取Push信息
     * @param callbackContext
     */
    private void getPushInfo(final CallbackContext callbackContext){
        YouyunInstance.getInstance().getPushInfo(new ChatApiCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                callbackContext.success(result);
            }

            @Override
            public void onError(String error) {
                callbackContext.error(error);
            }
        });
    }

    /**
     * 注销Push
     * @param callbackContext
     */
    private void logoutPush(final CallbackContext callbackContext){
        YouyunInstance.getInstance().logoutPush(new ChatApiCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                callbackContext.success(result);
            }

            @Override
            public void onError(String error) {
                callbackContext.error(error);
            }
        });
    }

    /**
     * 注册Push
     * @param startTime
     * @param endTime
     * @param callbackContext
     */
    private void registerPushInfo(String startTime, String endTime, final CallbackContext callbackContext){
        YouyunInstance.getInstance().registerPushInfo(startTime, endTime, new ChatApiCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                callbackContext.success(result);
            }

            @Override
            public void onError(String error) {
                callbackContext.error(error);
            }
        });
    }

    /**
     * 建立push连接
     */
    private void buildPushConnect(final CallbackContext callbackContext){
        YouyunInstance.getInstance().buildPushConnect(YouyunUtil.isDebug, new ChatApiCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                callbackContext.success(result);
            }

            @Override
            public void onError(String error) {
                callbackContext.error(error);
            }
        });
    }

    /**
     * 退群成功
     *
     * @param groupId
     * @param callbackContext
     */
    private void exitGroup(String groupId, final CallbackContext callbackContext) {
        YouyunInstance.getInstance().exitGroup(groupId, new ChatApiCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                callbackContext.success(result);
            }

            @Override
            public void onError(String error) {
                callbackContext.error(error);
            }
        });
    }

    /**
     * 删除群成员
     *
     * @param groupId
     * @param uids
     * @param callbackContext
     */
    private void groupDeleteUser(String groupId, String uids, final CallbackContext callbackContext) {
        YouyunInstance.getInstance().groupDeleteUser(groupId, uids, new ChatApiCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                callbackContext.success(result);
            }

            @Override
            public void onError(String error) {
                callbackContext.error(error);
            }
        });
    }

    /**
     * 加群
     *
     * @param groupId
     * @param uids
     * @param callbackContext
     */
    private void groupAddUser(String groupId, String uids, final CallbackContext callbackContext) {
        YouyunInstance.getInstance().groupAddUser(groupId, uids, new ChatApiCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                callbackContext.success(result);
            }

            @Override
            public void onError(String error) {
                callbackContext.error(error);
            }
        });
    }

    /**
     * 获取用户群列表
     *
     * @param callbackContext
     */
    private void getGroupListByUserId(String userId, final CallbackContext callbackContext) {
        YouyunInstance.getInstance().getGroupListByUserId(userId, new ChatApiCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                callbackContext.success(result);
            }

            @Override
            public void onError(String error) {
                callbackContext.error(error);
            }
        });
    }

    /**
     * 获取群成员
     *
     * @param groupId
     * @param callbackContext
     */
    private void getUserListByGroupId(String groupId, final CallbackContext callbackContext) {
        YouyunInstance.getInstance().getUserListByGroupId(groupId, new ChatApiCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                callbackContext.success(result);
            }

            @Override
            public void onError(String error) {
                callbackContext.error(error);
            }
        });
    }

    /**
     * 创建群
     *
     * @param callbackContext
     */
    private void createGroup(final CallbackContext callbackContext) {
        YouyunInstance.getInstance().createGroup(new ChatApiCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                callbackContext.success(result);
            }

            @Override
            public void onError(String error) {
                callbackContext.error(error);
            }
        });
    }

    /**
     * 下载图片
     *
     * @param fileId
     * @param filePath
     * @param fileLength
     * @param pieceSize
     * @param callbackContext
     */
    private void downloadImg(String fileId, String filePath, int fileLength, int pieceSize, final CallbackContext callbackContext) {
        YouyunInstance.getInstance().downloadImage(fileId, filePath, fileLength, pieceSize, new ChatApiCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                callbackContext.success(result);
            }

            @Override
            public void onError(String error) {
                callbackContext.error(error);
            }
        });
    }

    /**
     * 发送图片
     *
     * @param toUId
     * @param filePath        图片路径
     * @param thumbnailPath   缩略图路径
     * @param chatType
     * @param extContent 额外消息
     * @param callbackContext
     */
    private void sendImage(String toUId, String filePath, String thumbnailPath, ChatType chatType, String extContent, final CallbackContext callbackContext) {
        YouyunInstance.getInstance().sendImage(toUId, filePath, thumbnailPath, chatType, extContent, new ChatApiCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                callbackContext.success(result);
            }

            @Override
            public void onError(String error) {
                callbackContext.error(error);
            }
        });
    }

    /**
     * 发送文本
     *
     * @param toUId id
     * @param text 消息内容
     * @param extContext 额外消息
     * @param chatType
     * @param callbackContext
     */
    private void sendText(String toUId, String text, String extContext, ChatType chatType, final CallbackContext callbackContext) {
        YouyunInstance.getInstance().sendText(toUId, text, extContext, chatType,  new ChatApiCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                callbackContext.success(result);
            }

            @Override
            public void onError(String error) {
                callbackContext.error(error);
            }
        });

    }

    /**
     * 登出
     *
     * @param callbackContext
     */
    private void logout(final CallbackContext callbackContext) {
        YouyunInstance.getInstance().logout(new ChatApiCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                callbackContext.success(result);
            }

            @Override
            public void onError(String error) {
                callbackContext.error(error);
            }
        });
    }

    /**
     * 登录
     */
    private void
    login(final CallbackContext callbackContext) {
        YouyunInstance.getInstance().login(new ChatApiCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                callbackContext.success(result);
            }

            @Override
            public void onError(String error) {
                callbackContext.error(error);
            }
        });
    }

}

