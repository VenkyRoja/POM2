package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.util.TestUtil;

import org.openqa.selenium.edge.EdgeDriver;


public class MyBase {
	public static Properties prop;
    public static WebDriver d; 

    //---------1-----------
	public MyBase() {
		try {
			prop = new Properties();		
			FileInputStream fip;			
		
			String mainpath = System.getProperty("user.dir");
			String subpath = "/src/main/java/com/config/config.properties";

			System.out.println(" mainpath = " + mainpath);
			System.out.println(" subpath = " + subpath);
					
			fip = new FileInputStream(mainpath + subpath);
		
			prop.load(fip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


    }

    //---------2-----------
	public static void initialize() {
		
		String url = prop.getProperty("url");
        String browser = prop.getProperty("Browser");

        System.out.println(" url = " + url);
        System.out.println(" browser = " + browser);

        if (browser.equals("E")) {
            d = new EdgeDriver();
        } if (browser.equals("F")) { 
            d = new FirefoxDriver();
        } else {
            d = new ChromeDriver();
        }

        d.manage().window().maximize();
		d.manage().deleteAllCookies();

        Duration duration1 = Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT);
        d.manage().timeouts().pageLoadTimeout(duration1);

        Duration duration2 = Duration.ofSeconds(TestUtil.IMPLICIT_WAIT);
		d.manage().timeouts().implicitlyWait(duration2);
        
        d.get(url);	
	}

    //---------2-----------
	public static void quit() {
        d.quit();
    }
    //-------------
}





        
		
	