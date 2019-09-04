package pl.walaszczyk.innerclass;

/**
 *
 * @author Michał Walaszczyk
 */
public class Outer {

    private int number;

    public Outer() {
        this.number = 13;
    }

    public class InnerClass {

        public InnerClass() {
            System.out.println("This is an inner class constructor.");
        }

        private void print() {
            System.out.println("This is an inner class private method.");
        }

        public int getNum() {
            System.out.println("This is the getnum method of the inner class");
            return number;
        }
    }

    public void displayInner() {
        InnerClass inner = new InnerClass();
        inner.print();
    }

    // Method-local Inner Class
    public void methodWithClass() {
        int number = 23;

        class InnerMethodClass {

            public InnerMethodClass() {
                System.out.println("This is method inner class constructor, number: " + number);
            }

            private void privateMethodOfInnerMethodClass() {
                System.out.println("This is private method of innerMethodClass.");
            }
        }

        InnerMethodClass innerMethodClass = new InnerMethodClass();
        innerMethodClass.privateMethodOfInnerMethodClass();
    }

    // Anonymous Inner Class
    public abstract class AnnonymousInner {

        public abstract void someMethod();
    }

    // Anonymous Inner Class as Argument
    public interface GreetInterface {

        String greet();
    }

    public class Greet {

        public void greet(GreetInterface greet) {
            System.out.println(greet.greet().concat(" - example of Anonymous Inner Class as Argument"));
        }
    }
    
    
    // Static Nested Class
    public static class NestedStatic {
        public static void staticGreet() {
            System.out.println("Static method of static nested class greets you!");
        }
        
        public void nonStaticGreet() {
            System.out.println("Nonstatic method of static nested class greets you!");
        }
    }
}
