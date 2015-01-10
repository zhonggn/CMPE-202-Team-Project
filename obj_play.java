import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
/**
 * Write a description of class obj_play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class obj_play extends menu
{
    /**
     * Act - do whatever the obj_play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage text = new GreenfootImage(150, 80);

  public obj_play() {
    Font f = new Font("Arial", 1, 30);
    this.text.setFont(f);
    this.text.setColor(Color.white);
    this.text.drawString("Play", 50, 50);
    setImage(this.text);
  }  
  
  
}
