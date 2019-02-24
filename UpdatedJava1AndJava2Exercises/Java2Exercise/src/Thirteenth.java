class MyCustException extends Exception
{
    public MyCustException(String s)
    {
        super(s);
    }
}

class MyExp
{

    public static void main(String args[])
    {
        int a=18,b;
        try
        {   if(a<20) {
            throw new MyCustException("This Under Age exception");
        }
        else {
            System.out.println("He is 18 Year Old");
        }
        }
        catch (MyCustException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
} 