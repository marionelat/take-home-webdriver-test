package MarionelaTirsina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import utilities.ConfigurationReader;
import utilities.Driver;
import java.util.concurrent.TimeUnit;

public class NotificationMessage {
    @Before
    public void setUpMethod() {

        Driver.get().get(ConfigurationReader.get("baseUrl") + "/notification_message_rendered");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        Driver.closeDriver();
    }
//    Notification Message: http://localhost:7080/notification_message_rendered Test notification Message.
    @Test
    public void notificationMessageTest(){

        WebElement clickHere = Driver.get().findElement(By.cssSelector("a[href='/notification_message']"));
        clickHere.click();

        String actualNotification = Driver.get().findElement(By.id("flash")).getText();
//        System.out.println("actualNotification = " + actualNotification);

        Assert.assertTrue(actualNotification.contains("Action successful") || actualNotification.contains("Action unsuccesful, please try again"));







    }
}
