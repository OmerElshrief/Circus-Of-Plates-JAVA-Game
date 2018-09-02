/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.States;

import static DesignPatterns.States.State.circus;
import Objects.ImageObject;
import Objects.Shape;
import World.Circus;
import eg.edu.alexu.csd.oop.game.GameObject;

/**
 *
 * @author Omar Elbasha
 */
public class HorizontalLeft extends State
{
    // variable to be used when moving shapes
  
    private static State Horizontal;  
     GameObject cons = (ImageObject) circus.getConstantObjects().get(2);
    
    
    private HorizontalLeft()
    
    {
        GameObject cons = (ImageObject) circus.getConstantObjects().get(1);
    }

   
    public static State getInstance()
    {
        if( Horizontal == null )
            Horizontal = new HorizontalLeft();
        
        return Horizontal;
    }

    // Decrement the x-coordinate checking if the image has hit the border
    @Override
    public void move(Shape shape)
    {
         newPos = (shape.getX() - 2);
         shape.setX(newPos);
         circusWidth = circus.getWidth();
        if(circusWidth == shape.getX()+2)
        { newPos = (int)Math.random()*circus.getWidth()-circus.getWidth();
            shape.setX(newPos);
        }
        if(shape.getX()<(cons.getX()))
            shape.setState(Left_Vertical.getInstance());
        }
    }

    

