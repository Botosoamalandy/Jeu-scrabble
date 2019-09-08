<?php
require("Connexion.php");	
    $numero=$_GET['numero'];
    function getPartie(){
        $get=$_GET['get'];
        $req="";
        if($get==1){
            $req="select * from partie";    
        }else if($get==2){
            $req="select * from partie where nomPartie='".$_GET['nomPartie']."'";
        }else if($get==3){
            $req="select * from partie where idPartie='".$_GET['idPartie']."'";
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
        $sql = "insert into partie value(NULL,'".$_GET['nomPartie']."',now(),0,0)";
	   mysqli_query(connection(),$sql) ;    
    }
    function update(){
        $sql = "update partie set  premierCoup=1 where idPartie='".$_GET['idPartie']."'";
	   mysqli_query(connection(),$sql) ;    
    }
    function update1(){
        $sql = "update partie set  fin=1 where idPartie='".$_GET['idPartie']."'";
	   mysqli_query(connection(),$sql) ;    
    }
    function principale($numero){
        if($numero==1){
            getPartie();
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


