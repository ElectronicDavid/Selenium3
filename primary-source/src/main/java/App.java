import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        // Set up the WebDriver
        //System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // Replace with the path to your webdriver if necessary
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(co);

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        // Find the search box and enter the search term
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("ChatGpt");
        searchBox.sendKeys(Keys.RETURN);
        System.out.println("El flujo paso por esta linea");

        // Wait for the page to load and print the title
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());

        // Quit the WebDriver
        driver.quit();
    }
}