const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const btn1 = document.getElementById("btn1");
d1.innerHTML='Hello';

function test() {
    alert("Click Event 실행")
    let result = test2(1,2);
    console.log(result);
    f1();
}

//명명 함수
function test2(num1, num2) {
    let result = num1+num2;
    
    return result;
}

//익명 함수
let f1 = function () {
    console.log("익명 함수 실행")
}

d2.onclick = function(){
    console.log('Click callBack');
};

//3번째
btn1.addEventListener("click", function(){
    console.log('Click Button1');
});