/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.Observers;

import Objects.Clown;
import Objects.ImageObject;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.ArrayList;
import Objects.Shape;
import DesignPatterns.Observers.Observer;
import DesignPatterns.States.OnLeftHand;
import DesignPatterns.States.OnRightHand;
import World.Circus;
import java.util.List;

/**
 *
 * @author Omar Elbasha
 */

/* Responsible for checking shape's intersection with the clown
 * Has a reference of the clown and the shapes in it's left and right hand.
 * Has a reference of the shapes moving vertically
 * checkIntersection is called when we move plates vertically 
 * Loops through all plates falling vertically checking
 * if they intersect with the clown's left or right hand
 * if they do intersect, we check the previous two plates in the corresponding hand
 * if the 3 are of the same colour, they are removed from the Hand ArrayList
 * Also gets removed from the " moving " list in the circus
 */
public class IntersectionObserver implements Observer
{

    Circus circus;
    private Clown clown;
    private ArrayList<Shape> leftHand;
    private ArrayList<Shape> rightHand;
    private ArrayList<Shape> verticalShapes;
    private Shape shape;
    private int shapeBorder;
    private int clownLeftBorder, clownRightBorder, condition, topPlate;
    private static IntersectionObserver intersectionObserver = null;
    private GameObject leftPlate, rightPlate;
    private Shape topShape;
    private Success_Observer success_Observer;

    private IntersectionObserver()
    {
        circus = Circus.getInstance();
        success_Observer =Success_Observer.getInstance();
        clown = (Clown) circus.getControlableObjects().get(0);
    }

    public static IntersectionObserver getInstance()
    {
        if (intersectionObserver == null)
        {
            intersectionObserver = new IntersectionObserver();
        }
        return intersectionObserver;
    }

    public void checkIntersection()
    {
        shapeBorder = shape.getX() + shape.getWidth();
        clownLeftBorder = clown.getX() + 10;
        clownRightBorder = clown.getWidth() + clown.getX();
        int size = clown.getLeftHand().size();
        //intersection of the first plate with the clown left hand
        if (size == 0)
        {

            condition = clownLeftBorder - shapeBorder;

            //intersection with leftHand
            if ((condition) > -(60) && (condition) < 5 && shape.getY() == clown.getY())
            {
                shape.diff = clown.getX() - shape.getX();
                shape.setState(OnLeftHand.getInstance());
                clown.UpdateLeftHand(shape);
                System.err.println(shape.getX());

            }
        } else
        {  //Intersection with top Plates on the left hand
             topShape = clown.getLeftHand().get(clown.getLeftHand().size() - 1);
            topPlate = topShape.getX() + topShape.getWidth();

            condition = topPlate - shapeBorder;

            if ((condition) > -(20) && (condition) < 15 && shape.getY() == topShape.getY())
            {
                shape.diff = clown.getX() - shape.getX();
                shape.setState(OnLeftHand.getInstance());
                clown.UpdateLeftHand(shape);
                
            }}
            
            

             //intersetion with Right hand
               size = clown.getRightHand().size();
                if (size == 0)
                {
                    condition = clownRightBorder - shapeBorder;
                    if (condition > -15 && condition < 15 && shape.getY() == clown.getY())
                    {
                        shape.diff = -clown.getX() + shape.getX();
                        shape.setState(OnRightHand.getInstance());
                        clown.UpdateRightHand(shape);
                        }
                }
                    else
                    { 
                           topShape = clown.getRightHand().get(clown.getRightHand().size() -1);
                           topPlate = topShape.getX() + topShape.getWidth();
                           condition = topPlate - shapeBorder;
                       if ((condition) > -(20) && (condition) < 15 && shape.getY() == topShape.getY())
                       {
                shape.diff = -clown.getX() + shape.getX();
                clown.UpdateRightHand(shape);
                shape.setState(OnRightHand.getInstance());
               
           
                       }
                }
                
            
        clown.getRightHand().size();
       success_Observer.Update();
         
    }
   
    

    public void updateShape(Shape shape)
    {
        this.shape = shape;
        checkIntersection();
    }

    @Override
    public void Update()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
