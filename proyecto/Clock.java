import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Calendar;
import java.awt.Font;
import java.awt.Color;

/**
 * A clock. Displays the time.
 * 
 * @author Michael Berry (mjrb4)
 * @version 06/12/08
 */
public class Clock extends Actor
{

    /** The hours to display on the clock */
    private String hours;
    /** The minutes to display on the clock */
    private String minutes;
    /** The seconds to display on the clock */
    private String seconds;

    /**
     * When the clock is added to the world, just update it
     * (same as we do in the act method.)
     */
    public void addedToWorld(World world)
    {
        act();
    }

    /**
     * Execute repeatedly.
     */
    public void act() 
    {
        updateTime();
        draw();
    }
    
    /**
     * Update the hours, minutes and seconds fields.
     */
    private void updateTime()
    {
        Calendar calendar = Calendar.getInstance();
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        this.hours = getStr(hours);
        int minutes = calendar.get(Calendar.MINUTE);
        this.minutes = getStr(minutes);
        int seconds = calendar.get(Calendar.SECOND);
        this.seconds = getStr(seconds);
    }
    
    /**
     * Put a 0 before the number if it's less than 10.
     */
    private String getStr(int val)
    {
        String str = null;
        if(val<10) {
            str = "0"+val;
        }
        else {
            str = ""+val;
        }
        return str;
    }
    
    /**
     * Put a reasonable font on the image and draw it to the world.
     */
    private void draw()
    {
 
        
        GreenfootImage image = new GreenfootImage(200,200);
        Font font = image.getFont();
        font = font.deriveFont(new Float(24.0F));
        image.setFont(font.deriveFont(24.0F));
        image.setColor(Color.YELLOW);
        image.drawString(hours + " : " + minutes + " : " + seconds, 25, 100);
        setImage(image);
    }

}
