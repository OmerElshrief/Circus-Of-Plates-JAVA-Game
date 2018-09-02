/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.Iterator;

import Objects.Shape;
import World.Circus;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.List;

/**
 *
 * @author Cina marCina
 */
public class CollectionOfShapes implements Container
{
    
    @Override
    public  Iterator getIterator(List<GameObject> myShapes)
    {
        return new CollectionOfShapesIterator(myShapes);
        
        }

    
    
    private class CollectionOfShapesIterator implements Iterator
    {
   List<GameObject> myShapes; 
   int i=0;
Circus circus;
        public CollectionOfShapesIterator(List<GameObject> myShapes)
        {
            
           this.myShapes = myShapes;
        }
 
        @Override
        public boolean hasNext()
        {
            if(i<myShapes.size()) return true;
            refresh();
            return false;
            }

        @Override
        public GameObject next()
        {
            if(this.hasNext())
            {return myShapes.get(i++); }
            
        return null;
        }
        private void refresh()
        {
            this.i = 0;
        }
    }
    
}
