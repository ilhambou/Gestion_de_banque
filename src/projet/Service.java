package projet;

import java.util.Scanner;


public class Service {

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


    public static Client addClient(Scanner clavier)
    {
        clavier = new Scanner(System.in);

            System.out.println("entrer le nom :");
            String nom=clavier.next();

            System.out.println("entrer le prenom :");
            String prenom=clavier.next();

            System.out.println("entrer email :");
            String email=clavier.next();
            Client client=new Client(nom,prenom,email);

        return client;
    }

    public static void afficher()
    {
        Client client[]= new Client[10];


        for (int i = 0; i < client.length; i++) {

            System.out.print(client[i]);

        }
    }



  /**  public boolean supprimerCompte(Scanner clavier)
    {
        Compte comptes[];
        Compte c = null;
        System.out.println("entrer le num de compte");
        int n = clavier.nextInt();
        for(int i=0;i<=comptes.lentgh;i++)
        {
            if(c.getIdCompte()==n)
            {
                comptes[i]=comptes[i+1];
            }
            i--;
        }
        return true;

    }
**/


    public static void main(String[] args){
        int choice=-1;
        Scanner clavier = new Scanner(System.in);



        do {
            System.out.println("1.ajouter des clients");
            System.out.println("2.consulter les clients");
            System.out.println("3.chercher un client ");
            System.out.println("4.supprimer un client ");
            System.out.println("0.exit");
            System.out.println("enter votre choix : ");
            choice=clavier.nextInt();
            switch (choice){
                case 1:

                   Client c=addClient(clavier);
                   System.out.println(c);






                    break;
                case 2:
                    afficher();


                    break;

                case 3:

                    break;

                case 4:

                    break;
            }
        }while (choice!=0);
    }

}
