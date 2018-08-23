package config.locators;

import config.DriverCreator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class IOSLocator implements LocatorInterface {
    public static IOSDriver<IOSElement> driver = null;
    public IOSLocator(){
        driver=DriverCreator.iosDriver;
    }

    @Override
    public MobileElement getLocator(final String strategy, final String element){
        IOSElement e=null;
        MobileBy mobileBy=null;
        switch (strategy) {
            case "accessibility":
                e= initDriver(driver, new MobileBy.ByAccessibilityId(element));
                break;
            case "nspredicate":
                e= initDriver(driver, new MobileBy.ByAccessibilityId(element));
                break;
            case "xpath":
                e=driver.findElementByXPath("//XCUIElementTypeKey[@name=\'"+element+"\']");
                break;
            default:
                //we will pass the element name as a filename for sreenshot
                //TODO: set the scenario name and element name as the SS name
                takeScreenshot(element.split("/")[1]);
                throw new IllegalArgumentException("check type of the identifier");
        }
        return e;
    }

    @Override
    public List getLocators(final String strategy, final String element){
        IOSElement e=null;
        switch (strategy) {
            // hard coding for
            case "nestedpredicate":
                e=(IOSElement)driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeTabBar'")).
                        findElements(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton'"));
                break;
            default:
                throw new IllegalArgumentException("check type of the identifier");
        }
        List<IOSElement> list=null;
        list.add(e);
        return list;
    }

    public void sendKeysToKeyBoard(String keyCode) {

        Keyboard k=driver.getKeyboard();
        k.pressKey(keyCode);
        k.releaseKey(keyCode);
    }
    public void sendKeysToKeyBoard(MobileElement mobileElement) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(mobileElement).perform();
    }

    public IOSElement initDriver(IOSDriver driver, final MobileBy byType){
        Wait wait = new FluentWait(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        IOSElement element = (IOSElement) wait.until(new Function<IOSDriver, IOSElement>() {
            public IOSElement apply(IOSDriver driver) {
                driver = DriverCreator.iosDriver;
                return (IOSElement) driver.findElement(byType);
            }
        });
        wait.until(ExpectedConditions.elementToBeClickable(byType));
        return element;
    }

    public IOSElement initDriverBy(IOSDriver driver, By byType){
        Wait wait = new FluentWait(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        IOSElement element = (IOSElement) wait.until(new Function<IOSDriver, IOSElement>() {
            public IOSElement apply(IOSDriver driver) {
                driver = DriverCreator.iosDriver;
                return (IOSElement) driver.findElement(byType);
            }
        });
        wait.until(ExpectedConditions.elementToBeClickable(byType));
        return element;
    }
    public void takeScreenshot(String tcName){
        //Create Folder for SS
        new File("TestArtifacts").mkdir();
        //Output type
        File f=((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);
        //Set filename
        String filename=tcName+".png";
        try {
            FileUtils.copyFile(f, new File("TestArtifacts" + "/" + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void switchToFrame(String type)  {
        switch (type){
            case ("alert.Accept"):
                driver.switchTo().alert().accept();
                break;
            case ("alert.Dismiss"):
                driver.switchTo().alert().dismiss();
                break;
            default:
                throw new IllegalArgumentException("Not supported");
        }

    }

    //as opposed to Android, IOS starts in UAT env and so we need to switch to STUB
    public void switchToStub(){
        driver.shake();

        initDriver(driver, new MobileBy.ByAccessibilityId("App settings")).click();
        initDriver(driver, new MobileBy.ByAccessibilityId("UAT")).click();
        initDriver(driver, new MobileBy.ByAccessibilityId("Stubs")).click();
        initDriver(driver, new MobileBy.ByAccessibilityId("Done")).click();;
    }

    public void getDateandTimeWheel(){
        driver.findElementByXPath(("//XCUIElementTypePickerWheel[@type='XCUIElementTypePickerWheel']")).click();
    }
}
