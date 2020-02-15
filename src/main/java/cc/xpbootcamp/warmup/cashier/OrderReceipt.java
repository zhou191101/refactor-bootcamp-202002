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

        printHeader(output);

        printCustomerName(output);
        printAddress(output);

        double totSalesTx = 0d;
        double tot = 0d;

        for (LineItem lineItem : order.getLineItems()) {
            printLineItem(output, lineItem);

            double salesTax = getSalesTax(lineItem);
            totSalesTx += salesTax;

            tot += getTotalAmountOfLineItem(lineItem, salesTax);
        }

        printsStateTax(output, totSalesTx);

        printTotalAmount(output, tot);
        return output.toString();
    }

    private void printHeader(StringBuilder output) {
        output.append("======Printing Orders======\n");
    }

    private StringBuilder printCustomerName(StringBuilder output) {
        return output.append(order.getCustomerName());
    }

    private void printAddress(StringBuilder output) {
        output.append(order.getCustomerAddress());
    }

    private void printTotalAmount(StringBuilder output, double tot) {
        output.append(TOTAL_AMOUNT_NAME).append('\t').append(tot);
    }

    private void printsStateTax(StringBuilder output, double totSalesTx) {
        output.append(SALES_TAX_NAME).append('\t').append(totSalesTx);
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