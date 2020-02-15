package cc.xpbootcamp.warmup.fibonacci;
import org.junit.Test;

public class FibonacciTest {

    Fibonacci fibonacci = new Fibonacci();

    @Test
    public void should_return_1_when_calculate_given_position_is_4() {
        long result = fibonacci.getResult(4);
        assert result == 3;
    }

    @Test
    public void should_return_1_when_calculate_given_position_is_1() {
        long result = fibonacci.getResult(1);
        assert result == 1;
    }

    @Test
    public void should_return_1_when_calculate_given_position_is_2() {
        long result = fibonacci.getResult(2);
        assert result == 1;
    }

    @Test
    public void should_return_12586269025_when_calculate_given_position_is_50() {
        long result = fibonacci.getResult(50);
        assert result == 12586269025L;
    }

}
