import java.io.File;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;
public class CopyFile {
public static void main(String args[])
{
	try
	
	{
	 FileHandler.copy(new File("C:\\a\\ReservationSummary2.png"),new File("C:\\b\\ReservationSummary2.png"));
	 System.out.println("copied");
	}
	catch(IOException e)
	{
		System.out.print(e);
	}
}
}
