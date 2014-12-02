package account_suite;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class accountLoggedInNav {
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
  public void testAccountLoggedInNav() throws Exception {
    driver.get(baseUrl + "/");
    try {
      assertEquals("ThinkGeek | Join In. Geek Out.", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
      verificationErrors.append("1");
    }
    try {
      assertTrue(isElementPresent(By.linkText("LOG IN")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
      verificationErrors.append("2");
    }
    try {
      assertTrue(isElementPresent(By.linkText("NO LOOT")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
      verificationErrors.append("3");
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
      assertTrue(isElementPresent(By.cssSelector("h1")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
      verificationErrors.append("4");
    }
    driver.findElement(By.id("header-logo")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | olapicFrame | ]]
    //driver.findElement(By.id("olapicSubmit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    try {
      assertTrue(isElementPresent(By.cssSelector("#topnav_account > a > span")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
      verificationErrors.append("5");
    }
    assertEquals("HAI, BRETT\nYOUR ACCOUNT", driver.findElement(By.cssSelector("#topnav_account > a > span")).getText());
    try {
      assertTrue(isElementPresent(By.linkText("SHOP BY CATEGORY")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
      verificationErrors.append("6");
    }
    assertEquals("SHOP BY CATEGORY", driver.findElement(By.linkText("SHOP BY CATEGORY")).getText());
    driver.findElement(By.linkText("Knives, Swords & Axes")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | olapicFrame | ]]
    //driver.findElement(By.id("olapicSubmit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    try {
      assertEquals("Knives, Swords & Axes | Tools, Outdoor & Survival | ThinkGeek", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
      verificationErrors.append("7");
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("#topnav_account > a > span > strong")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
      verificationErrors.append("8");
    }
    assertEquals("HAI, BRETT\nYOUR ACCOUNT", driver.findElement(By.cssSelector("#topnav_account > a > span")).getText());
    driver.findElement(By.cssSelector("a[title=\"Cardsharp 2 Credit Card Knife\"] > img.lazy.prodlist-img-lrg")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | olapicFrame | ]]
    //driver.findElement(By.id("olapicSubmit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    try {
      assertEquals("Cardsharp 2 Credit Card Knife | ThinkGeek", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
      verificationErrors.append("9");
    }
    assertEquals("HAI, BRETT\nYOUR ACCOUNT", driver.findElement(By.cssSelector("#topnav_account > a > span")).getText());
    try {
      assertTrue(isElementPresent(By.cssSelector("#topnav_account > a > span")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
      verificationErrors.append("10");
    }
    try {
      assertTrue(isElementPresent(By.id("wish-list-add-default")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
      verificationErrors.append("11");
    }
    /*driver.findElement(By.linkText("LOG OUT")).click();
    try {
      assertTrue(isElementPresent(By.linkText("LOG IN")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals("Log In", driver.findElement(By.linkText("Log In")).getText());*/
    
    driver.findElement(By.cssSelector("#topnav_account > a > span")).click();
    driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
    assertEquals("LOG IN", driver.findElement(By.linkText("LOG IN")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
    	//System.out.println(verificationErrorString);
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
