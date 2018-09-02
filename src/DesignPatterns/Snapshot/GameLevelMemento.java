/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.Snapshot;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cina marCina
 */
public class GameLevelMemento
{
    private GameLevel gameLevel;
    List<GameLevel> mementos;

    public GameLevelMemento()
    {
        mementos = new ArrayList<GameLevel>();
    }

    public GameLevel getGameLevel()
    {
        return gameLevel;
    }

    public void setGameLevel(GameLevel gameLevel)
    {
        this.gameLevel = gameLevel;
    }
    public void addLevel(GameLevel gameLevel)
    {
        mementos.add(gameLevel);
    }
    
}
