section .data
    num1 db 5        ; Primer número
    num2 db 3        ; Segundo número
    result db 0       ; Variable para almacenar el resultado
    message db "Resultado: ", 0       ; Mensaje a mostrar

section .bss
    res resb 10       ; Espacio para almacenar el resultado como texto

section .text
    global _start

_start:
    ; Cargar los valores en registros
    mov al, [num1]    ; Mueve el primer número al registro AL
    add al, [num2]    ; Suma el segundo número con el contenido de AL
    mov [result], al  ; Guarda el resultado en la variable "result"

    ; Mostrar el mensaje y el resultado
    mov eax, 4        ; syscall: write
    mov ebx, 1        ; File descriptor: stdout
    mov ecx, message  ; Dirección del mensaje
    mov edx, 11       ; Longitud del mensaje
    int 0x80          ; Llamada al sistema

    ; Convertir el resultado a carácter ASCII
    mov eax, [result] 
    add eax, 48       ; Convertir a ASCII (sumar '0')
    mov [res], al

    mov eax, 4        ; syscall: write
    mov ebx, 1        ; File descriptor: stdout
    mov ecx, res      ; Dirección del resultado como texto
    mov edx, 1        ; Longitud del carácter
    int 0x80          ; Llamada al sistema

    ; Salir del programa
    mov eax, 1        ; syscall: exit
    xor ebx, ebx      ; Código de salida 0
    int 0x80

