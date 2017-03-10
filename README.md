# RestJobs
Cadastrar Jobs - Restfull

Ferramentas utilizadas:
Java, Spring, Hibernate, MySql, RestFull

Como rodar o projeto

Instalar MySql local para persistencia de dados e configurar o arquivo persistence.xml de acordo.

Serviços existentes:


POST em http://localhost:8080/RestJobs/api/addjobs Media Type application/json para 'adicionar' um job
exemplo de Json:
{
   "name":"job-name2",
   "msg":"mensagem de teste",
   "cron":"* * * *"
}


GET em http://localhost:8080/RestJobs/api/jobs para retornar todos os jobs que existem na base de dados


DELETE em http://localhost:8080/RestJobs/api/deljobs/aqui_nome_job_a_ser_deletado para remover da base de dados um job

