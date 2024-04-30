package com.example.Backend_Traini8_Nilesh_Bahetwar.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="training_centre")
//@Builder
public class TrainingCentre {
    private String centreName;
    private String centreCode;

    private int studentCapacity;
    //@ElementCollection
    private List<String>courseOffered=new ArrayList<>();
    @CreationTimestamp
    private Date createdOn;
    @Id
    @Column(unique=true,nullable = false)
    private String contactEmail;
    private String contactPhone;

    @OneToOne(mappedBy = "trainingCentre",cascade = CascadeType.ALL)
    @JsonIgnore
    private Address address;

    //    @Transient
//    public String getCourseOfferedAsString() {
//        return String.join(",", this.courseOffered);
//    }
//
//    // Method to convert a comma-separated string to a List<String>
//    @Transient
//    public void setCourseOfferedAsString(String courseOfferedAsString) {
//        this.courseOffered = Arrays.asList(courseOfferedAsString.split(","));
//    }
    public TrainingCentre() {

    }

    public TrainingCentre(String centreName, String centreCode, Address address,int studentCapacity,
                          List<String> courseOffered, Date createdOn, String contactEmail, String contactPhone) {
        this.centreName = centreName;
        this.centreCode = centreCode;
        this.address=address;
        this.studentCapacity = studentCapacity;
        this.courseOffered = courseOffered;
        this.createdOn = createdOn;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }

    public String getCentreName() {
        return centreName;
    }

    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }

    public String getCentreCode() {
        return centreCode;
    }

    public void setCentreCode(String centreCode) {
        this.centreCode = centreCode;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getStudentCapacity() {
        return studentCapacity;
    }

    public void setStudentCapacity(int studentCapacity) {
        this.studentCapacity = studentCapacity;
    }

    public List<String> getCourseOffered() {
        return courseOffered;
    }

    public void setCourseOffered(List<String> courseOffered) {
        this.courseOffered = courseOffered;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
