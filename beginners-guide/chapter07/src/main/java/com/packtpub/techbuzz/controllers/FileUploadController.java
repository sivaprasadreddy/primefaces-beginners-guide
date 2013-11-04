package com.packtpub.techbuzz.controllers;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 * @author Siva
 *
 */
@ManagedBean
@RequestScoped
public class FileUploadController {

	private Logger logger = Logger.getLogger(getClass());
	
	private UploadedFile file;
	
	public UploadedFile getFile()
	{
		return file;
	}
	public void setFile(UploadedFile file)
	{
		this.file = file;
	}
	
	public void uploadFile()
	{
		FacesMessage msg = new FacesMessage(file.getFileName()+ " is uploaded successfully.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
	}
	
	public void handleFileUpload(FileUploadEvent event) throws IOException  
	{  
		UploadedFile uploadedFile = event.getFile();
		String fileName = uploadedFile.getFileName();
		String contentType = uploadedFile.getContentType();
		logger.debug("FileName:"+fileName);
		logger.debug("ContentType:"+contentType);
		/*
		byte[] contents = uploadedFile.getContents();
		FileOutputStream fos = new FileOutputStream(new File(System.getProperty("java.io.tmpdir")));
		fos.write(contents);
		fos.close();
		*/
		//InputStream inputstream = uploadedFile.getInputstream();
        FacesMessage msg = new FacesMessage(uploadedFile.getFileName()+ " is uploaded successfully.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
}
