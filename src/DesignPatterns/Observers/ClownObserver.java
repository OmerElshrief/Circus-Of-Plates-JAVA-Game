/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.Observers;

import Objects.Clown;

/**
 *
 * @author Cina marCina
 */
public class ClownObserver implements Observer
{
Clown clown;
private static ClownObserver clownObserver;
    @Override
    public void Update()
    {
        
        clown.getRightHand().removeAll(clown.getRightHand());
        clown.getLeftHand().removeAll(clown.getLeftHand());
        System.err.println(clown.getRightHand().size());
        System.out.println(clown.getLeftHand().size());
         }

    private ClownObserver()
    {
        clown = Clown.getInstance2();
    }
    public static ClownObserver getInstance()
    {
        if(clownObserver == null)
            clownObserver = new ClownObserver();
        return clownObserver;
    }    
}
