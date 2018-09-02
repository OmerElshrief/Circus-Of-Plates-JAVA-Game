/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.Strategy;

import Objects.ImageObject;
import World.Circus;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.List;

/**
 *
 * @author Cina marCina
 */
public abstract class Strategy
{
   protected Circus circus;

    public abstract void move(ImageObject shape);

    public Strategy()
    {
        this.circus = Circus.getInstance();
       
    }
}
