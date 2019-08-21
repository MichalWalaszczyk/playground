/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.walaszczyk.strategia;

import pl.walaszczyk.strategia.zachowanie.latanie.LotZNapedemRakietowym;

/**
 *
 * @author Michał Walaszczyk
 */
public class MiniSymulatorKaczki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Kaczka dzika = new DzikaKaczka();
        dzika.wykonajKwacz();
        dzika.wykonajLec();
        
        Kaczka model = new ModelKaczki();
        model.wykonajLec();
        model.ustawLatanieInterfejs(new LotZNapedemRakietowym());
        model.wykonajLec();
    }
    
}
