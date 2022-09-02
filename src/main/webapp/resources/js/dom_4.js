const ch = document.getElementsByClassName("ch");
const cb = document.getElementsByClassName("cb");
const all = document.getElementById("all");

for(let i=0; i<ch.length; i++) {
    ch[i].addEventListener("click", function(){
        alert(ch[i].value);
    })
}

all.addEventListener('click', function(){
    let c = false;
    if(all.checked) c=true;
    for(let i=0; i<cb.length; i++) {
        cb[i].checked=c;
    }
})

for(let i=0; i<cb.length; i++) {
    cb[i].addEventListener('click', function(){
        let c = 0;
        if(!cb[i].checked) all.checked=false;
        for(let j=0; j<cb.length; j++) {
            if(cb[j].checked) c=c+1;
        }
        console.log(c);
        if(c==cb.length) all.checked=true;
    })
}