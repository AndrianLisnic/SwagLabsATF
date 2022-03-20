package utils;

import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GenericUtils {
    private static String COMMA_DELIMITER = ",";
    private WebDriver driver;

    public GenericUtils(WebDriver driver){
        this.driver = driver;
    }

    public void switchWindowToChild(){
        Set<String> windowsSet = driver.getWindowHandles();
        Iterator<String> iterator = windowsSet.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();

        driver.switchTo().window(childWindow);
    }

    public static List<List<String>> csvToListOfStringsConverter(){
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/test/resources/checkoutDetails.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return records;
    }
}
