package finals.finalprojectcs;
import javax.ejb.Remote;
@Remote
public interface WindowServer {
    // Interface for WindowServer, Define the function here

    public String getWindowStatus(String name);

}
