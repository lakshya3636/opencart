package testBase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.github.javafaker.Faker;





public class testBase {
   
 public static WebDriver driver;
 public Logger logger;
 public Properties p;
 public Faker faker=new Faker();
 public DesiredCapabilities desiredCapabilities;

 
 
 
    @Parameters({"os","browser"})
    @BeforeClass(groups = {"Sanity","Regression","Master"})
	public void setup(String os,String browser) throws IOException {
		
        logger=LogManager.getLogger(this.getClass());
        
        FileReader filereder;
        filereder=null;
        
        try 
        {
        	 filereder=new FileReader(".//src//test//resources//config.properties");
		}
        catch (Exception e) 
        {
			System.out.println(e.getMessage());
		}
       
        p=new Properties();
        p.load(filereder);
         
        if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
        	desiredCapabilities=new DesiredCapabilities();
        	
        	switch (os.toLowerCase()) {
			case "window": desiredCapabilities.setPlatform(Platform.WIN11);break;
			case "linux": desiredCapabilities.setPlatform(Platform.LINUX);break;
			case "ios": desiredCapabilities.setPlatform(Platform.IOS);break;
			default:System.out.println("Invalid Operating System");return;
			}
        	
        	switch (browser.toLowerCase()) {
			case "chrome": desiredCapabilities.setBrowserName("chrome");break;
			case "edge": desiredCapabilities.setBrowserName("MicrosoftEdge");break;
			case "firefox": desiredCapabilities.setBrowserName("firefox");break;
			default:System.out.println("Invalid browser ");return;
			}
        	String urlString="http://10.26.129.80:4444";
        	
        	driver=new RemoteWebDriver(new URL(urlString), desiredCapabilities);
        	
		}
        
        
        
        if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
        	
	     switch (browser.toLowerCase())
        {
		case "chrome": driver=new ChromeDriver();break;
		case "firefox": driver=new FirefoxDriver();break;
		case "edge": driver=new EdgeDriver();break;
		default:System.out.println("Invalid browser");
		}
	     
        }   
         
        
    	driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(p.getProperty("appurl")); 
		
		}
        
    
    
    @AfterClass(groups = {"Sanity","Regression","Master"})
	public void teardown() throws InterruptedException {
		Thread.sleep(9000);
		driver.quit();
	}

    
 public String rannumeric() {
		
    	String genString= RandomStringUtils.randomNumeric(10);
    	return genString;
	}
    
 public String ranalphabet() {
		
 	String genString= RandomStringUtils.randomAlphabetic(6);
 	return genString;
	}
    
 public String ranpswd() {
	  String genpswdString= (RandomStringUtils.randomNumeric(4)+"@"+RandomStringUtils.randomAlphabetic(4));
 	return genpswdString;
	}
 
 
 public String firstnamefaker() {
	return(faker.name().firstName());
}

 public String lastnamefaker() {
	return(faker.name().lastName());
}
 
 public String emailfaker() {
		return(faker.internet().emailAddress());
	} 
 
 public String phnnumfaker() {
		return(faker.phoneNumber().cellPhone());
	} 
 
 public String pswdfaker() {
		return(faker.internet().password());
	}
 
 public static String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

	 
	 
	 

 
	
	
}
