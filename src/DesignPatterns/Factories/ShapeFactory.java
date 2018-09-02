/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.Factories;

import DesignPatterns.States.State;
//import Objects.BallObject;
//import Objects.RectagleObject;

import Objects.Shape;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.Color;

import java.awt.image.BufferedImage;

import java.util.Random;

public class ShapeFactory
{
   
static ShapeFactory ShapeFactory = null ;
BufferedImage bufferedImage =null;
    private ShapeFactory()
    {
       // imageByColor.put(Color.RED, bufferedImage);
        
      
    }

    GameObject[] Shapes;
    Color[] Colors;
    

    public GameObject GetRandomShape(int x, int y,State state)
    {
  //      Shapes =    new GameObject[2];
    //    Shapes[0] = (Shape)new RectagleObject(x, y, GetRandomColor(),state);
      //  Shapes[1] = (Shape)new BallObject(x, y, GetRandomColor(),state);

        return Shapes[new Random().nextInt(2)];

    }

    public Color GetRandomColor()
    {
        Colors = new Color[4];
        Colors[0] = Color.RED;
        Colors[1] = Color.BLUE;
        Colors[2] = Color.BLACK;
        Colors[3] = Color.YELLOW;

        return Colors[new Random().nextInt(4)];
    }
public static ShapeFactory getInstance()
{
    if(ShapeFactory == null) ShapeFactory = new ShapeFactory();
    return ShapeFactory;
}

    
}
