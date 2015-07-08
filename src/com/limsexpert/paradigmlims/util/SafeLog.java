/*

Copyright 2014 Joel Limardo

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

package com.limsexpert.paradigmlims.util;

import java.io.File;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Date;

public class SafeLog {
 /* 
  * This should allow for 'safe' logging operations -- logging that should 
  * avoid causing the system to run out of disk space.
  */
  private String theDrive;
  private String filename;
  private File logfile;
  private boolean isCreated = false;
  
  /** Constructor 
    * @param driveName Drive name
    * @param filename  The name of the log file. */
  public SafeLog(String driveName, String filename) 
  {
    theDrive = driveName;
    this.filename = filename; 
    
    try {
     logfile = new File(theDrive + "/" + filename);
     if(!logfile.exists())
     {
        logfile.createNewFile(); 
        isCreated = true;
     }
     else
     {
        isCreated = true; 
     }
    }
    catch(IOException e)
    {
      e.printStackTrace();
      isCreated = false; // just in case
    }   
  }

  /** isCreated -- get isCreated property
    * @return boolean isCreated property */
  public boolean isCreated(){
   return this.isCreated; 
  }
  
  public String getFilename(){
     return (this.filename); 
  }
  
   /** Tells you how much free space you have on the drive 
     * @return Integer with free space bytes */  
   public long spaceFree(){
    File f = new File(this.theDrive);
    return(f.getFreeSpace()); 
  }
  /** Write a line to the safe log in the format DATETIME - lineToWrite\n
    * The DATETIME stamp and end of line is added by this method
    * @param lineToWrite String The line to write to the safe log */ 
  public void writeLine(String lineToWrite)
  {
    try {
     FileWriter fw = new FileWriter(logfile.getAbsoluteFile(), true);
     BufferedWriter bw = new BufferedWriter(fw);
     bw.write(new Date().toString() + " - " + lineToWrite + "\n");
     bw.close(); 
    }
    catch(IOException e)
    {
       e.printStackTrace(); 
    }
  }
}