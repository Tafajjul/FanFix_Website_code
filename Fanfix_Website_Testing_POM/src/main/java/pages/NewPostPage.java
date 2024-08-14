package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NewPostPage extends BasePage {

	@FindBy(xpath = "//button[@data-testid='pill-button-new-post-ds']")
	WebElement newPost;

	@FindBy(xpath = "//button[.='Free Post']")
	WebElement FreePost;

	@FindBy(xpath = "//div[@data-testid='post-caption-input-c']/.//div/.//textarea[@placeholder=\"What's on your mind?\"]")
	WebElement postField;

	@FindBy(xpath = "//div[@class=\"MuiBox-root css-1u5aujn\"]/.//p[.='Now']")
	WebElement nowDropDown;

	@FindBy(xpath = "(//div[@class=\"MuiStack-root css-lmzl00\"])[2]/.//p[.='Custom Time']")
	WebElement customTime;

	@FindBy(xpath = "//button[@type='button' and @aria-label='Choose date, selected date is Aug 14, 2024']")
	WebElement selectDate;

	@FindBy(xpath = "//button[@title='Next month']")
	WebElement changeMonth;

	@FindBy(xpath = "//div[@class='MuiPickersSlideTransition-root MuiDayCalendar-slideTransition css-1xuxf2l' and @role='presentation']/.//div/.//div/.//button[.='1']")
	WebElement selectFirstSept;

	@FindBy(xpath = "//div[@role='group' and @class='MuiMultiSectionDigitalClock-root css-11cj477']/.//ul/.//li[.='03']")
	WebElement selectTime1;

	@FindBy(xpath = "//div[@role='group']/.//ul[@aria-label='Select minutes']/.//li[.='30']")
	WebElement selectTime2;

	@FindBy(xpath = "//button[.='OK']")
	WebElement clickOK;

	@FindBy(xpath = "//button[@data-testid='pill-button-post-to-profile-ds']")
	WebElement clickPostToProfile;

	public NewPostPage(WebDriver driver) {
		super(driver);
	}

	public void clickNewPostButton() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@data-testid='pill-button-new-post-ds']")));

		newPost.click();
		Thread.sleep(3000);
	}

	public void clickFreePost() {
		FreePost.click();

	}

	public void writePostCaption(String caption) throws InterruptedException {

		postField.click();
		postField.sendKeys(caption);
		Thread.sleep(4000);
	}

	public void customTimeselect() {
		nowDropDown.click();
		customTime.click();

	}

	public void customDateselect() throws InterruptedException {
		selectDate.click();
		Thread.sleep(3000);

	}

	public void custommonthTimeelect() throws InterruptedException {
		JavascriptExecutor ja = (JavascriptExecutor) driver;
		ja.executeScript("arguments[0].scrollIntoView();", selectFirstSept);
		ja.executeScript("arguments[0].scrollIntoView();", selectTime1);
		ja.executeScript("arguments[0].scrollIntoView();", selectTime2);
		changeMonth.click();
		System.out.println("navigated to sept month from the calendar");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='MuiPickersSlideTransition-root MuiDayCalendar-slideTransition css-1xuxf2l' and @role='presentation']/.//div/.//div/.//button[.='1']")));

		//Thread.sleep(3000);
		selectFirstSept.click();

		System.out.println("Date selected 1st sept from the calendar");
		Thread.sleep(3000);
		selectTime1.click();
		selectTime2.click();
		System.out.println("Time 3:30 selected from the calendar");
		Thread.sleep(3000);
	}

	public void clickOkAndPost() throws InterruptedException {
		clickOK.click();
		clickPostToProfile.click();
		System.out.println("Clicked on Post button");
		Thread.sleep(3000);

	}

}