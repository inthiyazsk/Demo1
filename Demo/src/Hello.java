import java.io.*;
public class Hello {
public static void main(String args[]) throws IOException
{

    FileReader in = null;
    FileWriter out = null;

    try {
       in = new FileReader("C://Users//senishetty//Desktop//doubt.txt");
       out = new FileWriter("C://Users//senishetty//Desktop//output.txt");
       
       int c;
       while ((c = in.read()) != -1) {
          out.write(c);
       }
    }catch(Exception e)
    {
    	System.out.println(e.getMessage());
    }
    finally {
       if (in != null) {
          in.close();
       }
       if (out != null) {
          out.close();
          
       }
    }
}
}
