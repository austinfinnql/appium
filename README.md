# Automated Regression tests for Qantas Money
* About the Project: This is an Appium based autoamtion proejct to test theQantas Money app
This
* Appium Setup IOS devices: To get Appium to work with your devices we need to use the WebdriverAgent project. The project installs the Webdriver agent onto the device which enabled the JSONWire protocol to work with IOS devices. The same method can be followed for Simualtors as well. A couple of tutorials to help setupa nd understand the concept better can be found here:
  
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
   
  