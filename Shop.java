import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Shop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shop extends World
{
    private ArrayList<Item> itemlist = new ArrayList<Item>();
    private int lvl;
    private Character ch;
    Item item1, item2;
    
    
    public Shop()
    {    
        super(800, 600, 1); 
    }
    
    public Shop(int lvl, Character ch){
        super(800,600,1);
        this.lvl = lvl;
        this.ch = ch;
        addObject(ch, 400, 300);
        setItems();
        int i1 = Greenfoot.getRandomNumber(7);
        int i2 = Greenfoot.getRandomNumber(7);
        while(i2==i1){
            i2 = Greenfoot.getRandomNumber(7);
        }
        item1 = itemlist.get(i1);
        item2 = itemlist.get(i2);
        addObject(item1, 275, 300);
        addObject(item2, 475, 300);
    }
    
    public void setItems(){
        itemlist.add(new cherry());
        itemlist.add(new ring());
        itemlist.add(new pumpkin());
        itemlist.add(new crystal());
        itemlist.add(new fireball());
        itemlist.add(new laser());
        itemlist.add(new sword());
    }
    
    public void act(){
        if(ch.getX()>250&&ch.getX()<300&&ch.getY()>270&&ch.getY()<330){
            removeObject(item2);
            addObject(new Door(lvl+1,lvl), 400, 300);
        }
        if(ch.getX()>450&&ch.getX()<500&&ch.getY()>270&&ch.getY()<330){
            removeObject(item1);
            addObject(new Door(lvl+1,lvl), 400, 300);
        }
        
    }
}
