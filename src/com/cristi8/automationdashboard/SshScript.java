package com.cristi8.automationdashboard;

import android.content.Context;

public class SshScript implements IScript {
	String mConfigStr = ""; 
	
	@Override
	public void configure(String conf) {
		mConfigStr = conf;
	}

	@Override
	public String run() {
		return "done with " + mConfigStr;
	}

	@Override
	public ScriptConfigurationView createConfigurationView(Context context) {
		return new SimpleConfigurationView(context);
	}

}
