public class Point {
    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(){
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    public double getX(){ return x; }
    public double getY(){ return y; }
    public double getZ(){ return z; }

    public void setX(double val){ this.x = val; }
    public void setY(double val){ this.y = val; }
    public void setZ(double val){ this.z = val; }

    public boolean compareWith(Point point){
        return Math.abs(this.x - point.getX()) <= 0.0001 &&
               Math.abs(this.y - point.getY()) <= 0.0001 &&
               Math.abs(this.z - point.getZ()) <= 0.0001;
    }

    public String toString(){
        return "(x" + x + ",y" + y + ",z" + z + ")";
    }
}
