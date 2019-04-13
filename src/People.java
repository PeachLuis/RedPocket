public class People implements Runnable {
    private redPocket rPocket;

    public People(redPocket rPocket) {
        this.rPocket=rPocket;
    }

    @Override
    public void run() {
        double money = rPocket.grapMoney();
        if (money == 0.0) {
            System.out.println(Thread.currentThread().getName()+"不好意思，您手慢了");
        } else {
            System.out.println(Thread.currentThread().getName()+",您抢到了"+money+"元");
        }
    }
}
