Candidate table init
```SQL
CREATE TABLE candidate (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(255),
                           surname VARCHAR(255),
                           patronymic VARCHAR(255),
                           employed BOOLEAN
);
```
Vacancy table init
```SQL
CREATE TABLE vacancy (
                         id SERIAL PRIMARY KEY,
                         title VARCHAR(255),
                         description TEXT,
                         active BOOLEAN
);
```
