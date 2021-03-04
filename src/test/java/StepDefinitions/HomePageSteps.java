package StepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageFactory.HomePage;

import java.net.MalformedURLException;

public class HomePageSteps extends AutomationChromeBase {

    AndroidDriver<AndroidElement> driver = null;
    HomePage homePage;

    @Dado("que cliente acessa o site da Auditeste")
    public void accessAuditesteSite() throws MalformedURLException {
        driver = setupCapabilities();
        driver.get("https://auditeste.com.br");
        homePage = new HomePage(driver);
        homePage.closeWelcomeContactPopup();
    }

    @Quando("^aciona o menu (.*)$")
    public void accessMenu(String menuName) {
        homePage.accessMenu(menuName);
    }

    @Quando("acessa a página do serviço (.*)$")
    public void accessServicePage(String service) throws InterruptedException {
        homePage.accessServicePage(service);
    }

    @Entao("^cliente é redirecionado para a página (.*)$")
    public void isBrowserAtPage(String pageTitle) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Assert.assertTrue(wait.until(ExpectedConditions.titleIs(pageTitle + " - Auditeste")));
        // This wait is only for viewing the screen on the emulator during testing
        Thread.sleep(3000L);
        driver.close();
        driver.quit();
    }

}
