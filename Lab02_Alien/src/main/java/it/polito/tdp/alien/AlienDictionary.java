package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	//List<Word> dizionario;
	List<WordEnhanced> dizionario;
	
	public AlienDictionary() {
		dizionario= new ArrayList<WordEnhanced>();
	}
	
	public void resetDizionario() {
		dizionario.clear();
	}

	public void addWord(String alienWord, String translation) {

		//Word parola= new Word(alienWord,translation);
		WordEnhanced parola= new WordEnhanced(alienWord,translation);
		if(dizionario.contains(parola)) {
			dizionario.get(dizionario.indexOf(parola)).setTranslation(translation);
			return;
		}
		dizionario.add(parola);
		
		
	}
	
	public String translateWord(String alienWord) {
		WordEnhanced w= new WordEnhanced(alienWord);
		
		
			 if(dizionario.contains(w)) {
				return dizionario.get(dizionario.indexOf(w)).getTranslation();
			}
				
		return null;
		
	}

	


public String translateWordWildCard(String alienWildCard) {

	// Utilizzo le regual expression di Java (posso usare stringa.matches())
	// Sostituisco "?" con "."
	// "." nelle regex indica un qualsiasi carattere
	alienWildCard = alienWildCard.replaceAll("\\?", ".");

	int matchCounter = 0;
	StringBuilder sb = new StringBuilder();

	for (WordEnhanced w : dizionario) {
		if (w.compareWild(alienWildCard)) {
			matchCounter++;
			sb.append(w.getTranslation() + "\n");
		}
	}
	
	if (matchCounter != 0)
		return sb.toString();
	else
		return null;
}	
	
	
}
