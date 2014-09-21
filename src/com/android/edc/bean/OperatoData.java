package com.android.edc.bean;

import com.j256.ormlite.field.DatabaseField;

public class OperatoData {

	public final String FIELD_OPERATOR_ID = "id";
	
	public final String FIELD_JOB_ID = "job_id";
	
	public final String FIELD_TRAILER = "trailer";
	
	public final String FIELD_TRUCK = "truck";
	
	public final String FIELD_SUB = "sub";
	
	public final String FIELD_BONUS = "bonus"; 
	
	@DatabaseField(columnName = FIELD_OPERATOR_ID)
	private int id;
	
	@DatabaseField(columnName = FIELD_JOB_ID)
	private int job_id;
	
	@DatabaseField(columnName = FIELD_TRAILER)
	private String trailer;
	
	@DatabaseField(columnName = FIELD_TRUCK)
	private String truck;
	
	@DatabaseField(columnName = FIELD_SUB)
	private int sub;
	
	@DatabaseField(columnName = FIELD_BONUS)
	private int bouns;
	
	public OperatoData(){
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public OperatoData setId(int id) {
		this.id = id;
		return this;
	}

	/**
	 * @return the job_id
	 */
	public int getJob_id() {
		return job_id;
	}

	/**
	 * @param job_id the job_id to set
	 */
	public OperatoData setJob_id(int job_id) {
		this.job_id = job_id;
		return this;
	}

	/**
	 * @return the trailer
	 */
	public String getTrailer() {
		return trailer;
	}

	/**
	 * @param trailer the trailer to set
	 */
	public OperatoData setTrailer(String trailer) {
		this.trailer = trailer;
		return this;
	}

	/**
	 * @return the truck
	 */
	public String getTruck() {
		return truck;
	}

	/**
	 * @param truck the truck to set
	 */
	public OperatoData setTruck(String truck) {
		this.truck = truck;
		return this;
	}

	/**
	 * @return the sub
	 */
	public int getSub() {
		return sub;
	}

	/**
	 * @param sub the sub to set
	 */
	public OperatoData setSub(int sub) {
		this.sub = sub;
		return this;
	}
	
	
	
	
	
}
