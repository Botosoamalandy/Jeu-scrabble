<?php
require("Connexion.php");	
    $numero=$_GET['numero'];
    function get(){
        $get=$_GET['get'];
        $req="";
        if($get==1){
            $req="select * from chevaler";    
        }else if($get==2){
            $req="select * from chevaler where idPartie='".$_GET['idPartie']."'";
        }else if($get==3){
            $req="select * from chevaler where idPartie='".$_GET['idPartie']."' and idJoueur='".$_GET['idJoueur']."'";
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
    function insertion(){
        $sql = "INSERT INTO `chevaler` (`idChevalet`, `idPartie`, `lettre`, `couleur`, `idJoueur`) VALUES (NULL,'".$_GET['idPartie']."','L',0,'".$_GET['idJoueur']."')";
	    mysqli_query(connection(),$sql) ; 
    }
    function update(){
        $sql = "UPDATE `chevaler` SET `couleur` = '".$_GET['couleur']."', `lettre`='".$_GET['lettre']."' WHERE `chevaler`.`idPartie` = '".$_GET['idPartie']."' and `idJoueur`='".$_GET['idJoueur']."'";
	    mysqli_query(connection(),$sql) ; 
    }
    function principale($numero){
        if($numero==1){
            get();
        }else if($numero==2){
            insertion();
        }else if($numero==3){
            update();
        }
    }
    principale($numero);
?>