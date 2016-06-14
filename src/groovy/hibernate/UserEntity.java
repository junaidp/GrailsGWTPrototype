package hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity

@Table(name="user")
public class UserEntity implements Serializable {

	public UserEntity(){}


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userId")
	private int userId;

	@Column(name="username")
	private String userName;

	@Column(name="password")
	private String password;

	@Column(name="name")
	private String name;

	@Column(name="email")
	private String email;

	@Column(name="status")
	private int status;

	@Temporal(TemporalType.DATE)
	@Column(name="tokenGeneratedDate")
	private Date tokenGeneratedDate;


	@Column(name="isAdmin")
	private boolean admin;

	@Column(name="token")
	private String token;

	@Transient
	private String userFetchStatus;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean isAdmin) {
		this.admin = isAdmin;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getTokenGeneratedDate() {
		return tokenGeneratedDate;
	}

	public void setTokenGeneratedDate(Date tokenGeneratedDate) {
		this.tokenGeneratedDate = tokenGeneratedDate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserFetchStatus() {
		return userFetchStatus;
	}

	public void setUserFetchStatus(String userFetchStatus) {
		this.userFetchStatus = userFetchStatus;
	}


}
