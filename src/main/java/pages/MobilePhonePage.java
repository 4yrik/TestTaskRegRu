package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class MobilePhonePage {

    private WebDriver driver;

    @FindBy(css = "div.rating.hint.i-bem")
    private WebElement rating;

    public MobilePhonePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getRating(){
        return rating.getText();
    }
}
