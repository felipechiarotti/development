pilha = []

read = input("Digite a expressão: ")
i = 0
while i < len(pilha)+1:
    character = pilha[i]
    if character == '(':
        pilha.append(character)
    elif character == ')':
        del pilha[-1]
    i+=1

print(pilha)
if len(pilha) == 0:
    print("A expressão %s está OK!" % (read))
else:
    print("A expressão %s obteve Erro!" % (read))
