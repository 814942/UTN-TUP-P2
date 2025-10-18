@echo off
echo ===============================================
echo    KATAS DE HERENCIA Y POLIMORFISMO - JAVA
echo ===============================================
echo.

echo Compilando todas las Katas...
echo.

echo [1/4] Compilando Kata 1: Vehiculos...
cd "Kata1_Vehiculos"
javac Kata1_Vehiculos.java
if %errorlevel% neq 0 (
    echo ERROR: No se pudo compilar Kata1_Vehiculos.java
    pause
    exit /b 1
)
cd ..

echo [2/4] Compilando Kata 2: Figuras...
cd "Kata2_Figuras"
javac Kata2_Figuras.java
if %errorlevel% neq 0 (
    echo ERROR: No se pudo compilar Kata2_Figuras.java
    pause
    exit /b 1
)
cd ..

echo [3/4] Compilando Kata 3: Empleados...
cd "Kata3_Empleados"
javac Kata3_Empleados.java
if %errorlevel% neq 0 (
    echo ERROR: No se pudo compilar Kata3_Empleados.java
    pause
    exit /b 1
)
cd ..

echo [4/4] Compilando Kata 4: Animales...
cd "Kata4_Animales"
javac Kata4_Animales.java
if %errorlevel% neq 0 (
    echo ERROR: No se pudo compilar Kata4_Animales.java
    pause
    exit /b 1
)
cd ..

echo.
echo ✓ Todas las Katas compiladas exitosamente!
echo.
echo ===============================================
echo Ejecutando las Katas...
echo ===============================================
echo.

echo Presiona cualquier tecla para ejecutar Kata 1: Vehiculos...
pause >nul
echo.
cd "Kata1_Vehiculos"
java Kata1_Vehiculos
cd ..
echo.
echo ===============================================

echo Presiona cualquier tecla para ejecutar Kata 2: Figuras...
pause >nul
echo.
cd "Kata2_Figuras"
java Kata2_Figuras
cd ..
echo.
echo ===============================================

echo Presiona cualquier tecla para ejecutar Kata 3: Empleados...
pause >nul
echo.
cd "Kata3_Empleados"
java Kata3_Empleados
cd ..
echo.
echo ===============================================

echo Presiona cualquier tecla para ejecutar Kata 4: Animales...
pause >nul
echo.
cd "Kata4_Animales"
java Kata4_Animales
cd ..
echo.
echo ===============================================

echo.
echo ✓ Todas las Katas ejecutadas exitosamente!
echo.
echo Presiona cualquier tecla para salir...
pause >nul