
public class GestionMagasin{

	/**
	* Fonction affichant le menu offert pour ce programme. Cette fonction a été implantée afin de
	* raccourcir la fonction main et ainsi clarifier le code
	* @return void
	*/
	public static void menu(){
		System.out.println("Choisissez parmi les options suivantes:");
		System.out.println("n : ajout d'un nouveau produit");
		System.out.println("f : afficher le nom d'un produit selon son numéro d'identification");
		System.out.println("d : effacer un produit de l'inventaire");
		System.out.println("q : quitter");
	}

	/**
	* Fonction appelée lorsque l'option 'n' (nouveau produit) du menu est choisie. Puisque plusieurs lignes
	* de code étaient associées à cette option, cela simplifiait et clarifiait le main de faire une fonction
	* pour cette option. 
	* @param mag , le magasin dans lequel on insérera le nouveau produit
	* @return void
	*/
	public static void creerNouveauProduit(Magasin mag){
		String nomProduit;
		int idProduit;
		float prixProduit;
		
		System.out.print("Entrez le nom d'un nouveau produit: ");
		nomProduit = Keyboard.readString();

		System.out.print("Entrez le numéro d'identification du produit: ");
		idProduit = Keyboard.readInt();
		
		System.out.print("Entrez le prix du produit : ");
		prixProduit = Keyboard.readFloat();
		boolean ajout = mag.ajouterProduit(nomProduit, prixProduit, idProduit);
		//si l'inventaire du magasin est plein ou si le produit existe déjà, il ne sera
		//pas ajouté au magasin et on affiche un message d'erreur
		if(!ajout)
			System.out.println("Impossible de créer le nouveau produit "+nomProduit);
		else{
			System.out.println("Produit ajouté ");
			System.out.println("*************************");
			System.out.println("Voici l'inventaire du magasin");
			System.out.println(mag);
			System.out.println("*************************\n\n\n");
		}
		
	
	}
	/**
	* Fonction main gérant le menu, et l'exécution de chacune des options de ce dernier
	* @param args, les arguments à la ligne de commande (non utilisés pour ce programme)
	* @return void
	*/
	public static void main(String[] args)
	{
		//création d'un nouveau magasin
		Magasin mag = new Magasin("Dollarama", 500);
		
		char choix = 'n';
		int id;
		String nom;
		boolean ok;

		//on demande d'ajouter des nouveaux produits, jusqu'à ce que l'usager tape: "fin"
		while(choix != 'q'){
			menu();
			System.out.print("Votre choix: ");
			choix = Keyboard.readString().charAt(0);
			switch(choix){
				case 'n'://nouveau produit
					creerNouveauProduit(mag);
				break;
				case 'f'://trouve un produit selon son id et imprime son nom
					System.out.print("Entrez le numéro d'identification du produit: ");
					id = Keyboard.readInt();
					nom = mag.getNomProduit(id);
					if(nom.length() == 0)
						System.out.println("Produit introuvable");
					else
						System.out.println("Le nom du produit: " + nom);
				break;
				case 'd': //retire un produit du magasin, selon son numéro d'identification
					System.out.print("Entrez le numéro d'identification du produit à retirer: ");
					id = Keyboard.readInt();;
					ok = mag.enleverProduit(id);
					if(ok)
						System.out.println("Le produit a été retiré");
					else
						System.out.println("Produit introuvable");
					System.out.println("Le magasin: ");
					System.out.println(mag);
					
				break;
				case 'q'://le programme se terminera
				break;
				default:
					System.out.println("Option invalide");
			}
		}
	}
}
