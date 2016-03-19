package withoutwsdlobjectoriented;

import javax.xml.soap.SOAPMessage;
import java.util.Set;

public class StockQuoteProgram {
    public static void main(String[] args) {
        SOAPMessage soapReply = StockServiceClient.getStockQuote("IBM");
        Set<Stock> stocks =
                StockFactory.newStocksFromSOAPReplyMessage(soapReply);
        for (Stock stock : stocks) {
            System.out.println(stock.toString());
        }
    }
}
