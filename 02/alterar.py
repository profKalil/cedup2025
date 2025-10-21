ARQUIVO = "nome.txt"

antigo = input("Digite o nome a alterar: ")
novo = input("Digite o novo nome: ")

# Lê todas as linhas
objeto = open(ARQUIVO, "r")
linhas = objeto.readlines()
objeto.close()

# Procura e substitui
alterado = False
for i in range(len(linhas)):
    if linhas[i].strip() == antigo:
        linhas[i] = novo + "\n"
        alterado = True
        break

# Regrava o arquivo
if alterado:
    objeto = open(ARQUIVO, "w")
    objeto.writelines(linhas)
    objeto.close()
    print(f"Nome '{antigo}' alterado para '{novo}'.")
else:
    print("Nome não encontrado.")
