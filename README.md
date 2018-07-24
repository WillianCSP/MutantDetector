# MutantDetector

#### O projeto foi desenvolvido para detectar se um indivíduo é mutante ou apenas humano.

Para ser considerado mutante é necessário que no DNA haja 2 sequências ou mais de 4 letras iguais, 
nas direções horizontal, vertical, diagonal(Esq-Dir) e diagonal(Dir-Esq), na matriz do DNA.

O serviço está hospedado na "nuvem", utilizando servidores da AMAZON AWS:
- Servidor EC2(t2.micro)
- Banco de Dados RDS(db.t2.micro) (bdmutante1.co8fum1cec9s.us-east-1.rds.amazonaws.com)

Foram disponibilizados os seguintes endpoints, utilizando WebServices Jersey Rest:

**(GET /ping)** - Para teste de disponibilidade do servidor.
{http://18.208.223.84:8080/MutantDetector/mutantDetectorWS/ping}

**(POST /mutant)** - Para análise do DNA

O parâmetro deve ser um JSON contendo a sequência de Strings do DNA, como o exemplo abaixo:
{"dna": ["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]}

Segue URL completa da requisição utilizando o JSON de exemplo:

http://18.208.223.84:8080/MutantDetector/mutantDetectorWS/mutant={
  "dna": [
    "ATGCGA",
    "CAGTGC",
    "TTATGT",
    "AGAAGG",
    "CCCCTA",
    "TCACTG"
  ]
}

retorna HTTP 200 OK, caso seja detectado um mutante, HTTP 403 FORBIDDEN caso não seja detectado e HTTP 400 BAD REQUEST caso o formato não esteja de acordo
com o padrão especificado.

**(GET /stats)** - Implementação futura para restornar as estatísticas.

