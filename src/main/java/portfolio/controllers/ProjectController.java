package main.java.portfolio.controllers;

import java.util.List;
import java.util.Map;
import main.java.portfolio.models.Project;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import supahnickie.caffeine.Caffeine;
import supahnickie.caffeine.CaffeineObject;

@RestController
public class ProjectController {
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public List<CaffeineObject> index() throws Exception {
		CaffeineObject.setQueryClass(Project.class);
		return Caffeine.rawQuery("select * from projects");
	}

	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
	public CaffeineObject show(@PathVariable int projectId) throws Exception {
		return CaffeineObject.find(Project.class, projectId);
	}

	@RequestMapping(value = "/project", method = RequestMethod.POST)
	public Project create(@RequestBody Map<String, String> attrs) throws Exception {
		Project p = new Project();
		p.setName(attrs.get("name"));
		p.setDescription(attrs.get("description"));
		p.setDescriptionLong(attrs.get("description_long"));
		p.setUrl(attrs.get("url"));
		p.create();
		return p;
	}
	
	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.PUT)
	public Project update(@PathVariable int projectId, @RequestBody Map<String, Object> attrs) throws Exception {
		Project p = (Project) CaffeineObject.find(Project.class, projectId);
		p.update(attrs);
		return p;
	}
	
	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.DELETE)
	public Project delete(@PathVariable int projectId) throws Exception {
		Project p = (Project) CaffeineObject.find(Project.class, projectId);
		p.delete();
		return p;
	}
}