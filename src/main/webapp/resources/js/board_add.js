const fileAdd = document.getElementById("fileAdd");
const addFiles = document.getElementById("addFiles");

let count=0;
fileAdd.addEventListener("click", function(){
    count++;
    if(count < 6) {
        let d = document.createElement("div"); // <div></div>
        let d_class = document.createAttribute("class"); //class=
        d_class.value="mb-3"; //class="mb-3"
        d.setAttributeNode(d_class); // <div class="mb-3"></div>

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
        i_id.value="file";
        i.setAttributeNode(i_type);
        i.setAttributeNode(i_class);
        i.setAttributeNode(i_name);
        i.setAttributeNode(i_id);
        
        d.appendChild(l);
        d.appendChild(i);
        addFiles.append(d);
    } else {
        alert("파일 추가는 5개까지만 가능합니다.");
    }
})