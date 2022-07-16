<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册2</title>
</head>
<body style="background-color: rgba(240, 242, 247, 100);">
<div>
    <img src="imgr_1.png" ;width="290px" ; height="290px" ; style="position:absolute; left:290px; top:60px; ">
</div>

<div style="background-color: white; width:390px; height:150px;position:absolute; left:615px; top:380px;">
    <!..字体..>
    <p  style="position:absolute;left: 70px;top: 30px;width: 70px;height: 28px;color: rgba(39, 39, 39, 100);font-size: 14px;text-align: left;">邮箱地址：</p>
    <p style="position:absolute;left: 70px;top: 60px;width: 150px;height: 28px;color: rgba(39, 39, 39, 100);font-size: 14px;text-align: left;">恭喜您注册成功！</p>
    <p id="email" style="position:absolute;left: 140px;top: 30px;width: 150px;height: 28px;color: rgba(39, 39, 39, 100);font-size: 14px;text-align: left;"></p>
    <!..按钮..>
    <a href="Login.html">
    <input type="button"  value="返回登录界面" style="border:none;width: 300px;height: 40px;line-height: 23px;border-radius: 37px;
      background-color: rgba(57, 82, 253, 100);color: rgba(255, 255, 255, 100);font-size: 16px;text-align: center;position:absolute; left:50px; top:200px; ">
    </a>
</div>
</body>
<?php
$a=$_POST['username'];
echo '<p hidden="hidden" id="uemail">'.$a.'</p>';
?>
<script>

    var user= document.getElementById('uemail').innerHTML;
    document.getElementById("email").innerHTML=user;
</script>
</html>
