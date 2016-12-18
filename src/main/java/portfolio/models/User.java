package main.java.portfolio.models;

import java.util.Map;
import java.util.HashMap;
import supahnickie.caffeine.CaffeineObject;

public class User extends CaffeineObject {
	@SuppressWarnings("rawtypes")
	public static Map<Class, String> caffeineAssociations = new HashMap<Class, String>();
	public static final String tableName = "users";

	static {
		caffeineAssociations.put(Project.class, "hasMany");
	}
	
	private int id;
	private String username;
	private String password;
	
	public User() throws Exception {
		init();
	}
	
	public boolean validate(String validationType) {
		return false;
	}
	
	public int getId() { return this.id; }
	public String getUsername() { return this.username; }
	public String getPassword() { return this.password; }
	
	public String toString() {
		return "ID: " + this.getId() + ", username: " + this.getUsername() + ", password: " + this.getPassword();
	}
}