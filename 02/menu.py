print("=== MENU PRINCIPAL ===")
print("1 - Incluir nome")
print("2 - Alterar nome")

opcao = input("Escolha uma opção: ")

if opcao == "1":
    import incluir
elif opcao == "2":
    import alterar
else:
    print("Opção inválida.")
