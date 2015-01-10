import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class LifePanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LifePanel extends Actor
{
    Character ch;
    
    public LifePanel(Character ch){
        this.ch = ch;
    }
    
    public void act() 
    {
        setImage(new GreenfootImage("Life: "+ ch.getHP(), 24, Color.GREEN, Color.BLACK));
    }    
}
