package com.cristi8.automationdashboard;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;


public class MainActivity extends Activity {

	private Button m_cmdNew;
	private int x = 0;
	
	private GridView m_gridView;
	private MyGridItem[] m_items = new MyGridItem[] { 
			new MyGridItem(1, "Anna"),
			new MyGridItem(2, "Are"),
			new MyGridItem(3, "Multe"),
			new MyGridItem(4, "MERE")
		};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_cmdNew = (Button) findViewById(R.id.cmd_new);
        m_gridView = (GridView) findViewById(R.id.gridView);
        
        ListAdapter adapter = new ArrayAdapter<MyGridItem>(this, R.layout.grid_item, m_items);
        m_gridView.setAdapter(adapter);
        
        
        m_cmdNew.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				addNewClicked();
			}
		});
        
    }
    
    private void addNewClicked()
    {
    	startActivity(new Intent(this, AddOrEditScript.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.action_about:
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        case R.id.action_settings:
            
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}
