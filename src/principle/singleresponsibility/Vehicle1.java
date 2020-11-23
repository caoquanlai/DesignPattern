package principle.singleresponsibility;

/**
 * @author CaoQuanLai
 * @Time 2020/11/20 16:04
 */
public class Vehicle1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("小汽车");
        vehicle.run("飞机");
    }
}

class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上跑...");
    }
}
