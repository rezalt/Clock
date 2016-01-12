/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

/**
 *
 * @author Jakob & Henrik
 */
public class Clock
{
    


    int days=0;
    int seconds = (int)(long) (System.currentTimeMillis()/1000);
    int minutes = seconds/60;
    int timeZone = 1;
    int hours = minutes/60+timeZone;
    int years = 1970;
    int daysSinceNewYear=0;
    boolean leapYear;
    int month =0;
    String monthString;
    /**
     * @param args the command line arguments
     */
    public void setDate()
    {
        days=hours/24+1;
        for (int day=0; day< days;)
        {
            day+=365;
            if(years%100==0 && years%400==0 && years%4==0 || years%100!=0 && years%4==0)
            {
                day++;
            }

            if (day<days)
            {
                daysSinceNewYear=days-day;
                years++;
            }


        }
    }
    public void isLeapYear()
    {
        if(years%100==0 && years%400==0 && years%4==0 || years%100!=0 && years%4==0)
           {
               leapYear = true;
           }
        leapYear = false;
    }
    public int calcMonth()
    {
        month=1;
        int jan =31;
        int feb = 28;
        int march =31;
        int april = 30;
        int may = 31;
        int juni = 30;
        int july = 31;
        int august =31;
        int sep = 30;
        int oct = 31;
        int nov = 30; 
        //int dec = 31;
        if(leapYear)
        {
            feb = 29;
        }
        if(daysSinceNewYear > jan)
        {
            daysSinceNewYear-=jan;
            month++;
        }
        else
        {
            return month;
        }
        if(daysSinceNewYear > feb)
        {
            daysSinceNewYear-=feb;
            month++;
        }
        else
        {
            return month;
        } 
        if(daysSinceNewYear > march)
        {
            daysSinceNewYear-=march;
            month++;
        }
        else
        {
            return month;
        } 
        if(daysSinceNewYear > april)
        {
            daysSinceNewYear-=april;
            month++;
        }
        else
        {
            return month;
        } 
        if(daysSinceNewYear > may)
        {
            daysSinceNewYear-=may;
            month++;
        }
        else
        {
            return month;
        } 
        if(daysSinceNewYear > juni)
        {
            daysSinceNewYear-=juni;
            month++;
        }
        else
        {
            return month;
        } 
        if(daysSinceNewYear > july)
        {
            daysSinceNewYear-=july;
            month++;
        }
        else
        {
            return month;
        } 
        if(daysSinceNewYear > august)
        {
            daysSinceNewYear-=august;
            month++;
        }
        else
        {
            return month;
        } 
        if(daysSinceNewYear > sep)
        {
            daysSinceNewYear-=sep;
            month++;
        }
        else
        {
            return month;
        }
        if(daysSinceNewYear > oct)
        {
            daysSinceNewYear-=oct;
            month++;
        }
        else
        {
            return month;
        }
        if(daysSinceNewYear > nov)
        {
            daysSinceNewYear-=jan;
            month++;
        }
        else
        {
            return month;
        } 
        return month;
    }
    
    public void calcMonthName()
    {
     switch (month) {
            case 1:  monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }          
        
    }
    
    
    
    public void printTime()
    {
         System.out.println("år: "+years+" month: "+monthString+" dage: "+daysSinceNewYear+" timer: "+hours%24+" minutter: "+minutes%60+" seconds: "+seconds%60);
    }
    public static void main(String[] args)
    {
        Clock clock = new Clock();
        clock.setDate();
        clock.isLeapYear();
        clock.calcMonth();
        clock.calcMonthName();
        clock.printTime();
    }
}
