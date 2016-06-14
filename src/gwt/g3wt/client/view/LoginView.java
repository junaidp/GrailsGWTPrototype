package g3wt.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import g3wt.client.DataService;
import g3wt.client.DataServiceAsync;

public class LoginView extends Composite  {

	private static LoginViewUiBinder uiBinder = GWT
			.create(LoginViewUiBinder.class);
	

	interface LoginViewUiBinder extends UiBinder<Widget, LoginView> {
	}
	
	@UiField TextBox txtUserName;
	@UiField PasswordTextBox txtPassword;
	@UiField Button btnSubmit;
	@UiField Label lblError;
	@UiField Anchor btnForgotPassword;
	@UiField Anchor btnForgotUsername;
	
	
	public LoginView() {
		initWidget(uiBinder.createAndBindUi(this));
		txtUserName.getElement().setPropertyString("placeholder", "Enter username");
		txtPassword.getElement().setPropertyString("placeholder", "Enter password");



		btnSubmit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				signIn();
			}
		});



	}

	private void signIn() {

		DataServiceAsync myService = (DataServiceAsync) GWT.create(DataService.class);

		ServiceDefTarget endpoint = (ServiceDefTarget) myService;
		String moduleRelativeURL = GWT.getModuleBaseURL() + "rpc";
		endpoint.setServiceEntryPoint("http://localhost:8080/g3wt/gwt/g3wt.Application/rpc");

		lblError.setText("");
		final String username = txtUserName.getText();
		//		final LoadingPopup loadingPopup = new LoadingPopup();
		btnSubmit.addStyleName("loading-pulse");

		myService.signIn(txtUserName.getText(), txtPassword.getText(), new AsyncCallback<String>() {
					public void onSuccess(String result) {
						if(result == null){
							lblError.setText("username password does not match");
						}else {
							Window.alert(result + "Signed in");

						}
						btnSubmit.removeStyleName("loading-pulse");
					}

					public void onFailure(Throwable caught) {
						Window.alert(caught.getLocalizedMessage());
						btnSubmit.removeStyleName("loading-pulse");
					}



				}
		);
	}

	public TextBox getTxtUserName() {
		return txtUserName;
	}


	public void setTxtUserName(TextBox txtUserName) {
		this.txtUserName = txtUserName;
	}


	public PasswordTextBox getTxtPassword() {
		return txtPassword;
	}


	public void setTxtPassword(PasswordTextBox txtPassword) {
		this.txtPassword = txtPassword;
	}

	public Button getBtnSubmit() {
		return btnSubmit;
	}

	public void setBtnSubmit(Button btnSubmit) {
		this.btnSubmit = btnSubmit;
	}

	
	public Label getLblError() {
		return lblError;
	}

	public Anchor getBtnForgotPassword() {
		return btnForgotPassword;
	}

	public Anchor getBtnForgotUsername() {
		return btnForgotUsername;
	}



}
