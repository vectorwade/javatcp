@echo off
echo Compilando projeto TCP Chat Java...
echo.

if not exist "build" mkdir build

javac -d build *.java

if %errorlevel% == 0 (
    echo ✅ Compilação concluída com sucesso!
    echo Os arquivos .class estão na pasta build/
) else (
    echo ❌ Erro na compilação!
)

echo.
pause
