package com.android.edc.activity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.android.edc.R;
import com.android.edc.pdf.PdfCreator;
import com.android.edc.util.Const;

@EActivity(R.layout.activity_create_pdf)
public class CreatePdfActivity extends Activity {

	@ViewById(R.id.btn_save)
	Button btn_save;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Click(R.id.btn_save)
	public void onSaveData() {
		PdfCreator.createDocument(Const.getAppHomePath());		
	}
}
