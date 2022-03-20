package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    private WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");

        Properties properties = new Properties();
        properties.load(fileInputStream);

        if (driver == null){
            if (properties.getProperty("browser").equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else {
                System.out.println("This driver is not implemented yet");
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            String url = properties.getProperty("QAUrl");
            driver.get(url);
        }

        return driver;
    }
}
