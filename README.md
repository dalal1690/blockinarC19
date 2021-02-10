# blockinarC19

Blockinar challenge development. 

# APIs

## Infected

### Register a new infected

**Method:** `POST`

**URL:** `<url>:<port>/infected/register`

**Headers:**
```
Accept: application/json
Content-Type: application/json
```

**Body:** 
```
{
  "first_name": "<first_name>",
  "last_name": "<last_name>",
  "country": "<country>",
  "live": "<live>",
  "age": "<age>",
  "infect_date": "<infect_date>",
  "gender": "<gender>"
}
```

**Responses:**
- Success: 201
- Failure: 400
```
{
    "error": "Usuario debe indicar el apellido del contagiado"
}
```
```
{
    "error": "Usuario debe indicar el nombre del contagiado"
}
```


### Get an infected

**Method:** `GET`

**URL:** `<url>:<port>/infected/{infected_id}`

**Responses:**
- Success: 200

- Failure: 404
```
{
    "error": "Infected does not exist in the database"
}
```

### Get Infected List
**Method:** `GET`

**URL:** `<url>:<port>/infected`

**Responses:**
- Success: 200

