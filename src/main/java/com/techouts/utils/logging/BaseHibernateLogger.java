package com.techouts.utils.logging;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// the only reason I made this class is for logging purpose only I could have also used event listeners but this gets the job done
@MappedSuperclass
public class BaseHibernateLogger {

    private void printLog(String s) {
        System.out.println ("Hibernate logger ==> " + LocalDateTime.now ().format (DateTimeFormatter.ofPattern ("dd-MMM-uuuu HH:mm:ss")) + ": " + s);
    }

    @PrePersist
    public void beforePersist() {
        printLog (this.getClass ().getSimpleName () + " entity is about to be \"inserted\" into database");
    }
    
    @PostPersist
    public void afterPersist() {
        printLog (this.getClass ().getSimpleName () + " entity is \"inserted\" into database");
    }

    @PreUpdate
    public void beforeMerge() {
        printLog (this.getClass ().getSimpleName () + " entity is about to be \"updated\" on the database");
    }

    @PostUpdate
    public void afterMerge() {
        printLog (this.getClass ().getSimpleName () + " entity is \"updated\" on the database");
    }

    @PreRemove
    public void beforeRemove() {
        printLog (this.getClass ().getSimpleName () + " entity is about to be \"removed\" from the database");
    }

    @PostRemove
    public void afterRemove() {
        printLog (this.getClass ().getSimpleName () + " entity is \"removed\" from the database");
    }

    @PostLoad
    public void beforeLoad() {
        printLog (this.getClass ().getSimpleName () + " entity loaded successfully!!!");
    }

}
