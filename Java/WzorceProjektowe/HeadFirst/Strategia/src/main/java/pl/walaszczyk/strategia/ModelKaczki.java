/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.walaszczyk.strategia;

import pl.walaszczyk.strategia.zachowanie.kwakanie.Kwacz;
import pl.walaszczyk.strategia.zachowanie.latanie.NieLatam;

/**
 *
 * @author Michał Walaszczyk
 */
public class ModelKaczki extends Kaczka {

    public ModelKaczki() {
        this.latanieInterfejs = new NieLatam();
        this.kwakanieInterfejs = new Kwacz();
    }

    @Override
    public void wyswietl() {
        System.out.println("Jestem modelem kaczki!");
    }
}
