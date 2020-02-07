package com.example.earlychildhooddevelopmentapp.Model;

public class SwitchPage {

    public int SwitchPage(int year, int months){

        if (year > 5){
            return 9;
        }
        else if (year > 4) {
            return 8;
        }
        else if(year > 3) {
            return 7;
        }
        else if(year > 2) {
            return 6;
        }
        else if(year > 1 || (year == 1 && months > 6)) {
            return 5;
        }
        else if(year == 1 && months >= 0) {
            return 4;
        }
        else if(year == 0 && months > 9) {
            return 3;
        }
        else if(year == 0 && months > 6) {
            return 2;
        }
        else if(year == 0 && months > 3) {
            return 1;
        }
        else {
            return 0;
        }


    }
}
