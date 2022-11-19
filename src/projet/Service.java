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

    public static boolean créerEtAjouterCompte(Scanner clavier) {
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
    public static boolean créerEtAjouterNouveauClient(Scanner clavier) {
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

    public boolean lierCompteAuClient (int idClient, int idCompte)
    {
        return true;
    }
    public static Compte chercherlCompte(Scanner clavier){
        Compte compte = new Compte();
        System.out.print("entrer id : ");
        int id=clavier.nextInt();
        for (int i=0;i<banque.nbrcp;i++)
        {
            if(banque.getCompte()[i].getIdCompte()==id)
            {
                System.out.println("found");
                compte=banque.getCompte()[i];
            }
        }

        return compte;

    }

    /**public static Compte chercherlCompte(Scanner clavier){
        Compte compte = new Compte();
        System.out.print("entrer id : ");
        int id=clavier.nextInt();
        for (int i=0;i<banque.nbrcp;i++)
        {
            if(banque.getCompte().equals(id)==false)
            {
                compte=banque.getCompte()[i];
            }
        }
        return compte;
    }
**/
    public static void consulterDétailCompte(Scanner clavier){
        Compte compte=new Compte();
        System.out.println("entrer l'id : ");
        int id = clavier.nextInt();
        for (int i=0;i<banque.nbrcp;i++)
        {
            if(banque.getCompte()[i].getIdCompte()==id)
            {
                compte=banque.getCompte()[i];
                System.out.println(compte);
            }

        }

    }

    public static void consulterDétailClient(Scanner clavier){
        Client client=new Client();
        System.out.println("entrer l'id : ");
        int id = clavier.nextInt();
        for (int i=0;i<banque.nbrcl;i++)
        {
            if(banque.getClient()[i].getIdClient()==id)
            {
                client=banque.getClient()[i];
                System.out.println(client);
            }

        }

    }


    public static void main(String[] args){
        int choice=-1;
        Scanner clavier=new Scanner(System.in);



        do {
            System.out.println("1.ajouter un compte : ");
            System.out.println("2.ajouter un client : ");
            System.out.println("3.chercher un compte ");
            System.out.println("4.consulter detail compte ");
            System.out.println("5.consulter detail client ");
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
                    System.out.println(chercherlCompte(clavier).toString());


                    break;

                case 4:
                    consulterDétailCompte(clavier);

                    break;
                case 5:
                    consulterDétailClient(clavier);

                    break;
            }
        }while (choice!=0);
    }

}
