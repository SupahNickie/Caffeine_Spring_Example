package main.java.portfolio.queries;

public class ImageQueries {
	public static String getIndexQuery() {
		return "select * from images where project_id = $1";
	}
	
	public static String updateOtherImagesToNonHeroStatus() {
		return 	"update images " + 
				"set (is_hero_image) = (false) " +
				"where id <> $1 " + 
				"and project_id = $2";
	}
}