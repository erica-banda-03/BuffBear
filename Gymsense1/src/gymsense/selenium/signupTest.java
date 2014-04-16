package gymsense.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class signupTest {
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
  public void test1() {
	driver.get(baseUrl + "landingpage.jsp");
  	String expectedTitle = "Gymsense";
      String actualTitle = "";       

      actualTitle = driver.getTitle();

      if (actualTitle.contentEquals(expectedTitle)){
          System.out.println("Test 1 Passed!");
      } else {
          System.out.println("Test 1 Failed");
      }
      
      assertEquals(actualTitle, expectedTitle);
  }
  
  @Test
  public void testSignup() throws Exception {
    driver.get(baseUrl + "landingpage.jsp");
    driver.findElement(By.linkText("Sign Up")).click();
    driver.findElement(By.id("user-firstname")).clear();
    driver.findElement(By.id("user-firstname")).sendKeys("Juliana");
    driver.findElement(By.id("user-lastname")).clear();
    driver.findElement(By.id("user-lastname")).sendKeys("Leon");
    driver.findElement(By.id("user-email")).clear();
    driver.findElement(By.id("user-email")).sendKeys("juliana@gmail.com");
    driver.findElement(By.id("weight")).clear();
    driver.findElement(By.id("weight")).sendKeys("99");
    new Select(driver.findElement(By.id("month"))).selectByVisibleText("April");
    new Select(driver.findElement(By.id("day"))).selectByVisibleText("22");
    new Select(driver.findElement(By.id("year"))).selectByVisibleText("1991");
    new Select(driver.findElement(By.id("feet"))).selectByVisibleText("3");
    new Select(driver.findElement(By.id("inches"))).selectByVisibleText("10");
    
    if( driver.findElement(By.id("user-firstname")).getText().equals("Juliana")) {
  	   System.out.println("Test 2 Passed!");
     } else {
         System.out.println("Test 2 Failed");
     }
     assertEquals("Juliana", driver.findElement(By.id("user-firstname")).getText());
     
    driver.findElement(By.id("submit")).click();
   
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
