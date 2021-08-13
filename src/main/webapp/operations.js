function employeeLogin(){
    var empId= document.getElementById('inputID').value;
    var email= document.getElementById('inputEmail').value;
    var password=document.getElementById('inputPassword').value;
    var empObj={employeeID:empId,employeeEmail:email,employeePass:password};
    fetch("http://localhost:8080/mybankproject/webapi/employee/employeeLogin",{
        body: JSON.stringify(empObj),
        headers:{
            "Content-Type": "application/json",
        },
        method: "POST"
    })
    .then((response)=>response.json())
    .then((json)=>display(json))
    .catch(err=>console.log('Request failed'));
    function display(resE){
        if(resE.status==="true"){
            window.location.herf= "employeeDashBoard.html";
        }else{
            alert("incorrect password");
        }
    }
}