nome = input("Seu nome: ") 
objeto = open("nome.txt", "r")  
encontrado = False

while True: 	
	linha = objeto.readline()
	if linha.strip() == nome:
		print("Bem-vindo de volta", nome)
		objeto.close()
		encontrado = True
		break
	else:
		if not linha:
			objeto.close()
			break
if not encontrado:
	objeto2 = open("nome.txt", "a")
	objeto2.write(nome + "\n")
	print("Ola,", nome)
	objeto2.close()
