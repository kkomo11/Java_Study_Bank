let btnSubmit = document.getElementById("btnSubmit");
let form = document.getElementById("form");
let id = document.getElementById("id");
let pw = document.getElementById("pw");
let errMsg = document.getElementById("errMsg");

btnSubmit.addEventListener("click", function(){
    if(id.value.length==0) {
        errMsg.innerText="ID를 입력하세요";
    } else if(pw.value.length==0) {
        errMsg.innerText="PW를 입력하세요";
    } else {
        form.submit();
    }
})