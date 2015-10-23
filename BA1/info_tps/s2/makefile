
# Compiler
CC = javac

# Java Command
JVM = java

# Flags:
CFLAGS = 
RFLAGS = 

# Sources in this directory to Compile
SRCS = $(wildcard *.java)
OBJS = $(wildcard *.class)

.PHONY : default Release Debug all $(SUBDIRS) clean

all: default

default: Run

Run: Compile
	$(JVM) -cp . $(OBJS:.class=)

Compile:
	$(CC) $(CFLAGS) $(R_CFLAGS) $(SRCS)

clean:
	rm -f *.class
