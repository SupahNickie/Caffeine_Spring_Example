package main.java.portfolio.queries;

public class ProjectQueries {
	public static final String getIndexQuery() {
		return 	"select projects.*, " +
				"images.id as image_id, " +
				"images.url as image_url " +
				"from projects " +
				"left outer join images on projects.id = images.project_id " +
				"where images.is_hero_image = true";
	}

	public static final String getShowQuery() {
		return	"select projects.*, " +
				"json_agg((images.id, images.url)) as image_info " +
				"from projects " +
				"left outer join images on projects.id = images.project_id " +
				"where projects.id = $1 " +
				"group by projects.id";
	}
}