

window.onload = function () {
    let username = getCookie("username")
    let password = getCookie("password")
    console.log("==username:"+username)
    console.log("==password:"+password)
    if (username && password){
        document.getElementById("un").value=username
        document.getElementById("pw").value=password
        let form = document.getElementById("loginForm")
        form.submit();
    }
}

getCookie = function (name) {
    let value = ""
    let cookies = document.cookie;
    console.log("cookies:"+cookies);
    //username=Jack; password=123
    let arr = cookies.split("; ");
    for(let item of arr){
        let result = item.split("=")
        if (result.length == 2 && result[0] == name){
            value = result[1];
            break;
        }
    }
    return value
}