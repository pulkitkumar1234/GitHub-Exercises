/*
interface PolyGon{
    void Polygon();
}
class Triangle implements PolyGon{
    @Override
    public void Polygon(){
        System.out.println("This is Triangle");
    }
}
class Square implements PolyGon{
    @Override
    public void Polygon(){
        System.out.println("This is Square");
    }
}
class Quadilateral implements PolyGon{
    @Override
    public void Polygon(){
        System.out.println("This is Quadilateral");
    }
}

class PolyShape{
    PolyGon polyGon;

    public PolyGon PolygonType(){return polyGon;};
    public void setPolyGon(PolyGon polyGon){
        this.polyGon=polyGon;
    }

}
class PolygonFactory{
    static PolyShape getPolyShapeObject(String Shape){
     PolyShape polyShape=new PolyShape();
     switch (Shape){
         case "Triangle":
             polyShape.setPolyGon(new Triangle());
             break;
         case "Square":
             polyShape.setPolyGon(new Square());
             break;
         case "Quadilateral":
             polyShape.setPolyGon(new Quadilateral());
             break;
     }
     return polyShape;
    }
}
class FactoryPolygon{
    public static void main(String[] args) {
        PolyShape polyShapeTriangle = PolygonFactory.getPolyShapeObject("Triangle");
        polyShapeTriangle.PolygonType().Polygon();

        PolyShape polyShapeSquare=PolygonFactory.getPolyShapeObject("Square");
        polyShapeSquare.PolygonType().Polygon();

        PolyShape polyShapeQuad=PolygonFactory.getPolyShapeObject("Quadilateral");
        polyShapeQuad.PolygonType().Polygon();
    }

}*/
