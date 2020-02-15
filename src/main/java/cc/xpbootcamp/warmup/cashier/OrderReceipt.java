package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;
    private static final String SALES_TAX_NAME = "Sales Tax";
    private static final String TOTAL_AMOUNT_NAME = "Total Amount";

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        // print headers
        output.append("======Printing Orders======\n");

        // print date, bill no, customer name
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        // prints lineItems
        double totSalesTx = 0d;
        double tot = 0d;

        for (LineItem lineItem : order.getLineItems()) {
            printLineItem(output, lineItem);

            double salesTax = getSalesTax(lineItem);
            totSalesTx += salesTax;

            tot += getTotalAmountOfLineItem(lineItem, salesTax);
        }

        // prints the state tax
        printsStateTax(output, totSalesTx, SALES_TAX_NAME);

        // print total amount
        output.append(TOTAL_AMOUNT_NAME).append('\t').append(tot);
        return output.toString();
    }

    private void printsStateTax(StringBuilder output, double totSalesTx, String s) {
        output.append(s).append('\t').append(totSalesTx);
    }

    private void printLineItem(StringBuilder output, LineItem lineItem) {
        output.append(lineItem.getDescription());
        output.append('\t');
        output.append(lineItem.getPrice());
        output.append('\t');
        output.append(lineItem.getQuantity());
        output.append('\t');
        output.append(lineItem.totalAmount());
        output.append('\n');
    }

    private double getTotalAmountOfLineItem(LineItem lineItem, double salesTax) {
        return lineItem.totalAmount() + salesTax;
    }

    private double getSalesTax(LineItem lineItem) {
        return lineItem.totalAmount() * .10;
    }
}