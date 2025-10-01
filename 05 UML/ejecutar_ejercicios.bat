@echo off
echo ========================================
echo SISTEMA DE EJERCICIOS UML EN JAVA
echo ========================================
echo.

REM Compilar y ejecutar ejercicio 1
echo --- EJERCICIO 1: Pasaporte - Foto - Titular ---
javac ejercicio1/*.java
if %errorlevel% == 0 (
    java ejercicio1.TestPasaporte
    echo.
) else (
    echo Error compilando ejercicio 1
    echo.
)

REM Compilar y ejecutar ejercicio 2
echo --- EJERCICIO 2: Celular - Bateria - Usuario ---
javac ejercicio2/*.java
if %errorlevel% == 0 (
    java ejercicio2.TestCelular
    echo.
) else (
    echo Error compilando ejercicio 2
    echo.
)

REM Compilar y ejecutar ejemplo de dependencia
echo --- EJEMPLO: Dependencia de Uso ---
javac dependencia/*.java
if %errorlevel% == 0 (
    java dependencia.TestReproductor
    echo.
) else (
    echo Error compilando dependencia
    echo.
)

echo ========================================
echo TODOS LOS EJERCICIOS COMPLETADOS
echo ========================================
pause