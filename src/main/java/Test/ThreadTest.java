package Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @描述：
 * @创建者： Louzhoucheng
 * @日期： 2017-04-21 15:15
 * @修改者： Louzhoucheng
 * @修改日期： 2017-04-21 15:15
 * @版本： v1.0
 */
public class ThreadTest {
    static volatile int count = 0;

    public static void main(String[] args) throws Exception {
        int[] a = {1, 2};
        try {
            System.out.println(a[3]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("end");
//        System.out.println("Thread.activeCount()=" + Thread.activeCount());
//        for (int i = 0; i < 10; i++) {
//            new Thread(ThreadTest::doSomeThing).start();
//        }
//        while (Thread.activeCount() > 2)  //保证前面的线程都执行完
//        {
//            //System.out.println("Thread.activeCount()=" + Thread.activeCount());
//            Thread.yield();
//        }
//        System.out.println(count);

    }

    private synchronized static void doSomeThing() {
        for (int i = 0; i < 1000; i++)
            count++;
        System.out.println(count);
    }

}