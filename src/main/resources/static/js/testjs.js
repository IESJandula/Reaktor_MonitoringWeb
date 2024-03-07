function myFunction(elemento)
{
  document.getElementById("acciones-networking-des").style.display = "none";
  document.getElementById("acciones-bloqueopuertos-des").style.display = "none";
  document.getElementById("acciones-screenshot-des").style.display = "none";
  document.getElementById("acciones-id-junta-des").style.display = "none";
  document.getElementById("acciones-instalar-aplicacion-des").style.display = "none";
  document.getElementById("acciones-desistalar-des").style.display = "none";
  document.getElementById("acciones-script-des").style.display = "none";
  document.getElementById("acciones-navegador-des").style.display = "none";
  document.getElementById("acciones-apagar-des").style.display = "none";

  var descripcionElegida = elemento + "-des" ;
  
  var contenedorDescripcionElegida = document.getElementById(descripcionElegida);
  if (contenedorDescripcionElegida.style.display === "none")
  {
    contenedorDescripcionElegida.style.display = "block";
  }
  
  document.getElementById("acciones-networking-fil").style.display = "none";
  document.getElementById("acciones-bloqueopuertos-fil").style.display = "none";
  document.getElementById("acciones-screenshot-fil").style.display = "none";
  document.getElementById("acciones-id-junta-fil").style.display = "none";
  document.getElementById("acciones-instalar-aplicacion-fil").style.display = "none";
  document.getElementById("acciones-desistalar-fil").style.display = "none";
  document.getElementById("acciones-script-fil").style.display = "none";
  document.getElementById("acciones-navegador-fil").style.display = "none";
  document.getElementById("acciones-apagar-fil").style.display = "none";

  
  var filtroElegido = elemento + "-fil";
  var contenedorFiltroElegido = document.getElementById(filtroElegido);
  if (contenedorFiltroElegido.style.display === "none")
  {
    contenedorFiltroElegido.style.display = "block";
  }

}

async function testReaktor()
{
  console.log("TEST - REKTOR CLICKED");

  response = await fetch('http://localhost:8084/computers/web',
  {
      method:'POST',//Informamos de que se utilizara una llamada de metodo post
      headers:{//Con los headers decimos que se utiliza json es muy importante
          'Content-Type':'application/json',
          'serialNumber':'5A59A1A8-CFA5-0000-0000-000000000000',
      },
      body: JSON.stringify( //Convertimos a json
          {})
  })
  //Convertimos el json a datos planos y guardamos en una variable que mostramos por consola
  datos = await response.json()
  console.log(datos)

}