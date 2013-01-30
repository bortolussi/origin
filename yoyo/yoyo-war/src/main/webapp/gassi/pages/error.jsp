<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" %>
<jsp:useBean id="target" scope="request" class="java.lang.String"/>
<jsp:useBean id="login" scope="request" class="java.lang.String"/>
<jsp:useBean id="message" scope="request" class="java.lang.String"/>

<html>
<head>
  <!-- Allow to have correct relative links to images -->
  <base href="<%=
	  request.getScheme()+"://"+
	  request.getServerName()+":"+
	  request.getServerPort()+
	  request.getContextPath()+"/gassi/pages/"%>"/>
  <title>GASSI - login error</title>
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>

  <!-- style sheets import -->
  <link href="../styles/reset.css" rel="stylesheet" type="text/css" media="screen"/>
  <link href="../styles/application.css" rel="stylesheet" type="text/css" media="screen"/>
</head>
<body>
  <div class="site">
    <div class="containerHeader">
      <a name="top"></a>
      <div class="header">
        <h1>${parent.artifactId}</h1>
      </div>
    </div>

    <div class="contentContainer">
      <!-- CONTENT -->
      <div class="content">
        <!--  form main title -->
        <h2>Authentication error</h2>
        
      <!-- END CONTENT -->
      </div>
    </div><!--  end contentContainer -->
    
    <div class="containerFooter">
      <a name="bas"></a>
      <!-- FOOTER -->
      <div class="footer">
        <div class="copy">France T&eacute;l&eacute;com 2011 &copy;</div>
        <div class="version">version ${project.version}</div>
      </div>
    </div><!-- end containerFooter -->
  </div><!-- end site -->

</body>
</html>
