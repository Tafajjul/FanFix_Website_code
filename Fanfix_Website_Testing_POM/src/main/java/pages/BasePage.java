package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class BasePage {



    protected WebDriver driver;
    //protected ActionClass Action;
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
        //this.Action=new ActionClass(driver);
        PageFactory.initElements(driver, this);
    }
}
