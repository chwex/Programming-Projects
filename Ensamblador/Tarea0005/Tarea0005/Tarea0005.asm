TITLE	Programa para evaluar una expresión 2
				.586
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


PromptA				BYTE "Proporcione el valo de A: "
Long_PA				EQU		$ - PromptA

PromptB				BYTE "Proporcione el valor de B: "
Long_PB				EQU     $ - PromptB

PromptC1			BYTE "Proporcione el valor de C: "
Long_PC1			EQU     $  - PromptC1

PromptD				BYTE "Proporcione el valor de D: "
Long_PD				EQU     $  - PromptD

PromptE				BYTE "Proporcione el valor de E: "
Long_PE				EQU     $  - PromptE

PromptF				BYTE "Proporcione el valor de F: "
Long_PF				EQU     $  - PromptF

Salida				BYTE	"EL RESULATADO DE E ES: "
Long_salida			EQU		$ -  Salida

Texto				BYTE  11 DUP(?)
Caracteres			DWORD   ?
ManejadorE			DWORD   ?
ManejadorS			DWORD	?
SaltoLinea          BYTE   13,10

A					DWORD 0
B					DWORD 0
C1					DWORD 0
D					DWORD 0
E					DWORD 0
F					DWORD 0

					.CODE
					
Main				PROC
					;obtener manejadores de entrada y salida
					INVOKE	GetStdHandle, STD_INPUT_HANDLE
					MOV		ManejadorE, EAX
					INVOKE	GetStdHandle, STD_OUTPUT_HANDLE
					MOV		ManejadorS, EAX
					
					;Obtener el valor de A 
					MOV        EAX, Long_PA
					INVOKE WriteConsoleA, ManejadorS, ADDR PromptA, EAX, ADDR Caracteres, 0
					INVOKE ReadConsoleA, ManejadorE, ADDR Texto, 11, ADDR Caracteres, 0
					SUB				Caracteres, 2
					MacroCadenaAEntero		Texto, A
					
					
					;Obtener el valor de B
					MOV        EAX, Long_PB
					INVOKE WriteConsoleA, ManejadorS, ADDR PromptB, EAX, ADDR Caracteres, 0
					INVOKE ReadConsoleA, ManejadorE, ADDR Texto, 11, ADDR Caracteres, 0
					SUB				Caracteres, 2
					MacroCadenaAEntero		Texto, B
					
								
					;Obtener el valor de C1 
					MOV        EAX, Long_PC1
					INVOKE WriteConsoleA, ManejadorS, ADDR PromptC1, EAX, ADDR Caracteres, 0
					INVOKE ReadConsoleA, ManejadorE, ADDR Texto, 11, ADDR Caracteres, 0
					SUB				Caracteres, 2
					MacroCadenaAEntero		Texto, C1
					
								
					;Obtener el valor de D
					MOV        EAX, Long_PD
					INVOKE WriteConsoleA, ManejadorS, ADDR PromptD, EAX, ADDR Caracteres, 0
					INVOKE ReadConsoleA, ManejadorE, ADDR Texto, 11, ADDR Caracteres, 0
					SUB				Caracteres, 2
					MacroCadenaAEntero		Texto, D
					
					;Obtener el valor de E
					MOV        EAX, Long_PE
					INVOKE WriteConsoleA, ManejadorS, ADDR PromptE, EAX, ADDR Caracteres, 0
					INVOKE ReadConsoleA, ManejadorE, ADDR Texto, 11, ADDR Caracteres, 0
					SUB				Caracteres, 2
					MacroCadenaAEntero		Texto, E
					
					;Obtener el valor de F
					MOV        EAX, Long_PF
					INVOKE WriteConsoleA, ManejadorS, ADDR PromptF, EAX, ADDR Caracteres, 0
					INVOKE ReadConsoleA, ManejadorE, ADDR Texto, 11, ADDR Caracteres, 0
					SUB				Caracteres, 2
					MacroCadenaAEntero		Texto, F
						
						
					;Evaluar (C-E)
					MOV    EAX, C1
					SUB    EAX, E
					MOV    EBX,EAX
				
					;Evaluar (B+(C-E))
					MOV	  EAX, B
					ADD   EAX, EBX 
					MOV	  EBX,EAX
					
					;Evaluar A-(B+(C-E))
					MOV   EAX, A
					SUB	  EAX, EBX
					MOV   EBX, EAX
				
					;Evaluar  (D-F)
					MOV	  EDX, D
					SUB	  EDX, F
					MOV   ECX, EDX

					;Evaluar A-(B+(C-E))+(D-F)
					ADD   EBX, ECX
					MOV   E, EBX
					
										
				; Imprimir el resultado
				MOV		EAX, Long_salida
				INVOKE	WriteConsoleA, ManejadorS, ADDR Salida, EAX, ADDR Caracteres, 0
				
				;Convertir texto a cadena
				MacroEnteroACadena E, Texto, Caracteres
				
				;Imprimir Numero
				INVOKE	WriteConsoleA, ManejadorS, ADDR Texto, Caracteres, ADDR Caracteres, 0
				
				; Salto de Linea
				INVOKE	WriteConsoleA, ManejadorS, ADDR SaltoLinea, 2, ADDR Caracteres, 0
				
				; Salir
				INVOKE	ExitProcess, 0								
Main			ENDP
				END Main