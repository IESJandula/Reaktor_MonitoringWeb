<script setup>
import { ref, watch } from 'vue';
import { getTeachers,getHours,getCourses,getTeacherClassroom } from '@/api/peticiones';
import { useRouter } from 'vue-router';
import { separadorNombre } from '../js/utils.js'
//Instancia del router para cambiar de componente
const router = useRouter();
//Acceso al index.html
const body = document.getElementById("body");
body.style.backgroundColor = "rgb(241, 241, 224)";
body.style.padding = 0;
body.style.margin = 0;

//Instancia de variables
let selector = ref(true);
let profesores = ref([]);
let horas = ref([]);
let cursos = ref([]);
let infoProfe = ref("");
let infoNumAula = ref("");
let infoNombreAula = ref("");
let info = ref(false);

//Metodos
const getTeacher = async () =>{
    const data = await getTeachers();
    let arrayProfes = [];
    selector.value = true;
    for(let i=0;i<data.length;i++)
    {
        arrayProfes.push(data[i].nombre+" "+data[i].primerApellido+" "+data[i].segundoApellido);
    }
    
    profesores = ref(arrayProfes);
    selector.value = false;
}

const getHour = async () =>{
    const data = await getHours();
    let arrayHoras = [];
    selector.value = true;
    for(let i = 0;i<data.length;i++)
    {
        arrayHoras.push(data[i].start+" - "+data[i].end);
    }

    horas = ref(arrayHoras);
    selector.value = false;
}

const getCourse = async () =>{
    const data = await getCourses();
    let arrayCursos = [];
    selector.value = false;
    for(let i = 0;i<data.length;i++)
    {
        arrayCursos.push(data[i].name);
    }

    cursos = ref(arrayCursos);
    selector.value = true
}

const getLocTeacher = async (nombre,apellidos)=>{
    const data = await getTeacherClassroom(nombre,apellidos);
    console.log(data.number);
    let aula = "";
    let curso = "";
    console.log("Entro aqui")
    aula+=data.floor+"."+data.number;
    curso = data.name;
    infoProfe.value = nombre+" "+apellidos;
    infoNumAula.value = aula;
    infoNombreAula.value = curso;
    
}
const mostrarDocente = ()=>{
    //Obtenemos el elemento selection por su id
    const profeSelection = document.getElementById("profesor");
    //Sacamos su valor en bruto
    let profesor = profeSelection.options[profeSelection.selectedIndex].text;
    //Mismo procedimiento con las horas
    const horaSelection = document.getElementById("hora");
    let hora = horaSelection.options[horaSelection.selectedIndex].text;

    let nombreApellido = separadorNombre(profesor);
    if(hora == "Ahora mismo")
    {
        getLocTeacher(nombreApellido[0],nombreApellido[1]);
        info.value = true;
    }

    
}
watch(selector,(nuevo,viejo)=>
{
    if(!nuevo)
    {
        console.log("Informacion bloque profesores actualizada");
        getTeacher();
        getHour();
    }
    else
    {
        console.log("Informacion bloque cursos actualizada");
        getCourse();
    }
});
watch(info,(nuevo,viejo)=>
{
    if(nuevo)
    {
        info.value = false;
        info.value = true;
    }
})
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
        <br>
        <main>
            <div id="docente" >
                <!-- Endpoints 7 y 8: introduce nombre y apellidos del profesor y devuelve aula dónde se encuentra y asignatura impartida -->
                <div  id="docente-profesor" v-show="!selector">
                <label for="profesor">Profesor: </label>
                <select  name="profesor" id="profesor">
                    <option value="default">Selecciona un profesor</option>
                    <option v-for="i in profesores" value="{{ i }}">{{ i }}</option>
                </select>
                <br><br>
                <label for="hora">Tramo Horario: </label> <!-- Por defecto: ahora mismo. Si no se toca nada, el sistema usará la hora actual del servidor -->
                <select name="hora" id="hora">
                    <option value="default">Ahora mismo</option>
                    <option v-for="i in horas" value="{{ i }}">{{ i }}</option>
                    
                </select>
                <br><br>
                <label for="dia">Día: </label>
                <input type="date" id="dia"> <!-- Aparece por defecto el día actual -->
                <!--<script>document.getElementById("dia").valueAsDate = new Date();</script>-->
                <br><br>
                <button class="button-docente" v-on:click="mostrarDocente">Buscar por docente</button>
            </div>

        <!-- Endpoint 9: introduce nombre del curso y recibe nombre del profesor y asignatura impartida en el momento actual -->
        <div id="docente-curso" v-show="selector">
            <label for="curso">Curso: </label>
            <select name="curso" id="curso">
                <option value="default">Selecciona un curso</option>
                <option v-for="i in cursos" value="{{ i }}">{{ i }}</option>
            </select>
            <br><br>
            <button class="button-docente">Buscar por curso</button> <!-- Devolverá qué profesor se encuentra en el aula actualmente o en el tramo horario elegido y asignatura impartida -->
        </div>
        <div id="info-aula" v-show="info">
            <br>
            <h3>El profesor {{ infoProfe }}</h3>
            <br>
            <h3>Se encuentra en el aula {{ infoNumAula }}</h3>
            <br>
            <h3>Curso {{ infoNombreAula }}</h3>
            <br>
        </div>
    </div>
    <br><br>
    <div id="selector">
        <button id="botonProfe" v-on:click="selector = false">Buscar por profesor</button>
        <button id="botonCurso" v-on:click="selector = true">Buscar por curso</button>
    </div>
            <br><hr><br>
            <div id="docente-guardia"> <!-- Mostrará nombres del profesor que falta y profesor sustituto por cada hora y clase -->
                <iframe id="hoja-calculo" src="https://onedrive.live.com/embed?resid=370B3DAE70E66DD4%212895&authkey=!AEWXzF8NKl6X2lo&em=2"></iframe>
            </div>
        </main>
</template>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap');


.nav-menu li:nth-child(2){
    background-color: rgb(222, 252, 253) !important;
    border-color: rgb(0, 0, 0);
}

.nav-menu li:nth-child(2) a{
    color: rgb(34, 46, 83) !important;
    font-weight: bold !important;
}


*{
    padding: 0;
    margin: 0;
    text-decoration: none;
    list-style: none;
    font-family: 'Open Sans';
}

body {
    background-color: rgb(241, 241, 224);
}

#docente {
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    flex-wrap: wrap;
}


#docente-curso {
    text-align: center;
    background-color: white;
    border: 2px solid black;
    border-radius: 5px;
    padding: 12px;
}

#docente-profesor {
    text-align: center;
    background-color: white;
    border: 2px solid black;
    border-radius: 5px;
    padding: 12px;
}

#docente-profesor:hover, #docente-curso:hover {
    box-shadow: 0 0 5px rgb(97, 172, 173);
}

#hoja-calculo {
    width: 100%;
    height: 400px;
    border: 2px solid black;
}

.button-docente {
    background-color: rgb(31, 155, 203);
    border-radius: 5px;
    padding: 3px;
}

.button-docente:hover {
    background-color: hsl(197, 74%, 43%);
}

.button-docente:active {
    background-color: hsl(197, 74%, 43%);
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

#selector {
   width: 20%;
   margin-left: 42.5%;
}

#selector button{
    margin-left: 5%;
    background-color:  rgb(31, 155, 203);
    border-radius: 5px;
}

#selector button:hover{
    background-color: hsl(197, 74%, 43%);
}

#selector button:active{
    background-color: hsl(197, 74%, 43%);
}

#info-aula{
    background-color:  rgb(123, 202, 233);
    border: 2px solid black;
    border-radius: 5px; 
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