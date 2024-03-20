<script setup>
import { useRouter } from 'vue-router';
//Instancia del router
const router = useRouter();
const body = document.getElementById("body");
body.style.backgroundColor = "rgb(230, 253, 253);";
body.style.padding = 0;
body.style.margin = 0;

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

        <div class="table-title">
            <h2>Info Alumnos</h2>
        </div>

        <div class="container-table-info-alumnos">

            <div class="selectores">
                <form>
                    <label for="selector-curso">Cursos:</label>
                    <select name="selector-curso" id="selector-curso">
                        <option value="0">Seleccionar</option>
                        <option value="aula01">1º FPB</option>
                        <option value="aula03">2º FPB</option>
                        <option value="aula05">1º DAM</option>
                        <option value="aula07">2º DAM</option>
                        <option value="aula02no">3º DIVER </option>
                        <option value="aula02su">4º DIVER </option>
                        <option value="aula011">1º BCS-A </option>
                    </select>
                </form>

                <form>
                    <label for="selector-alumno">Alumnos:</label>
                    <select name="selector-alumno" id="selector-alumno">
                        <option value="0">Seleccionar</option>
                        <option value=“Alumno1”>Mayra Aguado López</option> 
                        <option value=“Alumno2”>Rafael Alberola Robles</option> 
                        <option value=“Alumno3”>Guillermo Alcusón Marco</option> 
                        <option value=“Alumno4”>Francisca Alonso López</option> 
                        <option value=“Alumno5”>Juan Álvaro Martínez-Carrasco</option> 
                        <option value=“Alumno6”>Jaime Apariecido dos Santos</option> 
                        <option value=“Alumno7”>Guido Arias Brenes</option> 
                        <option value=“Alumno8”>Nekane Bariain Carrasco</option> 
                        <option value=“Alumno9”>Jorge Barriobero Olarte</option> 
                        <option value=“Alumno10”>Dolores Bastida López</option> 
                        <option value=“Alumno11”>Maria E Berenguer Borja</option> 
                        <option value=“Alumno12”>María Bernad Albiol</option> 
                        <option value=“Alumno13”>José Manuel Blasco Boix</option> 
                        <option value=“Alumno14”>Yanneth Bohorquez Pérez</option> 
                        <option value=“Alumno15”>Antonio Camarasa Sanfelix</option> 
                        <option value=“Alumno16”>Ramón Carañana Sanchís</option> 
                        <option value=“Alumno17”>Clara Carbonell Sendra</option> 
                        <option value=“Alumno18”>Antonio Casanova Mula</option> 
                        <option value=“Alumno19”>Juan Félix Casas Bosca</option> 
                        <option value=“Alumno20”>Mauricio Castillo Hidalgo</option> 
                    </select>
                </form>
             </div>
            
            <div class="tabla-info-alumno">
                <table>
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Correo</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
    
                    <tbody>
                        <tr>
                            <td>Vicente Serrano</td>
                            <td>*****@g.educaand.es</td>
                            <td>
                                <span class="action-btn">
                                    <a href="#">Info Tutor</a>
                                    <a href="#">Info Tutor Legal</a>
                                </span>
                            </td>
                        </tr>
                    </tbody>
                </table>
    
            </div>
        </div>


        <!--Tabla 1: Hace referencia al registro de ida y vuelta del baño de un alumno-->

        
        <div class="table-title">
            <h2>Registrar ida y vuelta</h2>
        </div>

        <div class="table-record-01">

            <div class="configuration-header">
            
                <div class="add">
                    <span>Datos</span>
                    <select name="course-select">
                        <option value="course-option">Curso</option>
                    </select>
    
                    <select name="name-select">
                        <option value="group-option">Nombre y apellidos</option>
                    </select>

                </div>
    
            </div>

            <table>

                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Curso</th>
                        <th>Acciones</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>Lucía</td>
                        <td>García González</td>
                        <td>1 ESO A</td>
                        <td>
                            <span class="action-btn">
                                <a href="#">Ida</a>
                                <a href="#">Vuelta</a>
                            </span>
                        </td>
                    </tr>
                </tbody>

            </table>

        </div>

        <!--Tabla 2: Hace referencia a las estadísticas determinadas de un alumno-->

        <div class="table-title">
            <h2>Estadísticas del alumno</h2>
        </div>

        <div class="table-record-02">

            <div class="configuration-header">
            
                <div class="add">
                    <span>Datos</span>
                    <select name="course-select">
                        <option value="course-option">Curso</option>
                    </select>
    
                    <select name="name-select">
                        <option value="group-option">Nombre y apellidos</option>
                    </select>

                </div>

                <div class="date">
                    <span>Periodo</span>
                    <input type="search" class="date-search" placeholder="Fecha inicio">
                    <input type="search" class="date-search" placeholder="Fecha fin">
                </div>
    
            </div>

            <table>

                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Curso</th>
                        <th>Veces idas al baño</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>Lucía</td>
                        <td>García González</td>
                        <td>1 ESO A</td>
                        <td>?</td>
                    </tr>
                </tbody>

            </table>

            <table>

                <thead>
                    <tr>
                        <th>Días</th>
                        <th>Horas</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>?</td>
                        <td>?</td>
                    </tr>
                </tbody>

            </table>

        </div>

        <!--Tabla 3: Hace referencia a la lista de alumnos con el número de veces que han ido al baño-->

        <div class="table-title">
            <h2>Listado de alumnos</h2>
        </div>

        <div class="table-record-03">

            <div class="configuration-header">

                <div class="date">
                    <span>Periodo</span>
                    <input type="search" class="date-search" placeholder="Fecha inicio">
                    <input type="search" class="date-search" placeholder="Fecha fin">
                </div>
    
            </div>

            <table>

                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Curso</th>
                        <th>Veces idas al baño</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>Lucía</td>
                        <td>García González</td>
                        <td>1 ESO A</td>
                        <td>?</td>
                    </tr>

                    <tr>
                        <td>Pablo</td>
                        <td>Motos Burgos</td>
                        <td>2 ESO B</td>
                        <td>?</td>
                    </tr>

                    <tr>
                        <td>María</td>
                        <td>López González</td>
                        <td>4 ESO C</td>
                        <td>?</td>
                    </tr>
                </tbody>

            </table>

        </div>

</template>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap');

/*Resalta el boton de la barra de navegación de la sección para las migajas*/
.nav-menu li:nth-child(3){
    background-color: rgb(222, 252, 253) !important;
    border-color: rgb(0, 0, 0);
}
/*Resalta el boton de la barra de navegación de la sección para las migajas*/
.nav-menu li:nth-child(3) a{
    color: rgb(34, 46, 83) !important;
    font-weight: bold !important;
}


.selectores{
    display: flex;
    justify-content: space-around;
    margin: 2em;
}


.container-table-info-alumnos{
    max-width: 900px;
    border: 1px solid rgb(0, 70, 128);
    background-color: beige;
    padding: 15px;
    overflow: auto;
    margin: auto;
    border-radius: 10px;
    margin-bottom: 10px;
}



/*FIN INFO ALUMNOS*/

/*COMIENZO SECCION LAVABOS*/

.venatanaActualizada{
    background-color: white;
}
*{
    box-sizing:border-box;
    text-align: center;
}

body{
   margin:40px;
   font-family:'Arial';
   margin:0;
   background-color: rgb(230, 253, 253);
}

.logo{
    display:flex;
    align-items: center;
}

.logo img{
   height:80px;
   margin-right: 10px;
   border-radius: 50%;
}

nav a {
    font-weight: 600;
    padding-right: 10px;
}

nav a:hover {
    color:white;
}

@media (max-width:700px){
    header {
        flex-direction: column; 
    }

    nav{
        padding:10px 0px;
    }
}

.configuration-header{
    padding: 15px; 
}

.browse{
    padding: 5px; 
    display: inline-flex;
} 

input{
    border-radius: 5px;
    border-style: solid;
    border-color: rgb(146, 173, 177);
} 

select{
    border-radius: 5px;
    border-style: solid;
    border-color: rgb(146, 173, 177);
} 

.table-title{
    color:rgb(28, 77, 117);
    text-align: center;
}

.table-record-01{
    max-width: 900px;
    border: 1px solid rgb(0, 128, 128);
    background-color: beige;
    padding: 15px;
    overflow: auto;
    margin: auto;
    border-radius: 10px;
    margin-bottom: 10px;
}

.table-record-02{
    max-width: 900px;
    border: 1px solid rgb(0, 128, 128);
    background-color: beige;
    padding: 15px;
    overflow: auto;
    margin: auto;
    border-radius: 10px;
    margin-bottom: 10px;
}

.table-record-03{
    max-width: 900px;
    border: 1px solid rgb(0, 128, 128);
    background-color: beige;
    padding: 15px;
    overflow: auto;
    margin: auto;
    border-radius: 10px;
    margin-bottom: 10px;
}

table{
    width: 100%;
    font-size: 13px;
    color:rgb(68, 68, 68);
    white-space: nowrap;
    border-collapse:collapse;
}

table>thead{
    background-color: rgb(116, 173, 190);
    color:white;
}

table>thead th{
    padding: 15px;
}

table th,table td{
    border:1px solid rgb(29, 28, 28);
    padding: 10px 15px;
}

table>body>tr>td>img{
    display:inline-block;
    width: 60px;
    height: 60px;
    object-fit: cover;
    border-radius:50%;
    border:4px solid white;
    box-shadow: 0 2px 6px rgb(29, 28, 28);
}

.action-btn{
    display: flex;
    justify-content: center;
    gap:10px;
}

.action-btn>a{
    text-decoration: none;
    color: rgb(29, 28, 28);
    background: white;
    border: 1px solid rgb(0, 109, 128);
    display: inline-block;
    padding:7px 20px;
    font-weight: bold;
    border-radius:10px;
    transition: 0.3s ease-in-out;
}

.action-btn>a:nth-child(1){
    border-color:rgb(93, 143, 207);
}

.action-btn>a:nth-child(2){
    border-color:rgb(131, 19, 19);
}

.configuration-header:hover{
    transition: 0.5s ease-in-out;
    filter:drop-shadow(0px 2px 6px rgb(97, 132, 173));
}

table>tbody>tr{
    background-color: white;
    transition: 0.3s ease-in-out;
}

table>tbody>tr:hover{
   filter:drop-shadow(0px 2px 6px rgb(4, 144, 163));
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