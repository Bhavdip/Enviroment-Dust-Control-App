package com.android.edc.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

import com.android.edc.callback.OnCompleteListener;

public abstract class AbsDialog extends Dialog{
	
	public static final String RESULT_DONE = "done";
	
	public static final String RESULT_ENABLE = "enable";
	
	public static final String RESULT_CLOSE = "close";
	
	public static final String RESULT_YES = "yes";
	
	public static final String RESULT_NO = "no";
	
	public static final String RESULT_OK = "Ok";
	
	public static final String RESULT_CANCEL = "Cancel";
	
	protected boolean mCancelable = false;
	
	protected boolean mTouchoutside = false;
	
	protected OnCompleteListener<String> mCallbackListener;
	
	private Context mContext;
	
	private View mParentView;
	
	private boolean mFullscreen;
	
	public AbsDialog(Context context){
		super(context);
	}
	
	public AbsDialog(Context context,int style,boolean fullscreen) {
		super(context,style);
		mFullscreen = fullscreen;
		//fill the context
		setDialogContext(context);
		//set content view of dialog
		if(onCreateView() != null){
			mParentView = onCreateView();
			setContentView(mParentView);
			onDialogCreated(mParentView);
		}
		//full screen 
		if(mFullscreen){
			getWindow().setLayout(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);	
		}else{
			getWindow().setLayout(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		}
		setCancelable(onCancelable());
		setCanceledOnTouchOutside(onTouchOutSide());
	}
	
	/**
	 * <p>
	 * Fill the context for dialog context should activity context
	 * instead of application level context
	 * 
	 * @param context
	 */
	private void setDialogContext(Context context){
		this.mContext = context;
	}
	
	/**
	 * When dialog create it call {@code onCreateView}
	 * it should not return null
	 * @return dialog content view
	 */
	protected abstract View onCreateView();
	
	/**
	 * return the content of dialog after dialog created, it help 
	 * for access the content item callback register
	 * @param contentView
	 */
	protected abstract void onDialogCreated(View contentView);
	
	/**
	 * back press close the dialog 
	 * @return true for cancel 
	 */
	protected abstract boolean onCancelable();
	
	/**
	 * on out side dialog touch cancel the dialog
	 * 
	 * @return true if cancel
	 */
	protected abstract boolean onTouchOutSide();
	
	
	/**
	 * return the activity level context that use by dialog
	 */
	protected Context getDialogContext(){
		return mContext;
	}
	
	/**
	 * return the content view of the dialog
	 * @return
	 */
	protected View getParentView(){
		return mParentView;
	}
	
	protected boolean hasRegisterListener(){
		return mCallbackListener != null;
	}
	
	public AbsDialog registerListener(OnCompleteListener<String> callback){
		mCallbackListener = callback;
		return this;
	}
	
	public void showFullScreen(){
		if(!isShowing())show();
	}
	
	public void hideFullScreen(){
		if(isShowing())
		dismiss();
	}
}
