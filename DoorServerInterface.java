package finals.finalprojectcs;
import javax.ejb.Stateful;
import java.util.Random;
@Stateful
public class DoorServerInterface implements DoorServer {

  private int mycount=0;
  public String getDoorStatus(String name) {
    // Check if the input is door? Otherwise, call window server.
    if (name.toLowerCase().contains ("rec-door") || name.toLowerCase().contains ("vip-door") )
    {

      String status=" ";
      Random rand= new Random();
      // Generating a randam status to simulate the door state
      int doorStatus=rand.nextInt(3) + 1;
      switch(doorStatus){
        case 1:
          status ="Open";
          break;
        case 2:
          status ="Closed but not Locked";
          break;
        case 3:
          status ="Closed and Locked";
          break;
      }
      // print the status of the door
      System.out.println(name + " is " + status);
      return (name + " is " + status);
    }

    return "Window Server is called";
  }


}
