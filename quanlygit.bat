chcp 65001
echo off
color a
title Quản Lý Git
set dir=%~dp0
cd %dir%
cls
:run
set /p mode=Chọn chế độ(pull nhập 1, push nhập 2, reset branch nhập 3):
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
git.exe push
echo Đã cập nhật lên Github
goto stop

:reset
set /p id=Nhập commit id:
set /p branch=Nhập branch name:
git.exe reset --hard %id%
git.exe push -f origin %branch"
echo Đã reset về commit %id%
goto stop

:stop
pause
exit