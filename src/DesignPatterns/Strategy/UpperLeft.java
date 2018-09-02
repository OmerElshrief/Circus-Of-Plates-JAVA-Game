/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.Strategy;

import Objects.ImageObject;

/**
 *
 * @author Cina marCina
 */
public class UpperLeft extends Strategy
        
{

    @Override
    public void move(ImageObject cons)
    {
if(cons.Horizontal)
          cons.setX( cons.getX()+1);
        else
            cons.setX( cons.getX()-1);
      if(cons.getX()==950)
         cons.Horizontal=false;
      if(cons.getX()==770)
         cons.Horizontal=true;    }
    
}
