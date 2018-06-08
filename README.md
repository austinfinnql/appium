# Automated Regression tests for Qantas Money
* About the Project: 
    1) This Appium based automation project is an effort to automate the regressions tests used for Qantas Money app.
    2) The is currently being developed to be run locally and uses CucumberRunner for execution of the tests.
    
* stack:
    1) Prerequisite 
       ------------
       JDK 1.8
        
       Maven 3.3.9
       
       NPM 5.3.0
       
       Appium 1.7.2 (Java_client: 5.0.4)
       
       XCode 9 or higher (for IOS)
       
       Android Studio 2.* or latest
       
* Appium Setup IOS devices: 
    
  To get Appium to work with your devices we need to use the WebdriverAgent project. The project installs the Webdriver agent onto the device which enabled the JSONWire protocol to work with IOS devices. The same method can be followed for Simualtors as well. A couple of tutorials to help setupa nd understand the concept better can be found here:
  
  1) https://www.mutuallyhuman.com/blog/2017/04/20/webdriveragent-getting-started-with-automated-ios-testing
  2) https://github.com/facebook/WebDriverAgent/wiki/Starting-WebDriverAgent

* Highly level view of the structure:
    
````
+-- src
|   +-- test
|       +-- java
|           +-- config                  # the driver creation, declaring the DesiredCapabilities are done here                      
|               +-- locators            # the platform specific locators are placed in this folder.  
|           +-- pageobjects             # view/activity based hierarcy should be followed while declaring the pageObjects
|           +-- steps                   # step definitions should roughly follow the feature file. All steps regarding the scenario need not be in the sample file
|           +-- suite                   # declarition of the testrunner
|           +-- utils                   # Contains json parser and other non-test related files
|       +-- resource                    # the feature files are to be placed in this folder
````
   
Running your tests in local
---------------------------

To start appium server from terminal:

iOS:
appium --pre-launch --platform-name ios --platform-version xxx --udid xxxx --app ~/xxx.app --device-name xxx

Android:
appium --pre-launch --platform-name android --platform-version xxx--device-name xxx     --app ~/xxx.apk

Details of server arguments can be found at https://appium.io/slate/en/master/#appium-server-arguments.  

To executed the tests:
mvn clean install

BrowserStack:
Appium setup: https://www.browserstack.com/app-automate/appium-java
 
Current State:
1) The change passcode test have been completed for Android.
2) On IOS there are Accessibility id's missing for
    * In toolbar/navbar, the elements, "Home", "Pay a bill", and "More"
    * In "Activate your card": the field to enter “CVC” does not have an ID.
    XPath can be used in this case, but it did not provide the stability we 
    look for in automated testcase.