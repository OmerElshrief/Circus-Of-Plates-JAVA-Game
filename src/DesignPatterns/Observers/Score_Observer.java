/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.Observers;

import World.Circus;

/**
 *
 * @author Cina marCina
 */
public class Score_Observer implements Observer
         
{
private static Score_Observer score_Observer;
private Circus circus;

private Score_Observer()
{
    circus = Circus.getInstance();
}
public static Score_Observer  getInstance()
{
    if(score_Observer==null) score_Observer = new Score_Observer();
    return score_Observer;
}
    @Override
    public void Update()
    {
        circus.setScore(circus.getScore() +1);
       }
    
}
