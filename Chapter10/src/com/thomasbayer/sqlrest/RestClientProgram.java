package com.thomasbayer.sqlrest;

public class RestClientProgram {
    public static void main(String[] args) {
        int[] customerIds = ObjectFactory.getCustomerIds();

        System.out.println("----------- Collection test -----------");
        System.out.println("First three customer ids: " +
                customerIds[0] + ", " +
                customerIds[1] + ", " +
                customerIds[2]);

        System.out.println("----------- Customer test -----------");
        Customer customer = ObjectFactory.createCustomer(customerIds[1]);
        System.out.println(customer);
        System.out.println("----------- Product test -----------");
        Product product = ObjectFactory.createProduct(0);
        System.out.println(product);
        System.out.println("----------- Invoice test -----------");
        Invoice invoice = ObjectFactory.createInvoice(0);
        System.out.println(invoice);
        System.out.println("----------- Invoice items test -----------");
        System.out.println(invoice.getItems());
    }
}
