package com.android.edc.pdf;

import java.io.FileOutputStream;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;

import com.android.edc.bean.DustJobData;
import com.android.edc.bean.OperatoData;
import com.android.edc.dao.DustJobDAO;
import com.android.edc.dao.OperatorDAO;
import com.android.edc.util.Const;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfCreator {

	private static Font normalFont_black = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.NORMAL, BaseColor.BLACK);
	
	private static Font normalFont_gray= new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.NORMAL, BaseColor.GRAY);

	private DustJobData mJobData;
	
	private List<OperatoData> mOperatorDatas;
	
	private static PdfCreator mPdfCreator;
	
	private Context mContext;
	
	private String createdFilePath;
	
	private DustJobDAO mDustJobDAO;
	
	private OperatorDAO mOperatorDAO;
	
	public static PdfCreator getInstance(Context context){
		if(mPdfCreator == null){
			mPdfCreator = new PdfCreator(context);
		}
		return mPdfCreator;
	}
	
	private PdfCreator(Context context){
		// make it private for access as signleTone
		this.mContext = context;
	}
	
	private Context getContext(){
		return mContext;
	}

	public Resources getResources(){
		return getContext().getResources();
	}
	
	public String getStringResource(int resouceId){
		return getResources().getString(resouceId).toString();
	}
	
	public void GenerateJobPDF() {
		try {
			Document document = new Document();
			String composeFileName = new String();
			composeFileName = System.currentTimeMillis() + "edc.pdf";
			createdFilePath = String.format("%s %s", Const.getAppHomePath(),composeFileName);
			PdfWriter.getInstance(document,new FileOutputStream(createdFilePath));
			document.open();
			addMetaData(document);
			addJobDetails(document);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public PdfCreator addDustJobDetails(DustJobData mDustJobData){
		this.mJobData = mDustJobData;
		return this;
	}
	
	public DustJobData getJobData(){
		return mJobData;
	}
	
	public PdfCreator addOperatorData(List<OperatoData> operatorData){
		this.mOperatorDatas = operatorData;
		return this;
	}
	
	public List<OperatoData> getOperatoDatas(){
		return mOperatorDatas;
	}

	private static void addMetaData(Document document) {
		document.addTitle("Assosciated Research Environment Dust Control");
		document.addSubject("Dust Job Report");
		document.addAuthor("Assosciated Research Environment Dust Control");
		document.addCreator("USA");
	}
	

	private void addJobDetails(Document document)
			throws DocumentException {
		
		PdfPTable table = new PdfPTable(2);
		
		if(getJobData() != null){
			
			DustJobData mDustJobData = getJobData();
		
			mDustJobData.setPdfPath(createdFilePath);
			
			// insert in to the database
			mDustJobDAO = new DustJobDAO(getContext());
			mDustJobDAO.addJobData(mDustJobData);
			
			table.addCell(createCell("Customer",normalFont_gray));
			table.addCell(createCell(mDustJobData.getCustomer(),normalFont_black));
			
			table.addCell(createCell("LocationNumber", normalFont_gray));
			table.addCell(createCell(mDustJobData.getLocation_number(), normalFont_black));
			
			table.addCell(createCell("Downhole Location", normalFont_gray));
			table.addCell(createCell(mDustJobData.getDownhole_location(), normalFont_black));
			
			table.addCell(createCell("AR-EDC S/O",normalFont_gray));
			table.addCell(createCell(mDustJobData.getAr_edc_so(), normalFont_black));
			
			table.addCell(createCell("Date", normalFont_gray));
			table.addCell(createCell(mDustJobData.getJob_date(), normalFont_black));
			
			table.addCell(createCell("Job Start Time ", normalFont_gray));
			table.addCell(createCell(mDustJobData.getJob_start_time(), normalFont_black));
			
			table.addCell(createCell("Job End Time", normalFont_gray));
			table.addCell(createCell(mDustJobData.getJob_end_time(), normalFont_black));
			
			table.addCell(createCell("Equipment Hrs Start ", normalFont_gray));
			table.addCell(createCell(mDustJobData.getEquipment_hrs_start(), normalFont_black));
			
			table.addCell(createCell("Equipment Hrs End", normalFont_gray));
			table.addCell(createCell(mDustJobData.getEquipment_hrs_end(), normalFont_black));
			
			table.addCell(createCell("Accommadation", normalFont_gray));
			table.addCell(createCell(mDustJobData.getAccommodations(), normalFont_black));
			
			table.addCell(createCell("Hogg #", normalFont_gray));
			table.addCell(createCell(mDustJobData.getHogg(), normalFont_black));
			
			table.addCell(createCell("Pails of Dust", normalFont_gray));
			table.addCell(createCell(mDustJobData.getPails_dust(), normalFont_black));
			
			if(getOperatoDatas() != null){
				
				List<OperatoData> mOperatoDatas = getOperatoDatas();
				
				table.addCell(createCell("Operator 1", normalFont_gray));
				table.addCell(createCell(mOperatoDatas.get(0).getOperator_name(), normalFont_black));
				
				table.addCell(createCell("Operator 2", normalFont_gray));
				table.addCell(createCell(mOperatoDatas.get(1).getOperator_name(), normalFont_black));
				
				table.addCell(createCell("Operator 3", normalFont_gray));
				table.addCell(createCell(mOperatoDatas.get(2).getOperator_name(), normalFont_black));
				
				table.addCell(createCell("Operator 4", normalFont_gray));
				table.addCell(createCell(mOperatoDatas.get(3).getOperator_name(), normalFont_black));
				
				if(mDustJobData.getJobId() != -1){
					
					mOperatorDAO = new OperatorDAO(getContext());
					
					mOperatoDatas.get(0).setJob_id(mDustJobData.getJobId());
					mOperatoDatas.get(1).setJob_id(mDustJobData.getJobId());
					mOperatoDatas.get(2).setJob_id(mDustJobData.getJobId());
					mOperatoDatas.get(3).setJob_id(mDustJobData.getJobId());
					
					mOperatorDAO.addOperator(mOperatoDatas.get(0));
					mOperatorDAO.addOperator(mOperatoDatas.get(1));
					mOperatorDAO.addOperator(mOperatoDatas.get(2));
					mOperatorDAO.addOperator(mOperatoDatas.get(3));
				}
			}

			
			table.addCell(createCell("", normalFont_gray));
			table.addCell(createCell("", normalFont_black));

			
			table.addCell(createCell("Notes", normalFont_gray));
			table.addCell(createCell(mDustJobData.getNotes(), normalFont_black));
			
			table.addCell(createCell("Supervisor", normalFont_gray));
			table.addCell(createCell(mDustJobData.getSupervisor(), normalFont_black));
			
//			preface.add(new Paragraph(String.format("Customer %60s",mDustJobData.getCustomer()), normalFont));
//			preface.add(new Paragraph(String.format("ClientS/OP/O %60s",mDustJobData.getClientsopo()), normalFont));
//			preface.add(new Paragraph(String.format("LocationNumber %60s",mDustJobData.getLocation_number()), normalFont));
//			preface.add(new Paragraph(String.format("Downhole Location %60s",mDustJobData.getDownhole_location()), normalFont));
//			preface.add(new Paragraph(String.format("AR-EDC S/O %60s",mDustJobData.getAr_edc_so()), normalFont));
//			//preface.add(new Paragraph(String.format(getStringResource(R.string.job_date),mDustJobData.getJob_date()), normalFont));
//			preface.add(new Paragraph(String.format("Job Start Time %60s",mDustJobData.getJob_start_time()), normalFont));
//			preface.add(new Paragraph(String.format("Job End Time %60s",mDustJobData.getJob_end_time()), normalFont));
//			
//			preface.add(new Paragraph(String.format("Equipment Hrs Start %60s",mDustJobData.getEquipment_hrs_start()), normalFont));
//			preface.add(new Paragraph(String.format("Equipment Hrs End %60s",mDustJobData.getEquipment_hrs_end()), normalFont));
//			
//			preface.add(new Paragraph(String.format("Accommadation %60s",mDustJobData.getAccommodations()), normalFont));
//			
//			preface.add(new Paragraph(String.format("Hogg # %60s",mDustJobData.getHogg()), normalFont));
//			
//			preface.add(new Paragraph(String.format("Pails of Dust %60s",mDustJobData.getPails_dust()), normalFont));
//			
//			if(getOperatoDatas() != null){
//				
//				List<OperatoData> mOperatoDatas = getOperatoDatas();
//				
//				preface.add(new Paragraph(String.format("Operator 1 %60s",mOperatoDatas.get(0).getOperator_name()), normalFont));
//				preface.add(new Paragraph(String.format("Operator 2 %60s",mOperatoDatas.get(1).getOperator_name()), normalFont));
//				preface.add(new Paragraph(String.format("Operator 3 %60s",mOperatoDatas.get(2).getOperator_name()), normalFont));
//				preface.add(new Paragraph(String.format("Operator 4 %60s",mOperatoDatas.get(3).getOperator_name()), normalFont));
//			}
//			
//			preface.add(new Paragraph(String.format("Pails of Dust %70s",mDustJobData.getPails_dust()), normalFont));
//			
//			preface.add(new Paragraph(String.format("Notes %50s",mDustJobData.getNotes()), normalFont));
//			
//			// We add one empty line
//			addEmptyLine(preface, 3);
//			
//			preface.add(new Paragraph(String.format("Supervisor %60s",mDustJobData.getSupervisor()), normalFont));
			
		}

		document.add(table);
		
		//clean up the data catch
		releaseDataAccess();
	}
	
	private PdfPCell createCell(String value,Font mFont){
		PdfPCell pdfPCell = new PdfPCell(new Paragraph(value,mFont));
		pdfPCell.setBorderColor(BaseColor.WHITE);
		pdfPCell.setBorderWidth(0.0f);
		pdfPCell.setPadding(10f);
		return pdfPCell;
	}
	
	private void releaseDataAccess(){
		if(mDustJobDAO != null){
			mDustJobDAO.releaseHelper();
		}
		if(mOperatorDAO != null){
			mOperatorDAO.releaseHelper();
		}
	}
}

