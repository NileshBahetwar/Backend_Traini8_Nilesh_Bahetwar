package com.example.Backend_Traini8_Nilesh_Bahetwar.Repository;

import com.example.Backend_Traini8_Nilesh_Bahetwar.Model.TrainingCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<TrainingCentre,String> {
     TrainingCentre findByContactEmail(String email);
}
