cd /d "%~dp0"
git init
git add *
git commit -a -m "version initiale"
git remote add gitHubOrigin_al30_clientWs https://didier-tp:....!@github.com/didier-tp/al30_clientWs.git
git push -u gitHubOrigin_al30_clientWs master
pause

REM open with text editor
REM opne with system editor