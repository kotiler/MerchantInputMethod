<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>忘记密码</title>
</head>
<body>
<!..文字..>
<p style="width: 29px;height: 20px;color:black;font-size: 14px;position:absolute; left:440px; top:60px;">登录</p>
<p style="width: 100px;height: 20px;color:rgba(153, 153, 153, 100);;font-size: 14px;position:absolute; left:470px; top:60px;"> > 忘记密码</p>
<p style="width: 50px;height: 20px;color:black;font-size: 14px;position:absolute; left:538px; top:200px;">新密码:</p>
<p style="width: 60px;height: 20px;color:black;font-size: 14px;position:absolute; left:524px; top:280px;">确认密码:</p>
<p style="width: 50px;height: 20px;color:black;font-size: 14px;position:absolute; left:552px; top:360px;">邮箱:</p>
<p style="width: 50px;height: 20px;color:black;font-size: 14px;position:absolute; left:552px; top:440px;">验证:</p>

<img src="imgfp_2.png" ;width="40px" ; height="40px" ; style="position:absolute; left:435px; top:100px; ">
<form method="post">
    <!..输入框..>
    <input type="password" name="newpassword" placeholder="请输入新密码" id="pass1" style="width: 300px;height: 40px;line-height: 20px;border-radius: 30px;
     border: 1px solid rgba(211, 211, 211, 100);position:absolute; left:610px; top:200px; padding-left:18px;">
    <input type="password" name="password" placeholder="输入确认密码" id="pass2" style="width: 300px;height: 40px;line-height: 20px;border-radius: 30px;
     border: 1px solid rgba(211, 211, 211, 100);position:absolute; left:610px; top:280px; padding-left:18px;">
    <input type="text" name="username" placeholder="请输入邮箱验证码" id="word" style="width: 300px;height: 40px;line-height: 20px;border-radius: 30px;
     border: 1px solid rgba(211, 211, 211, 100);position:absolute; left:610px; top:440px; padding-left:18px;">

    <input type="button" name="submit" value="确认修改" id="sub" style="border:none;width: 320px;height: 40px;line-height: 23px;border-radius: 37px;
      background-color: rgba(57, 82, 253, 100);color: rgba(255, 255, 255, 100);font-size: 16px;text-align: center;position:absolute; left:610px; top:520px; " onclick="changecheck()">
    <input type="button" name="send" value="发送验证码" id="send" style="border:none;width: 80px;height: 20px;line-height: 20px;border-radius: 37px;
      background-color: rgba(57, 82, 253, 100);color: rgba(255, 255, 255, 100);font-size: 10px;text-align: center;position:absolute; left:830px; top:450px;" onclick="sendemail(this)">
    <!..账号..>
    <p type="text" name="username" id="user" style="width: 198px;height: 21px;color: rgba(16, 16, 16, 100);font-size: 14px;position:absolute; left:610px; top:360px; "></p>

    <!..警告信息..>
    <p id="ppwarn" style='width: 231px; height: 20px; color: rgba(236, 56, 56, 94); font-size: 14px;position:absolute; left:620px;top:320px;'></p>
    <p id="wordwarn" style='width: 231px; height: 20px; color: rgba(236, 56, 56, 94); font-size: 14px;position:absolute; left:620px;top:400px;'></p>
    <p id="emailwarn" style='width: 231px; height: 20px; color: rgba(236, 56, 56, 94); font-size: 14px;position:absolute; left:620px;top:480px;'></p>
</form>
<?php
$a=$_POST['username'];
echo '<p hidden="hidden" id="uemail">'.$a.'</p>';
?>
<script type="text/javascript">
    var user= document.getElementById('uemail').innerHTML;
    document.getElementById("user").innerHTML=user;
    var emailword;
    //发送验证码
    function sendemail(object){

        document.getElementById("ppwarn").innerHTML="";
        document.getElementById("wordwarn").innerHTML="";
        var pass1=document.getElementById('pass1').value;
        var pass2=document.getElementById('pass2').value;
        if(pass1==='' || pass2==='')
        {
            document.getElementById("ppwarn").innerHTML="存在输入密码为空";
        }
        else{
            if(pass1 !== pass2 )
            {
                document.getElementById("ppwarn").innerHTML="两次输入的密码不一致";
            }
            else{
                time(object);
                var data={"u_email":user,"u_password":''};
                var httpRequest = new XMLHttpRequest();//第一步：建立所需的对象
                httpRequest.open("POST", "http://localhost:8088/user/send", true);  //调用AddDataToServer
                httpRequest.setRequestHeader("Content-type", "application/JSON"); //设置请求头信
                httpRequest.send(JSON.stringify(data)); //设置为发送给服务器数据
                //回调函数，获取返回数据
                httpRequest.onreadystatechange = function() {
                    if (httpRequest.readyState == 4) {
                        //根据服务器的响应内容格式处理响应结果
                        if(httpRequest.getResponseHeader('content-type')==='application/json'){
                            var result = JSON.parse(httpRequest.responseText);
                            emailword=result["identifingCode"];
                        }
                    }
                }
            }
        }

    }
    var wait=60;
    function time(object){
        if(wait==0){
            document.getElementById("send").style.backgroundColor="rgba(57, 82, 253, 100)";
            object.removeAttribute("disabled");
            object.value ="发送验证码";
            wait = 60;
        }else{
            document.getElementById("send").style.backgroundColor="gray";
            object.setAttribute("disabled",true);
            wait--;
            object.value = wait + "S";
            setTimeout(function(){time(object)},1000);
        }
    }
    //整体验证
    function changecheck(){
        var word=document.getElementById('word').value;
        if(word!==''){
            if(word===emailword) {

                var pass = document.getElementById('pass1').value;
                var data = {"u_email": user, "u_password": pass};
                var httpRequest = new XMLHttpRequest();//第一步：建立所需的对象
                httpRequest.open("POST", "http://localhost:8088/user/change", true);  //调用AddDataToServer
                httpRequest.setRequestHeader("Content-type", "application/JSON"); //设置请求头信
                httpRequest.send(JSON.stringify(data)); //设置为发送给服务器数据
                httpRequest.onreadystatechange = function () {
                    if (httpRequest.readyState == 4) {
                        //根据服务器的响应内容格式处理响应结果
                        if (httpRequest.getResponseHeader('content-type') === 'application/json') {
                            var result = JSON.parse(httpRequest.responseText);
                            //根据返回结果判断验证码是否正确
                            if (result["code"] === 4004) {
                                window.location.href = "fpassword3.html";
                            }
                            else{
                                document.getElementById("emailwarn").innerHTML="修改失败，邮箱不存在!";
                            }

                        }
                    }
                }
            }
            else{document.getElementById("wordwarn").innerHTML="验证码错误!";}
        }
        else{
            document.getElementById("wordwarn").innerHTML="请输入验证码";
        }

    }
</script>
</body>
</html>