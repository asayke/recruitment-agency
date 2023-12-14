package org.example.repository.interfaces;

import org.example.entity.Vacancy;

public interface VacancyRepository {
    void save(Vacancy vacancy);

    Vacancy getById(Long id);

    void setEnabledStatus(Long id, Boolean enableStatus);
}