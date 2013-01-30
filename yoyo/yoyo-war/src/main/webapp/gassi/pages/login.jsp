<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
  <title>GASSI - ${parent.artifactId} login</title>
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>

  <!-- style sheets import -->
  <link href="../styles/reset.css" rel="stylesheet" type="text/css" media="screen"/>
  <link href="../styles/application.css" rel="stylesheet" type="text/css" media="screen"/>

  <link href="../images/favicon.ico" rel="shortcut icon"/>   
</head>
<body onload="document.forms[0].elements[0].focus();">
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
        <h2>GASSI authentication - for development only</h2>
		<%if ((null != message) && !message.equals("")) {%>
			<div class="errors center"><%=message%></div>
			<%}%>
        
        <div class="center">
          <div class="block" >
            <div class="formHeader">
              <div class="formLeft">
                <h3>Data input</h3>
              </div>
            </div><!-- end header -->
          
            <div class="formBody">
              <!-- FORM -->
              <form action="<%=target%>" method="post">
                <div class="center">
                  <p>To connect as administrator : Login = adm / Password = adm</p>
                  <p>To connect as user : Login = usr / Password = usr</p>
                </div>
                <div class="input required">
                  <label for="nom"><span>*</span>Login</label>
                  <input type="text" id="nom" name="login" value="<%=login%>" maxlength="10" />
                </div>

                <div class="input required">
                  <label for="password"><span>*</span>Password</label>
                  <input type="password" id="password" name="password" value=""/>
                </div>
             
                <div class="center">
                  <input type="submit" class="button" title="Connect" value="Connect"/>
                </div>
              </form>
            </div>
          
            <div class="formFooterLeft">
              <div class="formFooter"> 
                <p class="nota">* : mandatory field</p>
              </div>
            </div>

          </div>
        </div>
      <!-- END CONTENT -->
      </div>
    </div><!--  end contentContainer -->
    
    <div class="containerFooter">
      <a name="bas"></a>
      <!-- FOOTER -->
      <div class="footer">
        <div class="copy">France T&eacute;l&eacute;com 2011 &copy;</div>
        <div class="user">
			<!-- Added for session affinity tests -->
			  Local Address: ${pageContext.request.localAddr}<br/>
			  Local Name:    ${pageContext.request.localName}<br/>
			  Local Port:    ${pageContext.request.localPort}<br/>
			  Server Name:   ${pageContext.request.serverName}<br/>
			  Server Port:   ${pageContext.request.serverPort}<br/>
		</div>
        <div class="version">
        	version:       ${project.version}<br/>
        	build date:    ${build.timestamp}<br/>
   			database type: <spring:eval expression="@applicationProperties.getProperty('database.name')" /><br/><br/>
        </div>
      </div>
    </div><!-- end containerFooter -->
  </div><!-- end site -->

</body>
</html>
