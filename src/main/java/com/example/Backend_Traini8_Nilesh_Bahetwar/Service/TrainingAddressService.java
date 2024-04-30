package com.example.Backend_Traini8_Nilesh_Bahetwar.Service;

import com.example.Backend_Traini8_Nilesh_Bahetwar.Dtos.AddressAndTrainingCentreRequestDto;
//import com.example.Backend_Traini8_Nilesh_Bahetwar.Dtos.TrainingCentreResponseDto;
import com.example.Backend_Traini8_Nilesh_Bahetwar.Exception.*;
import com.example.Backend_Traini8_Nilesh_Bahetwar.Model.Address;
import com.example.Backend_Traini8_Nilesh_Bahetwar.Model.TrainingCentre;
import com.example.Backend_Traini8_Nilesh_Bahetwar.Repository.AddressRepository;
import com.example.Backend_Traini8_Nilesh_Bahetwar.Repository.TrainingRepository;
//import com.example.Backend_Traini8_Nilesh_Bahetwar.Transformer.EntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingAddressService {
  @Autowired
  TrainingRepository trainingrepository;
  @Autowired
  AddressRepository addressRepository;

  //*** 1.method for creating training centre ***//
  public void createTrainingCentre(AddressAndTrainingCentreRequestDto addressAndTrainingCentreRequestDto) throws InvalidCenterNameException, InvalidCenterCodeException, EmailAlreadyInUseException,
          InvalidFormatEmailException, InvalidPhoneNumberFormat{
    // Dto of training centre and address both = >  addressAndTrainingCentreRequestDto


     // creating address object from given Dto of address
    Address address = new Address();
    address.setDetailedAddress(addressAndTrainingCentreRequestDto.getDetailedAddress());
    address.setState(addressAndTrainingCentreRequestDto.getState());
    address.setPinCode(addressAndTrainingCentreRequestDto.getPinCode());
    address.setCity(addressAndTrainingCentreRequestDto.getCity());

     // saving into address DB
     Address savedAddress = addressRepository.save(address);


    // creating training-centre object from given Dto of training-centre
    TrainingCentre training_centre = new TrainingCentre();
    training_centre.setAddress(savedAddress);
    training_centre.setCourseOffered(addressAndTrainingCentreRequestDto.getCourseOffered());
    training_centre.setCentreName(addressAndTrainingCentreRequestDto.getCentreName());
    training_centre.setCentreCode(addressAndTrainingCentreRequestDto.getCentreCode());
    training_centre.setStudentCapacity(addressAndTrainingCentreRequestDto.getStudentCapacity());
    training_centre.setContactPhone(addressAndTrainingCentreRequestDto.getContactPhone());

    // before setting email we need to check if already this emailId present in training centre DB or not
    TrainingCentre emailCheck = trainingrepository.findByContactEmail(addressAndTrainingCentreRequestDto.getContactEmail());
    if(emailCheck!=null){
      throw new EmailAlreadyInUseException("email id already in use try with different email input");
    }

    // if we don't find given email in training centre DB then we set email
    training_centre.setContactEmail(addressAndTrainingCentreRequestDto.getContactEmail());

    // checking all required constraints
    if(training_centre.getCentreName().length()>=40){
      throw new InvalidCenterNameException("name of training centre name must be less than 40 characters");
    }

    if(training_centre.getCentreCode().length()!=12){
      throw new InvalidCenterCodeException("centre code must be exactly 12 alphanumeric character");
    }

    String email = training_centre.getContactEmail();
    if(email.length()<10 || !email.substring(email.length()-10).equals("@gmail.com")){
      throw new InvalidFormatEmailException("email format should be in .....@gmail.com");
    }

    String phoneNo = training_centre.getContactPhone();
    if(!phoneNo.substring(0,3).equals("+91") || phoneNo.length()!=13){
      throw new InvalidPhoneNumberFormat("It should start with +91 and must be exactly 13 numbers");
    }

    // if all constraints are correct then we are saving it into training-centre DB in last
    trainingrepository.save(training_centre);
  }

  //*** 2.method for getting all training centres ***//
  public List<TrainingCentre> getAllTrainingCentres(){
    // getting all training centres from training centre DB(TrainingRepo)
    List<TrainingCentre> trainingCentre = trainingrepository.findAll();

    // if training centre value comes null we will return empty list
    if(trainingCentre==null){
      List<TrainingCentre>emptyList = new ArrayList<>();
      return emptyList;
    }

    // here we are returning all list of training centres
    return trainingCentre;
  }
}


