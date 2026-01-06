public class Cube {
    private Face[] mesh;

    public Cube(Face one, Face two, Face three, Face four, Face five, Face six) {
        mesh = new Face[]{one, two, three, four, five, six};

        for (int i = 0; i < 6; i++) {
            int sharedEdges = 0;

            for (int b = 0; b < 6; b++) {
                if (i == b) continue;

                for (int j = 0; j < 2; j++){
                    for (int k = 0; k < 2; k++){
                        int commonVertices = 0;
                        Triangle t1 = mesh[i].getMesh()[j];
                        Triangle t2 = mesh[b].getMesh()[k];

                        if (t1.getVertexA().compareWith(t2.getVertexA()) ||
                            t1.getVertexA().compareWith(t2.getVertexB()) ||
                            t1.getVertexA().compareWith(t2.getVertexC())) commonVertices++;
                        if (t1.getVertexB().compareWith(t2.getVertexA()) ||
                            t1.getVertexB().compareWith(t2.getVertexB()) ||
                            t1.getVertexB().compareWith(t2.getVertexC())) commonVertices++;
                        if (t1.getVertexC().compareWith(t2.getVertexA()) ||
                            t1.getVertexC().compareWith(t2.getVertexB()) ||
                            t1.getVertexC().compareWith(t2.getVertexC())) commonVertices++;

                        if (commonVertices == 2) sharedEdges++;
                    }
                }
            }

            if (sharedEdges != 4){
                System.out.println("Face " + i + " does not share exactly 4 edges. Shared edges: " + sharedEdges);
            }
        }
    }

    public Cube(){ mesh = new Face[6]; }

    public Face[] getMesh(){ return mesh; }

    public String toString(){
        for (Face n : mesh){
            if (n.toString().equals("{InvalidFace}")) return "|InvalidCube|";
        }
        return String.format("|C%s%s%s%s%s%s|", mesh[0], mesh[1], mesh[2], mesh[3], mesh[4], mesh[5]);
    }
}
