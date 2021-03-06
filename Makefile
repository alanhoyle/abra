# Make file for ABRA
# libAbra is invoked from the ABRA java code

SRCDIR=src/main/c

all: clean native java

java:
	mvn package

mktargetdir:
	mkdir target

native: mktargetdir
	g++ -g -I$(SRCDIR) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/linux -shared -fPIC $(SRCDIR)/assembler.cpp -o target/libAbra.so

standalone:
	g++ -g -I$(SRCDIR) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/linux $(SRCDIR)/assembler.cpp -o abra

clean:
	rm -rf target
	mvn clean

# TODO: Parameterize version
javah: java
	javah -classpath target/abra-0.53-SNAPSHOT.jar abra.NativeAssembler
