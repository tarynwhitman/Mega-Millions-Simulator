package com.example.megaMillions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@SpringBootApplication
@RestController
public class MegaMillionsApplication {

	public static void main(String[] args) {

		SpringApplication.run(MegaMillionsApplication.class, args);
	}

//	@GetMapping("/hello")
//	public ArrayList hello(){
//		ArrayList array = new ArrayList();
//		array.add(1);
//		array.add(2);
//		array.add(3);
//		array.add(2);
//		array.add(2);
//		return array;
//	}
}
