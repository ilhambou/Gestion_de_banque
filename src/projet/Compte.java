package projet;

import model.Comp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Compte {
    private int idCompte;
    private double solde;
    private String[] journalisation=new String[10];
    private Client client ;
    private LocalDateTime date;
    public static int count=1;
    public int i;

    //Constructeurs

    Compte()
    {
    }
    Compte(double solde)
    {
        this.idCompte = count++;
        this.solde=solde;
        this.date= LocalDateTime.now();
        journalisation[i]="compte : "+idCompte+"la date de creation :"+date;
        i++;

    }
    Compte(double solde, Client client)
    {
        this.idCompte = count++;
        this.solde=solde;
        this.date= LocalDateTime.now();
        this.client=client;
        journalisation[i]="compte : "+idCompte+"la date de creation :"+date;
        i++;
    }

    //getters
    public int getIdCompte() {

        //this.idCompte = count++;
        return idCompte;

    }
    public double getSolde() {
        return solde;
    }

    public String[] getJournalisation() {
        return journalisation;
    }

    public Client getClient() {
        return client;
    }

    public LocalDateTime getDate() {
        return date;
    }

    //setters

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public void setSolde(double solde) {
        if (solde>0.0)
        {
            this.solde = solde;

        }

    }

    public void setJournalisation(String[] journalisation) {
        this.journalisation = journalisation;
    }
    public void setDate() {
        this.date= LocalDateTime.now();
    }

    public void setClient(Client client) {
        this.client = client;
    }

    /**public boolean setlogs(String log){

        Object datetime;
        DateTimmeFormatter formatter= DateTimeFormatter.afpattern("dd/MM/yyyy | HH:mm);
                String datetime=formatter.format(LocalDateTime.now());
        String dateTime;
        log = "[ "+dateTime+ " ]=> + log;

        for(  int i=0;i<logs.lentgh;i++  )
        {
            if(logs[i]==null)
            {
                logs[i]=log;
                return true;


            }
        }
        return false;

**/

    //ToString

    @Override
    public String toString() {
        if(client==null)
        {
            return "id: "+idCompte +" solde: "+solde+" date de creation: "+date+" --AUCUN CLIENT-- ";
        }
        else {
            return "id: "+idCompte +" solde: "+solde+" date de creation: "+date+" client: "+client;

        }

    }

    //equals


    @Override
    public boolean equals(Object other) {
        if(other instanceof Compte)
            return  false;
        Compte o= (Compte) other;
        if (this.getIdCompte()==o.getIdCompte())
            return true;
        else return false;
    }


}
