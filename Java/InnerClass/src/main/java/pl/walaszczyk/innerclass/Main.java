package pl.walaszczyk.innerclass;

import pl.walaszczyk.innerclass.Outer.Greet;

/**
 *
 * @author Michał Walaszczyk
 */
public class Main {

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.displayInner();

        System.out.println();
        Outer.InnerClass inner = outer.new InnerClass();
        System.out.println(inner.getNum());

        System.out.println();
        outer.methodWithClass();

        System.out.println();
        // Call of Anonymous Inner Class
        Outer.AnnonymousInner annonymous = outer.new AnnonymousInner() {
            public void someMethod() {
                System.out.println("Method invoked inside Anonymous Inner Class.");
            }
        };
        annonymous.someMethod();

        System.out.println();
        // Call of Anonymous Inner Class as Argument
        Greet greet = outer.new Greet();
        greet.greet(new Outer.GreetInterface() {
            @Override
            public String greet() {
                return "I greet you!";
            }
        });
        
        System.out.println();
        // Invoking static method of static nested class
        Outer.NestedStatic.staticGreet();
        // Invoking static method of static nested class
        Outer.NestedStatic nested = new Outer.NestedStatic();        
        nested.nonStaticGreet();
    }
}
