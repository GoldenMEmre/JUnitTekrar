package day07_JUnit_dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeAfterClass {
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //○ titleTest  => Sayfa başlığının “YouTube” oldugunu test edin
    //○ imageTest  => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //○ Search Box ’in erisilebilir oldugunu test edin (isEnabled())
    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
        }

        @AfterClass
        public static void teardown(){
        driver.close();

        }
        @Test
        public void titleTest(){
        //○ titleTest  => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        }

        @Test
        public void imageTest(){
        //○ imageTest  => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement youTubeResmi = driver.findElement(By.xpath("(//*[@class='style-scope ytd-logo'])[1]"));
        Assert.assertTrue(youTubeResmi.isDisplayed());

        }
    @Test
    public void searchBoxTest(){
    //○ Search Box ’in erisilebilir oldugunu test edin (isEnabled())
    WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
    Assert.assertTrue(searchBox.isEnabled());

        }
    @Test
    public void sayfaBasligi(){
    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    String expectedTitle= "youtube";
    String actualTitle = driver.getTitle();
    Assert.assertNotEquals(actualTitle,expectedTitle);
    }






    }

