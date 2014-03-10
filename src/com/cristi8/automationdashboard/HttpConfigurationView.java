package com.cristi8.automationdashboard;

import android.content.Context;
import android.text.InputType;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HttpConfigurationView extends ScriptConfigurationView {
	EditText mInput;
	
	public HttpConfigurationView(Context context) {
		super(context);
		setOrientation(LinearLayout.VERTICAL);
		TextView label = new TextView(context);
		label.setText("URL"); // TODO: add resource
		addView(label);
		mInput = new EditText(context);
		LayoutParams inputLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		mInput.setLayoutParams(inputLayoutParams);
		mInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_URI);
		addView(mInput);
	}

	@Override
	public void setConfigration(String configuration) {
		mInput.setText(configuration);
	}

	@Override
	public String getConfigration() {
		return mInput.getText().toString();
	}

}
