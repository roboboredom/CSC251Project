@echo off

rem Run the javadoc command to generate a documentation website for the current java project. 
rem Use "-private" arg to toggle the documentation for private items.
rem "^" is just a newline wrapper for commands.
javadoc ^
-private ^
-d .\doc ^
-sourcepath .\src ^
-subpackages com.github.roboboredom.CSC251Project