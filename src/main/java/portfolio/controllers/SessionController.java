package main.java.portfolio.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SessionController {

	@RequestMapping(value = "/sessions", method = RequestMethod.POST)
	public Map<String, String> authorize(@RequestBody Map<String, Object> args) throws Exception {
		if (args.get("password") != null && args.get("password").equals(System.getenv("PORTFOLIO_AUTHORIZATION_KEY"))) {
			Map<String, String> ret = new HashMap<String, String>();
			ret.put("secret", System.getenv("PORTFOLIO_AUTHORIZATION_SECRET"));
			return ret;
		} else {
			return null;
		}
	}
}