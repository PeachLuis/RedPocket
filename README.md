

# RedPocket

题目：抢红包程序（java）：要求发出100元红包，20人分16个红包，红包中的金额不等额。

注：随机函数、线程同步

------

要实现该程序需要解决的问题大致如下：

1. 学会使用随机函数，包括Random和Math类中的random方法
2. 学会多线程的使用，注意多个线程同时使用同一个方法的时候，可能会造成线程堵塞，学会使用synchronized关键字
3. 将原本单位为元的2位小数的double型钱转换为*100倍的以分为单位的分
4. 有4个人分不到红包
5. 每个红包尽量做到等额
6. 红包分发的特殊情况

程序运行效果如下：

![redPocket](https://github.com/PeachLuis/RedPocket/blob/master/image/redPocket.gif)
