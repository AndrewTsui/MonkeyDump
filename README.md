# MonkeyDump
## 项目简介
自Google推出Android以来，由于其开源、生态丰富等特点，被各大厂商定制成不同的版本，现已成为移动设备上用户最多、占有率最高的操作系统。而由于各大厂商们的终端设备在硬件上甚至Andorid定制版本上都有较大差异，因此带来了碎片化问题，使得软件的测试过程机械化、效率低，开发者往往要花费大量的时间用于软件测试。综上，自动化测试工具成为了研究热点。   

Monkey是一款自动化黑盒压力测试工具，对测试应用发送随机的用户事件，模拟用户与应用之间的交互行为。Monkey采用了adb shell运行方式，需要在Terminal下才能进行操作，每次测试需要重复编写adb shell monkey命令，过程较于繁琐。Monkey测试日志中不包含每次测试产生的应用状态变化，也无法获得应用状态之间的转化关系。而由于其随机性的特点，更是无法获得代码覆盖率，无法量化测试效率。   

本项目解决了Monkey测试工具存在的上述问题。
*****
### 已解决如下问题：
- 保存Monkey测试过程中的应用状态
- 在Java中调用Monkey测试
- 记录每一次Monkey测试的日志
- 保存Monkey测试过程中每一次操作的Activity
*****
### 待解决问题：
- 计算Monkey测试的代码覆盖率
- 生成应用状态转化图


