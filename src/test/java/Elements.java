import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Elements {

    public WebDriver driver;
    public Utilities utilities;

    public Elements(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement contactBubble() throws InterruptedException {
        utilities = new Utilities(driver);
        utilities.switchToPodiumBubbleIFrame();
        return driver.findElement(By.cssSelector(".ContactBubble__Bubble"));
    }

    public WebElement h1(){
        return driver.findElement(By.tagName("h1"));
    }

    public List<WebElement> locationList(){
        return driver.findElements(By.tagName("button"));
    }

}
