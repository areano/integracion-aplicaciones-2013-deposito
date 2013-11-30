package ar.com.edu.uade.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URI;

import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.AbstractTextField;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;

public class ImageUploader implements Receiver, SucceededListener {
    public File file;
    Embedded image;
    AbstractTextField field;
    public ImageUploader(Embedded image, AbstractTextField foto){
    	this.image = image;
    	this.field =  foto;
    }
    public OutputStream receiveUpload(String filename,
                                      String mimeType) {
        // Create upload stream
        FileOutputStream fos = null; // Stream to write to
        try {
        	file = new File("../welcome-content/deposito/" + filename);        	
        	fos = new FileOutputStream(file);
        } catch (final java.io.FileNotFoundException e) {
            new Notification("Could not open file<br/>",
                             e.getMessage(),
                             Notification.Type.ERROR_MESSAGE)
                .show(Page.getCurrent());
            return null;
        }
        return fos; // Return the output stream to write to
    }
    @Override
    public void uploadSucceeded(SucceededEvent event) {
        // Show the uploaded file in the image viewer
        image.setVisible(true);
        image.setSource(new FileResource(file));
        field.setValue(((FileResource) image.getSource()).getFilename());
        field.setImmediate(true);
    }

};