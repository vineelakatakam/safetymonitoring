package finals.finalprojectcs;
import javax.ejb.Remote;
@Remote
public interface DoorServer {
    // Interface for DoorServer, Define the function here
    public String getDoorStatus(String name);
}
