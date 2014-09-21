package com.android.edc.bean;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

public class DustJobData {
	
	public final static String FIELD_ID = "id";
	
	public final static String FIELD_CUSTOMER_NAME = "customer";
	
	public final static String FIELD_SUPERVISOR_NAME = "supervisor";
	
	public final static String FIELD_SIGNATURE_PATH = "signature";
	
	public final static String FIELD_CLIENT_SPPO = "clientsopo";
	
	public final static String FIELD_LOCATION_NUMBER = "location_number";
	
	public final static String FIELD_DOWHOLE_LOCATION = "downhole_location";
	
	public final static String FIELD_AR_EDC_SO = "ar_edc_so";
	
	public final static String FIELD_DATE = "job_date";
	
	public final static String FIELD_JOB_START_TIME = "job_start_time";
	
	public final static String FIELD_JOB_END_TIME = "job_end_time";
	
	public final static String FIELD_EQUIPMENT_HRS_START = "equipment_hrs_start";
	
	public final static String FIELD_EQUIPMENT_HRS_END = "equipment_hrs_end";
	
	public final static String FIELD_ACCOMMODATIONS = "accommodations";
	
	public final static String FIELD_HOGG = "hogg";
	
	public final static String FIELD_PAILS_DUST = "Pails_dust";
	
	public final static String FIELD_NOTES = "notes";
	
	/**
	 * id is generated by the database and set on the object automatically
	 */
	@DatabaseField(generatedId = true, columnName = FIELD_ID)
	private int jobId;
	
	@DatabaseField(columnName = FIELD_CUSTOMER_NAME, canBeNull = false)
	private String customer;
	
	@DatabaseField(columnName = FIELD_SUPERVISOR_NAME)
	private String supervisor;
	
	@DatabaseField(columnName = FIELD_SIGNATURE_PATH)
	private String signature;
	
	@DatabaseField(columnName = FIELD_CLIENT_SPPO)
	private String clientsopo;
	
	@DatabaseField(columnName = FIELD_LOCATION_NUMBER)
	private String location_number;
	
	@DatabaseField(columnName = FIELD_DOWHOLE_LOCATION)
	private String downhole_location;
	
	@DatabaseField(columnName = FIELD_AR_EDC_SO)
	private String ar_edc_so;
	
	@DatabaseField(columnName = FIELD_DATE)
	private Date job_date;
	
	@DatabaseField(columnName = FIELD_JOB_START_TIME)
	private String job_start_time;
	
	@DatabaseField(columnName = FIELD_JOB_END_TIME)
	private String job_end_time;
	
	@DatabaseField(columnName = FIELD_EQUIPMENT_HRS_START)
	private String equipment_hrs_start;
	
	@DatabaseField(columnName = FIELD_EQUIPMENT_HRS_END)
	private String equipment_hrs_end;
	
	@DatabaseField(columnName = FIELD_ACCOMMODATIONS)
	private String accommodations;
	
	@DatabaseField(columnName = FIELD_HOGG)
	private String hogg;
	
	@DatabaseField(columnName = FIELD_PAILS_DUST)
	private String Pails_dust;
	
	@DatabaseField(columnName = FIELD_NOTES)
	private String notes;
	
	public DustJobData(){
		// all persisted classes must define a no-arg constructor
		// with at least package visibility
	}

	/**
	 * @return the jobId
	 */
	public int getJobId() {
		return jobId;
	}

	/**
	 * @param jobId the jobId to set
	 */
	public DustJobData setJobId(int jobId) {
		this.jobId = jobId;
		return this;
	}

	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public DustJobData setCustomer(String customer) {
		this.customer = customer;
		return this;
	}

	/**
	 * @return the supervisor
	 */
	public String getSupervisor() {
		return supervisor;
	}

	/**
	 * @param supervisor the supervisor to set
	 */
	public DustJobData setSupervisor(String supervisor) {
		this.supervisor = supervisor;
		return this;
	}

	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * @param signature the signature to set
	 */
	public DustJobData setSignature(String signature) {
		this.signature = signature;
		return this;
	}

	/**
	 * @return the clientsopo
	 */
	public String getClientsopo() {
		return clientsopo;
	}

	/**
	 * @param clientsopo the clientsopo to set
	 */
	public DustJobData setClientsopo(String clientsopo) {
		this.clientsopo = clientsopo;
		return this;
	}

	/**
	 * @return the location_number
	 */
	public String getLocation_number() {
		return location_number;
	}

	/**
	 * @param location_number the location_number to set
	 */
	public DustJobData setLocation_number(String location_number) {
		this.location_number = location_number;
		return this;
	}

	/**
	 * @return the downhole_location
	 */
	public String getDownhole_location() {
		return downhole_location;
	}

	/**
	 * @param downhole_location the downhole_location to set
	 */
	public DustJobData setDownhole_location(String downhole_location) {
		this.downhole_location = downhole_location;
		return this;
	}

	/**
	 * @return the ar_edc_so
	 */
	public String getAr_edc_so() {
		return ar_edc_so;
	}

	/**
	 * @param ar_edc_so the ar_edc_so to set
	 */
	public DustJobData setAr_edc_so(String ar_edc_so) {
		this.ar_edc_so = ar_edc_so;
		return this;
	}

	/**
	 * @return the job_date
	 */
	public Date getJob_date() {
		return job_date;
	}

	/**
	 * @param job_date the job_date to set
	 */
	public DustJobData setJob_date(Date job_date) {
		this.job_date = job_date;
		return this;
	}

	/**
	 * @return the job_start_time
	 */
	public String getJob_start_time() {
		return job_start_time;
	}

	/**
	 * @param job_start_time the job_start_time to set
	 */
	public DustJobData setJob_start_time(String job_start_time) {
		this.job_start_time = job_start_time;
		return this;
	}

	/**
	 * @return the job_end_time
	 */
	public String getJob_end_time() {
		return job_end_time;
	}

	/**
	 * @param job_end_time the job_end_time to set
	 */
	public DustJobData setJob_end_time(String job_end_time) {
		this.job_end_time = job_end_time;
		return this;
	}

	/**
	 * @return the equipment_hrs_start
	 */
	public String getEquipment_hrs_start() {
		return equipment_hrs_start;
	}

	/**
	 * @param equipment_hrs_start the equipment_hrs_start to set
	 */
	public DustJobData setEquipment_hrs_start(String equipment_hrs_start) {
		this.equipment_hrs_start = equipment_hrs_start;
		return this;
	}

	/**
	 * @return the equipment_hrs_end
	 */
	public String getEquipment_hrs_end() {
		return equipment_hrs_end;
	}

	/**
	 * @param equipment_hrs_end the equipment_hrs_end to set
	 */
	public DustJobData setEquipment_hrs_end(String equipment_hrs_end) {
		this.equipment_hrs_end = equipment_hrs_end;
		return this;
	}

	/**
	 * @return the accommodations
	 */
	public String getAccommodations() {
		return accommodations;
	}

	/**
	 * @param accommodations the accommodations to set
	 */
	public DustJobData setAccommodations(String accommodations) {
		this.accommodations = accommodations;
		return this;
	}

	/**
	 * @return the hogg
	 */
	public String getHogg() {
		return hogg;
	}

	/**
	 * @param hogg the hogg to set
	 */
	public DustJobData setHogg(String hogg) {
		this.hogg = hogg;
		return this;
	}

	/**
	 * @return the pails_dust
	 */
	public String getPails_dust() {
		return Pails_dust;
	}

	/**
	 * @param pails_dust the pails_dust to set
	 */
	public DustJobData setPails_dust(String pails_dust) {
		Pails_dust = pails_dust;
		return this;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public DustJobData setNotes(String notes) {
		this.notes = notes;
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DustJobData [jobId=" + jobId + ", customer=" + customer
				+ ", supervisor=" + supervisor + ", signature=" + signature
				+ ", clientsopo=" + clientsopo + ", location_number="
				+ location_number + ", downhole_location=" + downhole_location
				+ ", ar_edc_so=" + ar_edc_so + ", job_date=" + job_date
				+ ", job_start_time=" + job_start_time + ", job_end_time="
				+ job_end_time + ", equipment_hrs_start=" + equipment_hrs_start
				+ ", equipment_hrs_end=" + equipment_hrs_end
				+ ", accommodations=" + accommodations + ", hogg=" + hogg
				+ ", Pails_dust=" + Pails_dust + ", notes=" + notes + "]";
	}
	
	
}