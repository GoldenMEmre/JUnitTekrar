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

public class C02_CheckBox {
    /*
    a. Verilen web sayfasına gidin.
    https://the-internet.herokuapp.com/checkboxes
    b. Checkbox1 ve checkbox2 elementlerini locate edin.
    c. Checkbox1 seçili değilse onay kutusunu tıklayın
    d. Checkbox2 seçili değilse onay kutusunu tıklayın
    e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin
    */

    WebDriver driver;
    //Before&AfterClass'da olduğu gibi static yapmak zorunda değiliz.
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown(){
        driver.close();
    }
    @Test
    public void checkBoxTest() throws InterruptedException {
        //a. Verilen web sayfasına gidin.
        //    https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //    b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkbox1Elementi = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2Elementi = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        Thread.sleep(3000);
        //    c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkbox1Elementi.isSelected()){
            checkbox1Elementi.click();
        }

        Thread.sleep(3000);
        //    d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkbox2Elementi.isSelected()){
            checkbox2Elementi.click();
        }

        Thread.sleep(3000);
        //    e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin
        Assert.assertTrue(checkbox1Elementi.isSelected()&& checkbox2Elementi.isSelected());


    }


}
