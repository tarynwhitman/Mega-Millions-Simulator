package com.example.megaMillions.web.controller;

import com.example.megaMillions.services.DrawingServices;
import com.example.megaMillions.services.WinningServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController
public class SimulationController {

    @GetMapping("/simulation")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("simulation");
        ArrayList winBalls = DrawingServices.getWhiteBalls();
        ArrayList playBalls = DrawingServices.getWhiteBalls();
        mav.addObject("winBalls", winBalls);
        mav.addObject("playBalls", playBalls);
        int winningMatchAmount = WinningServices.checkWhiteBalls(winBalls, playBalls);
        mav.addObject("winMatches",winningMatchAmount);

        int playMega = DrawingServices.getMegaBall();
        int winMega = DrawingServices.getMegaBall();
        mav.addObject("winMega", winMega);
        mav.addObject("playMega", playMega);
        Boolean winMegaCheck = WinningServices.checkMegaBall(winMega, playMega);
        mav.addObject("winMegaMatch", winMegaCheck);



        mav.addObject("sim", "This is the simulation");
        return mav;
    }
}
