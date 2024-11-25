@echo off
rem Generates javadoc website for the project. 
rem "-private" includes private items in the documentation.
javadoc ^
-private ^
-d doc ^
-sourcepath src ^
-subpackages com.github.roboboredom.CSC251Project