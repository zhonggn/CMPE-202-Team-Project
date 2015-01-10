import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class laser extends Item
{
    public laser(){
        GreenfootImage image = getImage();
        image.scale(48, 48); 
    }
    
    public void act() 
    {
        Character ch = (Character)getOneIntersectingObject(Character.class);
        if(ch!=null){
            ch.setMode(3);
            getWorld().removeObject(this);
        }
    }    
}
