import { Profesor } from "@/models/profesores";
import { Tramo } from "@/models/tramos";
import { Alumno } from "@/models/alumnos";

/**
 * Metodo que compara el nombre seleccionado con los datos cargadados
 * de los profesores devolviendo el nombre y apellidos para la busqueda
 * posterior en el servidor
 * @param {string} nombre 
 * @param {Profesor[]} profesores 
 * @returns array con 2 datos, nombre(0) y apellidos(1)
 */
export const separadorNombre = (nombre,profesores) =>{
    let nombreApellido = [];
    let index = 0;
    let salir = false;
    while(index<profesores.length && !salir)
    {
        let profe = profesores.at(index);
        let nombreCompleto = profe.nombre+" "+profe.primerApellido+" "+profe.segundoApellido;

        if(nombre == nombreCompleto)
        {
            nombreApellido.push(profe.nombre);
            nombreApellido.push(profe.primerApellido+" "+profe.segundoApellido);
            salir = true;
        }

        index++;
    }
    return nombreApellido;
}
/**
 * Metodo que mediante un tramo horario y una lista de tramos
 * devuelve un tramo especifico para su posterior uso en una
 * llamada http
 * @param {string} hora 
 * @param {Tramo[]} tramos 
 * @returns tramo especifico 
 */
export const getSpecificTramo = (hora,tramos)=>{
    //Como la hora siempre va a venir dada por hh - hh separamos por "-"
    let array = hora.split("-");
    //Creamos un tramo por defecto
    let tramo = new Tramo("","","","");
    //Eliminamos los espacios sobrantes
    array[0] = array[0].trim();
    array[1] = array[1].trim();
    
    //Instanciamos la fecha actual
    let date = new Date();

    //Comprobamos que los dias no sean sabado o domingo
    if(date.getUTCDay()==6)
    {
        alert("Estas busacando un profesor en sabado")
    }
    else if(date.getUTCDay()==0)
    {
        alert("Estas buscando un profesor en domingo")
    }
    else
    {   
        //Buscamos el tramo y se lo asignamos al que queremos devolver
        for(let i=0;i<tramos.length;i++)
        {
            tramos[i].startHour = tramos[i].startHour.trim();
            tramos[i].endHour = tramos[i].endHour.trim();

            if(tramos[i].startHour==array[0] && tramos[i].endHour==array[1] && tramos[i].dayNumber==(date.getUTCDay()+""))
            {
                tramo = tramos[i];
            }
        }
    }
    
    return tramo;
}

/**
 * Metodo que meiante un tramo horario, un dia especifico y una lista
 * de tramos devuelve un tramo especifico para su posterior uso en 
 * una llamada http
 * @param {string} hora 
 * @param {string} dia 
 * @param {Tramo[]} tramos 
 * @returns tramo especifico
 */
export const getOldTramo = (hora,dia,tramos)=>{

    //Creamos la fecha utilizando el valor seleccionado del dia
    let date = new Date(dia);

    //Como la hora siempre va a venir dada por hh - hh separamos por "-"
    let array = hora.split("-");
    //Creamos un tramo por defecto
    let tramo = new Tramo("","","","");
    //Eliminamos los espacios sobrantes
    array[0] = array[0].trim();
    array[1] = array[1].trim();

    //Controlamaos que el dia no sea ni sabado ni domingo
    if(date.getUTCDay()==6)
    {
        alert("Has seleccionado sabado, dia no laborable");
    }
    else if(date.getUTCDay()==0)
    {
        alert("Has seleccionado domingo, dia no laborable");
    }
    else
    {
        //Buscamos el tramo y se lo asignamos al que queremos devolver
        for(let i=0;i<tramos.length;i++)
        {
            tramos[i].startHour = tramos[i].startHour.trim();
            tramos[i].endHour = tramos[i].endHour.trim();

            if(tramos[i].startHour==array[0] && tramos[i].endHour==array[1] && tramos[i].dayNumber==(date.getUTCDay()+""))
            {
                tramo = tramos[i];
            }
        }
    }

    return tramo;
}
/**
 * Metodo que recoge el dia la hora y los minutos actuales para la localizacion
 * a tiempo real de un profesor buscandolo por su curso
 * @returns booleano que determina si se debe de mostrar o no un PopUp informativo
 */
export const checkHoraDia = () =>
{
    let mostrar = true;
    let date = new Date();

    if(date.getUTCDay()==6)
    {
        alert("No se puede localizar un profesor en sabado");
        mostrar = false;
    }
    else if(date.getUTCDay()==0)
    {
        alert("No se puede localizar un profesor en domingo");
        mostrar = false;
    }
    else if(date.getHours()<8 && date.getMinutes<15)
    {
        alert("Se esta buscando un profesor antes del tramo inicial (8:15)");
        mostrar = false;
    }
    else if(date.getHours()>14 && date.getMinutes<45)
    {
        alert("Se esta buscando un profesor antes del tramo inicial (14:45)");
        mostrar = false;
    }

    return mostrar;
}

/**
 * Metodo que mediante un alumno y un curso devuelve un alumno en concreto
 * para su puesta de datos en una tabla
 * @param {string} alumno 
 * @param {string} curso 
 * @param {Alumno[]} alumnos 
 * @returns alumno encontrado
 */
export const separadorNombreCurso = (alumno,curso,alumnos) =>{
    let alumnoFound =  new Alumno("?","?","?",0);

    for(let i = 0;i<alumnos.length;i++)
    {
        let item = alumnos[i];
        let itemValue = item.nombre+" "+item.apellidos;

        if(itemValue==alumno)
        {
           alumnoFound = new Alumno(item.nombre,item.apellidos,curso,item.numBathroom); 
        }
    }

    return alumnoFound;
}