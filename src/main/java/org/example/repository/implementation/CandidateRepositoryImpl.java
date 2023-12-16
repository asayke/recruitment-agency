package org.example.repository.implementation;

import lombok.extern.java.Log;
import org.example.config.SessionFactoryMaker;
import org.example.entity.Candidate;
import org.example.repository.interfaces.CandidateRepository;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

//@Log - сама создаёт логгер под назваением log
//Логгер - это обьект, которые предоставет методы вывода в консоль(аналог sout)
@Log
//Repository/DAO - слой, через который ты работаешь с БД
public class CandidateRepositoryImpl implements CandidateRepository {
    private final SessionFactory sessionFactory = SessionFactoryMaker.getFactory();

    /*
        try/catch - попытайся(try) использовать ресурс(обьект класса) Session,
         чтобы работать с сессией в БД. Что делает Java? - она начинает работу со всем кода, внутри блока try
        пишем в блоке catch, что делает, если возникло ислкчение/ошибка(Exception)
        В нашем случае - оно выводит в консоль сообщение от этой ошибке
     */
    @Override
    public void save(Candidate candidate) {
        try (Session session = sessionFactory.openSession()) {
            //Открывает внутри сессии открывает новую траназкцию внутри сесси и хранит саму транзакцую
            Transaction transaction = session.beginTransaction();
            //сохраняем в БД candidate
            session.save(candidate);
            log.info("Entity candidate with name " + candidate.getName() + " successfully saved");
            //Именно при коммите БД сохраняем результат нашей работы с ней, и закрывает транзакцию
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
            log.info("Entity candidate with name " + candidate.getName() + " successfully found");
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

    @Override
    public boolean login(String username, String password) {
        String truePassword = "";
        String hql = "from Candidate where username = :username";

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery(hql, Candidate.class);
            query.setParameter("username", username);

            Candidate candidate = (Candidate) query.uniqueResult();

            if (candidate != null && candidate.getUsername().equals(username)) {
                truePassword = candidate.getPassword();
            } else {
                log.info("User found found successfully");
                return false;
            }

            transaction.commit();
        } catch (Exception e) {
            log.warning(e.getMessage());
        }

        return truePassword.equals(password);
    }

}