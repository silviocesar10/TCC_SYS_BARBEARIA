import psycopg2
from psycopg2 import Error
import requests

import psycopg2
from psycopg2 import Error
import requests


def countBarbearias() -> int:
    user = "postgres"
    passwd = None
    counter = 0
    connection = None
    cursor = None
    try:
        connection = psycopg2.connect(user=user,
                                      password=passwd,
                                      host="127.0.0.1",
                                      port="5432",
                                      database="sysbarbearia")
        cursor = connection.cursor()
        cursor.execute("SELECT COUNT(*) FROM BARBEARIA")
        counter = cursor.fetchone()[0]
    except (Exception, Error) as error:
        print("Error while connecting to PostgreSQL", error)
    finally:
        if cursor is not None:
            cursor.close()
        if connection is not None:
            connection.close()
            print("PostgreSQL connection is closed")
    return int(counter)


def countUsuarios() -> int:
    user = "postgres"
    passwd = None
    counter = 0
    connection = None
    cursor = None
    try:
            connection = psycopg2.connect(user=user,
                                        password=passwd,
                                        host="127.0.0.1",
                                        port="5432",
                                        database="sysbarbearia")
            cursor = connection.cursor()
            cursor.execute("SELECT COUNT(*) FROM CLIENTE")
            counter = cursor.fetchone()[0]
    except (Exception, Error) as error:
            print("Error while connecting to PostgreSQL", error)
    finally:
            if cursor is not None:
                cursor.close()
            if connection is not None:
                connection.close()
                print("PostgreSQL connection is closed")
    return int(counter)


def montarRequests():
    lista = []
    responses = []
    barbearias = int(countBarbearias())
    clientes = int(countUsuarios())

    i = 1
    j = 1
    while i <= clientes:
        while j <= barbearias:
            urlEmpresa = "&idEmpresa=" + str(j)
            j = j + 1
        url = "http://localhost:8080/recomendacao?idCliente=" + str(i)
        url = url + urlEmpresa
        lista.append(url)
        i = i + 1

    for item in lista:
        #resp = requests.get(item)
        #responses.append(resp)
        print(item)

    for x in responses:
        print(x)

if __name__ == '__main__':
    montarRequests()
