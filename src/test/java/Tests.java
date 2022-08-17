import org.junit.*;
import org.openqa.selenium.By;

import static io.restassured.RestAssured.given;

public class Tests extends BaseTest {

    public String baseURL = "https://demo.podium.tools/qa-webchat-lorw/";

    Elements elements;
    Utilities utilities;

    @Test
    public void webchatPageReturns200() throws InterruptedException {
        softly.assertThat(given().when().baseUri(baseURL).get().getStatusCode()==200);
        softly.assertAll();
    }

    @Test
    public void webchatPageLoadsElements() throws InterruptedException {
        elements = new Elements(driver);

        softly.assertThat(elements.contactBubble().isDisplayed());
        softly.assertAll();
    }

    @Test
    public void podiumModalLoads() throws InterruptedException {
        elements = new Elements(driver);
        utilities = new Utilities(driver);

        elements.contactBubble().click();
        utilities.switchToPodiumModalIFrame();

        softly.assertThat(driver.findElement(By.cssSelector(".LocationSelector")).isDisplayed());
        softly.assertAll();
    }

    @Test
    public void podiumModalLoadsElements() throws InterruptedException {
        elements = new Elements(driver);
        utilities = new Utilities(driver);

        elements.contactBubble().click();
        utilities.switchToPodiumModalIFrame();

        softly.assertThat(driver.findElement(By.cssSelector(".LocationSelector__Title")).getText().contains("Select Location"));
        softly.assertThat(driver.findElement(By.cssSelector(".LocationSelector__Subtitle")).getText().contains("Search for the location you want to contact by entering a postal code or address."));
        softly.assertThat(driver.findElement(By.xpath("//input[@name='Search Locations']")).isDisplayed());
        softly.assertThat(elements.locationList().size()==3);
        softly.assertAll();
    }

    @Test
    public void podiumModalSelectLocationLoadsWidgetElements() throws InterruptedException {
        elements = new Elements(driver);
        utilities = new Utilities(driver);

        elements.contactBubble().click();
        utilities.switchToPodiumModalIFrame();
        elements.locationList().get(0).click();

        softly.assertThat(driver.findElement(By.cssSelector("#Name")).isDisplayed());
        softly.assertThat(driver.findElement(By.xpath("//input[@id='Mobile Phone']")).isDisplayed());
        softly.assertThat(driver.findElement(By.cssSelector("#Message")).isDisplayed());
        softly.assertAll();
    }

    @Test
    public void podiumModalNullInputWidgetDisplaysFieldValidation() throws InterruptedException {
        elements = new Elements(driver);
        utilities = new Utilities(driver);

        elements.contactBubble().click();
        utilities.switchToPodiumModalIFrame();
        elements.locationList().get(0).click();
        driver.findElement(By.cssSelector(".SendButton")).click();

        String nameFieldValidation = driver.findElement(By.xpath("//label[@for='Name']/following-sibling::div[@class='TextInput__TextInputError']")).getText();
        String mobilePhoneFieldValidation = driver.findElement(By.xpath("//label[@for='Mobile Phone']/following::*[2]")).getText();
        String messageFieldValidation = driver.findElement(By.xpath("//label[@for='Message']/following-sibling::div[@class='TextInput__TextInputError']")).getText();
    }
}