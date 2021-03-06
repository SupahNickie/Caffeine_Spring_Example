package main.java.portfolio.queries;

public class ProjectQueries {
	public static final String getIndexQuery() {
		return 	"with img as " +
				"(select images.project_id as image_project_id, " +
				"images.id as image_id, " + 
				"images.url as image_url " +
				"from images where images.is_hero_image = true) " +
				"select projects.*, img.image_id, img.image_url " +
				"from projects left join img on img.image_project_id = projects.id " +
				"order by projects.id asc";
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