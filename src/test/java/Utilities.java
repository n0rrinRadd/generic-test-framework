import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Utilities {

    public WebDriver driver;

    public Utilities(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToPodiumBubbleIFrame() throws InterruptedException {
        switchToIFrame("podium-bubble");
    }

    public void switchToPodiumModalIFrame() throws InterruptedException {
        switchToIFrame("podium-modal");
    }

    public void switchToIFrame(String iframe) throws InterruptedException {
        driver.switchTo().parentFrame();
        Thread.sleep(3000);
        int size = driver.findElements(By.tagName("iframe")).size();
        driver.switchTo().frame(iframe);
    }
}
