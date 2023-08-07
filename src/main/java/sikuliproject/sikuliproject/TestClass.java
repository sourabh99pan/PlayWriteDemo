package sikuliproject.sikuliproject;

import org.sikuli.script.Screen;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;

public class TestClass {

	public static void main(String[] args) throws InterruptedException, FindFailed  {
		Screen s =null;
		try
		{
		 s=new Screen();
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
		}
		Pattern p =new Pattern("D:\\Sikuli\\Edge.PNG");
		//s.find("D:\\Sikuli\\Eclipse.PNG");
		//s.wait();
		s.doubleClick(p);
		
		//s.click();
		System.out.println("Done");

	}

}
