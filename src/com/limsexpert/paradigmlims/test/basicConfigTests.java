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

package com.limsexpert.paradigmlims.test;

import com.limsexpert.paradigmlims.config.*;
import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class basicConfigTests extends TestCase {
 
  private paradigmConfig pconf;
  
  /** basicConfigTests constructor */
  public basicConfigTests(){
    pconf = new paradigmConfig();
  }
  
  /** Test to see if the connect.xml is in the default local location */
  public void testConfigFilePath() {  
        assertEquals("Config File Path","./lib/connect.xml",paradigmConfig.staticFilePath());
  }
  
  /**  Checks to see if the configFileTest() method works */
  public void testConfigFilePresent() {
        assertEquals("Config File is Present",
                      paradigmConfig.configFileTest(paradigmConfig.staticFilePath()),
                      true);
   }
  
  
  /** test to get the database URL */
  public void testConfigDBURL() {
       assertEquals("URL value",true,(pconf.getDBUrl().indexOf("paradigmlims",1) > 0));
  }
  
  /** test to ensure we know what OS we are on */
  public void testWhatOS(){
        assertEquals("OS Check",true,(pconf.get_OS() != "")); 
  }
  
  /** verify that the log directory and user directories exist and that they are 
    * writeable */
  public void testVerifyDirectories(){
       assertTrue(false); 
  }
  
  
   
}
