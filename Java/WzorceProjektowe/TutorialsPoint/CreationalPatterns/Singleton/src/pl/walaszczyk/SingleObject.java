package pl.walaszczyk;

public class SingleObject {

    private static SingleObject instance;

    private SingleObject() {
    }

    public static SingleObject getInstance() {
        if (instance == null) {
            instance = new SingleObject();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello world! I am the Singleton creational design pattern.");
    }
}
