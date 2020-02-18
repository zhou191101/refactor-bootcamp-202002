package cc.xpbootcamp.warmup.cashier;

import cc.xpbootcamp.warmup.utils.DateUtils;

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

        printHeader(output);

        String nowWeek = DateUtils.getNowWeek();
        String nowTime = DateUtils.getNowTime();
        printNowDate(output, nowTime, nowWeek);

        double totLineItemAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            printLineItem(output, lineItem);
            totLineItemAmount += lineItem.totalAmount();
        }

        printDividingLine(output);

        double totSalesTx = getTotalSalesTax(totLineItemAmount);
        printsStateTax(output, totSalesTx);

        double tot = getTot(totLineItemAmount, totSalesTx);
        if (SPECIAL_WEEK.equals(nowWeek)) {
            printDiscount(output, tot, 0.02);
            tot = tot * 0.98;
        }
        printTotalAmount(output, tot);
        return output.toString();
    }

    private double getTot(double totLineItemAmount, double totSalesTx) {
        return totLineItemAmount + totSalesTx;
    }

    private void printDiscount(StringBuilder output, double totLineItemAmount, double ratio) {
        output.append(DISCOUNT_NAME).append(formatDouble(totLineItemAmount * ratio)).append("\n");
    }


    private void printDividingLine(StringBuilder output) {
        output.append("-----------------------------------\n");
    }

    private void printNowDate(StringBuilder output, String nowTime, String nowWeek) {
        output.append(nowTime);
        output.append("，");
        output.append(nowWeek);
        output.append("\n");

    }

    private void printHeader(StringBuilder output) {
        output.append("===== 老王超市，值得信赖 ======\n");
    }

    private void printTotalAmount(StringBuilder output, double tot) {
        output.append(TOTAL_AMOUNT_NAME).append(formatDouble(tot));
    }

    private void printsStateTax(StringBuilder output, double totSalesTx) {
        output.append(SALES_TAX_NAME).append(formatDouble(totSalesTx)).append("\n");
    }

    private void printLineItem(StringBuilder output, LineItem lineItem) {
        output.append(lineItem.getDescription());
        output.append(", ");
        output.append(lineItem.getPrice());
        output.append(" x ");
        output.append(lineItem.getQuantity());
        output.append(", ");
        output.append(lineItem.totalAmount());
        output.append('\n');
    }

    private double getTotalSalesTax(double totalAmount) {
        return totalAmount * .10;
    }

    private String formatDouble(double x) {
        return String.format("%.2f", x);
    }

}