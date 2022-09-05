const d1 = document.querySelector("#d1");
const i1 = document.querySelector("#i1");

d1.addEventListener("click", function(){
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", "https://jsonplaceholder.typicode.com/posts/"+i1.value);

    xhttp.send();

    xhttp.onreadystatechange =function(){
        if(this.readyState==4 && this.status==200) {
            let response = this.responseText.trim();
            response = JSON.parse(response);
            let h3 = document.createElement("h3");
            let text = document.createTextNode(response.userId);
            h3.appendChild(text);
            result.append(h3);
            h3 = document.createElement("h3");
            text = document.createTextNode(response.id);
            h3.appendChild(text);
            result.append(h3);
            h3 = document.createElement("h3");
            text = document.createTextNode(response.title);
            h3.appendChild(text);
            result.append(h3);
            h3 = document.createElement("h3");
            text = document.createTextNode(response.body);
            h3.appendChild(text);
            result.append(h3);
        }
    }

    console.log("Ajax 발생");
});