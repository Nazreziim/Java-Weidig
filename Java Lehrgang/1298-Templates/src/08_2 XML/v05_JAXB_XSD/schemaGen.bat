@echo off
REM Ausführung im Ordner: H:\eclipseProjekte\FUSIX\src

REM die Pfad-Angaben zum Anpassen
REM das JDK
set JAVA_PATH="C:\Program Files\Java\jdk1.7.0_55"

REM der Pfad für schemagen.exe
set JAVA_BIN=%JAVA_PATH%\bin

REM die Java-Tools
set JAVA_TOOLS=%JAVA_PATH%\lib\tools.jar

REM Die Java-Dateien
set CLASS=Raum
set PACKAGE=xml.v06_JAXB.v04_MitXSD
set CLASSFILE=%PACKAGE%.%CLASS%
set DESTINATION="H:\eclipseProjekte\FUSIX\src\xml\v06_JAXB\v04_MitXSD"

REM Ausführung
PATH=%PATH%;%JAVA_BIN%
schemagen.exe %CLASSFILE% -cp %JAVA_TOOLS% -d %DESTINATION%
ren %DESTINATION%\schema1.xsd %CLASS%.xsd
PAUSE