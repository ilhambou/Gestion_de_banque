package projet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Compte {
    private int idCompte;
    private double solde;
    private String[] compte=new String[10];
    private Client client ;
    private LocalDateTime date;
    public static int count;

    //Constructeurs

    Compte()
    {
    }
    Compte(double solde, LocalDateTime date, Client client)
    {
        this.solde=solde;
        this.date=date;
        this.client=client;
    }

    //getters
    public int getIdCompte() {

        this.idCompte = count++;
        return idCompte;

    }
    public double getSolde() {
        return solde;
    }

    public String[] getCompte() {
        return compte;
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

    public void setCompte(String[] compte) {
        this.compte = compte;
    }

    public void setDate() {
        this.date= LocalDateTime.now();
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
        return "id="+idCompte +"solde="+solde;

    }

    //equals

/**
    @Override
    public boolean equals(Object other) {
        if(other instanceof Compte) {
            return this.getIdCompte().equals(((Compte) other).getIdCompte());

        }
        else
        {
            return false;}

    **/
}
