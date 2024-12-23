CREATE DATABASE IF NOT EXISTS TicketApp2024;
USE TicketApp2024;

-- Table for UserModel
CREATE TABLE UserModel (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL,
    mot_de_passe VARCHAR(100) NOT NULL,
    date_derniere_connexion VARCHAR(50) NOT NULL,
    statut BOOLEAN NOT NULL,
    role ENUM('INTERVENANT', 'UTILISATEUR') NOT NULL
);

-- Table for DevicesModel
CREATE TABLE DevicesModel (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    utilisateur_affecte INTEGER NOT NULL,
    configuration VARCHAR(255) NOT NULL,
    etat ENUM('EN_FONCTION', 'EN_MAINTENANCE', 'EN_COMMANDE') NOT NULL,
    FOREIGN KEY (utilisateur_affecte) REFERENCES UserModel(id)
);

-- Table for TicketModel
CREATE TABLE TicketModel (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    impact ENUM('BLOQUANT', 'MAJEUR', 'MINEUR') NOT NULL,
    titre VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    date_de_creation VARCHAR(50) NOT NULL,
    date_mise_a_jour VARCHAR(50) NOT NULL,
    etat ENUM('OUVERT', 'EN_COURS', 'RESOLU', 'FERME', 'ANNULE') NOT NULL,
    utilisateur_createur INTEGER NOT NULL,
    poste_informatique INTEGER NOT NULL,
    type_de_demande VARCHAR(255) NOT NULL,
    FOREIGN KEY (utilisateur_createur) REFERENCES UserModel(id),
    FOREIGN KEY (poste_informatique) REFERENCES DevicesModel(id)
);

-- Insert sample data into UserModel
INSERT INTO UserModel (nom, email, mot_de_passe, date_derniere_connexion, statut, role) VALUES
('Alice Dupont', 'alice.dupont@example.com', 'motdepasse123', '2024-01-01', TRUE, 'UTILISATEUR'),
('Bob Martin', 'bob.martin@example.com', 'motdepasse123', '2024-01-02', TRUE, 'INTERVENANT'),
('Charlie Durand', 'charlie.durand@example.com', 'motdepasse123', '2024-01-03', TRUE, 'UTILISATEUR'),
('Diane Morel', 'diane.morel@example.com', 'motdepasse123', '2024-01-04', TRUE, 'UTILISATEUR'),
('Eve Lambert', 'eve.lambert@example.com', 'motdepasse123', '2024-01-05', TRUE, 'INTERVENANT'),
('Fabrice Lemoine', 'fabrice.lemoine@example.com', 'motdepasse123', '2024-01-06', TRUE, 'UTILISATEUR'),
('Gilles Perrin', 'gilles.perrin@example.com', 'motdepasse123', '2024-01-07', TRUE, 'INTERVENANT'),
('Helene Roche', 'helene.roche@example.com', 'motdepasse123', '2024-01-08', TRUE, 'UTILISATEUR'),
('Isabelle Fournier', 'isabelle.fournier@example.com', 'motdepasse123', '2024-01-09', TRUE, 'INTERVENANT'),
('Jacques Lefevre', 'jacques.lefevre@example.com', 'motdepasse123', '2024-01-10', TRUE, 'UTILISATEUR'),
('Karine Petit', 'karine.petit@example.com', 'motdepasse123', '2024-01-11', TRUE, 'INTERVENANT'),
('Louis Robert', 'louis.robert@example.com', 'motdepasse123', '2024-01-12', TRUE, 'UTILISATEUR'),
('Marie Dubois', 'marie.dubois@example.com', 'motdepasse123', '2024-01-13', TRUE, 'INTERVENANT'),
('Nathalie Simon', 'nathalie.simon@example.com', 'motdepasse123', '2024-01-14', TRUE, 'UTILISATEUR'),
('Olivier Renault', 'olivier.renault@example.com', 'motdepasse123', '2024-01-15', TRUE, 'UTILISATEUR'),
('Pascal Bourdon', 'pascal.bourdon@example.com', 'motdepasse123', '2024-01-16', TRUE, 'INTERVENANT'),
('Quentin Barre', 'quentin.barre@example.com', 'motdepasse123', '2024-01-17', TRUE, 'UTILISATEUR'),
('Romain Tessier', 'romain.tessier@example.com', 'motdepasse123', '2024-01-18', TRUE, 'INTERVENANT'),
('Sylvie Bernard', 'sylvie.bernard@example.com', 'motdepasse123', '2024-01-19', TRUE, 'UTILISATEUR'),
('Thomas Lambert', 'thomas.lambert@example.com', 'motdepasse123', '2024-01-20', TRUE, 'UTILISATEUR'),
('Ursule Moreau', 'ursule.moreau@example.com', 'motdepasse123', '2024-01-21', TRUE, 'UTILISATEUR'),
('Victor Hugo', 'victor.hugo@example.com', 'motdepasse123', '2024-01-22', TRUE, 'INTERVENANT'),
('Wendy Fischer', 'wendy.fischer@example.com', 'motdepasse123', '2024-01-23', TRUE, 'UTILISATEUR'),
('Xavier Dupuis', 'xavier.dupuis@example.com', 'motdepasse123', '2024-01-24', TRUE, 'UTILISATEUR'),
('Yannick Roux', 'yannick.roux@example.com', 'motdepasse123', '2024-01-25', TRUE, 'INTERVENANT'),
('Zoe Laurent', 'zoe.laurent@example.com', 'motdepasse123', '2024-01-26', TRUE, 'UTILISATEUR'),
('Alice Martin', 'alice.martin@example.com', 'motdepasse123', '2024-01-27', TRUE, 'INTERVENANT'),
('Bob Durand', 'bob.durand@example.com', 'motdepasse123', '2024-01-28', TRUE, 'UTILISATEUR'),
('Charlie Petit', 'charlie.petit@example.com', 'motdepasse123', '2024-01-29', TRUE, 'UTILISATEUR'),
('Diane Robert', 'diane.robert@example.com', 'motdepasse123', '2024-01-30', TRUE, 'INTERVENANT'),
('Eve Bernard', 'eve.bernard@example.com', 'motdepasse123', '2024-02-01', TRUE, 'UTILISATEUR'),
('Fabrice Morel', 'fabrice.morel@example.com', 'motdepasse123', '2024-02-02', TRUE, 'INTERVENANT'),
('Gilles Lambert', 'gilles.lambert@example.com', 'motdepasse123', '2024-02-03', TRUE, 'UTILISATEUR'),
('Helene Renault', 'helene.renault@example.com', 'motdepasse123', '2024-02-04', TRUE, 'UTILISATEUR'),
('Isabelle Tessier', 'isabelle.tessier@example.com', 'motdepasse123', '2024-02-05', TRUE, 'INTERVENANT'),
('Jacques Bourdon', 'jacques.bourdon@example.com', 'motdepasse123', '2024-02-06', TRUE, 'UTILISATEUR'),
('Karine Simon', 'karine.simon@example.com', 'motdepasse123', '2024-02-07', TRUE, 'INTERVENANT'),
('Louis Dupont', 'louis.dupont@example.com', 'motdepasse123', '2024-02-08', TRUE, 'UTILISATEUR');

-- Insert sample data into DevicesModel
INSERT INTO DevicesModel (utilisateur_affecte, configuration, etat) VALUES
(1, 'PC - Windows 10 - 16GB RAM', 'EN_FONCTION'),
(2, 'Laptop - Ubuntu - 8GB RAM', 'EN_MAINTENANCE'),
(3, 'MacBook - macOS - 16GB RAM', 'EN_COMMANDE'),
(4, 'Desktop - Windows 11 - 32GB RAM', 'EN_FONCTION'),
(5, 'Server - Linux - 64GB RAM', 'EN_MAINTENANCE'),
(6, 'PC - Windows 7 - 4GB RAM', 'EN_COMMANDE'),
(7, 'Laptop - Fedora - 8GB RAM', 'EN_FONCTION'),
(8, 'MacBook Air - macOS - 8GB RAM', 'EN_FONCTION'),
(9, 'Desktop - Windows 8 - 16GB RAM', 'EN_MAINTENANCE'),
(10, 'Server - Windows Server 2019 - 128GB RAM', 'EN_COMMANDE'),
(11, 'Laptop - Mint - 16GB RAM', 'EN_MAINTENANCE'),
(12, 'PC - Ubuntu 20.04 - 8GB RAM', 'EN_FONCTION'),
(13, 'Desktop - Linux - 32GB RAM', 'EN_COMMANDE'),
(14, 'Server - Debian - 256GB RAM', 'EN_FONCTION'),
(15, 'PC - macOS Ventura - 16GB RAM', 'EN_MAINTENANCE'),
(16, 'Laptop - Windows 11 - 8GB RAM', 'EN_FONCTION'),
(17, 'Server - Proxmox - 128GB RAM', 'EN_MAINTENANCE'),
(18, 'Desktop - PopOS - 32GB RAM', 'EN_FONCTION'),
(19, 'Laptop - Arch Linux - 16GB RAM', 'EN_COMMANDE'),
(20, 'PC - Windows 10 - 8GB RAM', 'EN_FONCTION'),
(21, 'Server - Windows Server 2022 - 512GB RAM', 'EN_MAINTENANCE'),
(22, 'Desktop - CentOS - 16GB RAM', 'EN_COMMANDE'),
(23, 'Laptop - OpenSUSE - 8GB RAM', 'EN_FONCTION'),
(24, 'Mac Mini - macOS - 16GB RAM', 'EN_FONCTION'),
(25, 'Server - Red Hat - 256GB RAM', 'EN_MAINTENANCE');

-- Insert sample data into TicketModel
INSERT INTO TicketModel (impact, titre, description, date_de_creation, date_mise_a_jour, etat, utilisateur_createur, poste_informatique, type_de_demande) VALUES
('BLOQUANT', 'Panne systeme', 'Le systeme se bloque lors de la sauvegarde.', '2024-01-01', '2024-01-02', 'OUVERT', 1, 1, 'Probleme logiciel'),
('MAJEUR', 'Performance lente', 'Le systeme est tres lent au demarrage.', '2024-01-02', '2024-01-03', 'EN_COURS', 2, 2, 'Probleme de performance'),
('MINEUR', 'Bug interface', 'Un bouton nest pas cliquable sur la page des parametres.', '2024-01-03', '2024-01-04', 'RESOLU', 3, 3, 'Probleme interface'),
('BLOQUANT', 'Probleme reseau', 'Aucune connexion Internet sur le serveur principal.', '2024-01-04', '2024-01-05', 'FERME', 4, 4, 'Probleme reseau'),
('MAJEUR', 'Imprimante en panne', 'Limprimante ne repond pas aux commandes dimpression.', '2024-01-05', '2024-01-06', 'ANNULE', 5, 5, 'Probleme materiel'),
('BLOQUANT', 'Erreur critique', 'Application se ferme de maniere inattendue.', '2024-01-06', '2024-01-07', 'OUVERT', 6, 6, 'Erreur systeme'),
('MINEUR', 'Probleme affichage', 'Icone manquante dans le menu principal.', '2024-01-07', '2024-01-08', 'EN_COURS', 7, 7, 'Interface utilisateur'),
('MAJEUR', 'Base de donnees inaccessible', 'Erreur de connexion a la base de donnees.', '2024-01-08', '2024-01-09', 'RESOLU', 8, 8, 'Probleme base de donnees'),
('BLOQUANT', 'Erreur impression', 'Document non imprime correctement.', '2024-01-09', '2024-01-10', 'FERME', 9, 9, 'Probleme materiel'),
('MINEUR', 'Probleme mineur', 'Fenetre de configuration lente.', '2024-01-10', '2024-01-11', 'ANNULE', 10, 10, 'Probleme logiciel'),
('MAJEUR', 'Connexion lente', 'Les utilisateurs signalent une lenteur du reseau.', '2024-01-11', '2024-01-12', 'OUVERT', 11, 1, 'Probleme reseau'),
('BLOQUANT', 'Crash logiciel', 'Logiciel de facturation ne repond pas.', '2024-01-12', '2024-01-13', 'EN_COURS', 12, 2, 'Probleme logiciel'),
('MINEUR', 'Notification manquante', 'Notification push non recues.', '2024-01-13', '2024-01-14', 'RESOLU', 13, 3, 'Probleme interface'),
('MAJEUR', 'Serveur hors ligne', 'Serveur principal inaccessible.', '2024-01-14', '2024-01-15', 'FERME', 14, 4, 'Probleme materiel'),
('BLOQUANT', 'Delai de reponse long', 'Les requetes prennent trop de temps.', '2024-01-15', '2024-01-16', 'OUVERT', 15, 5, 'Probleme de performance'),
('MINEUR', 'Probleme visuel', 'Alignement incorrect dans linterface utilisateur.', '2024-01-16', '2024-01-17', 'EN_COURS', 16, 6, 'Interface utilisateur'),
('MAJEUR', 'Application lente', 'Application tres lente a charger.', '2024-01-17', '2024-01-18', 'RESOLU', 17, 2, 'Performance'),
('MINEUR', 'Lien casse', 'Un lien sur la page est incorrect.', '2024-01-18', '2024-01-19', 'FERME', 18, 3, 'Probleme interface'),
('BLOQUANT', 'Blocage total', 'Le systeme ne redemarre pas.', '2024-01-19', '2024-01-20', 'EN_COURS', 19, 4, 'Probleme materiel'),
('MAJEUR', 'Temps de reponse', 'Les pages mettent beaucoup de temps a charger.', '2024-01-20', '2024-01-21', 'OUVERT', 20, 5, 'Performance materielle');
