package main.java.portfolio.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;
import java.util.HashMap;
import supahnickie.caffeine.CaffeineObject;

@JsonIgnoreProperties({ "validationErrors", "currentQuery", "firstCondition", "placeholders" })
public class Project extends CaffeineObject {
	@SuppressWarnings("rawtypes")
	public static Map<Class, String> caffeineAssociations = new HashMap<Class, String>();
	public static final String tableName = "projects";
	
	static {
		caffeineAssociations.put(User.class, "belongsTo");
	}
	
	private int id;
	private String name;
	private String description;
	private String description_long;
	private String url;
	
	public Project() { }
	
	public boolean validate(String validationType) {
		if (this.name == null) return false;
		if (this.description == null) return false;
		if (this.description_long == null) return false;
		if (this.url == null) return false;
		return true;
	}
	
	public int getId() { return this.id; }
	public String getName() { return this.name; }
	public String getDescription() { return this.description; }
	public String getDescriptionLong() { return this.description_long; }
	public String getUrl() { return this.url; }
	
	public Project setName(String name) { this.name = name; return this; }
	public Project setDescription(String description) { this.description = description; return this; }
	public Project setDescriptionLong(String descriptionLong) { this.description_long = descriptionLong; return this; }
	public Project setUrl(String url) { this.url = url; return this; }
	
	public String toString() {
		return "ID: " + this.getId() + ", name: " + this.getName() + ", description: " + this.getDescription() + ", description_long: " + this.getDescriptionLong() + ", url: " + this.getUrl();
	}
}