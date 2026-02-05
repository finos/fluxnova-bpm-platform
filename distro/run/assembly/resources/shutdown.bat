@echo off

SET BASEDIR=%~dp0
SET EXECUTABLE=%BASEDIR%internal\run.bat

REM stop Fluxnova Run
call "%EXECUTABLE%" stop