package webapp

import program.XMLFlowParser;

class CompileController {
    def xmlToJava = {
        def code = new Code()
        if (params.containsKey("testCode")) {
            code = new Code(params)
            def reader = new StringReader(code.testCode)
            def writer = new StringWriter();
            code.messages = new XMLFlowParser().compile(reader,writer,"TestWebGenerated")
            code.compiledTestCode = writer.toString();
	}
        [code: code]
    }
}