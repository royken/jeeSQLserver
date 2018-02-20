package com.royken.teknik.web.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.TimeZone;

/**
 *
 * author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Named(value = "applicationBean")
@SessionScoped
public class ApplicationBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new instance of ApplicationBean
     */
    public ApplicationBean() {
    }

    public TimeZone getTimeZone() {
        return TimeZone.getDefault();
    }

}
