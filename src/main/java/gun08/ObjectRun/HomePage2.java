package gun08.ObjectRun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class HomePage2 {

    private WebDriver driver;
    private WebDriverWait wait;

    String url = "https://opencart.abstracta.us/";

    @FindBy(xpath = "//div[@id='top-links']//a[contains(., 'My Account')]")
    public WebElement eMyAccountLink;

    @FindBy(xpath = "//div[@id='top-links']//a[contains(., 'Login')]")
    public WebElement eMyAccountLoginLink;

    @FindBy(xpath = "//div[@id='top-links']//a[contains(., 'Logout')]")
    public WebElement eMyAccountLogouLink;

    @FindBy(id = "input-email")
    public WebElement eLoginFormUsername;

    @FindBy(id = "input-password")
    public WebElement eLoginFormPassword;

    @FindBy(xpath = "//input[@value='Login']")
    public WebElement eLoginSubmitButton;

    @FindBy(xpath = "//aside//a[text()='My Account']")
    public WebElement eRightMenuMyAccount;

    @FindBy(xpath = "//aside//a[text()='Login']")
    public WebElement eRightMenuLogin;



    public HomePage2(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }


    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendKeys(WebElement element, String text){
        WebElement element1 = waitUntilVisible(element);
        element1.clear();
        element1.sendKeys(text);
    }

    public WebElement waitUntilVisible(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void gotoUrl(){
        driver.get(url);
    }

    public void login(){
        click(eMyAccountLink);
        waitUntilVisible(eMyAccountLoginLink);
        click(eMyAccountLoginLink);
        sendKeys(eLoginFormUsername, "deneme@deneme.com");
        sendKeys(eLoginFormPassword, "deneme");
        click(eLoginSubmitButton);
        waitUntilVisible(eRightMenuMyAccount);
    }

    public void logout(){
        click(eMyAccountLink);
        waitUntilVisible(eMyAccountLogouLink);
        click(eMyAccountLogouLink);
        waitUntilVisible(eRightMenuLogin);
    }




}
