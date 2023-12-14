package org.example.repository.implementation;

import lombok.extern.java.Log;
import org.example.config.SessionFactoryMaker;
import org.example.entity.Vacancy;
import org.example.repository.interfaces.VacancyRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Log
public class VacancyRepositoryImpl implements VacancyRepository {
    private final SessionFactory sessionFactory = SessionFactoryMaker.getFactory();

    @Override
    public void save(Vacancy vacancy) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(vacancy);
            log.info("Entity vacancy with title " + vacancy.getTitle() + " successfully saved");
            transaction.commit();
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }

    @Override
    public Vacancy getById(Long id) {
        Vacancy vacancy = null;

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            vacancy = session.get(Vacancy.class, id);
            log.info("Entity vacancy with title " + vacancy.getTitle() + " successfully found");
            transaction.commit();
        } catch (Exception e) {
            log.warning(e.getMessage());
        }

        return vacancy;
    }

    @Override
    public void setEnabledStatus(Long id, Boolean enableStatus) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Vacancy vacancy = session.get(Vacancy.class, id);

            if (vacancy != null) {
                vacancy.setActive(enableStatus);
                session.update(vacancy);
                log.info("Active status was set successfully");
            }

            transaction.commit();
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }
}