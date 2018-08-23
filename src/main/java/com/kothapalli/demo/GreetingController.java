package com.kothapalli.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class GreetingController {
	
	private final AtomicLong counter = new AtomicLong();
	@RequestMapping("/")
	public String home() {
		return "Welcome!";
	}
	
	@RequestMapping(method= RequestMethod.GET)
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting(counter.incrementAndGet(),String.format("Hello, %s", name));
	}

}
