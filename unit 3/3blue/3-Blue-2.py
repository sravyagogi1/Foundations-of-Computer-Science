def c_sub(text):
    
    accumulator = ''
    sc=''
    upper='ABCDEFGHIJKLMNOPQRSTUVWXYZ'  
    lower='abcdefghijklmnopqrstuvwxyz'
    while sc!="quit":
        print("Current string:",text)
        print("Letter frequencies:")
        for i in range(len(upper)):
            count = text.upper().count(upper[i])
            print(upper[i],count)
        print ("Remember, the most common letters in English are usually ETAOINSHRDLU in that order")
        sc= input("Type a pair of letters to swap, for example AB would swap A and B, or type 'quit':")
        if len(sc)==2:
            text=char_swap(text,sc[0], sc[1])
        accumulator+=sc
    
    
def char_swap(text, a,b):
    
    text=text.replace(a.lower(), 'X')
    text=text.replace(b.lower(), a.lower())
    text=text.replace('X',b.lower()) 

    text=text.replace(a.upper(), 'X')
    text=text.replace(b.upper(), a.upper())
    text=text.replace('X',b.upper())   
    return text

c_sub('Abc')#"Svtl tl q pbuqstkbug bqlg bjqxoub sz dlb sz nbxzilspqsb wpqwctir!")