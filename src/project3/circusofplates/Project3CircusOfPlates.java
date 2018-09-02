/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3.circusofplates;

import StartMenu.Startmenu;
import World.Circus;
import eg.edu.alexu.csd.oop.game.GameEngine;
import java.awt.Color;
import static java.awt.SystemColor.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author Cina marCina
 */
public class Project3CircusOfPlates
{
   public int speed;
   public  int clownspeed;
   public  int numberofshapes;
GameEngine.GameController gameController;

    public GameEngine.GameController getGameController()
    {
        return gameController;
    }
    
   
   
    
        
        public void startgame() throws ClassNotFoundException, NoSuchMethodException, MalformedURLException
        {
        JMenuBar main = new JMenuBar();
        JMenu Game = new JMenu("Game");
        JMenuItem Resume = new JMenuItem("Resum");
        JMenuItem Pause = new JMenuItem("Pause");
        JMenuItem Exit = new JMenuItem("Exit");
        JMenuItem newgame = new JMenuItem("New game");
        Game.add(newgame);
        Game.addSeparator();
        Game.add(Pause);
        Game.add(Resume);
        Game.addSeparator();

        
        Game.addSeparator();
        Game.add(Exit);

        

        main.add(Game);
       

         gameController = GameEngine.start("My Game", new Circus(1000, 700,speed,clownspeed,numberofshapes), main);

        Pause.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                gameController.pause();
                Resume.enable();
                Pause.disable();
            }
        });

        Resume.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                gameController.resume();
                Resume.disable();
                Pause.enable();
            }
        });

        Exit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

       
    }

}
