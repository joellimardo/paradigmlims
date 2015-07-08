/*

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
package com.limsexpert.paradigmlims.view;

import java.io.Console;
import java.util.Arrays;
import com.limsexpert.paradigmlims.config.*;

public final class generalConsole {
 
  public generalConsole(paradigmConfig cf){
         /* This console is for an actual user who expects to be authenticated
          * with a manual username/password to execute a single instruction. This
          * is the default console. Other ones that would authenticate differently, 
          * as in one that would use LDAP/etc. */
         Console console = System.console();
         String username = console.readLine("User Name? ");
         char[] password = console.readPassword("Password? ");

         String pass = new String(password);
         if (pass.equals("arealpassword"))
         {
           console.printf("===========WELCOME===========\n");
           String instr = console.readLine(":> ");
           while(!instr.equals("quit"))
           {
                 console.printf("doing..." + instr + "\n"); 
                 instr = console.readLine(":> ");
           }
         }
         else
         {
            console.printf("That is not a valid password!\n"); 
         }
         
         
         console.printf("Bye.");
  }

}