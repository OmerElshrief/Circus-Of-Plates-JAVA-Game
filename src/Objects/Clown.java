/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import static java.util.Collections.list;
import java.util.LinkedList;
import java.util.List;


public class Clown extends ImageObject
{
  static  Clown Clown = null;
  private List<Shape> leftHand = new LinkedList<Shape>();
  private List<Shape> rightHand = new LinkedList<Shape>();

    private Clown(int posX, int posY)
    {
        super(posX, posY, "/clown.png");
    
    }
    public static Clown getInstance(int x , int y)
    {
        if(Clown == null) Clown = new Clown(x,y);
        return Clown;
    }

    public List<Shape> getLeftHand()
    {
        return leftHand;
    }

   public void UpdateLeftHand(Shape shape)
    {
        leftHand.add(shape);
    }

    public List<Shape> getRightHand()
    {
        return rightHand;
    }

    public void UpdateRightHand(Shape shape)
    {
        rightHand.add(shape);
    }
     
    public static Clown getInstance2()
    {
        return Clown;
    }
    
    
}

    

