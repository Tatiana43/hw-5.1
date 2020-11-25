import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateNotRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        long expected = 10;

        long actual = service.calculate(amount, false);

        assertEquals(expected, actual);
    }

        @Test
        void shouldCalculateNotRegisteredAndOverLimit() {
            BonusService service = new BonusService();

            long amount = 1_000_000_60;
            long expected = 500;

            long actual = service.calculate(amount, false);

            assertEquals(expected, actual);

    }
    
    @Test
    void shouldCalculateRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        long expected = 30;

        long actual = service.calculate(amount, true);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000_60;
        long expected = 500;

        long actual = service.calculate(amount, true);

        assertEquals(expected, actual);
    }
}
