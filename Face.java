public class Face {
    private Triangle[] mesh;

    public Face(Triangle t1, Triangle t2){
        mesh = new Triangle[]{t1, t2};
    }

    public Face(){ mesh = new Triangle[2]; }

    public Triangle[] getMesh(){ return mesh; }

    public String toString(){
        for (Triangle t : mesh){
            if (t.toString().equals("[InvalidTriangle]")) return "{InvalidFace}";
        }
        return String.format("{F%s %s N%s}", mesh[0], mesh[1], mesh[0].getSurfaceNormal());
    }
}
