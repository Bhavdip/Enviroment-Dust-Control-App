package com.android.edc.dao;

import android.content.Context;

import com.android.edc.bean.OperatoData;
import com.android.edc.data.EDCSQLiteHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;

public class OperatorDAO {

	public final String TAG = OperatorDAO.class.getCanonicalName();
	
	private EDCSQLiteHelper mEdcsqLiteHelper;
	
	private Context mContext;
	
	public OperatorDAO(Context context){
		this.mContext = context;
		if (mEdcsqLiteHelper == null) {
			mEdcsqLiteHelper = EDCSQLiteHelper.getHelperInstnace(mContext);
		}
	}
	
	private EDCSQLiteHelper getEDCHelper(){
		return mEdcsqLiteHelper;
	}
	
	private RuntimeExceptionDao<OperatoData, Integer> getOperatorRunTimeDAO(){
		return getEDCHelper().getOperatorRunTimeDAO();
	}
	
	/**
	 * 
	 * @param mOperatoData
	 * @return
	 */
	public int addOperator(OperatoData mOperatoData){
		int result = -1;
		try{
			result = getOperatorRunTimeDAO().create(mOperatoData);
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
