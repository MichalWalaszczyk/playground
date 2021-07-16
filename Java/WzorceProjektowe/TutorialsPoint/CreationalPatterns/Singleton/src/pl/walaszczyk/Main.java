package pl.walaszczyk;

public class Main {

    public static void main(String[] args) {
        SingleObject singleton = SingleObject.getInstance();
        singleton.showMessage();
    }
}
