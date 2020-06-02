
### Ativando a Ligação de dados

- `build.gradle`

`android {
...
    dataBinding {
       enabled true
    }
}`

### Usando expressões de layout para vincular componentes no arquivo de layout, você pode:

 - Melhorar o desempenho do seu aplicativo
 - Ajudar a evitar vazamentos de memória e exceções de ponteiro nulo
 - Simplificar o código da sua atividade removendo as chamadas da estrutura da interface do usuário