package com.sadruddinjunejo.sammo.views;

import java.util.Observable;
import java.util.Observer;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.sadruddinjunejo.sammo.R;
import com.sadruddinjunejo.sammo.constants.WebConstants;
import com.sadruddinjunejo.sammo.web.requests.GetRequest;

/**
 * General testing Activity
 * @author Sunny
 *
 */
public class SammoMainActivity extends Activity implements OnClickListener, Observer{

	private Button btnTest;
	private TextView tvTextApi;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sammo_main);
		initialise();
	}
	
	private void initialise(){
		btnTest = (Button) findViewById(R.id.btnTest);
		btnTest.setOnClickListener(this);
		tvTextApi = (TextView) findViewById(R.id.tvTestString);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sammo_main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
		case R.id.btnTest:
			// Generate web request here
			new GetRequest(this, WebConstants.URL_QUERY);
			break;
		}
		
	}

	@Override
	public void update(Observable arg0, Object data) {
		Log.d("SAMMO", "Update method called successfully");
		String responseString = (String) data;
		this.tvTextApi.setText(responseString);
	}

}
