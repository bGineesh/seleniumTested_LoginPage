import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class login_failed_2 {


    public static void main(String[] args) {
//      Path to driver and launching
        System.setProperty("webdriver.chrome.driver", "E:\\Application\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//      Hitting URL
        driver.get("https://sakshingp.github.io/assignment/login.html");

        System.out.println(driver.getTitle());      //print Title

        driver.findElement(By.id("password")).sendKeys("password");        //Passing password only
//       not providing user name
        driver.findElement(By.id("log-in")).click();
        //selecting login Button

        var errorIsDisplayed = driver.findElement(By.xpath("//div[@class='alert alert-warning']"));
        assertThat(errorIsDisplayed.isDisplayed(), is(true));
        driver.quit();
    }
}