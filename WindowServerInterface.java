package finals.finalprojectcs;
import javax.ejb.Stateful;
import java.util.Random;
@Stateful
public class WindowServerInterface implements WindowServer {
  private int mycount=0;
  public String getWindowStatus(String name) {
    // Check if the input is window ? Otherwise, call door server.

    if (name.toLowerCase().contains ("vip-window-1") || name.toLowerCase().contains ("vip-window-2") )
    {

      String status=" ";
      Random rand= new Random();
      // Generating a randam status to simulate the window state
      int windowStatus=rand.nextInt(4) + 1;
      switch(windowStatus){
        case 1:
          status ="Open";
          break;
        case 2:
          status ="Half Open";
          break;
        case 3:
          status ="Closed";
          break;
        case 4:
          status ="Closed and Locked";
          break;
      }
      // print the status of the window
      System.out.println(name + " is " + status);
      return (name + " is " + status);
    }
    return "Door Server is called";
  }

}
