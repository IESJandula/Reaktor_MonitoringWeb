//Evento que se ejecuta nada mas abrir la ventana

var userName = "testDummy";
var roles = "testDummy";

window.addEventListener('DOMContentLoaded', async e =>
{
    userName = document.querySelector("#userLogged");
    console.log(userName.innerHTML);
    
    roles = document.querySelector("#userLoggedRoles");
    console.log(roles.innerHTML);

});


async function openPrinters()
{
    response = await fetch('http://localhost:3000',
    {
        method:'POST',//Informamos de que se utilizara una llamada de metodo post
        headers:{//Con los headers decimos que se utiliza json es muy importante
            'Content-Type':'application/json'
        },
        body: JSON.stringify( //Convertimos a json
            { 
            username: userName.innerHTML, //Para la clave username valor username
            roles: roles.innerHTML //Para la clave password el valor password
        })
    })
        
    //Convertimos a json datos planos y guardamos en una variable que mostramos por consola
    datos = await response.json()
}
