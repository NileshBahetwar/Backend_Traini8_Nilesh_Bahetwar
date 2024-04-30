package com.example.Backend_Traini8_Nilesh_Bahetwar.Dtos;

import com.example.Backend_Traini8_Nilesh_Bahetwar.Model.Address;
import lombok.Builder;
import java.util.ArrayList;
import java.util.List;
//@Builder
public class AddressAndTrainingCentreRequestDto {
    // address attribute

    private String detailedAddress;
    private String city;
    private String state;
    private String pinCode;

    // training centre attribute
    private String centreName;
    private String centreCode;
    private int studentCapacity;
    private List<String> courseOffered=new ArrayList<>();
    private String contactEmail;
    private String contactPhone;
//    private Address address;

    public AddressAndTrainingCentreRequestDto() {
    }

    public AddressAndTrainingCentreRequestDto(String detailedAddress, String city, String state,
                                              String pinCode, String centreName, String centreCode, int studentCapacity, List<String> courseOffered, String contactEmail, String contactPhone) {
        this.detailedAddress = detailedAddress;
        this.city = city;
        this.state = state;
//        this.address=address;
        this.pinCode = pinCode;
        this.centreName = centreName;
        this.centreCode = centreCode;
        this.studentCapacity = studentCapacity;
        this.courseOffered = courseOffered;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
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

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

}
