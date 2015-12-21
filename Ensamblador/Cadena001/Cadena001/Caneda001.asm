TITLE	Programa para comparar si dos cadenas son iguales
				.686
				.MODEL	FLAT, STDCALL

;Prototipos de funciones a utilizar
GetStdHandle	PROTO	:DWORD
ReadConsoleA	PROTO	:DWORD, :DWORD, :DWORD, :DWORD, :DWORD
WriteConsoleA	PROTO	:DWORD, :DWORD, :DWORD, :DWORD, :DWORD
ExitProcess		PROTO	:DWORD

		.STACK
		.DATA
STD_INPUT_HANDLE	EQU	-10
STD_OUTPUT_HANDLE	EQU	-11
PromptA			BYTE	"Proporcione la primer cadena: "
Long_PA			EQU		$ - PromptA
PromptB			BYTE	"Proporcione la segunda cadena: "
Long_PB			EQU		$ - PromptB
Men_Sal_I		BYTE	"Las cadenas son iguales."
Long_MSI		EQU		$ - Men_Sal_I
Men_Sal_NI		BYTE	"Las cadenas no son iguales."
Long_MSNI		EQU		$ - Men_Sal_NI
SaltoLinea		BYTE	13,10
Cadena1			BYTE	80 DUP ( ? )
Cadena2			BYTE	80 DUP ( ? )
Long_C1			DWORD	?
Long_C2			DWORD	?
Caracteres		DWORD	?
ManejadorE		DWORD	?
ManejadorS		DWORD	?

				.CODE
Main			PROC
				; Obtener manejadores de entrada y salida
				INVOKE	GetStdHandle, STD_INPUT_HANDLE
				MOV		ManejadorE, EAX
				INVOKE	GetStdHandle, STD_OUTPUT_HANDLE
				MOV		ManejadorS, EAX

				; Obtener la primer cadena
				MOV		EAX, Long_PA
				INVOKE	WriteConsoleA, ManejadorS, ADDR PromptA, EAX, ADDR Caracteres, 0
				INVOKE	ReadConsoleA, ManejadorE, ADDR Cadena1, 80, ADDR Caracteres, 0
				SUB		Caracteres, 2
				MOV		EAX, Caracteres
				MOV		Long_C1, EAX
				
				; Obtener la segunda cadena
				MOV		EAX, Long_PB
				INVOKE	WriteConsoleA, ManejadorS, ADDR PromptB, EAX, ADDR Caracteres, 0
				INVOKE	ReadConsoleA, ManejadorE, ADDR Cadena2, 80, ADDR Caracteres, 0
				SUB		Caracteres, 2
				MOV		EAX, Caracteres
				MOV		Long_C2, EAX
				
				; Comparar las dos longitudes de las cadenas
				MOV		EAX, Long_C1
				CMP		EAX, Long_C2
				JNE		DIFERENTES
				
				; Las longitudes son iguales, comparar caracteres
				LEA		ESI, Cadena1
				LEA		EDI, Cadena2
				CLD						; DF=0. Izq a Der
				MOV		ECX, Long_C1
				REPE	CMPSB
				
				JNE		DIFERENTES
				
				; Los cadenas son iguales
				
				; Imprimir mensaje de iguales				
				MOV		EAX, Long_MSI
				INVOKE	WriteConsoleA, ManejadorS, ADDR Men_Sal_I, EAX, ADDR Caracteres, 0
				; Salto de linea
				INVOKE	WriteConsoleA, ManejadorS, ADDR SaltoLinea, 2, ADDR Caracteres, 0

				JMP		Salir
DIFERENTES:
				; Imprimir mensaje de no iguales
				MOV		EAX, Long_MSNI
				INVOKE	WriteConsoleA, ManejadorS, ADDR Men_Sal_NI, EAX, ADDR Caracteres, 0
				; Salto de linea
				INVOKE	WriteConsoleA, ManejadorS, ADDR SaltoLinea, 2, ADDR Caracteres, 0

Salir:
				; Salir
				INVOKE	ExitProcess, 0								
Main			ENDP
				END Main
