product_value = float(input("Valor do Produto: "))
product_discount = float(input("Valor do Desconto: "))/100

discount = product_value * product_discount
result = product_value - discount

print("Com um desconto de: %.2f o produto sai por: %.2f" % (discount,result))
