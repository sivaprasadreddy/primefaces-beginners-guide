package com.packtpub.techbuzz.controllers;

import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 * @author Siva
 *
 */
@ManagedBean
@RequestScoped
public class FileDownloadController {

    public StreamedContent getFile() 
    {  
    	System.out.println("Downloading File....");
		InputStream stream = this.getClass().getResourceAsStream("/Sample.pdf");
		StreamedContent file = new DefaultStreamedContent(stream, "application/pdf", "Sample.pdf"); 
		return file;
    }
}
