@echo off
echo Criando arquivos JAR executáveis...
echo.

if not exist "build\Servidor.class" (
    echo Compilando primeiro...
    call compilar.bat
)

echo Criando Servidor.jar...
echo Main-Class: Servidor > MANIFEST.MF
jar cfm Servidor.jar MANIFEST.MF -C build .

echo Criando Cliente.jar...
echo Main-Class: Cliente > MANIFEST.MF
jar cfm Cliente.jar MANIFEST.MF -C build .

del MANIFEST.MF

if exist "Servidor.jar" if exist "Cliente.jar" (
    echo ✅ Arquivos JAR criados com sucesso!
    echo.
    echo Para executar:
    echo   Servidor: java -jar Servidor.jar
    echo   Cliente:  java -jar Cliente.jar
) else (
    echo ❌ Erro ao criar os JARs!
)

echo.
pause
