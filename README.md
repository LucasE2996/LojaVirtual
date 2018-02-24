# LojaVirtual
--------------------------

**Regras de negocio:**

1. Listagem de products
2. Adição de products ao shoppingCart de compras (product e quantidade)
3. Visualização do shoppingCart de compras
4. Checkout:
- 4.1 Identificação do cliente
- 4.2. Forma de paymentOption
- 4.2.1. Se cartão, receber o número do cartão e quantidade de parcelas
- 4.2.2. Se billet, imprimir um número randômico, para simular o código de barras
- 4.3. Finalização da order

------------------

*@annotations*
- Compras devem ter status?
-- se sim, cada order deve ser criada, porém a entrega do product deve ser liberada apenas se o estatus da mesma for aprovada. (*Problema: não existe devilery na especificação* )
