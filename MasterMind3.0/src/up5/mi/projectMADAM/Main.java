package up5.mi.projectMADAM;

import java.util.Scanner;

public class Main {
	//A FAIRE : Classe Main
	public static void main(String args[]){
		MasterMind mm = new MasterMind(4,8);
		int nbCoups = 0;
		System.out.println("Jeu du Mastermind, entrez une combinaison de 4 lettres parmi {'R','V','B','J','O','M','T','F'}");
		
		do{
			Scanner sc = new Scanner(System.in);
			nbCoups++;
			String s = sc.nextLine();
			if(s.equals("0")){
				mm.printCF();
			}
			else{
				mm.comparaison(s);
			}
		}while(!mm.getEstBon());
		
		System.out.print("La réponse était : ");
		mm.printCF();
		System.out.println(" ");
		System.out.println("Vous l'avez découverte en "+nbCoups+" coups.");
	}
	
}
