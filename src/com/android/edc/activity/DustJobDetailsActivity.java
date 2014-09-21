package com.android.edc.activity;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.edc.R;
import com.android.edc.bean.DustJobData;
import com.android.edc.bean.OperatoData;
import com.android.edc.pdf.PdfCreator;

@EActivity(R.layout.activity_dust_job_details)
public class DustJobDetailsActivity extends Activity {

	@ViewById(R.id.btn_save)
	Button btn_save;
	
	@ViewById(R.id.btn_clear)
	Button btn_clear;
	
	@ViewById(R.id.edittext_customer_name)
	EditText edittext_customer_name;
	
	@ViewById(R.id.edittext_supervisor_name)
	EditText edittext_supervisor_name;
	
	@ViewById(R.id.btn_add_signature)
	Button btn_add_signature;
	
	@ViewById(R.id.edittext_client_name)
	EditText edittext_client_name;
	
	@ViewById(R.id.edittext_location_number)
	EditText edittext_location_number;
	
	@ViewById(R.id.edittext_downhole_location)
	EditText edittext_downhole_location;
	
	@ViewById(R.id.edittext_ar_edc_so)
	EditText edittext_ar_edc_so;
	
	@ViewById(R.id.edittext_date)
	EditText edittext_date;
	
	@ViewById(R.id.edittext_job_start_time)
	EditText edittext_job_start_time;
	
	@ViewById(R.id.edittext_job_end_time)
	EditText edittext_job_end_time;
	
	@ViewById(R.id.edittext_equipment_hrs_start)
	EditText edittext_equipment_hrs_start;
	
	@ViewById(R.id.edittext_equipment_hrs_end)
	EditText edittext_equipment_hrs_end;
	
	@ViewById(R.id.edittext_accommodations)
	EditText edittext_accommodations;
	
	@ViewById(R.id.edittext_hogg)
	EditText edittext_hogg;
	
	@ViewById(R.id.edittext_pailofdust)
	EditText edittext_pailofdust;
	
	@ViewById(R.id.textview_signature_info)
	TextView textview_signature_info;
	
	// # Operator 1 
	
	@ViewById(R.id.edittext_operator_01)
	EditText edittext_operator_01;
	
	@ViewById(R.id.edittext_trailer_01)
	EditText edittext_trailer_01;
	
	@ViewById(R.id.edittext_truck_01)
	EditText edittext_truck_01;
	
	@ViewById(R.id.checkbox_op1_01)
	CheckBox checkbox_op1_01;
	
	@ViewById(R.id.checkbox_op1_02)
	CheckBox checkbox_op1_02;
	
	// # Operator 2
	
	@ViewById(R.id.edittext_operator_02)
	EditText edittext_operator_02;
	
	@ViewById(R.id.edittext_trailer_02)
	EditText edittext_trailer_02;
	
	@ViewById(R.id.edittext_truck_02)
	EditText edittext_truck_02;
	
	@ViewById(R.id.checkbox_op2_01)
	CheckBox checkbox_op2_01;
	
	@ViewById(R.id.checkbox_op2_02)
	CheckBox checkbox_op2_02;
	
	
	// # Operator 3
	
	@ViewById(R.id.edittext_operator_03)
	EditText edittext_operator_03;
	
	@ViewById(R.id.edittext_trailer_03)
	EditText edittext_trailer_03;
	
	@ViewById(R.id.edittext_truck_03)
	EditText edittext_truck_03;
	
	@ViewById(R.id.checkbox_op3_01)
	CheckBox checkbox_op3_01;
	
	@ViewById(R.id.checkbox_op3_02)
	CheckBox checkbox_op3_02;
	
	// # Operator 4
	
	@ViewById(R.id.edittext_operator_04)
	EditText edittext_operator_04;
	
	@ViewById(R.id.edittext_trailer_04)
	EditText edittext_trailer_04;
	
	@ViewById(R.id.edittext_truck_04)
	EditText edittext_truck_04;
	
	@ViewById(R.id.checkbox_op4_01)
	CheckBox checkbox_op4_01;
	
	@ViewById(R.id.checkbox_op4_02)
	CheckBox checkbox_op4_02;
	
	@ViewById(R.id.edittext_notes)
	EditText edittext_notes;
	
	@ViewById(R.id.progress_dialog)
	LinearLayout mProgress_dialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Click(R.id.btn_save)
	public void onSaveData() {
		new AsyncTask<Void,Void,Void>() {

			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				if(mProgress_dialog != null)
				mProgress_dialog.setVisibility(View.VISIBLE);
			}
			
			@Override
			protected Void doInBackground(Void... params) {
				PdfCreator.getInstance(getApplicationContext())
						.addDustJobDetails(collectJobDetails())
						.addOperatorData(getOperatorData()).GenerateJobPDF();
				return null;
			}
			 
			@Override
			protected void onPostExecute(Void result) {
				if(mProgress_dialog != null)
				mProgress_dialog.setVisibility(View.GONE);
				finish();
			}
			
		}.execute();
				
	}
	
	@Click(R.id.btn_clear)
	public void onClearData(){
		mProgress_dialog.setVisibility(View.VISIBLE);
	}
	
	public DustJobData collectJobDetails(){
		
		DustJobData mDustJobData = new DustJobData();
		
		mDustJobData.setCustomer(edittext_customer_name.getText().toString().trim());
		mDustJobData.setSupervisor(edittext_supervisor_name.getText().toString().trim());
		mDustJobData.setClientsopo(edittext_client_name.getText().toString().trim());
		mDustJobData.setLocation_number(edittext_location_number.getText().toString().trim());
		mDustJobData.setDownhole_location(edittext_downhole_location.getText().toString().trim());
		mDustJobData.setAr_edc_so(edittext_ar_edc_so.getText().toString().trim());
		mDustJobData.setJob_date(edittext_date.getText().toString().trim());
		mDustJobData.setJob_start_time(edittext_job_start_time.getText().toString().trim());
		mDustJobData.setJob_end_time(edittext_job_end_time.getText().toString().trim());
		mDustJobData.setEquipment_hrs_start(edittext_equipment_hrs_start.getText().toString().trim());
		mDustJobData.setEquipment_hrs_end(edittext_equipment_hrs_end.getText().toString());
		mDustJobData.setAccommodations(edittext_accommodations.getText().toString());
		mDustJobData.setHogg(edittext_hogg.getText().toString());
		mDustJobData.setPails_dust(edittext_pailofdust.getText().toString());
		mDustJobData.setNotes(edittext_notes.getText().toString());
		
		return mDustJobData;
	}
	
	public List<OperatoData> getOperatorData(){
		ArrayList<OperatoData> mDatas = new ArrayList<OperatoData>();
		
		// Operator Data 1
		OperatoData mOperatoData1 = new OperatoData();
		mOperatoData1.setOperator_name(edittext_operator_01.getText().toString());
		mOperatoData1.setTrailer(edittext_trailer_01.getText().toString());
		mOperatoData1.setTruck(edittext_truck_01.getText().toString());
		mOperatoData1.setSub(checkbox_op1_01.isChecked() ? 1 : 0);
		mOperatoData1.setBouns(checkbox_op1_02.isChecked() ? 1 : 0);
		mDatas.add(mOperatoData1);
		
		OperatoData mOperatoData2 = new OperatoData();
		mOperatoData2.setOperator_name(edittext_operator_02.getText().toString());
		mOperatoData2.setTrailer(edittext_trailer_02.getText().toString());
		mOperatoData2.setTruck(edittext_truck_02.getText().toString());
		mOperatoData2.setSub(checkbox_op2_01.isActivated() ? 1 : 0);
		mOperatoData2.setBouns(checkbox_op2_02.isActivated() ? 1 : 0);
		mDatas.add(mOperatoData2);
		
		OperatoData mOperatoData3 = new OperatoData();
		mOperatoData3.setOperator_name(edittext_operator_03.getText().toString());
		mOperatoData3.setTrailer(edittext_trailer_03.getText().toString());
		mOperatoData3.setTruck(edittext_truck_03.getText().toString());
		mOperatoData3.setSub(checkbox_op3_01.isActivated() ? 1 : 0);
		mOperatoData3.setBouns(checkbox_op3_02.isActivated() ? 1 : 0);
		mDatas.add(mOperatoData3);
		
		
		OperatoData mOperatoData4 = new OperatoData();
		mOperatoData4.setOperator_name(edittext_operator_04.getText().toString());
		mOperatoData4.setTrailer(edittext_trailer_04.getText().toString());
		mOperatoData4.setTruck(edittext_truck_04.getText().toString());
		mOperatoData4.setSub(checkbox_op4_01.isActivated() ? 1 : 0);
		mOperatoData4.setBouns(checkbox_op4_02.isActivated() ? 1 : 0);
		mDatas.add(mOperatoData4);
		
		return mDatas;
	}
}
