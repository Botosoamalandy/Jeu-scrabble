<?php
require("Connexion.php");	
    function get(){
        $get=$_GET['get'];
        $req="";
        if($get==1){
            $req="select * from partieDeJeu";    
        }else if($get==2){
            $req="select * from partieDeJeu where nomPartie='".$_GET['nomPartie']."'";
        }else if($get==3){
            $req="select * from partieDeJeu where idPartie='".$_GET['idPartie']."'";
        }else if($get==4){
            $req="select * from partieDeJeu where idPartie='".$_GET['idPartie']."' and idJoueur='".$_GET['idJoueur']."'";
        }else if($get==5){
            $req="select * from partieDeJeu where idJoueur='".$_GET['idJoueur']."'";
        }
        $result= mysqli_query(connection(),$req);
        $valiny=array();
            while($donnees=mysqli_fetch_array($result)){
                $valiny[]=$donnees;
            }
            mysqli_free_result($result);
        $k=json_encode($valiny);
	    echo($k);
    }
    get();
	
?> 