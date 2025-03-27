package org.example.model;
CREATE TABLE soutenances (
        id SERIAL PRIMARY KEY,
        nom_etudiant VARCHAR(255),
email VARCHAR(255),
titre_pfe VARCHAR(255),
encadrant VARCHAR(255),
president_jury VARCHAR(255),
rapporteur VARCHAR(255),
salle VARCHAR(255),
heure TIME,
date DATE
);
