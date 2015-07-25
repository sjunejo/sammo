package com.sadruddinjunejo.sammo.web.requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

import android.os.AsyncTask;
import android.util.Log;


/**
 * AsyncTask wrapper for GET request class.
 * @author Sunny
 *
 */
public class GetRequest extends Observable {
	
	
	private URL url;
	private String salt;
	
	private String serverURL;
	
	// TODO: Option for more observers?
	public GetRequest(Observer o, String url){
		// TODO define production server
		this.addObserver(o);
		Log.d("SAMMO", "Executing AsyncTask");
		new QueryRetrievalTask().execute(url);
		
	}

	
	public class QueryRetrievalTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... url) {
			StringBuilder responseStringBuilder = new StringBuilder();
			HttpURLConnection connection = null;
			try {
				connection = (HttpURLConnection) new URL(url[0]).openConnection();
				connection.setDoInput (true);
				connection.setDoOutput (false);
				connection.setUseCaches (false);
				Log.d("SAMMO", "Initiating connection to server");
				connection.connect();
				Log.d("SAMMO", "CONNECTING...");
				 responseStringBuilder = new StringBuilder();
				  
				 Log.d("RESPONSE", "" + connection.getResponseCode());
				// Output response
				BufferedReader br = new BufferedReader(new InputStreamReader(  
				                connection.getInputStream(),"utf-8"));  
				        
				        String line = null; 
				        while ((line = br.readLine()) != null) {  
				             responseStringBuilder.append(line);  
				        }  
				        br.close();  
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				finally {
				    	connection.disconnect();
				}
			
			Log.d("RESPONSE", responseStringBuilder.toString());
			return responseStringBuilder.toString();
		}

		@Override
		protected void onPostExecute(String result) {
			Log.d("Done", "Processing");
			GetRequest.this.setChanged();
			GetRequest.this.notifyObservers(result);
			
			// Important for garbage collection
			GetRequest.this.deleteObservers();
			super.onPostExecute(result);
		}
	
	}
}
