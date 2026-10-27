package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameCharacterTest {

    @Test
    public void shouldCreateCharacterWithValidStats() throws POOBSoccerException {
        Country canada = new Country("Canada", new FreezePower());
        GameCharacter character = new GameCharacter("Canada", canada, 3, 3, 4);
        assertEquals("Canada", character.getName());
        assertEquals(3, character.getSpeed());
        assertEquals(3, character.getJump());
        assertEquals(4, character.getStrength());
    }

    @Test
    public void shouldAcceptLimitStats() throws POOBSoccerException {
        Country canada = new Country("Canada", new FreezePower());
        GameCharacter weak = new GameCharacter("A", canada, 1, 1, 1);
        GameCharacter strong = new GameCharacter("B", canada, 5, 5, 5);
        assertEquals(1, weak.getSpeed());
        assertEquals(5, strong.getStrength());
    }

    @Test
    public void shouldNotCreateCharacterWithStatBelowOne() throws POOBSoccerException {
        Country canada = new Country("Canada", new FreezePower());
        POOBSoccerException e = assertThrows(POOBSoccerException.class,
                () -> new GameCharacter("Canada", canada, 0, 3, 3));
        assertEquals(POOBSoccerException.INVALID_STAT, e.getMessage());
    }

    @Test
    public void shouldNotCreateCharacterWithStatAboveFive() throws POOBSoccerException {
        Country canada = new Country("Canada", new FreezePower());
        POOBSoccerException e = assertThrows(POOBSoccerException.class,
                () -> new GameCharacter("Canada", canada, 3, 6, 3));
        assertEquals(POOBSoccerException.INVALID_STAT, e.getMessage());
    }

    @Test
    public void shouldNotCreateCharacterWithoutName() throws POOBSoccerException {
        Country canada = new Country("Canada", new FreezePower());
        POOBSoccerException e = assertThrows(POOBSoccerException.class,
                () -> new GameCharacter("  ", canada, 3, 3, 3));
        assertEquals(POOBSoccerException.EMPTY_NAME, e.getMessage());
    }

    @Test
    public void shouldNotCreateCharacterWithoutCountry() {
        POOBSoccerException e = assertThrows(POOBSoccerException.class,
                () -> new GameCharacter("Canada", null, 3, 3, 3));
        assertEquals(POOBSoccerException.NO_COUNTRY, e.getMessage());
    }

    @Test
    public void shouldTakePowerFromCountry() throws POOBSoccerException {
        Power freeze = new FreezePower();
        GameCharacter character = new GameCharacter("Canada", new Country("Canada", freeze), 3, 3, 4);
        assertSame(freeze, character.getPower());
    }
}
