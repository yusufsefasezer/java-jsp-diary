# Java JSP Diary
# Reporte de Sonarlint:

## Clase UserRepository.java
Podemos apreciar que el codigo esta duplicando varios valores mas de 3 veces, sugiriendonos reemplazarlo con una constante en su lugar.
![image](https://github.com/Berly01/java-jsp-diary/assets/104027221/c69d37c5-a781-4737-81d7-53206d2b008b)

## Bloque de codigo en cuestion:
Similares a estos, donde se ve lo detallado en el reporte:
![image](https://github.com/Berly01/java-jsp-diary/assets/104027221/ecd7c13d-4ddc-4f88-ac63-4ff8d7bbbc46)

##Correcion:
Creamos las constantes para usarlas en los demas bloques de codigo:
![image](https://github.com/Berly01/java-jsp-diary/assets/104027221/0bb741b9-a021-471e-8696-f6a7538c366a)
Los colocamos en las funciones correspondientes (las demas son similares):
![image](https://github.com/Berly01/java-jsp-diary/assets/104027221/a5d9a80b-6f0a-469a-89a5-368c8235b54e)

