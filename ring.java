import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ring here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ring extends Item
{
    public ring(){
        GreenfootImage image = getImage();
        image.scale(48, 48); 
    }
    
    public void act() 
    {
        Character ch = (Character)getOneIntersectingObject(Character.class);
        if(ch!=null){
            ch.setFirerate(10);
            getWorld().removeObject(this);
        }
    }    
}
