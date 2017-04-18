result = 0
product_code = int(input("Código do Produto: "))
while product_code != 0:
    if product_code == 1 or product_code == 2 or product_code == 3 or product_code == 5 or product_code == 9:
        quantity = int(input("Quantidade Comprada: "))

    if product_code == 1:
        result=result+(0.5*quantity)
    elif product_code == 2:
        result=result+(1*quantity)
    elif product_code == 3:
        result=result+(4*quantity)
    elif product_code == 5:
        result=result+(7*quantity)
    elif product_code == 9:
        result=result+(8*quantity)
    else:
        print("Produto %d: Código Inválido" % (product_code))
    product_code  = int(input("Código do Produto: "))
print("Seu gasto foi de R$%.2f" % (result))
