

antlr4 := java -Xmx500M -cp "./antlr-4.5.3-complete.jar:$CLASSPATH" org.antlr.v4.Tool
grun := java org.antlr.v4.gui.TestRig

main: antlr4 build

antlr4:
	curl -O http://www.antlr.org/download/antlr-4.5.3-complete.jar

build:
	$(antlr4) -no-listener -visitor L.g4
	javac L*.java

run:
	$(grun) L program -gui

run_test:
	bash run_test.sh

clean:
	rm *.class antlr-4.5.3-complete.jar
