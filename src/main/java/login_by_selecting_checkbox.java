import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class login_by_selecting_checkbox {


    public static void main(String[] args) {
//      Path to driver and launching
        System.setProperty("webdriver.chrome.driver", "E:\\Application\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//      Hitting URL
        driver.get("https://sakshingp.github.io/assignment/login.html");

        System.out.println(driver.getTitle());      //print Title
        driver.findElement(By.id("username")).sendKeys("Admin");         //Passing user name
        driver.findElement(By.id("password")).sendKeys("Admin");        //Passing password
//      selecting check box
        driver.findElement(By.xpath("//div[@class='form-check-inline']")).isDisplayed();
        driver.findElement(By.xpath("//div[@class='form-check-inline']")).click();

        driver.findElement(By.id("log-in")).click();
        //selecting login Button


        assertThat(driver.getTitle().toString().equals("Demo App"), is(true));
        driver.quit();
    }
}