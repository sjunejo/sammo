package com.sadruddinjunejo.sammo.views;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.ListView;

import com.sadruddinjunejo.sammo.R;

/**
 * Where 99.9% of the magic happens.
 * @author Sunny
 *
 */
public class LandingActivity extends FragmentActivity {

	
	private ListView lvQueries;
	private Button btnSOS;
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		this.setContentView(R.layout.activity_landing);
		initialise();
	}

	@Override
	protected void onResume() {
		super.onResume();
		refreshQueryList();
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}
	
	private void initialise(){
		initialiseComponents();
		initialiseActionBar();
	}
	
	private void initialiseComponents(){
		lvQueries = (ListView) findViewById(R.id.lvQueries);
		btnSOS = (Button) findViewById(R.id.btnSOS);
	}
	
	private void initialiseActionBar(){
		
	}

	/**
	 * Don't want to update list unnecessarily.
	 * Therefore, GET request will be issued first,
	 * and if there's a change, only then will UI
	 * be re-drawn.
	 * 
	 * Need a predefined limit on the number of queries
	 * shown at a time. 100?
	 */
	private void refreshQueryList(){
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu_landing, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	

}
