<?php
require("Connexion.php");	
    $numero=$_GET['numero'];
    function getPartie(){
        $get=$_GET['get'];
        $req="";
        if($get==1){
            $req="select * from parametre";    
        }else if($get==2){
            $req="select * from parametre where idPartie=".$_GET['idPartie'];    
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
        $sql = "INSERT INTO `parametre` (`idParametre`, `idPartie`, `nombreDeJoueur`, `scoreMax`,`langue`) VALUES (NULL, '".$_GET['idPartie']."', '".$_GET['nombreDeJoueur']."',0,1)";
	    mysqli_query(connection(),$sql) ; 
    }
    function update(){
        $sql = "update parametre set scoreMax=".$_GET['scoreMax']." where idParametre=".$_GET['idParametre'];
	   mysqli_query(connection(),$sql) ;    
    }
    function principale($numero){
        if($numero==1){
            getPartie();
        }else if($numero==2){
            insertion();
        }else if($numero==3){
            update();
        }
    }
    principale($numero);
	
?>