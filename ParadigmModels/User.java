/*
     $Id: User.java,v 1.2 2011/05/31 18:38:52 joellimardo Exp $
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
package ParadigmModels;

public class User {
  /*  The original of this class allowed for the setting of permissions 
   * during the user definition stage. This isn't a bad idea, but in practice
   * most users actually fall into ROLES, and roles typically have LOTS of individual
   * configuration settings associated with them. In legacy systems users were forced
   * to actually copy an existing user rather than try and manually set a new
   * one up because this process was so complex and involved (if you missed
   * something it would take you quite a while to figure out why a screen
   * was not opening up, for instance).
   * 
   * Also, some laboratory people 
   * perform administration and mainly verify work. Others receive worksheets and
   * hit hit the benches. Still others may be assigned to perform equipment 
   * maintenance. Some users, depending on the lab, pull double or even
   * triple duty, so it is best to assign rights in blocks and not individually
   * based off of role.
   * 
   * Regarding permissions themselves, as a system grows, you cannot rely upon a single, static, set of CRUD 
   * (create, read, update, delete) permissions to cut the mustard. You will need
   * to be able to add as many as you want to handle additional modules that
   * will need to be added. In short, permissions cannot be inflexible, they
   * have to be configurable which means they probably should NOT be in 
   * the user class.
   */
}