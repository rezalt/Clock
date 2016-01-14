/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    int customSeconds;
    int minutes = seconds/60;
    int customMinutes;
    int timeZone = 1;
    int hours = minutes/60+timeZone;
    int customHours;
    int years = 1970;
    int customYears;
    int daysSinceNewYear=0;
    boolean leapYear;
    int month =0;
    String monthString;
    /**
     * @param args the command line arguments
     */
    
    public Clock()
    {
        setDate();
        isLeapYear();
        calcMonth();
        calcMonthName();
      //  printTime();
    }
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
    public void calcMonth()
    {
        month=1;
        int[] months = new int[11];
        months[0] =31;
        months[1] = 28;
        if(leapYear)
        {
            months[1] = 29;
        }
        months[2] = 31;
        months[3] = 30;
        months[4] = 31;
        months[5] = 30;
        months[6] = 31;
        months[7] = 31;
        months[8] = 30;
        months[9] = 31;
        months[10] = 30; 
        //int dec = 31
        for (int i = 0;  daysSinceNewYear > months[i]; i++)
        {
            daysSinceNewYear -= months[i];
            month++;
        }
       
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

    
 
    public void updateClock()
    {
     
       
       seconds = (int)(long) (System.currentTimeMillis()/1000) + customSeconds;
       minutes = seconds/60 + customMinutes;
       hours = minutes/60+timeZone + customHours;
       years = 1970 + customYears;
       daysSinceNewYear=0;
       month = 0;
       setDate();
       isLeapYear();
       calcMonth();
       calcMonthName();
       

    }
    
    public int getSecond()
    {
        return seconds;
    }
    
    public int getMinute()
    {  
        return minutes;
    }
    
    public int getHour()
    {
        return hours;
    }
    
    public int getDays()
    {
       return daysSinceNewYear;       
    }
    
    public String getMonth()
    {
        return monthString;
    }
    
    public int getYear()
    {
        return years;
    }
    
 
}
