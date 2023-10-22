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
if "%mode%"=="3" goto reset
echo Hãy nhập đúng định dạng
goto run

:pull
set pullLog=
for /f "delims=" %%i in ('git.exe pull 2^>^&1') do (set pullLog=%%i)
if "x%pullLog:Already=%"=="x%pullLog%" if "x%pullLog:changed=%"=="x%pullLog%" goto pullErrHandle
echo Đã cập nhật về thiết bị
goto stop

:pullErrHandle
echo Hãy commit code trước
set /p msg=Nhập commit:
git.exe add .
git.exe commit -m "%msg%"
git.exe pull
echo Đã cập nhật về thiết bị
goto stop

:push
set pushLog=
set /p msg=Nhập commit:
git.exe add .
git.exe commit -m "%msg%"
for /f "delims=" %%i in ('git.exe push 2^>^&1') do (set pushLog=%%i)
if "x%pushLog:->=%"=="x%pushLog%" if "x%pushLog:up-to-date=%"=="x%pushLog%" goto :pushErrHandle
echo Đã cập nhật lên Github
goto stop

:pushErrHandle
echo Lỗi, đang thử lại
git.exe pull
git.exe push
echo Đã cập nhật lên Github
goto stop



:reset
set /p id=Nhập commit id:
set /p branch=Nhập branch name:
git.exe reset "--hard" %id%
git.exe push "-f" origin %branch%
echo Đã reset về commit %id%, nhớ nhắc mọi người clone code mới
goto stop

:stop
pause
exit