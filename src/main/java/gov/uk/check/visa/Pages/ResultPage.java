package gov.uk.check.visa.Pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customListerners.CustomListeners;
import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class ResultPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[@class='gem-c-heading gem-c-heading--font-size-27 govuk-!-margin-bottom-6']")
    WebElement getMessage;
    public String getResultMessage() {
        String result = getTextFromElement(getMessage);
        return result;
    }
    public void verifyIfResultMessage(String expMsg) {
        if (getResultMessage().equalsIgnoreCase(expMsg)) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
        CustomListeners.test.log(Status.PASS, "Confirm message displayed : " + getMessage.getText());
        Reporter.log("Confirm message displayed : " + getMessage.getText() + "<br>");
    }
}