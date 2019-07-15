package org.katas.refactoring;

import java.util.List;

public class Order {
    private String customerName;
    private String address;
    private List<LineItem> lineItems;

    public Order(String customerName, String address, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.address = address;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getCustomerAddress() {
        return this.address;
    }

    public List<LineItem> getLineItems() {
        return this.lineItems;
    }
}
