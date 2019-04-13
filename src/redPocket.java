import java.util.Random;
import java.math.*;

public class redPocket {
    private int count;        //红包个数
    private int totalMoney;  //红包金额，单位为分，所以为整型

    /**
     * @param money 设置红包总额
     * @param count 设置红包个数
     */
    public redPocket(double money, int count) {      //读取用户输入的红包金额，用户输入的单位应该为元
        this.count = count;
        this.totalMoney = (int) (money * 100);  //这里将单位为元的钱转换为100倍的单位为分的钱
    }

    /**
     * @return 返回抢到的钱，单位为元
     * 采用synchronized关键字，因为多个用户同步抢红包，可能会造成线程拥塞
     */
    public synchronized double grapMoney() {
        int index = 0;  //储存对应次数得到的随机金额数

        //情况一：钱刚好够每个人分得0.01元
        if (totalMoney != 0 && totalMoney / count == 1) {
            index = 1;
            totalMoney = totalMoney - index;
            count--;
            return index / 100.0;
        }
        //情况二：
        //如果个数等于1
        if (count == 1) {
            index = totalMoney;
        //如果个数小于等于0
        } else if (count<=0) {
            index = 0;
        //如果正常情况，个数大于0
        } else {
            int temp; //剩下的金额
            while (true) {
                // 随机生成当前金额的随机数 [0,totalVal/count),尽量平均一点
                index = Math.abs((new Random().nextInt(totalMoney / count)));
                temp = totalMoney - index;
                // 判断生成的金额大于0，且剩余的钱数够剩下人平分到0.01元
                if (temp * 1.0 / (count - 1) >= 1 && index > 0) {
                    break;
                }
            }
            totalMoney = totalMoney - index;
        }
        count--;

        return index / 100.0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }
}
