const d1 = document.querySelector("#d1");
const d1_2_1_2 = document.querySelector("#d1_2_1_2");
const btn = document.querySelector("#btn");

console.log(d1_2_1_2.parentNode.parentNode.parentNode);
console.log(d1_2_1_2.previousSibling.previousSibling);
console.log(d1_2_1_2.nextSibling.nextSibling);
console.log("-------------------------------------------------------")
console.log(d1.children);
console.log(d1.childNodes[3].childNodes[1].childNodes[1].innerHTML);
console.log(d1.children[1].children[0].children[0].innerHTML);


d1.addEventListener("click", function(){
    // li 모두 삭제
    let li = d1.children[1].children[0].children;

    // remove 사용
    length = li.length;
    for(let i=0; i<length; i++){
        li[0].remove();
    }
})

btn.addEventListener("click", function(){
    let div = d1_2_1_2.parentNode.parentNode;
    console.log(d1_2_1_2.parentNode.parentNode);
    div.remove();
})

//test