package gov.uk.check.visa.testbase;

import gov.uk.check.visa.propertyreader.PropertyReader;
import gov.uk.check.visa.utilities.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utility {
    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod
    public void setUp() {selectBrowser(browser); }

    public void setBrowser(String browser){

    }
    @AfterMethod
    public void tearDown(){closeBrowser();}

    public void closeBrowser(){

    }
}
