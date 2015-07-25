package com.sadruddinjunejo.sammo.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Delegates responsibility to other services/threads
 * @author Sunny
 *
 */
public class CoreService extends Service {

	
	
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

}
