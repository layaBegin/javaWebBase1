let score = window.prompt("请输入分数")

let result = ""
switch (true) {
    case score < 60:
        result="不及格"
        break;
    case score >= 60 && score < 70:
        result="及格"
        break;
    case score >= 70 && score < 80:
        result="良好"
        break;
    case score >= 90:
        result = "优秀"
        break;
    default:
        break;

}
document.write("结果："+result)