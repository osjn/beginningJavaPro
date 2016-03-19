package withoutwsdlobjectoriented;

import javax.xml.namespace.QName;
import javax.xml.soap.*;

public class StockServiceClient {
    private final static String SERVICE_HOST = "http://www.webserviceX.NET/";
    private final static String SERVICE_METHOD = "GetQuote";
    private final static String SERVICE_ENDPOINT = "stockquote.asmx";
    public static SOAPMessage getStockQuote(String stockSymbol) {
        SOAPConnection soapConnection = null;
        try {
            SOAPConnectionFactory soapConnectionFactory =
                    SOAPConnectionFactory.newInstance();
            soapConnection =
                    soapConnectionFactory.createConnection();
            SOAPMessage soapResponse = soapConnection.call(
                    createSOAPRequest(stockSymbol),
                    SERVICE_HOST + SERVICE_ENDPOINT);
            soapConnection.close();
            return soapResponse;
        } catch (UnsupportedOperationException | SOAPException e) {
            e.printStackTrace();
        } finally {
            if (soapConnection != null)
                try { soapConnection.close(); } catch (SOAPException i) {}
        }
        return null;
    }

    private static SOAPMessage createSOAPRequest(String stockSymbol) {
        try {
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();
            SOAPBody soapBody = soapMessage.getSOAPBody();
            QName bodyName = new QName(SERVICE_HOST, SERVICE_METHOD);
            SOAPBodyElement bodyElement = soapBody.addBodyElement(bodyName);
            SOAPElement soapBodyArgument1 = bodyElement.addChildElement("symbol");
            soapBodyArgument1.addTextNode(stockSymbol);
            MimeHeaders headers = soapMessage.getMimeHeaders();
            headers.addHeader("SOAPAction", SERVICE_HOST + SERVICE_METHOD);
            soapMessage.saveChanges();
            return soapMessage;
        } catch (SOAPException e) {
            e.printStackTrace();
        }
        return null;
    }
}
