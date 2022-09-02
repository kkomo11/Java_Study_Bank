const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const d3 = document.getElementById("d3");
const d4 = document.getElementById("d4");
const year = document.getElementById("year");
const month = document.getElementById("month");
const date = document.getElementById("date");

alert(d1.getAttribute("value"));
alert(d1.value);

d2.type="button";

let count = prompt("숫자를 입력하세요");
for(let i=0; i<count; i++) {
    d3.innerHTML+='<input type="text">';
}

for(let i=2022; i>=1900; i--) {
    year.innerHTML+='<option>'+i+'</option>';
}

for(let i=1; i<=12; i++) {
    month.innerHTML+='<option>'+i+'</option>';
}

for(let i=1; i<=31; i++) {
    date.innerHTML+='<option>'+i+'</option>';
}

let r=prompt("row의 갯수 입력");
let c=prompt("column의 갯수 입력");

let t='<thead>';
t+='<tr>';
for(let i=0; i<c; i++) {
    t+='<th>Column'+i+'</th>';
}
t+='</tr>';
t+='</thead>';

t+='<tbody>';
for(let i=0; i<r; i++) {
    t+='<tr>';
    for(let j=0; j<c; j++) {
        t+='<td>'+i+'_'+j+'</td>';
    }
    t+='</tr>';
}
t+='<tbody>';
d4.innerHTML=t;

/*
let t='';
for(let i=0; i<r; i++) {
    t+='<tr>'
        for(let j=0; j<c; j++) {
            t+='<td>'+i+j+'</td>'
        }
    t+='</tr>'
}
*/