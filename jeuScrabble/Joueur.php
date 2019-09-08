<?php
require("Connexion.php");	
    $numero=$_GET['numero'];
    function getJoueur(){
        $get=$_GET['get'];
        $req="";
        if($get==1){
            $req="select * from joueur";    
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
        $sql = "insert into Joueur value(NULL,'".$_GET['nomJoueur']."','".$_GET['description']."',0,0,0,'L')";
	   mysqli_query(connection(),$sql) ;    
    }
    function update(){
        $sql = "update Joueur set tour='".$_GET['tour']."' where idJoueur=".$_GET['idJoueur'];
	   mysqli_query(connection(),$sql) ;    
    }
    function update1(){
        $sql = "update Joueur set nomJoueur='".$_GET['nomJoueur']."' where idJoueur=".$_GET['idJoueur'];
	   mysqli_query(connection(),$sql) ;    
    }
    function principale($numero){
        if($numero==1){
            getJoueur();
        }else if($numero==2){
            insertion();
        }else if($numero==3){
            update();
        }else if($numero==4){
            update1();
        }
    }
    principale($numero);
	
?>