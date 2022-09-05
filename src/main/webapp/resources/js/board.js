const allCheck = document.getElementById("allCheck");
const btnTerms = document.getElementById("btnTerms");
const form = document.getElementById("form");
const errMsg = document.getElementById("errMsg");
const termsChecks = document.getElementsByClassName("termsCheck");

allCheck.addEventListener("click", function(){
    let c = false;
    if(allCheck.checked) c = true;
    for(let i=0; i<termsChecks.length; i++) {
        termsChecks[i].checked=c;
    }
});

for(let i=0; i<termsChecks.length; i++) {
    termsChecks[i].addEventListener("click", function(){
        if(!termsChecks[i].checked) allCheck.checked=false;
        let c=0;
        for(let j=0; j<termsChecks.length; j++) {
            if(termsChecks[j].checked) c++;
        }
        if(c==termsChecks.length) allCheck.checked=true;
    });
}

btnTerms.addEventListener("click", function(){
    if(termsChecks[0].checked && termsChecks[1].checked) {
        form.submit();
    } else {
        errMsg.innerText="네이버 이용약관과 개인정보 수집 및 이용에 대한 안내 모두 동의해주세요.";
    }
});
