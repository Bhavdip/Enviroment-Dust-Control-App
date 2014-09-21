package com.android.edc.callback;

public interface OnCompleteListener<Result> {
	
	public void onPreExecute();
	
	public void onSuccessComplete(Result result);

	public void onFailed(String failedMessage);
	
	public void onError(String error);
	
	public void onError(int error);
}
