package creational.singleton;

/**
 * @author CaoQuanLai
 * @version V1.0
 * @date 2020/11/26 11:11
 * @description 枚举实现单例
 * 不能懒加载 | 多线程安全
 */
public enum EnumForSingleton {
    /**
     * 枚举单例
     */
    INSTANCE;

    public void method1() {
        System.out.println(Thread.currentThread().getName());
    }
}

class EnumForSingletonTest {
    public static void main(String[] args) {
        EnumForSingleton singleton = EnumForSingleton.INSTANCE;
        singleton.method1();
    }
}