package com.accenture.flowershop.backend.services;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.stereotype.Component;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

@Component
public class XMLConverter {
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    private String path;

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public Marshaller getMarshaller() {
        return marshaller;
    }
    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public Unmarshaller getUnmarshaller() {
        return unmarshaller;
    }
    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public void convertFromObjectToXML(Object object, String filepath)
            throws IOException {
        FileOutputStream os = new FileOutputStream(filepath);
        getMarshaller().marshal(object, new StreamResult(os));
    }
    public String convertFromObjectToXMLString(Object object)
            throws IOException {
        StringWriter sw = new StringWriter();
        getMarshaller().marshal(object, new StreamResult(sw));
        return sw.toString();
    }

    public Object convertFromXMLStringToObject(String string)
            throws IOException {
        StringReader sr = new StringReader(string);
        return getUnmarshaller().unmarshal(new StreamSource(sr));
    }

    public Object convertFromXMLToObject(String xmlfile) throws IOException {
        FileInputStream is = new FileInputStream(xmlfile);
        return getUnmarshaller().unmarshal(new StreamSource(is));
    }
}