-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 08, 2019 at 05:26 PM
-- Server version: 5.7.11
-- PHP Version: 5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jeu`
--

-- --------------------------------------------------------

--
-- Table structure for table `chevaler`
--

CREATE TABLE `chevaler` (
  `idChevalet` int(11) NOT NULL,
  `idPartie` int(11) NOT NULL,
  `lettre` varchar(20) NOT NULL,
  `couleur` int(11) NOT NULL,
  `idJoueur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chevaler`
--

INSERT INTO `chevaler` (`idChevalet`, `idPartie`, `lettre`, `couleur`, `idJoueur`) VALUES
(34, 19, 'PAOSHFR', 1, 1),
(35, 19, 'REHUALI', 1, 6);

-- --------------------------------------------------------

--
-- Table structure for table `joueur`
--

CREATE TABLE `joueur` (
  `idJoueur` int(11) NOT NULL,
  `nomJoueur` varchar(30) NOT NULL,
  `description` varchar(40) NOT NULL,
  `rand` int(11) NOT NULL,
  `tour` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  `chevaler` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `joueur`
--

INSERT INTO `joueur` (`idJoueur`, `nomJoueur`, `description`, `rand`, `tour`, `score`, `chevaler`) VALUES
(1, 'Malandy', 'Je suis moi', 0, 0, 0, 'L'),
(4, 'Marivelo', 'Description_vide', 0, 0, 0, 'L'),
(5, 'Botosoamalandy', 'Description_vide', 0, 0, 0, 'L'),
(6, 'Heritiana', 'Description_vide', 0, 0, 0, 'L');

-- --------------------------------------------------------

--
-- Table structure for table `mottrouver`
--

CREATE TABLE `mottrouver` (
  `idMotTrouver` int(11) NOT NULL,
  `idPartie` int(11) NOT NULL,
  `idJoueur` int(11) NOT NULL,
  `mot` varchar(30) NOT NULL,
  `point` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mottrouver`
--

INSERT INTO `mottrouver` (`idMotTrouver`, `idPartie`, `idJoueur`, `mot`, `point`) VALUES
(111, 19, 6, 'VAS', 36),
(112, 19, 1, 'SAC', 9),
(113, 19, 6, 'SI', 5);

-- --------------------------------------------------------

--
-- Table structure for table `parametre`
--

CREATE TABLE `parametre` (
  `idParametre` int(11) NOT NULL,
  `idPartie` int(11) NOT NULL,
  `nombreDeJoueur` int(11) NOT NULL,
  `scoreMax` double NOT NULL,
  `langue` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `parametre`
--

INSERT INTO `parametre` (`idParametre`, `idPartie`, `nombreDeJoueur`, `scoreMax`, `langue`) VALUES
(18, 19, 2, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `partie`
--

CREATE TABLE `partie` (
  `idPartie` int(11) NOT NULL,
  `nomPartie` varchar(30) NOT NULL,
  `datePartie` date NOT NULL,
  `premierCoup` int(11) NOT NULL,
  `fin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `partie`
--

INSERT INTO `partie` (`idPartie`, `nomPartie`, `datePartie`, `premierCoup`, `fin`) VALUES
(19, 'Scrabble_botosoamalandy', '2019-09-08', 1, 1);

-- --------------------------------------------------------

--
-- Stand-in structure for view `partiedejeu`
--
CREATE TABLE `partiedejeu` (
`idPartie` int(11)
,`nomPartie` varchar(30)
,`datePartie` date
,`idServeur` int(11)
,`serveur` int(11)
,`idJoueur` int(11)
,`nomJoueur` varchar(30)
,`description` varchar(40)
,`rand` int(11)
,`tour` int(11)
,`score` int(11)
,`chevaler` varchar(10)
);

-- --------------------------------------------------------

--
-- Table structure for table `plateau`
--

CREATE TABLE `plateau` (
  `idPlateau` int(11) NOT NULL,
  `idPartie` int(11) NOT NULL,
  `indiceX` int(11) NOT NULL,
  `indiceY` int(11) NOT NULL,
  `lettre` varchar(5) NOT NULL,
  `image` varchar(20) NOT NULL,
  `ancienImage` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `plateau`
--

INSERT INTO `plateau` (`idPlateau`, `idPartie`, `indiceX`, `indiceY`, `lettre`, `image`, `ancienImage`) VALUES
(2704, 19, 0, 0, '', 'fond6.jpg', 'fond6.jpg'),
(2705, 19, 0, 1, '', 'fond.jpg', 'fond.jpg'),
(2706, 19, 0, 2, '', 'fond.jpg', 'fond.jpg'),
(2707, 19, 0, 3, '', 'fond5.jpg', 'fond5.jpg'),
(2708, 19, 0, 4, '', 'fond.jpg', 'fond.jpg'),
(2709, 19, 0, 5, '', 'fond.jpg', 'fond.jpg'),
(2710, 19, 0, 6, '', 'fond.jpg', 'fond.jpg'),
(2711, 19, 0, 7, '', 'fond6.jpg', 'fond6.jpg'),
(2712, 19, 0, 8, '', 'fond.jpg', 'fond.jpg'),
(2713, 19, 0, 9, '', 'fond.jpg', 'fond.jpg'),
(2714, 19, 0, 10, '', 'fond.jpg', 'fond.jpg'),
(2715, 19, 0, 11, '', 'fond5.jpg', 'fond5.jpg'),
(2716, 19, 0, 12, '', 'fond.jpg', 'fond.jpg'),
(2717, 19, 0, 13, '', 'fond.jpg', 'fond.jpg'),
(2718, 19, 0, 14, '', 'fond6.jpg', 'fond6.jpg'),
(2719, 19, 1, 0, '', 'fond.jpg', 'fond.jpg'),
(2720, 19, 1, 1, '', 'fond7.jpg', 'fond7.jpg'),
(2721, 19, 1, 2, '', 'fond.jpg', 'fond.jpg'),
(2722, 19, 1, 3, '', 'fond.jpg', 'fond.jpg'),
(2723, 19, 1, 4, '', 'fond.jpg', 'fond.jpg'),
(2724, 19, 1, 5, '', 'fond4.jpg', 'fond4.jpg'),
(2725, 19, 1, 6, '', 'fond.jpg', 'fond.jpg'),
(2726, 19, 1, 7, '', 'fond.jpg', 'fond.jpg'),
(2727, 19, 1, 8, '', 'fond.jpg', 'fond.jpg'),
(2728, 19, 1, 9, '', 'fond4.jpg', 'fond4.jpg'),
(2729, 19, 1, 10, '', 'fond.jpg', 'fond.jpg'),
(2730, 19, 1, 11, '', 'fond.jpg', 'fond.jpg'),
(2731, 19, 1, 12, '', 'fond.jpg', 'fond.jpg'),
(2732, 19, 1, 13, '', 'fond7.jpg', 'fond7.jpg'),
(2733, 19, 1, 14, '', 'fond.jpg', 'fond.jpg'),
(2734, 19, 2, 0, '', 'fond.jpg', 'fond.jpg'),
(2735, 19, 2, 1, '', 'fond.jpg', 'fond.jpg'),
(2736, 19, 2, 2, '', 'fond7.jpg', 'fond7.jpg'),
(2737, 19, 2, 3, '', 'fond.jpg', 'fond.jpg'),
(2738, 19, 2, 4, '', 'fond.jpg', 'fond.jpg'),
(2739, 19, 2, 5, '', 'fond.jpg', 'fond.jpg'),
(2740, 19, 2, 6, '', 'fond5.jpg', 'fond5.jpg'),
(2741, 19, 2, 7, '', 'fond.jpg', 'fond.jpg'),
(2742, 19, 2, 8, '', 'fond5.jpg', 'fond5.jpg'),
(2743, 19, 2, 9, '', 'fond.jpg', 'fond.jpg'),
(2744, 19, 2, 10, '', 'fond.jpg', 'fond.jpg'),
(2745, 19, 2, 11, '', 'fond.jpg', 'fond.jpg'),
(2746, 19, 2, 12, '', 'fond7.jpg', 'fond7.jpg'),
(2747, 19, 2, 13, '', 'fond.jpg', 'fond.jpg'),
(2748, 19, 2, 14, '', 'fond.jpg', 'fond.jpg'),
(2749, 19, 3, 0, '', 'fond5.jpg', 'fond5.jpg'),
(2750, 19, 3, 1, '', 'fond.jpg', 'fond.jpg'),
(2751, 19, 3, 2, '', 'fond.jpg', 'fond.jpg'),
(2752, 19, 3, 3, '', 'fond7.jpg', 'fond7.jpg'),
(2753, 19, 3, 4, '', 'fond.jpg', 'fond.jpg'),
(2754, 19, 3, 5, '', 'fond.jpg', 'fond.jpg'),
(2755, 19, 3, 6, '', 'fond.jpg', 'fond.jpg'),
(2756, 19, 3, 7, '', 'fond5.jpg', 'fond5.jpg'),
(2757, 19, 3, 8, '', 'fond.jpg', 'fond.jpg'),
(2758, 19, 3, 9, '', 'fond.jpg', 'fond.jpg'),
(2759, 19, 3, 10, '', 'fond.jpg', 'fond.jpg'),
(2760, 19, 3, 11, '', 'fond7.jpg', 'fond7.jpg'),
(2761, 19, 3, 12, '', 'fond.jpg', 'fond.jpg'),
(2762, 19, 3, 13, '', 'fond.jpg', 'fond.jpg'),
(2763, 19, 3, 14, '', 'fond5.jpg', 'fond5.jpg'),
(2764, 19, 4, 0, '', 'fond.jpg', 'fond.jpg'),
(2765, 19, 4, 1, '', 'fond.jpg', 'fond.jpg'),
(2766, 19, 4, 2, '', 'fond.jpg', 'fond.jpg'),
(2767, 19, 4, 3, '', 'fond.jpg', 'fond.jpg'),
(2768, 19, 4, 4, '', 'fond7.jpg', 'fond7.jpg'),
(2769, 19, 4, 5, '', 'fond.jpg', 'fond.jpg'),
(2770, 19, 4, 6, '', 'fond.jpg', 'fond.jpg'),
(2771, 19, 4, 7, '', 'fond.jpg', 'fond.jpg'),
(2772, 19, 4, 8, '', 'fond.jpg', 'fond.jpg'),
(2773, 19, 4, 9, '', 'fond.jpg', 'fond.jpg'),
(2774, 19, 4, 10, '', 'fond7.jpg', 'fond7.jpg'),
(2775, 19, 4, 11, '', 'fond.jpg', 'fond.jpg'),
(2776, 19, 4, 12, '', 'fond.jpg', 'fond.jpg'),
(2777, 19, 4, 13, '', 'fond.jpg', 'fond.jpg'),
(2778, 19, 4, 14, '', 'fond.jpg', 'fond.jpg'),
(2779, 19, 5, 0, '', 'fond.jpg', 'fond.jpg'),
(2780, 19, 5, 1, '', 'fond4.jpg', 'fond4.jpg'),
(2781, 19, 5, 2, '', 'fond.jpg', 'fond.jpg'),
(2782, 19, 5, 3, '', 'fond.jpg', 'fond.jpg'),
(2783, 19, 5, 4, '', 'fond.jpg', 'fond.jpg'),
(2784, 19, 5, 5, '', 'fond4.jpg', 'fond4.jpg'),
(2785, 19, 5, 6, '', 'fond.jpg', 'fond.jpg'),
(2786, 19, 5, 7, '', 'fond.jpg', 'fond.jpg'),
(2787, 19, 5, 8, '', 'fond.jpg', 'fond.jpg'),
(2788, 19, 5, 9, '', 'fond4.jpg', 'fond4.jpg'),
(2789, 19, 5, 10, '', 'fond.jpg', 'fond.jpg'),
(2790, 19, 5, 11, '', 'fond.jpg', 'fond.jpg'),
(2791, 19, 5, 12, '', 'fond.jpg', 'fond.jpg'),
(2792, 19, 5, 13, '', 'fond4.jpg', 'fond4.jpg'),
(2793, 19, 5, 14, '', 'fond.jpg', 'fond.jpg'),
(2794, 19, 6, 0, '', 'fond.jpg', 'fond.jpg'),
(2795, 19, 6, 1, '', 'fond.jpg', 'fond.jpg'),
(2796, 19, 6, 2, '', 'fond5.jpg', 'fond5.jpg'),
(2797, 19, 6, 3, '', 'fond.jpg', 'fond.jpg'),
(2798, 19, 6, 4, '', 'fond.jpg', 'fond.jpg'),
(2799, 19, 6, 5, '', 'fond.jpg', 'fond.jpg'),
(2800, 19, 6, 6, '', 'fond5.jpg', 'fond5.jpg'),
(2801, 19, 6, 7, '', 'fond.jpg', 'fond.jpg'),
(2802, 19, 6, 8, '', 'fond5.jpg', 'fond5.jpg'),
(2803, 19, 6, 9, '', 'fond.jpg', 'fond.jpg'),
(2804, 19, 6, 10, '', 'fond.jpg', 'fond.jpg'),
(2805, 19, 6, 11, '', 'fond.jpg', 'fond.jpg'),
(2806, 19, 6, 12, '', 'fond5.jpg', 'fond5.jpg'),
(2807, 19, 6, 13, '', 'fond.jpg', 'fond.jpg'),
(2808, 19, 6, 14, '', 'fond.jpg', 'fond.jpg'),
(2809, 19, 7, 0, '', 'fond6.jpg', 'fond6.jpg'),
(2810, 19, 7, 1, '', 'fond.jpg', 'fond.jpg'),
(2811, 19, 7, 2, '', 'fond.jpg', 'fond.jpg'),
(2812, 19, 7, 3, '', 'fond5.jpg', 'fond5.jpg'),
(2813, 19, 7, 4, '', 'fond.jpg', 'fond.jpg'),
(2814, 19, 7, 5, '', 'fond.jpg', 'fond.jpg'),
(2815, 19, 7, 6, '', 'fond.jpg', 'fond.jpg'),
(2816, 19, 7, 7, 'V', '22.jpg', '22.jpg'),
(2817, 19, 7, 8, '', 'fond.jpg', 'fond.jpg'),
(2818, 19, 7, 9, '', 'fond.jpg', 'fond.jpg'),
(2819, 19, 7, 10, '', 'fond.jpg', 'fond.jpg'),
(2820, 19, 7, 11, '', 'fond5.jpg', 'fond5.jpg'),
(2821, 19, 7, 12, '', 'fond.jpg', 'fond.jpg'),
(2822, 19, 7, 13, '', 'fond.jpg', 'fond.jpg'),
(2823, 19, 7, 14, '', 'fond6.jpg', 'fond6.jpg'),
(2824, 19, 8, 0, '', 'fond.jpg', 'fond.jpg'),
(2825, 19, 8, 1, '', 'fond.jpg', 'fond.jpg'),
(2826, 19, 8, 2, '', 'fond5.jpg', 'fond5.jpg'),
(2827, 19, 8, 3, '', 'fond.jpg', 'fond.jpg'),
(2828, 19, 8, 4, '', 'fond.jpg', 'fond.jpg'),
(2829, 19, 8, 5, '', 'fond.jpg', 'fond.jpg'),
(2830, 19, 8, 6, 'S', '19.jpg', '19.jpg'),
(2831, 19, 8, 7, 'A', '1.jpg', '1.jpg'),
(2832, 19, 8, 8, 'C', '3.jpg', '3.jpg'),
(2833, 19, 8, 9, '', 'fond.jpg', 'fond.jpg'),
(2834, 19, 8, 10, '', 'fond.jpg', 'fond.jpg'),
(2835, 19, 8, 11, '', 'fond.jpg', 'fond.jpg'),
(2836, 19, 8, 12, '', 'fond5.jpg', 'fond5.jpg'),
(2837, 19, 8, 13, '', 'fond.jpg', 'fond.jpg'),
(2838, 19, 8, 14, '', 'fond.jpg', 'fond.jpg'),
(2839, 19, 9, 0, '', 'fond.jpg', 'fond.jpg'),
(2840, 19, 9, 1, '', 'fond4.jpg', 'fond4.jpg'),
(2841, 19, 9, 2, '', 'fond.jpg', 'fond.jpg'),
(2842, 19, 9, 3, '', 'fond.jpg', 'fond.jpg'),
(2843, 19, 9, 4, '', 'fond.jpg', 'fond.jpg'),
(2844, 19, 9, 5, '', 'fond4.jpg', 'fond4.jpg'),
(2845, 19, 9, 6, 'I', '9.jpg', '9.jpg'),
(2846, 19, 9, 7, 'S', '19.jpg', '19.jpg'),
(2847, 19, 9, 8, '', 'fond.jpg', 'fond.jpg'),
(2848, 19, 9, 9, '', 'fond4.jpg', 'fond4.jpg'),
(2849, 19, 9, 10, '', 'fond.jpg', 'fond.jpg'),
(2850, 19, 9, 11, '', 'fond.jpg', 'fond.jpg'),
(2851, 19, 9, 12, '', 'fond.jpg', 'fond.jpg'),
(2852, 19, 9, 13, '', 'fond4.jpg', 'fond4.jpg'),
(2853, 19, 9, 14, '', 'fond.jpg', 'fond.jpg'),
(2854, 19, 10, 0, '', 'fond.jpg', 'fond.jpg'),
(2855, 19, 10, 1, '', 'fond.jpg', 'fond.jpg'),
(2856, 19, 10, 2, '', 'fond.jpg', 'fond.jpg'),
(2857, 19, 10, 3, '', 'fond.jpg', 'fond.jpg'),
(2858, 19, 10, 4, '', 'fond7.jpg', 'fond7.jpg'),
(2859, 19, 10, 5, '', 'fond.jpg', 'fond.jpg'),
(2860, 19, 10, 6, '', 'fond.jpg', 'fond.jpg'),
(2861, 19, 10, 7, '', 'fond.jpg', 'fond.jpg'),
(2862, 19, 10, 8, '', 'fond.jpg', 'fond.jpg'),
(2863, 19, 10, 9, '', 'fond.jpg', 'fond.jpg'),
(2864, 19, 10, 10, '', 'fond7.jpg', 'fond7.jpg'),
(2865, 19, 10, 11, '', 'fond.jpg', 'fond.jpg'),
(2866, 19, 10, 12, '', 'fond.jpg', 'fond.jpg'),
(2867, 19, 10, 13, '', 'fond.jpg', 'fond.jpg'),
(2868, 19, 10, 14, '', 'fond.jpg', 'fond.jpg'),
(2869, 19, 11, 0, '', 'fond5.jpg', 'fond5.jpg'),
(2870, 19, 11, 1, '', 'fond.jpg', 'fond.jpg'),
(2871, 19, 11, 2, '', 'fond.jpg', 'fond.jpg'),
(2872, 19, 11, 3, '', 'fond7.jpg', 'fond7.jpg'),
(2873, 19, 11, 4, '', 'fond.jpg', 'fond.jpg'),
(2874, 19, 11, 5, '', 'fond.jpg', 'fond.jpg'),
(2875, 19, 11, 6, '', 'fond.jpg', 'fond.jpg'),
(2876, 19, 11, 7, '', 'fond5.jpg', 'fond5.jpg'),
(2877, 19, 11, 8, '', 'fond.jpg', 'fond.jpg'),
(2878, 19, 11, 9, '', 'fond.jpg', 'fond.jpg'),
(2879, 19, 11, 10, '', 'fond.jpg', 'fond.jpg'),
(2880, 19, 11, 11, '', 'fond7.jpg', 'fond7.jpg'),
(2881, 19, 11, 12, '', 'fond.jpg', 'fond.jpg'),
(2882, 19, 11, 13, '', 'fond.jpg', 'fond.jpg'),
(2883, 19, 11, 14, '', 'fond5.jpg', 'fond5.jpg'),
(2884, 19, 12, 0, '', 'fond.jpg', 'fond.jpg'),
(2885, 19, 12, 1, '', 'fond.jpg', 'fond.jpg'),
(2886, 19, 12, 2, '', 'fond7.jpg', 'fond7.jpg'),
(2887, 19, 12, 3, '', 'fond.jpg', 'fond.jpg'),
(2888, 19, 12, 4, '', 'fond.jpg', 'fond.jpg'),
(2889, 19, 12, 5, '', 'fond.jpg', 'fond.jpg'),
(2890, 19, 12, 6, '', 'fond5.jpg', 'fond5.jpg'),
(2891, 19, 12, 7, '', 'fond.jpg', 'fond.jpg'),
(2892, 19, 12, 8, '', 'fond5.jpg', 'fond5.jpg'),
(2893, 19, 12, 9, '', 'fond.jpg', 'fond.jpg'),
(2894, 19, 12, 10, '', 'fond.jpg', 'fond.jpg'),
(2895, 19, 12, 11, '', 'fond.jpg', 'fond.jpg'),
(2896, 19, 12, 12, '', 'fond7.jpg', 'fond7.jpg'),
(2897, 19, 12, 13, '', 'fond.jpg', 'fond.jpg'),
(2898, 19, 12, 14, '', 'fond.jpg', 'fond.jpg'),
(2899, 19, 13, 0, '', 'fond.jpg', 'fond.jpg'),
(2900, 19, 13, 1, '', 'fond7.jpg', 'fond7.jpg'),
(2901, 19, 13, 2, '', 'fond.jpg', 'fond.jpg'),
(2902, 19, 13, 3, '', 'fond.jpg', 'fond.jpg'),
(2903, 19, 13, 4, '', 'fond.jpg', 'fond.jpg'),
(2904, 19, 13, 5, '', 'fond4.jpg', 'fond4.jpg'),
(2905, 19, 13, 6, '', 'fond.jpg', 'fond.jpg'),
(2906, 19, 13, 7, '', 'fond.jpg', 'fond.jpg'),
(2907, 19, 13, 8, '', 'fond.jpg', 'fond.jpg'),
(2908, 19, 13, 9, '', 'fond4.jpg', 'fond4.jpg'),
(2909, 19, 13, 10, '', 'fond.jpg', 'fond.jpg'),
(2910, 19, 13, 11, '', 'fond.jpg', 'fond.jpg'),
(2911, 19, 13, 12, '', 'fond.jpg', 'fond.jpg'),
(2912, 19, 13, 13, '', 'fond7.jpg', 'fond7.jpg'),
(2913, 19, 13, 14, '', 'fond.jpg', 'fond.jpg'),
(2914, 19, 14, 0, '', 'fond6.jpg', 'fond6.jpg'),
(2915, 19, 14, 1, '', 'fond.jpg', 'fond.jpg'),
(2916, 19, 14, 2, '', 'fond.jpg', 'fond.jpg'),
(2917, 19, 14, 3, '', 'fond5.jpg', 'fond5.jpg'),
(2918, 19, 14, 4, '', 'fond.jpg', 'fond.jpg'),
(2919, 19, 14, 5, '', 'fond.jpg', 'fond.jpg'),
(2920, 19, 14, 6, '', 'fond.jpg', 'fond.jpg'),
(2921, 19, 14, 7, '', 'fond6.jpg', 'fond6.jpg'),
(2922, 19, 14, 8, '', 'fond.jpg', 'fond.jpg'),
(2923, 19, 14, 9, '', 'fond.jpg', 'fond.jpg'),
(2924, 19, 14, 10, '', 'fond.jpg', 'fond.jpg'),
(2925, 19, 14, 11, '', 'fond5.jpg', 'fond5.jpg'),
(2926, 19, 14, 12, '', 'fond.jpg', 'fond.jpg'),
(2927, 19, 14, 13, '', 'fond.jpg', 'fond.jpg'),
(2928, 19, 14, 14, '', 'fond6.jpg', 'fond6.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `sac`
--

CREATE TABLE `sac` (
  `idSac` int(11) NOT NULL,
  `idPartie` int(11) NOT NULL,
  `lettre` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sac`
--

INSERT INTO `sac` (`idSac`, `idPartie`, `lettre`) VALUES
(118, 19, 'T,T,I,T,U,U,O,G,Z,E,L,E,D,U,I,N,L,R,A,K,E,A,S,E,B,O,N,R,H,L,J,S,A,Q,T,O,I,Y,E,M,A,N,R,A,A,S,A,O,U,L,E,L,R,T,S,P,E,R,T,F,V,O,F,U,I,E,N,C,H,D,G,T,E,D,E,M,N,B,I,I,S,C,R,U,E,I,S,A,E,O,E,W,0,N,I,M,V,P,0,X,E,E,Z');

-- --------------------------------------------------------

--
-- Table structure for table `serveur`
--

CREATE TABLE `serveur` (
  `idServeur` int(11) NOT NULL,
  `idPartie` int(11) NOT NULL,
  `idJoueur` int(11) NOT NULL,
  `serveur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `serveur`
--

INSERT INTO `serveur` (`idServeur`, `idPartie`, `idJoueur`, `serveur`) VALUES
(44, 19, 1, 1),
(45, 19, 6, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tour`
--

CREATE TABLE `tour` (
  `idTour` int(11) NOT NULL,
  `idPartie` int(11) NOT NULL,
  `rang` varchar(30) NOT NULL,
  `idJoueur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tour`
--

INSERT INTO `tour` (`idTour`, `idPartie`, `rang`, `idJoueur`) VALUES
(12, 19, '1|6|', 6);

-- --------------------------------------------------------

--
-- Structure for view `partiedejeu`
--
DROP TABLE IF EXISTS `partiedejeu`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `partiedejeu`  AS  select `partie`.`idPartie` AS `idPartie`,`partie`.`nomPartie` AS `nomPartie`,`partie`.`datePartie` AS `datePartie`,`serveur`.`idServeur` AS `idServeur`,`serveur`.`serveur` AS `serveur`,`joueur`.`idJoueur` AS `idJoueur`,`joueur`.`nomJoueur` AS `nomJoueur`,`joueur`.`description` AS `description`,`joueur`.`rand` AS `rand`,`joueur`.`tour` AS `tour`,`joueur`.`score` AS `score`,`joueur`.`chevaler` AS `chevaler` from ((`partie` join `serveur` on((`partie`.`idPartie` = `serveur`.`idPartie`))) join `joueur` on((`serveur`.`idJoueur` = `joueur`.`idJoueur`))) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chevaler`
--
ALTER TABLE `chevaler`
  ADD PRIMARY KEY (`idChevalet`);

--
-- Indexes for table `joueur`
--
ALTER TABLE `joueur`
  ADD PRIMARY KEY (`idJoueur`);

--
-- Indexes for table `mottrouver`
--
ALTER TABLE `mottrouver`
  ADD PRIMARY KEY (`idMotTrouver`);

--
-- Indexes for table `parametre`
--
ALTER TABLE `parametre`
  ADD PRIMARY KEY (`idParametre`);

--
-- Indexes for table `partie`
--
ALTER TABLE `partie`
  ADD PRIMARY KEY (`idPartie`);

--
-- Indexes for table `plateau`
--
ALTER TABLE `plateau`
  ADD PRIMARY KEY (`idPlateau`);

--
-- Indexes for table `sac`
--
ALTER TABLE `sac`
  ADD PRIMARY KEY (`idSac`);

--
-- Indexes for table `serveur`
--
ALTER TABLE `serveur`
  ADD PRIMARY KEY (`idServeur`);

--
-- Indexes for table `tour`
--
ALTER TABLE `tour`
  ADD PRIMARY KEY (`idTour`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chevaler`
--
ALTER TABLE `chevaler`
  MODIFY `idChevalet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT for table `joueur`
--
ALTER TABLE `joueur`
  MODIFY `idJoueur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `mottrouver`
--
ALTER TABLE `mottrouver`
  MODIFY `idMotTrouver` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=114;
--
-- AUTO_INCREMENT for table `parametre`
--
ALTER TABLE `parametre`
  MODIFY `idParametre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `partie`
--
ALTER TABLE `partie`
  MODIFY `idPartie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `plateau`
--
ALTER TABLE `plateau`
  MODIFY `idPlateau` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2929;
--
-- AUTO_INCREMENT for table `sac`
--
ALTER TABLE `sac`
  MODIFY `idSac` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=119;
--
-- AUTO_INCREMENT for table `serveur`
--
ALTER TABLE `serveur`
  MODIFY `idServeur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;
--
-- AUTO_INCREMENT for table `tour`
--
ALTER TABLE `tour`
  MODIFY `idTour` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
