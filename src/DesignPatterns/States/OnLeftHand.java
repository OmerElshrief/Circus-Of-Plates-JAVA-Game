/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.States;

import Objects.Clown;
import Objects.Shape;
import static java.util.Collections.list;
import java.util.List;
import java.util.Set;


public class OnLeftHand extends State
{
    private static OnLeftHand onLeftHand;
    private List<Shape> leftHand;
    Clown clown;
    int cross=10;
    Shape  topShape;
    
    public static OnLeftHand getInstance()
    { if(onLeftHand==null) 
        onLeftHand = new OnLeftHand();
    return onLeftHand;
        
    }
    
    private OnLeftHand()
    {
        clown = Clown.getInstance2();
       
    }
    @Override
    public void move(Shape shape)
    { 
       try
       { topShape = clown.getLeftHand().get(clown.getLeftHand().size()-1);
        int size = clown.getLeftHand().size();
         
       
        int cla = topShape.getY() - shape.getWidth();
        
        shape.setY(clown.getY() - size*20 );
        shape.setX(clown.getX() - shape.diff);
        shape.setHorizontalOnly(true);}
       catch(java.lang.IndexOutOfBoundsException e) {}
    
    
}
}

