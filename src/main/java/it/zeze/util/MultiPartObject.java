package it.zeze.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.media.multipart.BodyPartEntity;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import java.io.*;
import java.util.Date;
import java.util.UUID;

public class MultiPartObject {

    private InputStream file;
    private FormDataContentDisposition fileDisposition;

    public MultiPartObject(String multiPartName, File file) throws FileNotFoundException {
        this.file = new FileInputStream(file);
        this.fileDisposition = FormDataContentDisposition.
                name(multiPartName).
                fileName(file.getName()).
                creationDate(new Date()).
                size(file.getTotalSpace()).
                build();
    }

    public MultiPartObject(String multiPartName, byte[] file) throws IOException {
        File tmpFileToUse = File.createTempFile(UUID.randomUUID().toString(), null);
        org.apache.commons.io.FileUtils.writeByteArrayToFile(tmpFileToUse, file);
        this.file = new FileInputStream(tmpFileToUse);
        this.fileDisposition = FormDataContentDisposition.
                name(multiPartName).
                fileName(tmpFileToUse.getName()).
                creationDate(new Date()).
                size(tmpFileToUse.getTotalSpace()).
                build();
    }

    public MultiPartObject(FormDataBodyPart fileBodyPart, FormDataContentDisposition fileDisposition) {
        this.file = ((BodyPartEntity) fileBodyPart.getEntity()).getInputStream();
        this.fileDisposition = fileDisposition;
    }

    public MultiPartObject(InputStream file, FormDataContentDisposition fileDisposition) {
        this.file = file;
        this.fileDisposition = fileDisposition;
    }

    public String getBase64File() throws IOException {
        if (file != null) {
            byte[] byteArray = IOUtils.toByteArray(file);
            return Base64.encodeBase64String(byteArray);
        }
        return null;
    }

    public InputStream getFile() {
        return file;
    }

    public void setFile(InputStream file) {
        this.file = file;
    }

    public FormDataContentDisposition getFileDisposition() {
        return fileDisposition;
    }

    public void setFileDisposition(FormDataContentDisposition fileDisposition) {
        this.fileDisposition = fileDisposition;
    }

}
