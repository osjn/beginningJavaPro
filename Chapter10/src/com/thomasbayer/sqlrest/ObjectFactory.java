package com.thomasbayer.sqlrest;

import com.thomasbayer.sqlrest.RestServiceClient.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class ObjectFactory {
    private final static RestServiceClient client = new RestServiceClient();

    public static int[] getCustomerIds() {
        return getCollectionIds(Resource.CUSTOMER);
    }

    public static int[] getProductIds() {
        return getCollectionIds(Resource.PRODUCT);
    }

    public static int[] getItemIds() {
        return getCollectionIds(Resource.ITEM);
    }

    public static int[] getInvoiceIds() {
        return getCollectionIds(Resource.INVOICE);
    }

    public static Customer createCustomer(int id) {
        Document document = client.getResourceItem(Resource.CUSTOMER, id);
        Customer customer = new Customer(id);
        customer.setFirstName(getEl(document, "FIRSTNAME"));
        customer.setLastName(getEl(document, "LASTNAME"));
        customer.setStreet(getEl(document, "STREET"));
        customer.setCity(getEl(document, "CITY"));
        return customer;
    }
    public static Product createProduct(int id) {
        Document document = client.getResourceItem(Resource.PRODUCT, id);
        Product product = new Product(id);
        product.setName(getEl(document, "NAME"));
        product.setPrice(Double.parseDouble(getEl(document, "PRICE")));
        return product;
    }
    public static Invoice createInvoice(int id) {
        Document document = client.getResourceItem(Resource.INVOICE, id);
        Invoice invoice = new Invoice(id);
        invoice.setCustomer(
                createCustomer(Integer.parseInt(getEl(document, "CUSTOMERID"))));
        invoice.setTotalSum(Double.parseDouble(getEl(document, "TOTAL")));
        invoice.setItems(createItems(id, invoice));
        return invoice;
    }

    public static List<Item> createItems(int id, Invoice invoice) {
        Item item;
        Product product = null;
        int quantity = 0;
        double cost = 0D;
        Document document = client.getResourceItem(Resource.ITEM, id);
        List<Item> items = new ArrayList<Item>();
        if (document.getChildNodes().getLength() == 0)
            return items;
        NodeList children = document.getChildNodes().item(0).getChildNodes();
        // Loop over the XML document
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            switch (node.getNodeName()) {
                case "PRODUCTID":
                    product = createProduct(Integer.parseInt(node.getTextContent()));
                    break;
                case "QUANTITY":
                    quantity = Integer.parseInt(node.getTextContent());
                    break;
                case "COST":
                    cost = Double.parseDouble(node.getTextContent());
                    // This is the last line, commit our item to the list
                    item = new Item(invoice, product, quantity, cost);
                    items.add(item);
                    break;
                default:
                    break;
            }
        }
        return items;
    }

    private static int[] getCollectionIds(Resource resource) {
        Document document = client.getResourceCollection(resource);
        NodeList elements = document.getElementsByTagName(resource.name());
        int[] ids = new int[elements.getLength()];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = Integer.parseInt(elements.item(i).getTextContent());
        }
        return ids;
    }
    private static String getEl(Document document, String n) {
        return document.getElementsByTagName(n).item(0).getTextContent();
    }
}
