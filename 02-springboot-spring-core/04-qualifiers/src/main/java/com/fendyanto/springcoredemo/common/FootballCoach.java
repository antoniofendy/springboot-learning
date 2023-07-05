package com.fendyanto.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice fast passing for 15 minutes";
    }
}
