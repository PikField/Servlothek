/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Quentin
 * Created: 21 nov. 2019
 */


CREATE TABLE LIVRE(
    ID  INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) primary key,
    TITRE VARCHAR (50) NOT NULL,
    AUTEUR VARCHAR (100) NOT NULL,
    SORTIE DATE NOT NULL, 
    DISPONIBLE boolean NOT NULL DEFAULT true
)ENGINE=INNODB;

CREATE TABLE UTILISATEUR(
    ID  INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) primary key,
    NOM VARCHAR (50) NOT NULL,
    PRENOM VARCHAR (50) NOT NULL,
    MAIL VARCHAR (120)  NOT NULL,
    MDP VARCHAR (120)  NOT NULL, 
    ROLE boolean NOT NULL DEFAULT false
) 
CREATE TABLE EMPRUNT(
    ID  INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) primary key,
    UTILISATEUR INTEGER UNSIGNED NOT NULL ,
    LIVRE INTEGER UNSIGNED NOT NULL ,
    DEBUT DATE NOT NULL,
    FIN DATE NOT NULL
) ENGINE=INNODB;

ALTER TABLE EMPRUNT ADD CONSTRAINT fk_utilisateur_emprunt FOREIGN KEY (UTILISATEUR) REFERENCES utilisateur(ID);
ALTER TABLE EMPRUNT ADD CONSTRAINT fk_livre_emprunt FOREIGN KEY (LIVRE) REFERENCES livre(ID);
alter table UTILISATEUR ADD  UNIQUE (MAIL)


insert into UTILISATEUR(NOM, PRENOM, MAIL, MDP) VALUES ('jean', 'dupont', 'jean.dupont@gmail.com', 'azertyuiop'), ('jean', 'admin', 'jean.admin@gmail.com', 'azertyuiop')
insert into LIVRE(TITRE, AUTEUR, SORTIE, DISPONIBLE) VALUES ('Electromagnetisme', 'P. Dassonvalle', current_date, true), ('La thermodynamique pour les nulls', 'L. Barroux', current_date, false)
insert into EMPRUNT(LIVRE, AUTEUR) VALUES ((select ID from LIVRE where TITRE LIKE 'Electromagnetisme' AND AUTEUR LIKE 'P. Dassonvalle'), 
(select ID from UTILISATEUR where MAIL  like 'jean.dupont@gmail.com'))


select L.*, U.* from  LIVRE as L INNER JOIN EMPRUNT on EMPRUNT.LIVRE = L.ID, UTILISATEUR as U INNER JOIN EMPRUNT on EMPRUNT.UTILISATEUR = U.ID, EMPRUNT as E where L.DISPONIBLE = false and E.UTILISATEUR  = U.ID and E.LIVRE = 