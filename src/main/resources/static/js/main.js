
const http = new XMLHttpRequest()

function query() {
 var lat = document.getElementById("latitude").value;
 var lon = document.getElementById("longitude").value;

 var url = "http://localhost:8080/api/coord/" + lat + "/" + lon;
 console.log(url);
 http.open("GET", url);
 http.send();


 http.onreadystatechange=function(){

  if(this.readyState==4 && this.status==200){
   var json_info = JSON.parse(http.responseText);


   for (var i = 0; i < 8; i++){

    var curTextArea = document.getElementById("day" + i.toString(10));
    curTextArea.value = "";
    curTextArea.value += "Day " + i+ "\n"
    curTextArea.removeAttribute("hidden")

    var dailyInfo = json_info.daily.data[i];
    for (var key in dailyInfo){
     curTextArea.value += key + ": " + dailyInfo[key] + "\n"
     console.log(dailyInfo[key])
    }

   }



   console.log(json_info);
  }
 }
}