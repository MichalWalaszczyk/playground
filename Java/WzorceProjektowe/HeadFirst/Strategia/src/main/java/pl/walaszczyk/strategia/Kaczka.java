/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.walaszczyk.strategia;

import pl.walaszczyk.strategia.zachowanie.kwakanie.KwakanieInterfejs;
import pl.walaszczyk.strategia.zachowanie.latanie.LatanieInterfejs;

/**
 *
 * @author Michał Walaszczyk
 */
public abstract class Kaczka {
    
    protected LatanieInterfejs latanieInterfejs;
    protected KwakanieInterfejs kwakanieInterfejs;
    
    public abstract void wyswietl();
    
    public void wykonajLec() {
        this.latanieInterfejs.lec();
    }
    
    public void wykonajKwacz() {
        this.kwakanieInterfejs.kwacz();                
    }
    
    public void plywaj() {
        System.out.println("Wszystkie kaczki pływają, nawet te sztuczne!");
    }
    
    public void ustawLatanieInterfejs(LatanieInterfejs latanieInterfejs) {
        this.latanieInterfejs = latanieInterfejs;
    }
    
    public void ustawKwakanieInterfejs(KwakanieInterfejs kwakanieInterfejs) {
        this.kwakanieInterfejs = kwakanieInterfejs;
    }
}
