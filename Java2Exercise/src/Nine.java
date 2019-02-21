interface Furniture{
    String Material="";
     String type="";
     int Height=0;
     String Color="";
     int price=0;

     void StressTest();
     void FireTest();

}

class Chair implements Furniture{

  public void StressTest()
  {
      System.out.println("This is Stress Test of Chair");
  }
  public void FireTest()
    {
        System.out.println("This is Fire Test of Chair");
    }
}

class WoodChair extends Chair{
    @Override
    public void StressTest()
    {
        System.out.println("This is Stress Test of Wooden Chair");
    }
    @Override
    public void FireTest()
    {
        System.out.println("This is Fire Test of Wooden Chair");
    }
}

class WoodTable extends Chair{
    @Override
    public void StressTest()
    {
        System.out.println("This is Stress Test of Wooden Table");
    }
    public void FireTest()
    {
        System.out.println("This is Fire Test of Wooden Table");
    }
}

class MetalChair extends Chair{
    @Override
    public void StressTest()
    {
        System.out.println("This is Stress Test of Metal Chair");
    }
    @Override
    public void FireTest()
    {
        System.out.println("This is Fire Test of Metal Chair");
    }
}
class MetalTable extends Chair{
    @Override
    public void StressTest()
    {
        System.out.println("This is Stress Test of Metal Table");
    }
    @Override
    public void FireTest()
    {
        System.out.println("This is Fire Test of Metal Table");
    }
}

class MyMain{
    public static void main(String[] args) {
        Chair c=new Chair();
        c.StressTest();
        c.FireTest();

        WoodChair wc=new WoodChair();
        wc.FireTest();
        wc.StressTest();

        WoodTable wt=new WoodTable();
        wt.FireTest();
        wt.StressTest();

        MetalChair mc=new MetalChair();
        mc.FireTest();
        mc.StressTest();

        MetalTable mt=new MetalTable();
        mt.FireTest();
        mt.StressTest();

        Chair c1=new WoodChair();
        c1.FireTest();

        Chair c2=new WoodTable();
        c2.StressTest();
    }

        }