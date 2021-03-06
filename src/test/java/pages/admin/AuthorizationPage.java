package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "input[name='email']")
    public WebElement emailTF;

    @FindBy(css = "input[name='passwd']")
    public WebElement passwordTF;

    @FindBy(css = "button[name='submitLogin']")
    public WebElement logInBtn;

    @FindBy(css = "input[id='stay_logged_in']")
    public WebElement rememberMeCheckbox;

    @FindBy(css = "h4[id='shop_name']")
    public WebElement title;

    public AuthorizationPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    private void inputDataIntoTextField(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }

    public void signInToAccount(String email, String password){
        wait.until(ExpectedConditions.elementToBeClickable(logInBtn));
        inputDataIntoTextField(emailTF, email);
        inputDataIntoTextField(passwordTF, password);
        logInBtn.click();
    }

    public void signInToAccountAndRememberData(String email, String password){
        inputDataIntoTextField(emailTF, email);
        inputDataIntoTextField(passwordTF, password);
        rememberMeCheckbox.click();
        logInBtn.click();
    }
}
