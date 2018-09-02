/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.DynamicLinkage;

import DesignPatterns.States.State;
import Objects.Shape;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoadShape extends Shape
{

    Shape shapeObject;
    URLClassLoader shapeLoader;
   URL[] url = new URL[1];
    Class shape,main;
    Method method;

    public LoadShape(int posX, int posY,Color color, State state, String shape_name,URL url) 
    {
        super(posX, posY, state);
        this.url[0] = url;
        
        try
        {
            Class[] param = new Class[4];
            param[0] = int.class; param[1] = int.class; param[2] = Color.class; param[3] = State.class;
            Object[] argu = new Object[4];
            argu[0] = posX; argu[1] = posY; argu[2] = color; argu[3] = state;
            shapeLoader = new URLClassLoader(this.url);
            shape = shapeLoader.loadClass(shape_name);
            main=shapeLoader.loadClass("Objects.Shape");
            shapeObject = (Shape)shape.getConstructor(param).newInstance(argu);

        } catch (InstantiationException | IllegalAccessException ex)
        { System.err.println("Can't instance");
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex)
        { System.err.println("Arguents ERROR");
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex)
        { System.err.println("Can't invoke method");
        ex.getCause();
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        { System.err.println("Class not found");
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex)
        { System.err.println("No Such method");
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

    @Override
    public void setX(int mX)
    {
        try
        {
            method = shape.getMethod("setX", int.class);
            method.invoke(shapeObject, mX);

        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getY()
    {
        try
        {
            method = shape.getMethod("getY");
        } catch (NoSuchMethodException | SecurityException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        }

        try
        {
            return (int) method.invoke(shapeObject);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.err.println("ERROR");
        return 0;
    }

    @Override
    public void setY(int mY)
    {
        try
        {

            method = shape.getMethod("setY", int.class);
            method.invoke(shapeObject, mY);
        } catch (NoSuchMethodException ex)
        {  System.err.println("ERROR");
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public BufferedImage[] getSpriteImages()
    {
        try
        {
            method = shape.getMethod("getSpriteImages");
            return (BufferedImage[]) method.invoke(shapeObject);
        } catch (NoSuchMethodException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int getWidth()
    {
        try
        {
            method = shape.getMethod("getWidth");
            return (int) method.invoke(shapeObject);
        } catch (NoSuchMethodException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int getHeight()
    {
        try
        {
            method = shape.getMethod("getHeight");
            return (int) method.invoke(shapeObject);
        } catch (NoSuchMethodException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public boolean isVisible()
    {
        try
        {
            method = shape.getMethod("isVisible");
            return (boolean) method.invoke(shapeObject);
        } catch (NoSuchMethodException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
     public void setState(State state)
    {
        try
        {
            method = shape.getMethod("setState", State.class);
            method.invoke(shapeObject, state);
        } catch (NoSuchMethodException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setVisible(boolean visible)
    {
        try
        {
            method = shape.getMethod("setVisible",boolean.class);
            method.invoke(shapeObject,visible);
        } catch (NoSuchMethodException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 public State getState()
 {
      try
        {
            method = shape.getMethod("getState");
           return (State) method.invoke(shapeObject);
        } catch (NoSuchMethodException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        }
      System.err.println("ERROR");
              return null;
 }
 public  void move()
 {
      try
        {
            method = shape.getMethod("move");
            method.invoke(shapeObject);
        } catch (NoSuchMethodException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 
    @Override
    public int getX()
    {
         try
        {
            method = shape.getMethod("getX");
            return (int) method.invoke(shapeObject);
        } catch (NoSuchMethodException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.err.println("error");
    return 0;
    }
 
    @Override
   
    
    public Color getColor()
    {
         try
        {
            method = shape.getMethod("getColor");
         return   (Color) method.invoke(shapeObject);
        } catch (NoSuchMethodException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.err.println("Error"); return null;
    }
    public void setHorizontalOnly(boolean x)
    {
         try
        {
            method = shape.getMethod("setHorizontalOnly",boolean.class);
            method.invoke(shapeObject,x);
        } catch (NoSuchMethodException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex)
        {
            Logger.getLogger(LoadShape.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
