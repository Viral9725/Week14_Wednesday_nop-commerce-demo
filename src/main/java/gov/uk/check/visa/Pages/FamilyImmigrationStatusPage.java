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

public class FamilyImmigrationStatusPage extends Utility {

// nextStepButton, yes, no locators and create methods 'void selectImmigrationStatus(String status)'
//  (Note: Use switch statement for select immigration status) and 'void clickNextStepButton()'

    public FamilyImmigrationStatusPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='govuk-radios']//label")
    List<WebElement> immigrationStatus;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Continue']")
    WebElement continueButton;


    public void selectImmigrationStatus(String status) {
        for (WebElement menu : immigrationStatus) {
            if (menu.getText().equals(status)) {
                clickOnElement(menu);
                CustomListeners.test.log(Status.PASS, "Select immigration status: '" + status + "' radio button");
                Reporter.log("Select immigration status '" + status + "' radio button <br>");
                break;
            }
        }
    }

    public void clickNextStepButton() {
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on next step");
        Reporter.log("Click on next step" + "<br>");

    }
}
