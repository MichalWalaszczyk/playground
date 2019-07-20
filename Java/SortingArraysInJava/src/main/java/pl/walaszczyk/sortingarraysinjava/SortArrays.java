/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.walaszczyk.sortingarraysinjava;

import java.util.Arrays;

/**
 *
 * @author micmark
 */
public class SortArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numbers = new int[]{-8, 7, 5, 9, 10, -2, 3};
        String[] strings = new String[]{"learning", "java", "with", "baeldung"};

        Employee john = new Employee(6, "John");
        Employee mary = new Employee(3, "Mary");
        Employee david = new Employee(4, "David");
        Employee[] employees = new Employee[]{john, mary, david};

        System.out.println("Przed sortowaniem");
        for (int number : numbers) {
            System.out.print(number + ", ");
        }
        System.out.print("\n\n");
        Arrays.sort(numbers);
        System.out.println("Po sortowaniu");
        for (int number : numbers) {
            System.out.print(number + ", ");
        }
        
        assertArrayEquals(new int[] { -8, -2, 3, 5, 7, 9, 10 }, numbers);
    }

    private static void assertArrayEquals(int[] i, int[] numbers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
