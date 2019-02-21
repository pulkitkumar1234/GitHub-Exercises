class DogName implements Cloneable {

    private String dname;


    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Object clone() throws CloneNotSupportedException {
        return (DogName) super.clone();
    }

    public static void main(String[] args) {
        DogName obj1 = new DogName();
        try {
            obj1.setDname("Dog1");

            DogName obj2 = (DogName) obj1.clone();


            System.out.println(obj1.getDname());
            System.out.println(obj2.getDname());


            obj1.setDname("Dog2");


            System.out.println(obj1.getDname());
            System.out.println(obj2.getDname());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}