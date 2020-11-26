package creational.singleton;

/**
 * @author CaoQuanLai
 * @version V1.0
 * @date 2020/11/26 13:15
 * @description 静态内部类单例模式
 * 延迟加载 | 多线程安全
 * 利用了 classloader 机制来保证初始化 instance 时只有一个线程
 * 内部类和静态内部类都是等到用的时候才进行加载，所以可以实现懒加载
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {}

    private static class SingletonHolder {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void method1() {
        System.out.println(Thread.currentThread().getName());
    }
}

class StaticInnerClassSingletonTest {
    public static void main(String[] args) {
        StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();
        instance.method1();
    }
}