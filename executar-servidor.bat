@echo off
title Servidor TCP Chat
echo === INICIANDO SERVIDOR TCP CHAT ===
echo.

if not exist "build\Servidor.class" (
    echo ❌ Arquivo Servidor.class não encontrado!
    echo Execute compilar.bat primeiro.
    echo.
    pause
    exit /b
)

echo Iniciando servidor na porta 5000...
echo Para parar o servidor, pressione Ctrl+C
echo.

java -cp build Servidor

echo.
echo Servidor encerrado.
pause
