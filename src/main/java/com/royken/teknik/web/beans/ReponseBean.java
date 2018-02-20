package com.royken.teknik.web.beans;

import com.royken.teknik.entities.Reponse;
import com.royken.teknik.service.ITeknikService;
import com.royken.teknik.service.ServiceException;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import org.primefaces.model.UploadedFile;

/**
 *
 * author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Named(value = "reponseBean")
@SessionScoped
public class ReponseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private ITeknikService teknikService;

    private List<Reponse> reponses;

    private Reponse reponse = new Reponse();

    private UploadedFile file;

    /**
     * Creates a new instance of ReponseBean
     */
    public ReponseBean() {
    }

    public List<Reponse> getReponses() {
        try {
            Date debut, fin;
            Calendar cal = Calendar.getInstance();
            debut = cal.getTime();
            cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, -3);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            fin = cal.getTime();
            System.out.println("DATE DEBUT : "+ debut + " DATE FIN : " + fin);
            //reponses = teknikService.getReponseBetweenDates(debut, fin);
            reponses = teknikService.getReponseBetweenDates(fin, debut);
           // reponses = teknikService.getAllReponse();
        } catch (ServiceException e) {
        }
        return reponses;
    }

    public void setReponses(List<Reponse> reponses) {
        this.reponses = reponses;
    }

    public Reponse getReponse() {
        return reponse;
    }

    public void setReponse(Reponse reponse) {
        this.reponse = reponse;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void importer() throws IOException {
        try {
            teknikService.importReponse(file.getInputstream());
        } catch (ServiceException ex) {
        }
    }

}
