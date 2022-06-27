package com.example.megaMillions.services;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class StatisticsServices {
    public static ArrayList getWinChances(ArrayList winList, Double numOfDays, Double numOfTickets){
        ArrayList winPercentages = new ArrayList();
        Double totalCount = numOfTickets * numOfDays;
        Double totalWinCount = 0.0;

        for (int i = 0; i < winList.size(); i++) {
            Double value = (Double) winList.get(i);
            totalWinCount = totalWinCount + value;
        }

        for (int i = 0; i < winList.size(); i++) {
            Double value = (Double)winList.get(i);
            Double percen = value / totalCount;
            winPercentages.add(i,percen);
        }

        Double overallPercen = (totalWinCount / totalCount);
        winPercentages.add(9,overallPercen);

        return winPercentages;
    }

    public static ArrayList getWinMoney(ArrayList winList){
        ArrayList winMoney = new ArrayList<>();
        Double totalWinMoney = 0.0;

        for (int i = 0; i < winList.size(); i++) {
            Double value = (Double)winList.get(i);
            switch(i){
                case 0:
                    winMoney.add(value * 2.00);
                    break;
                case 1:
                    winMoney.add(value * 4.00);
                    break;
                case 2:
                    winMoney.add(value * 10.00);
                    break;
                case 3:
                    winMoney.add(value * 10.00);
                    break;
                case 4:
                    winMoney.add(value * 200.00);
                    break;
                case 5:
                    winMoney.add(value * 500.00);
                    break;
                case 6:
                    winMoney.add(value * 10000.00);
                    break;
                case 7:
                    winMoney.add(value * 1000000.00);
                    break;
                case 8:
                    winMoney.add(value * 104075525.00);
                    break;
            }

        }
        for (int i = 0; i < winList.size(); i++) {
            Double value = (Double) winMoney.get(i);
            totalWinMoney = totalWinMoney + value;
        }

        winMoney.add(9, totalWinMoney);
        return winMoney;
    }

    public static ArrayList getStringChance(ArrayList winList, Double numOfDays, Double numOfTickets){
        ArrayList winPercentages = getWinChances(winList, numOfDays, numOfTickets);
        for (int i = 0; i < winPercentages.size(); i++) {
            Double value = (Double)winPercentages.get(i);
            String chance = String.format("%.2f", value * 100.0)  + " %";
            winPercentages.set(i,chance);
        }
        return winPercentages;
    }
    public static ArrayList getStringMoney(ArrayList winList){
        ArrayList winAmount = getWinMoney(winList);
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);

        for (int i = 0; i < winAmount.size(); i++) {
            Double value = (Double)winAmount.get(i);
            String amount = n.format(value);
            winAmount.set(i,amount);
        }
        return winAmount;
    }

}
