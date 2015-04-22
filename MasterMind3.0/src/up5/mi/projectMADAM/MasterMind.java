package up5.mi.projectMADAM;

import java.util.ArrayList;
import java.util.Random;

public class MasterMind {
	private ArrayList<Character> cF = new ArrayList<Character>(); //Contient la combinaison finale g�n�r�e par l'ordinateur
	private boolean estBon;
	private char[] tCouleur = {'R','V','B','J','O','M','T','F'};//Rouge Vert Bleu Jaune Orange Marron Turquoise Fuschia
	
	public MasterMind(int nbCases, int nbCouleur){
		this.estBon = false;
		Random r =  new Random();
		
		//A FAIRE : ERREUR nbCouleur>tCouleur.size()
		//A FAIRE : ERREUR nbCases = 0
		//A FAIRE : ERREUR nbCases>nbCouleur
		
		//DEBUT G�n�ration de la combinaison finale
		do{
			int i = r.nextInt(nbCouleur);
			if(!this.cF.contains(this.tCouleur[i])){
				this.cF.add(this.tCouleur[i]);
			}
		}while(cF.size()<nbCases);
		//FIN G�n�ration de la combinaison finale
	}
	
	public void comparaison(String combinaison){ //Cette fonction compare une combinaison (propos�e par celui qui joue) � la r�ponse
		ArrayList<Character> cP = new ArrayList<Character>(); //Contiendra la combinaison propos�e

		//A FAIRE : ERREUR combinaison incorrecte (on part du principe que c'est un String, mais elle doit contenir des caract�res appartenant au tableau de couleurs
		
		//DEBUT Remplissage de cP
		for(int i=0;i<combinaison.length();i++){
			cP.add(combinaison.charAt(i));
		}
		//FIN Remplissage de cP
		
		int accB = 0, accM = 0; //Accumulateurs des bonnes et mauvaises couleurs
		
		//DEBUT Comparaison des cha�nes
		for(int j=0;j<cP.size();j++){
			if(cF.get(j)==cP.get(j)){
				accB++;
			}
			else{
				for(int k=0;k<cP.size();k++){
					if(cF.get(j)==cP.get(k)){
						accM++;
					}
				}
			}
		}
		//FIN Comparaison des cha�nes
		
		//DEBUT Confirmation de combinaison correcte 
		if((accB==cF.size())&&(accM==0)){
			this.estBon = true;
		}
		//FIN Confirmation de combinaison correcte
		
		//DEBUT Envoi de la r�ponse
		StringBuffer sb = new StringBuffer();
		while(accB>0){
			sb.append("x");
			accB--;
		}
		while(accM>0){
			sb.append("o");
			accM--;
		}
		System.out.print(sb.toString());
		//FIN Envoi de la r�ponse
		
	}
	
	public boolean getEstBon(){
		return this.estBon;
	}
	
}
