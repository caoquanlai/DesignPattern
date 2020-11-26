package creational.singleton;

/**
 * @author CaoQuanLai
 * @version V1.0
 * @date 2020/11/26 11:41
 * @description 静态常量饿汉式单例模式
 * 不能延迟加载 | 线程安全
 */
public class Singleton01 {

    private final static Singleton01 INSTANCE = new Singleton01();

    private Singleton01 () {}

    public static Singleton01 getInstance() {
        return INSTANCE;
    }

    public void method1() {
        System.out.println(Thread.currentThread().getName());
    }
}

class Singleton01Test {
    public static void main(String[] args) {
        Singleton01 instance = Singleton01.getInstance();
        instance.method1();
    }
}