<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>JavaByKiran | Log in</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/plugins/iCheck/square/blue.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="hold-transition login-page">
    <div class="login-box">
       <center>
        <img src="${pageContext.request.contextPath}/pages/pages/images/jbk.png" height="150px">
    </center> 
      <div class="login-logo">
        <a href="#"><b>Java By Kiran</b><h4>JAVA | SELENIUM | PYTHON</h4></a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
        <p class="login-box-msg">Sign in to start your session</p>
        <p style="color:red;text-align:center;">Logout successfully</p>
        
        <form:form id="form" action="loginprocess" modelAttribute="userobj">
          <div class="form-group has-feedback">
            <form:input path ="email" type="text" id="email" class="form-control" placeholder="Email" />
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            <div id="email_error" style="color:red;"></div>
          </div>
          <div class="form-group has-feedback">
            <form:input path ="password" type="password" id="password" class="form-control" placeholder="Password"/>
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            <div id="password_error" style="color:red;"></div>
          </div>
          <div class="row">
            
            <div class="col-xs-12">
              <input type="submit" class="btn btn-primary btn-block btn-flat" value="Sign In" />
            </div><!-- /.col -->
          </div>
        </form:form>


        <br>
        <a href="${pageContext.request.contextPath}/registeruser" class="text-center">Register a new membership</a>

      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->

    <!-- jQuery 2.1.4 -->
    <script src="${pageContext.request.contextPath}/pages/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="${pageContext.request.contextPath}/pages/bootstrap/js/bootstrap.min.js"></script>
    <!-- iCheck -->
    <script src="${pageContext.request.contextPath}/pages/plugins/iCheck/icheck.min.js"></script>
   <script>
      $("#form").submit(function(){
        var email = $("#email").val();
        var password = $("#password").val();

        //$("#email_error").text("");
        //$("#password_error").text("");

        if(email=='' && password==''){
          $("#email_error").text("Please enter email.");
          $("#password_error").text("Please enter password.");
          return false;
        }

        if(email!='' && password==''){
          if(!validateEmail(email)){
            $("#email_error").text("Please enter valid email.");
          }
          $("#password_error").text("Please enter password.");

          return false;
        }

        if(email=='' && password!=''){
          
          $("#email_error").text("Please enter email");
          return false;
        }

      });

      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });

      function validateEmail($email) {
        var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
        return emailReg.test( $email );
      }
    </script>
  </body>
</html>
