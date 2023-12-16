package org.example;

import org.example.entity.Candidate;
import org.example.entity.Vacancy;
import org.example.repository.implementation.CandidateRepositoryImpl;
import org.example.repository.implementation.VacancyRepositoryImpl;
import org.example.repository.interfaces.CandidateRepository;
import org.example.repository.interfaces.VacancyRepository;
import org.example.service.CandidateService;

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
//        VacancyRepository vacancyRepository = new VacancyRepositoryImpl();
//        vacancyRepository.save(vacancy1);
//        vacancyRepository.save(vacancy2);
//
        Candidate candidate = new Candidate();
        candidate.setName("Liza");
        candidate.setSurname("Kolodiazhnya");
        candidate.setPatronymic("Alexandrovna");
        candidate.setAge(18);
        candidate.setGender("Женский");
        candidate.setUsername("molinka");
        candidate.setPassword("molinka");
//
        CandidateRepository candidateRepository = new CandidateRepositoryImpl();
        candidateRepository.save(candidate);

//        candidateRepository.setEmployedStatus(2L, true);
//        Candidate byId = candidateRepository.getById(2L);
//        System.out.println(byId);
//
//        vacancyRepository.setEnabledStatus(4L, true);
//        Vacancy byId1 = vacancyRepository.getById(4L);
//        System.out.println(byId1);

//        CandidateService candidateService = new CandidateService();
//        System.out.println(candidateService.login("molinka", "molinka"));
    }
}