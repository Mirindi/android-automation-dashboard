package com.cristi8.automationdashboard;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;


public abstract class ScriptConfigurationView extends LinearLayout {
	public ScriptConfigurationView(Context context) {
		super(context);
	}

	public abstract void setConfigration(String configuration);
	public abstract String getConfigration();
}
