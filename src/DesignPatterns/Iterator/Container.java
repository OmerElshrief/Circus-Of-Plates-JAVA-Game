/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.Iterator;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.List;

/**
 *
 * @author Cina marCina
 */
public interface Container {  
    public Iterator getIterator(List<GameObject> myShapes);  
}
