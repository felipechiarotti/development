first_string = input()
second_string = input()
equals = []
for character in first_string:
    if(character in second_string):
        equals.append(character)
equals = "".join(equals)
print (equals)