import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("----抢红包测试----");
        System.out.println("----多线程----");

        //读取金额和红包个数
        Scanner in = new Scanner(System.in);
        System.out.print("请输入金额：");
        double money = in.nextDouble();
        System.out.print("请输入红包个数：");
        int count = in.nextInt();
        System.out.println();
        //打印详情
        System.out.println("红包详情：");

        redPocket rp = new redPocket(money, count);
        People p = new People(rp);
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(p);
            thread.start();
        }
    }
}
