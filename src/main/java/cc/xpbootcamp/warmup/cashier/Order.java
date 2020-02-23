package cc.xpbootcamp.warmup.cashier;

import cc.xpbootcamp.warmup.utils.DateUtils;

import java.util.List;

public class Order {
    private String customerName;
    private String addr;
    private List<LineItem> lineItemList;
    private String orderDate;
    private String orderWeek;


    public Order(String customerName, String addr, List<LineItem> lineItemList, String orderDate, String orderWeek) {
        this.customerName = customerName;
        this.addr = addr;
        this.lineItemList = lineItemList;
        this.orderDate = orderDate;
        this.orderWeek = orderWeek;
    }

    public Order(String customerName, String addr, List<LineItem> lineItemList) {
        this(customerName, addr, lineItemList, DateUtils.getNowTime(),DateUtils.getNowWeek());
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public List<LineItem> getLineItems() {
        return lineItemList;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderWeek() {
        return orderWeek;
    }
}
