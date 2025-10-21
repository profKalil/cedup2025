# menu.py
from incluir import incluir
from alterar import alterar

def menu():
    while True:
        print("\n=== MENU PRINCIPAL ===")
        print("1 - Incluir nome")
        print("2 - Alterar nome")
        print("0 - Sair")

        opcao = input("Escolha uma opção: ")

        if opcao == "1":
            incluir()
        elif opcao == "2":
            alterar()
        elif opcao == "0":
            print("Saindo do sistema...")
            break
        else:
            print("Opção inválida. Tente novamente.")

menu()
