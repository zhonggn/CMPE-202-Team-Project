import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mage extends enemy
{
    private int d;
    private GreenfootImage face;
    private GreenfootImage back;
    private GreenfootImage left;
    private GreenfootImage right;
    private World world;
    private int hp=50;
    private int cd=80;
    private int cd_num=0;
    
    public mage(World w) {
        this.world = w;    
        GreenfootImage image = getImage();
        image.scale(31, 47);      
        face = new GreenfootImage("blackmage-face.png");
        face.scale(31, 47);
        back = new GreenfootImage("blackmage-back.png");
        back.scale(31, 47);
        left = new GreenfootImage("blackmage-left.png");
        left.scale(31, 47);
        right = new GreenfootImage("blackmage-right.png");
        right.scale(31, 47);
        this.d = 0;
    }
    
    public void act() 
    {
        this.d = wander(this.d);
        Stage3 w = (Stage3)getWorld();
        Character player = w.getCharacter();
        int diffX = player.getX()-getX();
        int diffY = player.getY()-getY();
        double l = Math.sqrt(diffX*diffX+diffY*diffY);
        this.cd_num++;
        if(cd_num>=cd){
            shoot(diffX, diffY);
            cd_num=0;
        }
        takeHit();
    }    
    
    private int wander(int d){
        if (Greenfoot.getRandomNumber(500)<5||getX()<=5||getX()>=getWorld().getWidth()-5||getY()<=5||getY()>=getWorld().getHeight()-5||getOneIntersectingObject(stone.class)!=null){
            d = Greenfoot.getRandomNumber(4);
        }
        if (d == 0){
            setLocation(getX(), getY() + 1);
            setImage(face);
        }
        if (d == 1){
            setLocation(getX(), getY() - 1);
            setImage(back);
        }
        if (d == 2){
            setLocation(getX() - 1, getY());
            setImage(left);
        }
        if (d == 3){
            setLocation(getX() + 1, getY());
            setImage(right);
        }
        return d;
    }
    
    private void shoot(int dx, int dy){
        if(Math.abs(dx)>=Math.abs(dy)){
            if(dx>=0){
                blackmagic bullet = new blackmagic("right");
                getWorld().addObject(bullet, getX(), getY());
            }
            else{
                blackmagic bullet = new blackmagic("left");
                getWorld().addObject(bullet, getX(), getY());
            }
        }
        else{
            if(dy>=0){
                blackmagic bullet = new blackmagic("down");
                getWorld().addObject(bullet, getX(), getY());
            }
            else{
                blackmagic bullet = new blackmagic("up");
                getWorld().addObject(bullet, getX(), getY());
            }
        }
    }
    
    private void takeHit(){
        normal_bullet bullet1 = (normal_bullet)getOneIntersectingObject(normal_bullet.class);
        crystal_bullet bullet2 = (crystal_bullet)getOneIntersectingObject(crystal_bullet.class);
        fireball_bullet bullet3 = (fireball_bullet)getOneIntersectingObject(fireball_bullet.class);
        laser_bullet bullet4 = (laser_bullet)getOneIntersectingObject(laser_bullet.class);
        if(bullet1!=null){
            getWorld().removeObject(bullet1);
            if(hp>0){
                hp-=bullet1.dmg;
            }
            else{
                getWorld().removeObject(this);
            }
        }
        
        else if(bullet2!=null){
            getWorld().removeObject(bullet2);
            if(hp>0){
                hp-=bullet2.dmg;
            }
            else{
                getWorld().removeObject(this);
            }
        }
        
        else if(bullet3!=null){
            getWorld().removeObject(bullet3);
            if(hp>0){
                hp-=bullet3.dmg;
            }
            else{
                getWorld().removeObject(this);
            }
        }
        
        else if(bullet4!=null){
            if(hp>0){
                hp-=bullet4.dmg;
            }
            else{
                getWorld().removeObject(this);
            }
        }
    }
}
