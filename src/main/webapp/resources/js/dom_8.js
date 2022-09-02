const count = document.getElementById("count");
const btn = document.getElementById("btn");
const result = document.getElementById("result");
const c1 = document.getElementsByClassName("c1");
const d1 = document.getElementById("d1");
const d1_1 = document.getElementById("d1_1");
const d1_1_1 = document.getElementById("d1_1_1");
const google = document.getElementById("google");

//let k=0;

btn.addEventListener("click", function(){
    for(let i=0; i<count.value; i++) {
        let b = document.createElement("button");
        let bClass = document.createAttribute("class");
        bClass.value='c1';
        let bContents = document.createTextNode('CLICK'+i);
        b.setAttributeNode(bClass);
        b.appendChild(bContents);

        result.append(b);
    }
   // def();
})

result.addEventListener("click", function(event){
    if(event.target.className=='c1') {
        alert(event.target.innerHTML);
    }
})

// function def() {
//     console.log(c1.length);
//     for(let i=k; i<c1.length; i++) {
//         c1[i].addEventListener("click", function(){
//             alert(c1[i].innerHTML);
//         })
//     }
//     k=c1.length;
// }

d1.addEventListener("click", function(event){
    console.log('d1 click');
    console.log(event);
    console.log(event.currentTarget);
    console.log(event.target);
    if(event.target.className=='buttons') {
        alert("buton");
        console.log("this : ", this);
        alert(event.target.innerHTML);
    }
}, true)


google.addEventListener("click", function(event){
    alert('go Google');
    event.preventDefault();
})