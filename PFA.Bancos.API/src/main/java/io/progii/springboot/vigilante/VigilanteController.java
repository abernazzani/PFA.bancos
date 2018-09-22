package io.progii.springboot.vigilante;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VigilanteController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hi Guys, I'm Ready!";		
	}
}
