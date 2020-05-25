from uiautomator import device as d
import time
# dump the widown hierarchy and save to local file "hierarchy.xml"
d.dump('/Users/tsui/eclipse-workspace/MonkeyDump/AndroidXML/'+str(time.time())+'.xml')
# or get the dumped content(unicode) from return.
#xml = d.dump()