package cart_suite;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class cartGuestAdding {
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
  public void testCartGuestAdding() throws Exception {
    driver.get(baseUrl + "/");
    try {
      assertEquals("ThinkGeek | Join In. Geek Out.", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.linkText("BESTSELLERS")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("BESTSELLERS")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | olapicFrame | ]]
    //driver.findElement(By.id("olapicSubmit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.xpath("//img[@alt='Star Wars LIGHT UP Chop Sabers']")).click();
    String itemPrice = driver.findElement(By.cssSelector("#buy > h3")).getText();
    driver.findElement(By.id("submitcart")).click();
    new Select(driver.findElement(By.id("skucarter"))).selectByVisibleText("Luke $14.99");
    driver.findElement(By.xpath("//input[@value='Buy Now']")).click();
    //driver.findElement(By.id("submitcart")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | olapicFrame | ]]
    //driver.findElement(By.id("olapicSubmit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    try {
      assertEquals("Your Loot! | ThinkGeek", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("td.cart-subtotal-amount > strong")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    String totalPrice = driver.findElement(By.cssSelector("td.cart-subtotal-amount > strong")).getText();
    
    System.out.println(itemPrice);
    System.out.println(totalPrice);
    assertEquals(itemPrice, totalPrice);
    
    try {
      assertTrue(isElementPresent(By.xpath("(//a[contains(text(),'Go to Checkout!')])[2]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("(//a[contains(text(),'Go to Checkout!')])[2]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | olapicFrame | ]]
    //driver.findElement(By.id("olapicSubmit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    try {
      assertEquals("Warpspeed Checkout :: Addresses | ThinkGeek", driver.getTitle());
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
