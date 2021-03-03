package StepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageFactory.HomePage;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

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

    @Quando("aciona o link para solicitação de orçamento")
    public void requestBudget() {
        homePage.requestBudget();
    }

    @Quando("^aciona o menu (.*)$")
    public void accessMenu(String menuName) throws InterruptedException {
        homePage.accessMenu(menuName);
    }

    @Quando("acessa a página do serviço (.*)$")
    public void accessServicePage(String service) throws InterruptedException {
        homePage.accessServicePage(service);
    }

    @Entao("^cliente é redirecionado para a página (.*)$")
    public void isBrowserAtPage(String pageTitle) throws InterruptedException {
        Thread.sleep(3000L);
        Assert.assertTrue(homePage.isBrowserAtPage(pageTitle));
        driver.close();
        driver.quit();
    }

}
