package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import java.util.List;

public class YandexMarketPage {

    private WebDriver driver;

    @FindBy(css = "ul.topmenu__list li")
    private List<WebElement> topMenu;

    public YandexMarketPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MobilePhonesCatalogPage chooseMobilePhonesCatalog(){
        new Actions(driver).moveToElement(topMenu.get(0)).perform();
        WebElement mobilePhonesButton = topMenu.get(0).findElement(By.className("topmenu__subitem_nid_54726"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(mobilePhonesButton));
        mobilePhonesButton.click();
        return new MobilePhonesCatalogPage(driver);
    }
}
