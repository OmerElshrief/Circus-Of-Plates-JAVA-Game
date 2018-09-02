/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.Factories;

import DesignPatterns.DynamicLinkage.LoadShape;
//import static DesignPatterns.Factories.ShapeFactory.ShapeFactory;
import DesignPatterns.States.State;

import Objects.Shape;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.Color;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Random;

/**
 *
 * @author Cina marCina
 */
public class LoadShapeFactory
{
    private static LoadShapeFactory loadShapeFactory;
    private LoadShapeFactory()
    {
    }
    
    public static LoadShapeFactory getInstance()
    {
        if(loadShapeFactory == null)
            loadShapeFactory = new LoadShapeFactory();
        return loadShapeFactory;
    }
GameObject[] Shapes;
    Color[] Colors;
    public File jar;

    public GameObject GetRandomShape(int x, int y,State state) throws MalformedURLException
    {
        System.err.println("");
        Shapes =    new GameObject[2];
        jar = new File("res//Shapes.jar");
        Shapes[0] = (Shape)new LoadShape(x,y,GetRandomColor(),state,"Objects.RectagleObject",jar.toURI().toURL());
        Shapes[1] = (Shape)new LoadShape(x,y,GetRandomColor(),state,"Objects.BallObject",jar.toURI().toURL());
       
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

    
}

