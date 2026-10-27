package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CountryTest {

    @Test
    public void shouldCreateCountryWithPower() throws POOBSoccerException {
        Country brasil = new Country("Brasil", new ConfusionPower());
        assertEquals("Brasil", brasil.getName());
        assertEquals("Confusion", brasil.getPower().getName());
    }

    @Test
    public void shouldNotCreateCountryWithoutName() {
        POOBSoccerException e = assertThrows(POOBSoccerException.class,
                () -> new Country("", new ConfusionPower()));
        assertEquals(POOBSoccerException.EMPTY_NAME, e.getMessage());
    }

    @Test
    public void shouldNotCreateCountryWithoutPower() {
        POOBSoccerException e = assertThrows(POOBSoccerException.class,
                () -> new Country("Brasil", null));
        assertEquals(POOBSoccerException.NO_POWER, e.getMessage());
    }
}
