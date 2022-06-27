package com.example.megaMillions.web.controller;

import com.example.megaMillions.form.SimulationForm;
import com.example.megaMillions.services.DrawingServices;
import com.example.megaMillions.services.SimulationServices;
import com.example.megaMillions.services.StatisticsServices;
import com.example.megaMillions.services.WinningServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

@RestController
public class SimulationController {


    @PostMapping("/runSimulation")
    public ModelAndView runSimulation(SimulationForm form){

        ModelAndView mav = new ModelAndView("simulation");
        long startTime = System.currentTimeMillis();
        ArrayList winCounter = SimulationServices.runSimulation(form.getNumOfDays(),  form.getNumOfTickets());
        mav.addObject("winCounter", winCounter);

        ArrayList winPercentages = StatisticsServices.getStringChance(winCounter, form.getNumOfDays(),  form.getNumOfTickets());
        for (int i = 0; i < winPercentages.size(); i++) {
            mav.addObject("winPercenPos" + i, winPercentages.get(i));
        }
        mav.addObject("winPercentages", winPercentages);

        ArrayList winAmount = StatisticsServices.getStringMoney(winCounter);
        for (int i = 0; i < winAmount.size(); i++) {
            mav.addObject("winAmountPos" + i, winAmount.get(i));
        }
        mav.addObject("winAmount", winAmount);
        long endTime = System.currentTimeMillis();
        System.out.println("Total Time: " +((endTime - startTime) / 1000) + " Seconds");

        Double spent = form.getNumOfDays() *  form.getNumOfTickets() * 2.00;
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
        String amount = n.format(spent);
        mav.addObject("spentAmount", amount);


        return mav;
    }
}
