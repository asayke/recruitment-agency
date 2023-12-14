package org.example.repository.implementation;

import lombok.extern.java.Log;
import org.example.config.SessionFactoryMaker;
import org.example.entity.Candidate;
import org.example.repository.interfaces.CandidateRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Log
public class CandidateRepositoryImpl implements CandidateRepository {
    private final SessionFactory sessionFactory = SessionFactoryMaker.getFactory();

    @Override
    public void save(Candidate candidate) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(candidate);
            log.info("Entity candidate with name " + candidate.getName() + " successfully saved");
            transaction.commit();
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }

    @Override
    public Candidate getById(Long id) {
        Candidate candidate = null;

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            candidate = session.get(Candidate.class, id);
            log.info("Entity candidate with title " + candidate.getName() + " successfully found");
            transaction.commit();
        } catch (Exception e) {
            log.warning(e.getMessage());
        }

        return candidate;
    }

    @Override
    public void setEmployedStatus(Long id, Boolean employedStatus) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Candidate candidate = session.get(Candidate.class, id);

            if (candidate != null) {
                candidate.setEmployed(employedStatus);
                session.update(candidate);
                log.info("Employed status was set successfully");
            }

            transaction.commit();
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }
}