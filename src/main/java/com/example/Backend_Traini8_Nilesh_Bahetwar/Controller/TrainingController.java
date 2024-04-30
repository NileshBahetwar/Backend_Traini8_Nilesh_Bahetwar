package com.example.Backend_Traini8_Nilesh_Bahetwar.Controller;

import com.example.Backend_Traini8_Nilesh_Bahetwar.Dtos.AddressAndTrainingCentreRequestDto;
//import com.example.Backend_Traini8_Nilesh_Bahetwar.Dtos.TrainingCentreResponseDto;
import com.example.Backend_Traini8_Nilesh_Bahetwar.Exception.*;
import com.example.Backend_Traini8_Nilesh_Bahetwar.Model.TrainingCentre;
import com.example.Backend_Traini8_Nilesh_Bahetwar.Service.TrainingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training_centre")
public class TrainingController {
      @Autowired
      TrainingAddressService trainingAddressservice;

      @PostMapping("/add")
      public ResponseEntity createTrainingCentre(@RequestBody AddressAndTrainingCentreRequestDto
                                                               addressAndTrainingCentreRequestDto) throws InvalidCenterCodeException, InvalidFormatEmailException, InvalidCenterNameException, EmailAlreadyInUseException, InvalidPhoneNumberFormat {
            try{
                  trainingAddressservice.createTrainingCentre(addressAndTrainingCentreRequestDto);
            } catch (Exception e) {
                  return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity("Training Centre has been created successfully",HttpStatus.CREATED);
      }

      @GetMapping("/get/all")
      public List<TrainingCentre> getAllTrainingCentres(){
            // if none of the training centre is created then it is going to return empty list
            // otherwise it will return all training centres
           return trainingAddressservice.getAllTrainingCentres();
      }
}
