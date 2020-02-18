package cc.xpbootcamp.warmup.utils;

public enum Week {
    SUNDAY("星期日"),
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六");
    private String date;

    private Week(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
