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
        try
        {
            throw new MyCustException("This is My exception");
        }
        catch (MyCustException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
} 