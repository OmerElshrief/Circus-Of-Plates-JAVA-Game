/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;


public class Plates implements GameObject {
    public boolean verticle =true;
        public boolean stop = false;
        public boolean got = false;
        public boolean plate1 = false;
        private boolean horizontalOnly;

       public static final int SPRITE_WIDTH = 40;
	private static final int MAX_MSTATE = 1;
	// an array of sprite images that are drawn sequentially
	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
	private int x;
	private int y;
	private boolean left;
	private boolean top;
	boolean visible;

    public Plates(int x, int y) {
        spriteImages[0] = new BufferedImage(SPRITE_WIDTH, SPRITE_WIDTH,	BufferedImage.TYPE_INT_ARGB);
        this.x = x;
        this.y = y;
        Polygon  d2 = new Polygon();
        Ellipse2D E = new Ellipse2D.Float();
        E.setFrameFromCenter(x, y, x+40, y+40);
        Graphics2D g2 = spriteImages[0].createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.yellow);
        g2.draw(E);
        g2.dispose();
        
        
    }

        
   @Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int mX) {
		this.x = mX;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int mY) {
		this.y = mY;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
            
		return spriteImages;
	}

	@Override
	public int getWidth(){
		return SPRITE_WIDTH;
	}

	@Override
	public int getHeight() {
		return SPRITE_WIDTH;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}

}
