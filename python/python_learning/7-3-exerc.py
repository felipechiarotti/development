strings =[""+input(),""+input()]
equals = []

total_strings = len(strings)-1
for string in strings:
    for character in string:
        if (character not in strings[total_strings]) and (character not in equals):
            equals.append(character)
    total_strings-=1

print("".join(equals))