System variables that has to be added
ANDROID_HOME C:\Users\Maxim\AppData\Local\Android\Sdk
NODE_HOME  C:\Program Files\nodejs

path:
C:\Users\Maxim\AppData\Local\Android\Sdk\tools
C:\Users\Maxim\AppData\Local\Android\Sdk\tools\bin
C:\Program Files\nodejs\node_modules\npm\bin
C:\Users\Maxim\AppData\Local\Android\Sdk\platform-tools

Appium command to see all available driver: appium driver list
Appium command to install driver: appium driver install <driverName>

Appium Inspector
app  path to apk
deviceName emulatorname
platformName  android
automationName UiAutomator2


https://www.linkedin.com/pulse/solving-jdk-17-compatibility-issue-appium-step-by-step-nir-tal/


How to run android and iOS emulator:

https://vanessafsoares.medium.com/start-emulator-and-simulator-from-macos-terminal-aa345495170d

 

/Users/maximbesliu/Library/Android/sdk/emulator

emulator -list-avds (List of all emulators)

emulator -avd {$emulatorName}

emulator -avd MaximPhone -wipe-data

adb emu kill


!!! Before starting add start emulator

Run «ads root» command  to be able to run below commands without restrictions

Command to switch activity from command line

adb shell am start -n <package name> / <activity name>

Command to see activity

adb shell dumpsys window windows
