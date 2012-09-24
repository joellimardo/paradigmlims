package ParadigmExceptions;

public class BadInspector extends Exception {
  BadInspector (String reason) {
    // should log this as a potential security breach attempt
    super(reason);
       
  }
  
}
