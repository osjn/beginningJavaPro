package withoutwsdlobjectoriented;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class StockFactory {
    public static Set<Stock> newStocksFromSOAPReplyMessage(SOAPMessage soapMessage) {
        try {
            Node responseNode = soapMessage.getSOAPBody().getFirstChild();
            String xmlText = responseNode.getTextContent();
            return newStocksFromXMLString(xmlText);
        } catch (SOAPException e) {
            e.printStackTrace();
        }
        // If we end up here, something went wrong:
        return null;
    }

    public static Set<Stock> newStocksFromXMLString(String xmlText) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document =
                    builder.parse(new InputSource(new StringReader(xmlText)));
            return newStocksFromXMLDocument(document);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // If we end up here, something went wrong:
        return null;
    }

    public static Set<Stock> newStocksFromXMLDocument(Document document) {
        Set<Stock> stocksSet = new HashSet<Stock>();
        NodeList stockElements = document.getElementsByTagName("Stock");
        for (int i = 0; i < stockElements.getLength(); i++) {
            Stock stock = newStockFromXMLElement(
                    (Element) stockElements.item(i));
            stocksSet.add(stock);
        }
        return stocksSet;
    }

    public static Stock newStockFromXMLElement(Element node) {
        String symbol, name;
        double last, open, high, low, marketCap,
                previousClose, change, percentageChange, annRangeLow,
                annRangeHigh, earns, pe;
        long volume;
        Date timestamp;
        symbol = getEl(node, "Symbol");
        name = getEl(node, "Name");
        last = Double.parseDouble(getEl(node, "Last"));
        open = Double.parseDouble(getEl(node, "Open"));
        high = Double.parseDouble(getEl(node, "High"));
        low = Double.parseDouble(getEl(node, "Low"));
        volume = Long.parseLong(getEl(node, "Volume"));
        marketCap = Double.parseDouble(getEl(node, "MktCap").replace("B", ""));
        previousClose = Double.parseDouble(getEl(node, "PreviousClose"));
        percentageChange = Double.parseDouble(getEl(node, "PercentageChange")
                .replace("%", "")
                .replace("+", "")
                .replace("-", ""));
        change = Double.parseDouble(getEl(node, "Change")
                .replace("+", "")
                .replace("-", ""));
        String[] annRange = getEl(node, "AnnRange").split(" - ");
        annRangeLow = Double.parseDouble(annRange[0]);
        annRangeHigh = Double.parseDouble(annRange[1]);
        earns = Double.parseDouble(getEl(node, "Earns"));
        pe = Double.parseDouble(getEl(node, "P-E"));
        try {
            String fullDate = getEl(node, "Date")+" "+getEl(node, "Time");
            fullDate = fullDate.replace("pm", " pm").replace("am", " am");
            timestamp = new SimpleDateFormat("M/d/y K:m a",
                    Locale.ENGLISH).parse(fullDate);
        } catch (ParseException e) {
            e.printStackTrace();
            timestamp = new Date();
        }
        return new Stock(symbol, name,
                last, open, high, low,
                volume, timestamp, marketCap,
                previousClose, change,
                percentageChange, annRangeLow,
                annRangeHigh, earns, pe);
    }

    private static String getEl(Element node, String n) {
        return node.getElementsByTagName(n).item(0).getTextContent();
    }
}
