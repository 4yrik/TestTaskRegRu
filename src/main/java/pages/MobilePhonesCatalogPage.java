package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MobilePhonesCatalogPage {

    private WebDriver driver;

    @FindBy(linkText = "Перейти ко всем фильтрам")
    private WebElement advancedSearchButton;

    @FindBy(css = "span.snippet-card__header-text")
    private List<WebElement> phonesList;

    @FindBy(css = "a.n-filter-sorter__link")
    private List<WebElement> sortingList;

    @FindBy(css = "a.n-pager__button-next")
    private WebElement nextButton;

    public MobilePhonesCatalogPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AdvancedSearchPage goToAdvancedSearch(){
        advancedSearchButton.click();
        return new AdvancedSearchPage(driver);
    }

    public int getNumberOfPhones(){
        return phonesList.size();
    }

    public String getPhoneNameByIndex(int index){
        return phonesList.get(index - 1).getText();
    }

    public MobilePhonesCatalogPage changeSorting(String sorting){
        for(WebElement element: sortingList){
            if(element.getText().equals(sorting)){
                element.click();
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){}
                break;
            }
        }
        return this;
    }

    public MobilePhonePage findAndClickPhoneElement(String element){
        driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
        while(true){
            try {
                WebElement phone = driver.findElement(By.xpath(String.format("//span[contains(text(), '%s')]", element)));
                phone.click();
                return new MobilePhonePage(driver);
            }catch (NoSuchElementException e){
                try {
                    nextButton.click();
                }catch (NoSuchElementException ex){
                    break;
                }
            }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return null;
    }
}
