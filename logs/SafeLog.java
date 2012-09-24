/*
     $Id: SafeLog.java,v 1.2 2011/05/31 18:36:39 joellimardo Exp $
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
package paradigmlims.logs;

import java.io.File;

public class SafeLog {
 /* 
  * This log checks to see if there is enough disk space before writing to a log.
  * If you don't do this and your LIMS is trapped in some kind of error loop
  * you will wind up writing logs until you fill up your disk space (I've seen this happen).
  * 
  */
  private String theDrive;
  
  public SafeLog(String driveName)
  {
    theDrive = driveName;
    
  }
  
   public long spaceFree(){
    File f = new File(this.theDrive);
    return(f.getFreeSpace()); 
  }
}