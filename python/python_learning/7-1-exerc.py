first_string = input()
second_string = input()

if(first_string.find(second_string) > -1):
    print("%s encontrado na posição %d de %s" % (second_string,first_string.find(second_string),first_string))
else:
    print("A string '%s' não possui ocorrência em '%s'" % (second_string,first_string))