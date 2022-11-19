package projet;


public class Client {
    private int idClient;
    private String nom ;
    private String prenom;
    private String email;
    private Compte[] ClientComptes = new Compte[2];

    public static int count;

    // Constructeurs

    public Client(){
    }
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

    //ToString

    @Override
    public String toString() {
        return "id="+idClient +"nom="+nom;

    }

    //Equal

    /**
    @Override
    public boolean equals(Object other) {
        if(other instanceof Compte) {
            return this.getIdClient().equals(((Compte)other).getIdClient());
        }
        else
        {
            return false;
        }
    }
**/



}
