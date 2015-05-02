package up5.mi.projectMADAM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MasterMind {
	private ArrayList<Character> cF = new ArrayList<Character>(); //Contient la combinaison finale générée par l'ordinateur
	private boolean estBon;
	private char[] tCouleur = {'R','V','B','J','O','M','T','F'};//Rouge Vert Bleu Jaune Orange Marron Turquoise Fuschia
	private char [][] matrice = new char [1680][];
	int count =0;


	public MasterMind(int nbCases, int nbCouleur){
		this.estBon = false;
		Random r =  new Random();

		//A FAIRE : ERREUR nbCouleur>tCouleur.size()
		//A FAIRE : ERREUR nbCases = 0
		//A FAIRE : ERREUR nbCases>nbCouleur

		//DEBUT Génération de la combinaison finale
		do{
			int i = r.nextInt(nbCouleur);
			if(!this.cF.contains(this.tCouleur[i])){
				this.cF.add(this.tCouleur[i]);
			}
		}while(cF.size()<nbCases);
		//FIN Génération de la combinaison finale
	}

	public void comparaison(String combinaison){ //Cette fonction compare une combinaison (proposée par celui qui joue) à la réponse
		ArrayList<Character> cP = new ArrayList<Character>(); //Contiendra la combinaison proposée

		//A FAIRE : ERREUR combinaison incorrecte (on part du principe que c'est un String, mais elle doit contenir des caractères appartenant au tableau de couleurs

		//DEBUT Remplissage de cP
		for(int i=0;i<combinaison.length();i++){
			cP.add(combinaison.charAt(i));
		}
		//FIN Remplissage de cP

		int accB = 0, accM = 0; //Accumulateurs des bonnes et mauvaises couleurs

		//DEBUT Comparaison des chaînes
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
		//FIN Comparaison des chaînes

		//DEBUT Confirmation de combinaison correcte 
		if((accB==cF.size())&&(accM==0)){
			this.estBon = true;
		}
		//FIN Confirmation de combinaison correcte

		//DEBUT Envoi de la réponse
		StringBuffer sb = new StringBuffer();
		while(accB>0){
			sb.append("x");
			accB--;
		}
		while(accM>0){
			sb.append("o");
			accM--;
		}
		System.out.println("Commentaire : "+sb.toString());
		//FIN Envoi de la réponse

	}


	//Fonction qui converti les ArrayList<Char> en String
	public String arrayToList(ArrayList<Character> comb)
	{    
		StringBuilder conteneur = new StringBuilder(comb.size());

		for(Character it: comb)
		{
			conteneur.append(it);
		}
		return conteneur.toString();
	}
	
	
	/**
	 * Fonction qui genere de facon itérative toute les combinaisons possible et s'arrete dès qu'il a trouvé la bonne
	 * @return
	 */
	public int proposition(){

		int accNb = 0;


		ArrayList<Character> IT = new ArrayList<Character>();
		IT.add(new Character('R'));
		IT.add(new Character('V'));
		IT.add(new Character('B'));
		IT.add(new Character('J'));
		if(arrayToList(cF).equals( arrayToList(IT))){
			this.estBon = true;
		}

		ArrayList<Character> IP = new ArrayList<Character>();
		for (int i =0;i<8;i++)
		{
			IP.add(tCouleur[i]);
		}

		

		for (int i=0, m=0; m<8 ; m=(m<8) ? m+1:m){

			

			for(int j =1, n=0; n<8; n=(n<8) ? n+1:n){

			

				for(int k = 2, o = 0; o<8; o=(o<8) ? o+1:o){


					
					for(int l = 3 ,p=0; p<8; p=(p<8) ? p+1:p){
						char [] nom = new char[4];


						//if(!IT.contains(tmp1)){
						//IT.set(i,IP.get(m));
						nom[0] = tCouleur[m];
						//}
						//if(!IT.contains(tmp2) ){
						//IT.set(j,IP.get(n));
						nom[1] = tCouleur[n];
						//}
						//if(!IT.contains(tmp3) ){
						//IT.set(k,IP.get(o));
						nom[2] = tCouleur[o];
						//}
						//if(!IT.contains(tmp4)){
						//IT.set(l,IP.get(p));
						nom[3] = tCouleur[p];
						//}
						//System.out.println(nom[0]+""+nom[1]+""+nom[2]+""+nom[3]+"");
						if(allDif(nom)&& (containts(nom))==false  ){
							matrice [count++]= nom;
							
							
						}

						accNb ++;
						//System.out.println(accNb);
						
						if(arrayToList(cF).compareTo(new String(nom))==0){
							this.estBon = true;
							System.out.println("La reponse est : "+new String(nom));
							return accNb;
						}
					}
				}

			}

		}

		return -1;
	}

	/**
	 * Fonction permettant de verifier qu'il n'y ait pas de doublon
	 * @param a, tableau contenant les valeurs de "nom"
	 * @return vrai si "a" est dans "matrice",faux sinon
	 */
	public boolean containts(char a[]){
		
		for(int i =0;i<count;i++){
			int val =0;
			for(int j =0;j<4;j++){
				
				if(matrice[i][j] == a[j]){
					val++;
				}
				
				if(j == 3 && val ==4){

					return true;
				}
			}

		}
		return false;
	}
	/**
	 * Fonction vérifiant qu'il n'y ait pas deux fois la même lettre dans le mot
	 * @param a, tableau contenant les valeurs de "nom"
	 * @return faux si il y a deja une lettre identique dans le mot,vrai sinon
	 */
	public boolean allDif(char a[]){

		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(j!=i && a[i]==a[j]){
					//System.out.println(a[0]+""+a[1]+""+a[2]+""+a[3]);
					return false;
				}
			}
		}
		
		return true;
	}

	public boolean getEstBon(){
		return this.estBon;
	}
	public void printCF(){
		System.out.print(this.cF.toString());
	}

}