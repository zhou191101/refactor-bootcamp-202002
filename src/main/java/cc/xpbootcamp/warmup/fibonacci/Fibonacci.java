package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {

    public long getResult(int position) {
        if (position == 1) {
            return 1;
        }
        if (position == 2) {
            return 1;
        }
        return getResult(position - 1) + getResult(position - 2);
    }
}
