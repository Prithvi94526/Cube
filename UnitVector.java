import java.lang.Math;

public class UnitVector {
    private double i;
    private double j;
    private double k;

    public UnitVector(double i, double j, double k){
        this.i = i;
        this.j = j;
        this.k = k;
    }

    public UnitVector(Point start, Point end){
        this.i = end.getX() - start.getX();
        this.j = end.getY() - start.getY();
        this.k = end.getZ() - start.getZ();

        double mag = Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2) + Math.pow(k, 2));

        if (Math.abs(mag) < 0.0001) {
            this.i = this.j = this.k = 0.0;
        } else if (Math.abs(mag - 1.0) > 0.0001) {
            this.i /= mag;
            this.j /= mag;
            this.k /= mag;
        }
    }

    public UnitVector(){ this(0, 0, 0); }

    public double getI(){ return i; }
    public double getJ(){ return j; }
    public double getK(){ return k; }

    public boolean compareWith(UnitVector vector){
        return Math.abs(this.i - vector.getI()) <= 0.0001 &&
               Math.abs(this.j - vector.getJ()) <= 0.0001 &&
               Math.abs(this.k - vector.getK()) <= 0.0001;
    }

    public UnitVector crossProduct(UnitVector b) {
        double newI = this.j * b.getK() - this.k * b.getJ();
        double newJ = this.k * b.getI() - this.i * b.getK();
        double newK = this.i * b.getJ() - this.j * b.getI();

        double mag = Math.sqrt(Math.pow(newI, 2) + Math.pow(newJ, 2) + Math.pow(newK, 2));

        if (Math.abs(mag) <= 0.0001) {
            newI = newJ = newK = 0.0;
        } else if (Math.abs(mag - 1.0) > 0.0001) {
            newI /= mag;
            newJ /= mag;
            newK /= mag;
        }

        return new UnitVector(newI, newJ, newK);
    }

    public String toString(){
        if (Math.abs(i) < 0.0001 && Math.abs(j) < 0.0001 && Math.abs(k) < 0.0001) return "<InvalidUnitVector>";
        return String.format("<%.3fi, %.3fj, %.3fk>", i, j, k);
    }
}
