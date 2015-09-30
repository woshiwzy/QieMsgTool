package com.common.task;

import android.os.AsyncTask;

import com.common.net.NetResult;

import org.json.JSONObject;

/**
 * loginTask
 *
 * @author wangzy
 */
public class BaseTaskJosn extends AsyncTask<JSONObject, Void, NetResult> {

    NetCallBackJson mCallBack;
    public BaseTaskJosn(NetCallBackJson callBack) {
        this.mCallBack = callBack;
    }

    @Override
    protected NetResult doInBackground(JSONObject... params) {
        if (null != mCallBack) {
            if (null == params) {
                return mCallBack.onDoInBack(null);
            } else {
                NetResult result = mCallBack.onDoInBack(params[0]);
                return result;
            }
        }
        return null;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (null != mCallBack) {
            mCallBack.onPreCall();
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        if (null != mCallBack) {
            mCallBack.onCanCell();
        }
    }

    @Override
    protected void onPostExecute(NetResult result) {
        super.onPostExecute(result);
        if (null != mCallBack) {
            mCallBack.onFinish(result);
        }
    }
}
