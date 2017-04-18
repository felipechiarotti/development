entrada = ""+input()
characters = {}

for character in entrada:
    if(character not in characters.keys()):
        characters[character] = 1
    else:
        characters[character]+=1

for character in characters:
    print("%s: %dx" % (character,characters[character]))