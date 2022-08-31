const d1= document.getElementById("d1");
const d2= document.getElementById("d2");
const d3= document.getElementById("d3");
const d4= document.getElementById("d4");
const d5= document.getElementById("d5");
const span= document.getElementById("span");


d2.addEventListener("focus", function(){
    console.log('d2 focus');
});

d2.addEventListener("blur", function(){
    console.log('d2 blur');
})

//d1입력하고 나왔을 때 글자의 길이가 3글자 이하라면 d1 다시 강제로 입력대기
d1.addEventListener("blur", function(){
    if(d1.value.length < 4) {
        d1.focus();
    }
})

d3.addEventListener("change", function(){
    console.log('change Event 발생')
})

d4.addEventListener("keyup", function(){
    console.log('key up')
    span.innerHTML=d4.value.length * 1000;
})

d5.addEventListener("change", function(){
    console.log('change d5')
})