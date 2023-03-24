package com.greedy.section02.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PokemonService {
	
//	@Autowired
//	@Qualifier("squirtle")
	private Pokemon pokemon;
	
	public PokemonService(@Qualifier("charmander")Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	public void pokemonAttack() {
		pokemon.attack();
	}

}
