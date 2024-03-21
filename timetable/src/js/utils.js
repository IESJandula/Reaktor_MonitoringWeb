import { Profesor } from "@/models/profesores";
import { Tramo } from "@/models/tramos";

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
    let array = hora.split("-");
    let tramo = new Tramo("","","","");
    array[0] = array[0].trim();
    array[1] = array[1].trim();

    let date = new Date();

    for(let i=0;i<tramos.length;i++)
    {
        tramos[i].startHour = tramos[i].startHour.trim();
        tramos[i].endHour = tramos[i].endHour.trim();

        if(tramos[i].startHour==array[0] && tramos[i].endHour==array[1] && tramos[i].dayNumber==(date.getUTCDay()+""))
        {
            tramo = tramos[i];
        }
    }

    return tramo;
}