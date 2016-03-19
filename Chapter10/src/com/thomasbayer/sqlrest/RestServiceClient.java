package com.thomasbayer.sqlrest;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestServiceClient {
    private final static String URL_API_ROOT = "http://www.thomas-bayer.com/sqlrest";

    public enum Resource {
        CUSTOMER, PRODUCT, INVOICE, ITEM
    };

    public Document getResourceCollection(Resource resource) {
        return stringToXMLDocument(getHttpUrl(URL_API_ROOT + resource.name()));
    }

    public Document getResourceItem(Resource resource, int itemId) {
        return stringToXMLDocument(getHttpUrl(URL_API_ROOT
                + resource.name() + "/" + itemId));
    }

    public String getHttpUrl(String url) {
        HttpURLConnection connection = null;
        try {
            URL u = new URL(url);
            connection = (HttpURLConnection) u.openConnection();
            // we will be making GET requests only to this service
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                // we got a non 200 (OK) status code: error or server is down
                System.err.println("Server returned status code: " + responseCode);
                return null;
            }
            // fetch the response from the server
            StringBuilder stringBuilder = new StringBuilder();
            // getInputStream is data coming back from the server
            // getOutputStream is meant for sending data to the server
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "UTF-8")
            )) {
                String s;
                while ((s = reader.readLine()) != null) {
                    stringBuilder.append(s + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            connection.disconnect();
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

    static public Document stringToXMLDocument(String xmlText) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlText)));
            return document;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws TransformerException {
        // Testing our RestServiceClient
        RestServiceClient client = new RestServiceClient();

        // set up a transformer to properly convert an XML document to a string
        Document d;
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();

        // Test collection URL
        StringWriter writer = new StringWriter();
        d = client.getResourceCollection(Resource.CUSTOMER);
        transformer.transform(new DOMSource(d), new StreamResult(writer));
        System.out.println(writer);

        // Test item URL
        writer = new StringWriter();
        d = client.getResourceItem(Resource.PRODUCT, 3);
        transformer.transform(new DOMSource(d), new StreamResult(writer));
        System.out.println(writer);
    }
}
