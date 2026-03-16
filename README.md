After cloning this project, you must run the install program located under bin/[platform].

Prerequisites:
  - Git
  - Java
  - Maven
  - Docker



1. Create a new folder under which you want to develop your services.
2. Copy and edit the secrets.yaml in a folder, not covered by git.
3. Run load-secrets (-h for help), to load the secrets into the vault.
4. Be aware that the vault container is volatile and will forget secrets on restart.
5. Also, after any restart of the vault, it takes a while until it's ready

6. Add datasources under the config/artifacts/databases/[environment]
7. Add entities under the datamodel/entities

8. Create an OpenAPI contract for your service. Use the example provided as a start
9. Run create-project name contract. This will create all the necessary artifacts.
10. Edit the controllers under src/main/dtu/services/controllers 
