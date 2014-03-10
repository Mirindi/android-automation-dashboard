package com.cristi8.automationdashboard;

import android.content.Context;

public class HttpScript implements IScript {

	String mConf = "";
	
	@Override
	public void configure(String conf) {
		mConf = conf;
	}

	@Override
	public String run() {
		return "http success " + mConf;
	}

	@Override
	public ScriptConfigurationView createConfigurationView(Context context) {
		return new HttpConfigurationView(context);
	}
}
