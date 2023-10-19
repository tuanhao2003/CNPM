chcp 65001
echo off
color a
title Quản Lý Git
set dir=%~dp0
cd %dir%
cls
:run
set /p mode=Chọn chế độ(pull nhập 1, push nhập 2):
if "%mode%"=="1" goto pull
if "%mode%"=="2" goto push
echo Hãy nhập đúng định dạng
goto run

:pull
set /p msg=Nhập commit:
git.exe add .
git.exe commit -m "%msg%"
git.exe pull
echo Đã cập nhật về máy
goto stop

:push
set /p msg=Nhập commit:
git.exe add .
git.exe commit -m "%msg%"
<<<<<<< HEAD
=======
git.exe pull
>>>>>>> 211f988d04b9ebd80c5595bdeaa4122800f3b289
git.exe push
echo Đã cập nhật lên Github
goto stop

:stop
pause
exit