package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import java.util.List;

public class AdvancedSearchPage {

    private WebDriver driver;

    @FindBy(id = "glf-priceto-var")
    private WebElement priceTo;

    @FindBy(xpath = "//span[contains(text(), 'Диагональ экрана')]")
    private WebElement screenDiagonal;

    @FindBy(css = "div.n-filter-block__list-items.i-bem input.checkbox__control")
    private List<WebElement> producers;

    @FindBy(className = "button_action_show-filtered")
    private WebElement showAppropriateButton;

    public AdvancedSearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AdvancedSearchPage fillPriceTo(String price){
        priceTo.sendKeys(price);
        return this;
    }

    public AdvancedSearchPage fillScreenDiagonalFrom(String diagonal){
        screenDiagonal.click();
        driver.findElement(By.id("glf-4925721-from")).sendKeys(diagonal);
        return this;
    }

    public AdvancedSearchPage chooseProducers(int... indexes){
        for(int index: indexes){
            producers.get(index - 1).click();
        }
        return this;
    }

    public MobilePhonesCatalogPage showAppropriate(){
        showAppropriateButton.click();
        return new MobilePhonesCatalogPage(driver);
    }
}
