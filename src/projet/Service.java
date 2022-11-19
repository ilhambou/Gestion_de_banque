package projet;

import java.awt.*;
import java.util.Scanner;


public class Service {
    public static Banque banque=new Banque("banqueone","banque");

    public boolean verser(double montant, Compte c)
    {
        double solde = c.getSolde();
        solde=solde+montant;
        return true;

    }
    public boolean retirer(double montant, Compte c)
    {
        double solde = c.getSolde();
        solde=solde-montant;
        return true;
    }

    public static boolean créerEtAjouterCompte(Scanner clavier)
    {
        System.out.print("entrer le solde : ");
        double solde=clavier.nextDouble();
        Compte compte = new Compte(solde);

        if(banque.nbrcp<banque.getMaxCompte())
            {
                banque.getCompte()[banque.nbrcp]=compte;
                banque.nbrcp++;
                return true;
            }
        else
            {
                System.out.print("vous pouvez pas ajouter un compte");
                return false;
            }


    }

    public static boolean créerEtAjouterNouveauClient(Scanner clavier)
    {
        System.out.print("entrer le nom : ");
        String nom=clavier.next();
        System.out.print("entrer le prenom : ");
        String prenom=clavier.next();
        System.out.print("entrer l'email : ");
        String email=clavier.next();


        Client client = new Client(nom,prenom,email);

        if(banque.nbrcl<banque.getMaxClient())
        {
            banque.getClient()[banque.nbrcl]=client;
            banque.nbrcl++;
            return true;
        }
        else
        {
            System.out.print("vous pouvez pas ajouter un client");
            return false;
        }


    }




    public static void main(String[] args){
        int choice=-1;
        Scanner clavier=new Scanner(System.in);



        do {
            System.out.println("1.ajouter un compte : ");
            System.out.println("2.ajouter un client : ");
            System.out.println("3.chercher un client ");
            System.out.println("4.supprimer un client ");
            System.out.println("0.exit");
            System.out.println("enter votre choix : ");
            choice=clavier.nextInt();
            switch (choice){
                case 1:
                    créerEtAjouterCompte(clavier);


                    break;
                case 2:
                    créerEtAjouterNouveauClient(clavier);



                    break;

                case 3:

                    break;

                case 4:

                    break;
            }
        }while (choice!=0);
    }

}
