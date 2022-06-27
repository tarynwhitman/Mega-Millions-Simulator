package com.example.megaMillions.services;

import java.util.ArrayList;

public class WinningServices {
    public static int checkWhiteBalls(ArrayList winBalls, ArrayList playBalls) {
        int counter = 0;
        for (int i = 0; i < winBalls.size(); i++) {
                if (playBalls.contains(winBalls.get(i)) ) {
                    counter++;
                }

        }
        return counter;
    }

    public static Boolean checkMegaBall(int winMega, int playMega){
        return winMega == playMega;
    }
}
