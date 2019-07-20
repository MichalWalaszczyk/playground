/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.walaszczyk.junit.samouczekprogramisty;

/**
 *
 * @author Michał Walaszczyk
 */
public class Range {

    private final long lowerBound;
    private final long upperBound;

    public Range(long lowerBound, long upperBound) {
        if (lowerBound > upperBound) {
            throw new IllegalArgumentException("Lower bound is bigger than upperbound.");
        }
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public boolean isRange(long number) {
        return number >= this.lowerBound && this.upperBound >= number;
    }
}
