const btnCommentAdd = document.querySelector("#btnCommentAdd");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");
const commentList = document.querySelector("#commentList");

getCommentList();

btnCommentAdd.addEventListener("click", function(){

    let bookNum = btnCommentAdd.getAttribute("data-bookNum");
    let wv = writer.value;
    let cv = contents.value;

    // 객체 생성
    const xhttp = new XMLHttpRequest();

    // 메소드 방식, URL
    xhttp.open("POST", "commentAdd");

    // encType
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");


    xhttp.send("bookNum="+bookNum+"&writer="+wv+"&contents="+cv);

    xhttp.onreadystatechange=function(){
        if(this.readyState==4 && this.status==200) {
            let result = xhttp.responseText.trim();
            result = JSON.parse(result);
            writer.value="";
            contents.value="";
            if(result.result==1) {
                alert("댓글 작성 성공");
                getCommentList();
            }
        }
    }
})

function getCommentList() {
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "commentList?page=1&bookNum="+btnCommentAdd.getAttribute("data-bookNum"));
    xhttp.send();

    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4 && this.status==200) {
            // commentList.innerHTML=this.responseText;   jsp 사용 결과물

            let list = JSON.parse(this.responseText.trim());
            let table = document.createElement("table");
            for(let i=0; i<list.length; i++) {
                let tr = document.createElement("tr");
                let td = document.createElement("td");
                let text = document.createTextNode(list[i].writer);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode(list[i].contents);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode(list[i].regDate);
                td.appendChild(text);
                tr.appendChild(td);

                table.appendChild(tr);
            }
          	commentList.innerHTML="";
            commentList.append(table);
        }
    })
}