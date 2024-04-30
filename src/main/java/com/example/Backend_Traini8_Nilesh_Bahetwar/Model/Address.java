package com.example.Backend_Traini8_Nilesh_Bahetwar.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name="address")
//@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String detailedAddress;
    private String city;
    private String state;

    private String pinCode;

    @OneToOne
    @JoinColumn
    @JsonIgnore
    private TrainingCentre trainingCentre;

    public Address() {
    }

    public Address(String detailedAddress, String city, String state, String pinCode) {
        this.detailedAddress = detailedAddress;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
