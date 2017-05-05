estoque = {"Tomate": [1000, 2.30], "Rabanete": [320, 0.30]}
cart = []
valor_total = 0
while True:
    produto = input("Adicionar ao Carrinho (comprar): ")
    if produto == "comprar":
        break
    elif produto in estoque:
        quantidade = int(input("Quantidade de %s : " % (produto)))
        pedido = [produto,quantidade]
        cart.append(pedido)
        print(cart)
    else:
        print("Inexistente no estoque!")

for produto in cart:
    nome_produto, quantidade_produto = produto
    valor_total += estoque[nome_produto][1] * quantidade_produto
    estoque[nome_produto][0] -= quantidade_produto

for chave, dados in estoque.items():
    quantidade, valor = dados
    print("Produto: %s\nQuantidade: %d\nValor: R$%.2f\n" % (chave,quantidade,valor))
print("Valor da Compra: R$%.2f" % (valor_total))