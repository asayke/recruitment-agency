package org.example.config;

import org.example.entity.Candidate;
import org.example.entity.Vacancy;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryMaker {
//    обьект внутри библиотеки, которым ты должна пользоваться
    private static SessionFactory factory;

/*
    1.configureFactory - конфигурирует твой обьект factory типа SessionFactory
    2.new Configuration() - ты говоришь создать новую конфигурацию внутри твоей factory
    3. addAnnotatedClass - устанавливаешь обьекты, с которыми твой хибернейт может работать
    4. configure().buildSessionFactory(); - на этом этапе, ты уже настроила хибернейт,
    и теперь ты говоришь закончить конфигурацию и собрать ноывй образец factory
    5. метод configure - он считывает значения с конфиг-файла(hibernate.cfg.xml), помещает их в себя, и заканчивает конфигурацию
    6. buildSessionFactory - он завершает свою сборку(настройку) и готов к работе
 */
    private static void configureFactory() {
        try {
            factory = new Configuration()
                    .addAnnotatedClass(Candidate.class)
                    .addAnnotatedClass(Vacancy.class)
                    .configure()
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static org.hibernate.SessionFactory getFactory() {
        if (factory == null) configureFactory();

        return factory;
    }
}