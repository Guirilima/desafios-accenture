# DESAFIO-ACCENTURE #01

## Utilizando tecnologias como JPA, MYSQL e MAVEN

[![Image](https://www.google.com/search?q=imagen+java&sxsrf=ALeKk01jdHjQM9nBLZ1_Irs9-IKH0H--uQ:1611708399421&source=lnms&tbm=isch&sa=X&ved=2ahUKEwid0IPV8bruAhWJD7kGHQJaD-0Q_AUoAXoECBQQAw&biw=958&bih=967#imgrc=2zT_F-n1TGaAsM "Imagem JAVA")]

## CONSTRUÇÂO DO PROJETO

- Modelagem
  - Conta
  - Lancamento
  - LancamentoTipo
  - PlanoConta
  - Usuario
- Repository
  - ContaRepository
  - LancamentoRepository
  - PlanoContaRepository
  - RepositoryI
  - UsuarioRepository
- Service
  - UsuarioService
- Utils
  - ConexaoFactory
  - TextoUtils
  
  
  ## Dependências Maven
  
  ```xml
  <dependencies>

		<!-- junit 5 -->
		<dependency>
			<groupId>org.junit.jupiter</groupId>
			<artifactId>junit-jupiter-engine</artifactId>
			<version>${junit-jupiter.version}</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>

		<!-- HIBERNATE -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.2.6.Final</version>
		</dependency>
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-entitymanager</artifactId>
			<version>5.2.6.Final</version>
		</dependency>

		<!-- BD HSGLDB - BANCO LOCAL JAVA -->
		<!-- https://mvnrepository.com/artifact/org.hsqldb/hsqldb -->
		<dependency>
			<groupId>org.hsqldb</groupId>
			<artifactId>hsqldb</artifactId>
			<version>2.4.0</version>
		</dependency>

		<!-- API, java.xml.bind module -->
		<dependency>
			<groupId>jakarta.xml.bind</groupId>
			<artifactId>jakarta.xml.bind-api</artifactId>
			<version>2.3.2</version>
		</dependency>

		<!-- Runtime, com.sun.xml.bind module -->
		<dependency>
			<groupId>org.glassfish.jaxb</groupId>
			<artifactId>jaxb-runtime</artifactId>
			<version>2.3.2</version>
		</dependency>

		<!-- DRIVER MYSQL -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.23</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/com.h2database/h2 -->
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<version>1.4.200</version>
			<scope>test</scope>
		</dependency>


	</dependencies>
  ```
  
  ### Conexao Factory
  ```java
  public class ConexaoFactory {
    private static EntityManager em;
    public static EntityManager getConexao() {
        if( em == null ) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("MY_PU");
            em = emf.createEntityManager();
        }
        return em;
    }
    ```
    
    
  ## Membros
  
  - Danilo Marcondes,
  - Guilherme Lima,
  - Igor Shimauti, 
  - Isaque Silva, 
  - Franklin Barreto
  
  
  
