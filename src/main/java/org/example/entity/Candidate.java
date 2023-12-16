package org.example.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

/*
Data - генерирует геттер и сеттеры для класса
Entity - просто помечает хибернейту, что этот класс имеет свою таблицу в БД
Тейбл - она уточняет хибернейту конретное название этой таблицы
FieldDefaults - за тебя ставить модификатор private перед полями
Id - указывает, какое конрететно поля является id в БД
GeneratedValue - сам считает и вписывает ID
 */
@Data
@Entity
@Table(name = "candidate")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String username;

    String password;

    String name;

    String surname;

    String patronymic;

    Boolean employed = false;

    Integer age;

    String gender;
}