package pageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    AndroidDriver<AndroidElement> driver;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div[2]/div[1]/div[2]/button")
    WebElement expandMenuBtn;

    @FindBy(xpath = "//*[@id=\"menu-menu-topo-1\"]/li[3]/span")
    WebElement expandServicesSubmenuBtn;

    @FindBy(xpath = "//*[@id=\"sgpb-popup-dialog-main-div-wrapper\"]/div/img")
    WebElement contactPopupCloseBtn;

    public HomePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void closeWelcomeContactPopup() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(contactPopupCloseBtn));
        contactPopupCloseBtn.click();
    }

    public void accessMenu(String menuName) {
        expandMenuBtn.click();
        driver.findElement(By.xpath("//*[@id=\"menu-menu-topo-1\"]/li/a[contains(.,'" + menuName + "')]")).click();
    }

    public void accessServicePage(String service) throws InterruptedException {
        expandMenuBtn.click();
        expandServicesSubmenuBtn.click();
        driver.findElement(By.xpath("//*[@id=\"menu-menu-topo-1\"]/li/ul/li/a[contains(.,'" + service + "')]")).click();
    }

}
