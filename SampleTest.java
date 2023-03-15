import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.Test;

public class SeleniumTest {

    @Test
    public void testGoogleSearch() {

        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

        // Initialize the ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Navigate to Google
        driver.get("https://www.google.com");

        // Find the search box and enter a search query
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium test");
        searchBox.submit();

        // Wait for the search results to load
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify that the search results page title contains the search query
        String pageTitle = driver.getTitle();
        if (pageTitle.contains("Selenium test")) {
            System.out.println("Search successful!");
        } else {
            System.out.println("Search failed!");
        }

        // Close the browser
        driver.quit();
    }
}