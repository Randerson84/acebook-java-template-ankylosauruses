import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import com.makersacademy.acebook.Application;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ProfileTest {
    WebDriver driver;
    Faker faker;
    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        faker = new Faker();
        String username = faker.internet().emailAddress();
        driver.get("http://localhost:8080/users/new");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys("Password098!");
        driver.findElement(By.id("submit")).click();
        driver.get("http://localhost:8080/login");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys("Password098!");
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.id("content")).sendKeys("LikeTest");
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.id("like")).click();
        driver.findElement(By.id("profile")).click();
    }
    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void successfulRedirectToPostsPage() {
        driver.findElement(By.id("posts")).click();
        String title = driver.getTitle();
        Assert.assertEquals("Acebook", title);
    }
    @Test
    public void successfulRedirectToLogoutPage() {
        driver.findElement(By.id("logout")).click();
        String title = driver.getTitle();
        Assert.assertEquals("Logout", title);
    }
    @Test
    public void LikesIncrease(){
        String likes = String.valueOf(driver.findElement(By.id("NoLikes")).getText());
        Assert.assertEquals("1", likes);
        driver.findElement(By.id("like")).click();
        String likes2 = String.valueOf(driver.findElement(By.id("NoLikes")).getText());
        Assert.assertEquals("2", likes2);
    }
}
