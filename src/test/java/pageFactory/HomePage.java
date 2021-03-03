package pageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    AndroidDriver<AndroidElement> driver;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div[2]/div[1]/div[2]/button")
    WebElement expandMenuBtn;

    @FindBy(xpath = "//*[@id=\"sgpb-popup-dialog-main-div-wrapper\"]/div/img")
    WebElement contactPopupCloseBtn;

    @FindBy(xpath = "//*[@id=\"rodape-faixa-preta\"]/div[2]/div/div/div[1]/a")
    WebElement requestBudgetBtn;

    @FindBy(id = "menu-item-290")
    WebElement servicesMenuBtn;


    public HomePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void closeWelcomeContactPopup(){
        contactPopupCloseBtn.click();
    }

    public void requestBudget() {
        requestBudgetBtn.click();
    }

    public void accessMenu(String menuName) throws InterruptedException {
        expandMenuBtn.click();
        int menuIndex = 1;
        switch (menuName){
            case "Quem somos":
                menuIndex = 2;
                break;
        }
//        driver.findElement(By.xpath("//*[@id=\"menu-menu-topo-1\"]/li[" + menuIndex + "]/a")).click();
        driver.findElement(By.xpath("//ul/li/a[@text='" + menuName + "']")).click();
//        Thread.sleep(5000L);
//        driver.findElement(By.xpath("//ul/li[contains(.,'" + menuName + "')]")).click();
    }

    public void accessServicePage(String service) throws InterruptedException {
        expandMenuBtn.click();
        openServicesSubmenu();
//      driver.findElement(By.xpath("//ul/li/a[contains(.,'" + service + "')]")).click();
    }

    public boolean isBrowserAtPage(String pageTitle){
        return driver.getPageSource().contains("//" + pageTitle);
    }

    private void openServicesSubmenu() throws InterruptedException {
        servicesMenuBtn.click();
        Thread.sleep(1000L);
    }
}
