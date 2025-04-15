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

env
0960108580290


export ANDROID_HOME=/Users/xmaximbesliu/Library/Android/sdk
export ANDROID_SDK_ROOT=$HOME/Library/Android/sdk
export ANDROID_AVD_HOME=/Users/maximbesliu/.android/avd
export PATH=$ANDROID_HOME/platform-tools:$PATH
export PATH=$ANDROID_HOME/tools:$PATH
export PATH=$ANDROID_SDK_ROOT:$ANDROID_HOME/tools:$PATH
export PATH=$ANDROID_HOME/tools/bin:$PATH


How to run android and iOS emulator:
 https://vanessafsoares.medium.com/start-emulator-and-simulator-from-macos-terminal-aa345495170d

https://github.com/google/android-emulator-m1-preview/issues/34
Cant run emulator ARM64 · Issue #34 · google/android-emulator-m1-preview · GitHub

iOS commands

Check device list:
xcrun simctl list

Start simulator and device:
open -a Simulator && xcrun simctl boot ‘device name’  (example:iPhone 14)

Check if device was booted:  
xcrun simctl list devices | grep "iPhone 14"

Kill simulators:
killall "Simulator" || true

Android commands:

Adb command to see logs by log level and log tag and text
 adb logcat -s "okhttp.OkHttpClient" -v time | grep -E "I/okhttp.OkHttpClient.*OperationId:"

/Users/maximbesliu/Library/Android/sdk/emulator

emulator -list-avds (List of all emulators)
emulator -avd <device name> or emulatore @<device name>

Command to see activity

adb shell dumpsys window windows

Kill emulator:
adb emu kill

Run command  to be able to run below commands without restrictions:
adb root

Command to switch activity from command line 
adb shell am start -n <package name> / <activity name>

Command to uninstall UIatomator20 when. Appium server cannot start
adb uninstall io.appium.uiautomator2.server.test 

