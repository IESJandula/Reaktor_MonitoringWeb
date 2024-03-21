function toggleArticulos(element) 
{
    var redContenido = element.querySelector('.redContenido');
    if (redContenido.style.display === 'none' || redContenido.style.display === '') 
    {
      redContenido.style.display = 'block';
    } 
    else 
    {
      redContenido.style.display = 'none';
    }
}

function filtrarTarjetas() 
{
  var input, filter, ul, li, article, h1, p, i, txtValue;
  input = document.getElementById('busqueda');
  filter = input.value.toUpperCase();
  ul = document.getElementById("listaRedes");
  li = ul.getElementsByTagName('li');

  for (i = 0; i < li.length; i++) 
  {
    article = li[i].getElementsByClassName("tarjeta");
    for (var j = 0; j < article.length; j++)
    {
      h1 = article[j].getElementsByTagName("h1")[0];
      p = article[j].getElementsByTagName("p");
      txtValue = h1.textContent || h1.innerText;
      for (var k = 0; k < p.length; k++)
      {
        txtValue += p[k].textContent || p[k].innerText;
      }
      if (txtValue.toUpperCase().indexOf(filter) > -1) 
      {
          article[j].style.display = "";
      } 
      else 
      {
          article[j].style.display = "none";
      }
    }
  }
}