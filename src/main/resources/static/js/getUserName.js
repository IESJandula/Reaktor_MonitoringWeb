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
	var mapForm = document.createElement("form");
    mapForm.target = "userInfo";
    mapForm.method = "POST";
    mapForm.action = "http://localhost:3000/user";
	
    var userNameInput = document.createElement("input");
    userNameInput.type = "text";
    userNameInput.name = "username";
    userNameInput.value = userName.innerHTML;
    mapForm.appendChild(userNameInput);
    
    var userRoleInput = document.createElement("input");
    userRoleInput.type = "text";
    userRoleInput.name = "roles";
    userRoleInput.value = roles.innerHTML;
    mapForm.appendChild(userRoleInput);
	
    document.body.appendChild(mapForm);

    map = window.open("", "userInfo", "status=0,title=0,height=600,width=800,scrollbars=1");
	
	if (map)
	{
	    mapForm.submit();
	}
	else
	{
	    alert('You must allow popups for this map to work.');
	}
}
