@echo off
echo Gerando ZIP do projeto TCP Chat Java...
echo.

:: Compilar primeiro
call compilar.bat

:: Criar arquivo ZIP usando PowerShell
powershell -command "Compress-Archive -Path '*.java', '*.bat', 'README.md', 'build' -DestinationPath 'TCPChatJava-Complete.zip' -Force"

if exist "TCPChatJava-Complete.zip" (
    echo ✅ ZIP criado com sucesso: TCPChatJava-Complete.zip
    echo.
    echo O arquivo contém:
    echo - Código fonte (.java)
    echo - Arquivos compilados (.class na pasta build)
    echo - Scripts de execução (.bat)
    echo - Documentação (README.md)
) else (
    echo ❌ Erro ao criar o ZIP!
)

echo.
pause
