package demo;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;


    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.makemytrip.com/");

        String currenturl = driver.getCurrentUrl();
        if (currenturl.contains("makemytrip")) {
            System.out.println("Test case 01: Passed");
        }
    }

    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        driver.get("https://www.makemytrip.com/");

        WebElement from = driver.findElement(By.id("fromCity"));
        from.click();
        WebElement fromtext = driver.findElement(By.xpath("//input[@placeholder='From']"));
        fromtext.sendKeys("blr");
        List<WebElement> fromsuggestion = driver.findElements(By.className("calc60"));
        Thread.sleep(2000);
        if (fromsuggestion.get(0).getText().contains("Bengaluru")) {
            fromsuggestion.get(0).click();
        }

        WebElement to = driver.findElement(By.id("toCity"));
        to.click();

        to.sendKeys("del");
        List<WebElement> tosuggestion = driver.findElements(By.className("calc60"));
        Thread.sleep(2000);
        if (tosuggestion.get(0).getText().contains("Delhi")) {
            tosuggestion.get(0).click();
        }

        WebElement nextMonthbutton = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
        nextMonthbutton.click();
        Thread.sleep(1000);
        WebElement monthheader = driver.findElement(By.xpath("//div[@class='DayPicker-Month']/div[1]"));
        if (monthheader.getText().equalsIgnoreCase("march 2024")) {
            System.out.println("correct month");
        }
        Thread.sleep(2000);
        WebElement day = driver.findElement(By.xpath("//div[@aria-label='Fri Mar 29 2024']/div"));
        day.click();

        WebElement searchButton = driver.findElement(By.xpath("//a[contains(@class,'widgetSearchBtn')]"));
        searchButton.click();

        Thread.sleep(2000);
        WebElement price = driver.findElement(By.xpath("//div[contains(@class,'clusterViewPrice')]"));
        String flightPrice = price.getText();
        System.out.println("Flight Price: " + flightPrice);

    }

    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.makemytrip.com/");

        WebElement train = driver.findElement(By.className("menu_Trains"));
        train.click();

        WebElement from = driver.findElement(By.id("fromCity"));
        from.click();
        WebElement fromtext = driver.findElement(By.xpath("//input[@placeholder='From']"));
        fromtext.sendKeys("ypr");
        List<WebElement> fromsuggestion = driver.findElements(By.xpath("//li[@aria-selected='false']"));
        Thread.sleep(1000);
        if (fromsuggestion.get(0).getText().contains("Bangalore")) {
            fromsuggestion.get(0).click();
        }

        WebElement totext = driver.findElement(By.xpath("//input[@placeholder='To']"));
        totext.sendKeys("ndls");
        List<WebElement> tosuggestion = driver.findElements(By.xpath("//li[@aria-selected='false']"));
        Thread.sleep(1000);
        if (tosuggestion.get(0).getText().contains("Delhi")) {
            tosuggestion.get(0).click();
        }

        WebElement nextMonthbutton = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
        nextMonthbutton.click();
        Thread.sleep(1000);
        WebElement monthheader = driver.findElement(By.xpath("//div[@class='DayPicker-Month']/div[1]"));
        if (monthheader.getText().equalsIgnoreCase("march 2024")) {
            System.out.println("correct month");
        }
        Thread.sleep(1000);
        WebElement day = driver.findElement(By.xpath("//div[@aria-label='Fri Mar 29 2024']"));
        day.click();

        WebElement coach = driver.findElement(By.xpath("//li[@data-cy='3A']"));
        coach.click();

        Thread.sleep(1000);
        WebElement searchButton = driver.findElement(By.xpath("//a[contains(@class,'widgetSearchBtn')]"));
        searchButton.click();

        Thread.sleep(1000);
        WebElement Price = driver
                .findElement(By.xpath("//div[@id='train_options_29-03-2024_0']//div[contains(@class,'ticket-price')]"));
        String thirdACPrice = Price.getText();
        System.out.println("Flight Price: " + thirdACPrice);
    }

    public void testCase04() throws InterruptedException {
        System.out.println("Start Test case: testCase04");
        driver.get("https://www.makemytrip.com/");

        WebElement train = driver.findElement(By.className("menu_Buses"));
        train.click();

        WebElement from = driver.findElement(By.id("fromCity"));
        from.click();
        WebElement fromtext = driver.findElement(By.xpath("//input[@placeholder='From']"));
        fromtext.sendKeys("bangl");
        List<WebElement> fromsuggestion = driver.findElements(By.xpath("//li[@aria-selected='false']"));
        Thread.sleep(1000);
        if (fromsuggestion.get(0).getText().contains("Bangalore")) {
            fromsuggestion.get(0).click();
        }

        WebElement totext = driver.findElement(By.xpath("//input[@placeholder='To']"));
        totext.sendKeys("del");
        List<WebElement> tosuggestion = driver.findElements(By.xpath("//li[@aria-selected='false']"));
        Thread.sleep(1000);
        if (tosuggestion.get(0).getText().contains("Delhi")) {
            tosuggestion.get(0).click();
        }

        WebElement nextMonthbutton = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
        nextMonthbutton.click();
        Thread.sleep(1000);
        WebElement monthheader = driver.findElement(By.xpath("//div[@class='DayPicker-Month']/div[1]"));
        if (monthheader.getText().equalsIgnoreCase("march 2024")) {
            System.out.println("correct month");
        }
        Thread.sleep(1000);
        WebElement day = driver.findElement(By.xpath("//div[@aria-label='Fri Mar 29 2024']"));
        day.click();

        WebElement searchButton = driver.findElement(By.xpath("//button[@data-cy='submit']"));
        searchButton.click();

        WebElement errorMessage = driver.findElement(By.className("error-title"));
        if (errorMessage.isDisplayed()) {
            System.out.println(errorMessage.getText());
        }
    }

}
