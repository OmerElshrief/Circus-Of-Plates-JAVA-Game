/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.States;

import Objects.Clown;
import Objects.ImageObject;
import Objects.Shape;
import World.Circus;
import eg.edu.alexu.csd.oop.game.GameObject;

/**
 *
 * @author Omar Elbasha
 */
public abstract class State
{
    public static Circus circus=null;
    protected int newPos;
   protected int circusWidth;
   protected int circusHeight;
   protected GameObject clown;
   public State()
    {
        if( circus == null )
            circus = circus.getInstance();
       circusWidth = circus.getWidth();
      circusHeight = circus.getHeight();
      clown = (ImageObject) circus.getControlableObjects().get(0);
      
    }
    
    
    public abstract void move(Shape shape );
    
    
}
