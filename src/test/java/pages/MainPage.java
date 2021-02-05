package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }
    private By pasteField = By.id("postform-text");
    private By syntaxField = By.id("select2-postform-format-container");
    private By syntaxPushing = By.className("select2-search__field");
    private By pasteExpirationPushing = By.id("select2-postform-expiration-container");
    private By pasteExpirationSelection = By.xpath("//li[text()='10 Minutes']");
    private By pasteNameFieldPushing = By.id("postform-name");
    private By newPasteButton = By.xpath("//button[@class='btn -big']");
    private By textFromNameMath = By.xpath("//div[@class='info-top']/child::h1");
    private By textFromSyntaxButton = By.xpath("//div[@class='left']/child::a");
    private By textFromDataField = By.xpath("//textarea[@class='textarea']");

    public void openPage(){
        driver.get("https://pastebin.com");
    }

    public void writeTextInToNewPasteField(String textForNewPaste){
        driver.findElement(pasteField).sendKeys(textForNewPaste);
    }

    public void selectSyntaxHighlighting(String syntax){
        driver.findElement(syntaxField).click();
        WebElement syntaxSelection = driver.findElement(syntaxPushing);
        syntaxSelection.sendKeys(syntax);
        syntaxSelection.sendKeys(Keys.ENTER);
    }
    public void selectPasteExpiration(){
        driver.findElement(pasteExpirationPushing).click();
        driver.findElement(pasteExpirationSelection).click();
    }

    public void writeTextInToPasteNameField(String textForPasteName){
        driver.findElement(pasteNameFieldPushing).sendKeys(textForPasteName);
    }

    public void pressCreateNewPasteButton(){
        driver.findElement(newPasteButton).click();
    }

    public void checkPasteNameMath(String textForPasteName){
        String isExist = driver.findElement(textFromNameMath).getText();
        assertEquals(isExist,textForPasteName);
    }

    public void checkTextOnSyntaxButton(String syntax){
        String isExist = driver.findElement(textFromSyntaxButton).getText();
       assertEquals(isExist,syntax);
    }

    public void checkTextInRawPasteDataField(String textInPasteData){
        String isExist = driver.findElement(textFromDataField).getText();
        assertEquals(isExist,textInPasteData);
    }
}
