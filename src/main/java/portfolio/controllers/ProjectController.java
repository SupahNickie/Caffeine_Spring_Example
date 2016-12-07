package main.java.portfolio.controllers;

import main.java.portfolio.models.Project;
import supahnickie.caffeine.Caffeine;
import supahnickie.caffeine.CaffeineObject;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProjectController {
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public List<CaffeineObject> projectIndex() throws Exception {
		CaffeineObject.setQueryClass(Project.class);
		return Caffeine.executeQuery("select * from projects");
	}
	
	@RequestMapping(value = "/project", method = RequestMethod.POST)
	public Project projectCreate(@RequestBody Map<String, String> attrs) throws Exception {
		Project p = new Project();
		p.setName(attrs.get("name"));
		p.setDescription(attrs.get("description"));
		p.setDescriptionLong(attrs.get("description_long"));
		p.setUrl(attrs.get("url"));
		p.create();
		return p;
	}
	
	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.PUT)
	public Project projectUpdate(@PathVariable int projectId, @RequestBody Map<String, Object> attrs) throws Exception {
		Project p = (Project) CaffeineObject.find(Project.class, projectId);
		p.update(attrs);
		return p;
	}
	
	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.DELETE)
	public Project projectDelete(@PathVariable int projectId) throws Exception {
		Project p = (Project) CaffeineObject.find(Project.class, projectId);
		p.delete();
		return p;
	}
}