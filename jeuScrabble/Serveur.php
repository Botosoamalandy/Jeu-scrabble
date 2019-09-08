<?php
require("Connexion.php");	
    $numero=$_GET['numero'];
    function get(){
        $get=$_GET['get'];
        $req="";
        if($get==1){
            $req="select * from serveur";    
        }else if($get==2){
            $req="select * from serveur where idPartie='".$_GET['idPartie']."'";
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
        $sql = "INSERT INTO `serveur` (`idServeur`, `idPartie`, `idJoueur`, `serveur`) VALUES (NULL, '".$_GET['idPartie']."', '".$_GET['idJoueur']."', '".$_GET['serveur']."')";
	    mysqli_query(connection(),$sql) ; 
    }
    function principale($numero){
        if($numero==1){
            get();
        }else if($numero==2){
            insertion();
        }
    }
    principale($numero);
	
?> 