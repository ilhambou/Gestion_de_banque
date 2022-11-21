package projet;

import java.awt.*;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Service {

    public static Banque banque=new Banque("banqueone","banque");

    /**--------------------------------------------------------------------------------------------------**/

    public static boolean verser(double montant, Compte c){
        for(int i=0;i<banque.nbrcp;i++)
        {
            banque.getCompte()[i].setSolde(c.getSolde()+montant);

        }

        return true;

    }
    public static boolean retirer(double montant, Compte c){
        for(int i=0;i<banque.nbrcp;i++)
        {
            banque.getCompte()[i].setSolde(c.getSolde()-montant);

        }

        return true;
    }
    public static boolean virement(double montant, Compte src, Compte des){
        for(int i=0;i<banque.nbrcp;i++)
        {
            banque.getCompte()[i].setSolde(des.getSolde()+montant);
            banque.getCompte()[i].setSolde(src.getSolde()-montant);

        }
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
            System.out.println("ajout avec succes");
            return true;
        }
        else
        {
            System.out.println("vous pouvez pas ajouter un compte");
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
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        if(pattern.matcher(email).matches()==false)
        {
            System.out.println("invalid email");
            return false;
        }
        else
        {
            Client client = new Client(nom,prenom,email);

            if(banque.nbrcl<banque.getMaxClient())
            {
                banque.getClient()[banque.nbrcl]=client;
                banque.nbrcl++;
                System.out.println("ajout avec succes");
                return true;
            }
            else
            {
                System.out.println("vous pouvez pas ajouter un client");
                return false;
            }

        }



    }

    /**-------------------------------------------------lier---------------------------------------------------**/

    public static boolean lierCompteAuClient(int idClient, int idCompte) {
        int x = 0;
        int y=0;

        for(int i=0;i<banque.nbrcp;i++)
        {
            if(banque.getCompte()[i].getIdCompte()==idCompte)
            {
                x=i;
            }
        }
        for(int j=0;j<banque.nbrcl;j++)
        {
            if(banque.getClient()[j].getIdClient()==idClient)
            {
                y=j;
            }
        }
        if(banque.getCompte()[x].getClient()==null)
        {

            banque.getCompte()[x].setClient(banque.getClient()[y]);
        }
        else
        {
            System.out.println("impossible");
        }




        return true;
    }

    /**------------------------------------------------recherche-----------------------------------------------**/
    public static Compte chercherlCompte(Scanner clavier){
        Compte compte = new Compte();
        System.out.print("entrer id : ");
        int id=clavier.nextInt();
        compte=null;
        for (int i=0;i<banque.nbrcp;i++)
        {
            if(banque.getCompte()[i].getIdCompte()==id)
            {
                compte=banque.getCompte()[i];
            }

        }

        return compte;

    }

    public static Client chercherlClient(Scanner clavier){
        Client client = new Client();
        System.out.print("entrer id : ");
        int id=clavier.nextInt();
        client=null;
        for (int i=0;i<banque.nbrcl;i++)
        {
            if(banque.getClient()[i].getIdClient()==id)
            {
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
        System.out.print("entrer l'id : ");
        int id = clavier.nextInt();
        int x=0;
        for (int i=0;i<banque.nbrcp;i++)
        {
            if(banque.getCompte()[i].getIdCompte()==id)
            {
                compte=banque.getCompte()[i];
                System.out.println(compte);
                x=1;
            }
        }
        if(x==0)
        {
            System.out.println("compte n'existe pas");
        }

    }

    public static void consulterDétailClient(Scanner clavier){
        Client client=new Client();
        System.out.print("entrer l'id : ");
        int id = clavier.nextInt();
        int x=0;
        for (int i=0;i<banque.nbrcl;i++)
        {
            if(banque.getClient()[i].getIdClient()==id)
            {
                client=banque.getClient()[i];
                System.out.println(client);
                x=1;
            }


        }
        if(x==0)
        {
            System.out.println("client n'existe pas");
        }

    }


    /**----------------------------------------------modification----------------------------------------------**/

    public static boolean modifierCompte(Scanner clavier){
        System.out.print("entrer l'id: ");
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
        System.out.print("entrer l'id: ");
        int id=clavier.nextInt();
        for(int i=0;i<banque.nbrcl;i++)
        {
            if(banque.getClient()[i].getIdClient()==id)
            {

                int c =-1;
                do{
                    System.out.println("--------------------");
                    System.out.println("       1. nom");
                    System.out.println("       2. prenom");
                    System.out.println("       3. email");
                    System.out.println("-------------------");
                    System.out.println("       0. exit");
                    System.out.println("-------------------");
                    System.out.print("enter votre choix : ");
                    c=clavier.nextInt();
                    switch (c)
                    {
                        case 1:{
                            System.out.print("enter le nom : ");
                            String nom = clavier.next();
                            banque.getClient()[i].setNom(nom);

                            break;
                        }
                        case 2:
                        {
                            System.out.print("enter le prenom : ");
                            String prenom = clavier.next();
                            banque.getClient()[i].setPrenom(prenom);
                            break;
                        }
                        case 3:{
                            System.out.print("enter l'email : ");
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


/**---------------------------------------------------- afficher tt --------------------------------------------**/


    public static void afficherCompte() {
        for(int i=0;i<banque.nbrcp;i++)
        {
            System.out.println(banque.getCompte()[i].toString());
        }
    }

    public static void afficherClient() {
        for(int i=0;i<banque.nbrcl;i++)
        {
            System.out.println(banque.getClient()[i].toString());
        }
    }


    /**-----------------------------------------------------Main------------------------------------------------**/

    public static void main(String[] args){
        int choice=-1;
        Scanner clavier=new Scanner(System.in);

        do {
            System.out.println("--------------------------------------------------------- ");
            System.out.println("                 1. ajouter un compte  ");
            System.out.println("                 2. ajouter un client  ");
            System.out.println("                 3. chercher un compte ");
            System.out.println("                 4. chercher un client ");
            System.out.println("                 5. consulter detail compte ");
            System.out.println("                 6. consulter detail client ");
            System.out.println("                 7. modifier compte ");
            System.out.println("                 8. modifier client ");
            System.out.println("                 9. supprimer compte ");
            System.out.println("                 10. supprimer client ");
            System.out.println("--------------------------------------------------------- ");
            System.out.println("                 11. verser ");
            System.out.println("                 12. retirer  ");
            System.out.println("                 13. virement  ");
            System.out.println("--------------------------------------------------------- ");
            System.out.println("                 14. consulter tt les comptes  ");
            System.out.println("                 15. consulter tt les clients  ");
            System.out.println("                 15. lier le compte au client  ");
            System.out.println("--------------------------------------------------------- ");
            System.out.println("                 0. exit");
            System.out.println("--------------------------------------------------------- ");
            System.out.print("-> enter votre choix : ");
            choice=clavier.nextInt();
            switch (choice){
                case 1:
                    créerEtAjouterCompte(clavier);


                    break;
                case 2:
                    créerEtAjouterNouveauClient(clavier);

                    break;

                case 3:
                    Compte comp=chercherlCompte(clavier);
                    if(comp==null)
                    {
                        System.out.println("compte n'existe pas");

                    }
                    else
                    {
                        System.out.println("compte existe");

                    }

                    break;

                case 4:
                    Client cli=chercherlClient(clavier);
                    if(cli==null)
                    {
                        System.out.println("client n'existe pas");

                    }
                    else
                    {
                        System.out.println("client existe");

                    }

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
                case 11:
                    System.out.print("enter le montant : ");
                    double montant = clavier.nextDouble();
                    Compte c=chercherlCompte(clavier);
                    verser(montant,c);


                    break;
                case 12:
                    System.out.print("enter le montant : ");
                    double montant_ret = clavier.nextDouble();
                    Compte c_ret=chercherlCompte(clavier);
                    retirer(montant_ret,c_ret);


                    break;
                case 13:

                    System.out.print("(src) ");
                    Compte src=chercherlCompte(clavier);
                    System.out.print("(des) ");
                    Compte des=chercherlCompte(clavier);
                    System.out.print("enter le montant : ");
                    double montant_ver = clavier.nextDouble();
                    virement(montant_ver, src, des);


                    break;
                case 14:
                {
                    afficherCompte();
                    break;
                }
                case 15:
                {
                    afficherClient();
                }
                case 16:
                {
                    System.out.print("entrer l'id du compte: ");
                    int idCompte=clavier.nextInt();
                    System.out.print("entrer l'id du client: ");
                    int idClient=clavier.nextInt();
                    lierCompteAuClient(idClient,idCompte);
                }
            }
        }while (choice!=0);
    }

}
