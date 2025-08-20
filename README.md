# Employee CRUD Examples (Spring Boot)

Ce repository présente **3 manières différentes** d’implémenter un CRUD (Create, Read, Update, Delete) avec Spring Boot.

Il est organisé en 3 projets indépendants pour montrer l’évolution progressive de la simplicité avec les outils Spring.

---

## 📂 Structure du repository

- **Employee-CRUD-without-spring-data-jpa**  
  Implémentation manuelle du CRUD avec `EntityManager` et un `DAO` (Data Access Object).  
  → Montre la logique bas niveau (transactions, queries).

- **Employee-CRUD-with-spring-Data-jpa**  
  Utilisation de `JpaRepository` de Spring Data JPA pour simplifier l’accès aux données.  
  → Plus besoin de DAO manuel, les opérations CRUD sont générées automatiquement.

- **Employee-CRUD-with-spring-Data-Rest**  
  Utilisation de Spring Data REST pour exposer directement les repositories en endpoints REST.  
  → Pas besoin d’écrire de contrôleur REST.


## 🚀 Démarrage rapide

### 1. Cloner le repository
```bash
git clone https://github.com/Adnane-ved/spring-employee-crud.git
cd spring-employee-crud
```
### 2. Choisir un projet
```bash
cd Employee-CRUD-with-spring-Data-jpa
```
## Test :

### 1. Prérequis

Avant de commencer, assurez-vous d'avoir installé et configuré les éléments suivants :

- [MySQL](https://dev.mysql.com/downloads/) installé et en cours d'exécution
- MySQL workbench
- Java 17 ou version supérieure
- [Maven](https://maven.apache.org/download.cgi)

---

## 2. Configuration de la base de données

### Étape 1 : Importer le script SQL
Importez le fichier `employee-script.sql` dans votre MySQL Workbench (ou tout autre client MySQL), puis exécutez-le pour créer la base de données et les tables.

### Étape 2 : Configurer `application.properties`
Ouvrez le fichier `src/main/resources/application.properties` et ajoutez les informations de connexion à la base de données :

```properties
# Configuration de la datasource
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=root
spring.datasource.password=votre-mot-de-passe
```
### Étape 3. Démarrer 
```bash
mvn spring-boot:run
```

### Étape 4 : Tester les endpoints

Une fois l'application démarrée, vous pouvez tester les endpoints de l'API en utilisant un outil comme [Postman](https://www.postman.com/)  

Exemple :  (Un simple GET depuis le navigateur web )

#### Lister tous les employés
http://localhost:8080/api/employees

Assurez-vous que l'application Spring Boot est en cours d'exécution avant de tester les endpoints.

Pour plus de détails sur les endpoints, vous pouvez consulter les README des sous-projets correspondants



