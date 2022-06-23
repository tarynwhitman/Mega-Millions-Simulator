package com.example.megaMillions.services;

import java.util.ArrayList;

public class DrawingServices {
    public static ArrayList getWhiteBalls(){
        ArrayList balls = new ArrayList<>();
            while(balls.size() < 5) {
                int randNum = (int) (Math.random() * (70 - 1) + 1);
                if (!balls.contains(randNum)) {
                    balls.add(randNum);
                }
            }
            return balls;
    }

    public static int getMegaBall(){
       return (int) (Math.random() * (25 - 1) + 1);
    }
}
