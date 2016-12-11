package main.java.portfolio.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashMap;
import java.util.Map;
import supahnickie.caffeine.CaffeineObject;

@JsonIgnoreProperties({ "validationErrors", "currentQuery", "firstCondition", "placeholders" })
public class Image extends CaffeineObject {
	@SuppressWarnings("rawtypes")
	public static Map<Class, String> caffeineAssociations = new HashMap<Class, String>();
	public static final String tableName = "projects";

	static {
		caffeineAssociations.put(Project.class, "belongsTo");
	}

	private int id;
	private int project_id;
	private String url;
	private boolean is_hero_image;

	public Image(int projectId, String url, boolean isHeroImage) {
		this.project_id = projectId;
		this.url = url;
		this.is_hero_image = isHeroImage;
	}

	public int getId() { return this.id; }
	public int getProjectId() { return this.project_id; }
	public String getUrl() { return this.url; }
	public boolean getIsHeroImage() { return this.is_hero_image; }

	public void setProjectId(int id) { this.project_id = id; }
	public void setUrl(String url) { this.url = url; }
	public void setIsHeroImage(boolean isHeroImage) { this.is_hero_image = isHeroImage; }

	public String toString() {
		return "ID: " + this.getId() + "; ProjectID: " + this.getProjectId() + "; URL: " + this.getUrl() + "; IsHeroImage: " + this.getIsHeroImage();
	}
}