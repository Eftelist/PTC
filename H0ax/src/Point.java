public class Point {



    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getRotx() {
        return rotx;
    }

    public double getRoty() {
        return roty;
    }

    public double getRotz() {
        return rotz;
    }

    private final double x;
    private final double y;
    private final double z;
    private double rotx;
    private double roty;
    private double rotz;
    private final int ind;
    private final double yaw;
    private final BodyPart leftarm;
    private final BodyPart rightarm;

    public Point(int ind, double x, double y, double z, double rotx, double roty, double rotz, double yaws, BodyPart bodyPartLeftArm, BodyPart bodyPart){
        this.ind = ind;
        this.x = x;
        this.y = y;
        this.z = z;
        this.rotx = rotx;
        this.roty = roty;
        this.rotz = rotz;
        this.yaw = yaws;
        this.leftarm = bodyPartLeftArm;
        this.rightarm = bodyPart;
    }

    public String string() {
        return " X: " + x + " Y: " + y + " Z: " +z + " rX: " + rotx + " rY: " + roty + " rZ:" + rotz;
    }

    public int getInd() {
        return ind;
    }

    public String[] formatted() {
        String[] res = {"","","","","","",""};
        String defaultString = " 0.0 0.0 0.0";
        res[0] = "Armorstand_Position" + defaultString + " "+yaw;
        res[1] = "Armorstand_Middle" + defaultString;
        res[2] = "Armorstand_Right_Leg" + defaultString;
        res[3] = "Armorstand_Left_Leg" + defaultString;
        res[4] = "Armorstand_Left_Arm " + leftarm.getX() + " " + leftarm.getY() + " " + leftarm.getZ();
        res[5] = "Armorstand_Right_Arm " + rightarm.getX() + " " + rightarm.getY() + " " + rightarm.getZ();
        res[6] = "Armorstand_Head " + rotx + " " + roty + " " + rotz;
        return res;
    }

    public double getYaw() {
        return yaw;
    }

    public BodyPart getLeftarm() {
        return leftarm;
    }

    public void rotate(double i) {
        this.rotx =this.rotx + i;
        this.roty = this.roty + i;
        this.rotz = this.rotz + i;
    }

    public void rotateBodyPart(int i, double i1) {
        if(i == 0){
            this.leftarm.rotate(i1);
        }
        if(i == 1){
            this.rightarm.rotate(i1);
        }
        if(i == 2){
            this.leftarm.rotateZ(-120);
        }
        if(i == 3){
            this.rightarm.rotateZ(120);
        }
    }
}
