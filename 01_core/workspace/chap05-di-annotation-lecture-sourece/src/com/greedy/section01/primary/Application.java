package com.greedy.section01.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.greedy.section01.primary");
		
		PokemonService pokemonService = context.getBean("pokemonService", PokemonService.class);
		
		pokemonService.pokemonAttack();
	}

}
