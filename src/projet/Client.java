package projet;


public class Client {
    private int idClient;
    private String nom ;
    private String prenom;
    private String email;
    private Compte[] compte = new Compte[2];

    public static int count;

    // Constructeurs

    public Client(){}
    public Client(String nom,String prenom, String email)
    {
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.idClient = count++;

    }

    //getters

    public int getIdClient() {
        this.idClient = count++;
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
        this.email = email;
    }

    public void setCompte(Compte[] compte) {
        this.compte = compte;
    }

    //ToString

    @Override
    public String toString() {
        return "id="+idClient +"nom="+nom+"prenom: "+prenom+"email: "+email;

    }

    //Equal

    @Override
    public boolean equals(Object other) {
        if(other instanceof Client)
            return  false;
        Client o= (Client) other;
        if (this.getIdClient()==o.getIdClient() && this.nom==o.getNom() && this.prenom==o.getPrenom() && this.email==o.getEmail() )
            return true;
        else return false;
    }



}
