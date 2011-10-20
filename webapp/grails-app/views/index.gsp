<!doctype html>
<html>
  <head>
    <meta name="layout" content="main"/>
    <title>HTMLUnitGenerator WebGUI</title>
  </head>
  <body>
      <a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
      <div id="page-body" role="main">
        <h1>Welcome HTMLUnitGenerator WebGUI!</h1>
        <p>
          This is a web GUI for the <a href="http://github.com/tomasbjerre/HTMLUnitGenerator">HTMLUnitGenerator</a>.
        </p>


        <h1>Web Compiler</h1>
        <p id="webcompiler">
          Test code can be edited below and compiled into JUnit tests using the compile button below the text field.
          <g:form name="compileForm" url="[ controller: 'compile', action:'result' ]">
            <select name="source">
              <option value="flow">Flow to JUnit</option>
              <option value="xml">XML to JUnit</option>
            </select>
            <textarea name="testCode" class="codeArea"></textarea><br/>
            <g:submitToRemote controller="compile" action="result" update="compilationResult" value="Compile" before="isCompiling()" onComplete="doneCompiling()" />
            <img src="images/spinner.gif" style="display: none;" id="compilationResultAreaSpinner"/>
          </g:form>
        </p>
        <script language="javascript">
        <!--
        function isCompiling() {
          $('compilationResult').hide();
          $('compilationResultAreaSpinner').show();
        }
        
        function doneCompiling() {
          $('compilationResultAreaSpinner').hide();
          $('compilationResult').show();
        }
        //-->
        </script>
        <p id="compilationResultArea">
          Enter test code above and press "Compile" to generate JUnit test case.
          <textarea name="compilationResult" id="compilationResult" class="codeArea" style="display: none;">&nbsp;</textarea><br/>
        </p>
      </div>
  </body>
</html>
