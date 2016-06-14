package g3wt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DataServiceAsync {
    void helloWorld(AsyncCallback callback);
    void signIn(String userName, String password, AsyncCallback<String> callback);
}
