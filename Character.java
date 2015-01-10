import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Character extends Actor
{
    private GreenfootImage face;
    private GreenfootImage back;
    private GreenfootImage left;
    private GreenfootImage right;
    private World world;
    public bullet bullet;
    private int speed = 4;
    private String direction = "down";
    private int firerate = 20;
    private int fireratecount = 0;
    private int hp = 100;
    private int attackmode = 0;
    private int protect = 80;
    private int protectcount = 0;
    
    public void setDirection(String direction){
        this.direction = direction;
    }
    
    public Character(World w) {
        this.world = w;    
        GreenfootImage image = getImage();
        image.scale(32, 48);      
        face = new GreenfootImage("player_face.png");
        face.scale(32, 48);
        back = new GreenfootImage("player_back.png");
        back.scale(32, 48);
        left = new GreenfootImage("player_left.png");
        left.scale(32, 48);
        right = new GreenfootImage("player_right.png");
        right.scale(32, 48);
        //
    }
    
    public void act() 
    {   
        fireratecount++;
        protectcount++;
        checkKey();
        if(protectcount>=protect){
            takeHit();
        }
        if(hp<=0)
            Greenfoot.setWorld(new Over());
    }
    
    public void checkKey(){
        
        
        if(Greenfoot.isKeyDown("A")){
            
            this.setDirection("left");
            moveLeft(this.speed);
            setImage(left);   
        }
        if(Greenfoot.isKeyDown("D")){
            this.setDirection("right");
            moveRight(this.speed);
            
            setImage(right);
        }
        if(Greenfoot.isKeyDown("W")){
            this.setDirection("up");
            moveUp(this.speed);
            setImage(back);
        }
        if(Greenfoot.isKeyDown("S")){
            this.setDirection("down");
            moveDown(this.speed);
            setImage(face);
        }
        if("space".equals(Greenfoot.getKey())){
            if(fireratecount>=firerate){
                fire();
                fireratecount = 0;
            }
        }
    }
    
    //eject bullet to hit something
    public void fire(){  
        if(attackmode == 0){
            bullet = new normal_bullet(this.direction);
            getWorld().addObject(bullet, getX(), getY());
        }
        if(attackmode == 1){
            bullet = new crystal_bullet(this.direction);
            getWorld().addObject(bullet, getX(), getY());
        }
        if(attackmode == 2){
            bullet = new fireball_bullet(this.direction);
            getWorld().addObject(bullet, getX(), getY());
        }
        if(attackmode == 3){
            bullet = new laser_bullet(this.direction);
            if(this.direction=="up")
                getWorld().addObject(bullet, getX(), getY()-250); 
            if(this.direction=="down")
                getWorld().addObject(bullet, getX(), getY()+250);   
            if(this.direction=="left")
                getWorld().addObject(bullet, getX()-250, getY()); 
            if(this.direction=="right")
                getWorld().addObject(bullet, getX()+250, getY()); 
        }
    }
    
    public void moveRight(int speed) {
        setLocation(getX() + speed, getY());
        if(getOneIntersectingObject(stone.class) != null)
            setLocation(getX() - speed, getY());
    } 
    
    public void moveLeft(int speed) { 
        setLocation(getX() - speed, getY());
        if(getOneIntersectingObject(stone.class) != null)
            setLocation(getX() + speed, getY());
    } 
    
    public void moveUp(int speed) { 
        setLocation(getX(), getY() - speed); 
        if(getOneIntersectingObject(stone.class) != null)
            setLocation(getX(), getY() + speed);
    } 
    
    public void moveDown(int speed) { 
        setLocation(getX(), getY() + speed); 
        if(getOneIntersectingObject(stone.class) != null)
            setLocation(getX(), getY() - speed); 
    }
    
    private void takeHit(){
        if(isTouching(bossmagic.class)){
            hp-=30;
            protectcount = 0;
        }
        if(isTouching(blackmagic.class)){
            hp-=20;
            protectcount = 0;
        }
        if(isTouching(enemy.class)||isTouching(spike.class)){
            hp-=10;
            protectcount = 0;
        }
    }
    
    public void setHP(int i){
        hp += i;
    }
    
    public void setSpeed(int i){
        speed += i;
    }
    
    public void setFirerate(int i){
        firerate -= i;
    }
    
    public void setMode(int i){
        attackmode = i;
    }
    
    public int getHP(){
        return hp;
    }
}
