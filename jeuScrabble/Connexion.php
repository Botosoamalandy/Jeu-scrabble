<?php 
    function connection(){
        static $connecter=null;
        if($connecter===null){
             $connecter=mysqli_connect("localhost","root","root","jeu");
        }
        return $connecter;
    } 

?>