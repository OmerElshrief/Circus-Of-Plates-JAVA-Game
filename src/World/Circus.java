/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package World;

import DesignPatterns.DynamicLinkage.LoadShape;
import DesignPatterns.Factories.LoadShapeFactory;
import DesignPatterns.Iterator.CollectionOfShapes;
import DesignPatterns.Iterator.Iterator;
import DesignPatterns.Factories.ShapeFactory;
import DesignPatterns.Observers.GameObserver;
import DesignPatterns.Observers.Level_Observer;
import DesignPatterns.States.HorizontalLeft;
import DesignPatterns.States.HorizontalLeft_1;
import DesignPatterns.States.HorizontalRight;
import DesignPatterns.States.HorizontalRight_1;
import DesignPatterns.States.State;
import DesignPatterns.Strategy.Fixed;
import DesignPatterns.Strategy.Left;
import DesignPatterns.Strategy.Right;
import DesignPatterns.Strategy.UpperLeft;
import DesignPatterns.Strategy.UpperRight;
import Objects.Clown;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import Objects.ImageObject;
import Objects.Shape;
import eg.edu.alexu.csd.oop.game.GameEngine;
import java.awt.Color;
import static java.awt.JobAttributes.DestinationType.FILE;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javafx.geometry.HorizontalDirection;

/**
 *
 * @author Cina marCina
 */
public class Circus implements World
{
 private String status = "You need to get at least 10 More point to win";
    private int level;
    private int timer;

   

    
    public int MAX_TIME = 2 * 60 * 1000;	// 1 minute
    private int score = 0;
    private long startTime = System.currentTimeMillis();
    private final int WIDTH;
    private final int HEIGHT;
    private final List<GameObject> constant = new LinkedList<GameObject>();
    private final List<GameObject> moving = new LinkedList<GameObject>();
    private final List<GameObject> control = new LinkedList<GameObject>();
    private int numberOfShapes ;
    Shape shape;
    int randomX, randomY;
    State shapeState;
    CollectionOfShapes MyShapes;
    Iterator movingIterator;
    Iterator constantIterator;
    ImageObject cons;
    private static Circus circus;
    Random random = new Random();
    
    private int gameSpeed ;
    int controlSpeed ;
    Level_Observer level_Observer;
    GameObserver gameobserver;
    
    public Circus(int WIDTH, int HEIGHT,int speed , int clownspeed, int shapes) throws ClassNotFoundException, NoSuchMethodException, MalformedURLException
    {
       gameobserver = GameObserver.getInstance();
        this.gameSpeed = speed;   
        this.controlSpeed = clownspeed;
        this.numberOfShapes = shapes;
        constant.add(new ImageObject(0, 0, "/Back.png", new Fixed()));
        this.level = 1;
        circus = this;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        randomX = (int) Math.random() * getWidth() * -1;
        randomY = 100;
        control.add(Clown.getInstance(getWidth() / 3, getHeight() - 150));
        constant.add(new ImageObject(0, 110, "/40Right.png", new Right()));
        constant.add(new ImageObject(600, 110, "/40left.png", new Left()));
        constant.add(new ImageObject(-150, 170, "/40Right.png", new UpperRight()));
        constant.add(new ImageObject(770, 170, "/40left.png", new UpperLeft()));
        //ToGenerate random shapes with random colors at random positions.
        for (int i = 0; i < (numberOfShapes); i++)
        {
            moving.add(LoadShapeFactory.getInstance().GetRandomShape(random.nextInt(getWidth()) + getWidth() + 20, 100, HorizontalLeft.getInstance()));
            // moving.add(ShapeFactory.getInstance().GetRandomShape( random.nextInt(getWidth()) + getWidth()+20, 100, HorizontalLeft.getInstance()));
  moving.add(LoadShapeFactory.getInstance().GetRandomShape(random.nextInt(getWidth()) * -1 + 20, 100, HorizontalRight.getInstance()));
          
          //  moving.add(ShapeFactory.getInstance().GetRandomShape(random.nextInt(getWidth()) * -1 + 20, 100, HorizontalRight.getInstance()));
            moving.add(LoadShapeFactory.getInstance().GetRandomShape(random.nextInt(getWidth()) + getWidth() + 20, 160, HorizontalLeft_1.getInstance()));
            moving.add(LoadShapeFactory.getInstance().GetRandomShape(random.nextInt(getWidth()) * -1 + 20, 160, HorizontalRight_1.getInstance()));

//moving.add(LoadShapeFactory.getInstance().GetRandomShape( random.nextInt(getWidth()) + getWidth()+20, 160, HorizontalLeft_1.getInstance()));
//            moving.add(LoadShapeFactory.getInstance().GetRandomShape( random.nextInt(getWidth())*-1+20, 160, HorizontalRight_1.getInstance()));
//       
        }

        MyShapes = new CollectionOfShapes();
        movingIterator = MyShapes.getIterator(moving);
        constantIterator = MyShapes.getIterator(constant);
         level_Observer = Level_Observer.getInstance();

    }

    @Override
    public boolean refresh()
    {

        timer = (int) Math.max(0, (MAX_TIME - (System.currentTimeMillis() - startTime)) / 1000);
        while (movingIterator.hasNext())
        {
            shape = (Shape) movingIterator.next();
            shape.move();
        }

        for (int i = 0; i < constant.size(); i++)
        {
            cons = (ImageObject) constant.get(i);
            cons.move();
        }
        gameobserver.Update();
   //     level_Observer.Update();
//        if(score == 2 ) {Restart(); score =0;}

        return true;

    }
    // To be used to get reference of the circuss to access it's fields.

    public static Circus getInstance()
    {

        return circus;
    }

    // to be used when creating the Circus at the start of the program
    

    @Override
    public int getSpeed()
    {
        return gameSpeed;
    }

    @Override
    public int getControlSpeed()
    {
        return controlSpeed;
    }

    @Override
    public List<GameObject> getConstantObjects()
    {
        return constant;
    }

    @Override
    public List<GameObject> getMovableObjects()
    {
        return moving;
    }

    @Override
    public List<GameObject> getControlableObjects()
    {
        return control;
    }

    @Override
    public int getWidth()
    {
        return WIDTH;
    }

    @Override
    public int getHeight()
    {
        return HEIGHT;
    }

    @Override
    public String getStatus()
    {
        return "Score=" + score + "   |   Time=" + timer  +"    |     Level: "+ level +"       |     "  + status;	// update status
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public int getNumberOfShapes()
    {
        return numberOfShapes;
    }

    public void setNumberOfShapes(int numberOfShapes)
    {
        this.numberOfShapes = numberOfShapes;
    }

   

    public void setGameSpeed(int gameSpeed)
    {
        this.gameSpeed = gameSpeed;
    }

    public int getTimer()
    {
        return timer;
    }

    public void setTimer(int Timer)
    {
        this.timer = Timer;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public void setControlSpeed(int ControlSpeed)
    {
        this.controlSpeed = ControlSpeed;
    }

    public void IncreaseNoOfPlates() throws MalformedURLException
    {
        for(int j=0;j<2;j++)
        { moving.add(LoadShapeFactory.getInstance().GetRandomShape(random.nextInt(getWidth()) + getWidth() + 20, 100, HorizontalLeft.getInstance()));
        moving.add(ShapeFactory.getInstance().GetRandomShape(random.nextInt(getWidth()) * -1 + 20, 100, HorizontalRight.getInstance()));
        moving.add(LoadShapeFactory.getInstance().GetRandomShape(random.nextInt(getWidth()) + getWidth() + 20, 160, HorizontalLeft_1.getInstance()));
        moving.add(LoadShapeFactory.getInstance().GetRandomShape(random.nextInt(getWidth()) * -1 + 20, 160, HorizontalRight_1.getInstance()));
        }
        numberOfShapes = numberOfShapes + 8;
    }
    public void decreaseNoOfPlates()
    {
        for(int j=0;j<8;j++)
            moving.remove(moving.size()-1);
    }
    public String getState()
    {
        return status;
    }

    public void setStatus(String state)
    {
        this.status = state;
    }
    public void updateShapes()
    {
        for(int i =0;i<moving.size();i+=4)
        { 
            try{
           shape = (Shape) moving.get(i);
           shape.setX(random.nextInt(getWidth()) + getWidth() + 20);
           shape.setY(100);
           shape.setState(HorizontalLeft.getInstance());
           shape = (Shape) moving.get(i+1);
           shape.setX(random.nextInt(getWidth()) * -1 + 20);
           shape.setY(100);
           shape.setState(HorizontalRight.getInstance());
           shape = (Shape) moving.get(i+2);
           shape.setX(random.nextInt(getWidth()) + getWidth()+20);
           shape.setY(160);
           shape.setState(HorizontalLeft_1.getInstance());
           shape = (Shape) moving.get(i+3);
           shape.setX(random.nextInt(getWidth()) * -1 + 20);
           shape.setY(160);
           shape.setState(HorizontalRight_1.getInstance());}
            catch(IndexOutOfBoundsException e) {}
           Clown clown = Clown.getInstance2();
           clown.getLeftHand().clear();
           clown.getRightHand().clear();
        }
    }
     public void setStartTime(long startTime)
    {
        this.startTime = startTime;
    }
     public void Restart()
     {
         
       
       
     }
}
