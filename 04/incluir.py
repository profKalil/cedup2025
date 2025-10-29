from conexao import conectar

nome = input("Nome para incluir : ")

con = conectar()
cursor = con.cursor()

cursor.execute("SELECT * FROM nomes WHERE nome = %s", (nome,))
resultado = cursor.fetchone()

if resultado:
    print("Nome já existe")
else:
    cursor.execute("INSERT INTO nomes (nome) VALUES (%s)", (nome,))
    con.commit()
    print("Nome inserido com sucesso!")
    
cursor.close()
con.close( )