package com.cristi8.automationdashboard;

import android.content.Context;
import android.widget.TextView;

public class SimpleConfigurationView extends ScriptConfigurationView {

	public SimpleConfigurationView(Context context) {
		super(context);
		TextView text = new TextView(context);
		text.setText("ana");
		addView(text);
	}

	@Override
	public String getConfigration() {
		return "config";
	}

	@Override
	public void setConfigration(String configuration) {
		
	}
}
