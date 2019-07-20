/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.walaszczyk.sortingarraysinjava;

/**
 *
 * @author micmark
 */
public class Employee {
    
    private Integer id;
    private String nazwa;

    public Employee(Integer id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

    public Employee(String nazwa) {
        this.nazwa = nazwa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
