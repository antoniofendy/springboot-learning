package com.fendyanto.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BasketCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice fast dribbling for 15 minutes";
    }

}
