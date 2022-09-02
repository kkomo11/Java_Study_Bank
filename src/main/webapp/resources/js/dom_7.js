const remove1 = document.getElementById("remove1");
const remove2 = document.getElementById("remove2");
const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const d2_1 = document.getElementById("d2_1");
const d2_2 = document.getElementById("d2_2");
const d2_3 = document.getElementById("d2_3");
const d2_4 = document.getElementById("d2_4");
const h = document.getElementsByClassName("h");

remove1.addEventListener("click", function(){
    d1.remove();
})

remove2.addEventListener("click", function(){

    let length = h.length;

    for(let i=0; i<length; i++) {
        d2.removeChild(h[0]);
    }
})