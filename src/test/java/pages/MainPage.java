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
    public void openPage(){
        driver.get("https://pastebin.com");
    }

    public void writeTextInToNewPasteField(String textForNewPaste){
        driver.findElement(By.id("postform-text")).sendKeys(textForNewPaste);
    }

    public void selectSyntaxHighlighting(String syntax){
        driver.findElement(By.id("select2-postform-format-container")).click();
        WebElement syntaxSelection = driver.findElement(By.className("select2-search__field"));
        syntaxSelection.sendKeys(syntax);
        syntaxSelection.sendKeys(Keys.ENTER);
    }
    public void selectPasteExpiration(){
        driver.findElement(By.id("select2-postform-expiration-container")).click();
        driver.findElement(By.xpath("//li[text()='10 Minutes']")).click();
    }

    public void writeTextInToPasteNameField(String textForPasteName){
        driver.findElement(By.id("postform-name")).sendKeys(textForPasteName);
    }

    public void pressCreateNewPasteButton(){
        driver.findElement(By.xpath("//button[@class='btn -big']")).click();
    }

    public void checkPasteNameMath(String textForPasteName){
        String isExist = driver.findElement(By.xpath("//div[@class='info-top']/child::h1")).getText();
        assertEquals(isExist,textForPasteName);
    }

    public void checkTextOnSyntaxButton(String syntax){
        String isExist = driver.findElement(By.xpath("//div[@class='left']/child::a")).getText();
       assertEquals(isExist,syntax);
    }

    public void checkTextInRawPasteDataField(String textInPasteData){
        String isExist = driver.findElement(By.xpath("//textarea[@class='textarea']")).getText();
        assertEquals(isExist,textInPasteData);
    }
}
