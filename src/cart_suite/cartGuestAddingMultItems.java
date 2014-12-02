package cart_suite;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class cartGuestAddingMultItems {
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
  public void testCartGuestAddingMultItems() throws Exception {
    driver.get(baseUrl + "/");
    try {
      assertEquals("ThinkGeek | Join In. Geek Out.", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.linkText("NO LOOT")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.cssSelector("li.starwars > a > span.ir")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | olapicFrame | ]]
    //driver.findElement(By.id("olapicSubmit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.cssSelector("a[title=\"Star Wars Han and Leia Bathroom Hand Towels\"] > img.lazy.prodlist-img-lrg")).click();
    String itemPrice1 = driver.findElement(By.cssSelector("#buy > h3")).getText();
    driver.findElement(By.id("submitcart")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | olapicFrame | ]]
    //driver.findElement(By.id("olapicSubmit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    try {
      assertEquals("Your Loot! | ThinkGeek", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    String totalPrice1 = driver.findElement(By.cssSelector("td.cart-subtotal-amount > strong")).getText();
    
    assertEquals(itemPrice1, totalPrice1);
    
    driver.findElement(By.id("header-logo")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | olapicFrame | ]]
    //driver.findElement(By.id("olapicSubmit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    try {
      assertTrue(isElementPresent(By.linkText("1 ITEM")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.cssSelector("li.startrek > a > span.ir")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | olapicFrame | ]]
    //driver.findElement(By.id("olapicSubmit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.cssSelector("a[title=\"Star Trek TNG Pajama Set\"] > img.lazy.prodlist-img-lrg")).click();
    String itemPrice2 = driver.findElement(By.cssSelector("#buy > h3")).getText();
    driver.findElement(By.id("submitcart")).click();
    new Select(driver.findElement(By.id("skucarter"))).selectByVisibleText("Blue, S $39.99");
    driver.findElement(By.xpath("//input[@value='Buy Now']")).click();
    //driver.findElement(By.id("submitcart")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | olapicFrame | ]]
    //driver.findElement(By.id("olapicSubmit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    try {
      assertTrue(isElementPresent(By.cssSelector("td.cart-subtotal-amount > strong")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Your Loot! | ThinkGeek", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    String finalTotalPrice = driver.findElement(By.cssSelector("td.cart-subtotal-amount > strong")).getText();
    
    String temp1 = itemPrice1.substring(1);
    System.out.println(temp1);
    String temp2 = itemPrice2.substring(1);
    System.out.println(temp2);
    double dtemp1 = Double.parseDouble(temp1);
    System.out.println(dtemp1);
    double dtemp2 = Double.parseDouble(temp2);
    System.out.println(dtemp2);
    
    double price = dtemp1 + dtemp2;
    System.out.println(price);
    String tmp = new String("$" + String.format("%1$,.2f", price));
    System.out.println(tmp);
    assertEquals(tmp, finalTotalPrice);
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
