package gymsense.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class signupErrorTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "localhost:8888/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test  
  public void testSignuperror() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.linkText("Sign Up")).click();
    driver.findElement(By.id("user-email")).clear();
    driver.findElement(By.id("user-email")).sendKeys("jewelsleon@gmail.com");
    driver.findElement(By.id("weight")).clear();
    driver.findElement(By.id("weight")).sendKeys("33");
    new Select(driver.findElement(By.id("month"))).selectByVisibleText("April");
    new Select(driver.findElement(By.id("day"))).selectByVisibleText("01");
    new Select(driver.findElement(By.id("year"))).selectByVisibleText("2007");
    driver.findElement(By.name("workout")).click();
    driver.findElement(By.name("sex")).click();
    new Select(driver.findElement(By.id("feet"))).selectByVisibleText("3");
    new Select(driver.findElement(By.id("inches"))).selectByVisibleText("10");
    driver.findElement(By.id("submit")).click();
    //Exception.expectMessage("All fields must be filled out!");
    Alert alert = driver.switchTo().alert(); 
    String alertText = alert.getText().trim(); 
    String expectedAlert = "All fields must be filled out!";
    if (alertText.contentEquals("All fields must be filled out!")){
        System.out.println("Test 1 Passed!");
    } else {
        System.out.println("Test 1 Failed");
    }
    
    assertEquals(alertText, expectedAlert);
    alert.accept(); 
    
    
  }

  @After
  public void tearDown() throws Exception {
	driver.close();
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
