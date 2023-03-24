package com.greedy.section03.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.greedy.section03.collection");
		
		PokemonService pokemonService = context.getBean("pokemonService", PokemonService.class);
		
		pokemonService.pokemonAttack();
	}

}
