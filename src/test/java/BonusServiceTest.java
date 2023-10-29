import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {

    @Test
    void sholdCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount,registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void  shouldCalculateForUnregisteredAndUnderLimit() {       // Незарегистрированный менее лимита бонусов
        BonusService service = new BonusService();

        long amount = 49_900;
        boolean registered = false;
        long expected = 499;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void  shouldCalculateForUnregisteredAndOverLimit() {        // Незарегистрированный выше лимита бонусов

        BonusService service = new BonusService();

        long amount = 50_100;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }
}
