package com.android.edc;

import android.app.Application;
import android.content.pm.ApplicationInfo;

import com.android.edc.data.EDCSQLiteHelper;
import com.android.edc.util.StorageManager;

public class EnviornmentDustApplication extends Application {
	
	private static EnviornmentDustApplication mSingleInstance;
	
	private boolean mDebugMode;
	
	public static EnviornmentDustApplication getApplicationInstance(){
		return mSingleInstance;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		mSingleInstance = this;
		
		// check the debuge mode of application is running 
		mDebugMode = (0 != (getApplicationInfo().flags &= ApplicationInfo.FLAG_DEBUGGABLE));
		
		StorageManager.verifyAppHomePath();
		
		// Initialize the data for first time uses
		EDCSQLiteHelper.getHelperInstnace(getApplicationContext()).initializeDataBase();
		
	}

	/**
	 * <p>
	 * Return value of application android
	 * {@code ApplicationInfo.FLAG_DEBUGGABLE}, Indicate debug mode on or off
	 * </p>
	 * 
	 * @return true means debug mode running false means release mode
	 */
	public boolean getAppDebugMode() {
		return mDebugMode;
	}
}
