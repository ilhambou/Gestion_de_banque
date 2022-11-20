package projet;

import java.awt.*;
import java.util.Scanner;


public class Service {
    public static Banque banque=new Banque("banqueone","banque");

    /**--------------------------------------------------------------------------------------------------**/

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

    /** -------------------------------------------------ajout-----------------------------------------------**/

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

    /**-------------------------------------------------lier---------------------------------------------------**/

    public boolean lierCompteAuClient (int idClient, int idCompte)
    {
        return true;
    }

    /**------------------------------------------------recherche-----------------------------------------------**/
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

    public static Client chercherlClient(Scanner clavier){
        Client client = new Client();
        System.out.print("entrer id : ");
        int id=clavier.nextInt();
        for (int i=0;i<banque.nbrcl;i++)
        {
            if(banque.getClient()[i].getIdClient()==id)
            {
                System.out.println("found");
                client=banque.getClient()[i];
            }
        }

        return client;

    }


/**
      public static Compte chercherlCompte(Scanner clavier){
      Compte compte = new Compte();
      System.out.print("entrer id : ");
      int id=clavier.nextInt();
      for (int i=0;i<banque.nbrcp;i++)
      {
      if(banque.getCompte().equals(id)==true)
      {
      compte=banque.getCompte()[i];
      }
      }
      return compte;
      }
**/

    /**public static Client chercherlClient(Scanner clavier){
        Client client = new Client();
        System.out.print("entrer id : ");
        int id=clavier.nextInt();
        for (int i=0;i<banque.nbrcl;i++)
        {
            if(banque.getClient().equals(id)==false)
            {
                client=banque.getClient()[i];
            }
        }
        return client;
    }**/

    /**------------------------------------------------affichage-----------------------------------------------**/
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


    /**----------------------------------------------modification----------------------------------------------**/

    public static boolean modifierCompte(Scanner clavier){
        System.out.print("entrer l'id");
        int id=clavier.nextInt();
        for(int i=0;i<banque.nbrcp;i++)
        {
            if(banque.getCompte()[i].getIdCompte()==id)
            {
                System.out.print("entrer le solde : ");
                double solde=clavier.nextDouble();
                banque.getCompte()[i].setSolde(solde);
            }
        }
        return true;
    }

    public static boolean modifierClient(Scanner clavier){
        System.out.print("entrer l'id : ");
        int id=clavier.nextInt();
        for(int i=0;i<banque.nbrcl;i++)
        {
            if(banque.getClient()[i].getIdClient()==id)
            {
                System.out.println("vous voulez supp quoi ?");
                int c =-1;
                do{
                    System.out.println("1.nom");
                    System.out.println("2.prenom");
                    System.out.println("3.email");
                    System.out.println("0.exit");
                    System.out.println("enter votre choix : ");
                    c=clavier.nextInt();
                    switch (c)
                    {
                        case 1:{
                            System.out.println("enter le nom : ");
                            String nom = clavier.next();
                            banque.getClient()[i].setNom(nom);

                            break;
                        }
                        case 2:
                        {
                            System.out.println("enter le prenom : ");
                            String prenom = clavier.next();
                            banque.getClient()[i].setPrenom(prenom);
                            break;
                        }
                        case 3:{
                            System.out.println("enter l'email : ");
                            String email = clavier.next();
                            banque.getClient()[i].setEmail(email);

                            break;
                        }
                    }


                } while (c!=0);


            }
        }
        return true;
    }


/**-----------------------------------------------------supprimer-----------------------------------------------**/


    public static boolean supprimerCompte(Scanner clavier) {
        System.out.print("entrer l'id : ");
        int id=clavier.nextInt();
        for(int i=0;i<banque.nbrcp;i++)
        {
            if(banque.getCompte()[i].getIdCompte()==id)
            {
                for(int j=i;i<banque.nbrcp;i++)
                {
                    banque.getCompte()[j]=banque.getCompte()[j+1];
                }
                banque.nbrcp--;
            }
        }
        return true;
    }

    public static boolean supprimerClient(Scanner clavier) {
        System.out.print("entrer l'id : ");
        int id=clavier.nextInt();
        for(int i=0;i<banque.nbrcl;i++)
        {
            if(banque.getClient()[i].getIdClient()==id)
            {
                for(int j=i;i<banque.nbrcl;i++)
                {
                    banque.getClient()[j]=banque.getClient()[j+1];
                }
                banque.nbrcl--;
            }
        }
        return true;
    }




    public static void main(String[] args){
        int choice=-1;
        Scanner clavier=new Scanner(System.in);

        do {
            System.out.println("1.ajouter un compte : ");
            System.out.println("2.ajouter un client : ");
            System.out.println("3.chercher un compte ");
            System.out.println("4.chercher un client ");
            System.out.println("5.consulter detail compte ");
            System.out.println("6.consulter detail client ");
            System.out.println("7.modifier compte ");
            System.out.println("8.modifier client ");
            System.out.println("9.supprimer compte ");
            System.out.println("10.supprimer client ");
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
                    System.out.println(chercherlClient(clavier).toString());

                    break;
                case 5:
                    consulterDétailCompte(clavier);


                    break;
                case 6:
                    consulterDétailClient(clavier);

                    break;
                case 7:
                    modifierCompte(clavier);


                    break;
                case 8:
                    modifierClient(clavier);

                    break;
                case 9:
                    supprimerCompte(clavier);


                    break;
                case 10:
                    supprimerClient(clavier);

                    break;
            }
        }while (choice!=0);
    }

}
