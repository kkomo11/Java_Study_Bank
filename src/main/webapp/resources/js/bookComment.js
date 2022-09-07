const btnCommentAdd = document.querySelector("#btnCommentAdd");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");
const commentList = document.querySelector("#commentList");
const more = document.querySelector("#more");
let page=1;
const bookNum = btnCommentAdd.getAttribute("data-bookNum");

getCommentList(page, bookNum);

btnCommentAdd.addEventListener("click", function(){

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
                for(let i=0; i<commentList.children.length;) {
                   commentList.children[0].remove(); 
                }
                page=1;
                getCommentList(page, bookNum);
            }
        }
    }
})

function getCommentList(p, bn) {
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "commentList?page="+p+"&bookNum="+bn);
    xhttp.send();

    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4 && this.status==200) {
            // commentList.innerHTML=this.responseText;   jsp 사용 결과물

            let result = JSON.parse(this.responseText.trim());
            let list = result.list;
            let pager = result.pager;
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

                td = document.createElement("td");
                text = document.createTextNode("수정");
                let tdAttr = document.createAttribute("class");
                tdAttr.value="update";
                td.setAttributeNode(tdAttr);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode("삭제");
                tdAttr = document.createAttribute("class");
                tdAttr.value="delete";
                td.setAttributeNode(tdAttr);
                tdAttr = document.createAttribute("data-comment-num");
                tdAttr.value=list[i].num;
                td.setAttributeNode(tdAttr);
                td.appendChild(text);
                tr.appendChild(td);

                commentList.append(tr);

                if(page >= pager.totalPage) {
                    more.classList.add('disabled');
                } else {
                    more.classList.remove('disabled');
                }
            }
        }
    })
}

more.onclick=function() {
    page++;
    getCommentList(page, bookNum);
}

commentList.onclick=function(event) {
    if(event.target.classList[0]=="delete") {
        let check = window.confirm("삭제하시겠습니까?");
        if(check) {
            alert(event.target.getAttribute("data-comment-num"));
        }
    }
}