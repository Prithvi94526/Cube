public class Triangle {
    private Point VertexA;
    private Point VertexB;
    private Point VertexC;
    private UnitVector surfaceNormal;

    public Triangle(Point VertA, Point VertB, Point VertC) {
        this.VertexA = VertA;
        this.VertexB = VertB;
        this.VertexC = VertC;

        UnitVector AB = new UnitVector(VertA, VertB);
        UnitVector AC = new UnitVector(VertA, VertC);

        this.surfaceNormal = AB.crossProduct(AC);
    }

    public Triangle(){
        this(new Point(), new Point(), new Point());
    }

    public Point getVertexA(){ return VertexA; }
    public Point getVertexB(){ return VertexB; }
    public Point getVertexC(){ return VertexC; }
    public UnitVector getSurfaceNormal(){ return surfaceNormal; }
    public Point[] getVertices(){ return new Point[]{VertexA, VertexB, VertexC}; }

    public boolean compareWith(Triangle triangle){
        return VertexA.compareWith(triangle.getVertexA()) &&
               VertexB.compareWith(triangle.getVertexB()) &&
               VertexC.compareWith(triangle.getVertexC());
    }

    public String toString(){
        if (VertexA.equals(VertexB) || VertexB.equals(VertexC) || VertexC.equals(VertexA) ||
            surfaceNormal == null || (Math.abs(surfaceNormal.getI()) < 0.0001 &&
                                     Math.abs(surfaceNormal.getJ()) < 0.0001 &&
                                     Math.abs(surfaceNormal.getK()) < 0.0001)) {
            return "[InvalidTriangle]";
        }

        return String.format(
            "[A(x%.3f, y%.3f, z%.3f); B(x%.3f, y%.3f, z%.3f); C(x%.3f, y%.3f, z%.3f); N<%.3fi, %.3fj, %.3fk>]",
            VertexA.getX(), VertexA.getY(), VertexA.getZ(),
            VertexB.getX(), VertexB.getY(), VertexB.getZ(),
            VertexC.getX(), VertexC.getY(), VertexC.getZ(),
            surfaceNormal.getI(), surfaceNormal.getJ(), surfaceNormal.getK()
        );
    }
}
