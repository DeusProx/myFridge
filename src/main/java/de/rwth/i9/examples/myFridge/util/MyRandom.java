package de.rwth.i9.examples.myFridge.util;

import java.util.Random;

/**
 * Created by deusprox on 06.09.16.
 */
public class MyRandom extends Random{
    public MyRandom() {}
    public MyRandom(int seed) { super(seed); }

    public int nextNonNegative() {
        return next(Integer.SIZE - 1);
    }
}
