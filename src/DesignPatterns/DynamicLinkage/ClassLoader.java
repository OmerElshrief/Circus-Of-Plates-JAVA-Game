/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.DynamicLinkage;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cina marCina
 */
public class ClassLoader
{
   URLClassLoader shapeLoader;
   URL[] url;
   Class shape;
   Object shape_Object;
 private static ClassLoader classLoader;
    private ClassLoader()  
            {
    
       
       
    }
    public static ClassLoader getInstance()
    {
        if(classLoader==null) classLoader = new ClassLoader();
        return classLoader;
    }
     public void LoadShape(String shape_name)
     {
         try
       {
           
           shapeLoader = new URLClassLoader(url);
           shape = shapeLoader.loadClass(shape_name);
           shape_Object = shape.getConstructor().newInstance();
           
           
       } catch (IllegalAccessException ex)
       {
           Logger.getLogger(ClassLoader.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IllegalArgumentException ex)
       {
           Logger.getLogger(ClassLoader.class.getName()).log(Level.SEVERE, null, ex);
       } catch (InvocationTargetException ex)
       {
           Logger.getLogger(ClassLoader.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex)
       {
           Logger.getLogger(ClassLoader.class.getName()).log(Level.SEVERE, null, ex);
       } catch (NoSuchMethodException ex)
       {
           Logger.getLogger(ClassLoader.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SecurityException ex)
       {
           Logger.getLogger(ClassLoader.class.getName()).log(Level.SEVERE, null, ex);
       } catch (InstantiationException ex)
       {
           Logger.getLogger(ClassLoader.class.getName()).log(Level.SEVERE, null, ex);
       }
        
     }
     public Object getObject()
     {
      return shape_Object;   
     }
    
}
