@echo off

for /l %%i in (0,1,10) do (
    cls
    ping 127.0.0.1 -n 2 > nul
    echo %%i
)
