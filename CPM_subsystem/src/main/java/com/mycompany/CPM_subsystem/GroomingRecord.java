package com.mycompany.CPM_subsystem;

import java.util.Date;

public class GroomingRecord {
    private String recordID;
    private Date date;
    private String serviceType;
    private String groomerNotes;

    // Constructor
    public GroomingRecord(String recordID, Date date, String serviceType, String groomerNotes) {
        this.recordID = recordID;
        this.date = date;
        this.serviceType = serviceType;
        this.groomerNotes = groomerNotes;
    }

    // Getter and Setter methods
    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getGroomerNotes() {
        return groomerNotes;
    }

    public void setGroomerNotes(String groomerNotes) {
        this.groomerNotes = groomerNotes;
    }

    // Method to view grooming history
    public void viewGroomingHistory() {
        System.out.println("Grooming Record ID: " + recordID);
        System.out.println("Date: " + date.toString());
        System.out.println("Service Type: " + serviceType);
        System.out.println("Groomer Notes: " + groomerNotes);
    }

    // toString method to display GroomingRecord details
    @Override
    public String toString() {
        return "GroomingRecord [recordID=" + recordID + ", date=" + date + ", serviceType=" + serviceType + ", groomerNotes=" + groomerNotes + "]";
    }
}
