package org.example.service;

import org.example.entity.Candidate;
import org.example.repository.implementation.CandidateRepositoryImpl;
import org.example.repository.interfaces.CandidateRepository;

public class CandidateService {
    private final CandidateRepository candidateRepository = new CandidateRepositoryImpl();

    public void save(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    public Candidate findById(Long id) {
        return candidateRepository.getById(id);
    }

    public void setEmployedStatus(Long id, Boolean employedStatus) {
        candidateRepository.setEmployedStatus(id, employedStatus);
    }

    public boolean login(String username, String password) {
        return candidateRepository.login(username, password);
    }
}