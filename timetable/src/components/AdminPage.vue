<script setup>
import { useRouter } from 'vue-router';
//Instancia del router
const router = useRouter();
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
            <!-- Fondo de la pagina -->
            <div class="fondo_cuadrado">
                <!-- Formulario -->
                <section class="seccion1">
                    <label  for="Configuración en xml">Cargar configuración en xml:</label>
                    <div class="marco_interno">
                        <input type="file" placeholder="Configuración..." accept=".xml">
                    </div>
                    <input type="submit" value="Cargar" id="alinear">
                </section>
                <section class="seccion1">
                    <label  for="Roles csv">Cargar roles en csv:</label>
                    <div class="marco_interno">
                        <input  type="file" placeholder="Roles..." accept=".csv">
                    </div>
                    <input type="submit" value="Cargar" id="alinear">
                </section>
                <section class="seccion1">
                    <label for="Alumnos en xml">Cargar alumnos en xml:</label>
                    <div class="marco_interno">
                        <input type="file" placeholder="Alumnos..." accept=".xml">
                    </div>
                    <input type="submit" value="Cargar" id="alinear">
                </section>
            </div>
</template>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap');

@import url('https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap');

/*Resalta el boton de la barra de navegación de la sección para las migajas*/
.nav-menu li:nth-child(1){
    background-color: rgb(222, 252, 253) !important;
    border-color: rgb(0, 0, 0);
}
/*Resalta el boton de la barra de navegación de la sección para las migajas*/
.nav-menu li:nth-child(1) a{
    color: rgb(34, 46, 83) !important;
    font-weight: bold !important;
}

*{
    font-size: 16px;
    font-family: 'Open Sans';
}
.fondo{
    background-color: #f2f2f2;
}
.fondo_cuadrado{
    background-color: white;
    width: 80%;
    height: auto;
    margin-left: 10%;
    box-shadow: 0 0 3px -1px;
}
#cuadrado{
    display: flex;
    justify-content: center;
}
.seccion1{
    height: 108px;
    max-height: 115px;
    margin-left: 2%;
    margin-right: 2%;
    margin-top: 1%;
}
.marco_interno {
    font-size: 28px;
    border: 1px solid #d0d0d0;
    border-radius: 10px;
    padding: 1px;
    background-color: #f2f2f2;
}
#alinear{
    margin-top: 1%;
    margin-left: 94%;
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