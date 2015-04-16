<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="description" content="Ma page web" />
    <meta name="keywords" content="HTML5,CSS3,JavaScript,PHP" />
    <meta name="author" content="Alexandre Sudreau" />
	<title>TP7 PHP</title>
</head>
<body>

<?php
    //Declaration initiale des variables, démarrage de la session, initialisation du compteur
    $mot = "LAMPE";
    $cache = "*****";
    session_start();
    if(!isset($_SESSION['count'])){
        $_SESSION['count'] = 10;
    } 
    
    //Reconnaissance de la lettre et assignation dans la variable de session
    if(!isset($_SESSION['word'])){
        $_SESSION['word'] = $cache;
    }
    else{
        if($_GET){
            $bool = false;
            for($j=0;$j<strlen($mot);$j++){
                if($_GET['lettre']==$mot[$j]){
                    $_SESSION['word'][$j]=$_GET['lettre'];
                    $bool=true;
                }
            }
            //Incrémentation du compteur si la lettre sélectionnée ne fait pas partie du mot
            if(!$bool){
                $_SESSION['count']--;
            }
            //Condition de sortie de la session : mot entier trouvé
            if($_SESSION['word'] == $mot){
                echo "<script>alert('Le mot est complet !')</script>";
                session_destroy();
            }
        }
    }
    
    //Vérification du compteur
    if($_SESSION['count'] == 0){
        echo "<script>alert('Vous avez perdu !');</script>";
        $_SESSION['word'] = $mot;
        session_destroy();
    }
    
    //Affichage du mot et du compteur
    echo "<p style=display:block;font-size:30px;text-align:center;>".$_SESSION['word']."</p>";
    echo '<input type=button value="Nombre d\'essais restants : '.$_SESSION['count'].'" disabled=true/>';
    
    //Affichage des lettres
    for($i=65;$i<=90;$i++){
        $c = chr($i);
        echo '<a href="Pendu.php?lettre='.$c.'" style=margin:10px;>'.$c.'</a>';
    }
    
    
    
?>

</body>
</html>