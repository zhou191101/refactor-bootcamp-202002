package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;
    private static final String SALES_TAX_NAME = "税额：";
    private static final String TOTAL_AMOUNT_NAME = "总价：";
    private static final String DISCOUNT_NAME = "折扣：";
    private static final String SPECIAL_WEEK = "星期三";


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