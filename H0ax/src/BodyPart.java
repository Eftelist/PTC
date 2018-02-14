public class BodyPart {

    private double x;
    private double y;
    private double z;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public BodyPart(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void rotate(double i1) {
        this.y += i1;
    }

    public void rotateZ(double i1) {
        this.z += i1;
    }


}
