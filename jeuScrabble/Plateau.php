<?php
require("Connexion.php");	
    $numero=$_GET['numero'];
    function get(){
        $get=$_GET['get'];
        $req="";
        if($get==1){
            $req="select * from plateau";    
        }else if($get==2){
            $req="select * from plateau where idPartie='".$_GET['idPartie']."'";
        }else if($get==3){
            $req="SELECT * FROM `plateau` WHERE idPartie='".$_GET['idPartie']."' LIMIT 1";
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
        $sql = "INSERT INTO `plateau` (`idPlateau`, `idPartie`, `indiceX`, `indiceY`, `lettre`, `image`, `ancienImage`) VALUES (NULL, '".$_GET['idPartie']."', '".$_GET['indiceX']."', '".$_GET['indiceY']."', '".$_GET['lettre']."', '".$_GET['image']."', '".$_GET['ancienImage']."')";
	    mysqli_query(connection(),$sql) ; 
    }
    function update(){
        $sql = "update plateau set lettre='".$_GET['lettre']."',image='".$_GET['image']."',ancienImage='".$_GET['ancienImage']."' where idPartie='".$_GET['idPartie']."' and indiceX='".$_GET['indiceX']."' and indiceY='".$_GET['indiceY']."' ";
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