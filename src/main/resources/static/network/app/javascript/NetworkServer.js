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
