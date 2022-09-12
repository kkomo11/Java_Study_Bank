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

function termsCheck() {
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

function joinCheck() {
    const userName = document.getElementById("userName");
    const errUserName = document.getElementById("errUserName");
    const passWord = document.getElementById("passWord");
    const errPassWord = document.getElementById("errPassWord");
    const rePassWord = document.getElementById("rePassWord");
    const errRePassWord = document.getElementById("errRePassWord");
    const name = document.getElementById("name");
    const errName = document.getElementById("errName");
    const email = document.getElementById("email");
    const errEmail = document.getElementById("errEmail");
    const phone = document.getElementById("phone");
    const errPhone = document.getElementById("errPhone");
    const frmJoin = document.getElementById("frmJoin");
    const btnJoin = document.getElementById("btnJoin");
    let un=false;
    let pw=false;
    let rpw=false;
    let na=false;
    let em=false;
    let ph=false;

    userName.addEventListener("blur", function(){
        if(userName.value.length <2) {
            errUserName.innerHTML="ID는 2글자 이상이어야 합니다.";
            un=false;
        } else {
            const xhttp = new XMLHttpRequest();
            xhttp.open("POST", "duplicateCheck");
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send("userName="+userName.value);
            xhttp.onreadystatechange=function(){
                if(this.readyState==4 && this.status==200) {
                    if(this.responseText=="") {
                        errUserName.innerHTML="";
                        un=true;
                    } else {
                        errUserName.innerHTML="ID 중복";
                        un=false;
                    }
                }
            }
        }
    })

    passWord.addEventListener("keyup", function(){
        const pwCheck = /^(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{6,}$/;
        if(pwCheck.test(passWord.value)) {
            errPassWord.innerHTML="";
            pw=true;
        } else {
            errPassWord.innerHTML="PW는 6글자 이상이고 영문자와 숫자로 이루어져 있어야 하고 대문자와 숫자가 최소 하나 필요합니다.";
            pw=false;
        }
    })

    rePassWord.addEventListener("blur", function(){
        if(passWord.value == rePassWord.value) {
            errRePassWord.innerHTML="일치";
            rpw=true;
        } else {
            errRePassWord.innerHTML="불일치";
            rePassWord.value="";
            rpw=false;
        }
    })
    
    name.addEventListener("blur", function(){
        if(name.value.length < 1) {
            errName.innerHTML="최소 한 글자 이상이어야 합니다.";
            na=false;
        } else {
            errName.innerHTML=""
            na=true;
        }
    })

    email.addEventListener("blur", function(){
        if(email.value.length < 1) {
            errEmail.innerHTML="최소 한 글자 이상이어야 합니다.";
            em=false;
        } else {
            errEmail.innerHTML="";
            em=true;
        }
    })

    phone.addEventListener("blur", function(){
        if(phone.value.length < 1) {
            errPhone.innerHTML="최소 한 글자 이상이어야 합니다.";
            ph=false;
        } else {
            errPhone.innerHTML="";
            ph=true;
        }
    })

    btnJoin.addEventListener("click", function(){
        if(un && pw && rpw && na && em && ph) {
            frmJoin.submit();
        } else {
            alert("필수 정보입니다. 입력해주세요");
        }
    })
}