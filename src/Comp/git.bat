echo off
color a
title Quan ly git
set dir=%~dp0
cd %dir%
:run
set /p mode=Chon che do(pull nhap 1, push nhap 2):
if "%mode%"=="1" goto pull
if "%mode%"=="2" goto push
echo Nhap dung dinh dang
goto run

:pull
set /p msg=Nhap commit:
git add .
git commit -m "%msg%"
git pull
echo Da cap nhat
goto stop

:push
set /p msg=Nhap commit:
git add .
git commit -m "%msg%"
git push
echo Da cap nhat len github
goto stop

:stop
pause
exit