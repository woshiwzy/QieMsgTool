package com.common.task;

import com.common.net.NetResult;

import org.json.JSONObject;

public abstract class NetCallBackJson {
	
	public  void onPreCall(){}
	public abstract NetResult onDoInBack(JSONObject jsonObject);
	public void onCanCell(){};
	public abstract void onFinish(NetResult result);

}
