TITLE	Programa para encontrar la posicion de un caractere
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
PromptA			BYTE	"Proporcione la cadena: "
Long_PA			EQU		$ - PromptA
PromptB			BYTE	"Proporcione el caracter: "
Long_PB			EQU		$ - PromptB
Men_Sal			BYTE	"La posicion del caracter es: "
Long_MS			EQU		$ - Men_Sal
Men_Error		BYTE	"El caracter no se encuentra en la cadena."
Long_ME			EQU		$ - Men_Error
SaltoLinea		BYTE	13,10
Cadena1			BYTE	80 DUP ( ? )
Cadena2			BYTE	80 DUP ( ? )
Caracter		BYTE	?
Long_C1			DWORD	?
Posicion		DWORD	?
Texto			BYTE	11 DUP( ? )
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
				
				; Obtener el caracter
				MOV		EAX, Long_PB
				INVOKE	WriteConsoleA, ManejadorS, ADDR PromptB, EAX, ADDR Caracteres, 0
				INVOKE	ReadConsoleA, ManejadorE, ADDR Cadena2, 80, ADDR Caracteres, 0
				MOV		AL, Cadena2[0]
				MOV		Caracter, AL
				
				; Buscar el caracter en la cadena
				LEA		EDI, Cadena1
				MOV		ESI, EDI
				MOV		AL, Caracter
				CLD						; DF = 0 Izq a Der
				MOV		ECX, Long_C1
				REPNE	SCASB
				JNE		NO_EXISTE
				
				; Encontrado. Calcular la posicion
				SUB		EDI, ESI
				MOV		Posicion, EDI
				
				; Imprimir el resultado
				MOV		EAX, Long_MS
				INVOKE	WriteConsoleA, ManejadorS, ADDR Men_Sal, EAX, ADDR Caracteres, 0
				;Convertir texto a cadena
				MacroEnteroACadena Posicion, Texto, Caracteres
				;Imprimir Posicion
				INVOKE	WriteConsoleA, ManejadorS, ADDR Texto, Caracteres, ADDR Caracteres, 0
				INVOKE	WriteConsoleA, ManejadorS, ADDR SaltoLinea, 2, ADDR Caracteres, 0
				
				JMP		Salir
				
NO_EXISTE:
				MOV		EAX, Long_ME
				INVOKE	WriteConsoleA, ManejadorS, ADDR Men_Error, EAX, ADDR Caracteres, 0
				; Salto de linea
				INVOKE	WriteConsoleA, ManejadorS, ADDR SaltoLinea, 2, ADDR Caracteres, 0
				
Salir:
				; Salir
				INVOKE	ExitProcess, 0								
Main			ENDP
				END Main
