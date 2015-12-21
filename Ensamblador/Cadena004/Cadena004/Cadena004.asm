TITLE	Programa para obtener un substring desde la derecha
.686
.MODEL	FLAT, STDCALL

; Prototipos de funciones a utilizar
GetStdHandle	PROTO : DWORD
ReadConsoleA	PROTO : DWORD, : DWORD, : DWORD, : DWORD, : DWORD
WriteConsoleA	PROTO : DWORD, : DWORD, : DWORD, : DWORD, : DWORD
ExitProcess		PROTO : DWORD

INCLUDE <Macros.inc>

.STACK
.DATA
STD_INPUT_HANDLE	EQU - 10
STD_OUTPUT_HANDLE	EQU - 11
PromptA			BYTE	"Proporcione una cadena: "
Long_PA			EQU		$ - PromptA
PromptB			BYTE	"Proporcione el numero de caracteres: "
Long_PB			EQU		$ - PromptB
Men_Sal			BYTE	"El substring es: "
Long_MS			EQU		$ - Men_Sal
SaltoLinea		BYTE	13, 10
Cadena1			BYTE	80 DUP(? )
Cadena2			BYTE	80 DUP(? )
Long_C1			DWORD ?
NumeroCar		DWORD ?
Caracteres		DWORD ?
Texto			BYTE	11 DUP(? )
ManejadorE		DWORD ?
ManejadorS		DWORD ?

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

; Obtener el numero de caracteres
MOV		EAX, Long_PB
INVOKE	WriteConsoleA, ManejadorS, ADDR PromptB, EAX, ADDR Caracteres, 0
INVOKE	ReadConsoleA, ManejadorE, ADDR Texto, 11, ADDR Caracteres, 0
MacroCadenaAEntero	Texto, NumeroCar

MOV		EAX, Long_C1
CMP		EAX, NumeroCar
JAE		Iniciar				;Brincar si EAX es mayor o igual a NumeroCar

; Si es menor, entonces hacer Numero de Caracteres igual
; a la longitud de la cadena
MOV		NumeroCar, EAX

Iniciar :
; Posicionar los indices
LEA		ESI, Cadena1
ADD		ESI, Long_C1
DEC		ESI

LEA		EDI, Cadena2
ADD		EDI, NumeroCar
DEC		EDI

STD; DF = 1 Der a Izq

MOV		ECX, NumeroCar
REP		MOVSB

; Restaurar Bandera de Direccion
CLD

; Imprimir resultado
MOV		EAX, Long_MS
INVOKE	WriteConsoleA, ManejadorS, ADDR Men_Sal, EAX, ADDR Caracteres, 0
MOV		EAX, NumeroCar
INVOKE	WriteConsoleA, ManejadorS, ADDR Cadena2, EAX, ADDR Caracteres, 0
; Salto de linea
INVOKE	WriteConsoleA, ManejadorS, ADDR SaltoLinea, 2, ADDR Caracteres, 0

; Salir
INVOKE	ExitProcess, 0
Main			ENDP
END Main