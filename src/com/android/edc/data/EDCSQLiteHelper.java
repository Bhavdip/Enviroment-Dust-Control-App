package com.android.edc.data;

import java.util.concurrent.atomic.AtomicInteger;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.android.edc.EnviornmentDustApplication;
import com.android.edc.bean.DustJobData;
import com.android.edc.bean.OperatoData;
import com.android.edc.util.Const;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class EDCSQLiteHelper extends OrmLiteSqliteOpenHelper{
	
	private final String TAG = EDCSQLiteHelper.class.getCanonicalName();
	
	//name of the database file for your application -- change to something appropriate for your app
	private static final String DATABASE_NAME = "edc.db";
	//any time you make changes to your database objects, you may have to increase the database version
	private static final int DATABASE_VERSION = 1;
	
	private final static String DATABASE_FULL_PATH = getDataBasePathName();
	
	/**
	 *  we do this so there is only one helper
	 */
	private static EDCSQLiteHelper mHelper = null;
	
	/**
	 * This track the usages of {@link #getHelperInstnace(Context)} we only 1
	 * instance allow to access, Creates a new AtomicInteger with the given
	 * initial value.
	 */
	private static final AtomicInteger mHelperUsges = new AtomicInteger(0);
	
	private RuntimeExceptionDao<DustJobData, Integer>  mDustJobExceptionDao = null;
	
	private RuntimeExceptionDao<OperatoData,Integer> mOperatorExceptionDao = null;
	
	public EDCSQLiteHelper(Context context) {
		super(context, DATABASE_FULL_PATH, null, DATABASE_VERSION);
	}
	
	public static EDCSQLiteHelper getHelperInstnace(Context context){
		if(mHelper == null){
			mHelper = new EDCSQLiteHelper(context);
		}
		//Atomically increments by one the current value.
		mHelperUsges.incrementAndGet();
		return mHelper;
	}
	
	/**
	 * Void the Database single tone Instance
	 */
	private static synchronized void voidHelperInstance(){
		if(mHelper != null){
			mHelper = null;
		}
	}
	
	/**
	 *First time application launch need to first create the database 
	 *do predefine table creation operation etc this method invoke 
	 *{@link #onCreate(SQLiteDatabase, ConnectionSource)} of database
	 *
	 */
	public synchronized void initializeDataBase(){
		if(mHelper != null){
			getWritableDatabase();	
		}
	}
	
	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
		Log.d(TAG,"onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource)");
		try{
			
			TableUtils.createTable(connectionSource, DustJobData.class);
			TableUtils.createTable(connectionSource, OperatoData.class);
			
		}catch(Exception e){
			
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int arg2,int arg3) {
	}
	
	/**
	 * Returns the RuntimeExceptionDao (Database Access Object) version of a Dao
	 * for our {@link #DustJobBean} class. It will create it or just give the
	 * cached value. RuntimeExceptionDao only through RuntimeExceptions.
	 */
	public RuntimeExceptionDao<DustJobData, Integer> getDustJobRuntimeDAO() {
		if (mDustJobExceptionDao == null) {
			mDustJobExceptionDao = getRuntimeExceptionDao(DustJobData.class);
		}
		return mDustJobExceptionDao;
	}
	
	public RuntimeExceptionDao<OperatoData,Integer> getOperatorRunTimeDAO(){
		if(mOperatorExceptionDao == null){
			mOperatorExceptionDao = getRuntimeExceptionDao(OperatoData.class);
		}
		return mOperatorExceptionDao;
	}
	
	/**
	 * <p>
	 * In development mode we create the database under the sd card home 
	 * location while in production mode it will create the db as default 
	 * <code>(For example \data\data\packagename\edc.db) </code> location
	 * </p>
	 * 
	 * @return return the appropriate path of database 
	 */
	private static String getDataBasePathName()
	{	
		if(EnviornmentDustApplication.getApplicationInstance().getAppDebugMode())
		{
			return new StringBuilder(Const.getAppHomePath()).append(DATABASE_NAME).toString();
		}
		else
		{
			//Returns the absolute path to the directory on the file system where files created
			StringBuilder dbBuilder = new StringBuilder(EnviornmentDustApplication.getApplicationInstance().getFilesDir().getPath())
					.append(EnviornmentDustApplication.getApplicationInstance().getPackageName())
					.append("/databases/").append(DATABASE_NAME);
			
			return dbBuilder.toString();
		}
	}
	
	/**
	 * Close the database connections and clear any cached DAOs.For each call to
	 * {@link #getHelper(Context)} there should be 1 and only 1 call to this
	 * method. If there were 3 calls to {@link #getHelper(Context)} then on the
	 * 3rd call to this method, the helper and the underlying database
	 * connections will be closed.
	 */
	@Override
	public void close() {
		// Atomically decrements by one the current value.
		if (mHelperUsges.decrementAndGet() == 0) {
			super.close();
			voidHelperInstance();
		}
	}

}
