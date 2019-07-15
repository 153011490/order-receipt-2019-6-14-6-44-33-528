package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        // print headers
        printHeader(output);

        printCustomerNameAndAddress(output);

        // prints lineItems
        double totalSalesTax = 0d;
        double total = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            printLineItems(output,lineItem);
            // calculate sales tax @ rate of 10%
            totalSalesTax += calculateSalesTax(lineItem);
            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            total += lineItem.getTotalAmount() + calculateSalesTax(lineItem);
        }

        // prints the state tax
        printStateTax(output,totalSalesTax);

        // print total amount
        printTotalAmount(output,total);
        return output.toString();
    }

    public double calculateSalesTax(LineItem lineItem){
        return lineItem.getTotalAmount() * .10;
    }

    public void printLineItems(StringBuilder output,LineItem lineItem){
            output.append(lineItem.getDescription()).append('\t');
            output.append(lineItem.getPrice()).append('\t');
            output.append(lineItem.getQuantity()).append('\t');
            output.append(lineItem.getTotalAmount()).append('\n');
    }

    public void printStateTax(StringBuilder output,double totalSalesTax){
        output.append("Sales Tax").append('\t').append(totalSalesTax);
    }

    public void printTotalAmount(StringBuilder output,double total){
        output.append("Total Amount").append('\t').append(total);
    }

    public void printHeader(StringBuilder output){
        output.append("======Printing Orders======\n");
    }

    public void printCustomerNameAndAddress(StringBuilder output){
        output.append(order.getCustomerName()).append(order.getCustomerAddress());
    }

}
