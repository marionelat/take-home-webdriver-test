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

public class FloatingMenu {
    @Before
    public void setUpMethod() {

        Driver.getDriver().get(ConfigurationReader.getProperty("baseUrl") + "/floating_menu");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        Driver.closeDriver();
    }

    //Floating Menu: http://localhost:7080/floating_menu Test Floating Menu.
    @Test
    public void floatingMenuTest(){
        WebElement homeButton = Driver.getDriver().findElement(By.cssSelector("a[href=\"#home\"]"));
        homeButton.click();
        String expHomeButtonText = "Home";
        String actHomeButtonText = homeButton.getText();

        WebElement newsButton = Driver.getDriver().findElement(By.cssSelector("a[href=\"#news\"]"));
        newsButton.click();
        String expNewsButtonText = "News";
        String actNewsButtonText = newsButton.getText();

        WebElement contactButton = Driver.getDriver().findElement(By.cssSelector("a[href=\"#contact\"]"));
        contactButton.click();
        String expContactButtonText = "Contact";
        String actContactButtonText = contactButton.getText();

        WebElement aboutButton = Driver.getDriver().findElement(By.cssSelector("a[href=\"#about\"]"));
        aboutButton.click();
        String expAboutButtonText = "About";
        String actAboutButtonText = aboutButton.getText();

        Assert.assertEquals(expHomeButtonText,actHomeButtonText);
        Assert.assertEquals(expNewsButtonText,actNewsButtonText);
        Assert.assertEquals(expContactButtonText,actContactButtonText);
        Assert.assertEquals(expAboutButtonText,actAboutButtonText);
    }
}