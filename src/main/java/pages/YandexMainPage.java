package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class YandexMainPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@data-id=\"market\"]")
    private WebElement marketButton;

    public YandexMainPage(WebDriver driver){
        driver.get("https://www.yandex.ru");
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public YandexMarketPage goToYandexMarketPage(){
        marketButton.click();
        return new YandexMarketPage(driver);
    }

}
