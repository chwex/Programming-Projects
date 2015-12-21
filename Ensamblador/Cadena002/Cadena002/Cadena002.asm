TITLE	Programa para obtener un substring
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
PromptA			BYTE	"Proporcione una primer cadena: "
Long_PA			EQU		$ - PromptA
PromptB			BYTE	"Proporcione la posicion inicial: "
Long_PB			EQU		$ - PromptB
PromptC			BYTE	"Proporcione el numero de caracteres: "
Long_PC			EQU		$ - PromptC
Men_Sal			BYTE	"El substring es: "
Long_MS			EQU		$ - Men_Sal
Men_Error		BYTE	"No existe posicion inicial."
Long_ME			EQU		$ - Men_Error
SaltoLinea		BYTE	13,10
Cadena1			BYTE	80 DUP ( ? )
Cadena2			BYTE	80 DUP ( ? )
Long_C1			DWORD	?
PosicionInicial	DWORD	?
NumeroCar		DWORD	?
Caracteres		DWORD	?
Texto			BYTE	11 DUP ( ? )
ManejadorE		DWORD	?
ManejadorS		DWORD	?

				.CODE
Main			PROC
				; Obtener manejadores de entrada y salida
				INVOKE	GetStdHandle, STD_INPUT_HANDLE
				MOV		ManejadorE, EAX
				INVOKE	GetStdHandle, STD_OUTPUT_HANDLE
				MOV		ManejadorS, EAX

				; Obtener la cadena
				MOV		EAX, Long_PA
				INVOKE	WriteConsoleA, ManejadorS, ADDR PromptA, EAX, ADDR Caracteres, 0
				INVOKE	ReadConsoleA, ManejadorE, ADDR Cadena1, 80, ADDR Caracteres, 0
				SUB		Caracteres, 2
				MOV		EAX, Caracteres
				MOV		Long_C1, EAX

				; Obtener la posicion inicial
				MOV		EAX, Long_PB
				INVOKE	WriteConsoleA, ManejadorS, ADDR PromptB, EAX, ADDR Caracteres, 0
				INVOKE	ReadConsoleA, ManejadorE, ADDR Texto, 11, ADDR Caracteres, 0
				MacroCadenaAEntero	Texto, PosicionInicial
				
				; Obtener el numero de caracteres
				MOV		EAX, Long_PC
				INVOKE	WriteConsoleA, ManejadorS, ADDR PromptC, EAX, ADDR Caracteres, 0
				INVOKE	ReadConsoleA, ManejadorE, ADDR Texto, 11, ADDR Caracteres, 0
				MacroCadenaAEntero	Texto, NumeroCar
				
				; Validar que la posicion inicial exista
				MOV		EAX, PosicionInicial
				CMP		EAX, Long_C1
				JA		MensajeError
				
				; Ver si nos alcanzan los caracteres
				MOV		EAX, PosicionInicial
				ADD		EAX, NumeroCar
				DEC		EAX
				CMP		EAX, Long_C1
				JBE		Iniciar
				; Ajustar numero de caracteres
				MOV		EAX, Long_C1
				SUB		EAX, PosicionInicial
				INC		EAX
				MOV		NumeroCar, EAX
				
Iniciar:
				;Copiar caracteres al substring
				LEA		ESI, Cadena1
				ADD		ESI, PosicionInicial
				DEC		ESI
				LEA		EDI, Cadena2
				CLD						; DF = 0, Izq a Der
				MOV		ECX, NumeroCar
				REP		MOVSB
				
				; Imprimir resultado
				MOV		EAX, Long_MS
				INVOKE	WriteConsoleA, ManejadorS, ADDR Men_Sal, EAX, ADDR Caracteres, 0
				MOV		EAX, NumeroCar
				INVOKE	WriteConsoleA, ManejadorS, ADDR Cadena2, EAX, ADDR Caracteres, 0
				; Salto de linea
				INVOKE	WriteConsoleA, ManejadorS, ADDR SaltoLinea, 2, ADDR Caracteres, 0

				JMP		Salir
				
MensajeError:
				MOV		EAX, Long_ME
				INVOKE	WriteConsoleA, ManejadorS, ADDR Men_Error, EAX, ADDR Caracteres, 0
				; Salto de linea
				INVOKE	WriteConsoleA, ManejadorS, ADDR SaltoLinea, 2, ADDR Caracteres, 0
				
Salir:
				; Salir
				INVOKE	ExitProcess, 0								
Main			ENDP
				END Main
