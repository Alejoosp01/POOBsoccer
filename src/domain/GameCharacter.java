package domain;

/**
 * Personaje seleccionable: nombre, pais y estadisticas de 1 a 5.
 * Se llama GameCharacter y no Character para no chocar con java.lang.Character.
 */
public class GameCharacter {

    public static final int MIN_STAT = 1;
    public static final int MAX_STAT = 5;

    private String name;
    private Country country;
    private int speed;
    private int jump;
    private int strength;

    public GameCharacter(String name, Country country, int speed, int jump, int strength) throws POOBSoccerException {
        if (name == null || name.trim().isEmpty()) {
            throw new POOBSoccerException(POOBSoccerException.EMPTY_NAME);
        }
        if (country == null) {
            throw new POOBSoccerException(POOBSoccerException.NO_COUNTRY);
        }
        if (!isValidStat(speed) || !isValidStat(jump) || !isValidStat(strength)) {
            throw new POOBSoccerException(POOBSoccerException.INVALID_STAT);
        }
        this.name = name;
        this.country = country;
        this.speed = speed;
        this.jump = jump;
        this.strength = strength;
    }

    private boolean isValidStat(int value) {
        return value >= MIN_STAT && value <= MAX_STAT;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public Power getPower() {
        return country.getPower();
    }

    public int getSpeed() {
        return speed;
    }

    public int getJump() {
        return jump;
    }

    public int getStrength() {
        return strength;
    }
}
