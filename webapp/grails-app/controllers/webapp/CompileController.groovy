package webapp

class CompileController {
    def result = {
        def code = new Code()
        if (params.containsKey("testCode")) {
            code = new Code(params)
            def reader = new StringReader(code.testCode)
            def writer = new StringWriter();
            if (params["source"].equals("xml")) {
                code.messages = new xml.program.XMLFlowParser().compile(reader,writer,"TestWebGenerated",new compiler.data.xml.TargetFactory())
            } else if (params["source"].equals("flow")) {
                code.messages = new flow.program.FlowParser().compile(reader,writer,"TestWebGenerated",new compiler.data.flow.TargetFactory())
            }
            code.compiledTestCode = writer.toString();
        }
        [code: code]
    }
}