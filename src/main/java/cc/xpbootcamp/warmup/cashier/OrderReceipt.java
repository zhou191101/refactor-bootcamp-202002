package cc.xpbootcamp.warmup.cashier;

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
        OrderReceiptService orderReceiptService = new OrderReceiptService(order);
        output.append(orderReceiptService.getHeader());
        output.append(orderReceiptService.getBody());
        output.append(orderReceiptService.getDividingLine());
        output.append(orderReceiptService.getTail());
        return output.toString();
    }
}