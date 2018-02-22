# LojaVirtual
--------------------------

**Regras de negocio:**

1. Listagem de produtos
2. Adição de produtos ao carrinho de compras (produto e quantidade)
3. Visualização do carrinho de compras
4. Checkout:
- 4.1 Identificação do cliente
- 4.2. Forma de pagamento
- 4.2.1. Se cartão, receber o número do cartão e quantidade de parcelas
- 4.2.2. Se boleto, imprimir um número randômico, para simular o código de barras
- 4.3. Finalização da compra

------------------

*@annotations*
- Compras devem ter status?
-- se sim, cada compra deve ser criada, porém a entrega do produto deve ser liberada apenas se o estatus da mesma for aprovada. (*Problema: não existe devilery na especificação* )
