# MarsObservatory
[![npm version](https://img.shields.io/npm/l/react)](https://github.com/MariaLuiza-CS/MarsObservatory/blob/master/LICENSE)

## Sobre o projeto

É um aplicativo de Visualização de imagens da sonda Curiosity em Marte. O projeto consome a [API da NASA](https://api.nasa.gov/) que exibe informações da sonda Curiosity (Mars Rover Photos).

Foi feito usando o padrão arquitetural MVP, componentes nativos do android e conceitos do Material Designer, além de contar com a utilização do ROOM Database e de bliotecas como o Retrofit e o Picassoa.

## O app conta com:

* Chamadas a API usando Retrofit
* Chamadas a imagens da API usando o Picasso
* Itens da API mostrados com o ReciclerView 
* Internacionalização (pt-br e en-us)
* Arquitetura MVP
* Design fluído com base nas orientações do Material Design do Google
* Warnings para a validação nos inputs do usuário
* Armazenamento do usuário utilizando o ROOM
* Persistência de dados usando SharedPreferences, com revogação ao clicar no botão "Sair"
* CheckBox para manter logado
* Layouts responsivos

## Layouts
<br>
  <p align="left">
            <img alt="Login layout screen capture"
            src="https://github.com/MariaLuiza-CS/MarsObservatory/blob/master/app/src/main/res/drawable/photo01.png" width="22%"
            title="adicionando task error campo vazio">
            <img alt="SingUp layout screen capture"
            src="https://github.com/MariaLuiza-CS/MarsObservatory/blob/master/app/src/main/res/drawable/photo02.png" width="22%"
            title="adicionando task error campo vazio">
            <img alt="Home layout first example screen capture"
            src="https://github.com/MariaLuiza-CS/MarsObservatory/blob/master/app/src/main/res/drawable/photo03.png" width="22%"
            title="adicionando task error campo vazio">
            <img alt="Login layout seconde example screen capture"
            src="https://github.com/MariaLuiza-CS/MarsObservatory/blob/master/app/src/main/res/drawable/photo04.png" width="22%"
            title="adicionando task error campo vazio">
            
## API

Esta API foi projetada para coletar dados de imagem coletados pelos rovers Curiosity, Opportunity e Spirit da NASA em Marte e torná-los mais facilmente disponíveis para outros desenvolvedores, educadores e cientistas cidadãos. Esta API é mantida por [Chris Cerami](https://github.com/chrisccerami/mars-photo-api) .

Junto com a consulta por data, os resultados também podem ser filtrados pela câmera com a qual foram tirados e as respostas serão limitadas a 25 fotos por chamada. As consultas que devem retornar mais de 25 fotos serão divididas em várias páginas, que podem ser acessadas adicionando um parâmetro 'página' à consulta.
 
As chamadas são feitas através de um Key. Todas as informações e documentação estão disponíveis no site da [NASA](https://api.nasa.gov/)

Exemplo de json disponível da API
```bash 
    {
        "photos": [
        {
            "id": 102685,
            "sol": 1004,
            "camera": {
            "id": 20,
            "name": "FHAZ",
            "rover_id": 5,
            "full_name": "Front Hazard Avoidance Camera"
        },
            "img_src": "http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01004/opgs/edr/fcam/FLB_486615455EDR_F0481570FHAZ00323M_.JPG",
            "earth_date": "2015-06-03",
            "rover": {
            "id": 5,
            "name": "Curiosity",
            "landing_date": "2012-08-06",
            "launch_date": "2011-11-26",
            "status": "active"
        }
        }
    }
```

## Autora
[![Author](https://img.shields.io/static/v1?label=@author&message=Maria%20Luíza&color=important)](https://github.com/MariaLuiza-CS)
[![LinkedIn](https://img.shields.io/static/v1?label=@linkedin&message=@marialuiza-0&color=blue)](https://www.linkedin.com/in/marialuiza-0/)
            
