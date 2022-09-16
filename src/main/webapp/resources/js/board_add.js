const fileAdd = document.getElementById("fileAdd");
const addFiles = document.getElementById("addFiles");

try {
    const fileDelete = document.querySelectorAll(".fileDelete");

    fileDelete.forEach(function(f){
        f.onclick=function(){
            let check = window.confirm("삭제시 되돌릴 ~~~~~~~");
            if(!check) {return ;}
            const xhttp = new XMLHttpRequest();
            xhttp.open("POST", "./fileDelete");
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send("fileNum="+f.getAttribute("data-file-num"));

            xhttp.onreadystatechange=function(){
                if(this.readyState==4 && this.status==200) {
                    let result = this.responseText.trim();
                    if(result == 1) {
                        f.parentNode.remove();
                        count--;
                    } else {
                        console.log(result);
                    }
                }
            }
        }
    });
} catch(e) {

}

let count=0;
let idx=0;

function setCount(c) {
    if(c>=0) count=c;
}

try {
    fileAdd.addEventListener("click", function(){
        if(count < 5) {
            let d = document.createElement("div"); // <div></div>
            let d_class = document.createAttribute("class"); //class=
            d_class.value="mb-3"; //class="mb-3"
            d_id = document.createAttribute("id");
            d_id.value="file"+idx;
            d.setAttributeNode(d_class); // <div class="mb-3"></div>
            d.setAttributeNode(d_id);
            
            let l = document.createElement("label");
            let l_for = document.createAttribute("for");
            l_for.value="file";
            let l_class = document.createAttribute("class");
            l_class.value="form-label";
            l.setAttributeNode(l_for);
            l.setAttributeNode(l_class);
            
            let i = document.createElement("input");
            let i_type = document.createAttribute("type");
            i_type.value="file";
            let i_class = document.createAttribute("class");
            i_class.value="form-control";
            let i_name = document.createAttribute("name");
            i_name.value="files";
            let i_id = document.createAttribute("id");
            i_id.value="file"+count;
            i.setAttributeNode(i_type);
            i.setAttributeNode(i_class);
            i.setAttributeNode(i_name);
            i.setAttributeNode(i_id);
            
            let b = document.createElement("button");
            b_type = document.createAttribute("type");
            b_type.value="button";
            b_class = document.createAttribute("class");
            b_class.value="btn btn-danger del";
            b_text = document.createTextNode("삭제");
            b_title = document.createAttribute("title");
            b_title.value=idx;
            b.setAttributeNode(b_type);
            b.setAttributeNode(b_class);
            b.setAttributeNode(b_title);
            b.appendChild(b_text);
            
            d.appendChild(l);
            d.appendChild(i);
            d.appendChild(b);
            addFiles.append(d);
            count++;
            idx++;
        } else {
            alert("파일 추가는 5개까지만 가능합니다.");
        }
    })

    addFiles.addEventListener("click", function(event){
        if(event.target.classList[2]=='del') {
            count--;
            let title = event.target.title;
            const div = document.getElementById("file"+title);
            div.remove();
        }
    })
} catch(e) {

}