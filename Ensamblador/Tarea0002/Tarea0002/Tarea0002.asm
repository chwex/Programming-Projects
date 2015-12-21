TITLE exprecion2
				.586
				.MODEL FLAT, STDCALL

;Prototipos de funciones a utilizar
GetStdHandle	PROTO :DWORD
ReadConsoleA	PROTO :DWORD, :DWORD, :DWORD, :DWORD, :DWORD
WriteConsoleA	PROTO :DWORD, :DWORD, :DWORD, :DWORD, :DWORD						
ExitProcess				PROTO :DWORD

INCLUDE <Macros.inc>

				.STACK
				.DATA
STD_INPUT_HANDLE	EQU	-10
STD_OUTPUT_HANDLE	EQU	-11				


PromptN				BYTE "Proporcione el valo de N: "
Long_PN				EQU		$ - PromptN

PromptM				BYTE "Proporcione el valor de M: "
Long_PM				EQU     $ - PromptM

PromptR				BYTE "Poporcione el valor de de R: "
Long_PR				EQU     $  - PromptR

Salida				BYTE	"EL RESULATADO DE E ES: "
Long_salida			EQU		$ -  Salida

Texto				BYTE  11 DUP(?)
Caracteres			DWORD   ?
ManejadorE			DWORD   ?
ManejadorS			DWORD	?
SaltoLinea          BYTE   13,10

N					DWORD 0
M					DWORD 0
R					DWORD 0
E					DWORD 0
					.CODE
					
Main				PROC
					;obtener manejadores de entrada y salida
					INVOKE	GetStdHandle, STD_INPUT_HANDLE
					MOV		ManejadorE, EAX
					INVOKE	GetStdHandle, STD_OUTPUT_HANDLE
					MOV		ManejadorS, EAX
					
					
					;Obtener el valor de N 
					MOV        EAX, Long_PN
					INVOKE WriteConsoleA, ManejadorS, ADDR PromptN, EAX, ADDR Caracteres, 0
					INVOKE ReadConsoleA, ManejadorE, ADDR Texto, 11, ADDR Caracteres, 0
					SUB				Caracteres, 2
					MacroCadenaAEntero		Texto, N
					
					
					;Obtener el valor de M
					MOV        EAX, Long_PM
					INVOKE WriteConsoleA, ManejadorS, ADDR PromptM, EAX, ADDR Caracteres, 0
					INVOKE ReadConsoleA, ManejadorE, ADDR Texto, 11, ADDR Caracteres, 0
					SUB				Caracteres, 2
					MacroCadenaAEntero		Texto, M
					
								
					;Obtener el valor de R 
					MOV        EAX, Long_PR
					INVOKE WriteConsoleA, ManejadorS, ADDR PromptR, EAX, ADDR Caracteres, 0
					INVOKE ReadConsoleA, ManejadorE, ADDR Texto, 11, ADDR Caracteres, 0
					SUB				Caracteres, 2
					MacroCadenaAEntero		Texto, R
					
															
					;evaluar n cuadrada n * n
					MOV	   EAX, N
					IMUL		N
					;(n*n /n)
					IDIV		N 
					MOV	   EBX,EAX
					
					;(4-M)
					MOV	   EAX , 4
					SUB    EAX, M
					MOV    EDX, EAX
					
					;(R*2)
					MOV	   EAX, 2
					IMUL   EAX, R
					MOV	   ECX, EAX
					
					IMUL   EBX,EDX
					ADD    EBX,ECX
					MOV		E,EBX
					
									
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