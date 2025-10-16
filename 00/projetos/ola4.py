nome = input("Seu nome: ") 
objeto = open("nome.txt", "r")  
while True: 	
	if objeto.readline().strip() == nome:
		print("Bem-vindo de volta", nome)
		objeto.close()
		break
	else:
		obj2 = open("nome.txt", "a").write(nome + "\n")
		print("Ola, ", nome)
		obj2.close()

		break
