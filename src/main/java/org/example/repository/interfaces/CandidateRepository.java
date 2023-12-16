package org.example.repository.interfaces;

import org.example.entity.Candidate;

public interface CandidateRepository {
    void save(Candidate candidate);

    Candidate getById(Long id);

    void setEmployedStatus(Long id, Boolean employedStatus);

    boolean login(String username, String password);
}