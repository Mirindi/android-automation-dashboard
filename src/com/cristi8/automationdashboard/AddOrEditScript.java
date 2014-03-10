package com.cristi8.automationdashboard;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class AddOrEditScript extends Activity {

	Spinner mSpinner;
	LinearLayout mConfigurationContainer;
	ScriptConfigurationView mCustomConfigView;
	Button mSaveButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_or_edit_script);
		// Show the Up button in the action bar.
		setupActionBar();
		
		String[] availableScriptTypes = ScriptFactory.getAvailableScriptTypes();
		
		mConfigurationContainer = (LinearLayout) findViewById(R.id.scriptConfigContainer);
		mSaveButton = (Button) findViewById(R.id.cmdSaveConfig);
		
		mSpinner = (Spinner) findViewById(R.id.scriptTypeSpinner);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, availableScriptTypes);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		mSpinner.setAdapter(adapter);
		
		mSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				loadScriptConfigControl();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		
		mSaveButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				saveConfig();
			}
		});
		
		loadScriptConfigControl();
	}

	private void saveConfig()
	{
		 
		String cfg = mCustomConfigView.getConfigration();
		
		Toast.makeText(this, cfg, Toast.LENGTH_LONG).show();
	}
	
	private void loadScriptConfigControl()
	{
		String scriptType = mSpinner.getSelectedItem().toString();
		IScript script = ScriptFactory.createScript(scriptType);
		ScriptConfigurationView configView = script.createConfigurationView(this);
		if (configView == null)
		{
			Log.e("AddOrEditScript", "Can't create configuration view for script type");
			return;
		}
		mConfigurationContainer.removeAllViews();
		mConfigurationContainer.addView(configView);
		mCustomConfigView = configView;
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_or_edit_script, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
