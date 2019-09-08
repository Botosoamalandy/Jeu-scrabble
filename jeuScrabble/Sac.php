<?php
require("Connexion.php");	
    $numero=$_GET['numero'];
    function getPartie(){
        $get=$_GET['get'];
        $req="";
        if($get==1){
            $req="select * from sac";    
        }if($get==2){
            $req="select * from sac where idPartie=".$_GET['idPartie'];    
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
        $sql = "INSERT INTO `sac` (`idSac`, `idPartie`, `lettre`) VALUES (NULL, '".$_GET['idPartie']."', '".$_GET['lettre']."')";
	    mysqli_query(connection(),$sql) ; 
    }
    function update(){
        $sql = "update sac set lettre='".$_GET['lettre']."' where idPartie='".$_GET['idPartie']."'";
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