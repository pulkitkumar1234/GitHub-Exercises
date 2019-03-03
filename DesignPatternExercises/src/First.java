class TotalMarks{
    static TotalMarks TMarks;
    int ObtainedNumber;
    String SubjectName;

    public TotalMarks(){
        this.ObtainedNumber=90;
        this.SubjectName="Java";
    }
    static TotalMarks getInstance(){
        if(TMarks==null){
            TMarks=new TotalMarks();
        }
        return TMarks;
    }
    @Override
    public String toString(){
        return "TotalMarks{"+
                "ObtainedMarks="+ObtainedNumber+", Subject Name="+SubjectName;
    }
}

class Singleton{
    public static void main(String[] args) {
        System.out.println(TotalMarks.getInstance());
        System.out.println(TotalMarks.getInstance());
    }
}