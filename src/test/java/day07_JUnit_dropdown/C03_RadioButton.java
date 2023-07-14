package day07_JUnit_dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //a. Verilen web sayfasına gidin.
    //https://facebook.com
    //b. Cookies’i kabul edin
    //c. Create an account buton’una basin
    //d. Radio button elementlerini locate edin ve size uygun olani secin
    //e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown() {
        driver.close();

    }

    @Test
    public void radioButtonTesti() {

        //a. Verilen web sayfasına gidin.
        //https://facebook.com
        driver.get("https://facebook.com");

    //b. Cookies’i kabul edin
    //c. Create an account buton’una basin
    driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

    //d. Radio button elementlerini locate edin ve size uygun olani secin
        WebElement erkekButon = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        erkekButon.click();

    //e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        WebElement kadinButon = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement ozelButon = driver.findElement(By.xpath("(//input[@type='radio'])[3]"));

        Assert.assertTrue(erkekButon.isSelected()&& !kadinButon.isSelected() && !ozelButon.isSelected());

}


}
