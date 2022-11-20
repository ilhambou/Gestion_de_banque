package projet;

import java.util.regex.Pattern;

public class Banque {
    private int idBanque;
    private String nom;
    private String email;
    private final int maxCompte=2;
    private final int maxClient=2;
    private Client[] client = new Client[3];
    private Compte[] compte = new Compte[3];
    public static int count;
    public int nbrcl=0;
    public int nbrcp=0;

    //constructeurs

    public Banque(){}
    public Banque(String nom, String email) {
        this.nom=nom;
        this.email=email;

    }

    //getters

    public int getIdBanque() {
        this.idBanque = count++;
        return idBanque;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public Client[] getClient() {
        return client;
    }

    public Compte[] getCompte() {
        return compte;
    }

    public int getMaxClient() {
        return maxClient;
    }

    public int getMaxCompte() {
        return maxCompte;
    }

    //setters

    public void setIdBanque(int idBanque) {
        this.idBanque = idBanque;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setClient(Client[] client) {
        this.client = client;
    }

    public void setCompte(Compte[] compte) {
        this.compte = compte;
    }

    //ToString

    @Override
    public String toString() {
        return "id="+idBanque +"nom="+nom +"email: "+email;

    }

    //equals

    @Override
    public boolean equals(Object other) {
        if(other instanceof Banque)
            return  false;
        Banque o= (Banque) other;
        if (this.getIdBanque()==o.getIdBanque())
            return true;
        else return false;
    }




}
