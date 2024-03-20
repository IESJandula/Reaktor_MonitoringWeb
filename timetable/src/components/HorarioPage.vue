<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';

//Instancia del router
const router = useRouter();
const body = document.getElementById("body");
body.style.backgroundColor = "white";
body.style.padding = 0;
body.style.margin = 0;

//Instancia de variables
let cambioHorario = ref(false);
</script>

<template>
     <header class="header">
        <div class="logo-header">
            <a href=""><img src="/logo.png" alt="logo"></a>
        </div>
        <div class="nav-menu">
            <input type="checkbox" id="check">
            <label for="check" class="checkbtn">
                
            </label>
            <ul>
                <li v-on:click="router.push('/horarios/admin')">Administración</li>
                <li v-on:click="router.push('/horarios/profesores')">Profesores</li>
                <li v-on:click="router.push('/horarios/alumnos')">Alumnos</li>
                <li v-on:click="router.push('/horarios/horas')">Horarios</li>
                <li v-on:click="router.push('/horarios/convivencia')">Convivencia</li>
                <li v-on:click="router.push('/horarios/mapa')">Mapas</li>
            </ul>
        </div>
   </header> 
    <div id="Horario">
        <div id="horario-seleccionar-Profesor" v-show="!cambioHorario">
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
        
        <div id="horario-todos-Profesores" v-show="!cambioHorario">
            <p>Horario de todos los Profesores</p>
            <form action="">
                <button id="button-Horario-Profesores"> Ver </button>
            </form>
        </div>
        
        <div id="horario-seleccionar-grupo" v-show="cambioHorario">
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
        
        <div id="horario-todos-grupos" v-show="cambioHorario">
            <p>Horario de todos los Grupos</p>
            <form action="">
                <button id="button-Horario-Grupo"> Ver </button>
            </form>
        </div>

    </div>
    <div id="botones">
            <button v-on:click="cambioHorario = false">Horarios Profesores</button>
            <button v-on:click="cambioHorario = true">Horarios Grupos</button>
        </div>
        
    <div id="horarios-container">
        <embed type="text/html" src="/Horario.pdf"  width="85%" height="900px">
    </div>
   
</template>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap');

/*Resalta el boton de la barra de navegación de la sección para las migajas*/
.nav-menu li:nth-child(4){
    background-color: rgb(222, 252, 253) !important;
    border-color: rgb(0, 0, 0);
}
/*Resalta el boton de la barra de navegación de la sección para las migajas*/
.nav-menu li:nth-child(4) a{
    color: rgb(34, 46, 83) !important;
    font-weight: bold !important;
}

#Horario{

    margin-top: 5%;
    display: flex;
    justify-content: space-around;
    flex-wrap: wrap;

}

#horario-seleccionar-Profesor{

    width: 20%;
    text-align: center;
    border: 2px solid black;
    min-width: 250px;
    max-width: 100%;
    margin-left: 25%;

}

#horario-todos-Profesores{

    width: 20%;
    text-align: center;
    border: 2px solid black;
    min-width: 225px;
    max-width: 100%;
    margin: 5px;
    margin-right: 25%;

}

#horario-seleccionar-grupo{

    width: 20%;
    text-align: center;
    border: 2px solid black;
    min-width: 100px;
    max-width: 100%;
    margin: 5px;
    margin-left: 25%;
}

#horario-todos-grupos{
    
    width: 20%;
    text-align: center;
    border: 2px solid black;
    min-width: 150px;
    max-width: 100%;
    margin: 5px;
    margin-right: 25%;

}

#horarios-container{
    min-height: 100%;
    margin-left: 10%;
    margin-top: 2.5%;
}

#botones{
    width: 18%;
    margin-left: 42%;
 
}

#botones button{
    margin-left: 5%;
    background-color:  rgb(31, 155, 203);
    border-radius: 5px;
}

#botones button:hover{
    background-color: hsl(197, 74%, 43%);
}

#botones button:active{
    background-color: hsl(197, 74%, 43%);
}

#botones button{
    margin-top: 25%;
   margin-left: 5%;
}

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

</style>