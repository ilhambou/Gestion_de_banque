package projet;


import java.util.regex.Pattern;

public class Client {
    private int idClient;
    private String nom ;
    private String prenom;
    private String email;
    private Compte[] compte = new Compte[2];

    public static int count=1;

    // Constructeurs

    public Client(){}
    public Client(String nom,String prenom, String email)
    {
        this.idClient=count++;
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;

    }

    //getters

    public int getIdClient() {
        //this.idClient = count++;
        return idClient;

    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getEmail() {
        return email;
    }

    public Compte[] getCompte() {
        return compte;
    }
    //setters

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        boolean resultat=isValid(email);
        if(resultat==true)
        {
            this.email = email;
        }
        else
        {
            System.out.println("invalid email");
        }

    }

    public void setCompte(Compte[] compte) {
        this.compte = compte;
    }

    //ToString

    @Override
    public String toString() {
        return "id: "+idClient +" nom: "+nom+" prenom: "+prenom+" email: "+email;

    }

    //Equal

    @Override
    public boolean equals(Object other) {
        if(other instanceof Client)
            return  false;
        Client o= (Client) other;
        if (this.getIdClient()==o.getIdClient())
            return true;
        else return false;
    }

    public static boolean isValid(String email)
    {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        if (email == null)
            return false;
        return pattern.matcher(email).matches();
    }



}
