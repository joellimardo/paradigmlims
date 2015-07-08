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
package com.limsexpert.paradigmlims.model;

public class User {
  private String id;
  private String first_name;
  private static final int MAX_ID_SIZE = 30;
  /** Constructor */
  public User(){
    
  }
  /** Set the user id...should be max MAX_ID_SIZE characters */
  public void setId(String id) throws UserIdTooLarge
  {
      if (id.length() > MAX_ID_SIZE) 
      {
        throw new UserIdTooLarge("Size is too large"); // should be multi-lingual
      }
      else
      {
        this.id = id; 
      }
  }
  
  /** Get the user id */
  public String getId()
  {
      return this.id; 
  }
}

/** Error class UserIdTooLarge. Must be MAX_ID_SIZE characters. */
class UserIdTooLarge extends Exception {
  UserIdTooLarge (String reason) {
       super(reason);
  }
  
}