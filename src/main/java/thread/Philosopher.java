package thread;

/**
 * 模拟哲学家就餐问题
 */
public class Philosopher {

    public static Chopstick[] chopsticks;

    public static void main(String[] args) {
        chopsticks = new Chopstick[5];
        for (int i = 0; i < 5; i++) {
            chopsticks[i] = new Chopstick();
        }
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new PhilosopherThread(i));
            thread.setName("Thread" + i);
            thread.start();
        }
    }

    public static class Chopstick {

    }

    public static class PhilosopherThread implements Runnable {
        public int idx;

        public PhilosopherThread(int i) {
            this.idx = i;
        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                synchronized (chopsticks[idx]) {
                    synchronized (chopsticks[(idx + 1) % chopsticks.length]) {
//                        chopsticks[idx].notify();
//                        chopsticks[(idx + 1) % chopsticks.length].notify();
                        System.out.println("哲学家" + idx + "正在用餐");
//                        try {
//                            //错误用法：进入wait方法后线程进入WAITTING状态无法继续释放对象
//                            chopsticks[idx].wait(100);
//                            chopsticks[(idx + 1) % chopsticks.length].wait(100);
//                            System.out.println("哲学家" + idx + "正在思考");
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    }
                }
                try {
                    Thread.sleep(1000);

                    System.out.println("哲学家" + idx + "正在思考");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
