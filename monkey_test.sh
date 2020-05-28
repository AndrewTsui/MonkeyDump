#!/bin/bash

export ANDROID_HOME=/Users/tsui/Library/Android/sdk
export PATH=$PATH:$ANDROID_HOME/tools
export PATH=$PATH:$ANDROID_HOME/platform-tools
export PATH=${PATH}:/usr/local/Cellar/python/3.7.7/bin

#adb devices
#adb shell monkey --throttle 1000 -p com.ichi2.anki -v -v -v 3 >> /Users/tsui/eclipse-workspace/MonkeyDump/MonkeyLog/log.txt
adb shell monkey --throttle $1 -p $2 -v -v -v $3 >> $4
