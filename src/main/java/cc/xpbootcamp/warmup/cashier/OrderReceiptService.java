package cc.xpbootcamp.warmup.cashier;

public class OrderReceiptService {

    private static final String SALES_TAX_NAME = "税额：";
    private static final String TOTAL_AMOUNT_NAME = "总价：";
    private static final String DISCOUNT_NAME = "折扣：";
    private static final String SPECIAL_WEEK = "星期三";

    private Order order;
    private Double totLineItemAmount = 0d;

    public OrderReceiptService(Order order) {
        this.order = order;
    }

    public String getHeader() {
        StringBuilder output = new StringBuilder();
        output.append("===== 老王超市，值得信赖 ======\n");
        return output.toString();
    }

    public String getBody() {
        StringBuilder output = new StringBuilder();
        appendNowDate(output, order.getOrderDate(), order.getOrderWeek());
        for (LineItem lineItem : order.getLineItems()) {
            appendLineItem(output, lineItem);
            totLineItemAmount += lineItem.totalAmount();
        }
        return output.toString();
    }

    public String getTail() {
        StringBuilder output = new StringBuilder();
        double totSalesTx = getTotalSalesTax(totLineItemAmount);
        appendStateTax(output, totSalesTx);
        double tot = getTot(totLineItemAmount, totSalesTx);
        if (SPECIAL_WEEK.equals(order.getOrderWeek())) {
            appendDiscount(output, tot, 0.02);
            tot = tot * 0.98;
        }
        appendTotalAmount(output, tot);
        return output.toString();
    }

    public String getDividingLine() {
        StringBuilder output = new StringBuilder();
        output.append("-----------------------------------\n");
        return output.toString();
    }

    private void appendNowDate(StringBuilder output, String nowTime, String nowWeek) {
        output.append(nowTime);
        output.append("，");
        output.append(nowWeek);
        output.append("\n");

    }

    private void appendLineItem(StringBuilder output, LineItem lineItem) {
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

    private void appendStateTax(StringBuilder output, double totSalesTx) {
        output.append(SALES_TAX_NAME).append(formatDouble(totSalesTx)).append("\n");
    }

    private String formatDouble(double x) {
        return String.format("%.2f", x);
    }


    private double getTot(double totLineItemAmount, double totSalesTx) {
        return totLineItemAmount + totSalesTx;
    }

    private void appendDiscount(StringBuilder output, double totLineItemAmount, double ratio) {
        output.append(DISCOUNT_NAME).append(formatDouble(totLineItemAmount * ratio)).append("\n");
    }

    private void appendTotalAmount(StringBuilder output, double tot) {
        output.append(TOTAL_AMOUNT_NAME).append(formatDouble(tot));
    }
}
