const btnCommentAdd = document.querySelector("#btnCommentAdd");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");

getCommentList();

btnCommentAdd.addEventListener("click", function(){

    let bookNum = btnCommentAdd.getAttribute("data-bookNum");
    let wv = writer.value;
    let cv = contents.value;

    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "commentAdd");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("bookNum="+bookNum+"&writer="+wv+"&contents="+cv);

    xhttp.onreadystatechange=function(){
        if(this.readyState==4 && this.status==200) {
            let result = xhttp.responseText.trim();
            console.log(result);
            result = JSON.parse(result);
            writer.value="";
            contents.value="";
            if(result.result==1) {
                alert("댓글 작성 성공");
            }
        }
    }
})

function getCommentList() {
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "commentList?page=1");
    xhttp.send();

    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4 && this.status==200) {
            console.log(this.responseText);
        }
    })
}