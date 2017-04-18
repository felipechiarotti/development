cart = []
while True:
    product_name = raw_input("Product: ")
    if product_name == "sair":
        break

    product_amount = int(input("Amount of %s: " % (product_name)))
    product_price = float(input("Price of %s: " % (product_name)))
    cart.append([product_name, product_amount, product_price])
    print()
order_value = 0.0

for key, product in enumerate(cart):
    print("Product %d" % (key+1))
    print("Name: %s\nAmount: %d\nPrice: %.2f\n" % (product[0],product[1],product[2]))
    order_value += product[1]*product[2]

print(order_value)