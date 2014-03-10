package com.cristi8.automationdashboard;

import android.content.Context;

public interface IScript {
	void configure(String conf);
	
	String run();
	
	ScriptConfigurationView createConfigurationView(Context context);	
}
