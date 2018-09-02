/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.Snapshot;

/**
 *
 * @author Cina marCina
 */
public class GameCurrentLevel
{
    private int gameSpeed;
    private int controlSpeed;
    private int numberOfShapes;
    public void getLevelFromMemento(GameLevelMemento gamelevel)
    {
        gameSpeed = gamelevel.getGameLevel().getGameSpeed();
        controlSpeed = gamelevel.getGameLevel().getControlSpeed();
        numberOfShapes= gamelevel.getGameLevel().getNumberOfShapes();
    }
    public GameLevelMemento getMemntoFromLevel()
    {
        GameLevel gameLevel = new GameLevel();
        GameLevelMemento memento = new GameLevelMemento();
        gameLevel.setGameSpeed(gameSpeed);
        gameLevel.setControlSpeed(controlSpeed);
        gameLevel.setNumberOfShapes(numberOfShapes);
        memento.setGameLevel(gameLevel);
        return memento;
        
    }

    public int getGameSpeed()
    {
        return gameSpeed;
    }

    public void setGameSpeed(int gameSpeed)
    {
        this.gameSpeed = gameSpeed;
    }

    public int getControlSpeed()
    {
        return controlSpeed;
    }

    public void setControlSpeed(int controlSpeed)
    {
        this.controlSpeed = controlSpeed;
    }

    public int getNumberOfShapes()
    {
        return numberOfShapes;
    }

    public void setNumberOfShapes(int numberOfShapes)
    {
        this.numberOfShapes = numberOfShapes;
    }
            
}
