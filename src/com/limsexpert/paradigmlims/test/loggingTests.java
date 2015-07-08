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
import com.limsexpert.paradigmlims.util.*;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */

public class loggingTests extends TestCase {

  private paradigmConfig pconf;
  
  public loggingTests(){
      pconf = new paradigmConfig(); 
  }
  
  /** testSafeLog -- basic test */
  public void testSafeLog() {
  SafeLog slog = new SafeLog(pconf.getLogDirectory(), "dummy.log");
        assertTrue(slog.spaceFree() > 0);
  
  }
  
  /** testNonExistentLog -
    * What happens when we try to create a non-exist log (should just create the file)*/
  public void testNonExistentLog(){
     SafeLog slog = new SafeLog("/tmp/foofakedir","dummy.log");
     assertTrue(!slog.isCreated());
     
  }
  
}