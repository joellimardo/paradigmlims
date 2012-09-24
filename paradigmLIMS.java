/*
     $Id: paradigmLIMS.java,v 1.3 2011/05/31 23:34:52 joellimardo Exp $
 */
/* 
Copyright 2011 Joel Limardo

This file is part of paradigmLIMS.

paradigmLIMS is free software: you can redistribute it and/or modify it under the terms 
of the GNU General Public License as published by the Free Software Foundation, 
either version 3 of the License, or (at your option) any later version.

paradigmLIMS is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with paradigmLIMS. 
If not, see http://www.gnu.org/licenses/. 
*/

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import paradigmlims.Configs.*;

public class paradigmLIMS {

    /* public static variables */

    public static String VERSION = "0.2";

    /* MAIN */

    public static void main(String[] args)
    {
        if (args.length > 0 ) 
        {
             if (args[0].equals("-h"))
             {
                  usageMessage();
             }
             else if (args[0].equals("-v"))
             {
                  System.out.println("\n\nVersion: " + VERSION + "\n");
             }
             else if(args[0].equals("-c"))
             {
                  // console mode
                  paradigmConfig cf = new paradigmConfig(paradigmConfig.staticFilePath());
                  cf.setInConsole(true);
                  ParadigmViews.generalConsole c = new ParadigmViews.generalConsole(cf);
             }
        }
        else
        {
           // GUI mode
           ParadigmViews.loginGUI gui = new ParadigmViews.loginGUI();
           gui.launchFrame();                    
          }
    }

    /* usageMessage */

    public static void usageMessage() 
    {
        System.out.println("\n\nUsage: \n"               +
                    "-h       Print this help message\n" +
                    "-c       Console mode\n"            +
                    "-v       Print the version\n");    
    }

}