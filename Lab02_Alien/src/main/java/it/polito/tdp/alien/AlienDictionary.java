package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	List<Word> dizionario;
	
	public AlienDictionary() {
		dizionario= new ArrayList<Word>();
	}
	
	public void resetDizionario() {
		dizionario.clear();
	}

	public void addWord(String alienWord, String translation) {

		Word parola= new Word(alienWord,translation);
		if(dizionario.contains(parola)) {
			dizionario.get(dizionario.indexOf(parola)).setTranslation(translation);
			return;
		}
		dizionario.add(parola);
		
		
	}
	
	public String translateWord(String alienWord) {
		Word w= new Word(alienWord);
		
		
			 if(dizionario.contains(w)) {
				return dizionario.get(dizionario.indexOf(w)).getTranslation();
			}
				
		return null;
		
	}

	
	
	
	
}
