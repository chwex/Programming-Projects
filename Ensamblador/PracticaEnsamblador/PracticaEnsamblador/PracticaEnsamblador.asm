TITLE Programa que saca el factorial de un numero
		.686
		.MODEL	FLAT, STDCALL
		
		; Prototipos de funciones a utilizar
GetStdHandle	PROTO	:DWORD
ReadConsoleA	PROTO	:DWORD,	:DWORD,	:DWORD,	:DWORD,	:DWORD
WriteConsoleA	PROTO	:DWORD,	:DWORD,	:DWORD,	:DWORD,	:DWORD
ExitProcess		PROTO	:DWORD

INCLUDE <Macros.inc>

		.STACK
		.DATA
STD_INPUT_HANDLE	EQU		-10
STD_OUTPUT_HANDLE	EQU		-11
ManejadorS	DWORD	?
ManejadorE	DWORD	?
PromptE		BYTE	"Proporcione un numero entero positivo: "
Long_PE		EQU		$ - PromptE
MenPar		BYTE	"El Factorial es: "
Long_MP		EQU		$ - MenPar
Texto		BYTE	11 DUP ( ' ' )
Caracteres	DWORD	?					; Se utiliza para los caracteres realmente leidos  o escritos
SaltoLinea	BYTE	13,10
NU			DWORD	0
FC			DWORD	1
		.CODE
Main	PROC
		; Obtener manejadores de entrada y salida
		INVOKE	GetStdHandle, STD_INPUT_HANDLE
		MOV		ManejadorE, EAX
		INVOKE	GetStdHandle, STD_OUTPUT_HANDLE
		MOV		ManejadorS, EAX

		MOV		EAX, Long_PE
		INVOKE	WriteConsoleA, ManejadorS, ADDR PromptE, EAX, ADDR Caracteres, 0
		INVOKE	ReadConsoleA, ManejadorE, ADDR Texto, 13, ADDR Caracteres, 0
		MacroCadenaAEntero	Texto, NU
		
		
		;PROCESO
		;		EAX, NU
CICLO:
		MOV		EAX,NU
		MOV		EBX,FC
		IMUL	EAX,EBX
		MOV		FC, EAX

		CMP		NU,1
		JE		SALIR
		DEC		NU
		JMP		CICLO

		
SALIR:
			
		
		
		; Imprimir Resultados
		MOV		EAX, Long_MP
		INVOKE	WriteConsoleA, ManejadorS, ADDR MenPar, EAX, ADDR Caracteres, 0

		; Convertir de numero a cadena
		MacroEnteroACadena	FC, Texto, Caracteres
		INVOKE	WriteConsoleA, ManejadorS, ADDR Texto, Caracteres, ADDR Caracteres, 0
	
		; Saltar de línea
		INVOKE	WriteConsoleA, ManejadorS, ADDR SaltoLinea, 2, ADDR Caracteres, 0
	
		; Salir al SO
		INVOKE	ExitProcess, 0
						
Main	ENDP
		END	Main