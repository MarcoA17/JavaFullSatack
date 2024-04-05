package com.upa.codigorupestre;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class HelloWorldAPI {

	@Autowired
	private HelloWorldRepository helloWorldRepository;

	@GetMapping("/hello/{name}/{age}")
	public String hello(@PathVariable String name, @PathVariable Integer age) {

		HellowEntity entity = new HellowEntity();
		entity.setName(name);
		entity.setAge(age);
		String welcomeMes = "Welcome: " + name + " Age: " + age + " : " + LocalDateTime.now();
		entity.setMsj(welcomeMes);

		helloWorldRepository.save(entity);
		return welcomeMes;

	}

}
