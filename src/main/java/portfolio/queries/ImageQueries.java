package main.java.portfolio.queries;

public class ImageQueries {
	public static String updateOtherImagesToNonHeroStatus() {
		return 	"update images " + 
				"set (is_hero_image) = (false) " +
				"where id is not $1 " + 
				"and project_id is $2";
	}
}