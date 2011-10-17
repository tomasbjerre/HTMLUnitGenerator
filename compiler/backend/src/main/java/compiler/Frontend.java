package compiler;

import java.io.Reader;
import java.io.Writer;

import compiler.data.TargetFactory;

public interface Frontend {

	String compile(Reader reader, Writer output, String testFileName, TargetFactory targetFactory);

}
