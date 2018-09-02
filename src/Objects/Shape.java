package Objects;
 
import DesignPatterns.States.State;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import Objects.Shape;
import World.Circus;
 
import eg.edu.alexu.csd.oop.game.GameObject;
import javafx.geometry.HorizontalDirection;
 
public abstract class Shape implements GameObject 
{
 
    public static final int SPRITE_WIDTH = 40;
    private static final int MAX_MSTATE = 1;
    // an array of sprite images that are drawn sequentially
  public BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
	public int x;
public	int y;
      public  int height;
     public   int width;
         public int diff=0;
public	boolean left;
public	boolean top;
public	boolean visible;
public        State state;
 public       Circus circus ;
public        boolean horizontalOnly;
 public       Color color;
        
 
    public Shape(int posX, int posY,State state)
    {
 
        this.x = posX;
        this.y = posY;
        this.visible = true;
        this.state = state;
        circus = circus.getInstance();
 
    }
   
   
    public void setState(State state)
    {
        this.state = state;
    }

    public void setVisible(boolean visible)
    {
        this.visible = visible;
    }
 public State getState()
 {
     return state;
 }
 public  void move()
 {
     state.move(this);
 }
 
    @Override
    public int getX()
    {
        return x;
    }
 
    @Override
    public void setX(int mX)
    {
        this.x = mX;
    }
 
    @Override
    public int getY()
    {
        return y;
    }
 
    @Override
    public void setY(int mY)
    { if(horizontalOnly) return;
        this.y = mY;
    }
 
    @Override
    public BufferedImage[] getSpriteImages()
    {
        return spriteImages;
    }
 
    @Override
    public int getWidth()
    {
        return SPRITE_WIDTH;
    }
 
    @Override
    public int getHeight()
    {
        return SPRITE_WIDTH;
    }
 
    @Override
    public boolean isVisible()
    {
        return visible;
    }
 
    public Color getColor()
    {
        return color;
    }
    public void setHorizontalOnly(boolean x)
    {
        horizontalOnly = x;
    }
 
 
}