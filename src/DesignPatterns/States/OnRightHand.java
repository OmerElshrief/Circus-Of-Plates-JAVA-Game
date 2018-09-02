/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.States;

import Objects.Clown;
import Objects.Shape;

/**
 *
 * @author Cina marCina
 */
public class OnRightHand extends State
{
    
    
private static OnRightHand onRighthand;
 Clown clown;   
 int spaces;
Shape topShape;
    
private OnRightHand()
{
    spaces = 0;
    clown = Clown.getInstance2();
}
    public static OnRightHand getInstance()
    {
        if(onRighthand==null)
            onRighthand = new OnRightHand();
        return onRighthand;
    }
    @Override
    public void move(Shape shape)
    {
      try
      {
          topShape = clown.getRightHand().get(clown.getRightHand().size()-1);
        int size = clown.getRightHand().size();
       
        shape.setY(clown.getY() - size*20 );
        shape.setX(clown.getX()  + shape.diff);
        shape.setHorizontalOnly(true);
       spaces = 0;}catch (IndexOutOfBoundsException r){}
}
}
