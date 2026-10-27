package domain;

/**
 * Reduccion (Colombia): encoge al oponente a un tamano diminuto.
 */
public class ShrinkPower extends Power {

    public ShrinkPower() {
        super("Reduccion", 5);
    }

    @Override
    public void activate(Ball ball, Player owner, Player opponent) {
        opponent.shrink(getDuration());
    }
}
