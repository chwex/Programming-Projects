				TITLE	Programa para convertir de minusculas a mayusculas
				.686
				.MODEL	FLAT, STDCALL


;Prototipos de funciones a utilizar
GetStdHandle	PROTO	:DWORD
ReadConsoleA	PROTO	:DWORD, :DWORD, :DWORD, :DWORD, :DWORD
WriteConsoleA	PROTO	:DWORD, :DWORD, :DWORD, :DWORD, :DWORD
ExitProcess		PROTO	:DWORD

INCLUDE <Macros.inc>

		.STACK
		.DATA
STD_INPUT_HANDLE	EQU	-10
STD_OUTPUT_HANDLE	EQU	-11
PromptA			BYTE	"Introdusca Cadena:"
Long_PA			EQU		$ - PromptA
Men_Sal			BYTE	"Numero Mayusculas: "
Long_MS			EQU		$ - Men_Sal
Men_Sal2		BYTE	"Numero Minusculas: "
Long_MS2		EQU		$ - Men_Sal2
SaltoLinea		BYTE	13,10
Texto			BYTE	80 DUP ( ? )
Caracteres		DWORD	?
Min				DWORD	0
May				DWORD	0
ManejadorE		DWORD	?
ManejadorS		DWORD	?

				.CODE
Main			PROC
				; Obtener manejadores de entrada y salida
				INVOKE	GetStdHandle, STD_INPUT_HANDLE
				MOV		ManejadorE, EAX
				INVOKE	GetStdHandle, STD_OUTPUT_HANDLE
				MOV		ManejadorS, EAX

				; Obtener la cadena en minusculas
				MOV		EAX, Long_PA
				INVOKE	WriteConsoleA, ManejadorS, ADDR PromptA, EAX, ADDR Caracteres, 0
				INVOKE	ReadConsoleA, ManejadorE, ADDR Texto, 80, ADDR Caracteres, 0
				
				; Ajustar la longitud de la cadena
				SUB		Caracteres, 2					; Para quitar el 13, 10
				
				; Ciclo por la longitud de la cadena
				MOV		ECX, Caracteres
				MOV		ESI, 0							; indice de la cadena
Inicio:
				; Preguntar si es caracter en minuscula
				CMP		Texto[ESI], 'a'
				JB		Continuar
				CMP		Texto[ESI], 'z'
				JA		Continuar
				
				; Es minuscula
				INC		Min

Continuar:
				; Incrementar indice
				INC		ESI
				LOOP	Inicio
				SUB		ESI, Min
				MOV		May, ESI

				
				; Imprimir Mayusculas
				MOV		EAX, Long_MS
				INVOKE	WriteConsoleA, ManejadorS, ADDR Men_Sal, EAX, ADDR Caracteres, 0	
				MacroEnteroACadena	May, Texto, Caracteres			
				INVOKE	WriteConsoleA, ManejadorS, ADDR Texto, Caracteres, ADDR Caracteres, 0

				; Salto de linea
				INVOKE	WriteConsoleA, ManejadorS, ADDR SaltoLinea, 2, ADDR Caracteres, 0

				; Imprimir Minusculas
				MOV		EAX, Long_MS
				INVOKE	WriteConsoleA, ManejadorS, ADDR Men_Sal2, EAX, ADDR Caracteres, 0
				MacroEnteroACadena	Min, Texto, Caracteres				
				INVOKE	WriteConsoleA, ManejadorS, ADDR Texto, Caracteres, ADDR Caracteres, 0
				
				; Salto de linea
				INVOKE	WriteConsoleA, ManejadorS, ADDR SaltoLinea, 2, ADDR Caracteres, 0
				
				; Salir
				INVOKE	ExitProcess, 0								
Main			ENDP
				END Main
				