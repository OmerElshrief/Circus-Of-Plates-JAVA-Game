/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.Observers;

import DesignPatterns.Snapshot.GameCurrentLevel;
import DesignPatterns.Snapshot.GameLevelMemento;
import World.Circus;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cina marCina
 */
public class Level_Observer implements Observer
{
Circus circus;
GameLevelMemento memento;
GameCurrentLevel currentLevel;
int score;
List<GameLevelMemento> levelsMemento ;
private static Level_Observer level_Observer;
ClownObserver clownObserver;

public static Level_Observer getInstance()
{
    if(level_Observer==null)
        level_Observer = new Level_Observer();
    return level_Observer;
}

    private Level_Observer()
    {
        clownObserver = ClownObserver.getInstance();
        this.circus = Circus.getInstance();
        currentLevel = new GameCurrentLevel();
        currentLevel.setControlSpeed(circus.getControlSpeed());
        currentLevel.setGameSpeed(circus.getSpeed());
        currentLevel.setNumberOfShapes(circus.getNumberOfShapes());
        this.score = circus.getScore();
        levelsMemento = new ArrayList<GameLevelMemento>();
        
        
    }

    @Override
    public void Update()
    {
        if(circus.getTimer() <1 && circus.getScore()>score +1  )
        {
            circus.setStartTime(System.currentTimeMillis());
            circus.setLevel(circus.getLevel() +1);
            levelsMemento.add(currentLevel.getMemntoFromLevel());
            circus.setGameSpeed(circus.getSpeed() - 3);
            circus.setControlSpeed(circus.getControlSpeed() + 3);
            try
            {
                circus.IncreaseNoOfPlates();
            } catch (MalformedURLException ex)
            {
                Logger.getLogger(Level_Observer.class.getName()).log(Level.SEVERE, null, ex);
            }
             clownObserver.Update();
              
         }
        else
            if(circus.getTimer() < 1 && circus.getScore() < score +1 && circus.getLevel()>1)
            {
            memento = levelsMemento.get(levelsMemento.size() -1);
            circus.setStartTime(System.currentTimeMillis());
            circus.setLevel(circus.getLevel() -1);
            currentLevel.getLevelFromMemento(memento);
            levelsMemento.remove(memento);
            circus.setGameSpeed(currentLevel.getGameSpeed());
            circus.setControlSpeed(currentLevel.getControlSpeed());
            circus.decreaseNoOfPlates();
            clownObserver.Update();
            
            
            }
        else
                if(circus.getTimer() < 1 && circus.getLevel() == 1 && circus.getScore() < score +1)
                {
                    circus.setStatus("GameOver, You lost.");
                }
            
        
       
     }
    
    
}
