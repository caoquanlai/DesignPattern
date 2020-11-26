package creational.singleton;

/**
 * @author CaoQuanLai
 * @Time 2020/11/23 14:59
 * @description 双重检查单例模式
 * 延迟加载 | 多线程安全
 */
public class DoubleCheckSingleton {

    /**
     * volatile：禁止指令重排序，保持可见性
     */
    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {}

    public static DoubleCheckSingleton getInstance() {
        //首先判断是否为空
        if (instance == null) {
            //可能多个线程同时进入到这一步进行阻塞等待
            synchronized (DoubleCheckSingleton.class) {
                //第一个线程拿到锁，判断不为空进入下一步
                if (instance == null) {
                    /*
                     * 由于编译器的优化、JVM的优化、操作系统处理器的优化，可能会导致指令重排（happen-before规则下的指令重排，执行结果不变，指令顺序优化排列）
                     * new DoubleCheckSingleton()这条语句大致会有这三个步骤：
                     * 1.在堆中开辟对象所需空间，分配内存地址
                     * 2.根据类加载的初始化顺序进行初始化
                     * 3.将内存地址返回给栈中的引用变量
                     *
                     * 但是由于指令重排的出现，这三条指令执行顺序会被打乱，可能导致3的顺序和2调换
                     * 👇
                     */
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

    public void method1() {
        System.out.println(Thread.currentThread().getName());
    }
}

class DoubleCheckSingletonTest {
    public static void main(String[] args) {
        DoubleCheckSingleton singleton = DoubleCheckSingleton.getInstance();
        singleton.method1();
    }
}