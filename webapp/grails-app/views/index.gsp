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
          This is a web GUI for the <a href="http://github.com/tomasbjerre/HTMLUnitGenerator">HTMLUnitGenerator</a>. BNF is available <a href="#bnf">here</a>.
        </p>


        <h1>Web Compiler</h1>
        <p id="webcompiler">
          Test code can be edited below and compiled into JUnit tests using the compile button below the text field.
          <g:form name="compileForm" url="[ controller: 'compile', action:'xmlToJava' ]">
            <textarea name="testCode" class="codeArea"></textarea><br/>
            <g:submitToRemote controller="compile" action="xmlToJava" update="compilationResult" value="Compile" before="isCompiling()" onComplete="doneCompiling()" />
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


        <a name="bnf" />
        <h1>BNF</h1>
        <p>
          This is the BNF of the language used by <a href="http://github.com/tomasbjerre/HTMLUnitGenerator">HTMLUnitGenerator</a>.
        </p>
        <code>
          start 	::= 	test<br/>
          test 	::= 	( pathsTag )* ( urlsTag )* flowTag &lt;EOF&gt;<br/>
          flowTag 	::= 	&lt;FLOWBEGIN&gt; ( stateTag )* &lt;FLOWEND&gt;<br/>
          stateTag 	::= 	&lt;STATEBEGIN&gt; idAttribute &lt;RT&gt; ( findTag )* ( formTag )* ( ( ( transitionTag )? &lt;LTEND&gt; ) | ( &lt;LTEND&gt; ) ) &lt;STATEEND&gt;<br/>
          formTag 	::= 	&lt;FORMBEGIN&gt; idAttribute submitAttribute &lt;RT&gt; ( inputTag )* &lt;FORMEND&gt;<br/>
          inputTag 	::= 	&lt;INPUTBEGIN&gt; nameAttribute valueAttribute &lt;RTEND&gt;<br/>
          transitionTag 	::= 	&lt;TRANSITIONBEGIN&gt; toAttribute usingAttribute delayAttribute &lt;RTEND&gt;<br/>
          findTag 	::= 	&lt;FINDBEGIN&gt; pathAttribute &lt;RT&gt; ( textTag )* ( tagTag )* &lt;FINDEND&gt;<br/>
          textTag 	::= 	&lt;TEXTBEGIN&gt; content &lt;TEXTEND&gt;<br/>
          tagTag 	::= 	&lt;TAGBEGIN&gt; typeAttribute &lt;RT&gt; ( attributeTag )* &lt;TAGEND&gt;<br/>
          attributeTag 	::= 	&lt;ATTRIBUTEBEGIN&gt; nameAttribute valueAttribute &lt;RTEND&gt;<br/>
          pathsTag 	::= 	&lt;PATHSBEGIN&gt; ( pathTag )* &lt;PATHSEND&gt;<br/>
          pathTag 	::= 	&lt;PATHBEGIN&gt; idAttribute content &lt;PATHEND&gt;<br/>
          urlsTag 	::= 	&lt;URLSBEGIN&gt; ( urlTag )* &lt;URLSEND&gt;<br/>
          urlTag 	::= 	&lt;URLBEGIN&gt; idAttribute content &lt;URLEND&gt;<br/>
          idAttribute 	::= 	&lt;IDATTRIBUTE&gt; idDecl<br/>
          submitAttribute 	::= 	&lt;SUBMITATTRIBUTE&gt; idUse<br/>
          nameAttribute 	::= 	&lt;NAMEATTRIBUTE&gt; contentAttribute<br/>
          valueAttribute 	::= 	&lt;VALUEATTRIBUTE&gt; contentAttribute<br/>
          typeAttribute 	::= 	&lt;TYPEATTRIBUTE&gt; contentAttribute<br/>
          delayAttribute 	::= 	&lt;DELAYATTRIBUTE&gt; contentAttribute<br/>
          toAttribute 	::= 	&lt;TOATTRIBUTE&gt; idUse<br/>
          usingAttribute 	::= 	&lt;USINGATTRIBUTE&gt; idUse<br/>
          pathAttribute 	::= 	&lt;PATHATTRIBUTE&gt; idUse<br/>
          content 	::= 	&lt;CONTENT&gt;<br/>
          idDecl 	::= 	&lt;STRING_LITERAL&gt;<br/>
          idUse 	::= 	&lt;STRING_LITERAL&gt;<br/>
          contentAttribute 	::= 	&lt;STRING_LITERAL&gt;<br/>
        </code>
      </div>
  </body>
</html>
