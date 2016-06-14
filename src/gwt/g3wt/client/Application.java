package g3wt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import g3wt.client.view.LoginView;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Application implements EntryPoint {
    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        System.out.println("in Data service1");
       DataServiceAsync myService = (DataServiceAsync) GWT.create(DataService.class);

        ServiceDefTarget endpoint = (ServiceDefTarget) myService;

        String moduleRelativeURL = GWT.getModuleBaseURL() + "rpc";
        endpoint.setServiceEntryPoint("http://localhost:8080/g3wt/gwt/g3wt.Application/rpc");
        System.out.println("in Data service2");
         RootPanel.get().add(new LoginView());

    }
}
