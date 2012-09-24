/*
     $Id: paradigmConfig.java,v 1.3 2011/05/31 23:38:55 joellimardo Exp $
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

package paradigmlims.Configs;

import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.Document;
import java.util.Properties;

public final class paradigmConfig {
  /* Utilty class that takes in various configuration
   * documents and database tables and puts them in one
   * easy-to-reach place. This class does not do anything else. */
  
  private String databasetype;
  private String db_username;
  private String db_password;
  private String db_url;
  private String db_force_unicode;
  private String db_char_encoding;
  private boolean show_startup_screen;
  private String default_language;
  private String user_directory;
  private String OS;   // detect OS or let configuration tell me?
  private boolean inConsole = false;
  
  // some statics are in order
  public static String staticFilePath(){
     return("./lib/connect.xml"); 
  }
  // general config path
  public String configFilePath(){
        String connectPath = paradigmConfig.staticFilePath();
        if (this.inConsole)
        {
           connectPath = "." + connectPath; 
        }
        return (connectPath); 
  }
  
  public paradigmConfig(String xmlConfigFile)
  {
            // borrowed from MySQLDBAdapter
    try {
            Document doc = new SAXBuilder().build(xmlConfigFile);
            Element eXML_DatabaseConfig = doc.getRootElement();
            this.databasetype = eXML_DatabaseConfig.getChildText("databasetype");
            this.db_username = eXML_DatabaseConfig.getChildText("userid"); 
            this.db_url = eXML_DatabaseConfig.getChildText("URL");
            this.db_force_unicode = eXML_DatabaseConfig.getChildText("force_unicode");
            this.db_char_encoding = eXML_DatabaseConfig.getChildText("character_encoding");
            this.show_startup_screen = ((eXML_DatabaseConfig.getChildText("startup_screen")).toUpperCase().equals("TRUE"))?true:false;
            this.default_language = eXML_DatabaseConfig.getChildText("default_language");
            this.user_directory = eXML_DatabaseConfig.getChildText("userdirectory");
            this.OS = System.getProperty("os.name"); 
           
    }
    catch(Exception e)
    {
        //TODO: change this to logging statement
        System.out.println(e); 
    }
  }
  
  public static boolean configFileTest(String configurationFile)
  {
       File f = new File(configurationFile);
       return (f.exists());
  }

  public void setInConsole(boolean cons) {
     this.inConsole = cons; 
  }
  
  public boolean getInConsole() {
     return this.inConsole; 
  }
   
  public String get_OS(){
       return this.OS; 
  }
  
  public String getdatabasetype(){
       return this.databasetype;
  }
  public String getdb_username(){
       return this.db_username;
  }
  public String getdb_password(){
       return this.db_password;
  }
  public String getdb_url(){
       return this.db_url;
  }
  public String getdb_force_unicode(){
       return db_force_unicode;
  }
  public String getdb_char_encoding(){
       return db_char_encoding;
  }
  public boolean getshow_startup_screen(){
       return this.show_startup_screen;
  }
  public String getdefault_language(){
       return this.default_language;
  }
  public String getuser_directory(){
       return user_directory;
  }

     
}