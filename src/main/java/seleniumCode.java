import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;



public class seleniumCode {


    public static void main(String[] args){
//      Path to driver and launching
        System.setProperty("webdriver.chrome.driver", "E:\\Application\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//      Hitting URL
        driver.get("https://sakshingp.github.io/assignment/login.html");

        System.out.println(driver.getTitle());      //print Title

        driver.findElement(By.id("username")).sendKeys("Admin");        //Passing User Name
        driver.findElement(By.id("password")).sendKeys("password");      //Passing Password

        driver.findElement(By.id("log-in")).click();
        //selecting login Button

        System.out.println(driver.getTitle());
        //Capturing Amount Table (Size and Text) stored in list
        int data = driver.findElements(By.xpath("//td[@class='text-right bolder nowrap']")).size();
        List<String> tableList = new ArrayList<>();
        for(int i =0; i<data; i++) {
            var list = driver.findElements(By.xpath("//td[@class='text-right bolder nowrap']")).get(i).getText();
            tableList.add(list);
        }
        // default values as per application
        System.out.println("tableList"+tableList);

        //selecting Amount header in from table
        driver.findElement(By.id("amount")).click();

        //Capturing Amount Table (Size and Text) stored in list after
        int data1 = driver.findElements(By.xpath("//td[@class='text-right bolder nowrap']")).size();
        List<String> tableList1 = new ArrayList<>();
        for(int i =0; i<data1; i++) {
            var list = driver.findElements(By.xpath("//td[@class='text-right bolder nowrap']")).get(i).getText();
            tableList1.add(list);
        }
        //sorted order
        System.out.println("tableList1"+tableList1);

        // tableList is not equal tableList1  because after selecting amount header it will in some sorted format
        assertThat(tableList.equals(tableList1), is(false));

//        // for ascending
//        Collections.sort(tableList);
//        System.out.println("asc"+tableList);
//
////        assertThat(tableList.equals(tableList1), is(false));
//
//        // for descending
//        Collections.sort(tableList, Collections.reverseOrder());
//        System.out.println("des"+tableList);
//
////        assertThat(tableList.equals(tableList1), is(true));


        driver.quit();
    }
}

