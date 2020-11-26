package creational.singleton;

/**
 * @author CaoQuanLai
 * @version V1.0
 * @date 2020/11/26 13:00
 * @description 静态代码块饿汉式单例模式
 * 不能延迟加载 | 多线程安全
 */
public class Singleton02 {

    private static final Singleton02 INSTANCE;

    static {
        INSTANCE = new Singleton02();
    }

    private Singleton02 () {}

    public static Singleton02 getInstance() {
        return INSTANCE;
    }

    public void method1() {
        System.out.println(Thread.currentThread().getName());
    }
}

class Singleton02Test {
    public static void main(String[] args) {
        Singleton02 instance = Singleton02.getInstance();
        instance.method1();
    }
}