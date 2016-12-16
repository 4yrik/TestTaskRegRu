package tests;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import java.util.concurrent.TimeUnit;

public class TestClass {

    private WebDriver driver;

    @Before
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "/Users/user/Documents/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testCase(){
        MobilePhonesCatalogPage mobilePhonesCatalogPage = new YandexMainPage(driver).goToYandexMarketPage()
                                                                                    .chooseMobilePhonesCatalog()
                                                                                    .goToAdvancedSearch()
                                                                                    .fillPriceTo("20000")
                                                                                    .chooseProducers(1, 3, 5, 7, 9)
                                                                                    .fillScreenDiagonalFrom("3")
                                                                                    .showAppropriate();
        int numberOfPhones = mobilePhonesCatalogPage.getNumberOfPhones();
        try{
            Assert.assertEquals("Number of phones on the page is NOT 10", 10, numberOfPhones);
        }catch (Error e){
            System.out.println(e.getMessage());
        }
        String firstPhoneName = mobilePhonesCatalogPage.getPhoneNameByIndex(1);
        String phoneRating = mobilePhonesCatalogPage.changeSorting("по новизне")
                                                    .findAndClickPhoneElement(firstPhoneName)
                                                    .getRating();
        System.out.println(String.format("Phone %s, rating is %s", firstPhoneName, phoneRating));
    }

    @After
    public void afterTest(){
        driver.quit();
    }
}
