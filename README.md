[![NPM](https://img.shields.io/npm/l/react)](https://github.com/ewertondrigues02/web-services-com-springboot-jpa-hibernate/blob/master/LICENSE)
# Back end 

   * Java.
   * Spring Boot.
   * JPA / Hibernate.
   * Maven.

     
 

Diagrama de modelo de domínio para um sistema de software. Ele representa várias entidades e seus relacionamentos. Aqui estão os principais pontos:
![Captura de tela 2024-05-10 074455](https://github.com/ewertondrigues02/web-services-com-springboot-jpa-hibernate/assets/106437473/d02c7484-1852-40fb-9469-bee7d76bb6c9)

### Entidades:
 * Produto: Possui atributos como id (inteiro), nome (string), descrição (string), preço (double), imageUrl (string) e categorias.
 * Categoria: Relacionada a produtos por meio de uma relação muitos-para-muitos.
 * Item de Pedido: Relacionado a produtos e pedidos por meio de relações muitos-para-um.
 * Pedido: Relacionado a itens de pedido e usuários.
 * Usuário: Não há detalhes específicos sobre os atributos do usuário.
 * Pagamento: Relacionado ao pedido e possui um atributo de status (enumeração).
### Relacionamentos:
 * Produto-Categoria: Muitos-para-muitos.
 * Item de Pedido-Produto: Muitos-para-um.
 * Item de Pedido-Pedido: Muitos-para-um.
   
Esse diagrama é relevante para entender como os componentes de um sistema de e-commerce podem ser estruturados em termos de gerenciamento de dados e fluxo. Ele também mostra como o processamento de pedidos pode ser tratado por meio de status. 

---
### Domain Instance

![Captura de tela 2024-05-10 075820](https://github.com/ewertondrigues02/web-services-com-springboot-jpa-hibernate/assets/106437473/f1e4cfa5-4c6c-45f5-bf2d-d18f33fcf9e3)



