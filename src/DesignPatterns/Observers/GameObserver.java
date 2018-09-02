/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.Observers;

import DesignPatterns.Snapshot.GameCurrentLevel;
import DesignPatterns.Snapshot.GameLevelMemento;
import Objects.Clown;
import World.Circus;
import eg.edu.alexu.csd.oop.game.GameEngine;
import java.util.ArrayList;
import java.util.List;
import project3.circusofplates.Project3CircusOfPlates;

/**
 *
 * @author Cina marCina
 */
public class GameObserver implements Observer
{
Circus circus;
GameLevelMemento memento;
GameCurrentLevel currentLevel;
int score;
List<GameLevelMemento> levelsMemento ;
private static GameObserver level_Observer;
Clown clown;
GameEngine.GameController gamecontroller;
Project3CircusOfPlates game = new Project3CircusOfPlates();
public static GameObserver getInstance()
{
    if(level_Observer==null)
        level_Observer = new GameObserver();
    return level_Observer;
}

    private GameObserver()
    { 
        gamecontroller = game.getGameController();
       clown = Clown.getInstance2();
        
       
        
    }


    @Override
    public void Update()
    {
        try
        {  if(clown.getLeftHand().get(clown.getLeftHand().size() -1).getY() <100)
        {
            circus.setStatus("You Lost, gameOver");
            gamecontroller.pause();            
        }
        else
            if(clown.getRightHand().get(clown.getRightHand().size() -1).getY() <100)
                 {
            circus.setStatus("You Lost, gameOver");
            gamecontroller.pause();     
            
          
        }}
        catch(NullPointerException e){}
            
        
        
    }
    
}
