-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 29 oct. 2021 à 23:19
-- Version du serveur : 10.4.21-MariaDB
-- Version de PHP : 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_rendezvous`
--

-- --------------------------------------------------------

--
-- Structure de la table `antecedent`
--

CREATE TABLE `antecedent` (
  `id` int(11) NOT NULL,
  `libelleA` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `antecedent`
--

INSERT INTO `antecedent` (`id`, `libelleA`) VALUES
(1, 'HYPERTENSION'),
(2, 'HEPATITE'),
(3, 'COVID 19'),
(4, 'PALUDISME');

-- --------------------------------------------------------

--
-- Structure de la table `con&cons`
--

CREATE TABLE `con&cons` (
  `consultation_id` int(11) NOT NULL,
  `constante_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `con&cons`
--

INSERT INTO `con&cons` (`consultation_id`, `constante_id`) VALUES
(1, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `constante`
--

CREATE TABLE `constante` (
  `id` int(11) NOT NULL,
  `libellec` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `constante`
--

INSERT INTO `constante` (`id`, `libellec`) VALUES
(1, 'TEMPERATURE'),
(2, 'TENSION');

-- --------------------------------------------------------

--
-- Structure de la table `historique`
--

CREATE TABLE `historique` (
  `patient_id` int(11) NOT NULL,
  `antecedent_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `historique`
--

INSERT INTO `historique` (`patient_id`, `antecedent_id`) VALUES
(1, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `medicament`
--

CREATE TABLE `medicament` (
  `id` int(11) NOT NULL,
  `code` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `medicament`
--

INSERT INTO `medicament` (`id`, `code`, `nom`) VALUES
(1, 'EAEAEZ434', 'DOLIPRANE'),
(2, 'EZEZFEZ23', 'PANADOLE');

-- --------------------------------------------------------

--
-- Structure de la table `ordonnance`
--

CREATE TABLE `ordonnance` (
  `id` int(11) NOT NULL,
  `posologie` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `ordonnance`
--

INSERT INTO `ordonnance` (`id`, `posologie`) VALUES
(1, '2C - J\r\n1 matin\r\n1 soir'),
(2, '3C - J\r\n1-matin \r\n1-midi\r\n1-soir');

-- --------------------------------------------------------

--
-- Structure de la table `prescription`
--

CREATE TABLE `prescription` (
  `ordonnance_id` int(11) NOT NULL,
  `medicament_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `prescription`
--

INSERT INTO `prescription` (`ordonnance_id`, `medicament_id`) VALUES
(1, 1),
(1, 2),
(2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `rdv`
--

CREATE TABLE `rdv` (
  `id` int(11) NOT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `medecin_id` int(11) DEFAULT NULL,
  `ordonnance_id` int(11) DEFAULT NULL,
  `consultation_id` int(11) DEFAULT NULL,
  `responsable_id` int(11) DEFAULT NULL,
  `date` date NOT NULL,
  `unarchived` tinyint(1) NOT NULL,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `libellep` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `rdv`
--

INSERT INTO `rdv` (`id`, `patient_id`, `medecin_id`, `ordonnance_id`, `consultation_id`, `responsable_id`, `date`, `unarchived`, `type`, `libellep`) VALUES
(2, 1, 4, 1, NULL, NULL, '2021-10-05', 1, 'TYPE_CONSULTATION', NULL),
(3, 1, NULL, NULL, 2, 3, '2021-10-25', 1, 'TYPE_PRESTATION', 'FIEVRE THYFOIDE'),
(4, NULL, NULL, NULL, NULL, NULL, '2021-10-13', 0, 'TYPE_CONSULTATION', NULL),
(5, NULL, NULL, NULL, NULL, NULL, '2021-10-08', 0, 'TYPE_PRESTATION', 'NFS'),
(6, 1, NULL, NULL, NULL, NULL, '2021-10-10', 0, 'TYPE_PRESTATION', 'ELECTROPHORESE'),
(7, 1, NULL, NULL, NULL, NULL, '2021-09-30', 0, 'TYPE_CONSULTATION', '');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `login` varchar(180) COLLATE utf8mb4_unicode_ci NOT NULL,
  `role` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nom_complet` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `antecedent_id` int(11) NOT NULL,
  `statut` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `disponible` tinyint(1) DEFAULT NULL,
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `login`, `role`, `nom_complet`, `password`, `antecedent_id`, `statut`, `disponible`, `code`) VALUES
(1, 'patient@gmail.com', 'ROLE_PATIENT', 'DIVINE OLAFA', 'passer@123', 1, NULL, 0, 'ARI21R1R3'),
(2, 'secretaire@gmail.com', 'ROLE_SECRETAIRE', 'CINDY ADOU', 'passer@123', 0, NULL, NULL, NULL),
(3, 'rp@gmail.com', 'ROLE_RESPONSABLE', 'IVAN YAMEOGO', 'passer@123', 0, NULL, NULL, NULL),
(4, 'medecin@gmail.com', 'ROLE_MEDECIN', 'HUGUES ADAISSO', 'passer@123', 0, 'NEUROLOGUE', 1, NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `antecedent`
--
ALTER TABLE `antecedent`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `con&cons`
--
ALTER TABLE `con&cons`
  ADD PRIMARY KEY (`consultation_id`,`constante_id`);

--
-- Index pour la table `constante`
--
ALTER TABLE `constante`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `historique`
--
ALTER TABLE `historique`
  ADD PRIMARY KEY (`patient_id`,`antecedent_id`);

--
-- Index pour la table `medicament`
--
ALTER TABLE `medicament`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `ordonnance`
--
ALTER TABLE `ordonnance`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `prescription`
--
ALTER TABLE `prescription`
  ADD PRIMARY KEY (`ordonnance_id`,`medicament_id`);

--
-- Index pour la table `rdv`
--
ALTER TABLE `rdv`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UNIQ_8D93D649AA08CB10` (`login`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `antecedent`
--
ALTER TABLE `antecedent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `constante`
--
ALTER TABLE `constante`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `medicament`
--
ALTER TABLE `medicament`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `ordonnance`
--
ALTER TABLE `ordonnance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `rdv`
--
ALTER TABLE `rdv`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `con&cons`
--
ALTER TABLE `con&cons`
  ADD CONSTRAINT `FK_C1EB5C8E62FF6CDF` FOREIGN KEY (`consultation_id`) REFERENCES `rdv` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `historique`
--
ALTER TABLE `historique`
  ADD CONSTRAINT `FK_87A618936B899279` FOREIGN KEY (`patient_id`) REFERENCES `user` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `prescription`
--
ALTER TABLE `prescription`
  ADD CONSTRAINT `FK_FE7DFAEE2BF23B8F` FOREIGN KEY (`ordonnance_id`) REFERENCES `ordonnance` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `rdv`
--
ALTER TABLE `rdv`
  ADD CONSTRAINT `FK_10C31F862BF23B8F` FOREIGN KEY (`ordonnance_id`) REFERENCES `ordonnance` (`id`),
  ADD CONSTRAINT `FK_10C31F864F31A84` FOREIGN KEY (`medecin_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_10C31F8653C59D72` FOREIGN KEY (`responsable_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_10C31F8662FF6CDF` FOREIGN KEY (`consultation_id`) REFERENCES `rdv` (`id`),
  ADD CONSTRAINT `FK_10C31F866B899279` FOREIGN KEY (`patient_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
