# DESAFIO-ACCENTURE #01

### Modelagem e implementação do backend de um sistema bancário simples utilizando tecnologias como JPA, MYSQL e MAVEN

![Image](http://s2.glbimg.com/ISAMH15-7x5uueooUfpwrNr_S5I=/s.glbimg.com/jo/g1/f/original/2011/08/22/22-java-300.jpg "Imagem JAVA")

## Configuração

Antes de rodar a aplicação verifique se o arquivo persistence.xml está configurado corretamente (caminho para o banco, e user/password corretos). Esse projeto utiliza um banco de dados Mysql pré-criado pelo usuário para funcionar corretamente.

## Construção do Projeto

### Modelagem
- **Conta:** classe abstrata que define o modelo de entidade Conta e seus atributos (usuario) e métodos (debitar, creditar, transferir)
    - **ContaCorrente:** implementação da classe Conta com os atributos que definem uma ContaCorrente (tipo, numero, saldo)
    - **ContaCredito:** implementação da classe Conta com os atributos que definem uma ContaCredito (numeroCartao, nomeImpresso, cvv, limite)
  - **Contatipo:** enum (CORRENTE, POUPANCA) utilizado por classes da aplicação
  - **EntidadeBase:** Classe abstrata herdada pelas classes de model do aplicação com atributo id
  - **Lancamento:**  define o modelo da entidade Lancamento e seus atributos (plano, planoConta, valor, descricao, dataHora, lancamentoTipo, contaDestino)
  - **LancamentoTipo:** enum (DESPESA, RECEITA, TRANSFERENCIA) utilizado por classes da aplicação
  - **PlanoConta:** define o modelo da entidade PlanoConta e seus atributos (usuario, descricao)
  - **Usuario:** define o modelo da entidade Usuario e seus atributos (login, senha, nome, cpf)
  
### Repository
  - **ContaRepository:** implementação dos métodos específicos de acesso e manipulação de entidades do tipo Conta
  - **LancamentoRepository:** implementação dos métodos específicos de acesso e manipulação de entidades do tipo Lancamento
  - **PlanoContaRepository:** implementação dos métodos específicos de acesso e manipulação de entidades do tipo PlanoConta
  - **RepositoryI:** declara a interface a ser implementada pelas classes do tipo Repository da aplicação (save, update, findAll, findById )
  - **RepositoryImpl:** implementação básica das funcionalidades das classes de repository da aplicação (save, update, findAll, findById )
  - **UsuarioRepository:** implementação dos métodos específicos de acesso e manipulação de entidades do tipo Usuario (exists, findByLogin)
  
### Service
  - **ContaService:** Serviços relativos ao ContaRepository utilizados pela aplicação (findById)
  - **LancamentoService:** Serviços relativos ao LancamentoRepository utilizados pela aplicação (salvaLancamento, extractByIdConta, extractByPeriodAndIdConta)
  - **PlanoContaService:** Serviços relativos ao PlanoContaRepository utilizados pela aplicação (salvaPlanoConta, findById)
  - **ServiceI:** Interface implementada pelas classes Service da aplicação
  - **ServiceImpl:** Implementação base dos serviços utilizados na aplicação (save, update, findById, findAll)
  - **UsuarioService:** Serviços relativos ao UsuarioRepository utilizados pela aplicação
  
### Utils
  - **ConexaoFactory:** Factory de criação do EntityManager utilizado na aplicação
  - **TextoUtils:** métodos auxiliares utilizado na validação de String
  
  
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

## Testes
  Testes para validar o funcionamento corretos dos métodos nas classes de repository e service foram criados e podem ser encontrados em `src/test/java/br.com.thundercoders`
    
    
  ## Membros
  
  - Danilo Marcondes,
  - Guilherme Lima,
  - Igor Shimauti, 
  - Isaque Silva, 
  - Franklin Barreto
  - Caio Assis Capasso
  
  
  
