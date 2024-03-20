/**
 * Metodo que separa el nombre por una parte y el apellido por otra
 * de la persona que se pasa por parametro para el envio del nombre
 * y apellido a un endpoint especifico
 * @param {string} nombre 
 * @returns nombre y apellido separados
 */
export const separadorNombre = (nombre) =>{
    let array = nombre.split(" ");
    let nombreApellido = [];
    
    array[0] = array[0].trim();
    array[1] = array[1].trim();
    array[2] = array[2].trim();

    nombreApellido.push(array[0]);
    nombreApellido.push(array[1]+" "+array[2]);

    return nombreApellido;
}