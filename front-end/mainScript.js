function myFunction(){
    var bundeslandForm = document.forms["form-getBundesland"];
    var isInfected;
    var laborId = bundeslandForm.elements[0].value;
    var personId = bundeslandForm.elements[1].value;
    var testDatum = Date.parse(bundeslandForm.elements[2].value);
    var type = bundeslandForm.elements[4].value;

    var parameterUrl = "?";
    
    
    if(bundeslandForm.elements[3].checked){
        isInfected = 1;
    }else{
        isInfected = 0;
    }

    parameterUrl += "result="+isInfected;
    parameterUrl += "&";
    parameterUrl += "labor_id="+laborId;
    parameterUrl += "&";
    parameterUrl += "testdatum="+testDatum;
    parameterUrl += "&";
    parameterUrl += "person_id="+personId;
    parameterUrl += "&";
    parameterUrl += "type="+type;



    console.log("isInfected: "+isInfected);
    console.log("testDatum: "+testDatum);
    console.log(parameterUrl);
    console.log(getUrlAddTest(parameterUrl));

    var addTestRequest = new XMLHttpRequest();
    addTestRequest.open("POST",getUrlAddTest(parameterUrl),true);
    addTestRequest.send();

    
}

function getUrlAddTest(parameters){
    return "http://localhost:8080/test/add"+parameters;
}

function addTest(url){

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
       if (this.readyState == 4 && this.status == 200) {
           console.log("TEST ADDED");
           //var obj = JSON.parse(xhttp.responseText);
       }
   };
   xhttp.open("POST", url, true);
   xhttp.send();

}



   function test(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
       if (this.readyState == 4 && this.status == 200) {
           console.log(xhttp);
           return xhttp.responseText;
           //var obj = JSON.parse(xhttp.responseText);
       }
   };
   xhttp.open("POST", "http://localhost:8080/bundesland/add?", true);
   xhttp.send();
   }