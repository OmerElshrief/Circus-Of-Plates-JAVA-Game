/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.States;

import DesignPatterns.Observers.IntersectionObserver;
import Objects.Clown;
import Objects.Shape;
import eg.edu.alexu.csd.oop.game.GameObject;


/**
 *
 * @author Omar Elbasha
 */
public class Vertical extends State
{
  
 private static Vertical vertical =null;
 private IntersectionObserver observer;
 
 
    private Vertical()
    {
       observer = IntersectionObserver.getInstance();
    }
    public static Vertical getInstance ()
    {
        if(vertical==null)
            vertical = new Vertical();
        return vertical;
    }
    
    // modifies the y-coordinate checking
    // if it has hit the bottom border, change it's state to horizontal
    // and re-add it to the plates moving horizontally at the top
    // else, check if it has intersected with the clown by calling the IntersectionObserver
    
    
    @Override
    public void move(Shape shape)
    {
        newPos = shape.getY() + 2;
        shape.setY( newPos );
        observer.updateShape(shape);
        if( newPos > circus.getHeight() )
        {
            shape.setY(100);
            shape.setX((int) (Math.random()*circus.getWidth()*-1 +20));
            shape.setState(HorizontalRight.getInstance());
        }
        else // check if interesecting with the clown
        {
            //IntersectionObserver.update(shape);
        }
    }

    
}
