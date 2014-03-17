//package senddoumail
//import org.junit.After
//import org.junit.Before
//import org.junit.Test
//import org.openqa.selenium.*
//import org.openqa.selenium.firefox.FirefoxDriver
//
//import java.util.concurrent.TimeUnit
//
//import static org.junit.Assert.fail;
//
//public class TestService {
//    private WebDriver driver;
//    private String baseUrl;
//    private boolean acceptNextAlert = true;
//    private StringBuffer verificationErrors = new StringBuffer();
//
//    @Before
//    public void setUp() throws Exception {
//        driver = new FirefoxDriver();
//        baseUrl = "http://www.douban.com/";
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    }
//
//    @Test
//    public void testUntitled() throws Exception {
//        driver.get(baseUrl + "/accounts/login?uid=&alias=&redir=http%3A%2F%2Fwww.douban.com%2F&source=index_nav&error=1001");
//        driver.findElement(By.id("email")).clear();
//        driver.findElement(By.id("email")).sendKeys("hsw117@sina.com");
//        driver.findElement(By.id("password")).clear();
//        driver.findElement(By.id("password")).sendKeys("089392");
//        driver.findElement(By.name("user_login")).click();
//        println("OK!!!")
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        driver.quit();
//        String verificationErrorString = verificationErrors.toString();
//        if (!"".equals(verificationErrorString)) {
//            fail(verificationErrorString);
//        }
//    }
//
//    private boolean isElementPresent(By by) {
//        try {
//            driver.findElement(by);
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
//
//    private boolean isAlertPresent() {
//        try {
//            driver.switchTo().alert();
//            return true;
//        } catch (NoAlertPresentException e) {
//            return false;
//        }
//    }
//
//    private String closeAlertAndGetItsText() {
//        try {
//            Alert alert = driver.switchTo().alert();
//            String alertText = alert.getText();
//            if (acceptNextAlert) {
//                alert.accept();
//            } else {
//                alert.dismiss();
//            }
//            return alertText;
//        } finally {
//            acceptNextAlert = true;
//        }
//    }
//}
