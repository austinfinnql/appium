package config.locators;

import config.DriverCreator;
import cucumber.api.Scenario;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
/*import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;*/

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class AndroidLocator  implements LocatorInterface{

    public static AndroidDriver<AndroidElement> driver = null;
    public AndroidLocator(){
        driver=DriverCreator.androidDriver;
    }

    @Override
    public MobileElement getLocator(final String strategy, final String element){
        AndroidElement e=null;
        MobileBy mobileBy=null;
        Wait wait = new FluentWait(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        switch (strategy) {
            case "id":
                e = (AndroidElement) wait.until(new Function<AndroidDriver, AndroidElement>() {
                    public AndroidElement apply(AndroidDriver driver) {
                        driver = DriverCreator.androidDriver;
                        return (AndroidElement) driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiSelector().resourceId(\""+element+"\")"));
                    }
                });
                wait.until(ExpectedConditions.elementToBeClickable(new MobileBy.ByAndroidUIAutomator("new UiSelector().resourceId(\""+element+"\")")));
            break;
            case "accessibility":
                e = (AndroidElement) wait.until(new Function<AndroidDriver, AndroidElement>() {
                            public AndroidElement apply(AndroidDriver driver) {
                                driver = DriverCreator.androidDriver;
                                return (AndroidElement) driver.findElement(new MobileBy.ByAccessibilityId(element));
                            }
                        });
                wait.until(ExpectedConditions.elementToBeClickable(new MobileBy.ByAccessibilityId(element)));
                break;
            case ("descriptionStartsWith"):
                e= initDriver(this.driver, new MobileBy.ByAndroidUIAutomator
                        ("descriptionStartsWith(\""+element+"\")"));
                break;
            case ("textStartsWith"):
                e= initDriver(this.driver, new MobileBy.ByAndroidUIAutomator
                        ("descriptionStartsWith(\""+element+"\")"));
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
        List<AndroidElement> e=null;
        switch (strategy) {
            case "id":
                //e= (List<AndroidElement>) driver.findElements(MobileBy.AndroidUIAutomator(element));
                e= (List<AndroidElement>) driver.findElements(new MobileBy.ByAndroidUIAutomator("new UiSelector().resourceId(\""+element+"\")"));

                break;
            default:
                throw new IllegalArgumentException("check type of the identifier");
        }
        return e;
    }

    public void sendKeysToKeyBoard(int keyCode) {

        driver.pressKeyCode(keyCode);
        //driver.pressKey(new KeyEvent(keyCode));
    }

    public AndroidElement initDriver(AndroidDriver driver, final MobileBy byType){
        Wait wait = new FluentWait(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        AndroidElement element = (AndroidElement) wait.until(new Function<AndroidDriver, AndroidElement>() {
            public AndroidElement apply(AndroidDriver driver) {
                driver = DriverCreator.androidDriver;
                return (AndroidElement) driver.findElement(byType);
            }
        });
        wait.until(ExpectedConditions.elementToBeClickable(byType));
        return element;
    }

    public AndroidElement initDriverBy(AndroidDriver driver, By byType){
        Wait wait = new FluentWait(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        AndroidElement element = (AndroidElement) wait.until(new Function<AndroidDriver, AndroidElement>() {
            public AndroidElement apply(AndroidDriver driver) {
                driver = DriverCreator.androidDriver;
                return (AndroidElement) driver.findElement(byType);
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

}
