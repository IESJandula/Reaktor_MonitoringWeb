<script setup>

</script>

<template>
    <header class="header">
        <div class="logo-header">
            <a href=""><img src="../../public/logo.png" alt="logo"></a>
        </div>
        <div class="nav-menu">
            <input type="checkbox" id="check">
            <ul>
                <li>Mapas</li>
                <li>Profesores</li>
                <li>Alumnos</li>
                <li>Horarios</li>
                <li>Convivencia</li>
                <li>Administración</li>
            </ul>
        </div>
   </header> 
    <div id="Horario">
        <div id="horario-seleccionar-Profesor">
            <form action="#">
                <label for="Profesores">Profesores</label>
                <p></p>
                <select name="Profesores-Horarios" id="Profesores">
                  <option value="Francisco">Francisco Manuel Benitez Chico </option>
                  <option value="Vicente">Vicente Serrano Martínez </option>
                  <option value="Jose">Jose Antonio Sánchez Garcia</option>
                  <option value="Carlos">Carlos Cano Ladera</option>
                  <option value="Raquel">Raquel Molina Mesa</option>
                </select>
                <p></p>
                <input type="submit" value="Enviar" />
          </form>
        </div>
        
        <div id="horario-todos-Profesores">
            <p>Horario de todos los Profesores</p>
            <form action="">
                <button id="button-Horario-Profesores"> Ver </button>
            </form>
        </div>
        
        <div id="horario-seleccionar-grupo">
            <form action="#">
                <label for="Grupos">Grupos</label>
                <p></p>
                <select name="Grupos-Horarios" id="Grupos">
                  <option value="1ESO">1º ESO </option>
                  <option value="2ESO">2º ESO </option>
                  <option value="3ESO">3º ESO </option>
                  <option value="4ESO">4º ESO </option>
                  <option value="1BACH">1º BACH </option>
                  <option value="2Bach">2º BACH </option>
                  <option value="1DAM">1º DAM </option>
                  <option value="1DAW">1º DAW </option>
                  <option value="2DAM">2º DAM </option>
                  <option value="2DAW">2º DAW </option>
                </select>
                <p></p>
                <input type="submit" value="Enviar" />
          </form>
        </div>
        
        <div id="horario-todos-grupos">
            <p>Horario de todos los Grupos</p>
            <form action="">
                <button id="button-Horario-Grupo"> Ver </button>
            </form>
        </div>


    </div>
    <div id="horarios-container">
    <embed type="text/html" src="../../public/Horario.pdf"  width="100%" height="1000px">
    </div>
</template>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap');

*{
    padding: 0;
    margin: 0;
    text-decoration: none;
    list-style: none;
    font-family: 'Open Sans';
}

header{
    background-color: rgb(31, 155, 203);
    display: flex;
    justify-content: space-around;
    align-items: center;
    padding: 0.5rem 2rem; 
}

a, li{
    font-family: Arial, Helvetica, sans-serif;
}

.logo-header img{
    width: 75px;
}

.nav-menu ul{
    display: flex;
    align-items: center;
}

.nav-menu li{
    margin-right: 1.5rem;
    background-color: skyblue;
    border: 2px solid;
    padding: 0.25rem 0.75rem;
    border-radius: 0.2rem;        
}

.nav-menu a{
    color: black;
}

.menu-icon img{
    width: 30px;
    height: 30px;
    border-radius: 2px;
}

.menu-icon, #check{
    display: none;
}

@media (max-width:768px){   /*Si fuera para dispositivos móviles principalmente usaríamos min-width*/
    .checkbtn{
        display: block;
    }
    .menu-icon{
        display: block;
        position: fixed;
        top: 20px;
        right: 20px;
        cursor: pointer;    /*Sale la manita para saber que es clickable*/
    }
    .nav-menu ul{
        display: block;
        position: fixed;
        top:70px;
        left:-100%;
        background: #222;
        width: 100%;
        height: 100vh;
        right: 0;
    }
    .nav-menu ul li{
        padding: 2rem;
        display: flex;
        justify-content: center;
        margin: 0;
    }
    
    #check:checked ~ ul{    /*Aquí accedemos al id check que está en label e input y que afecta a toda la ul*/
        left: 0;    /**/
        transition: all 0.25s;  /*Activamos una transición para que el menú aparezca*/
    }
}
.nav-menu li:first-child{
    background-color: rgb(222, 252, 253) !important;
    border-color: rgb(0, 0, 0);
}
.nav-menu li:first-child a{
    color: rgb(34, 46, 83) !important;
    font-weight: bold !important;
}

@import url('https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap');

.aparece{
    display: block !important;
}

#cuadro, #cuadro2{
    background-color: rgb(215, 243, 252) !important;
    display: none;
    position: absolute;
    top: 40%;
    left: 40%;
    border: 1px solid black;
    border-radius: 10px;
    padding: 15px;
    z-index: 99;
    box-shadow: 10px 10px 10px ;
    transition: all;
    transition: 0.2s;
}

* {
    padding: 0;
    margin: 0;
    font-size: 16px; 
}

body{
    background-color: rgb(243, 235, 243);
    font-family: 'Open Sans';
}

:root {
    --map-width: 300px;
    --map-height: 300px;
    --status-color: red;
}

@keyframes enfasis {
    from {
        background-color: rgba(255, 0, 0, 0);
    }
    to {
        background-color: rgba(29, 117, 218, 0.75);
        border: 1px solid rgb(0, 0, 0);
        box-shadow: 0px 0px 10px 5px red;
    }
  }



.enfasis-aula{
    animation-name: enfasis;
    animation-duration: 0.33s;
    animation-iteration-count: infinite;
    animation-direction: alternate;
}

@media screen and (max-width: 4096px) {
    :root {
        --map-width: 2808px;
        --map-height: 1984px;
    }
}

@media screen and (max-width: 2048px) {
    :root {
        --map-width: 1404px;
        --map-height: 992px;
    }
}

@media screen and (max-width: 1920px) {
    :root {
        --map-width: 1170px;
        --map-height: 827px;
    }
}

@media screen and (max-width: 1440px) {
    :root {
        --map-width: 1100px;
        --map-height: 777px;
    }
}

@media screen and (max-width: 1366px) {
    :root {
        --map-width: 936px;
        --map-height: 662px;
    }
}

@media screen and (max-width: 1280px) {
    :root {
        --map-width: 936px;
        --map-height: 662px;
    }
}

#rotacionActiva {
    font-weight: bold;
    color: var(--status-color);
}
#rotacionNoActiva {
    font-weight: bold;
    color: var(--status-color);
}


#contenedor-botones-plantas{
    display:flex;
    flex-direction: row;
    flex-wrap: wrap;
}


.caja-mapa {
    height: var(--map-height);
    width: var(--map-width);
    border: 3px solid var(--status-color);
    margin-top: 10px;

}

#panel {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    padding: 5px;
    height: 913px;
    width: 310px;
}

#panel>*{
    border-radius: 5px;
    border: 1px solid grey;
    background-color: rgb(255, 255, 255);
    padding:10px;
    margin: 5px;
}

#contenedor-botones-plantas{
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
}

.titulo-djg{
    font-weight: bold;
    margin-bottom: 5px;
}

#panel-selector {
    font-weight: bold;
    display: flex;
    justify-content: center;
}

#djg-main-box{
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    background-color: rgb(241, 241, 224);
}


#contenedor-botones-dimensiones {
    display: none;
    flex-direction: column;
    flex-wrap: wrap;
    align-items: flex-start;
    margin-top:10px;
}

#contenedor-columnas-dimensiones {
    display: flex;
    flex-direction: row;
    justify-content: center;
    width: 100%;
}

.columna-dimensiones{
    display: flex;
    flex-direction: column;
    width: 100%;
}

#selector-dimensiones{
    border-radius: 5px;
    margin: 5px;
    padding: 3px;
}

#contenedor-info-box-endpoints {
    margin-top:10px;
    height: auto;
    background-color: rgb(230, 248, 253);
    transition: 1s;
    transition: all;
}

#selector-curso{
    padding: 3px;
    margin-top: 5px;
    border-radius: 5px;
    background-color: rgb(238, 243, 242);
}

button {
    cursor: pointer;
    color: rgb(0, 0, 0);
    background-color: rgb(238, 243, 242);
    transition: 0.2s;
    border-radius: 5px;
    border: 1px solid black;
    margin: 5px;
    padding: 3px;
}

#contenedor-botones-rotacion button{

    padding-left: 8px;
    padding-right: 8px;
    padding-top: 3px;
    padding-bottom: 3px;
    margin-top: 8px;
    margin-bottom: 8px;
}

#contenedor-botones-rotacion button.boton-active,
#contenedor-botones-dimensiones button.boton-active {
    color: rgb(255, 255, 255);
    background-color:  rgb(31, 155, 203);
    transition: 0.2s;
    padding-top: 8px !important;
    padding-bottom: 8px !important;
    margin-top: 0px !important;
    margin-bottom: 0px !important;
    font-weight: bold;
}

#contenedor-botones-rotacion button:hover,
.columna-dimensiones button:hover {
    color: rgb(0, 0, 0);
    background-color:  rgb(253, 255, 121);
    transition: 0.2s;
}


#restablecer:hover{
    color: rgb(0, 0, 0);
    background-color:  rgb(252, 218, 174);
}

.boton-active {
    color: rgb(255, 255, 255);
    background-color:  rgb(31, 155, 203);
    transition: 0.2s;
}

.boton-active-temp {
    color: rgb(0, 26, 255);
    background-color:  rgb(253, 255, 121);
    transition: 0.3s;
    padding-top: 8px !important;
    padding-bottom: 8px !important;
    margin-top: 0px !important;
    margin-bottom: 0px !important;
    font-weight: bold;
}

#planta-baja, #planta-primera, #planta-segunda{
    background-size: contain;
    background-repeat: no-repeat;
    position: relative;
}

#planta-baja {
    background-image: url(../img/planos/Planta-baja.png);
    display: block; 
}

#planta-primera {
    background-image: url(../img/planos/Planta-primera.png);
    display: none; 
}

#planta-segunda {
    background-image: url(../img/planos/Planta-segunda.png);
    display: none; 
}

 #planta-baja>* , #planta-primera>* , #planta-segunda>* {
    position: absolute;
    background-color: rgba(255, 255, 0, 0.26);
    border: 1px solid rgb(0, 0, 0);
 }

 #planta-baja>*:hover, #planta-primera>*:hover, #planta-segunda:hover>*:hover {
    background-color: rgba(28, 46, 146, 0.5);
    border: 1px solid gray;
}


#aula-2ndo-Guia {
    height: 14.5%;
    width: 7%;
    top: 1.6%;
    left: 14%;
}

#aula-1ero-Guia-A {
    height: 9%;
    width: 7%;
    top: 1.6%;
    left: 21%;
}

#aula-1ero-Guia-B {
    height: 9%;
    width: 7%;
    top: 1.6%;
    left: 28%;
}

#gimnasio {
    height: 11%;
    width: 18.4%;
    top: 29.5%;
    left: 12%;
}

#aula0-11 {
    height: 10.8%;
    width: 8.1%;
    top: 25.3%;
    left: 44.2%;
}

#aula0-9 {
    height: 10.8%;
    width: 11.9%;
    top: 25.3%;
    left: 52.6%;
}

#aula0-5 {
    height: 9.5%;
    width: 9%;
    top: 27.5%;
    right: 12.8%;
}

#pista-padel {
    height: 14.4%;
    width: 20.6%;
    top: 9.7%;
    right: 8.6%;
    transform: rotate(5.25deg);
}

#aula0-7 {
    height: 10.3%;
    width: 7.1%;
    top: 37.4%;
    right: 14.8%;
}

#aula0-3 {
    height: 10%;
    width: 3.6%;
    top: 61.6%;
    right: 13.8%;
}

#aula0-1 {
    height: 10%;
    width: 5.5%;
    top: 61.6%;
    right: 17.7%;
}

#aula0-2-norte {
    height: 13.2%;
    width: 4.5%;
    top: 72.8%;
    left: 12%;
}

#aula0-2-sur {
    height: 13.2%;
    width: 4.5%;
    top: 72.8%;
    left: 16.7%;
}

#aula1-11 {
    height: 25.3%;
    width: 11.3%;
    top: 10.5%;
    right: 4.9%;
}

#aula1-9 {
    height: 11%;
    width: 11.6%;
    top: 54.5%;
    right: 6.1%;
}

#aula1-7 {
    height: 11%;
    width: 11%;
    top: 54.5%;
    right: 18.3%;
}

#aula1-5 {
    height: 11%;
    width: 11.2%;
    top: 54.5%;
    right: 29.75%;
}

#aula1-3 {
    height: 11%;
    width: 11.5%;
    top: 54.5%;
    right: 41.3%;
}

#aula1-1 {
    height: 11%;
    width: 5.5%;
    top: 54.5%;
    right: 53.1%;
}

#aula1-19 {
    height: 11.4%;
    width: 5.4%;
    top: 36.6%;
    right: 53.1%;
}

#aula1-17 {
    height: 11.4%;
    width: 11.6%;
    top: 36.6%;
    right: 41.2%;
}

#aula1-15 {
    height: 11.4%;
    width: 11.3%;
    top: 36.6%;
    right: 29.7%;
}

#aula1-13 {
    height: 11.4%;
    width: 11.2%;
    top: 36.6%;
    right: 18.2%;
}

#aula1-2 {
    height: 11.2%;
    width: 11.5%;
    top: 54.5%;
    left: 24.6%;
}

#aula1-4 {
    height: 11.2%;
    width: 11.5%;
    top: 54.5%;
    left: 12.9%;
}

#aula1-6 {
    height: 11.2%;
    width: 11.3%;
    top: 54.5%;
    left: 1.3%;
}

#aula1-8 {
    height: 11.3%;
    width: 11.3%;
    top: 72.3%;
    left: 1.3%;
}

#aula1-10 {
    height: 11.3%;
    width: 5.5%;
    top: 72.3%;
    left: 12.9%
}

#aula1-12 {
    height: 11.3%;
    width: 11.4%;
    top: 72.3%;
    left: 18.7%
}

#aula2-11 {
    height: 12.2%;
    width: 11.3%;
    top: 9.0%;
    right: 4.5%;
}

#aula2-13 {
    height: 12.5%;
    width: 8.9%;
    top: 21.5%;
    right: 7.0%;
}

#aula2-9 {
    height: 11%;
    width: 11.7%;
    top: 52.8%;
    right: 5.9%;
}

#aula2-7 {
    height: 11%;
    width: 11.1%;
    top: 52.8%;
    right: 18.0%;
}

#aula2-5 {
    height: 11%;
    width: 11.2%;
    top: 52.8%;
    right: 29.45%;
}

#aula2-3 {
    height: 11%;
    width: 11.6%;
    top: 52.8%;
    right: 41.0%;
}

#aula2-1 {
    height: 11%;
    width: 5.5%;
    top: 52.8%;
    right: 52.9%;
}

#aula2-23 {
    height: 11.2%;
    width: 4.1%;
    top: 35.0%;
    right: 54.1%;
}

#aula2-21 {
    height: 11.2%;
    width: 3.9%;
    top: 35.0%;
    right: 50.0%;
}

#aula2-19 {
    height: 11.2%;
    width: 8.7%;
    top: 35.0%;
    right: 41.0%;
}

#aula2-17 {
    height: 11.2%;
    width: 11.3%;
    top: 35.0%;
    right: 29.4%;
}

#aula2-15 {
    height: 11.2%;
    width: 11.2%;
    top: 35.0%;
    right: 18.0%;
}

#aula2-2 {
    height: 11.2%;
    width: 11.5%;
    top: 52.8%;
    left: 24.8%;
}

#aula2-4 {
    height: 11.2%;
    width: 11.5%;
    top: 52.8%;
    left: 13.0%;
}

#aula2-6 {
    height: 11.2%;
    width: 11.3%;
    top: 52.8%;
    left: 1.5%;
}

#aula2-8 {
    height: 11.3%;
    width: 11.3%;
    top: 70.6%;
    left: 1.5%;
}

#aula2-10 {
    height: 11.3%;
    width: 5.5%;
    top: 70.6%;
    left: 13.1%;
}

#aula2-12 {
    height: 11.3%;
    width: 11.4%;
    top: 70.6%;
    left: 18.9%

}
</style>