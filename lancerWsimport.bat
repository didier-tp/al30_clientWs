set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_144
set WSDL_URL=http://localhost:8080/serveurWs/services/tva?wsdl
cd /d "%~dp0"
"%JAVA_HOME%/bin/wsimport" -keep -d src/main/java %WSDL_URL%
pause

REM open with text editor sous eclipse pour editer ce fichier
REM open with system editor sous eclipse windows pour lancer les commandes
REM avant : vérifier que le ?wsdl est accessible (seveur démarré ?)
REM apres : refresh eclipse
REM         puis nouveau package "....client" comportant classe avec main()
REM         utilisant (new ....Service()).get....Port()