@echo off
title Cliente TCP Chat
echo === INICIANDO CLIENTE TCP CHAT ===
echo.

if not exist "build\Cliente.class" (
    echo ❌ Arquivo Cliente.class não encontrado!
    echo Execute compilar.bat primeiro.
    echo.
    pause
    exit /b
)

echo Conectando ao servidor localhost:5000...
echo.

java -cp build Cliente

echo.
echo Cliente encerrado.
pause
