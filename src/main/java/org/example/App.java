package org.example;

import org.example.entity.Candidate;
import org.example.entity.Vacancy;
import org.example.repository.implementation.CandidateRepositoryImpl;
import org.example.repository.implementation.VacancyRepositoryImpl;
import org.example.repository.interfaces.CandidateRepository;
import org.example.repository.interfaces.VacancyRepository;

public class App
{
    public static void main( String[] args )
    {
//        Vacancy vacancy1 = new Vacancy();
//        vacancy1.setDescription("some desc1");
//        vacancy1.setTitle("title1");
//
//        Vacancy vacancy2 = new Vacancy();
//        vacancy2.setDescription("some desc2");
//        vacancy2.setTitle("title2");
//
        VacancyRepository vacancyRepository = new VacancyRepositoryImpl();
//        vacancyRepository.save(vacancy1);
//        vacancyRepository.save(vacancy2);
//
//        Candidate candidate = new Candidate();
//        candidate.setName("Oleg");
//        candidate.setSurname("Kolodiazhnyi");
//        candidate.setPatronymic("Evgenievich");
//
        CandidateRepository candidateRepository = new CandidateRepositoryImpl();
//        candidateRepository.save(candidate);

        candidateRepository.setEmployedStatus(2L, true);
        Candidate byId = candidateRepository.getById(1L);
        System.out.println(byId);

        vacancyRepository.setEnabledStatus(4L, true);
        Vacancy byId1 = vacancyRepository.getById(4L);
        System.out.println(byId1);
    }
}
