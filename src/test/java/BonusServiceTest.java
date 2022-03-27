import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // данные
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        // целевой метод
        long actual = service.calculate(amount, registered);

        // проверка
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // данные
        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;

        // целевой метод
        long actual = service.calculate(amount, registered);

        // проверка
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // данные
        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;

        // целевой метод
        long actual = service.calculate(amount, registered);

        // проверка
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndOverLimit() {
        BonusService service = new BonusService();

        // данные
        long amount = 1_000_000_60;
        boolean registered = false;
        long expected = 500;

        // целевой метод
        long actual = service.calculate(amount, registered);

        // проверка
        assertEquals(expected, actual);
    }
}