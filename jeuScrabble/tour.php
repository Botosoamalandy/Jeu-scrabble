<?php
require("Connexion.php");	
    $numero=$_GET['numero'];
    function get(){
        $get=$_GET['get'];
        $req="";
        if($get==1){
            $req="select * from tour where idPartie='".$_GET['idPartie']."'";
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
        $sql = "INSERT INTO `tour` (`idTour`, `idPartie`, `rang`, `idJoueur`) VALUES (NULL, '".$_GET['idPartie']."', '".$_GET['rang']."', '".$_GET['idJoueur']."')";
	    mysqli_query(connection(),$sql) ; 
    }
    function update(){
        $sql = "update tour set idJoueur='".$_GET['idJoueur']."'  where idPartie='".$_GET['idPartie']."'";
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