package com.sadruddinjunejo.sammo.views;

import com.sadruddinjunejo.sammo.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

	// used to prevent accumulation of activity transitions (i.e. from more than one 
		// company of the landing activity to be created at a time)
	   private boolean backButtonPressed;
	   
		// time in milliseconds UNTIL the run() method is called
		private static final int SPLASH_DURATION = 2000;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);

			this.setContentView(R.layout.activity_splash);
			Handler handler = new Handler();
			 
	       // runs 'run()' method after SPLASH_DURATION seconds
	       handler.postDelayed(new Runnable() {
	           @Override
	           public void run(){
	               finish();
	               
	               if (!backButtonPressed) {
	                  // The page we navigate to depends on whether the app is registered 
	            	   // or not.
	            	   Intent intent;
	            	  
	            	 // If already registered, navigate to landing activity
	            	   //} else {
	            		   // Else, navigate to registration 
	            		//   intent = new Intent(SplashScreenActivity.this, RegistrationActivity.class);
	            	  // }
	            	   
	                  // SplashActivity.this.startActivity(intent);
	              }
	              
	           }
	       }, SPLASH_DURATION); 
		} // End of onCreate() method
		
		 @Override
		 public void onBackPressed() {
		    // prevents next activity from starting unnecessarily if back button is pressed
		    // while on splash screen.
		    backButtonPressed = true;
		    super.onBackPressed();
		 }
}
