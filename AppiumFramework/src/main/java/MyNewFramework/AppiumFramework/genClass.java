package MyNewFramework.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class genClass {

	//public static void main(String[] args) throws MalformedURLException {
	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException {
		// TODO Auto-generated method stub
		
		
		String currDir = System.getProperty("user.dir");
		

		FileInputStream fis = new FileInputStream(currDir + "\\src\\main\\java\\MyNewFramework\\AppiumFramework\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
				
		
		
		//Set the Appname, .apk path and Android Emulator 
		DesiredCapabilities cap = new DesiredCapabilities();
		
		File appDir = new File("src");
		File f = new File(appDir, (String)prop.get(appName));
		//File f = new File(appDir,"General-Store.apk");
		// Enter device name as "Pixel_Saku" for emulator and "Android Device" for real device
		String device = (String)prop.get("Device");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, (String)prop.get(device));
		cap.setCapability(MobileCapabilityType.APP,f.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		//cap.setCapability("–session-override",true);
		
		//Set the Android driver and include the above capabilities
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		return driver;
		
	}

}
