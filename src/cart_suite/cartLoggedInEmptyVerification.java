package cart_suite;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class cartLoggedInEmptyVerification {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.thinkgeek.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCartLoggedInEmptyVerification() throws Exception {
    driver.get(baseUrl + "/");
    try {
      assertEquals("ThinkGeek | Join In. Geek Out.", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("LOG IN")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | olapicFrame | ]]
    //driver.findElement(By.id("olapicSubmit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.cssSelector("div.ninecol.lastcol > input[name=\"un\"]")).clear();
    driver.findElement(By.cssSelector("div.ninecol.lastcol > input[name=\"un\"]")).sendKeys("brettlilley@comcast.net");
    driver.findElement(By.cssSelector("div.ninecol.lastcol > input[name=\"pass\"]")).clear();
    driver.findElement(By.cssSelector("div.ninecol.lastcol > input[name=\"pass\"]")).sendKeys("password1699");
    driver.findElement(By.xpath("//input[@value='Log In']")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | olapicFrame | ]]
    //driver.findElement(By.id("olapicSubmit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    try {
      assertEquals("Your Account | ThinkGeek", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.linkText("NO LOOT")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals("HAI, BRETT\nYOUR ACCOUNT", driver.findElement(By.cssSelector("#topnav_account > a > span")).getText());
    driver.findElement(By.linkText("NO LOOT")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | olapicFrame | ]]
    //driver.findElement(By.id("olapicSubmit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    try {
      assertEquals("Your Loot! | ThinkGeek", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals("YOUR SHOPPING CART IS EMPTY. HOW SAD... GO BUY STUFF!", driver.findElement(By.cssSelector("em")).getText());
    driver.findElement(By.cssSelector("#topnav_account > a > span")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | olapicFrame | ]]
    //driver.findElement(By.id("olapicSubmit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | olapicFrame | ]]
    //driver.findElement(By.id("olapicSubmit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    try {
      assertEquals("Account Login | ThinkGeek", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @After
  public void tearDown() throws Exception {
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
