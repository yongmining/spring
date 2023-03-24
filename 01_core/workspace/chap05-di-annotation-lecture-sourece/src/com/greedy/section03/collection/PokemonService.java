package com.greedy.section03.collection;

import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PokemonService {
	
//	private	List<Pokemon> pokemons;
//	
//	public PokemonService(List<Pokemon> pokemons) {
//		this.pokemons = pokemons;
//	}
//	
//	public void pokemonAttack() {
//		for(Pokemon pokemon : pokemons) {
//			pokemon.attack();
//		}
//	}
	
	private Map<String, Pokemon> pokemons;
	
	@Autowired
	public PokemonService(Map<String, Pokemon> pokemons) {
		this.pokemons = pokemons;
	}
	
	public void pokemonAttack() {
		Iterator<String> iter = pokemons.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key);
			pokemons.get(key).attack();
		}
	}

}
