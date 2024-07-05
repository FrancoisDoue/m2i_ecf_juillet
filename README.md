# Application de gestion de personnel - API Rest
## Comment l'installer

### Prérequis
- **JDK** et **Maven** installés.
- **Apache Tomcat** téléchargé et configuré.
### Étapes

1. **Importer le projet dans IntelliJ**
   - Ouvrez IntelliJ, sélectionnez "Import Project" et choisissez le fichier `pom.xml` pour importer le projet Maven.

2. **Configurer Tomcat dans IntelliJ**
   - Allez dans `Run > Edit Configurations`.
   - Ajoutez une nouvelle configuration `Tomcat Server > Local`.
   - Configurez le chemin d'installation de Tomcat et sélectionnez le module `votre-projet`.

2. **Déployer et lancer l'application**
   - Cliquez sur `Run` ou `Debug` dans IntelliJ.
   - Accédez à l'application via `http://localhost:8080/ecf_gestion_personnel_war_exploded`.

---

[Script SQL](ecf_gestion_personnel\_sql\save.sql)

## EndPoints
| URI                     | METHOD | corps de la requête                 | description                                                    |
|-------------------------|--------|-------------------------------------|----------------------------------------------------------------|
| /api/employees          | GET    | *aucun*                             | Affiche tous les employés                                      |
| /api/employees/search   | GET    | *aucun*                             | [filtres](#filter-employee) optionnels, partiels et cumulatifs |
| /api/employees          | POST   | [post employee](#post-employee)     | Ajouter un employé                                             |
| /api/employees/`{id}`   | GET    | *aucun*                             | Affiche employé                                                |
| /api/employees/`{id}`   | PUT    | [put employee](#put-employee)       | Modifier totalement un employé                                 |
| /api/employees/`{id}`   | PATCH  | [patch employee](#patch-employee)   | Modifier partiellement un employé                              |
| /api/employees/`{id}`   | DELETE | *aucun*                             | Supprimer un employé                                           |
| /api/departments        | GET    | *aucun*                             | Affiche tous les départments                                   |
| /api/departments        | POST   | [post department](#post-department) | Ajoute un département                                          |
| /api/departments/`{id}` | GET    | *aucun*                             | Afficher un département                                        |
| /api/departments/`{id}` | PUT    | [put department](#put-department)   | Ajoute un département                                          |
| /api/departments/`{id}` | DELETE | *aucun*                             | supprimer un département                                       |
| /api/positions          | GET    | *aucun*                             | Affiche tous postes                                            |
| /api/positions          | POST   | [post department](#post-position)   | Ajouter un poste                                               |
| /api/positions          | PUT    | [post department](#put-position)    | Modifier un poste                                              |
| /api/positions/`{id}`   | GET    | *aucun*                             | Afficher un poste                                              |
| /api/positions/`{id}`   | DELETE | *aucun*                             | supprimer un poste                                             |


### <a id="filter-employee"></a>GET : Filtrer les employés
Paramètres :
```text
firstname=partial_firstname
lastname=partial_lastname
position=partial_job
department=partial_department
```

### <a id="post-employee"></a>POST : Nouvel employé
uri: `/api/employees`
```json
{
  "firstname": "Prénom de l'employé",
  "lastname": "Nom de l'employé",
  "email": "mail.employe@mail.com",
  "phone": "0101010101", // optionnel
  "department": { 
    "id" : 1 // optionnel
  },
  "position": { // optionnel
    "id" : 2
  }
}
```
---
### <a id="put-employee"></a>PUT : Modifier employé
uri: `/api/employees/{id_employee}`  
**L'absence de l'un des champs entrainera l'effacement de sa valeur.**
```json
{
  "firstname": "Prénom de l'employé",
  "lastname": "Nom de l'employé",
  "email": "mail.employe@mail.com",
  "phone": "0101010101",
  "department": {
    "id" : 1
  },
  "position": {
    "id" : 2
  }
}
```
---
### <a id="patch-employee"></a> PATCH : Modifier employé
uri: `/api/employees/{id_employee}`  
**L'intégralité des champs sont optionnels**
```json
{
  "firstname": "Prénom de l'employé",
  "lastname": "Nom de l'employé",
  "email": "mail.employe@mail.com",
  "phone": "0101010101",
  "department": {
    "id" : 1 
  },
  "position": { 
    "id" : 2
  }
}
```
---
### <a id="put-department"></a> POST : Nouveau département
uri: `/api/departments`

```json
{
  "name": "Nom du département"
}
```
---
### <a id="post-department"></a> PUT : Modifier département
uri: `/api/departments/{id_department}`
```json
{
  "name": "Nom du département"
}
```
---
### <a id="post-position"></a> POST : Nouveau poste
uri: `/api/positions`

```json
{
  "jobTitle": "Nom du poste"
}
```
---
### <a id="put-position"></a> PUT : Modifier un poste
uri: `/api/positions`

```json
{
  "jobTitle": "Nom du poste"
}
```
---
# Application de recrutement avec Spring et Thymeleaf
...