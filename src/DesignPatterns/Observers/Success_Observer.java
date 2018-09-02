/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.Observers;

import Objects.Clown;
import Objects.Shape;


public class Success_Observer implements Observer
{
    private static Success_Observer success_Observer;
   Clown clown;
   Shape shape1,shape2,shape3;
   int size;
   private Score_Observer score;
    private Success_Observer()
    {  score = Score_Observer.getInstance();
        clown = Clown.getInstance2();
    }
    public static Success_Observer getInstance()
    {
        if(success_Observer == null) success_Observer = new Success_Observer();
        return success_Observer;
    }

    @Override
    public void Update() 
    { 
        try
        {
       size = clown.getLeftHand().size();
       shape1 = clown.getLeftHand().get(size-1);
       shape2 = clown.getLeftHand().get(size-2);
       shape3 = clown.getLeftHand().get(size-3);
       if(shape1.getColor() == shape2.getColor() && shape1.getColor() == shape3.getColor())
       {  System.err.println("Point!");
           shape1.setVisible(false);
          shape2.setVisible(false);
          shape3.setVisible(false);
          clown.getLeftHand().remove(shape1);
          clown.getLeftHand().remove(shape2);
          clown.getLeftHand().remove(shape3);
          score.Update();
         
       }
       else
       {
         
       size = clown.getRightHand().size();
       shape1 = clown.getRightHand().get(size-1);
       shape2 = clown.getRightHand().get(size-2);
       shape3 = clown.getRightHand().get(size-3);
        
       if(shape1.getColor() == shape2.getColor() && shape1.getColor() == shape3.getColor())
       {  
           shape1.setVisible(false);
          shape2.setVisible(false);
          shape3.setVisible(false);
          clown.getRightHand().remove(shape1);
          clown.getRightHand().remove(shape2);
          clown.getRightHand().remove(shape3);
          score.Update();
       }
       }
        }
        catch(IndexOutOfBoundsException e)
                {
                   
                }
        
        
                }
       
    
       }


