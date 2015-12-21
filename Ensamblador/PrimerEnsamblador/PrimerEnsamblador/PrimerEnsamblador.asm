					TITLE	Programa de ejemplo de Lenguaje Ensamblador
					.586
					.MODEL	FLAT, STDCALL

STD_OUTPUT_HANDLE	EQU		-11
GetStdHandle		PROTO	:DWORD
WriteConsoleA		PROTO	:DWORD, :DWORD, :DWORD, :DWORD, :DWORD
ExitProcess			PROTO	:DWORD

					.STACK
					.DATA
Nombre				BYTE	"Mi Nombre es Jaime Felix", 13, 10
Nombre2				BYTE	"Mi Nombre es David Hernandez", 13, 10
Nombre3				BYTE	"Mi Nombre es Carlos Valdez", 13, 10
Long_N				EQU		$ - Nombre
Long_N2				EQU		$ - Nombre2
Long_N3				EQU		$ - Nombre3
Manejador			DWORD	?
Caracteres			DWORD	?

					
					.CODE
Main				PROC
					INVOKE	GetStdHandle, STD_OUTPUT_HANDLE
					MOV		Manejador, EAX					
					
					; Mostrar mensaje
					MOV		EAX, Long_N
					MOV		ECX, Long_N2
					MOV		EDX, Long_N3
					INVOKE	WriteConsoleA, Manejador, ADDR Nombre, EAX, ADDR Caracteres, 0
					

					; Salir al SO
					INVOKE	ExitProcess, 0
Main				ENDP
					END		Main