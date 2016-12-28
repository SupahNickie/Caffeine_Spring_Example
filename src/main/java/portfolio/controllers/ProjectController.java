package main.java.portfolio.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.java.portfolio.models.Project;
import main.java.portfolio.queries.ProjectQueries;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import supahnickie.caffeine.CaffeineConnection;
import supahnickie.caffeine.CaffeineObject;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProjectController {
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public List<HashMap<String, Object>> index() throws Exception {
		CaffeineObject.setQueryClass(Project.class);
		return CaffeineConnection.rawQuery(ProjectQueries.getIndexQuery());
	}

	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
	public List<HashMap<String, Object>> show(@PathVariable int projectId) throws Exception {
		return CaffeineConnection.rawQuery(ProjectQueries.getShowQuery(), projectId);
	}

	@RequestMapping(value = "/project", method = RequestMethod.POST)
	public Project create(@RequestBody Map<String, Object> attrs) throws Exception {
		Project p = new Project();
		p.setName((String)attrs.get("name"));
		p.setDescription((String)attrs.get("description"));
		p.setDescriptionLong((String)attrs.get("description_long"));
		p.setUrl((String)attrs.get("url"));
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