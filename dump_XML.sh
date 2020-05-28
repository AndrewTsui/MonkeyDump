#!/bin/bash

export ANDROID_HOME=/Users/tsui/Library/Android/sdk
export PATH=$PATH:$ANDROID_HOME/tools
export PATH=$PATH:$ANDROID_HOME/platform-tools
export PATH=${PATH}:/usr/local/Cellar/python/3.7.7/bin

#python3 /Users/tsui/eclipse-workspace/MonkeyDump/dump_verbose.py
adb shell dumpsys window windows | grep -E "mFocusedApp"
python3 $1