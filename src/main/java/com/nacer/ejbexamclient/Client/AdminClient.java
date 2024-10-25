package com.nacer.ejbexamclient.Client;

import com.nacer.examejb1.Service.CDService;
import com.nacer.examejb1.Entity.Cd;
import jakarta.naming.InitialContext;
import jakarta.naming.NamingException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;

public class AdminClient {
    private CdServiceBean cdService;

    public AdminClient() {
        try {
            // Créez un contexte initial JNDI
            InitialContext ctx = new InitialContext();
            // Recherche de l'EJB via JNDI
            cdService = (CdServiceBean) ctx.lookup("java:global/ejbexam1/CDServiceBean!com.nacer.examejb1.Service.CDService");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public void displayAllCDs() {
        try {
            // Récupération des CDs disponibles
            List<Cd> cdsDisponibles = cdService.getAllCDsDisponibles();
            // Affichage des titres des CDs
            if (cdsDisponibles.isEmpty()) {
                System.out.println("Aucun CD disponible.");
            } else {
                cdsDisponibles.forEach(cd -> System.out.println("Titre du CD: " + cd.getTitre()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Créez une instance de AdminClient
        AdminClient client = new AdminClient();
        // Affichez tous les CDs disponibles
        client.displayAllCDs();
    }
}
