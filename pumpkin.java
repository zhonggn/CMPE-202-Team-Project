import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pumpkin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pumpkin extends Item
{
    public pumpkin(){
        GreenfootImage image = getImage();
        image.scale(48, 48); 
    }
    
    public void act() 
    {
        Character ch = (Character)getOneIntersectingObject(Character.class);
        if(ch!=null){
            ch.setSpeed(3);
            getWorld().removeObject(this);
        }
    }    
}
