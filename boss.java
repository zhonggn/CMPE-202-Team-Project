import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class boss extends enemy
{
    private GreenfootImage face;
    private GreenfootImage back;
    private GreenfootImage left;
    private GreenfootImage right;
    private World world;
    private int hp=500;
    
    public boss(World w) {
        this.world = w;    
        GreenfootImage image = getImage();
        image.scale(160, 128);      
        face = new GreenfootImage("boss-face.png");
        face.scale(160, 128);
        back = new GreenfootImage("boss-back.png");
        back.scale(160, 128);
        left = new GreenfootImage("boss-left.png");
        left.scale(160, 128);
        right = new GreenfootImage("boss-right.png");
        right.scale(160, 128);
        //
    }
    
    
    public void act() 
    {
        BossStage w = (BossStage)getWorld();
        Character player = w.getCharacter();
        int diffX = player.getX()-getX();
        int diffY = player.getY()-getY();
        double l = Math.sqrt(diffX*diffX+diffY*diffY);
        chase(diffX, diffY, l);
        if(Greenfoot.getRandomNumber(800)<5){
            shoot();
        }
        if(Greenfoot.getRandomNumber(800)<5){
            magic();
        }
        takeHit();
    }    
    
    private void chase(int diffX, int diffY, double l){
        if(l!=0){
            setLocation(getX()+2*diffX/(int)l,getY()+2*diffY/(int)l);
        }
        if(Math.abs(diffX)>=Math.abs(diffY)){
            if(diffX>=0)
                setImage(right);
            else
                setImage(left);
        }
        else{
            if(diffY>=0)
                setImage(face);
            else
                setImage(back);
        }
    }
    
    private void shoot(){
        blackmagic bullet1 = new blackmagic("right");
        getWorld().addObject(bullet1, getX(), getY());
        blackmagic bullet2 = new blackmagic("left");
        getWorld().addObject(bullet2, getX(), getY());
        blackmagic bullet3 = new blackmagic("up");
        getWorld().addObject(bullet3, getX(), getY());
        blackmagic bullet4 = new blackmagic("down");
        getWorld().addObject(bullet4, getX(), getY());
    }
    
    private void magic(){
        getWorld().addObject(new bossmagic(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(600));
        getWorld().addObject(new bossmagic(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(600));
        getWorld().addObject(new bossmagic(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(600));
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
