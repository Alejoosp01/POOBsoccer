package domain;

/**
 * Pais (equipo) de un personaje. El poder depende del pais.
 */
public class Country {

    private String name;
    private Power power;

    public Country(String name, Power power) throws POOBSoccerException {
        if (name == null || name.trim().isEmpty()) {
            throw new POOBSoccerException(POOBSoccerException.EMPTY_NAME);
        }
        if (power == null) {
            throw new POOBSoccerException(POOBSoccerException.NO_POWER);
        }
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public Power getPower() {
        return power;
    }
}
