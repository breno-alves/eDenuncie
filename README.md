# e-Denúncie API

## Endpoints

### Usuario resources
- <code>GET</code> usuarios/{id}
- <code>POST</code> usuarios

### Enderecos resources
- <code>GET</code> enderecos/{id}
- <code>POST</code> enderecos

### Denuncias resources
- <code>GET</code> denuncias/{id}
- <code>POST</code> denuncias

### Arquivos resources
- <code>GET</code> arquivos/{id}
- <code>POST</code> arquivos

### Anexos resources
- <code>GET</code> anexos/{id}
- <code>POST</code> anexos/

## Objects format

### Endereco
- **id** - ID do endereco
- **logradouro** - Logradouro do endereco
- **numero** - Numero do endereco
- **complemto** - Complemento do endereco
- **bairro** - Bairro do endereco
- **cidade** - Cidade do endereco
- **estado** - Estado do endereco
- **cep** - Cep do endereco

```
{
	"id": null,
	"logradouro": "Conjunto a",
	"numero": "505",
	"complemento": "",
	"bairro": "Nova Cidade",
	"cidade": "Natal",
	"estado": "Rio Grande do Norte",
	"cep": "59020101"
}
```

### Usuario

- **id** - ID do usuario
- **nome** - Nome do usuario
- **cpf** - Cpf do usuario
- **telefone** - Telefone do usuario
- **email** - Email do usuario
- **data** - Data de nascimento do usuario
- **endereco** - Objeto Endereco
- **denuncias** - Array de denuncias reportadas pelo usuario

```
{
	"id": null,
	"nome": "Joao da Silva",
	"cpf": "12309812387",
	"telefone": "849901234",
	"email": "joaodasilva@email.com",
	"data": "27/10/1990",
	"endereco": null,
	"denuncias": null
}
```

### Denuncia
- **id** - ID da denuncia
- **descricao** - Tipo de denuncia
- **data** - Data do ocorrido
- **endereco** - Objeto Endereco
- **usuario** - Objeto Usuario / Anonimo
- **arquivos** - Array de arquivos de anexo

```
{
	"id": null,
	"descricao": "Crime Virtual"
	"data": "10/02/2019",
	"endereco": null,
	"usuario": null,
	"arquivos": null
}
```

### Anexo
- **id_tipo** - ID do anexo
- **descricao** - Descricao do tipo de arquivo 

```
{
	"id": null,
	"descricao": "Imagem"
}
```

### Arquivo
- **id** - ID do arquivo
- **nome** - Nome do arquivo
- **url** - Path do arquivo
- **denuncia** - Objeto denuncia
- **anexo** - Objeto Anexo

```
{
	"id": null,
	"nome": "arquivoimg.jpg",
	"url": "/.../arquivoimg.jpg"
	"denuncia": null,
	"anexo": null
}
```

