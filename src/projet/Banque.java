package projet;



public class Banque {
    private int idBanque;
    private String nom;
    private String email;
    private Client[] client = new Client[10];
    private Compte[] comptes = new Compte[10];



    public int getIdBanque() {
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

    public Compte[] getComptes() {
        return comptes;
    }

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

    public void setComptes(Compte[] comptes) {
        this.comptes = comptes;
    }

    @Override
    public String toString() {
        return "id="+idBanque +"nom="+nom;

    }
}
