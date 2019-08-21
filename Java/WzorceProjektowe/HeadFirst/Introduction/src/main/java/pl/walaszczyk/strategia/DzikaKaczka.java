/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.walaszczyk.strategia;

import pl.walaszczyk.strategia.zachowanie.kwakanie.Kwacz;
import pl.walaszczyk.strategia.zachowanie.latanie.LatamBoMamSkrzydla;

/**
 *
 * @author Michał Walaszczyk
 */
public class DzikaKaczka extends Kaczka {

    public DzikaKaczka() {
        this.kwakanieInterfejs = new Kwacz();
        this.latanieInterfejs = new LatamBoMamSkrzydla();
    }

    @Override
    public void wyswietl() {
        System.out.println("Jestem prawdziwą Dziką Kaczką");
    }

}
