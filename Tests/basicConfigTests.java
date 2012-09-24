/*
     $Id: basicConfigTests.java,v 1.3 2011/05/31 23:36:02 joellimardo Exp $
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
package Tests;
import paradigmlims.Configs.*;


import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class basicConfigTests extends TestCase {
  
  public void testConfigFilePath() {
   
        assertEquals("Config File Path","./lib/connect.xml",paradigmConfig.staticFilePath());
  
  }
  public void testConfigFilePresent() {
        assertEquals("Config File is Present",
                      paradigmConfig.configFileTest(paradigmConfig.staticFilePath()),
                      true);
   }
  
  
  // test the individual parts
  public void testConfigDBURL() {
       paradigmConfig pconf = new paradigmConfig(paradigmConfig.staticFilePath());
       assertEquals("URL value",true,(pconf.getdb_url().indexOf("paradigmlims",1) > 0));
  }
  
  // test to ensure we know what OS we are on
  public void testWhatOS(){
        paradigmConfig pconf = new paradigmConfig(paradigmConfig.staticFilePath());
        assertEquals("OS Check",true,(pconf.get_OS() != "")); 
  }
   
}
