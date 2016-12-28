package main.java.portfolio.queries;

public class ImageQueries {
	public static String updateOtherImagesToNonHeroStatus() {
		return 	"update images " + 
				"set (is_hero_image) = (false) " +
				"where id <> $1 " + 
				"and project_id = $2";
	}
}