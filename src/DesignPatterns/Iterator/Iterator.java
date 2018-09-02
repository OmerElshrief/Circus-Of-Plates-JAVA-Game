/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.Iterator;

import eg.edu.alexu.csd.oop.game.GameObject;

/**
 *
 * @author Cina marCina
 */
public interface Iterator {  
    public boolean hasNext();  
    public GameObject next();  
}  
