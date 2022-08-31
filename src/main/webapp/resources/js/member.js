function loginCheck() {
    let btnSubmit = document.getElementById("btnSubmit");
    let form = document.getElementById("form");
    let userName = document.getElementById("userName");
    let passWord = document.getElementById("passWord");
    let errMsg = document.getElementById("errMsg");

    btnSubmit.addEventListener("click", function(){
        if(userName.value.length==0) {
            errMsg.innerText="ID를 입력하세요";
        } else if(passWord.value.length==0) {
            errMsg.innerText="PW를 입력하세요";
        } else {
            form.submit();
        }
    })
}

function check() {
    const allCheck = document.getElementById("allCheck");
    const btnTerms = document.getElementById("btnTerms");
    const form = document.getElementById("form");
    const errMsg = document.getElementById("errMsg");
    const termsChecks = document.getElementsByClassName("termsCheck");
    const req = document.getElementsByClassName("req");

    allCheck.addEventListener("click", function(){
        for(let i=0; i<termsChecks.length; i++) {
            termsChecks[i].checked=allCheck.checked;
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
        let c = true
        for(let i=0; i<req.length; i++) {
            if(!req[i].checked) {
                c=false;
                break;
            }
        }

        if(c) {
            form.submit();
        } else {
            errMsg.innerText="네이버 이용약관과 개인정보 수집 및 이용에 대한 안내 모두 동의해주세요.";
        }
    });
}