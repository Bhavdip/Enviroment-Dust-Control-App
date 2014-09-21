package com.android.edc.dao;

import android.content.Context;

import com.android.edc.bean.DustJobData;
import com.android.edc.data.EDCSQLiteHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;


/**
 * <p>
 * Helper class for bridge between the Model Data and OrmLiteDatabase Helper
 * </p>
 *
 */
public class DustJobDAO {

	public final String TAG = DustJobDAO.class.getCanonicalName();
	
	private EDCSQLiteHelper mEdcsqLiteHelper;
	
	private Context mContext;
	
	public DustJobDAO(Context context){
		this.mContext = context;
		if (mEdcsqLiteHelper == null) {
			mEdcsqLiteHelper = EDCSQLiteHelper.getHelperInstnace(mContext);
		}
	}
	
	private EDCSQLiteHelper getEDCHelper(){
		return mEdcsqLiteHelper;
	}
	
	private RuntimeExceptionDao<DustJobData, Integer> getDustJobRuntimeDAO(){
		return getEDCHelper().getDustJobRuntimeDAO();
	}
	
	/**
	 * Insert the job record in to the table 
	 * @return
	 */
	public int addJobData(DustJobData mJobData){
		int result = -1;
		try{
			result = getDustJobRuntimeDAO().create(mJobData);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	/**
	 * Release the helper and close the database connection
	 */
	public void releaseHelper(){
		if(mEdcsqLiteHelper != null){
			mEdcsqLiteHelper.close();
			mEdcsqLiteHelper = null;
		}
	}
	
}
