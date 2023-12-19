package org.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static org.example.Settings.DEFAULT_THREADS_COUNT;

public class WebDriverFactory {
    static private final ConcurrentMap<Long, WebDriver> driverMap = new ConcurrentHashMap<>();

    public static WebDriver getDriver() {
        WebDriver driver;
        long threadId = Thread.currentThread().getId();

        if (!driverMap.containsKey(threadId)) {
            driver = new RobustWebDriver(getLocalWebDriver());
            driverMap.put(threadId, driver);
        }
        else {
            driver = driverMap.get(threadId);
            driver.manage().deleteAllCookies();
        }
        return driver;
    }

    private static int getThreadCount() {
        try {
            String threadCount = System.getProperty("threadCount");
            return Integer.parseInt(threadCount);
        }
        catch (Exception e) {
            return DEFAULT_THREADS_COUNT;
        }
    }

    public static WebDriver getLocalWebDriver() {
        String chromeDriverPath = "/tmp/bin/chromedriver-linux64/chromedriver";
        String chromeBrowserPath = "/tmp/bin/chrome-linux64/chrome";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        ChromeOptions options = new ChromeOptions();
        options.setBinary(chromeBrowserPath);
        options.addArguments("--headless"); // headless only
        options.addArguments("--disable-gpu"); // applicable to Windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // bypass OS security model
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("disable-infobars"); // disabling infobars
        return new ChromeDriver(options);
    }
}
