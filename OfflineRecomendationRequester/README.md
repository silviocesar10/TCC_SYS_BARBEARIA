# OfflineRecomendationRequeste

nesta pasta esta contido um script requester.py na sua versão inicial cujo o
objetivo é que seja rodado (no mesmo local onde a api estara hospedada) todos 
os dias ao menos uma ves para se conectar no banco verificar quantos usuarios
existem e quantas barbearias cadastradas ha, para que dessa forma possa montar
urls de requisição para requisitar recomedações a api e caso haja, o sistema ira
automaticamente guarda-las no banco de dados (isso é feito pela api assim que uma
solicitação de recomedação é requisitada) para uso futuro no sistema e atender ao 
modelo de recomendação offline na qual se trata justamente de se ter recomendações
disponiveis previamente calculadas.

ha tambem disponivel nesse diretorio um scritp crontab para fazer a execução do scrpt python
vale lembrar que todos estão em sua versão inicial