interface Color{
    String getColor();
}

class BlueSquare implements Color{
    @Override
    public String getColor(){
        return "This is Blue Square";
    }
}

class RedSquare implements Color{
    @Override
    public String getColor(){
       return "This is Red Square";
    }
}
class GreenTriange implements Color{
    @Override
    public String getColor(){
        return "This is Green Trigangle";
    }
}

abstract class Shape{
     Color color;
     public Shape(Color color)
    {
        this.color=color;
    }
    //public abstract void DrawShape();
}

class Square extends Shape{
     public Square(Color color){
        super(color);
    }
    /*public void DrawShape(){
    color.getColor();
    }*/
    @Override
    public String toString()
    {
        return color.getColor();
    }
}
class Triangle extends Shape{
    public Triangle(Color color){
        super(color);
    }
    /*public void DrawShape(){
        color.getColor();
    }*/
    public String toString()
    {
        return color.getColor();
    }
}

class  Bridge{
    public static void main(String[] args) {
        Square BlueSquare=new Square(new BlueSquare());
        Square RedSquare =new Square( new RedSquare());

        System.out.println(BlueSquare);
        System.out.println(RedSquare);

        Triangle GreenTriangle=new Triangle(new GreenTriange());
        System.out.println(GreenTriangle);
    }
}