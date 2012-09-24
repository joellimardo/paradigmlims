/*
     $Id: InsufficientPermissions.java,v 1.2 2011/05/31 18:38:04 joellimardo Exp $
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
package ParadigmExceptions;

public class InsufficientPermissions extends Exception {
  InsufficientPermissions (String reason) {
    // should log this as a potential security breach attempt
    super(reason);
       
  }
  
}
