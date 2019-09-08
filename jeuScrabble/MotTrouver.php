<?php
require("Connexion.php");	
    $numero=$_GET['numero'];
    function get(){
        $get=$_GET['get'];
        $req="";
        if($get==1){
            $req="select * from mottrouver where idPartie='".$_GET['idPartie']."'";
        }if($get==2){
            $req="select * from mottrouver where idPartie='".$_GET['idPartie']."' and idJoueur='".$_GET['idJoueur']."'";
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
        $sql = "INSERT INTO `mottrouver` (`idMotTrouver`, `idPartie`, `idJoueur`, `mot`, `point`) VALUES (NULL, '".$_GET['idPartie']."', '".$_GET['idJoueur']."', '".$_GET['mot']."', '".$_GET['point']."')";
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