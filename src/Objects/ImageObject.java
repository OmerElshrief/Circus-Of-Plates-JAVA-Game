package Objects;

import DesignPatterns.Strategy.Strategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;

public class ImageObject implements GameObject{
	private static final int MAX_MSTATE = 1;
	// an array of sprite images that are drawn sequentially
	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
	private int x;
	private int y;
	private boolean visible = true;
	private int type;
        public String State;
        public boolean verticle =true;
        public boolean stop = false;
        public boolean got = false;
        public boolean plate1 = false;
        public boolean HorizontalOnly = true;
         public boolean Horizontal = true;
          public boolean moving = true;
          private Strategy strategy;

    public void setState(String State) {
        this.State = State;
    }
       public ImageObject(int posX, int posY, String path)
        {
		this(posX, posY, path, 0,null);
	}
	
	public ImageObject(int posX, int posY, String path,Strategy strategy)
        {
		this(posX, posY, path, 0,strategy);
	}

    public String getState() {
        return State;
    }
	
	public ImageObject(int posX, int posY, String path, int type,Strategy strategy){
		this.x = posX;
		this.y = posY;
		this.type = type;
		this.visible = true;
                this.strategy = strategy;
		// create a bunch of buffered images and place into an array, to be displayed sequentially
		try {
			spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int mX) {
		if(moving)
            this.x = mX;
                else
                    return;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int mY) {
            if(HorizontalOnly) return;
		this.y = mY;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		return spriteImages;
	}

	@Override
	public int getWidth(){
		return spriteImages[0].getWidth();
	}

	@Override
	public int getHeight() {
		return spriteImages[0].getHeight();
	}

	@Override
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	public void setMoving(boolean moving)
        {
            this.moving = moving;
            
        }
        public void move()
        {
            this.strategy.move(this);
        }
}
