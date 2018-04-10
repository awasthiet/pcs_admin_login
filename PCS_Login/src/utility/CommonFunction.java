package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

 //import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

public class CommonFunction {

	String filePath;
	
	public void switchLoginWindow(WebDriver driver,String title)
	{
		Set<String> windows = driver.getWindowHandles();
		String currentTitle = "";
		for(String win : windows)
		{
			driver.switchTo().window(win);
			currentTitle = driver.getTitle();
			if(currentTitle.contains(title))
			{
				break;
			}
		}
	}
	
	public static String getPath()
	{
		File file =  new File("");
		String path = file.getAbsolutePath();
		return path;
	}
	
	public String getFile(String fileName)
	{
		//filePath = getPath()+"//Files//"+fileName;
		filePath = Constant.Path+fileName;
		return filePath;
	}
	
	public void hoverMouse(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public static void waitForObject(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public static void isElementDisplay(WebDriver driver, By ele)
	{
		try {
			driver.findElement(ele).isDisplayed();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void switchChildWindow(WebDriver driver,int win)
	{
		Object[] windows = driver.getWindowHandles().toArray();
		driver.switchTo().window((String)windows[win]);
	}
	
	public static void waitFor(int timeinSec)
	{
		try {
			Thread.sleep(timeinSec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void switchFrame(WebDriver driver, By ele)
	{
		driver.switchTo().defaultContent();
		waitFor(1);
		driver.switchTo().frame(driver.findElement(ele));
	}
	
	public static void updateLastValue(String fileName,double value)
	{
		try {
			FileWriter w = new FileWriter(getPath()
					+ "//src//companystatus//"+fileName);
			PrintWriter p = new PrintWriter(w);
			p.printf("%s"+"%n","LastValue = "+value);
			p.close(); 
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Value does not update on the Common Data file");
			e.printStackTrace();
		}
	}
	
	public static void updateLastValue(String fileName,String value)
	{
		try {
			FileWriter w = new FileWriter(getPath()
					+ "//src//companystatus//"+fileName);
			PrintWriter p = new PrintWriter(w);
			p.printf("%s"+"%n","LastValue = "+value);
			p.close(); 
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Value does not update on the Common Data file");
			e.printStackTrace();
		}
	}
	public static String readApplicationFile(String fileName,String key) {
		String value = "";
		try {
			Properties prop = new Properties();
			File f;
			f = new File(getPath()
					+ "//src//companystatus//"+fileName);
			if (f.exists()) {
				prop.load(new FileInputStream(f));
				value = prop.getProperty(key);
			}
		} catch (Exception e) {
			System.out
			.println("Failed to read from application.properties file.");
		}
		return value;
	}
	
	public static int compareTwoDate(String firstDate, String secondDate) {
		int value = 0;
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date date1 = sdf.parse(firstDate);
			Date date2 = sdf.parse(secondDate);
			if (date1.compareTo(date2) > 0) {
				System.out.println("Date1 is greater then Date2");
				value = 1;
			} else if (date1.compareTo(date2) < 0) {
				System.out.println("Date1 is less then Date2");
				value = -1;
			} else if (date1.compareTo(date2) == 0) {
				System.out.println("Date1 is equal to Date2");
				value = 0;
			}

		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		return value;
	}
	
	public static Set<?> findDuplicatesInList(List<?> beanList) {
		   // System.out.println("findDuplicatesInList::"+beanList);
		    Set<Object> duplicateRowSet=null;
		    duplicateRowSet=new LinkedHashSet<Object>();
		            for(int i=0;i<beanList.size();i++){
		                Object superString=beanList.get(i);
		              //  System.out.println("findDuplicatesInList::superString::"+superString);
		                for(int j=0;j<beanList.size();j++){
		                    if(i!=j){
		                         Object subString=beanList.get(j);
		                //         System.out.println("findDuplicatesInList::subString::"+subString);
		                         if(superString.equals(subString)){
		                             duplicateRowSet.add(beanList.get(j));
		                         }
		                    }
		                }
		            }
		            System.out.println("findDuplicatesInList::duplicationSet::"+duplicateRowSet);
		        return duplicateRowSet;
		  }	
	public static void scrollPageAtTheEnd(WebDriver driver) {

		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
