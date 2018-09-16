package com.esc.weatherapp.controller;

import com.esc.weatherapp.dto.StatisticDto;
import com.esc.weatherapp.exception.DatePeriodException;
import com.esc.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public ModelAndView getMainPage() {
        ModelAndView hello = new ModelAndView();
        hello.setViewName("hello");
        return hello;
    }

    @GetMapping("/statistic")
    public ModelAndView getStatisticPage(@RequestParam("city") String city,
                                         @RequestParam("from") String fromDate,
                                         @RequestParam("to") String toDate) {
        ModelAndView modelAndView = new ModelAndView();
        StatisticDto statistic = weatherService.getWeatherStatisticByCity(city, fromDate, toDate);
        statistic.setCity(city);
        modelAndView.addObject("statistic", statistic);
        modelAndView.setViewName("statistic");
        return modelAndView;
    }

    @ExceptionHandler({DatePeriodException.class})
    public ModelAndView datePeriodExceptionHandler(Exception e) {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAA");
        ModelAndView modelAndView = new ModelAndView("errorPage");
        modelAndView.addObject("exceptionInfo", e);
        return modelAndView;
    }
}
