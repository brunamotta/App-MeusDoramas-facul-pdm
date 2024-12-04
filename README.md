# Introdução
Este trabalho foi inspirado na plataforma MyDramaList e no vício que a autora tem por doramas, trata-se de um aplicativo para smartphones com sistema android, em modo retrato, onde o usuário pode salvar uma lista de Doramas assistidos, incluindo o ano de lançamento, país de origem, número de episódios e uma nota para o mesmo. Doramas neste caso se refere às novelas e minisséries produzidas no leste asiático.

![Tela principal (activity_main.xml) com a Listagem e um botão para adicionar um novo registro.](https://github.com/user-attachments/assets/c4e063df-7611-4ee6-9f48-bef40750e4fe) ![Tela secundária (activity_cadastrar_dorama.xml) para adicionar um novo registro](https://github.com/user-attachments/assets/60447dc5-e7d2-4ff8-8df7-83cbb413170b) ![Tela secundária (activity_editar_dorama.xml) para editar ou excluir um registro já existente e selecionado a partir da listagem.](https://github.com/user-attachments/assets/c72ab2e7-d194-427a-b9fa-38ebcfc7fe58)




# Objetivo
O objetivo deste trabalho era desenvolver um aplicativo para persistência de dados, tratando a inclusão, alteração e exclusão de registros, além de tratar o acesso, abertura e fechamento do recurso do banco de dados SQLite, com o uso da arquitetura em três camadas.

# Tecnologia Utilizadas
O aplicativo foi desenvolvido através da IDE Android Studio utilizando a linguagem Java com o paradigma de orientação a objetos e o padrão de projeto MVC (model, view, controller), o banco de dados usado foi o SQLite.

# Utilização
O fluxo de uso é simples. O aplicativo abre na tela de listagem, o usuário clica no botão para adicionar um item, podendo salvar o novo item e retornar a tela com o item já adicionado ou cancelar e retornar a tela de listagem sem alterações. Após isso ele pode selecionar na lista qual item deseja editar,selecionado o item será aberta uma nova tela já com os dados preenchidos onde o usuário pode cancelar e voltar à tela de listagem, pode excluir aquele item e retornar à tela de listagem já sem o mesmo, ou pode salvar suas alterações retornando a tela de listagem já com as mesmas aplicadas 

# Referências
Application fundamentals. [S.d.]. Android Developers. Disponível em: https://developer.android.com/guide/components/fundamentals. Acesso em: 1 set. 2024.

DEITEL, P. J.; DEITEL, H. M.; WALD, A. Android 6 para programadores: uma abordagem baseada em aplicativos. Porto Alegre: Bookman, 2016.

DEITEL, P. J.; DEITEL, H. M.; DEITEL, A. Android: como programar. Porto Alegre: Bookman, 2015.

DO NASCIMENTO, C. A. S. A. Desenvolvimento de Aplicações Mobile e Distribuídas. rio de janeiro, UVA, 2019. Disponível em: https://ead.uva.br/disciplinas/grad/publica/cont/def/dmd/eb/DMD_ebook.pdf.

FELIPE, A. Curso Android com Kotlin: 2024. Alura. Disponível em: https://cursos.alura.com.br/course/fundamentos-android-kotlin. Acesso em: 30 ago. 2024.

MYDRAMALIST. Discover, discuss, and organize the best Asian dramas & movies for your entertainment - MyDramaList. [S.d.]. Mydramalist.com. Disponível em: https://mydramalist.com. Acesso em: 12 set. 2024.
