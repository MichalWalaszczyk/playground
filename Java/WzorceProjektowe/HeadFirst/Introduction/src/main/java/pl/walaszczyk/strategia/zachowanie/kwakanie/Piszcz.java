/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.walaszczyk.strategia.zachowanie.kwakanie;

import pl.walaszczyk.strategia.zachowanie.kwakanie.KwakanieInterfejs;

/**
 *
 * @author Michał Walaszczyk
 */
public class Piszcz implements KwakanieInterfejs {

    @Override
    public void kwacz() {
        System.out.println("Piszczę!");
    }
    
}
