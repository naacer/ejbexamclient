package com.nacer.ejbexamclient.Web;

import com.nacer.examejb1.Entity.Cd;
import com.nacer.examejb1.Service.CDServiceBean;

import java.util.List;

public class CdBean {
    private CdServiceBean cdService;

    private List<Cd> cdsDisponibles;

    public List<Cd> getCdsDisponibles() {
        if (cdsDisponibles == null) {
            cdsDisponibles = cdService.getAllCDsDisponibles();
        }
        return cdsDisponibles;
    }

    public void emprunterCD(Long cdId, Long utilisateurId) {
        cdService.emprunterCD(cdId, utilisateurId);
        cdsDisponibles = cdService.getAllCDsDisponibles(); // Rafraîchir la liste
    }

}
