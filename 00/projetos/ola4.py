nome = input("Seu nome: ") 
objeto = open("nomes.txt", "r")  
while True: 	
	if objeto.readline().strip() == nome:
		print("Bem-vindo de volta", nome)
		objeto.close()
		break
	else:
		obj2 = open("nomes.txt", "a").write(nome + "\n")
		print("Ola, ", nome)
		obj2.close()
		break