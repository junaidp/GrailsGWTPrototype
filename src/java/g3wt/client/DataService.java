package g3wt.client;

import com.google.gwt.user.client.rpc.RemoteService;


//import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
//@RemoteServiceRelativePath("rpc")
public interface DataService extends RemoteService {
    String helloWorld();
    String signIn(String userName, String password);
}
