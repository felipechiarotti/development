lista_original = [9,8,7,6,5,4,3,2,1]
lista_par = []
lista_impar = []

for key, element in enumerate(lista_original):
    if element % 2 == 0:
        lista_par.append(element)
    else:
        lista_impar.append(element)

print("Lista Par: ", lista_par)
print("Lista Impar: ", lista_impar)