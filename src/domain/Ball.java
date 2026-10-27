package domain;

/**
 * Balon del partido.
 * Por ahora solo guarda posicion, velocidad y los efectos de los poderes
 * (Empuje e Ilusion). La gravedad y los rebotes se agregan con Match.
 */
public class Ball {

    private double x;
    private double y;
    private double velocityX;
    private double velocityY;
    private double radius;

    private boolean pushCharged;
    private int decoyCount;
    private double illusionTime;

    public Ball(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.velocityX = 0;
        this.velocityY = 0;
        this.pushCharged = false;
        this.decoyCount = 0;
        this.illusionTime = 0;
    }

    public void setVelocity(double velocityX, double velocityY) {
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    /**
     * Carga el balon con el Empuje: el primer rival que lo toque sale empujado.
     */
    public void chargePush() {
        pushCharged = true;
    }

    public void releasePush() {
        pushCharged = false;
    }

    /**
     * Inicia la Ilusion: aparecen copias falsas durante unos segundos.
     */
    public void startIllusion(int decoys, double seconds) {
        decoyCount = decoys;
        illusionTime = seconds;
    }

    /**
     * Descuenta el tiempo de los efectos. dt esta en segundos.
     */
    public void updateEffects(double dt) {
        if (illusionTime > 0) {
            illusionTime = illusionTime - dt;
            if (illusionTime <= 0) {
                illusionTime = 0;
                decoyCount = 0;
            }
        }
    }

    public boolean isPushCharged() {
        return pushCharged;
    }

    public boolean isIllusionActive() {
        return illusionTime > 0;
    }

    public int getDecoyCount() {
        return decoyCount;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public double getRadius() {
        return radius;
    }
}
