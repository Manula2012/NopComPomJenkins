package WebTestPom;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserSelector extends Utils
{
    public static LoadProp loadProp = new LoadProp();
    public static final String USERNAME = loadProp.getProperty("SAUCE_USERNAME");
    public static final String ACCESS_KEY = loadProp.getProperty("SAUCE_ACCESS_KEY");
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com/wd/hub";

    public static final boolean SAUCE_LAB = Boolean.parseBoolean(System.getProperty("sauce"));
    public static final String browser = System.getProperty("browser");


    //open browser
    public void setupBrowser() {
        //System.out.println(USERNAME);
        // System.out.println((ACCESS_KEY));
        //If sauce lab is true .............................................................................

        System.out.println(SAUCE_LAB);
        System.out.println(browser);
        if (SAUCE_LAB)
        {
            System.out.println("Running in SauceLab........ with browser " + browser);

            if (browser.equalsIgnoreCase("chrome")) {
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability("platform", "Windows 8");
                caps.setCapability("version", "78.0");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {

                    e.printStackTrace();
                }


            } else if (browser.equalsIgnoreCase("firefox")) {
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability("platform", "Windows 7");
                caps.setCapability("version", "56");
                caps.setCapability("name", "Testing on firefox 56");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {

                    e.printStackTrace();

                }

            } else if (browser.equalsIgnoreCase("ie")) {
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability("platform", "Windows 10");
                caps.setCapability("version", "11");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {

                    e.printStackTrace();
                }
            }
            else {
                System.out.println("Wrong browser name or empty: " + browser);
            }

        }
        //if sauce lab is false

        else {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/BrowserDrivers/chromedriver.exe");
                driver = new ChromeDriver();

            } else if
            (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/test/resources/BrowserDrivers/geckodriver.exe");
                driver = new FirefoxDriver();

            } else if (browser.equalsIgnoreCase("ie")) {
                System.setProperty("Webdriver.ie.driver", "src/test/resources/BrowserDrivers/IEDriverServer.exe");
                DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

                ieCapabilities.setCapability("nativeEvents", false);
                ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
                ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
                ieCapabilities.setCapability("disable-popup-blocking", true);
                ieCapabilities.setCapability("enablePersistentHover", true);
                ieCapabilities.setCapability("ignoreZoomSetting", true);
                driver = new InternetExplorerDriver();


            } else {
                System.out.println("Wrong browser name or empty: " + browser);
            }

        }
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    public void closeTheBrowser() {
        driver.close();
    }
}


