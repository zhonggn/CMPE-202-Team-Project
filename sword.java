import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class sword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class sword extends Item
{
    public sword(){
        GreenfootImage image = getImage();
        image.scale(48, 48); 
    }
    
    public void act() 
    {
        Character ch = (Character)getOneIntersectingObject(Character.class);
        if(ch!=null){
            ch.setHP(50);
            ch.setSpeed(1);
            ch.setFirerate(5);
            getWorld().removeObject(this);
        }
    }    
}
