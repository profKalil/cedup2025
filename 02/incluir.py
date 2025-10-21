ARQUIVO = "nome.txt"

nome = input("Digite o nome a incluir: ")
objeto = open(ARQUIVO, "r")
encontrado = False

while True:
    linha = objeto.readline()
    if linha.strip() == nome:
        print("Nome já existe.")
        objeto.close()
        encontrado = True
        break
    else:
        if not linha:
            objeto.close()
            break

if not encontrado:
    objeto2 = open(ARQUIVO, "a")
    objeto2.write(nome + "\n")
    print(f"Nome '{nome}' incluído com sucesso!")
    objeto2.close()
