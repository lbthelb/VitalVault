package com.pm.vitalvault.service;

import com.pm.vitalvault.dto.PatientResponseDTO;
import com.pm.vitalvault.mapper.PatientMapper;
import com.pm.vitalvault.model.Patient;
import com.pm.vitalvault.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();

        return patients.stream().map(PatientMapper::toDTO).toList();
    }
}
