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

package com.limsexpert.paradigmlims.config;

import java.io.*;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.Document;

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
  private String default_language;
  private String user_directory;
  private String OS;   
  private boolean inConsole = false;
  private String logDirectory;
  private int diskSizeLimit;
  
  /** The default location for the configuration file is 
    * ./lib/connect.xml under the installation. Use a different 
    * constructor to specify a different one.
    * */
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
  

  public paradigmConfig(){
    this(paradigmConfig.staticFilePath());
  }
  
  public paradigmConfig(String xmlConfigFile)
  {
            // borrowed from MySQLDBAdapter (from the GNU GPL'd freelims project
    try {
            Document doc = new SAXBuilder().build(xmlConfigFile);
            Element eXML_DatabaseConfig = doc.getRootElement();
            this.databasetype = eXML_DatabaseConfig.getChildText("databasetype");
            this.db_username = eXML_DatabaseConfig.getChildText("userid"); 
            this.db_url = eXML_DatabaseConfig.getChildText("URL");
            this.db_force_unicode = eXML_DatabaseConfig.getChildText("force_unicode");
            this.db_char_encoding = eXML_DatabaseConfig.getChildText("character_encoding");
            this.default_language = eXML_DatabaseConfig.getChildText("default_language");
            this.user_directory = eXML_DatabaseConfig.getChildText("userdirectory");
            this.OS = System.getProperty("os.name"); 
            this.diskSizeLimit = Integer.parseInt(eXML_DatabaseConfig.getChildText("diskWarningSizeLimit"));
            this.logDirectory = eXML_DatabaseConfig.getChildText("logDirectory");
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
  
  /**
   * This asks Java what OS you're in
   * */
  public String get_OS(){
       return this.OS; 
  }
  
  public String getDatabaseType(){
       return this.databasetype;
  }
  public String getDBUsername(){
       return this.db_username;
  }
  public String getDBPassword(){
       return this.db_password;
  }
  public String getDBUrl(){
       return this.db_url;
  }
  public String getDBForceUnicode(){
       return db_force_unicode;
  }
  public String getDBCharEncoding(){
       return db_char_encoding;
  }
  public String getDefaultLanguage(){
       return this.default_language;
  }
  public String getUserDirectory(){
       return user_directory;
  }
  public int diskWarningLimit(){
       return this.diskSizeLimit;   
  }
  public String getLogDirectory(){
       return this.logDirectory; 
  }
     
}