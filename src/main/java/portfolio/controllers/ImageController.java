package main.java.portfolio.controllers;

import java.util.Map;
import java.util.UUID;
import main.java.portfolio.models.Image;
import main.java.portfolio.services.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import supahnickie.caffeine.CaffeineObject;

@CrossOrigin
@RestController
public class ImageController {
	@RequestMapping(value = "/project/{projectId}/images", method = RequestMethod.POST)
	public Image create(@PathVariable int projectId, @RequestParam MultipartFile image) throws Exception {
		String s3Url = CloudStorage.init().convertAndUploadMultipartFile(projectId + "/pictures/" + UUID.randomUUID(), image);
		Image i = new Image();
		i.setProjectId(projectId);
		i.setUrl(s3Url);
		i.create();
		return i;
	}

	@RequestMapping(value = "/image/{imageId}", method = RequestMethod.PUT)
	public Image update(@PathVariable int imageId, @RequestBody Map<String, Object> attrs) throws Exception {
		Image i = (Image) CaffeineObject.find(Image.class, imageId);
		i.update(attrs);
		return i;
	}

	@RequestMapping(value = "/image/{imageId}", method = RequestMethod.DELETE)
	public Image delete(@PathVariable int imageId) throws Exception {
		Image i = (Image) CaffeineObject.find(Image.class, imageId);
		i.delete();
		return i;
	}
}