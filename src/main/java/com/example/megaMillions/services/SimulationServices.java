package com.example.megaMillions.services;

import java.util.ArrayList;

public class SimulationServices {
    public static ArrayList runSimulation(Double numOfDays, Double numOfTickets){

        ArrayList winCounter = new ArrayList();
        for (int i = 0; i <= 8; i++) {
            winCounter.add(0.0);
        }

        for (int i = 0; i < numOfDays; i++) {
            ArrayList winningBalls = DrawingServices.getWhiteBalls();
            int winningMega = DrawingServices.getMegaBall();

            for (int j = 0; j < numOfTickets; j++) {
                ArrayList ticketBalls = DrawingServices.getWhiteBalls();
                int ticketMega = DrawingServices.getMegaBall();

                int matches = WinningServices.checkWhiteBalls(winningBalls, ticketBalls);
                Boolean megaMatch = WinningServices.checkMegaBall(winningMega, ticketMega);
                switch (matches) {
                    case 0:
                        if (megaMatch) {
                             incrementCounterValue(0, winCounter);
                        }
                        break;
                    case 1:
                        if (megaMatch) {
                            incrementCounterValue(1, winCounter);
                            break;
                        }
                        break;
                    case 2:
                        if (megaMatch) {
                            incrementCounterValue(2, winCounter);
                            break;
                        }
                        break;
                    case 3:
                        if (megaMatch) {
                            incrementCounterValue(4, winCounter);
                        } else {
                            incrementCounterValue(3, winCounter);
                        }
                        break;
                    case 4:
                        if (megaMatch) {
                            incrementCounterValue(6, winCounter);
                        } else {
                            incrementCounterValue(5, winCounter);
                        }
                        break;
                    case 5:
                        if (megaMatch) {
                            incrementCounterValue(8, winCounter);
                        } else {
                            incrementCounterValue(7, winCounter);
                        }
                        break;
                    default:
                        throw new RuntimeException("This shouldn't happen");
                }
            }

        }
        return winCounter;
    }

    public static void incrementCounterValue(int position, ArrayList list){
        Double value = (Double) list.get(position);
        value++;
        list.set(position, value);
    }
}
