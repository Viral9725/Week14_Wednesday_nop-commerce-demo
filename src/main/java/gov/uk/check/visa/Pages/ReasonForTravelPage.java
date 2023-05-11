package gov.uk.check.visa.Pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customListerners.CustomListeners;
import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class ReasonForTravelPage extends Utility {
    public ReasonForTravelPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='govuk-radios']//label")
    List<WebElement> needUKVisa;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Continue']")
    WebElement continueButton;
    //button[normalize-space()='Continue']
    public void selectReasonForVisit(String reason) {
        for (WebElement menu : needUKVisa) {
            if (menu.getText().equals(reason)) {
                clickOnElement(menu);
                CustomListeners.test.log(Status.PASS, "Select reason for visit '" + reason + "' tab");
                Reporter.log("Select reason for visit '" + reason + "' tab <br>");
                break;
            }
        }
    }

    public void clickNextStepButton() {
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on next step");
        Reporter.log("Click on next step" + "<br>");
    }
    @CacheLookup
    @FindBy(linkText = "family permit")
    WebElement familyPermitButton;
    public void familyPermit(){
        clickOnElement(familyPermitButton);
        CustomListeners.test.log(Status.PASS, "Click on family permit");
        Reporter.log("Click on family permit" + "<br>");
    }
}